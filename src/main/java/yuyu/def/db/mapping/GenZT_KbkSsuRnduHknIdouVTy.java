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
import yuyu.def.db.entity.ZT_KbkSsuRnduHknIdouVTy;
import yuyu.def.db.id.PKZT_KbkSsuRnduHknIdouVTy;
import yuyu.def.db.meta.GenQZT_KbkSsuRnduHknIdouVTy;
import yuyu.def.db.meta.QZT_KbkSsuRnduHknIdouVTy;

/**
 * 株価指数連動保険異動ＶＦテーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_KbkSsuRnduHknIdouVTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KbkSsuRnduHknIdouVTy}</td><td colspan="3">株価指数連動保険異動ＶＦテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtysequenceno ztysequenceno}</td><td>（中継用）シーケンス番号</td><td align="center">{@link PKZT_KbkSsuRnduHknIdouVTy ○}</td><td align="center">N</td><td>Integer</td></tr>
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
 *  <tr><td>{@link #getZtysuuriyouyobin2x3 ztysuuriyouyobin2x3}</td><td>（中継用）数理用予備項目Ｎ２＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin10x11 ztysuuriyouyobin10x11}</td><td>（中継用）数理用予備項目Ｎ１０＿１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytmttknzoukaritujygn ztytmttknzoukaritujygn}</td><td>（中継用）積立金増加率上限</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtysetteibairitu ztysetteibairitu}</td><td>（中継用）設定倍率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtytykzenoutouymdsisuu ztytykzenoutouymdsisuu}</td><td>（中継用）直前応当日指数</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtykimatusisuu ztykimatusisuu}</td><td>（中継用）期末指数</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyyobiv3 ztyyobiv3}</td><td>（中継用）予備項目Ｖ３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
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
 *  <tr><td>{@link #getZtyvkimatutirttumitatekin ztyvkimatutirttumitatekin}</td><td>（中継用）Ｖ用期末定率部分積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykimatusisuutumitatekin ztykimatusisuutumitatekin}</td><td>（中継用）期末指数部分積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyvyoutykzenoutouymdsisuu ztyvyoutykzenoutouymdsisuu}</td><td>（中継用）Ｖ用直前応当日指数</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtytykzensisuukijyunymd ztytykzensisuukijyunymd}</td><td>（中継用）直前指数基準年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyvyoukimatusisuu ztyvyoukimatusisuu}</td><td>（中継用）Ｖ用期末指数</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtykmtsisuukijyunymd ztykmtsisuukijyunymd}</td><td>（中継用）期末指数基準年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyvyoutmttknzoukaritujygn ztyvyoutmttknzoukaritujygn}</td><td>（中継用）Ｖ用積立金増加率上限</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyvyousetteibairitu ztyvyousetteibairitu}</td><td>（中継用）Ｖ用設定倍率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyvyourendouritu ztyvyourendouritu}</td><td>（中継用）Ｖ用連動率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin3x2 ztysuuriyouyobin3x2}</td><td>（中継用）数理用予備項目Ｎ３＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv8x2 ztyyobiv8x2}</td><td>（中継用）予備項目Ｖ８＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykimatusisuutyokugotmttkn ztykimatusisuutyokugotmttkn}</td><td>（中継用）期末指数部分直後積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x19 ztyyobin11x19}</td><td>（中継用）予備項目Ｎ１１＿１９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x20 ztyyobin11x20}</td><td>（中継用）予備項目Ｎ１１＿２０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyjmttirttumitatekinnplus0 ztyjmttirttumitatekinnplus0}</td><td>（中継用）事末定率部分積立金（Ｎ＋０）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyjmttirttumitatekinnplus1 ztyjmttirttumitatekinnplus1}</td><td>（中継用）事末定率部分積立金（Ｎ＋１）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyjmttirttumitatekinnplus2 ztyjmttirttumitatekinnplus2}</td><td>（中継用）事末定率部分積立金（Ｎ＋２）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyjmtssutumitatekinnplus0 ztyjmtssutumitatekinnplus0}</td><td>（中継用）事末指数部分積立金（Ｎ＋０）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyjmtssutumitatekinnplus1 ztyjmtssutumitatekinnplus1}</td><td>（中継用）事末指数部分積立金（Ｎ＋１）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyjmtssutumitatekinnplus2 ztyjmtssutumitatekinnplus2}</td><td>（中継用）事末指数部分積立金（Ｎ＋２）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyjmtmvatyouseigownplus0 ztyjmtmvatyouseigownplus0}</td><td>（中継用）事末ＭＶＡ調整後Ｗ（Ｎ＋０）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyjmtmvakeisanjiwnplus0 ztyjmtmvakeisanjiwnplus0}</td><td>（中継用）事末ＭＶＡ計算時Ｖ（Ｎ＋０）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyjmtmvatyouseigownplus1 ztyjmtmvatyouseigownplus1}</td><td>（中継用）事末ＭＶＡ調整後Ｗ（Ｎ＋１）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyjmtmvakeisanjiwnplus1 ztyjmtmvakeisanjiwnplus1}</td><td>（中継用）事末ＭＶＡ計算時Ｖ（Ｎ＋１）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyjmtmvatyouseigownplus2 ztyjmtmvatyouseigownplus2}</td><td>（中継用）事末ＭＶＡ調整後Ｗ（Ｎ＋２）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyjmtmvakeisanjiwnplus2 ztyjmtmvakeisanjiwnplus2}</td><td>（中継用）事末ＭＶＡ計算時Ｖ（Ｎ＋２）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x21 ztyyobin11x21}</td><td>（中継用）予備項目Ｎ１１＿２１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x22 ztyyobin11x22}</td><td>（中継用）予備項目Ｎ１１＿２２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x23 ztyyobin11x23}</td><td>（中継用）予備項目Ｎ１１＿２３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x4 ztyyobin11x4}</td><td>（中継用）予備項目Ｎ１１＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x25 ztyyobin11x25}</td><td>（中継用）予備項目Ｎ１１＿２５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x26 ztyyobin11x26}</td><td>（中継用）予備項目Ｎ１１＿２６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin15 ztysuuriyouyobin15}</td><td>（中継用）数理用予備項目Ｎ１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin15x2 ztysuuriyouyobin15x2}</td><td>（中継用）数理用予備項目Ｎ１５＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv15 ztyyobiv15}</td><td>（中継用）予備項目Ｖ１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv20 ztyyobiv20}</td><td>（中継用）予備項目Ｖ２０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_KbkSsuRnduHknIdouVTy
 * @see     PKZT_KbkSsuRnduHknIdouVTy
 * @see     QZT_KbkSsuRnduHknIdouVTy
 * @see     GenQZT_KbkSsuRnduHknIdouVTy
 */
@MappedSuperclass
@Table(name=GenZT_KbkSsuRnduHknIdouVTy.TABLE_NAME)
@IdClass(value=PKZT_KbkSsuRnduHknIdouVTy.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_KbkSsuRnduHknIdouVTy extends AbstractExDBEntity<ZT_KbkSsuRnduHknIdouVTy, PKZT_KbkSsuRnduHknIdouVTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_KbkSsuRnduHknIdouVTy";
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
    public static final String ZTYSUURIYOUYOBIN2X3      = "ztysuuriyouyobin2x3";
    public static final String ZTYSUURIYOUYOBIN10X11    = "ztysuuriyouyobin10x11";
    public static final String ZTYTMTTKNZOUKARITUJYGN   = "ztytmttknzoukaritujygn";
    public static final String ZTYSETTEIBAIRITU         = "ztysetteibairitu";
    public static final String ZTYTYKZENOUTOUYMDSISUU   = "ztytykzenoutouymdsisuu";
    public static final String ZTYKIMATUSISUU           = "ztykimatusisuu";
    public static final String ZTYYOBIV3                = "ztyyobiv3";
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
    public static final String ZTYVKIMATUTIRTTUMITATEKIN = "ztyvkimatutirttumitatekin";
    public static final String ZTYKIMATUSISUUTUMITATEKIN = "ztykimatusisuutumitatekin";
    public static final String ZTYVYOUTYKZENOUTOUYMDSISUU = "ztyvyoutykzenoutouymdsisuu";
    public static final String ZTYTYKZENSISUUKIJYUNYMD  = "ztytykzensisuukijyunymd";
    public static final String ZTYVYOUKIMATUSISUU       = "ztyvyoukimatusisuu";
    public static final String ZTYKMTSISUUKIJYUNYMD     = "ztykmtsisuukijyunymd";
    public static final String ZTYVYOUTMTTKNZOUKARITUJYGN = "ztyvyoutmttknzoukaritujygn";
    public static final String ZTYVYOUSETTEIBAIRITU     = "ztyvyousetteibairitu";
    public static final String ZTYVYOURENDOURITU        = "ztyvyourendouritu";
    public static final String ZTYSUURIYOUYOBIN3X2      = "ztysuuriyouyobin3x2";
    public static final String ZTYYOBIV8X2              = "ztyyobiv8x2";
    public static final String ZTYKIMATUSISUUTYOKUGOTMTTKN = "ztykimatusisuutyokugotmttkn";
    public static final String ZTYYOBIN11X19            = "ztyyobin11x19";
    public static final String ZTYYOBIN11X20            = "ztyyobin11x20";
    public static final String ZTYJMTTIRTTUMITATEKINNPLUS0 = "ztyjmttirttumitatekinnplus0";
    public static final String ZTYJMTTIRTTUMITATEKINNPLUS1 = "ztyjmttirttumitatekinnplus1";
    public static final String ZTYJMTTIRTTUMITATEKINNPLUS2 = "ztyjmttirttumitatekinnplus2";
    public static final String ZTYJMTSSUTUMITATEKINNPLUS0 = "ztyjmtssutumitatekinnplus0";
    public static final String ZTYJMTSSUTUMITATEKINNPLUS1 = "ztyjmtssutumitatekinnplus1";
    public static final String ZTYJMTSSUTUMITATEKINNPLUS2 = "ztyjmtssutumitatekinnplus2";
    public static final String ZTYJMTMVATYOUSEIGOWNPLUS0 = "ztyjmtmvatyouseigownplus0";
    public static final String ZTYJMTMVAKEISANJIWNPLUS0 = "ztyjmtmvakeisanjiwnplus0";
    public static final String ZTYJMTMVATYOUSEIGOWNPLUS1 = "ztyjmtmvatyouseigownplus1";
    public static final String ZTYJMTMVAKEISANJIWNPLUS1 = "ztyjmtmvakeisanjiwnplus1";
    public static final String ZTYJMTMVATYOUSEIGOWNPLUS2 = "ztyjmtmvatyouseigownplus2";
    public static final String ZTYJMTMVAKEISANJIWNPLUS2 = "ztyjmtmvakeisanjiwnplus2";
    public static final String ZTYYOBIN11X21            = "ztyyobin11x21";
    public static final String ZTYYOBIN11X22            = "ztyyobin11x22";
    public static final String ZTYYOBIN11X23            = "ztyyobin11x23";
    public static final String ZTYYOBIN11X4             = "ztyyobin11x4";
    public static final String ZTYYOBIN11X25            = "ztyyobin11x25";
    public static final String ZTYYOBIN11X26            = "ztyyobin11x26";
    public static final String ZTYSUURIYOUYOBIN15       = "ztysuuriyouyobin15";
    public static final String ZTYSUURIYOUYOBIN15X2     = "ztysuuriyouyobin15x2";
    public static final String ZTYYOBIV15               = "ztyyobiv15";
    public static final String ZTYYOBIV20               = "ztyyobiv20";

    private final PKZT_KbkSsuRnduHknIdouVTy primaryKey;

    public GenZT_KbkSsuRnduHknIdouVTy() {
        primaryKey = new PKZT_KbkSsuRnduHknIdouVTy();
    }

    public GenZT_KbkSsuRnduHknIdouVTy(Integer pZtysequenceno) {
        primaryKey = new PKZT_KbkSsuRnduHknIdouVTy(pZtysequenceno);
    }

    @Transient
    @Override
    public PKZT_KbkSsuRnduHknIdouVTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_KbkSsuRnduHknIdouVTy> getMetaClass() {
        return QZT_KbkSsuRnduHknIdouVTy.class;
    }

    @Id
    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSEQUENCENO)
    public Integer getZtysequenceno() {
        return getPrimaryKey().getZtysequenceno();
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtysequenceno(Integer pZtysequenceno) {
        getPrimaryKey().setZtysequenceno(pZtysequenceno);
    }

    private Integer ztyyuukourecordlength;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYYUUKOURECORDLENGTH)
    public Integer getZtyyuukourecordlength() {
        return ztyyuukourecordlength;
    }

    public void setZtyyuukourecordlength(Integer pZtyyuukourecordlength) {
        ztyyuukourecordlength = pZtyyuukourecordlength;
    }

    private String ztyrdwarea;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYRDWAREA)
    public String getZtyrdwarea() {
        return ztyrdwarea;
    }

    public void setZtyrdwarea(String pZtyrdwarea) {
        ztyrdwarea = pZtyrdwarea;
    }

    private String ztyrecordkbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYRECORDKBN)
    public String getZtyrecordkbn() {
        return ztyrecordkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtyrecordkbn(String pZtyrecordkbn) {
        ztyrecordkbn = pZtyrecordkbn;
    }

    private String ztynenkinkaisigohyouji;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYNENKINKAISIGOHYOUJI)
    public String getZtynenkinkaisigohyouji() {
        return ztynenkinkaisigohyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtynenkinkaisigohyouji(String pZtynenkinkaisigohyouji) {
        ztynenkinkaisigohyouji = pZtynenkinkaisigohyouji;
    }

    private String ztynksgokurikosidhyj;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYNKSGOKURIKOSIDHYJ)
    public String getZtynksgokurikosidhyj() {
        return ztynksgokurikosidhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtynksgokurikosidhyj(String pZtynksgokurikosidhyj) {
        ztynksgokurikosidhyj = pZtynksgokurikosidhyj;
    }

    private String ztykeijyouym;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYKEIJYOUYM)
    public String getZtykeijyouym() {
        return ztykeijyouym;
    }

    public void setZtykeijyouym(String pZtykeijyouym) {
        ztykeijyouym = pZtykeijyouym;
    }

    private String ztyidojiyukbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYIDOJIYUKBN)
    public String getZtyidojiyukbn() {
        return ztyidojiyukbn;
    }

    public void setZtyidojiyukbn(String pZtyidojiyukbn) {
        ztyidojiyukbn = pZtyidojiyukbn;
    }

    private String ztyzougenkbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYZOUGENKBN)
    public String getZtyzougenkbn() {
        return ztyzougenkbn;
    }

    public void setZtyzougenkbn(String pZtyzougenkbn) {
        ztyzougenkbn = pZtyzougenkbn;
    }

    private String ztyidourecordkbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYIDOURECORDKBN)
    public String getZtyidourecordkbn() {
        return ztyidourecordkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtyidourecordkbn(String pZtyidourecordkbn) {
        ztyidourecordkbn = pZtyidourecordkbn;
    }

    private String ztykeijyouctrlkbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYKEIJYOUCTRLKBN)
    public String getZtykeijyouctrlkbn() {
        return ztykeijyouctrlkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtykeijyouctrlkbn(String pZtykeijyouctrlkbn) {
        ztykeijyouctrlkbn = pZtykeijyouctrlkbn;
    }

    private String ztyhenkousyoriymd;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYHENKOUSYORIYMD)
    public String getZtyhenkousyoriymd() {
        return ztyhenkousyoriymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtyhenkousyoriymd(String pZtyhenkousyoriymd) {
        ztyhenkousyoriymd = pZtyhenkousyoriymd;
    }

    private Integer ztykykmfksnctr;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYKYKMFKSNCTR)
    public Integer getZtykykmfksnctr() {
        return ztykykmfksnctr;
    }

    public void setZtykykmfksnctr(Integer pZtykykmfksnctr) {
        ztykykmfksnctr = pZtykykmfksnctr;
    }

    private Integer ztyrecordctr;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYRECORDCTR)
    public Integer getZtyrecordctr() {
        return ztyrecordctr;
    }

    public void setZtyrecordctr(Integer pZtyrecordctr) {
        ztyrecordctr = pZtyrecordctr;
    }

    private String ztysuuriyoukouryokukaisiymd;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSUURIYOUKOURYOKUKAISIYMD)
    public String getZtysuuriyoukouryokukaisiymd() {
        return ztysuuriyoukouryokukaisiymd;
    }

    public void setZtysuuriyoukouryokukaisiymd(String pZtysuuriyoukouryokukaisiymd) {
        ztysuuriyoukouryokukaisiymd = pZtysuuriyoukouryokukaisiymd;
    }

    private String ztydenymd;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYDENYMD)
    public String getZtydenymd() {
        return ztydenymd;
    }

    public void setZtydenymd(String pZtydenymd) {
        ztydenymd = pZtydenymd;
    }

    private String ztybluekeizokuhyouji;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYBLUEKEIZOKUHYOUJI)
    public String getZtybluekeizokuhyouji() {
        return ztybluekeizokuhyouji;
    }

    public void setZtybluekeizokuhyouji(String pZtybluekeizokuhyouji) {
        ztybluekeizokuhyouji = pZtybluekeizokuhyouji;
    }

    private String ztysuuriyouyobin1x2;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSUURIYOUYOBIN1X2)
    public String getZtysuuriyouyobin1x2() {
        return ztysuuriyouyobin1x2;
    }

    public void setZtysuuriyouyobin1x2(String pZtysuuriyouyobin1x2) {
        ztysuuriyouyobin1x2 = pZtysuuriyouyobin1x2;
    }

    private String ztytoukeikeijyoukbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYTOUKEIKEIJYOUKBN)
    public String getZtytoukeikeijyoukbn() {
        return ztytoukeikeijyoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtytoukeikeijyoukbn(String pZtytoukeikeijyoukbn) {
        ztytoukeikeijyoukbn = pZtytoukeikeijyoukbn;
    }

    private String ztyraysystemhyj;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYRAYSYSTEMHYJ)
    public String getZtyraysystemhyj() {
        return ztyraysystemhyj;
    }

    public void setZtyraysystemhyj(String pZtyraysystemhyj) {
        ztyraysystemhyj = pZtyraysystemhyj;
    }

    private String ztyzenkiidouteiseikbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYZENKIIDOUTEISEIKBN)
    public String getZtyzenkiidouteiseikbn() {
        return ztyzenkiidouteiseikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtyzenkiidouteiseikbn(String pZtyzenkiidouteiseikbn) {
        ztyzenkiidouteiseikbn = pZtyzenkiidouteiseikbn;
    }

    private String ztybsyym;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYBSYYM)
    public String getZtybsyym() {
        return ztybsyym;
    }

    public void setZtybsyym(String pZtybsyym) {
        ztybsyym = pZtybsyym;
    }

    private String ztytenkangokeiyakubosyuuym;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYTENKANGOKEIYAKUBOSYUUYM)
    public String getZtytenkangokeiyakubosyuuym() {
        return ztytenkangokeiyakubosyuuym;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZtytenkangokeiyakubosyuuym(String pZtytenkangokeiyakubosyuuym) {
        ztytenkangokeiyakubosyuuym = pZtytenkangokeiyakubosyuuym;
    }

    private String ztyidoujiyuucd;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYIDOUJIYUUCD)
    public String getZtyidoujiyuucd() {
        return ztyidoujiyuucd;
    }

    public void setZtyidoujiyuucd(String pZtyidoujiyuucd) {
        ztyidoujiyuucd = pZtyidoujiyuucd;
    }

    private String ztysyoricd;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSYORICD)
    public String getZtysyoricd() {
        return ztysyoricd;
    }

    public void setZtysyoricd(String pZtysyoricd) {
        ztysyoricd = pZtysyoricd;
    }

    private String ztysekininteiseihyouji;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSEKININTEISEIHYOUJI)
    public String getZtysekininteiseihyouji() {
        return ztysekininteiseihyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtysekininteiseihyouji(String pZtysekininteiseihyouji) {
        ztysekininteiseihyouji = pZtysekininteiseihyouji;
    }

    private String ztysuuriyouyobin8;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSUURIYOUYOBIN8)
    public String getZtysuuriyouyobin8() {
        return ztysuuriyouyobin8;
    }

    public void setZtysuuriyouyobin8(String pZtysuuriyouyobin8) {
        ztysuuriyouyobin8 = pZtysuuriyouyobin8;
    }

    private String ztysihankibikinkbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSIHANKIBIKINKBN)
    public String getZtysihankibikinkbn() {
        return ztysihankibikinkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtysihankibikinkbn(String pZtysihankibikinkbn) {
        ztysihankibikinkbn = pZtysihankibikinkbn;
    }

    private String ztysuuriyouyobin1x3;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSUURIYOUYOBIN1X3)
    public String getZtysuuriyouyobin1x3() {
        return ztysuuriyouyobin1x3;
    }

    public void setZtysuuriyouyobin1x3(String pZtysuuriyouyobin1x3) {
        ztysuuriyouyobin1x3 = pZtysuuriyouyobin1x3;
    }

    private String ztydatakanrino;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYDATAKANRINO)
    public String getZtydatakanrino() {
        return ztydatakanrino;
    }

    public void setZtydatakanrino(String pZtydatakanrino) {
        ztydatakanrino = pZtydatakanrino;
    }

    private String ztyhknsyukigou;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYHKNSYUKIGOU)
    public String getZtyhknsyukigou() {
        return ztyhknsyukigou;
    }

    public void setZtyhknsyukigou(String pZtyhknsyukigou) {
        ztyhknsyukigou = pZtyhknsyukigou;
    }

    private String ztyhknsyuruikigousedaikbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYHKNSYURUIKIGOUSEDAIKBN)
    public String getZtyhknsyuruikigousedaikbn() {
        return ztyhknsyuruikigousedaikbn;
    }

    public void setZtyhknsyuruikigousedaikbn(String pZtyhknsyuruikigousedaikbn) {
        ztyhknsyuruikigousedaikbn = pZtyhknsyuruikigousedaikbn;
    }

    private String ztysotodasipmenkbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSOTODASIPMENKBN)
    public String getZtysotodasipmenkbn() {
        return ztysotodasipmenkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtysotodasipmenkbn(String pZtysotodasipmenkbn) {
        ztysotodasipmenkbn = pZtysotodasipmenkbn;
    }

    private String ztystdssytikbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSTDSSYTIKBN)
    public String getZtystdssytikbn() {
        return ztystdssytikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtystdssytikbn(String pZtystdssytikbn) {
        ztystdssytikbn = pZtystdssytikbn;
    }

    private String ztystdssnskbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSTDSSNSKBN)
    public String getZtystdssnskbn() {
        return ztystdssnskbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtystdssnskbn(String pZtystdssnskbn) {
        ztystdssnskbn = pZtystdssnskbn;
    }

    private String ztysotodasimanagehyouji;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSOTODASIMANAGEHYOUJI)
    public String getZtysotodasimanagehyouji() {
        return ztysotodasimanagehyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtysotodasimanagehyouji(String pZtysotodasimanagehyouji) {
        ztysotodasimanagehyouji = pZtysotodasimanagehyouji;
    }

    private String ztysotodasiphkbnmnoshyouji;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSOTODASIPHKBNMNOSHYOUJI)
    public String getZtysotodasiphkbnmnoshyouji() {
        return ztysotodasiphkbnmnoshyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtysotodasiphkbnmnoshyouji(String pZtysotodasiphkbnmnoshyouji) {
        ztysotodasiphkbnmnoshyouji = pZtysotodasiphkbnmnoshyouji;
    }

    private String ztystdsstkjytkyuhyj;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSTDSSTKJYTKYUHYJ)
    public String getZtystdsstkjytkyuhyj() {
        return ztystdsstkjytkyuhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtystdsstkjytkyuhyj(String pZtystdsstkjytkyuhyj) {
        ztystdsstkjytkyuhyj = pZtystdsstkjytkyuhyj;
    }

    private String ztykbnkeiriyousegmentkbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYKBNKEIRIYOUSEGMENTKBN)
    public String getZtykbnkeiriyousegmentkbn() {
        return ztykbnkeiriyousegmentkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtykbnkeiriyousegmentkbn(String pZtykbnkeiriyousegmentkbn) {
        ztykbnkeiriyousegmentkbn = pZtykbnkeiriyousegmentkbn;
    }

    private String ztykbnkeiriyourgnbnskkbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYKBNKEIRIYOURGNBNSKKBN)
    public String getZtykbnkeiriyourgnbnskkbn() {
        return ztykbnkeiriyourgnbnskkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtykbnkeiriyourgnbnskkbn(String pZtykbnkeiriyourgnbnskkbn) {
        ztykbnkeiriyourgnbnskkbn = pZtykbnkeiriyourgnbnskkbn;
    }

    private String ztysuurisyuruicd;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSUURISYURUICD)
    public String getZtysuurisyuruicd() {
        return ztysuurisyuruicd;
    }

    public void setZtysuurisyuruicd(String pZtysuurisyuruicd) {
        ztysuurisyuruicd = pZtysuurisyuruicd;
    }

    private String ztyhosyoukinoukbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYHOSYOUKINOUKBN)
    public String getZtyhosyoukinoukbn() {
        return ztyhosyoukinoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtyhosyoukinoukbn(String pZtyhosyoukinoukbn) {
        ztyhosyoukinoukbn = pZtyhosyoukinoukbn;
    }

    private String ztydaikbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYDAIKBN)
    public String getZtydaikbn() {
        return ztydaikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtydaikbn(String pZtydaikbn) {
        ztydaikbn = pZtydaikbn;
    }

    private String ztytyuukbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYTYUUKBN)
    public String getZtytyuukbn() {
        return ztytyuukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZtytyuukbn(String pZtytyuukbn) {
        ztytyuukbn = pZtytyuukbn;
    }

    private String ztysyoukbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSYOUKBN)
    public String getZtysyoukbn() {
        return ztysyoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZtysyoukbn(String pZtysyoukbn) {
        ztysyoukbn = pZtysyoukbn;
    }

    private String ztysedaikbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSEDAIKBN)
    public String getZtysedaikbn() {
        return ztysedaikbn;
    }

    public void setZtysedaikbn(String pZtysedaikbn) {
        ztysedaikbn = pZtysedaikbn;
    }

    private String ztyharaikatakbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYHARAIKATAKBN)
    public String getZtyharaikatakbn() {
        return ztyharaikatakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyharaikatakbn(String pZtyharaikatakbn) {
        ztyharaikatakbn = pZtyharaikatakbn;
    }

    private String ztykykymd;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYKYKYMD)
    public String getZtykykymd() {
        return ztykykymd;
    }

    public void setZtykykymd(String pZtykykymd) {
        ztykykymd = pZtykykymd;
    }

    private String ztyhknkkn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYHKNKKN)
    public String getZtyhknkkn() {
        return ztyhknkkn;
    }

    public void setZtyhknkkn(String pZtyhknkkn) {
        ztyhknkkn = pZtyhknkkn;
    }

    private String ztyphrkkikn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYPHRKKIKN)
    public String getZtyphrkkikn() {
        return ztyphrkkikn;
    }

    public void setZtyphrkkikn(String pZtyphrkkikn) {
        ztyphrkkikn = pZtyphrkkikn;
    }

    private String ztysaimnkkykhyj;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSAIMNKKYKHYJ)
    public String getZtysaimnkkykhyj() {
        return ztysaimnkkykhyj;
    }

    public void setZtysaimnkkykhyj(String pZtysaimnkkykhyj) {
        ztysaimnkkykhyj = pZtysaimnkkykhyj;
    }

    private String ztyannaifuyouriyuukbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYANNAIFUYOURIYUUKBN)
    public String getZtyannaifuyouriyuukbn() {
        return ztyannaifuyouriyuukbn;
    }

    public void setZtyannaifuyouriyuukbn(String pZtyannaifuyouriyuukbn) {
        ztyannaifuyouriyuukbn = pZtyannaifuyouriyuukbn;
    }

    private String ztytksyuannaikykkbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYTKSYUANNAIKYKKBN)
    public String getZtytksyuannaikykkbn() {
        return ztytksyuannaikykkbn;
    }

    public void setZtytksyuannaikykkbn(String pZtytksyuannaikykkbn) {
        ztytksyuannaikykkbn = pZtytksyuannaikykkbn;
    }

    private String ztyhrkkaisuukbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYHRKKAISUUKBN)
    public String getZtyhrkkaisuukbn() {
        return ztyhrkkaisuukbn;
    }

    public void setZtyhrkkaisuukbn(String pZtyhrkkaisuukbn) {
        ztyhrkkaisuukbn = pZtyhrkkaisuukbn;
    }

    private String ztyhrkkeirokbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYHRKKEIROKBN)
    public String getZtyhrkkeirokbn() {
        return ztyhrkkeirokbn;
    }

    public void setZtyhrkkeirokbn(String pZtyhrkkeirokbn) {
        ztyhrkkeirokbn = pZtyhrkkeirokbn;
    }

    private String ztysdpdkbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSDPDKBN)
    public String getZtysdpdkbn() {
        return ztysdpdkbn;
    }

    public void setZtysdpdkbn(String pZtysdpdkbn) {
        ztysdpdkbn = pZtysdpdkbn;
    }

    private String ztyryouritukbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYRYOURITUKBN)
    public String getZtyryouritukbn() {
        return ztyryouritukbn;
    }

    public void setZtyryouritukbn(String pZtyryouritukbn) {
        ztyryouritukbn = pZtyryouritukbn;
    }

    private String ztyao3tyou3sibousdatehyouji;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYAO3TYOU3SIBOUSDATEHYOUJI)
    public String getZtyao3tyou3sibousdatehyouji() {
        return ztyao3tyou3sibousdatehyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtyao3tyou3sibousdatehyouji(String pZtyao3tyou3sibousdatehyouji) {
        ztyao3tyou3sibousdatehyouji = pZtyao3tyou3sibousdatehyouji;
    }

    private String ztyhhknseikbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYHHKNSEIKBN)
    public String getZtyhhknseikbn() {
        return ztyhhknseikbn;
    }

    public void setZtyhhknseikbn(String pZtyhhknseikbn) {
        ztyhhknseikbn = pZtyhhknseikbn;
    }

    private String ztyhihokensyaagev2;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYHIHOKENSYAAGEV2)
    public String getZtyhihokensyaagev2() {
        return ztyhihokensyaagev2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyhihokensyaagev2(String pZtyhihokensyaagev2) {
        ztyhihokensyaagev2 = pZtyhihokensyaagev2;
    }

    private String ztykyksyanen;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYKYKSYANEN)
    public String getZtykyksyanen() {
        return ztykyksyanen;
    }

    public void setZtykyksyanen(String pZtykyksyanen) {
        ztykyksyanen = pZtykyksyanen;
    }

    private String ztydai2hhknnen;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYDAI2HHKNNEN)
    public String getZtydai2hhknnen() {
        return ztydai2hhknnen;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtydai2hhknnen(String pZtydai2hhknnen) {
        ztydai2hhknnen = pZtydai2hhknnen;
    }

    private String ztytkbthsyumnryuhyouji;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYTKBTHSYUMNRYUHYOUJI)
    public String getZtytkbthsyumnryuhyouji() {
        return ztytkbthsyumnryuhyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtytkbthsyumnryuhyouji(String pZtytkbthsyumnryuhyouji) {
        ztytkbthsyumnryuhyouji = pZtytkbthsyumnryuhyouji;
    }

    private String ztysyukeiyakupwaribikikbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSYUKEIYAKUPWARIBIKIKBN)
    public String getZtysyukeiyakupwaribikikbn() {
        return ztysyukeiyakupwaribikikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtysyukeiyakupwaribikikbn(String pZtysyukeiyakupwaribikikbn) {
        ztysyukeiyakupwaribikikbn = pZtysyukeiyakupwaribikikbn;
    }

    private String ztytenkanwaribikikbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYTENKANWARIBIKIKBN)
    public String getZtytenkanwaribikikbn() {
        return ztytenkanwaribikikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtytenkanwaribikikbn(String pZtytenkanwaribikikbn) {
        ztytenkanwaribikikbn = pZtytenkanwaribikikbn;
    }

    private String ztyyuuhitutnknyuguryurtkbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYYUUHITUTNKNYUGURYURTKBN)
    public String getZtyyuuhitutnknyuguryurtkbn() {
        return ztyyuuhitutnknyuguryurtkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyyuuhitutnknyuguryurtkbn(String pZtyyuuhitutnknyuguryurtkbn) {
        ztyyuuhitutnknyuguryurtkbn = pZtyyuuhitutnknyuguryurtkbn;
    }

    private Long ztysyukeiyakup;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSYUKEIYAKUP)
    public Long getZtysyukeiyakup() {
        return ztysyukeiyakup;
    }

    public void setZtysyukeiyakup(Long pZtysyukeiyakup) {
        ztysyukeiyakup = pZtysyukeiyakup;
    }

    private Long ztytokujyoup;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYTOKUJYOUP)
    public Long getZtytokujyoup() {
        return ztytokujyoup;
    }

    public void setZtytokujyoup(Long pZtytokujyoup) {
        ztytokujyoup = pZtytokujyoup;
    }

    private Long ztysiteizukisyukeiyakup;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSITEIZUKISYUKEIYAKUP)
    public Long getZtysiteizukisyukeiyakup() {
        return ztysiteizukisyukeiyakup;
    }

    public void setZtysiteizukisyukeiyakup(Long pZtysiteizukisyukeiyakup) {
        ztysiteizukisyukeiyakup = pZtysiteizukisyukeiyakup;
    }

    private Long ztykihons;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYKIHONS)
    public Long getZtykihons() {
        return ztykihons;
    }

    public void setZtykihons(Long pZtykihons) {
        ztykihons = pZtykihons;
    }

    private Long ztysibous;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSIBOUS)
    public Long getZtysibous() {
        return ztysibous;
    }

    public void setZtysibous(Long pZtysibous) {
        ztysibous = pZtysibous;
    }

    private Long ztyhenkougokihons;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYHENKOUGOKIHONS)
    public Long getZtyhenkougokihons() {
        return ztyhenkougokihons;
    }

    public void setZtyhenkougokihons(Long pZtyhenkougokihons) {
        ztyhenkougokihons = pZtyhenkougokihons;
    }

    private Long ztyhenkougosibous;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYHENKOUGOSIBOUS)
    public Long getZtyhenkougosibous() {
        return ztyhenkougosibous;
    }

    public void setZtyhenkougosibous(Long pZtyhenkougosibous) {
        ztyhenkougosibous = pZtyhenkougosibous;
    }

    private String ztyhenkouymd;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYHENKOUYMD)
    public String getZtyhenkouymd() {
        return ztyhenkouymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtyhenkouymd(String pZtyhenkouymd) {
        ztyhenkouymd = pZtyhenkouymd;
    }

    private String ztyentyoukikan;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYENTYOUKIKAN)
    public String getZtyentyoukikan() {
        return ztyentyoukikan;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZtyentyoukikan(String pZtyentyoukikan) {
        ztyentyoukikan = pZtyentyoukikan;
    }

    private String ztyseizonkyuuhukinsiteimd;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSEIZONKYUUHUKINSITEIMD)
    public String getZtyseizonkyuuhukinsiteimd() {
        return ztyseizonkyuuhukinsiteimd;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZtyseizonkyuuhukinsiteimd(String pZtyseizonkyuuhukinsiteimd) {
        ztyseizonkyuuhukinsiteimd = pZtyseizonkyuuhukinsiteimd;
    }

    private Long ztysyukeiyakusiharaikingaku;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSYUKEIYAKUSIHARAIKINGAKU)
    public Long getZtysyukeiyakusiharaikingaku() {
        return ztysyukeiyakusiharaikingaku;
    }

    public void setZtysyukeiyakusiharaikingaku(Long pZtysyukeiyakusiharaikingaku) {
        ztysyukeiyakusiharaikingaku = pZtysyukeiyakusiharaikingaku;
    }

    private String ztyatukaisisyatodouhukencd;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYATUKAISISYATODOUHUKENCD)
    public String getZtyatukaisisyatodouhukencd() {
        return ztyatukaisisyatodouhukencd;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyatukaisisyatodouhukencd(String pZtyatukaisisyatodouhukencd) {
        ztyatukaisisyatodouhukencd = pZtyatukaisisyatodouhukencd;
    }

    private Integer ztytokuyakuhukasuu;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYTOKUYAKUHUKASUU)
    public Integer getZtytokuyakuhukasuu() {
        return ztytokuyakuhukasuu;
    }

    public void setZtytokuyakuhukasuu(Integer pZtytokuyakuhukasuu) {
        ztytokuyakuhukasuu = pZtytokuyakuhukasuu;
    }

    private String ztydi2hknkknikoujihisyaage;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYDI2HKNKKNIKOUJIHISYAAGE)
    public String getZtydi2hknkknikoujihisyaage() {
        return ztydi2hknkknikoujihisyaage;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtydi2hknkknikoujihisyaage(String pZtydi2hknkknikoujihisyaage) {
        ztydi2hknkknikoujihisyaage = pZtydi2hknkknikoujihisyaage;
    }

    private String ztyhrimnentyoumaephrkkkn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYHRIMNENTYOUMAEPHRKKKN)
    public String getZtyhrimnentyoumaephrkkkn() {
        return ztyhrimnentyoumaephrkkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyhrimnentyoumaephrkkkn(String pZtyhrimnentyoumaephrkkkn) {
        ztyhrimnentyoumaephrkkkn = pZtyhrimnentyoumaephrkkkn;
    }

    private String ztytokubetuhosyoukikan;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYTOKUBETUHOSYOUKIKAN)
    public String getZtytokubetuhosyoukikan() {
        return ztytokubetuhosyoukikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtytokubetuhosyoukikan(String pZtytokubetuhosyoukikan) {
        ztytokubetuhosyoukikan = pZtytokubetuhosyoukikan;
    }

    private String ztykousinmanryouage;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYKOUSINMANRYOUAGE)
    public String getZtykousinmanryouage() {
        return ztykousinmanryouage;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtykousinmanryouage(String pZtykousinmanryouage) {
        ztykousinmanryouage = pZtykousinmanryouage;
    }

    private String ztyknkuzusnzyrttekitkarihyj;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYKNKUZUSNZYRTTEKITKARIHYJ)
    public String getZtyknkuzusnzyrttekitkarihyj() {
        return ztyknkuzusnzyrttekitkarihyj;
    }

    public void setZtyknkuzusnzyrttekitkarihyj(String pZtyknkuzusnzyrttekitkarihyj) {
        ztyknkuzusnzyrttekitkarihyj = pZtyknkuzusnzyrttekitkarihyj;
    }

    private String ztykuriagekurisagekbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYKURIAGEKURISAGEKBN)
    public String getZtykuriagekurisagekbn() {
        return ztykuriagekurisagekbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtykuriagekurisagekbn(String pZtykuriagekurisagekbn) {
        ztykuriagekurisagekbn = pZtykuriagekurisagekbn;
    }

    private String ztyhrizmjhknsyukigousdkbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYHRIZMJHKNSYUKIGOUSDKBN)
    public String getZtyhrizmjhknsyukigousdkbn() {
        return ztyhrizmjhknsyukigousdkbn;
    }

    public void setZtyhrizmjhknsyukigousdkbn(String pZtyhrizmjhknsyukigousdkbn) {
        ztyhrizmjhknsyukigousdkbn = pZtyhrizmjhknsyukigousdkbn;
    }

    private String ztykrsgjhknsyukigousdkbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYKRSGJHKNSYUKIGOUSDKBN)
    public String getZtykrsgjhknsyukigousdkbn() {
        return ztykrsgjhknsyukigousdkbn;
    }

    public void setZtykrsgjhknsyukigousdkbn(String pZtykrsgjhknsyukigousdkbn) {
        ztykrsgjhknsyukigousdkbn = pZtykrsgjhknsyukigousdkbn;
    }

    private String ztysotodasisyouhinkaiteikbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSOTODASISYOUHINKAITEIKBN)
    public String getZtysotodasisyouhinkaiteikbn() {
        return ztysotodasisyouhinkaiteikbn;
    }

    public void setZtysotodasisyouhinkaiteikbn(String pZtysotodasisyouhinkaiteikbn) {
        ztysotodasisyouhinkaiteikbn = pZtysotodasisyouhinkaiteikbn;
    }

    private String ztyyobiv4;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYYOBIV4)
    public String getZtyyobiv4() {
        return ztyyobiv4;
    }

    public void setZtyyobiv4(String pZtyyobiv4) {
        ztyyobiv4 = pZtyyobiv4;
    }

    private Long ztygoukeitenkans;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYGOUKEITENKANS)
    public Long getZtygoukeitenkans() {
        return ztygoukeitenkans;
    }

    public void setZtygoukeitenkans(Long pZtygoukeitenkans) {
        ztygoukeitenkans = pZtygoukeitenkans;
    }

    private Long ztygoukeipbubuntenkans;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYGOUKEIPBUBUNTENKANS)
    public Long getZtygoukeipbubuntenkans() {
        return ztygoukeipbubuntenkans;
    }

    public void setZtygoukeipbubuntenkans(Long pZtygoukeipbubuntenkans) {
        ztygoukeipbubuntenkans = pZtygoukeipbubuntenkans;
    }

    private String ztytenkanteikisyuruikigou;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYTENKANTEIKISYURUIKIGOU)
    public String getZtytenkanteikisyuruikigou() {
        return ztytenkanteikisyuruikigou;
    }

    public void setZtytenkanteikisyuruikigou(String pZtytenkanteikisyuruikigou) {
        ztytenkanteikisyuruikigou = pZtytenkanteikisyuruikigou;
    }

    private String ztytenkanteikikigousedaikbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYTENKANTEIKIKIGOUSEDAIKBN)
    public String getZtytenkanteikikigousedaikbn() {
        return ztytenkanteikikigousedaikbn;
    }

    public void setZtytenkanteikikigousedaikbn(String pZtytenkanteikikigousedaikbn) {
        ztytenkanteikikigousedaikbn = pZtytenkanteikikigousedaikbn;
    }

    private String ztytnkntiksotodasikusnkbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYTNKNTIKSOTODASIKUSNKBN)
    public String getZtytnkntiksotodasikusnkbn() {
        return ztytnkntiksotodasikusnkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtytnkntiksotodasikusnkbn(String pZtytnkntiksotodasikusnkbn) {
        ztytnkntiksotodasikusnkbn = pZtytnkntiksotodasikusnkbn;
    }

    private String ztytnkntikstdspmenkbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYTNKNTIKSTDSPMENKBN)
    public String getZtytnkntikstdspmenkbn() {
        return ztytnkntikstdspmenkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtytnkntikstdspmenkbn(String pZtytnkntikstdspmenkbn) {
        ztytnkntikstdspmenkbn = pZtytnkntikstdspmenkbn;
    }

    private String ztytenkanteikikigouyobi;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYTENKANTEIKIKIGOUYOBI)
    public String getZtytenkanteikikigouyobi() {
        return ztytenkanteikikigouyobi;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtytenkanteikikigouyobi(String pZtytenkanteikikigouyobi) {
        ztytenkanteikikigouyobi = pZtytenkanteikikigouyobi;
    }

    private String ztytenkanteikikikan;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYTENKANTEIKIKIKAN)
    public String getZtytenkanteikikikan() {
        return ztytenkanteikikikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtytenkanteikikikan(String pZtytenkanteikikikan) {
        ztytenkanteikikikan = pZtytenkanteikikikan;
    }

    private Long ztygoukeitenkanteikis;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYGOUKEITENKANTEIKIS)
    public Long getZtygoukeitenkanteikis() {
        return ztygoukeitenkanteikis;
    }

    public void setZtygoukeitenkanteikis(Long pZtygoukeitenkanteikis) {
        ztygoukeitenkanteikis = pZtygoukeitenkanteikis;
    }

    private String ztytnknteikinkshrkkn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYTNKNTEIKINKSHRKKN)
    public String getZtytnknteikinkshrkkn() {
        return ztytnknteikinkshrkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtytnknteikinkshrkkn(String pZtytnknteikinkshrkkn) {
        ztytnknteikinkshrkkn = pZtytnknteikinkshrkkn;
    }

    private Long ztytenkansiharaikingaku;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYTENKANSIHARAIKINGAKU)
    public Long getZtytenkansiharaikingaku() {
        return ztytenkansiharaikingaku;
    }

    public void setZtytenkansiharaikingaku(Long pZtytenkansiharaikingaku) {
        ztytenkansiharaikingaku = pZtytenkansiharaikingaku;
    }

    private Long ztytnkntikshrkngk;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYTNKNTIKSHRKNGK)
    public Long getZtytnkntikshrkngk() {
        return ztytnkntikshrkngk;
    }

    public void setZtytnkntikshrkngk(Long pZtytnkntikshrkngk) {
        ztytnkntikshrkngk = pZtytnkntikshrkngk;
    }

    private String ztytenkankaisuu;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYTENKANKAISUU)
    public String getZtytenkankaisuu() {
        return ztytenkankaisuu;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtytenkankaisuu(String pZtytenkankaisuu) {
        ztytenkankaisuu = pZtytenkankaisuu;
    }

    private Long ztygoukeitenkankakaku;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYGOUKEITENKANKAKAKU)
    public Long getZtygoukeitenkankakaku() {
        return ztygoukeitenkankakaku;
    }

    public void setZtygoukeitenkankakaku(Long pZtygoukeitenkankakaku) {
        ztygoukeitenkankakaku = pZtygoukeitenkankakaku;
    }

    private BizNumber ztytnknkhnbbnjyuturt;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYTNKNKHNBBNJYUTURT)
    public BizNumber getZtytnknkhnbbnjyuturt() {
        return ztytnknkhnbbnjyuturt;
    }

    public void setZtytnknkhnbbnjyuturt(BizNumber pZtytnknkhnbbnjyuturt) {
        ztytnknkhnbbnjyuturt = pZtytnknkhnbbnjyuturt;
    }

    private Long ztywnasigoukeitenkanteikis;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYWNASIGOUKEITENKANTEIKIS)
    public Long getZtywnasigoukeitenkanteikis() {
        return ztywnasigoukeitenkanteikis;
    }

    public void setZtywnasigoukeitenkanteikis(Long pZtywnasigoukeitenkanteikis) {
        ztywnasigoukeitenkanteikis = pZtywnasigoukeitenkanteikis;
    }

    private String ztytnknteikikousinmnryouage;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYTNKNTEIKIKOUSINMNRYOUAGE)
    public String getZtytnknteikikousinmnryouage() {
        return ztytnknteikikousinmnryouage;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtytnknteikikousinmnryouage(String pZtytnknteikikousinmnryouage) {
        ztytnknteikikousinmnryouage = pZtytnknteikikousinmnryouage;
    }

    private String ztyyobiv5;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYYOBIV5)
    public String getZtyyobiv5() {
        return ztyyobiv5;
    }

    public void setZtyyobiv5(String pZtyyobiv5) {
        ztyyobiv5 = pZtyyobiv5;
    }

    private String ztykanyujidatakanrino;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYKANYUJIDATAKANRINO)
    public String getZtykanyujidatakanrino() {
        return ztykanyujidatakanrino;
    }

    @Padding(mode = "left", padChar = '0', length = 11)
    public void setZtykanyujidatakanrino(String pZtykanyujidatakanrino) {
        ztykanyujidatakanrino = pZtykanyujidatakanrino;
    }

    private String ztykanyujikykymd;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYKANYUJIKYKYMD)
    public String getZtykanyujikykymd() {
        return ztykanyujikykymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtykanyujikykymd(String pZtykanyujikykymd) {
        ztykanyujikykymd = pZtykanyujikykymd;
    }

    private String ztykanyuujihihokensyaage;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYKANYUUJIHIHOKENSYAAGE)
    public String getZtykanyuujihihokensyaage() {
        return ztykanyuujihihokensyaage;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtykanyuujihihokensyaage(String pZtykanyuujihihokensyaage) {
        ztykanyuujihihokensyaage = pZtykanyuujihihokensyaage;
    }

    private String ztykanyuujitenkanhyouji;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYKANYUUJITENKANHYOUJI)
    public String getZtykanyuujitenkanhyouji() {
        return ztykanyuujitenkanhyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtykanyuujitenkanhyouji(String pZtykanyuujitenkanhyouji) {
        ztykanyuujitenkanhyouji = pZtykanyuujitenkanhyouji;
    }

    private String ztyhsyuikktminaosikaisu;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYHSYUIKKTMINAOSIKAISU)
    public String getZtyhsyuikktminaosikaisu() {
        return ztyhsyuikktminaosikaisu;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyhsyuikktminaosikaisu(String pZtyhsyuikktminaosikaisu) {
        ztyhsyuikktminaosikaisu = pZtyhsyuikktminaosikaisu;
    }

    private BizNumber ztysknnjynbknsisnrt;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSKNNJYNBKNSISNRT)
    public BizNumber getZtysknnjynbknsisnrt() {
        return ztysknnjynbknsisnrt;
    }

    public void setZtysknnjynbknsisnrt(BizNumber pZtysknnjynbknsisnrt) {
        ztysknnjynbknsisnrt = pZtysknnjynbknsisnrt;
    }

    private String ztytkjykbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYTKJYKBN)
    public String getZtytkjykbn() {
        return ztytkjykbn;
    }

    public void setZtytkjykbn(String pZtytkjykbn) {
        ztytkjykbn = pZtytkjykbn;
    }

    private String ztysakugenkikan;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSAKUGENKIKAN)
    public String getZtysakugenkikan() {
        return ztysakugenkikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtysakugenkikan(String pZtysakugenkikan) {
        ztysakugenkikan = pZtysakugenkikan;
    }

    private Integer ztyryoumasihyouten;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYRYOUMASIHYOUTEN)
    public Integer getZtyryoumasihyouten() {
        return ztyryoumasihyouten;
    }

    public void setZtyryoumasihyouten(Integer pZtyryoumasihyouten) {
        ztyryoumasihyouten = pZtyryoumasihyouten;
    }

    private String ztysykyktkjyuryumsratehyj;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSYKYKTKJYURYUMSRATEHYJ)
    public String getZtysykyktkjyuryumsratehyj() {
        return ztysykyktkjyuryumsratehyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtysykyktkjyuryumsratehyj(String pZtysykyktkjyuryumsratehyj) {
        ztysykyktkjyuryumsratehyj = pZtysykyktkjyuryumsratehyj;
    }

    private BizNumber ztysykyktkjyuryumsrate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSYKYKTKJYURYUMSRATE)
    public BizNumber getZtysykyktkjyuryumsrate() {
        return ztysykyktkjyuryumsrate;
    }

    public void setZtysykyktkjyuryumsrate(BizNumber pZtysykyktkjyuryumsrate) {
        ztysykyktkjyuryumsrate = pZtysykyktkjyuryumsrate;
    }

    private String ztydai2tokujyoukbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYDAI2TOKUJYOUKBN)
    public String getZtydai2tokujyoukbn() {
        return ztydai2tokujyoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtydai2tokujyoukbn(String pZtydai2tokujyoukbn) {
        ztydai2tokujyoukbn = pZtydai2tokujyoukbn;
    }

    private String ztydai2sakugenkikan;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYDAI2SAKUGENKIKAN)
    public String getZtydai2sakugenkikan() {
        return ztydai2sakugenkikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtydai2sakugenkikan(String pZtydai2sakugenkikan) {
        ztydai2sakugenkikan = pZtydai2sakugenkikan;
    }

    private Integer ztydai2ryoumasihyouten;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYDAI2RYOUMASIHYOUTEN)
    public Integer getZtydai2ryoumasihyouten() {
        return ztydai2ryoumasihyouten;
    }

    public void setZtydai2ryoumasihyouten(Integer pZtydai2ryoumasihyouten) {
        ztydai2ryoumasihyouten = pZtydai2ryoumasihyouten;
    }

    private String ztytokuteibuijyoukenhyouji;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYTOKUTEIBUIJYOUKENHYOUJI)
    public String getZtytokuteibuijyoukenhyouji() {
        return ztytokuteibuijyoukenhyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtytokuteibuijyoukenhyouji(String pZtytokuteibuijyoukenhyouji) {
        ztytokuteibuijyoukenhyouji = pZtytokuteibuijyoukenhyouji;
    }

    private String ztytokuteibuino1;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYTOKUTEIBUINO1)
    public String getZtytokuteibuino1() {
        return ztytokuteibuino1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtytokuteibuino1(String pZtytokuteibuino1) {
        ztytokuteibuino1 = pZtytokuteibuino1;
    }

    private String ztyhtnpkkn1;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYHTNPKKN1)
    public String getZtyhtnpkkn1() {
        return ztyhtnpkkn1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyhtnpkkn1(String pZtyhtnpkkn1) {
        ztyhtnpkkn1 = pZtyhtnpkkn1;
    }

    private String ztytokuteibuino2;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYTOKUTEIBUINO2)
    public String getZtytokuteibuino2() {
        return ztytokuteibuino2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtytokuteibuino2(String pZtytokuteibuino2) {
        ztytokuteibuino2 = pZtytokuteibuino2;
    }

    private String ztyhtnpkkn2;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYHTNPKKN2)
    public String getZtyhtnpkkn2() {
        return ztyhtnpkkn2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyhtnpkkn2(String pZtyhtnpkkn2) {
        ztyhtnpkkn2 = pZtyhtnpkkn2;
    }

    private String ztymhituiryuyutktbijyknhyj;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYMHITUIRYUYUTKTBIJYKNHYJ)
    public String getZtymhituiryuyutktbijyknhyj() {
        return ztymhituiryuyutktbijyknhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtymhituiryuyutktbijyknhyj(String pZtymhituiryuyutktbijyknhyj) {
        ztymhituiryuyutktbijyknhyj = pZtymhituiryuyutktbijyknhyj;
    }

    private String ztymuhaitouiryouyoutktbino1;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYMUHAITOUIRYOUYOUTKTBINO1)
    public String getZtymuhaitouiryouyoutktbino1() {
        return ztymuhaitouiryouyoutktbino1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtymuhaitouiryouyoutktbino1(String pZtymuhaitouiryouyoutktbino1) {
        ztymuhaitouiryouyoutktbino1 = pZtymuhaitouiryouyoutktbino1;
    }

    private String ztymuhaitouiryouyouhtnpkkn1;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYMUHAITOUIRYOUYOUHTNPKKN1)
    public String getZtymuhaitouiryouyouhtnpkkn1() {
        return ztymuhaitouiryouyouhtnpkkn1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtymuhaitouiryouyouhtnpkkn1(String pZtymuhaitouiryouyouhtnpkkn1) {
        ztymuhaitouiryouyouhtnpkkn1 = pZtymuhaitouiryouyouhtnpkkn1;
    }

    private String ztymuhaitouiryouyoutktbino2;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYMUHAITOUIRYOUYOUTKTBINO2)
    public String getZtymuhaitouiryouyoutktbino2() {
        return ztymuhaitouiryouyoutktbino2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtymuhaitouiryouyoutktbino2(String pZtymuhaitouiryouyoutktbino2) {
        ztymuhaitouiryouyoutktbino2 = pZtymuhaitouiryouyoutktbino2;
    }

    private String ztymuhaitouiryouyouhtnpkkn2;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYMUHAITOUIRYOUYOUHTNPKKN2)
    public String getZtymuhaitouiryouyouhtnpkkn2() {
        return ztymuhaitouiryouyouhtnpkkn2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtymuhaitouiryouyouhtnpkkn2(String pZtymuhaitouiryouyouhtnpkkn2) {
        ztymuhaitouiryouyouhtnpkkn2 = pZtymuhaitouiryouyouhtnpkkn2;
    }

    private String ztysiteizukipwarimasihyouji;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSITEIZUKIPWARIMASIHYOUJI)
    public String getZtysiteizukipwarimasihyouji() {
        return ztysiteizukipwarimasihyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtysiteizukipwarimasihyouji(String pZtysiteizukipwarimasihyouji) {
        ztysiteizukipwarimasihyouji = pZtysiteizukipwarimasihyouji;
    }

    private String ztypwarimasisiteim1;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYPWARIMASISITEIM1)
    public String getZtypwarimasisiteim1() {
        return ztypwarimasisiteim1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtypwarimasisiteim1(String pZtypwarimasisiteim1) {
        ztypwarimasisiteim1 = pZtypwarimasisiteim1;
    }

    private String ztypwarimasisiteim2;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYPWARIMASISITEIM2)
    public String getZtypwarimasisiteim2() {
        return ztypwarimasisiteim2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtypwarimasisiteim2(String pZtypwarimasisiteim2) {
        ztypwarimasisiteim2 = pZtypwarimasisiteim2;
    }

    private String ztysiteimsykykpbairitu;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSITEIMSYKYKPBAIRITU)
    public String getZtysiteimsykykpbairitu() {
        return ztysiteimsykykpbairitu;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtysiteimsykykpbairitu(String pZtysiteimsykykpbairitu) {
        ztysiteimsykykpbairitu = pZtysiteimsykykpbairitu;
    }

    private String ztysaisyuusiteiym;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSAISYUUSITEIYM)
    public String getZtysaisyuusiteiym() {
        return ztysaisyuusiteiym;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZtysaisyuusiteiym(String pZtysaisyuusiteiym) {
        ztysaisyuusiteiym = pZtysaisyuusiteiym;
    }

    private String ztysykykkitmttvkeisanym;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSYKYKKITMTTVKEISANYM)
    public String getZtysykykkitmttvkeisanym() {
        return ztysykykkitmttvkeisanym;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZtysykykkitmttvkeisanym(String pZtysykykkitmttvkeisanym) {
        ztysykykkitmttvkeisanym = pZtysykykkitmttvkeisanym;
    }

    private Long ztysykykkitmttsknnjynbkngk;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSYKYKKITMTTSKNNJYNBKNGK)
    public Long getZtysykykkitmttsknnjynbkngk() {
        return ztysykykkitmttsknnjynbkngk;
    }

    public void setZtysykykkitmttsknnjynbkngk(Long pZtysykykkitmttsknnjynbkngk) {
        ztysykykkitmttsknnjynbkngk = pZtysykykkitmttsknnjynbkngk;
    }

    private Long ztydftumitatekingaku;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYDFTUMITATEKINGAKU)
    public Long getZtydftumitatekingaku() {
        return ztydftumitatekingaku;
    }

    public void setZtydftumitatekingaku(Long pZtydftumitatekingaku) {
        ztydftumitatekingaku = pZtydftumitatekingaku;
    }

    private Long ztydftumimasikin;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYDFTUMIMASIKIN)
    public Long getZtydftumimasikin() {
        return ztydftumimasikin;
    }

    public void setZtydftumimasikin(Long pZtydftumimasikin) {
        ztydftumimasikin = pZtydftumimasikin;
    }

    private Long ztyvbubundftenkankakaku;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYVBUBUNDFTENKANKAKAKU)
    public Long getZtyvbubundftenkankakaku() {
        return ztyvbubundftenkankakaku;
    }

    public void setZtyvbubundftenkankakaku(Long pZtyvbubundftenkankakaku) {
        ztyvbubundftenkankakaku = pZtyvbubundftenkankakaku;
    }

    private Long ztydpbubundftenkankakaku;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYDPBUBUNDFTENKANKAKAKU)
    public Long getZtydpbubundftenkankakaku() {
        return ztydpbubundftenkankakaku;
    }

    public void setZtydpbubundftenkankakaku(Long pZtydpbubundftenkankakaku) {
        ztydpbubundftenkankakaku = pZtydpbubundftenkankakaku;
    }

    private Long ztydftmttkngkitjbrbbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYDFTMTTKNGKITJBRBBN)
    public Long getZtydftmttkngkitjbrbbn() {
        return ztydftmttkngkitjbrbbn;
    }

    public void setZtydftmttkngkitjbrbbn(Long pZtydftmttkngkitjbrbbn) {
        ztydftmttkngkitjbrbbn = pZtydftmttkngkitjbrbbn;
    }

    private Long ztyhendous;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYHENDOUS)
    public Long getZtyhendous() {
        return ztyhendous;
    }

    public void setZtyhendous(Long pZtyhendous) {
        ztyhendous = pZtyhendous;
    }

    private Long ztyhengakujigyounendomatucv;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYHENGAKUJIGYOUNENDOMATUCV)
    public Long getZtyhengakujigyounendomatucv() {
        return ztyhengakujigyounendomatucv;
    }

    public void setZtyhengakujigyounendomatucv(Long pZtyhengakujigyounendomatucv) {
        ztyhengakujigyounendomatucv = pZtyhengakujigyounendomatucv;
    }

    private Long ztyitibuitijibarais;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYITIBUITIJIBARAIS)
    public Long getZtyitibuitijibarais() {
        return ztyitibuitijibarais;
    }

    public void setZtyitibuitijibarais(Long pZtyitibuitijibarais) {
        ztyitibuitijibarais = pZtyitibuitijibarais;
    }

    private Long ztyitibuitijibaraip;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYITIBUITIJIBARAIP)
    public Long getZtyitibuitijibaraip() {
        return ztyitibuitijibaraip;
    }

    public void setZtyitibuitijibaraip(Long pZtyitibuitijibaraip) {
        ztyitibuitijibaraip = pZtyitibuitijibaraip;
    }

    private Long ztyitibitjbrshrkngk;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYITIBITJBRSHRKNGK)
    public Long getZtyitibitjbrshrkngk() {
        return ztyitibitjbrshrkngk;
    }

    public void setZtyitibitjbrshrkngk(Long pZtyitibitjbrshrkngk) {
        ztyitibitjbrshrkngk = pZtyitibitjbrshrkngk;
    }

    private Long ztygoukeicv;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYGOUKEICV)
    public Long getZtygoukeicv() {
        return ztygoukeicv;
    }

    public void setZtygoukeicv(Long pZtygoukeicv) {
        ztygoukeicv = pZtygoukeicv;
    }

    private Long ztyminasicv;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYMINASICV)
    public Long getZtyminasicv() {
        return ztyminasicv;
    }

    public void setZtyminasicv(Long pZtyminasicv) {
        ztyminasicv = pZtyminasicv;
    }

    private Long ztyloanfund;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYLOANFUND)
    public Long getZtyloanfund() {
        return ztyloanfund;
    }

    public void setZtyloanfund(Long pZtyloanfund) {
        ztyloanfund = pZtyloanfund;
    }

    private Long ztysaiteihosyougaku;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSAITEIHOSYOUGAKU)
    public Long getZtysaiteihosyougaku() {
        return ztysaiteihosyougaku;
    }

    public void setZtysaiteihosyougaku(Long pZtysaiteihosyougaku) {
        ztysaiteihosyougaku = pZtysaiteihosyougaku;
    }

    private Long ztyhngksitihsyuyusykykp;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYHNGKSITIHSYUYUSYKYKP)
    public Long getZtyhngksitihsyuyusykykp() {
        return ztyhngksitihsyuyusykykp;
    }

    public void setZtyhngksitihsyuyusykykp(Long pZtyhngksitihsyuyusykykp) {
        ztyhngksitihsyuyusykykp = pZtyhngksitihsyuyusykykp;
    }

    private Long ztyhijynbrivasbujsitihsyugk;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYHIJYNBRIVASBUJSITIHSYUGK)
    public Long getZtyhijynbrivasbujsitihsyugk() {
        return ztyhijynbrivasbujsitihsyugk;
    }

    public void setZtyhijynbrivasbujsitihsyugk(Long pZtyhijynbrivasbujsitihsyugk) {
        ztyhijynbrivasbujsitihsyugk = pZtyhijynbrivasbujsitihsyugk;
    }

    private Long ztyhijynbrivamnkjsitihsyugk;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYHIJYNBRIVAMNKJSITIHSYUGK)
    public Long getZtyhijynbrivamnkjsitihsyugk() {
        return ztyhijynbrivamnkjsitihsyugk;
    }

    public void setZtyhijynbrivamnkjsitihsyugk(Long pZtyhijynbrivamnkjsitihsyugk) {
        ztyhijynbrivamnkjsitihsyugk = pZtyhijynbrivamnkjsitihsyugk;
    }

    private String ztysiinkbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSIINKBN)
    public String getZtysiinkbn() {
        return ztysiinkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtysiinkbn(String pZtysiinkbn) {
        ztysiinkbn = pZtysiinkbn;
    }

    private Long ztymudkaimasikihons;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYMUDKAIMASIKIHONS)
    public Long getZtymudkaimasikihons() {
        return ztymudkaimasikihons;
    }

    public void setZtymudkaimasikihons(Long pZtymudkaimasikihons) {
        ztymudkaimasikihons = pZtymudkaimasikihons;
    }

    private String ztykaimasiymd;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYKAIMASIYMD)
    public String getZtykaimasiymd() {
        return ztykaimasiymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtykaimasiymd(String pZtykaimasiymd) {
        ztykaimasiymd = pZtykaimasiymd;
    }

    private String ztykaimasikikan;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYKAIMASIKIKAN)
    public String getZtykaimasikikan() {
        return ztykaimasikikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtykaimasikikan(String pZtykaimasikikan) {
        ztykaimasikikan = pZtykaimasikikan;
    }

    private Long ztyhikitugikaimasis;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYHIKITUGIKAIMASIS)
    public Long getZtyhikitugikaimasis() {
        return ztyhikitugikaimasis;
    }

    public void setZtyhikitugikaimasis(Long pZtyhikitugikaimasis) {
        ztyhikitugikaimasis = pZtyhikitugikaimasis;
    }

    private Long ztymudkaimasisiharaikingaku;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYMUDKAIMASISIHARAIKINGAKU)
    public Long getZtymudkaimasisiharaikingaku() {
        return ztymudkaimasisiharaikingaku;
    }

    public void setZtymudkaimasisiharaikingaku(Long pZtymudkaimasisiharaikingaku) {
        ztymudkaimasisiharaikingaku = pZtymudkaimasisiharaikingaku;
    }

    private String ztyszoukouryokukaisiymdx1;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSZOUKOURYOKUKAISIYMDX1)
    public String getZtyszoukouryokukaisiymdx1() {
        return ztyszoukouryokukaisiymdx1;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtyszoukouryokukaisiymdx1(String pZtyszoukouryokukaisiymdx1) {
        ztyszoukouryokukaisiymdx1 = pZtyszoukouryokukaisiymdx1;
    }

    private String ztyszouhokensyuruikigoux1;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSZOUHOKENSYURUIKIGOUX1)
    public String getZtyszouhokensyuruikigoux1() {
        return ztyszouhokensyuruikigoux1;
    }

    public void setZtyszouhokensyuruikigoux1(String pZtyszouhokensyuruikigoux1) {
        ztyszouhokensyuruikigoux1 = pZtyszouhokensyuruikigoux1;
    }

    private String ztyszoukigousedaikbnx1;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSZOUKIGOUSEDAIKBNX1)
    public String getZtyszoukigousedaikbnx1() {
        return ztyszoukigousedaikbnx1;
    }

    public void setZtyszoukigousedaikbnx1(String pZtyszoukigousedaikbnx1) {
        ztyszoukigousedaikbnx1 = pZtyszoukigousedaikbnx1;
    }

    private String ztyszoukikanx1;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSZOUKIKANX1)
    public String getZtyszoukikanx1() {
        return ztyszoukikanx1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyszoukikanx1(String pZtyszoukikanx1) {
        ztyszoukikanx1 = pZtyszoukikanx1;
    }

    private String ztyszouhihokensyaagex1;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSZOUHIHOKENSYAAGEX1)
    public String getZtyszouhihokensyaagex1() {
        return ztyszouhihokensyaagex1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyszouhihokensyaagex1(String pZtyszouhihokensyaagex1) {
        ztyszouhihokensyaagex1 = pZtyszouhihokensyaagex1;
    }

    private String ztyszoudai2hihknsyaagex1;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSZOUDAI2HIHKNSYAAGEX1)
    public String getZtyszoudai2hihknsyaagex1() {
        return ztyszoudai2hihknsyaagex1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyszoudai2hihknsyaagex1(String pZtyszoudai2hihknsyaagex1) {
        ztyszoudai2hihknsyaagex1 = pZtyszoudai2hihknsyaagex1;
    }

    private Long ztyzoukasx1;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYZOUKASX1)
    public Long getZtyzoukasx1() {
        return ztyzoukasx1;
    }

    public void setZtyzoukasx1(Long pZtyzoukasx1) {
        ztyzoukasx1 = pZtyzoukasx1;
    }

    private Long ztyzennendozoukasx1;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYZENNENDOZOUKASX1)
    public Long getZtyzennendozoukasx1() {
        return ztyzennendozoukasx1;
    }

    public void setZtyzennendozoukasx1(Long pZtyzennendozoukasx1) {
        ztyzennendozoukasx1 = pZtyzennendozoukasx1;
    }

    private Long ztyszousiharaikingakux1;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSZOUSIHARAIKINGAKUX1)
    public Long getZtyszousiharaikingakux1() {
        return ztyszousiharaikingakux1;
    }

    public void setZtyszousiharaikingakux1(Long pZtyszousiharaikingakux1) {
        ztyszousiharaikingakux1 = pZtyszousiharaikingakux1;
    }

    private String ztyszoukouryokukaisiymdx2;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSZOUKOURYOKUKAISIYMDX2)
    public String getZtyszoukouryokukaisiymdx2() {
        return ztyszoukouryokukaisiymdx2;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtyszoukouryokukaisiymdx2(String pZtyszoukouryokukaisiymdx2) {
        ztyszoukouryokukaisiymdx2 = pZtyszoukouryokukaisiymdx2;
    }

    private String ztyszouhokensyuruikigoux2;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSZOUHOKENSYURUIKIGOUX2)
    public String getZtyszouhokensyuruikigoux2() {
        return ztyszouhokensyuruikigoux2;
    }

    public void setZtyszouhokensyuruikigoux2(String pZtyszouhokensyuruikigoux2) {
        ztyszouhokensyuruikigoux2 = pZtyszouhokensyuruikigoux2;
    }

    private String ztyszoukigousedaikbnx2;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSZOUKIGOUSEDAIKBNX2)
    public String getZtyszoukigousedaikbnx2() {
        return ztyszoukigousedaikbnx2;
    }

    public void setZtyszoukigousedaikbnx2(String pZtyszoukigousedaikbnx2) {
        ztyszoukigousedaikbnx2 = pZtyszoukigousedaikbnx2;
    }

    private String ztyszoukikanx2;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSZOUKIKANX2)
    public String getZtyszoukikanx2() {
        return ztyszoukikanx2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyszoukikanx2(String pZtyszoukikanx2) {
        ztyszoukikanx2 = pZtyszoukikanx2;
    }

    private String ztyszouhihokensyaagex2;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSZOUHIHOKENSYAAGEX2)
    public String getZtyszouhihokensyaagex2() {
        return ztyszouhihokensyaagex2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyszouhihokensyaagex2(String pZtyszouhihokensyaagex2) {
        ztyszouhihokensyaagex2 = pZtyszouhihokensyaagex2;
    }

    private String ztyszoudai2hihknsyaagex2;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSZOUDAI2HIHKNSYAAGEX2)
    public String getZtyszoudai2hihknsyaagex2() {
        return ztyszoudai2hihknsyaagex2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyszoudai2hihknsyaagex2(String pZtyszoudai2hihknsyaagex2) {
        ztyszoudai2hihknsyaagex2 = pZtyszoudai2hihknsyaagex2;
    }

    private Long ztyzoukasx2;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYZOUKASX2)
    public Long getZtyzoukasx2() {
        return ztyzoukasx2;
    }

    public void setZtyzoukasx2(Long pZtyzoukasx2) {
        ztyzoukasx2 = pZtyzoukasx2;
    }

    private Long ztyzennendozoukasx2;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYZENNENDOZOUKASX2)
    public Long getZtyzennendozoukasx2() {
        return ztyzennendozoukasx2;
    }

    public void setZtyzennendozoukasx2(Long pZtyzennendozoukasx2) {
        ztyzennendozoukasx2 = pZtyzennendozoukasx2;
    }

    private Long ztyszousiharaikingakux2;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSZOUSIHARAIKINGAKUX2)
    public Long getZtyszousiharaikingakux2() {
        return ztyszousiharaikingakux2;
    }

    public void setZtyszousiharaikingakux2(Long pZtyszousiharaikingakux2) {
        ztyszousiharaikingakux2 = pZtyszousiharaikingakux2;
    }

    private String ztysuuriyouyobin1x5;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSUURIYOUYOBIN1X5)
    public String getZtysuuriyouyobin1x5() {
        return ztysuuriyouyobin1x5;
    }

    public void setZtysuuriyouyobin1x5(String pZtysuuriyouyobin1x5) {
        ztysuuriyouyobin1x5 = pZtysuuriyouyobin1x5;
    }

    private String ztysuuriyouyobin1x6;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSUURIYOUYOBIN1X6)
    public String getZtysuuriyouyobin1x6() {
        return ztysuuriyouyobin1x6;
    }

    public void setZtysuuriyouyobin1x6(String pZtysuuriyouyobin1x6) {
        ztysuuriyouyobin1x6 = pZtysuuriyouyobin1x6;
    }

    private String ztyhrimngkizktkykpmenhyj;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYHRIMNGKIZKTKYKPMENHYJ)
    public String getZtyhrimngkizktkykpmenhyj() {
        return ztyhrimngkizktkykpmenhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtyhrimngkizktkykpmenhyj(String pZtyhrimngkizktkykpmenhyj) {
        ztyhrimngkizktkykpmenhyj = pZtyhrimngkizktkykpmenhyj;
    }

    private String ztymisyuustartym;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYMISYUUSTARTYM)
    public String getZtymisyuustartym() {
        return ztymisyuustartym;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZtymisyuustartym(String pZtymisyuustartym) {
        ztymisyuustartym = pZtymisyuustartym;
    }

    private String ztymisyuukaisuu;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYMISYUUKAISUU)
    public String getZtymisyuukaisuu() {
        return ztymisyuukaisuu;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtymisyuukaisuu(String pZtymisyuukaisuu) {
        ztymisyuukaisuu = pZtymisyuukaisuu;
    }

    private String ztyitjbrtkykkousnuktkarhyj;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYITJBRTKYKKOUSNUKTKARHYJ)
    public String getZtyitjbrtkykkousnuktkarhyj() {
        return ztyitjbrtkykkousnuktkarhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtyitjbrtkykkousnuktkarhyj(String pZtyitjbrtkykkousnuktkarhyj) {
        ztyitjbrtkykkousnuktkarhyj = pZtyitjbrtkykkousnuktkarhyj;
    }

    private Long ztygyousekihyoujis;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYGYOUSEKIHYOUJIS)
    public Long getZtygyousekihyoujis() {
        return ztygyousekihyoujis;
    }

    public void setZtygyousekihyoujis(Long pZtygyousekihyoujis) {
        ztygyousekihyoujis = pZtygyousekihyoujis;
    }

    private Long ztysykykgyusekihyjs;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSYKYKGYUSEKIHYJS)
    public Long getZtysykykgyusekihyjs() {
        return ztysykykgyusekihyjs;
    }

    public void setZtysykykgyusekihyjs(Long pZtysykykgyusekihyjs) {
        ztysykykgyusekihyjs = pZtysykykgyusekihyjs;
    }

    private Long ztytenkangyousekihyoujis;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYTENKANGYOUSEKIHYOUJIS)
    public Long getZtytenkangyousekihyoujis() {
        return ztytenkangyousekihyoujis;
    }

    public void setZtytenkangyousekihyoujis(Long pZtytenkangyousekihyoujis) {
        ztytenkangyousekihyoujis = pZtytenkangyousekihyoujis;
    }

    private Long ztytnknteikigyousekihyjs;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYTNKNTEIKIGYOUSEKIHYJS)
    public Long getZtytnknteikigyousekihyjs() {
        return ztytnknteikigyousekihyjs;
    }

    public void setZtytnknteikigyousekihyjs(Long pZtytnknteikigyousekihyjs) {
        ztytnknteikigyousekihyjs = pZtytnknteikigyousekihyjs;
    }

    private Long ztytnkndpbbngyuskhyjs;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYTNKNDPBBNGYUSKHYJS)
    public Long getZtytnkndpbbngyuskhyjs() {
        return ztytnkndpbbngyuskhyjs;
    }

    public void setZtytnkndpbbngyuskhyjs(Long pZtytnkndpbbngyuskhyjs) {
        ztytnkndpbbngyuskhyjs = pZtytnkndpbbngyuskhyjs;
    }

    private String ztykykjyoutai;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYKYKJYOUTAI)
    public String getZtykykjyoutai() {
        return ztykykjyoutai;
    }

    public void setZtykykjyoutai(String pZtykykjyoutai) {
        ztykykjyoutai = pZtykykjyoutai;
    }

    private String ztypmenhukakbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYPMENHUKAKBN)
    public String getZtypmenhukakbn() {
        return ztypmenhukakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtypmenhukakbn(String pZtypmenhukakbn) {
        ztypmenhukakbn = pZtypmenhukakbn;
    }

    private String ztykousinkbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYKOUSINKBN)
    public String getZtykousinkbn() {
        return ztykousinkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtykousinkbn(String pZtykousinkbn) {
        ztykousinkbn = pZtykousinkbn;
    }

    private String ztymankiyoteikbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYMANKIYOTEIKBN)
    public String getZtymankiyoteikbn() {
        return ztymankiyoteikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtymankiyoteikbn(String pZtymankiyoteikbn) {
        ztymankiyoteikbn = pZtymankiyoteikbn;
    }

    private String ztysykyktikmnkyoteikbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSYKYKTIKMNKYOTEIKBN)
    public String getZtysykyktikmnkyoteikbn() {
        return ztysykyktikmnkyoteikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtysykyktikmnkyoteikbn(String pZtysykyktikmnkyoteikbn) {
        ztysykyktikmnkyoteikbn = pZtysykyktikmnkyoteikbn;
    }

    private String ztytnknsykykkhnmnkytikbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYTNKNSYKYKKHNMNKYTIKBN)
    public String getZtytnknsykykkhnmnkytikbn() {
        return ztytnknsykykkhnmnkytikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtytnknsykykkhnmnkytikbn(String pZtytnknsykykkhnmnkytikbn) {
        ztytnknsykykkhnmnkytikbn = pZtytnknsykykkhnmnkytikbn;
    }

    private String ztytnknsykyktikmnkytikbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYTNKNSYKYKTIKMNKYTIKBN)
    public String getZtytnknsykyktikmnkytikbn() {
        return ztytnknsykyktikmnkytikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtytnknsykyktikmnkytikbn(String pZtytnknsykyktikmnkytikbn) {
        ztytnknsykyktikmnkytikbn = pZtytnknsykyktikmnkytikbn;
    }

    private String ztytenkanteikimankiyoteikbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYTENKANTEIKIMANKIYOTEIKBN)
    public String getZtytenkanteikimankiyoteikbn() {
        return ztytenkanteikimankiyoteikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtytenkanteikimankiyoteikbn(String pZtytenkanteikimankiyoteikbn) {
        ztytenkanteikimankiyoteikbn = pZtytenkanteikimankiyoteikbn;
    }

    private String ztyszoumankiyoteikbnx1;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSZOUMANKIYOTEIKBNX1)
    public String getZtyszoumankiyoteikbnx1() {
        return ztyszoumankiyoteikbnx1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtyszoumankiyoteikbnx1(String pZtyszoumankiyoteikbnx1) {
        ztyszoumankiyoteikbnx1 = pZtyszoumankiyoteikbnx1;
    }

    private String ztyszoumankiyoteikbnx2;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSZOUMANKIYOTEIKBNX2)
    public String getZtyszoumankiyoteikbnx2() {
        return ztyszoumankiyoteikbnx2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtyszoumankiyoteikbnx2(String pZtyszoumankiyoteikbnx2) {
        ztyszoumankiyoteikbnx2 = pZtyszoumankiyoteikbnx2;
    }

    private String ztyvestingmankiyoteikbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYVESTINGMANKIYOTEIKBN)
    public String getZtyvestingmankiyoteikbn() {
        return ztyvestingmankiyoteikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtyvestingmankiyoteikbn(String pZtyvestingmankiyoteikbn) {
        ztyvestingmankiyoteikbn = pZtyvestingmankiyoteikbn;
    }

    private String ztyvkeisanhyouji;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYVKEISANHYOUJI)
    public String getZtyvkeisanhyouji() {
        return ztyvkeisanhyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtyvkeisanhyouji(String pZtyvkeisanhyouji) {
        ztyvkeisanhyouji = pZtyvkeisanhyouji;
    }

    private String ztytoukisinkeiyakuhyouji;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYTOUKISINKEIYAKUHYOUJI)
    public String getZtytoukisinkeiyakuhyouji() {
        return ztytoukisinkeiyakuhyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtytoukisinkeiyakuhyouji(String pZtytoukisinkeiyakuhyouji) {
        ztytoukisinkeiyakuhyouji = pZtytoukisinkeiyakuhyouji;
    }

    private String ztysykykhokenhoutekiyouhyj;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSYKYKHOKENHOUTEKIYOUHYJ)
    public String getZtysykykhokenhoutekiyouhyj() {
        return ztysykykhokenhoutekiyouhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtysykykhokenhoutekiyouhyj(String pZtysykykhokenhoutekiyouhyj) {
        ztysykykhokenhoutekiyouhyj = pZtysykykhokenhoutekiyouhyj;
    }

    private String ztytokuteijyoutaihushrhyj;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYTOKUTEIJYOUTAIHUSHRHYJ)
    public String getZtytokuteijyoutaihushrhyj() {
        return ztytokuteijyoutaihushrhyj;
    }

    public void setZtytokuteijyoutaihushrhyj(String pZtytokuteijyoutaihushrhyj) {
        ztytokuteijyoutaihushrhyj = pZtytokuteijyoutaihushrhyj;
    }

    private String ztyytirrthndsysnmnskaisuu;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYYTIRRTHNDSYSNMNSKAISUU)
    public String getZtyytirrthndsysnmnskaisuu() {
        return ztyytirrthndsysnmnskaisuu;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtyytirrthndsysnmnskaisuu(String pZtyytirrthndsysnmnskaisuu) {
        ztyytirrthndsysnmnskaisuu = pZtyytirrthndsysnmnskaisuu;
    }

    private String ztysuuriyouyobin3;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSUURIYOUYOBIN3)
    public String getZtysuuriyouyobin3() {
        return ztysuuriyouyobin3;
    }

    public void setZtysuuriyouyobin3(String pZtysuuriyouyobin3) {
        ztysuuriyouyobin3 = pZtysuuriyouyobin3;
    }

    private String ztysuuriyouyobin11;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSUURIYOUYOBIN11)
    public String getZtysuuriyouyobin11() {
        return ztysuuriyouyobin11;
    }

    public void setZtysuuriyouyobin11(String pZtysuuriyouyobin11) {
        ztysuuriyouyobin11 = pZtysuuriyouyobin11;
    }

    private Long ztywnasigoukeitenkankakaku;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYWNASIGOUKEITENKANKAKAKU)
    public Long getZtywnasigoukeitenkankakaku() {
        return ztywnasigoukeitenkankakaku;
    }

    public void setZtywnasigoukeitenkankakaku(Long pZtywnasigoukeitenkankakaku) {
        ztywnasigoukeitenkankakaku = pZtywnasigoukeitenkankakaku;
    }

    private Long ztyyobin11;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYYOBIN11)
    public Long getZtyyobin11() {
        return ztyyobin11;
    }

    public void setZtyyobin11(Long pZtyyobin11) {
        ztyyobin11 = pZtyyobin11;
    }

    private Long ztyyobin11x2;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYYOBIN11X2)
    public Long getZtyyobin11x2() {
        return ztyyobin11x2;
    }

    public void setZtyyobin11x2(Long pZtyyobin11x2) {
        ztyyobin11x2 = pZtyyobin11x2;
    }

    private Long ztyyobin11x3;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYYOBIN11X3)
    public Long getZtyyobin11x3() {
        return ztyyobin11x3;
    }

    public void setZtyyobin11x3(Long pZtyyobin11x3) {
        ztyyobin11x3 = pZtyyobin11x3;
    }

    private Long ztytukibaraikansantokujyoup;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYTUKIBARAIKANSANTOKUJYOUP)
    public Long getZtytukibaraikansantokujyoup() {
        return ztytukibaraikansantokujyoup;
    }

    public void setZtytukibaraikansantokujyoup(Long pZtytukibaraikansantokujyoup) {
        ztytukibaraikansantokujyoup = pZtytukibaraikansantokujyoup;
    }

    private String ztytnkngkykkssnkijyuym;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYTNKNGKYKKSSNKIJYUYM)
    public String getZtytnkngkykkssnkijyuym() {
        return ztytnkngkykkssnkijyuym;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZtytnkngkykkssnkijyuym(String pZtytnkngkykkssnkijyuym) {
        ztytnkngkykkssnkijyuym = pZtytnkngkykkssnkijyuym;
    }

    private String ztysaiteihosyouhyouji;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSAITEIHOSYOUHYOUJI)
    public String getZtysaiteihosyouhyouji() {
        return ztysaiteihosyouhyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtysaiteihosyouhyouji(String pZtysaiteihosyouhyouji) {
        ztysaiteihosyouhyouji = pZtysaiteihosyouhyouji;
    }

    private String ztysuuriyouyobin8x2;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSUURIYOUYOBIN8X2)
    public String getZtysuuriyouyobin8x2() {
        return ztysuuriyouyobin8x2;
    }

    public void setZtysuuriyouyobin8x2(String pZtysuuriyouyobin8x2) {
        ztysuuriyouyobin8x2 = pZtysuuriyouyobin8x2;
    }

    private String ztysuuriyouyobin14;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSUURIYOUYOBIN14)
    public String getZtysuuriyouyobin14() {
        return ztysuuriyouyobin14;
    }

    public void setZtysuuriyouyobin14(String pZtysuuriyouyobin14) {
        ztysuuriyouyobin14 = pZtysuuriyouyobin14;
    }

    private String ztyhrimngtkykphrkkaisuukbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYHRIMNGTKYKPHRKKAISUUKBN)
    public String getZtyhrimngtkykphrkkaisuukbn() {
        return ztyhrimngtkykphrkkaisuukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtyhrimngtkykphrkkaisuukbn(String pZtyhrimngtkykphrkkaisuukbn) {
        ztyhrimngtkykphrkkaisuukbn = pZtyhrimngtkykphrkkaisuukbn;
    }

    private String ztyhrimngtkykphrkkirkbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYHRIMNGTKYKPHRKKIRKBN)
    public String getZtyhrimngtkykphrkkirkbn() {
        return ztyhrimngtkykphrkkirkbn;
    }

    public void setZtyhrimngtkykphrkkirkbn(String pZtyhrimngtkykphrkkirkbn) {
        ztyhrimngtkykphrkkirkbn = pZtyhrimngtkykphrkkirkbn;
    }

    private String ztyhrimngtkykpryurtkbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYHRIMNGTKYKPRYURTKBN)
    public String getZtyhrimngtkykpryurtkbn() {
        return ztyhrimngtkykpryurtkbn;
    }

    public void setZtyhrimngtkykpryurtkbn(String pZtyhrimngtkykpryurtkbn) {
        ztyhrimngtkykpryurtkbn = pZtyhrimngtkykpryurtkbn;
    }

    private String ztyyobiv13;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYYOBIV13)
    public String getZtyyobiv13() {
        return ztyyobiv13;
    }

    public void setZtyyobiv13(String pZtyyobiv13) {
        ztyyobiv13 = pZtyyobiv13;
    }

    private Long ztyidoujisaiteihosyoukngk;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYIDOUJISAITEIHOSYOUKNGK)
    public Long getZtyidoujisaiteihosyoukngk() {
        return ztyidoujisaiteihosyoukngk;
    }

    public void setZtyidoujisaiteihosyoukngk(Long pZtyidoujisaiteihosyoukngk) {
        ztyidoujisaiteihosyoukngk = pZtyidoujisaiteihosyoukngk;
    }

    private Long ztyidoujisaiteihosyoucost;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYIDOUJISAITEIHOSYOUCOST)
    public Long getZtyidoujisaiteihosyoucost() {
        return ztyidoujisaiteihosyoucost;
    }

    public void setZtyidoujisaiteihosyoucost(Long pZtyidoujisaiteihosyoucost) {
        ztyidoujisaiteihosyoucost = pZtyidoujisaiteihosyoucost;
    }

    private Long ztysinhokenfundtumitatekin;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSINHOKENFUNDTUMITATEKIN)
    public Long getZtysinhokenfundtumitatekin() {
        return ztysinhokenfundtumitatekin;
    }

    public void setZtysinhokenfundtumitatekin(Long pZtysinhokenfundtumitatekin) {
        ztysinhokenfundtumitatekin = pZtysinhokenfundtumitatekin;
    }

    private Long ztymsyuptusshkgkaiykhnrikn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYMSYUPTUSSHKGKAIYKHNRIKN)
    public Long getZtymsyuptusshkgkaiykhnrikn() {
        return ztymsyuptusshkgkaiykhnrikn;
    }

    public void setZtymsyuptusshkgkaiykhnrikn(Long pZtymsyuptusshkgkaiykhnrikn) {
        ztymsyuptusshkgkaiykhnrikn = pZtymsyuptusshkgkaiykhnrikn;
    }

    private Long ztyrrthndugtnkgetumatuv;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYRRTHNDUGTNKGETUMATUV)
    public Long getZtyrrthndugtnkgetumatuv() {
        return ztyrrthndugtnkgetumatuv;
    }

    public void setZtyrrthndugtnkgetumatuv(Long pZtyrrthndugtnkgetumatuv) {
        ztyrrthndugtnkgetumatuv = pZtyrrthndugtnkgetumatuv;
    }

    private Long ztyrrthndnksaiteihosyonkgns;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYRRTHNDNKSAITEIHOSYONKGNS)
    public Long getZtyrrthndnksaiteihosyonkgns() {
        return ztyrrthndnksaiteihosyonkgns;
    }

    public void setZtyrrthndnksaiteihosyonkgns(Long pZtyrrthndnksaiteihosyonkgns) {
        ztyrrthndnksaiteihosyonkgns = pZtyrrthndnksaiteihosyonkgns;
    }

    private Long ztyrrthendougatanksibous;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYRRTHENDOUGATANKSIBOUS)
    public Long getZtyrrthendougatanksibous() {
        return ztyrrthendougatanksibous;
    }

    public void setZtyrrthendougatanksibous(Long pZtyrrthendougatanksibous) {
        ztyrrthendougatanksibous = pZtyrrthendougatanksibous;
    }

    private String ztyalmyousohutomeisyoukbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYALMYOUSOHUTOMEISYOUKBN)
    public String getZtyalmyousohutomeisyoukbn() {
        return ztyalmyousohutomeisyoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyalmyousohutomeisyoukbn(String pZtyalmyousohutomeisyoukbn) {
        ztyalmyousohutomeisyoukbn = pZtyalmyousohutomeisyoukbn;
    }

    private String ztysnkyksoftmeisyoukbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSNKYKSOFTMEISYOUKBN)
    public String getZtysnkyksoftmeisyoukbn() {
        return ztysnkyksoftmeisyoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtysnkyksoftmeisyoukbn(String pZtysnkyksoftmeisyoukbn) {
        ztysnkyksoftmeisyoukbn = pZtysnkyksoftmeisyoukbn;
    }

    private String ztysoftmeisyoukbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSOFTMEISYOUKBN)
    public String getZtysoftmeisyoukbn() {
        return ztysoftmeisyoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtysoftmeisyoukbn(String pZtysoftmeisyoukbn) {
        ztysoftmeisyoukbn = pZtysoftmeisyoukbn;
    }

    private String ztykykjitokujyouarihyj;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYKYKJITOKUJYOUARIHYJ)
    public String getZtykykjitokujyouarihyj() {
        return ztykykjitokujyouarihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtykykjitokujyouarihyj(String pZtykykjitokujyouarihyj) {
        ztykykjitokujyouarihyj = pZtykykjitokujyouarihyj;
    }

    private String ztybnkttnknkbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYBNKTTNKNKBN)
    public String getZtybnkttnknkbn() {
        return ztybnkttnknkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtybnkttnknkbn(String pZtybnkttnknkbn) {
        ztybnkttnknkbn = pZtybnkttnknkbn;
    }

    private String ztytenkanminaosikbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYTENKANMINAOSIKBN)
    public String getZtytenkanminaosikbn() {
        return ztytenkanminaosikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtytenkanminaosikbn(String pZtytenkanminaosikbn) {
        ztytenkanminaosikbn = pZtytenkanminaosikbn;
    }

    private String ztysoujikeitenkankbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSOUJIKEITENKANKBN)
    public String getZtysoujikeitenkankbn() {
        return ztysoujikeitenkankbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtysoujikeitenkankbn(String pZtysoujikeitenkankbn) {
        ztysoujikeitenkankbn = pZtysoujikeitenkankbn;
    }

    private String ztynenkinkaisinendo;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYNENKINKAISINENDO)
    public String getZtynenkinkaisinendo() {
        return ztynenkinkaisinendo;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZtynenkinkaisinendo(String pZtynenkinkaisinendo) {
        ztynenkinkaisinendo = pZtynenkinkaisinendo;
    }

    private String ztynenkingatakbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYNENKINGATAKBN)
    public String getZtynenkingatakbn() {
        return ztynenkingatakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtynenkingatakbn(String pZtynenkingatakbn) {
        ztynenkingatakbn = pZtynenkingatakbn;
    }

    private String ztynknshry;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYNKNSHRY)
    public String getZtynknshry() {
        return ztynknshry;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtynknshry(String pZtynknshry) {
        ztynknshry = pZtynknshry;
    }

    private String ztyheiyoubaraikeiyakukbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYHEIYOUBARAIKEIYAKUKBN)
    public String getZtyheiyoubaraikeiyakukbn() {
        return ztyheiyoubaraikeiyakukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtyheiyoubaraikeiyakukbn(String pZtyheiyoubaraikeiyakukbn) {
        ztyheiyoubaraikeiyakukbn = pZtyheiyoubaraikeiyakukbn;
    }

    private String ztynenkinmaruteihukakbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYNENKINMARUTEIHUKAKBN)
    public String getZtynenkinmaruteihukakbn() {
        return ztynenkinmaruteihukakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtynenkinmaruteihukakbn(String pZtynenkinmaruteihukakbn) {
        ztynenkinmaruteihukakbn = pZtynenkinmaruteihukakbn;
    }

    private String ztysinseizonmrtiarihyj;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSINSEIZONMRTIARIHYJ)
    public String getZtysinseizonmrtiarihyj() {
        return ztysinseizonmrtiarihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtysinseizonmrtiarihyj(String pZtysinseizonmrtiarihyj) {
        ztysinseizonmrtiarihyj = pZtysinseizonmrtiarihyj;
    }

    private String ztysnkykyouibokijyukbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSNKYKYOUIBOKIJYUKBN)
    public String getZtysnkykyouibokijyukbn() {
        return ztysnkykyouibokijyukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtysnkykyouibokijyukbn(String pZtysnkykyouibokijyukbn) {
        ztysnkykyouibokijyukbn = pZtysnkykyouibokijyukbn;
    }

    private String ztytokusitujyuusitusetkbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYTOKUSITUJYUUSITUSETKBN)
    public String getZtytokusitujyuusitusetkbn() {
        return ztytokusitujyuusitusetkbn;
    }

    public void setZtytokusitujyuusitusetkbn(String pZtytokusitujyuusitusetkbn) {
        ztytokusitujyuusitusetkbn = pZtytokusitujyuusitusetkbn;
    }

    private String ztysiktsyuknbyugnhsyunshyj;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSIKTSYUKNBYUGNHSYUNSHYJ)
    public String getZtysiktsyuknbyugnhsyunshyj() {
        return ztysiktsyuknbyugnhsyunshyj;
    }

    public void setZtysiktsyuknbyugnhsyunshyj(String pZtysiktsyuknbyugnhsyunshyj) {
        ztysiktsyuknbyugnhsyunshyj = pZtysiktsyuknbyugnhsyunshyj;
    }

    private String ztypmensugugtganhsyunshyj;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYPMENSUGUGTGANHSYUNSHYJ)
    public String getZtypmensugugtganhsyunshyj() {
        return ztypmensugugtganhsyunshyj;
    }

    public void setZtypmensugugtganhsyunshyj(String pZtypmensugugtganhsyunshyj) {
        ztypmensugugtganhsyunshyj = pZtypmensugugtganhsyunshyj;
    }

    private String ztytkykgyousekihyjszerohyj;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYTKYKGYOUSEKIHYJSZEROHYJ)
    public String getZtytkykgyousekihyjszerohyj() {
        return ztytkykgyousekihyjszerohyj;
    }

    public void setZtytkykgyousekihyjszerohyj(String pZtytkykgyousekihyjszerohyj) {
        ztytkykgyousekihyjszerohyj = pZtytkykgyousekihyjszerohyj;
    }

    private String ztysuuriyouyobin7;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSUURIYOUYOBIN7)
    public String getZtysuuriyouyobin7() {
        return ztysuuriyouyobin7;
    }

    public void setZtysuuriyouyobin7(String pZtysuuriyouyobin7) {
        ztysuuriyouyobin7 = pZtysuuriyouyobin7;
    }

    private String ztysyussaikeitaikbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSYUSSAIKEITAIKBN)
    public String getZtysyussaikeitaikbn() {
        return ztysyussaikeitaikbn;
    }

    public void setZtysyussaikeitaikbn(String pZtysyussaikeitaikbn) {
        ztysyussaikeitaikbn = pZtysyussaikeitaikbn;
    }

    private String ztyyobiv6;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYYOBIV6)
    public String getZtyyobiv6() {
        return ztyyobiv6;
    }

    public void setZtyyobiv6(String pZtyyobiv6) {
        ztyyobiv6 = pZtyyobiv6;
    }

    private String ztybosyuukeitaikbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYBOSYUUKEITAIKBN)
    public String getZtybosyuukeitaikbn() {
        return ztybosyuukeitaikbn;
    }

    public void setZtybosyuukeitaikbn(String pZtybosyuukeitaikbn) {
        ztybosyuukeitaikbn = pZtybosyuukeitaikbn;
    }

    private String ztyaatukaisosikicd;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYAATUKAISOSIKICD)
    public String getZtyaatukaisosikicd() {
        return ztyaatukaisosikicd;
    }

    public void setZtyaatukaisosikicd(String pZtyaatukaisosikicd) {
        ztyaatukaisosikicd = pZtyaatukaisosikicd;
    }

    private String ztyaatukaikojincd;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYAATUKAIKOJINCD)
    public String getZtyaatukaikojincd() {
        return ztyaatukaikojincd;
    }

    public void setZtyaatukaikojincd(String pZtyaatukaikojincd) {
        ztyaatukaikojincd = pZtyaatukaikojincd;
    }

    private String ztybsydrtencd;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYBSYDRTENCD)
    public String getZtybsydrtencd() {
        return ztybsydrtencd;
    }

    public void setZtybsydrtencd(String pZtybsydrtencd) {
        ztybsydrtencd = pZtybsydrtencd;
    }

    private String ztycifcd;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYCIFCD)
    public String getZtycifcd() {
        return ztycifcd;
    }

    public void setZtycifcd(String pZtycifcd) {
        ztycifcd = pZtycifcd;
    }

    private String ztysuuriyouyobiv8;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSUURIYOUYOBIV8)
    public String getZtysuuriyouyobiv8() {
        return ztysuuriyouyobiv8;
    }

    public void setZtysuuriyouyobiv8(String pZtysuuriyouyobiv8) {
        ztysuuriyouyobiv8 = pZtysuuriyouyobiv8;
    }

    private String ztysinsakbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSINSAKBN)
    public String getZtysinsakbn() {
        return ztysinsakbn;
    }

    public void setZtysinsakbn(String pZtysinsakbn) {
        ztysinsakbn = pZtysinsakbn;
    }

    private String ztydai2hihokensyasinsakbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYDAI2HIHOKENSYASINSAKBN)
    public String getZtydai2hihokensyasinsakbn() {
        return ztydai2hihokensyasinsakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtydai2hihokensyasinsakbn(String pZtydai2hihokensyasinsakbn) {
        ztydai2hihokensyasinsakbn = pZtydai2hihokensyasinsakbn;
    }

    private String ztytoukeiyousinsakbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYTOUKEIYOUSINSAKBN)
    public String getZtytoukeiyousinsakbn() {
        return ztytoukeiyousinsakbn;
    }

    public void setZtytoukeiyousinsakbn(String pZtytoukeiyousinsakbn) {
        ztytoukeiyousinsakbn = pZtytoukeiyousinsakbn;
    }

    private String ztydai2toukeiyousinsakbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYDAI2TOUKEIYOUSINSAKBN)
    public String getZtydai2toukeiyousinsakbn() {
        return ztydai2toukeiyousinsakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtydai2toukeiyousinsakbn(String pZtydai2toukeiyousinsakbn) {
        ztydai2toukeiyousinsakbn = pZtydai2toukeiyousinsakbn;
    }

    private String ztyketteikijyunkanwakbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYKETTEIKIJYUNKANWAKBN)
    public String getZtyketteikijyunkanwakbn() {
        return ztyketteikijyunkanwakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtyketteikijyunkanwakbn(String pZtyketteikijyunkanwakbn) {
        ztyketteikijyunkanwakbn = pZtyketteikijyunkanwakbn;
    }

    private String ztykihonsibouhyoukbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYKIHONSIBOUHYOUKBN)
    public String getZtykihonsibouhyoukbn() {
        return ztykihonsibouhyoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtykihonsibouhyoukbn(String pZtykihonsibouhyoukbn) {
        ztykihonsibouhyoukbn = pZtykihonsibouhyoukbn;
    }

    private String ztyteikisibouhyoukbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYTEIKISIBOUHYOUKBN)
    public String getZtyteikisibouhyoukbn() {
        return ztyteikisibouhyoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyteikisibouhyoukbn(String pZtyteikisibouhyoukbn) {
        ztyteikisibouhyoukbn = pZtyteikisibouhyoukbn;
    }

    private String ztysonotasibouhyoukbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSONOTASIBOUHYOUKBN)
    public String getZtysonotasibouhyoukbn() {
        return ztysonotasibouhyoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtysonotasibouhyoukbn(String pZtysonotasibouhyoukbn) {
        ztysonotasibouhyoukbn = pZtysonotasibouhyoukbn;
    }

    private String ztymrarihyj;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYMRARIHYJ)
    public String getZtymrarihyj() {
        return ztymrarihyj;
    }

    public void setZtymrarihyj(String pZtymrarihyj) {
        ztymrarihyj = pZtymrarihyj;
    }

    private String ztysentakujyouhouarihyouji;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSENTAKUJYOUHOUARIHYOUJI)
    public String getZtysentakujyouhouarihyouji() {
        return ztysentakujyouhouarihyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtysentakujyouhouarihyouji(String pZtysentakujyouhouarihyouji) {
        ztysentakujyouhouarihyouji = pZtysentakujyouhouarihyouji;
    }

    private String ztydugktnknsntkhuhukbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYDUGKTNKNSNTKHUHUKBN)
    public String getZtydugktnknsntkhuhukbn() {
        return ztydugktnknsntkhuhukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtydugktnknsntkhuhukbn(String pZtydugktnknsntkhuhukbn) {
        ztydugktnknsntkhuhukbn = pZtydugktnknsntkhuhukbn;
    }

    private String ztygengakutenkankykhyj;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYGENGAKUTENKANKYKHYJ)
    public String getZtygengakutenkankykhyj() {
        return ztygengakutenkankykhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtygengakutenkankykhyj(String pZtygengakutenkankykhyj) {
        ztygengakutenkankykhyj = pZtygengakutenkankykhyj;
    }

    private String ztysykgycd;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSYKGYCD)
    public String getZtysykgycd() {
        return ztysykgycd;
    }

    public void setZtysykgycd(String pZtysykgycd) {
        ztysykgycd = pZtysykgycd;
    }

    private String ztyjidoukousinkykkanyuuymd;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYJIDOUKOUSINKYKKANYUUYMD)
    public String getZtyjidoukousinkykkanyuuymd() {
        return ztyjidoukousinkykkanyuuymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtyjidoukousinkykkanyuuymd(String pZtyjidoukousinkykkanyuuymd) {
        ztyjidoukousinkykkanyuuymd = pZtyjidoukousinkykkanyuuymd;
    }

    private String ztysaikohtnknkykkykymd;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSAIKOHTNKNKYKKYKYMD)
    public String getZtysaikohtnknkykkykymd() {
        return ztysaikohtnknkykkykymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtysaikohtnknkykkykymd(String pZtysaikohtnknkykkykymd) {
        ztysaikohtnknkykkykymd = pZtysaikohtnknkykkykymd;
    }

    private String ztykousinmaesykyksburtkbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYKOUSINMAESYKYKSBURTKBN)
    public String getZtykousinmaesykyksburtkbn() {
        return ztykousinmaesykyksburtkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtykousinmaesykyksburtkbn(String pZtykousinmaesykyksburtkbn) {
        ztykousinmaesykyksburtkbn = pZtykousinmaesykyksburtkbn;
    }

    private String ztyhjnkykhyj;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYHJNKYKHYJ)
    public String getZtyhjnkykhyj() {
        return ztyhjnkykhyj;
    }

    public void setZtyhjnkykhyj(String pZtyhjnkykhyj) {
        ztyhjnkykhyj = pZtyhjnkykhyj;
    }

    private String ztyanniskcd;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYANNISKCD)
    public String getZtyanniskcd() {
        return ztyanniskcd;
    }

    public void setZtyanniskcd(String pZtyanniskcd) {
        ztyanniskcd = pZtyanniskcd;
    }

    private String ztyhjncd;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYHJNCD)
    public String getZtyhjncd() {
        return ztyhjncd;
    }

    public void setZtyhjncd(String pZtyhjncd) {
        ztyhjncd = pZtyhjncd;
    }

    private String ztyhjnjigyosyocd;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYHJNJIGYOSYOCD)
    public String getZtyhjnjigyosyocd() {
        return ztyhjnjigyosyocd;
    }

    public void setZtyhjnjigyosyocd(String pZtyhjnjigyosyocd) {
        ztyhjnjigyosyocd = pZtyhjnjigyosyocd;
    }

    private String ztysaihokenno;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSAIHOKENNO)
    public String getZtysaihokenno() {
        return ztysaihokenno;
    }

    @Padding(mode = "left", padChar = '0', length = 5)
    public void setZtysaihokenno(String pZtysaihokenno) {
        ztysaihokenno = pZtysaihokenno;
    }

    private String ztydakuhikettikekkacd;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYDAKUHIKETTIKEKKACD)
    public String getZtydakuhikettikekkacd() {
        return ztydakuhikettikekkacd;
    }

    public void setZtydakuhikettikekkacd(String pZtydakuhikettikekkacd) {
        ztydakuhikettikekkacd = pZtydakuhikettikekkacd;
    }

    private String ztydai2dakuhiketteikekkacd;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYDAI2DAKUHIKETTEIKEKKACD)
    public String getZtydai2dakuhiketteikekkacd() {
        return ztydai2dakuhiketteikekkacd;
    }

    public void setZtydai2dakuhiketteikekkacd(String pZtydai2dakuhiketteikekkacd) {
        ztydai2dakuhiketteikekkacd = pZtydai2dakuhiketteikekkacd;
    }

    private String ztypmenkbnv2;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYPMENKBNV2)
    public String getZtypmenkbnv2() {
        return ztypmenkbnv2;
    }

    public void setZtypmenkbnv2(String pZtypmenkbnv2) {
        ztypmenkbnv2 = pZtypmenkbnv2;
    }

    private Long ztysiboukyuuhukin;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSIBOUKYUUHUKIN)
    public Long getZtysiboukyuuhukin() {
        return ztysiboukyuuhukin;
    }

    public void setZtysiboukyuuhukin(Long pZtysiboukyuuhukin) {
        ztysiboukyuuhukin = pZtysiboukyuuhukin;
    }

    private String ztyjyudthumeharaitkykhkhyj;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYJYUDTHUMEHARAITKYKHKHYJ)
    public String getZtyjyudthumeharaitkykhkhyj() {
        return ztyjyudthumeharaitkykhkhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtyjyudthumeharaitkykhkhyj(String pZtyjyudthumeharaitkykhkhyj) {
        ztyjyudthumeharaitkykhkhyj = pZtyjyudthumeharaitkykhkhyj;
    }

    private String ztyhaitoukbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYHAITOUKBN)
    public String getZtyhaitoukbn() {
        return ztyhaitoukbn;
    }

    public void setZtyhaitoukbn(String pZtyhaitoukbn) {
        ztyhaitoukbn = pZtyhaitoukbn;
    }

    private String ztyhhknnentysihyj;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYHHKNNENTYSIHYJ)
    public String getZtyhhknnentysihyj() {
        return ztyhhknnentysihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtyhhknnentysihyj(String pZtyhhknnentysihyj) {
        ztyhhknnentysihyj = pZtyhhknnentysihyj;
    }

    private String ztydai2hhknnentysihyj;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYDAI2HHKNNENTYSIHYJ)
    public String getZtydai2hhknnentysihyj() {
        return ztydai2hhknnentysihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtydai2hhknnentysihyj(String pZtydai2hhknnentysihyj) {
        ztydai2hhknnentysihyj = pZtydai2hhknnentysihyj;
    }

    private String ztykyksyaagetyouseihyj;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYKYKSYAAGETYOUSEIHYJ)
    public String getZtykyksyaagetyouseihyj() {
        return ztykyksyaagetyouseihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtykyksyaagetyouseihyj(String pZtykyksyaagetyouseihyj) {
        ztykyksyaagetyouseihyj = pZtykyksyaagetyouseihyj;
    }

    private String ztykituenkbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYKITUENKBN)
    public String getZtykituenkbn() {
        return ztykituenkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtykituenkbn(String pZtykituenkbn) {
        ztykituenkbn = pZtykituenkbn;
    }

    private String ztykituenhonsuu;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYKITUENHONSUU)
    public String getZtykituenhonsuu() {
        return ztykituenhonsuu;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtykituenhonsuu(String pZtykituenhonsuu) {
        ztykituenhonsuu = pZtykituenhonsuu;
    }

    private String ztymusentakukeiyakukbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYMUSENTAKUKEIYAKUKBN)
    public String getZtymusentakukeiyakukbn() {
        return ztymusentakukeiyakukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtymusentakukeiyakukbn(String pZtymusentakukeiyakukbn) {
        ztymusentakukeiyakukbn = pZtymusentakukeiyakukbn;
    }

    private String ztyyobiv6x2;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYYOBIV6X2)
    public String getZtyyobiv6x2() {
        return ztyyobiv6x2;
    }

    public void setZtyyobiv6x2(String pZtyyobiv6x2) {
        ztyyobiv6x2 = pZtyyobiv6x2;
    }

    private String ztylivingneedstkykarihyj;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYLIVINGNEEDSTKYKARIHYJ)
    public String getZtylivingneedstkykarihyj() {
        return ztylivingneedstkykarihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtylivingneedstkykarihyj(String pZtylivingneedstkykarihyj) {
        ztylivingneedstkykarihyj = pZtylivingneedstkykarihyj;
    }

    private String ztylivingneedssiharaihyouji;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYLIVINGNEEDSSIHARAIHYOUJI)
    public String getZtylivingneedssiharaihyouji() {
        return ztylivingneedssiharaihyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtylivingneedssiharaihyouji(String pZtylivingneedssiharaihyouji) {
        ztylivingneedssiharaihyouji = pZtylivingneedssiharaihyouji;
    }

    private String ztylnseikyuuymd;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYLNSEIKYUUYMD)
    public String getZtylnseikyuuymd() {
        return ztylnseikyuuymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtylnseikyuuymd(String pZtylnseikyuuymd) {
        ztylnseikyuuymd = pZtylnseikyuuymd;
    }

    private String ztylnshrgenincd;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYLNSHRGENINCD)
    public String getZtylnshrgenincd() {
        return ztylnshrgenincd;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZtylnshrgenincd(String pZtylnshrgenincd) {
        ztylnshrgenincd = pZtylnshrgenincd;
    }

    private String ztydakuhikettisyacd;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYDAKUHIKETTISYACD)
    public String getZtydakuhikettisyacd() {
        return ztydakuhikettisyacd;
    }

    public void setZtydakuhikettisyacd(String pZtydakuhikettisyacd) {
        ztydakuhikettisyacd = pZtydakuhikettisyacd;
    }

    private String ztydai2dakuhiketteisyacd;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYDAI2DAKUHIKETTEISYACD)
    public String getZtydai2dakuhiketteisyacd() {
        return ztydai2dakuhiketteisyacd;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtydai2dakuhiketteisyacd(String pZtydai2dakuhiketteisyacd) {
        ztydai2dakuhiketteisyacd = pZtydai2dakuhiketteisyacd;
    }

    private String ztygansapotokuyakuarihyouji;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYGANSAPOTOKUYAKUARIHYOUJI)
    public String getZtygansapotokuyakuarihyouji() {
        return ztygansapotokuyakuarihyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtygansapotokuyakuarihyouji(String pZtygansapotokuyakuarihyouji) {
        ztygansapotokuyakuarihyouji = pZtygansapotokuyakuarihyouji;
    }

    private String ztygnspshrhyj;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYGNSPSHRHYJ)
    public String getZtygnspshrhyj() {
        return ztygnspshrhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtygnspshrhyj(String pZtygnspshrhyj) {
        ztygnspshrhyj = pZtygnspshrhyj;
    }

    private String ztygansaposeikyuuymd;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYGANSAPOSEIKYUUYMD)
    public String getZtygansaposeikyuuymd() {
        return ztygansaposeikyuuymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtygansaposeikyuuymd(String pZtygansaposeikyuuymd) {
        ztygansaposeikyuuymd = pZtygansaposeikyuuymd;
    }

    private String ztygnspshrgenincd;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYGNSPSHRGENINCD)
    public String getZtygnspshrgenincd() {
        return ztygnspshrgenincd;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZtygnspshrgenincd(String pZtygnspshrgenincd) {
        ztygnspshrgenincd = pZtygnspshrgenincd;
    }

    private String ztyyobiv3x2;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYYOBIV3X2)
    public String getZtyyobiv3x2() {
        return ztyyobiv3x2;
    }

    public void setZtyyobiv3x2(String pZtyyobiv3x2) {
        ztyyobiv3x2 = pZtyyobiv3x2;
    }

    private String ztytargetmokuhyouritu;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYTARGETMOKUHYOURITU)
    public String getZtytargetmokuhyouritu() {
        return ztytargetmokuhyouritu;
    }

    public void setZtytargetmokuhyouritu(String pZtytargetmokuhyouritu) {
        ztytargetmokuhyouritu = pZtytargetmokuhyouritu;
    }

    private String ztyautoswitchmokuhyouritu;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYAUTOSWITCHMOKUHYOURITU)
    public String getZtyautoswitchmokuhyouritu() {
        return ztyautoswitchmokuhyouritu;
    }

    public void setZtyautoswitchmokuhyouritu(String pZtyautoswitchmokuhyouritu) {
        ztyautoswitchmokuhyouritu = pZtyautoswitchmokuhyouritu;
    }

    private String ztytumitatekinitenarihyj;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYTUMITATEKINITENARIHYJ)
    public String getZtytumitatekinitenarihyj() {
        return ztytumitatekinitenarihyj;
    }

    public void setZtytumitatekinitenarihyj(String pZtytumitatekinitenarihyj) {
        ztytumitatekinitenarihyj = pZtytumitatekinitenarihyj;
    }

    private String ztytumitatekinitenkaisuu;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYTUMITATEKINITENKAISUU)
    public String getZtytumitatekinitenkaisuu() {
        return ztytumitatekinitenkaisuu;
    }

    public void setZtytumitatekinitenkaisuu(String pZtytumitatekinitenkaisuu) {
        ztytumitatekinitenkaisuu = pZtytumitatekinitenkaisuu;
    }

    private String ztydatakanrino2;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYDATAKANRINO2)
    public String getZtydatakanrino2() {
        return ztydatakanrino2;
    }

    public void setZtydatakanrino2(String pZtydatakanrino2) {
        ztydatakanrino2 = pZtydatakanrino2;
    }

    private String ztydatakanrino3;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYDATAKANRINO3)
    public String getZtydatakanrino3() {
        return ztydatakanrino3;
    }

    public void setZtydatakanrino3(String pZtydatakanrino3) {
        ztydatakanrino3 = pZtydatakanrino3;
    }

    private String ztyknkuzusnzyrttekinendo;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYKNKUZUSNZYRTTEKINENDO)
    public String getZtyknkuzusnzyrttekinendo() {
        return ztyknkuzusnzyrttekinendo;
    }

    public void setZtyknkuzusnzyrttekinendo(String pZtyknkuzusnzyrttekinendo) {
        ztyknkuzusnzyrttekinendo = pZtyknkuzusnzyrttekinendo;
    }

    private String ztyknkuzusnzyrt;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYKNKUZUSNZYRT)
    public String getZtyknkuzusnzyrt() {
        return ztyknkuzusnzyrt;
    }

    public void setZtyknkuzusnzyrt(String pZtyknkuzusnzyrt) {
        ztyknkuzusnzyrt = pZtyknkuzusnzyrt;
    }

    private String ztyknkuzusnzyrtx2;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYKNKUZUSNZYRTX2)
    public String getZtyknkuzusnzyrtx2() {
        return ztyknkuzusnzyrtx2;
    }

    public void setZtyknkuzusnzyrtx2(String pZtyknkuzusnzyrtx2) {
        ztyknkuzusnzyrtx2 = pZtyknkuzusnzyrtx2;
    }

    private String ztyknkuzusnzyrtx3;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYKNKUZUSNZYRTX3)
    public String getZtyknkuzusnzyrtx3() {
        return ztyknkuzusnzyrtx3;
    }

    public void setZtyknkuzusnzyrtx3(String pZtyknkuzusnzyrtx3) {
        ztyknkuzusnzyrtx3 = pZtyknkuzusnzyrtx3;
    }

    private String ztysinkeiyakujiknkuzusnzyrt;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSINKEIYAKUJIKNKUZUSNZYRT)
    public String getZtysinkeiyakujiknkuzusnzyrt() {
        return ztysinkeiyakujiknkuzusnzyrt;
    }

    public void setZtysinkeiyakujiknkuzusnzyrt(String pZtysinkeiyakujiknkuzusnzyrt) {
        ztysinkeiyakujiknkuzusnzyrt = pZtysinkeiyakujiknkuzusnzyrt;
    }

    private String ztytenkanjiknkuzusnzyrt;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYTENKANJIKNKUZUSNZYRT)
    public String getZtytenkanjiknkuzusnzyrt() {
        return ztytenkanjiknkuzusnzyrt;
    }

    public void setZtytenkanjiknkuzusnzyrt(String pZtytenkanjiknkuzusnzyrt) {
        ztytenkanjiknkuzusnzyrt = pZtytenkanjiknkuzusnzyrt;
    }

    private String ztysinkeiyakujivithkhyouji;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSINKEIYAKUJIVITHKHYOUJI)
    public String getZtysinkeiyakujivithkhyouji() {
        return ztysinkeiyakujivithkhyouji;
    }

    public void setZtysinkeiyakujivithkhyouji(String pZtysinkeiyakujivithkhyouji) {
        ztysinkeiyakujivithkhyouji = pZtysinkeiyakujivithkhyouji;
    }

    private String ztykykjivithukusuukykhyj;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYKYKJIVITHUKUSUUKYKHYJ)
    public String getZtykykjivithukusuukykhyj() {
        return ztykykjivithukusuukykhyj;
    }

    public void setZtykykjivithukusuukykhyj(String pZtykykjivithukusuukykhyj) {
        ztykykjivithukusuukykhyj = pZtykykjivithukusuukykhyj;
    }

    private String ztysuuriyouyobin9x2;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSUURIYOUYOBIN9X2)
    public String getZtysuuriyouyobin9x2() {
        return ztysuuriyouyobin9x2;
    }

    public void setZtysuuriyouyobin9x2(String pZtysuuriyouyobin9x2) {
        ztysuuriyouyobin9x2 = pZtysuuriyouyobin9x2;
    }

    private String ztypwrbksidhitekiyouhyj;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYPWRBKSIDHITEKIYOUHYJ)
    public String getZtypwrbksidhitekiyouhyj() {
        return ztypwrbksidhitekiyouhyj;
    }

    public void setZtypwrbksidhitekiyouhyj(String pZtypwrbksidhitekiyouhyj) {
        ztypwrbksidhitekiyouhyj = pZtypwrbksidhitekiyouhyj;
    }

    private String ztysuuriyouyobin9;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSUURIYOUYOBIN9)
    public String getZtysuuriyouyobin9() {
        return ztysuuriyouyobin9;
    }

    public void setZtysuuriyouyobin9(String pZtysuuriyouyobin9) {
        ztysuuriyouyobin9 = pZtysuuriyouyobin9;
    }

    private String ztysuuriyouyobin10x7;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSUURIYOUYOBIN10X7)
    public String getZtysuuriyouyobin10x7() {
        return ztysuuriyouyobin10x7;
    }

    public void setZtysuuriyouyobin10x7(String pZtysuuriyouyobin10x7) {
        ztysuuriyouyobin10x7 = pZtysuuriyouyobin10x7;
    }

    private String ztysuuriyouyobin10x8;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSUURIYOUYOBIN10X8)
    public String getZtysuuriyouyobin10x8() {
        return ztysuuriyouyobin10x8;
    }

    public void setZtysuuriyouyobin10x8(String pZtysuuriyouyobin10x8) {
        ztysuuriyouyobin10x8 = pZtysuuriyouyobin10x8;
    }

    private String ztysuuriyouyobin10x9;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSUURIYOUYOBIN10X9)
    public String getZtysuuriyouyobin10x9() {
        return ztysuuriyouyobin10x9;
    }

    public void setZtysuuriyouyobin10x9(String pZtysuuriyouyobin10x9) {
        ztysuuriyouyobin10x9 = pZtysuuriyouyobin10x9;
    }

    private Long ztytumitatekinitenbubun;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYTUMITATEKINITENBUBUN)
    public Long getZtytumitatekinitenbubun() {
        return ztytumitatekinitenbubun;
    }

    public void setZtytumitatekinitenbubun(Long pZtytumitatekinitenbubun) {
        ztytumitatekinitenbubun = pZtytumitatekinitenbubun;
    }

    private Long ztysagakusknnjynbknzndk;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSAGAKUSKNNJYNBKNZNDK)
    public Long getZtysagakusknnjynbknzndk() {
        return ztysagakusknnjynbknzndk;
    }

    public void setZtysagakusknnjynbknzndk(Long pZtysagakusknnjynbknzndk) {
        ztysagakusknnjynbknzndk = pZtysagakusknnjynbknzndk;
    }

    private Long ztyyobin11x5;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYYOBIN11X5)
    public Long getZtyyobin11x5() {
        return ztyyobin11x5;
    }

    public void setZtyyobin11x5(Long pZtyyobin11x5) {
        ztyyobin11x5 = pZtyyobin11x5;
    }

    private Long ztyyobin11x6;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYYOBIN11X6)
    public Long getZtyyobin11x6() {
        return ztyyobin11x6;
    }

    public void setZtyyobin11x6(Long pZtyyobin11x6) {
        ztyyobin11x6 = pZtyyobin11x6;
    }

    private Long ztyyobin11x7;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYYOBIN11X7)
    public Long getZtyyobin11x7() {
        return ztyyobin11x7;
    }

    public void setZtyyobin11x7(Long pZtyyobin11x7) {
        ztyyobin11x7 = pZtyyobin11x7;
    }

    private Long ztyyobin11x8;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYYOBIN11X8)
    public Long getZtyyobin11x8() {
        return ztyyobin11x8;
    }

    public void setZtyyobin11x8(Long pZtyyobin11x8) {
        ztyyobin11x8 = pZtyyobin11x8;
    }

    private Long ztyyobin11x9;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYYOBIN11X9)
    public Long getZtyyobin11x9() {
        return ztyyobin11x9;
    }

    public void setZtyyobin11x9(Long pZtyyobin11x9) {
        ztyyobin11x9 = pZtyyobin11x9;
    }

    private Long ztyyobin11x10;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYYOBIN11X10)
    public Long getZtyyobin11x10() {
        return ztyyobin11x10;
    }

    public void setZtyyobin11x10(Long pZtyyobin11x10) {
        ztyyobin11x10 = pZtyyobin11x10;
    }

    private Long ztyyobin11x11;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYYOBIN11X11)
    public Long getZtyyobin11x11() {
        return ztyyobin11x11;
    }

    public void setZtyyobin11x11(Long pZtyyobin11x11) {
        ztyyobin11x11 = pZtyyobin11x11;
    }

    private Long ztyyobin11x12;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYYOBIN11X12)
    public Long getZtyyobin11x12() {
        return ztyyobin11x12;
    }

    public void setZtyyobin11x12(Long pZtyyobin11x12) {
        ztyyobin11x12 = pZtyyobin11x12;
    }

    private Long ztyyobin11x13;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYYOBIN11X13)
    public Long getZtyyobin11x13() {
        return ztyyobin11x13;
    }

    public void setZtyyobin11x13(Long pZtyyobin11x13) {
        ztyyobin11x13 = pZtyyobin11x13;
    }

    private Long ztyyobin11x14;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYYOBIN11X14)
    public Long getZtyyobin11x14() {
        return ztyyobin11x14;
    }

    public void setZtyyobin11x14(Long pZtyyobin11x14) {
        ztyyobin11x14 = pZtyyobin11x14;
    }

    private Long ztyyobin11x15;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYYOBIN11X15)
    public Long getZtyyobin11x15() {
        return ztyyobin11x15;
    }

    public void setZtyyobin11x15(Long pZtyyobin11x15) {
        ztyyobin11x15 = pZtyyobin11x15;
    }

    private Long ztyyobin11x16;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYYOBIN11X16)
    public Long getZtyyobin11x16() {
        return ztyyobin11x16;
    }

    public void setZtyyobin11x16(Long pZtyyobin11x16) {
        ztyyobin11x16 = pZtyyobin11x16;
    }

    private Long ztyyobin11x17;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYYOBIN11X17)
    public Long getZtyyobin11x17() {
        return ztyyobin11x17;
    }

    public void setZtyyobin11x17(Long pZtyyobin11x17) {
        ztyyobin11x17 = pZtyyobin11x17;
    }

    private String ztyzyrthntiyustatuskbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYZYRTHNTIYUSTATUSKBN)
    public String getZtyzyrthntiyustatuskbn() {
        return ztyzyrthntiyustatuskbn;
    }

    public void setZtyzyrthntiyustatuskbn(String pZtyzyrthntiyustatuskbn) {
        ztyzyrthntiyustatuskbn = pZtyzyrthntiyustatuskbn;
    }

    private String ztyzyrthntiyustatuskbnx2;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYZYRTHNTIYUSTATUSKBNX2)
    public String getZtyzyrthntiyustatuskbnx2() {
        return ztyzyrthntiyustatuskbnx2;
    }

    public void setZtyzyrthntiyustatuskbnx2(String pZtyzyrthntiyustatuskbnx2) {
        ztyzyrthntiyustatuskbnx2 = pZtyzyrthntiyustatuskbnx2;
    }

    private String ztyzyrthntiyustatuskbnx3;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYZYRTHNTIYUSTATUSKBNX3)
    public String getZtyzyrthntiyustatuskbnx3() {
        return ztyzyrthntiyustatuskbnx3;
    }

    public void setZtyzyrthntiyustatuskbnx3(String pZtyzyrthntiyustatuskbnx3) {
        ztyzyrthntiyustatuskbnx3 = pZtyzyrthntiyustatuskbnx3;
    }

    private String ztyzyrthntiyustatuskbnx4;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYZYRTHNTIYUSTATUSKBNX4)
    public String getZtyzyrthntiyustatuskbnx4() {
        return ztyzyrthntiyustatuskbnx4;
    }

    public void setZtyzyrthntiyustatuskbnx4(String pZtyzyrthntiyustatuskbnx4) {
        ztyzyrthntiyustatuskbnx4 = pZtyzyrthntiyustatuskbnx4;
    }

    private String ztyzyrthntiyustatuskbnx5;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYZYRTHNTIYUSTATUSKBNX5)
    public String getZtyzyrthntiyustatuskbnx5() {
        return ztyzyrthntiyustatuskbnx5;
    }

    public void setZtyzyrthntiyustatuskbnx5(String pZtyzyrthntiyustatuskbnx5) {
        ztyzyrthntiyustatuskbnx5 = pZtyzyrthntiyustatuskbnx5;
    }

    private String ztyyobiv10;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYYOBIV10)
    public String getZtyyobiv10() {
        return ztyyobiv10;
    }

    public void setZtyyobiv10(String pZtyyobiv10) {
        ztyyobiv10 = pZtyyobiv10;
    }

    private String ztyyobiv15x2;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYYOBIV15X2)
    public String getZtyyobiv15x2() {
        return ztyyobiv15x2;
    }

    public void setZtyyobiv15x2(String pZtyyobiv15x2) {
        ztyyobiv15x2 = pZtyyobiv15x2;
    }

    private String ztyyobiv15x3;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYYOBIV15X3)
    public String getZtyyobiv15x3() {
        return ztyyobiv15x3;
    }

    public void setZtyyobiv15x3(String pZtyyobiv15x3) {
        ztyyobiv15x3 = pZtyyobiv15x3;
    }

    private String ztyyobiv15x4;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYYOBIV15X4)
    public String getZtyyobiv15x4() {
        return ztyyobiv15x4;
    }

    public void setZtyyobiv15x4(String pZtyyobiv15x4) {
        ztyyobiv15x4 = pZtyyobiv15x4;
    }

    private String ztygaikakbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYGAIKAKBN)
    public String getZtygaikakbn() {
        return ztygaikakbn;
    }

    public void setZtygaikakbn(String pZtygaikakbn) {
        ztygaikakbn = pZtygaikakbn;
    }

    private BizNumber ztykawaserate1;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYKAWASERATE1)
    public BizNumber getZtykawaserate1() {
        return ztykawaserate1;
    }

    public void setZtykawaserate1(BizNumber pZtykawaserate1) {
        ztykawaserate1 = pZtykawaserate1;
    }

    private String ztykawaseratetekiyouymd1;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYKAWASERATETEKIYOUYMD1)
    public String getZtykawaseratetekiyouymd1() {
        return ztykawaseratetekiyouymd1;
    }

    public void setZtykawaseratetekiyouymd1(String pZtykawaseratetekiyouymd1) {
        ztykawaseratetekiyouymd1 = pZtykawaseratetekiyouymd1;
    }

    private BizNumber ztykawaserate2;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYKAWASERATE2)
    public BizNumber getZtykawaserate2() {
        return ztykawaserate2;
    }

    public void setZtykawaserate2(BizNumber pZtykawaserate2) {
        ztykawaserate2 = pZtykawaserate2;
    }

    private String ztykawaseratetekiyouymd2;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYKAWASERATETEKIYOUYMD2)
    public String getZtykawaseratetekiyouymd2() {
        return ztykawaseratetekiyouymd2;
    }

    public void setZtykawaseratetekiyouymd2(String pZtykawaseratetekiyouymd2) {
        ztykawaseratetekiyouymd2 = pZtykawaseratetekiyouymd2;
    }

    private BizNumber ztykykjikawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYKYKJIKAWASERATE)
    public BizNumber getZtykykjikawaserate() {
        return ztykykjikawaserate;
    }

    public void setZtykykjikawaserate(BizNumber pZtykykjikawaserate) {
        ztykykjikawaserate = pZtykykjikawaserate;
    }

    private String ztykykjikawaseratetkyuymd;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYKYKJIKAWASERATETKYUYMD)
    public String getZtykykjikawaseratetkyuymd() {
        return ztykykjikawaseratetkyuymd;
    }

    public void setZtykykjikawaseratetkyuymd(String pZtykykjikawaseratetkyuymd) {
        ztykykjikawaseratetkyuymd = pZtykykjikawaseratetkyuymd;
    }

    private Long ztymvatyouseigow;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYMVATYOUSEIGOW)
    public Long getZtymvatyouseigow() {
        return ztymvatyouseigow;
    }

    public void setZtymvatyouseigow(Long pZtymvatyouseigow) {
        ztymvatyouseigow = pZtymvatyouseigow;
    }

    private Long ztymvakeisanjisknnjynbkn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYMVAKEISANJISKNNJYNBKN)
    public Long getZtymvakeisanjisknnjynbkn() {
        return ztymvakeisanjisknnjynbkn;
    }

    public void setZtymvakeisanjisknnjynbkn(Long pZtymvakeisanjisknnjynbkn) {
        ztymvakeisanjisknnjynbkn = pZtymvakeisanjisknnjynbkn;
    }

    private BizNumber ztykaiyakukoujyoritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYKAIYAKUKOUJYORITU)
    public BizNumber getZtykaiyakukoujyoritu() {
        return ztykaiyakukoujyoritu;
    }

    public void setZtykaiyakukoujyoritu(BizNumber pZtykaiyakukoujyoritu) {
        ztykaiyakukoujyoritu = pZtykaiyakukoujyoritu;
    }

    private BizNumber ztyrendouritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYRENDOURITU)
    public BizNumber getZtyrendouritu() {
        return ztyrendouritu;
    }

    public void setZtyrendouritu(BizNumber pZtyrendouritu) {
        ztyrendouritu = pZtyrendouritu;
    }

    private BizNumber ztysrkaiyakusjkkktyouseirrt;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSRKAIYAKUSJKKKTYOUSEIRRT)
    public BizNumber getZtysrkaiyakusjkkktyouseirrt() {
        return ztysrkaiyakusjkkktyouseirrt;
    }

    public void setZtysrkaiyakusjkkktyouseirrt(BizNumber pZtysrkaiyakusjkkktyouseirrt) {
        ztysrkaiyakusjkkktyouseirrt = pZtysrkaiyakusjkkktyouseirrt;
    }

    private BizNumber ztysrkyksjkkktyouseiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSRKYKSJKKKTYOUSEIRIRITU)
    public BizNumber getZtysrkyksjkkktyouseiriritu() {
        return ztysrkyksjkkktyouseiriritu;
    }

    public void setZtysrkyksjkkktyouseiriritu(BizNumber pZtysrkyksjkkktyouseiriritu) {
        ztysrkyksjkkktyouseiriritu = pZtysrkyksjkkktyouseiriritu;
    }

    private String ztymvakeisankijyunymd;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYMVAKEISANKIJYUNYMD)
    public String getZtymvakeisankijyunymd() {
        return ztymvakeisankijyunymd;
    }

    public void setZtymvakeisankijyunymd(String pZtymvakeisankijyunymd) {
        ztymvakeisankijyunymd = pZtymvakeisankijyunymd;
    }

    private BizNumber ztymvatyouseikou;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYMVATYOUSEIKOU)
    public BizNumber getZtymvatyouseikou() {
        return ztymvatyouseikou;
    }

    public void setZtymvatyouseikou(BizNumber pZtymvatyouseikou) {
        ztymvatyouseikou = pZtymvatyouseikou;
    }

    private Long ztyenkdtsbujsitihsyukngk;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYENKDTSBUJSITIHSYUKNGK)
    public Long getZtyenkdtsbujsitihsyukngk() {
        return ztyenkdtsbujsitihsyukngk;
    }

    public void setZtyenkdtsbujsitihsyukngk(Long pZtyenkdtsbujsitihsyukngk) {
        ztyenkdtsbujsitihsyukngk = pZtyenkdtsbujsitihsyukngk;
    }

    private Long ztyenkdtsbujsitihsyucost;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYENKDTSBUJSITIHSYUCOST)
    public Long getZtyenkdtsbujsitihsyucost() {
        return ztyenkdtsbujsitihsyucost;
    }

    public void setZtyenkdtsbujsitihsyucost(Long pZtyenkdtsbujsitihsyucost) {
        ztyenkdtsbujsitihsyucost = pZtyenkdtsbujsitihsyucost;
    }

    private String ztyenkdtsbujsitihsyuarihyj;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYENKDTSBUJSITIHSYUARIHYJ)
    public String getZtyenkdtsbujsitihsyuarihyj() {
        return ztyenkdtsbujsitihsyuarihyj;
    }

    public void setZtyenkdtsbujsitihsyuarihyj(String pZtyenkdtsbujsitihsyuarihyj) {
        ztyenkdtsbujsitihsyuarihyj = pZtyenkdtsbujsitihsyuarihyj;
    }

    private BizNumber ztykeiyakujiyoteiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYKEIYAKUJIYOTEIRIRITU)
    public BizNumber getZtykeiyakujiyoteiriritu() {
        return ztykeiyakujiyoteiriritu;
    }

    public void setZtykeiyakujiyoteiriritu(BizNumber pZtykeiyakujiyoteiriritu) {
        ztykeiyakujiyoteiriritu = pZtykeiyakujiyoteiriritu;
    }

    private BizNumber ztytumitateriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYTUMITATERIRITU)
    public BizNumber getZtytumitateriritu() {
        return ztytumitateriritu;
    }

    public void setZtytumitateriritu(BizNumber pZtytumitateriritu) {
        ztytumitateriritu = pZtytumitateriritu;
    }

    private String ztykaigomaebaraitkykarihyj;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYKAIGOMAEBARAITKYKARIHYJ)
    public String getZtykaigomaebaraitkykarihyj() {
        return ztykaigomaebaraitkykarihyj;
    }

    public void setZtykaigomaebaraitkykarihyj(String pZtykaigomaebaraitkykarihyj) {
        ztykaigomaebaraitkykarihyj = pZtykaigomaebaraitkykarihyj;
    }

    private String ztysibouhyoukbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSIBOUHYOUKBN)
    public String getZtysibouhyoukbn() {
        return ztysibouhyoukbn;
    }

    public void setZtysibouhyoukbn(String pZtysibouhyoukbn) {
        ztysibouhyoukbn = pZtysibouhyoukbn;
    }

    private String ztynyuukintuukakbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYNYUUKINTUUKAKBN)
    public String getZtynyuukintuukakbn() {
        return ztynyuukintuukakbn;
    }

    public void setZtynyuukintuukakbn(String pZtynyuukintuukakbn) {
        ztynyuukintuukakbn = pZtynyuukintuukakbn;
    }

    private String ztysiharaituukakbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSIHARAITUUKAKBN)
    public String getZtysiharaituukakbn() {
        return ztysiharaituukakbn;
    }

    public void setZtysiharaituukakbn(String pZtysiharaituukakbn) {
        ztysiharaituukakbn = pZtysiharaituukakbn;
    }

    private String ztywyendttargetmokuhyouritu;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYWYENDTTARGETMOKUHYOURITU)
    public String getZtywyendttargetmokuhyouritu() {
        return ztywyendttargetmokuhyouritu;
    }

    public void setZtywyendttargetmokuhyouritu(String pZtywyendttargetmokuhyouritu) {
        ztywyendttargetmokuhyouritu = pZtywyendttargetmokuhyouritu;
    }

    private String ztysisuurendourate;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSISUURENDOURATE)
    public String getZtysisuurendourate() {
        return ztysisuurendourate;
    }

    public void setZtysisuurendourate(String pZtysisuurendourate) {
        ztysisuurendourate = pZtysisuurendourate;
    }

    private String ztysisuukbn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSISUUKBN)
    public String getZtysisuukbn() {
        return ztysisuukbn;
    }

    public void setZtysisuukbn(String pZtysisuukbn) {
        ztysisuukbn = pZtysisuukbn;
    }

    private String ztyteirituikouhyouji;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYTEIRITUIKOUHYOUJI)
    public String getZtyteirituikouhyouji() {
        return ztyteirituikouhyouji;
    }

    public void setZtyteirituikouhyouji(String pZtyteirituikouhyouji) {
        ztyteirituikouhyouji = pZtyteirituikouhyouji;
    }

    private String ztysuuriyouyobin2x3;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSUURIYOUYOBIN2X3)
    public String getZtysuuriyouyobin2x3() {
        return ztysuuriyouyobin2x3;
    }

    public void setZtysuuriyouyobin2x3(String pZtysuuriyouyobin2x3) {
        ztysuuriyouyobin2x3 = pZtysuuriyouyobin2x3;
    }

    private String ztysuuriyouyobin10x11;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSUURIYOUYOBIN10X11)
    public String getZtysuuriyouyobin10x11() {
        return ztysuuriyouyobin10x11;
    }

    public void setZtysuuriyouyobin10x11(String pZtysuuriyouyobin10x11) {
        ztysuuriyouyobin10x11 = pZtysuuriyouyobin10x11;
    }

    private BizNumber ztytmttknzoukaritujygn;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYTMTTKNZOUKARITUJYGN)
    public BizNumber getZtytmttknzoukaritujygn() {
        return ztytmttknzoukaritujygn;
    }

    public void setZtytmttknzoukaritujygn(BizNumber pZtytmttknzoukaritujygn) {
        ztytmttknzoukaritujygn = pZtytmttknzoukaritujygn;
    }

    private BizNumber ztysetteibairitu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSETTEIBAIRITU)
    public BizNumber getZtysetteibairitu() {
        return ztysetteibairitu;
    }

    public void setZtysetteibairitu(BizNumber pZtysetteibairitu) {
        ztysetteibairitu = pZtysetteibairitu;
    }

    private BizNumber ztytykzenoutouymdsisuu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYTYKZENOUTOUYMDSISUU)
    public BizNumber getZtytykzenoutouymdsisuu() {
        return ztytykzenoutouymdsisuu;
    }

    public void setZtytykzenoutouymdsisuu(BizNumber pZtytykzenoutouymdsisuu) {
        ztytykzenoutouymdsisuu = pZtytykzenoutouymdsisuu;
    }

    private BizNumber ztykimatusisuu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYKIMATUSISUU)
    public BizNumber getZtykimatusisuu() {
        return ztykimatusisuu;
    }

    public void setZtykimatusisuu(BizNumber pZtykimatusisuu) {
        ztykimatusisuu = pZtykimatusisuu;
    }

    private String ztyyobiv3;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYYOBIV3)
    public String getZtyyobiv3() {
        return ztyyobiv3;
    }

    public void setZtyyobiv3(String pZtyyobiv3) {
        ztyyobiv3 = pZtyyobiv3;
    }

    private Long ztyyenkadatekihons;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYYENKADATEKIHONS)
    public Long getZtyyenkadatekihons() {
        return ztyyenkadatekihons;
    }

    public void setZtyyenkadatekihons(Long pZtyyenkadatekihons) {
        ztyyenkadatekihons = pZtyyenkadatekihons;
    }

    private Long ztysitihsyumegkdtsibous;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSITIHSYUMEGKDTSIBOUS)
    public Long getZtysitihsyumegkdtsibous() {
        return ztysitihsyumegkdtsibous;
    }

    public void setZtysitihsyumegkdtsibous(Long pZtysitihsyumegkdtsibous) {
        ztysitihsyumegkdtsibous = pZtysitihsyumegkdtsibous;
    }

    private Long ztyenkdtssrentumitatekin;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYENKDTSSRENTUMITATEKIN)
    public Long getZtyenkdtssrentumitatekin() {
        return ztyenkdtssrentumitatekin;
    }

    public void setZtyenkdtssrentumitatekin(Long pZtyenkdtssrentumitatekin) {
        ztyenkdtssrentumitatekin = pZtyenkdtssrentumitatekin;
    }

    private Long ztysisuurentumitatekin;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSISUURENTUMITATEKIN)
    public Long getZtysisuurentumitatekin() {
        return ztysisuurentumitatekin;
    }

    public void setZtysisuurentumitatekin(Long pZtysisuurentumitatekin) {
        ztysisuurentumitatekin = pZtysisuurentumitatekin;
    }

    private Long ztynksjitirttumitatekin;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYNKSJITIRTTUMITATEKIN)
    public Long getZtynksjitirttumitatekin() {
        return ztynksjitirttumitatekin;
    }

    public void setZtynksjitirttumitatekin(Long pZtynksjitirttumitatekin) {
        ztynksjitirttumitatekin = pZtynksjitirttumitatekin;
    }

    private Long ztykimatutirttumitatekin;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYKIMATUTIRTTUMITATEKIN)
    public Long getZtykimatutirttumitatekin() {
        return ztykimatutirttumitatekin;
    }

    public void setZtykimatutirttumitatekin(Long pZtykimatutirttumitatekin) {
        ztykimatutirttumitatekin = pZtykimatutirttumitatekin;
    }

    private Long ztygaikadatejyuutoup;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYGAIKADATEJYUUTOUP)
    public Long getZtygaikadatejyuutoup() {
        return ztygaikadatejyuutoup;
    }

    public void setZtygaikadatejyuutoup(Long pZtygaikadatejyuutoup) {
        ztygaikadatejyuutoup = pZtygaikadatejyuutoup;
    }

    private Long ztyyendttargetkijyunkingaku;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYYENDTTARGETKIJYUNKINGAKU)
    public Long getZtyyendttargetkijyunkingaku() {
        return ztyyendttargetkijyunkingaku;
    }

    public void setZtyyendttargetkijyunkingaku(Long pZtyyendttargetkijyunkingaku) {
        ztyyendttargetkijyunkingaku = pZtyyendttargetkijyunkingaku;
    }

    private String ztyyobiv7;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYYOBIV7)
    public String getZtyyobiv7() {
        return ztyyobiv7;
    }

    public void setZtyyobiv7(String pZtyyobiv7) {
        ztyyobiv7 = pZtyyobiv7;
    }

    private BizNumber ztysitivkisnyukykjikwsrate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSITIVKISNYUKYKJIKWSRATE)
    public BizNumber getZtysitivkisnyukykjikwsrate() {
        return ztysitivkisnyukykjikwsrate;
    }

    public void setZtysitivkisnyukykjikwsrate(BizNumber pZtysitivkisnyukykjikwsrate) {
        ztysitivkisnyukykjikwsrate = pZtysitivkisnyukykjikwsrate;
    }

    private Long ztysisuurentyokugotmttkn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSISUURENTYOKUGOTMTTKN)
    public Long getZtysisuurentyokugotmttkn() {
        return ztysisuurentyokugotmttkn;
    }

    public void setZtysisuurentyokugotmttkn(Long pZtysisuurentyokugotmttkn) {
        ztysisuurentyokugotmttkn = pZtysisuurentyokugotmttkn;
    }

    private BizNumber ztyyoteiririturironbase;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYYOTEIRIRITURIRONBASE)
    public BizNumber getZtyyoteiririturironbase() {
        return ztyyoteiririturironbase;
    }

    public void setZtyyoteiririturironbase(BizNumber pZtyyoteiririturironbase) {
        ztyyoteiririturironbase = pZtyyoteiririturironbase;
    }

    private BizNumber ztyyoteiriritujtnyknbase;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYYOTEIRIRITUJTNYKNBASE)
    public BizNumber getZtyyoteiriritujtnyknbase() {
        return ztyyoteiriritujtnyknbase;
    }

    public void setZtyyoteiriritujtnyknbase(BizNumber pZtyyoteiriritujtnyknbase) {
        ztyyoteiriritujtnyknbase = pZtyyoteiriritujtnyknbase;
    }

    private Long ztykihrkmpjtnyknbase;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYKIHRKMPJTNYKNBASE)
    public Long getZtykihrkmpjtnyknbase() {
        return ztykihrkmpjtnyknbase;
    }

    public void setZtykihrkmpjtnyknbase(Long pZtykihrkmpjtnyknbase) {
        ztykihrkmpjtnyknbase = pZtykihrkmpjtnyknbase;
    }

    private Long ztysyuptumitatekin;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSYUPTUMITATEKIN)
    public Long getZtysyuptumitatekin() {
        return ztysyuptumitatekin;
    }

    public void setZtysyuptumitatekin(Long pZtysyuptumitatekin) {
        ztysyuptumitatekin = pZtysyuptumitatekin;
    }

    private Long ztysyuptumitatekingsc;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSYUPTUMITATEKINGSC)
    public Long getZtysyuptumitatekingsc() {
        return ztysyuptumitatekingsc;
    }

    public void setZtysyuptumitatekingsc(Long pZtysyuptumitatekingsc) {
        ztysyuptumitatekingsc = pZtysyuptumitatekingsc;
    }

    private Long ztygaikadatenkgns;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYGAIKADATENKGNS)
    public Long getZtygaikadatenkgns() {
        return ztygaikadatenkgns;
    }

    public void setZtygaikadatenkgns(Long pZtygaikadatenkgns) {
        ztygaikadatenkgns = pZtygaikadatenkgns;
    }

    private String ztyjikaipjyuutouym2;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYJIKAIPJYUUTOUYM2)
    public String getZtyjikaipjyuutouym2() {
        return ztyjikaipjyuutouym2;
    }

    public void setZtyjikaipjyuutouym2(String pZtyjikaipjyuutouym2) {
        ztyjikaipjyuutouym2 = pZtyjikaipjyuutouym2;
    }

    private Integer ztysuuriyobin9;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSUURIYOBIN9)
    public Integer getZtysuuriyobin9() {
        return ztysuuriyobin9;
    }

    public void setZtysuuriyobin9(Integer pZtysuuriyobin9) {
        ztysuuriyobin9 = pZtysuuriyobin9;
    }

    private Long ztygessitumitatekin;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYGESSITUMITATEKIN)
    public Long getZtygessitumitatekin() {
        return ztygessitumitatekin;
    }

    public void setZtygessitumitatekin(Long pZtygessitumitatekin) {
        ztygessitumitatekin = pZtygessitumitatekin;
    }

    private Long ztygaikadatetougetujuutoup;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYGAIKADATETOUGETUJUUTOUP)
    public Long getZtygaikadatetougetujuutoup() {
        return ztygaikadatetougetujuutoup;
    }

    public void setZtygaikadatetougetujuutoup(Long pZtygaikadatetougetujuutoup) {
        ztygaikadatetougetujuutoup = pZtygaikadatetougetujuutoup;
    }

    private Long ztykihrkmpmsukisymbase;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYKIHRKMPMSUKISYMBASE)
    public Long getZtykihrkmpmsukisymbase() {
        return ztykihrkmpmsukisymbase;
    }

    public void setZtykihrkmpmsukisymbase(Long pZtykihrkmpmsukisymbase) {
        ztykihrkmpmsukisymbase = pZtykihrkmpmsukisymbase;
    }

    private Long ztykeisanhanteiyoutmttkn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYKEISANHANTEIYOUTMTTKN)
    public Long getZtykeisanhanteiyoutmttkn() {
        return ztykeisanhanteiyoutmttkn;
    }

    public void setZtykeisanhanteiyoutmttkn(Long pZtykeisanhanteiyoutmttkn) {
        ztykeisanhanteiyoutmttkn = pZtykeisanhanteiyoutmttkn;
    }

    private Long ztygtmtv;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYGTMTV)
    public Long getZtygtmtv() {
        return ztygtmtv;
    }

    public void setZtygtmtv(Long pZtygtmtv) {
        ztygtmtv = pZtygtmtv;
    }

    private BizNumber ztyzettaisibouritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYZETTAISIBOURITU)
    public BizNumber getZtyzettaisibouritu() {
        return ztyzettaisibouritu;
    }

    public void setZtyzettaisibouritu(BizNumber pZtyzettaisibouritu) {
        ztyzettaisibouritu = pZtyzettaisibouritu;
    }

    private BizNumber ztysoutaisibouritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSOUTAISIBOURITU)
    public BizNumber getZtysoutaisibouritu() {
        return ztysoutaisibouritu;
    }

    public void setZtysoutaisibouritu(BizNumber pZtysoutaisibouritu) {
        ztysoutaisibouritu = pZtysoutaisibouritu;
    }

    private BizNumber ztysoutaikaiyakuritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSOUTAIKAIYAKURITU)
    public BizNumber getZtysoutaikaiyakuritu() {
        return ztysoutaikaiyakuritu;
    }

    public void setZtysoutaikaiyakuritu(BizNumber pZtysoutaikaiyakuritu) {
        ztysoutaikaiyakuritu = pZtysoutaikaiyakuritu;
    }

    private BizNumber ztyvhireilritu2;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYVHIREILRITU2)
    public BizNumber getZtyvhireilritu2() {
        return ztyvhireilritu2;
    }

    public void setZtyvhireilritu2(BizNumber pZtyvhireilritu2) {
        ztyvhireilritu2 = pZtyvhireilritu2;
    }

    private BizNumber ztyphireialpha;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYPHIREIALPHA)
    public BizNumber getZtyphireialpha() {
        return ztyphireialpha;
    }

    public void setZtyphireialpha(BizNumber pZtyphireialpha) {
        ztyphireialpha = pZtyphireialpha;
    }

    private BizNumber ztyphireibeta;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYPHIREIBETA)
    public BizNumber getZtyphireibeta() {
        return ztyphireibeta;
    }

    public void setZtyphireibeta(BizNumber pZtyphireibeta) {
        ztyphireibeta = pZtyphireibeta;
    }

    private BizNumber ztyphireiganma;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYPHIREIGANMA)
    public BizNumber getZtyphireiganma() {
        return ztyphireiganma;
    }

    public void setZtyphireiganma(BizNumber pZtyphireiganma) {
        ztyphireiganma = pZtyphireiganma;
    }

    private BizNumber ztyphireilwrbkritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYPHIREILWRBKRITU)
    public BizNumber getZtyphireilwrbkritu() {
        return ztyphireilwrbkritu;
    }

    public void setZtyphireilwrbkritu(BizNumber pZtyphireilwrbkritu) {
        ztyphireilwrbkritu = pZtyphireilwrbkritu;
    }

    private BizNumber ztyyoteiriritumsukisymbase;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYYOTEIRIRITUMSUKISYMBASE)
    public BizNumber getZtyyoteiriritumsukisymbase() {
        return ztyyoteiriritumsukisymbase;
    }

    public void setZtyyoteiriritumsukisymbase(BizNumber pZtyyoteiriritumsukisymbase) {
        ztyyoteiriritumsukisymbase = pZtyyoteiriritumsukisymbase;
    }

    private Long ztyrrthnduhknvkisovkisnyu1;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYRRTHNDUHKNVKISOVKISNYU1)
    public Long getZtyrrthnduhknvkisovkisnyu1() {
        return ztyrrthnduhknvkisovkisnyu1;
    }

    public void setZtyrrthnduhknvkisovkisnyu1(Long pZtyrrthnduhknvkisovkisnyu1) {
        ztyrrthnduhknvkisovkisnyu1 = pZtyrrthnduhknvkisovkisnyu1;
    }

    private Long ztyrrthnduhknvkisovkisnyu2;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYRRTHNDUHKNVKISOVKISNYU2)
    public Long getZtyrrthnduhknvkisovkisnyu2() {
        return ztyrrthnduhknvkisovkisnyu2;
    }

    public void setZtyrrthnduhknvkisovkisnyu2(Long pZtyrrthnduhknvkisovkisnyu2) {
        ztyrrthnduhknvkisovkisnyu2 = pZtyrrthnduhknvkisovkisnyu2;
    }

    private Long ztyrrthnduhknvkisovkisnyu3;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYRRTHNDUHKNVKISOVKISNYU3)
    public Long getZtyrrthnduhknvkisovkisnyu3() {
        return ztyrrthnduhknvkisovkisnyu3;
    }

    public void setZtyrrthnduhknvkisovkisnyu3(Long pZtyrrthnduhknvkisovkisnyu3) {
        ztyrrthnduhknvkisovkisnyu3 = pZtyrrthnduhknvkisovkisnyu3;
    }

    private Long ztyrrthnduhknvkisovkisnyu4;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYRRTHNDUHKNVKISOVKISNYU4)
    public Long getZtyrrthnduhknvkisovkisnyu4() {
        return ztyrrthnduhknvkisovkisnyu4;
    }

    public void setZtyrrthnduhknvkisovkisnyu4(Long pZtyrrthnduhknvkisovkisnyu4) {
        ztyrrthnduhknvkisovkisnyu4 = pZtyrrthnduhknvkisovkisnyu4;
    }

    private Long ztyrrthnduhknvkiso;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYRRTHNDUHKNVKISO)
    public Long getZtyrrthnduhknvkiso() {
        return ztyrrthnduhknvkiso;
    }

    public void setZtyrrthnduhknvkiso(Long pZtyrrthnduhknvkiso) {
        ztyrrthnduhknvkiso = pZtyrrthnduhknvkiso;
    }

    private Long ztytumitatekin;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYTUMITATEKIN)
    public Long getZtytumitatekin() {
        return ztytumitatekin;
    }

    public void setZtytumitatekin(Long pZtytumitatekin) {
        ztytumitatekin = pZtytumitatekin;
    }

    private Long ztykiharaikomip;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYKIHARAIKOMIP)
    public Long getZtykiharaikomip() {
        return ztykiharaikomip;
    }

    public void setZtykiharaikomip(Long pZtykiharaikomip) {
        ztykiharaikomip = pZtykiharaikomip;
    }

    private Long ztygaikadatesyukeiyakup;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYGAIKADATESYUKEIYAKUP)
    public Long getZtygaikadatesyukeiyakup() {
        return ztygaikadatesyukeiyakup;
    }

    public void setZtygaikadatesyukeiyakup(Long pZtygaikadatesyukeiyakup) {
        ztygaikadatesyukeiyakup = pZtygaikadatesyukeiyakup;
    }

    private Long ztykykkjmmvatyouseigow;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYKYKKJMMVATYOUSEIGOW)
    public Long getZtykykkjmmvatyouseigow() {
        return ztykykkjmmvatyouseigow;
    }

    public void setZtykykkjmmvatyouseigow(Long pZtykykkjmmvatyouseigow) {
        ztykykkjmmvatyouseigow = pZtykykkjmmvatyouseigow;
    }

    private Long ztyyobin11x39;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYYOBIN11X39)
    public Long getZtyyobin11x39() {
        return ztyyobin11x39;
    }

    public void setZtyyobin11x39(Long pZtyyobin11x39) {
        ztyyobin11x39 = pZtyyobin11x39;
    }

    private Long ztyyobin11x41;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYYOBIN11X41)
    public Long getZtyyobin11x41() {
        return ztyyobin11x41;
    }

    public void setZtyyobin11x41(Long pZtyyobin11x41) {
        ztyyobin11x41 = pZtyyobin11x41;
    }

    private Long ztyyobin11x42;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYYOBIN11X42)
    public Long getZtyyobin11x42() {
        return ztyyobin11x42;
    }

    public void setZtyyobin11x42(Long pZtyyobin11x42) {
        ztyyobin11x42 = pZtyyobin11x42;
    }

    private Long ztyyobin11x43;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYYOBIN11X43)
    public Long getZtyyobin11x43() {
        return ztyyobin11x43;
    }

    public void setZtyyobin11x43(Long pZtyyobin11x43) {
        ztyyobin11x43 = pZtyyobin11x43;
    }

    private Long ztyyobin11x44;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYYOBIN11X44)
    public Long getZtyyobin11x44() {
        return ztyyobin11x44;
    }

    public void setZtyyobin11x44(Long pZtyyobin11x44) {
        ztyyobin11x44 = pZtyyobin11x44;
    }

    private Long ztyyobin11x45;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYYOBIN11X45)
    public Long getZtyyobin11x45() {
        return ztyyobin11x45;
    }

    public void setZtyyobin11x45(Long pZtyyobin11x45) {
        ztyyobin11x45 = pZtyyobin11x45;
    }

    private String ztysuuriyouyobin15x3;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSUURIYOUYOBIN15X3)
    public String getZtysuuriyouyobin15x3() {
        return ztysuuriyouyobin15x3;
    }

    public void setZtysuuriyouyobin15x3(String pZtysuuriyouyobin15x3) {
        ztysuuriyouyobin15x3 = pZtysuuriyouyobin15x3;
    }

    private String ztysuuriyouyobin15x4;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSUURIYOUYOBIN15X4)
    public String getZtysuuriyouyobin15x4() {
        return ztysuuriyouyobin15x4;
    }

    public void setZtysuuriyouyobin15x4(String pZtysuuriyouyobin15x4) {
        ztysuuriyouyobin15x4 = pZtysuuriyouyobin15x4;
    }

    private String ztysuuriyouyobin15x5;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSUURIYOUYOBIN15X5)
    public String getZtysuuriyouyobin15x5() {
        return ztysuuriyouyobin15x5;
    }

    public void setZtysuuriyouyobin15x5(String pZtysuuriyouyobin15x5) {
        ztysuuriyouyobin15x5 = pZtysuuriyouyobin15x5;
    }

    private String ztysuuriyouyobin15x6;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSUURIYOUYOBIN15X6)
    public String getZtysuuriyouyobin15x6() {
        return ztysuuriyouyobin15x6;
    }

    public void setZtysuuriyouyobin15x6(String pZtysuuriyouyobin15x6) {
        ztysuuriyouyobin15x6 = pZtysuuriyouyobin15x6;
    }

    private String ztyyobiv14;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYYOBIV14)
    public String getZtyyobiv14() {
        return ztyyobiv14;
    }

    public void setZtyyobiv14(String pZtyyobiv14) {
        ztyyobiv14 = pZtyyobiv14;
    }

    private Long ztyvkimatutirttumitatekin;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYVKIMATUTIRTTUMITATEKIN)
    public Long getZtyvkimatutirttumitatekin() {
        return ztyvkimatutirttumitatekin;
    }

    public void setZtyvkimatutirttumitatekin(Long pZtyvkimatutirttumitatekin) {
        ztyvkimatutirttumitatekin = pZtyvkimatutirttumitatekin;
    }

    private Long ztykimatusisuutumitatekin;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYKIMATUSISUUTUMITATEKIN)
    public Long getZtykimatusisuutumitatekin() {
        return ztykimatusisuutumitatekin;
    }

    public void setZtykimatusisuutumitatekin(Long pZtykimatusisuutumitatekin) {
        ztykimatusisuutumitatekin = pZtykimatusisuutumitatekin;
    }

    private BizNumber ztyvyoutykzenoutouymdsisuu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYVYOUTYKZENOUTOUYMDSISUU)
    public BizNumber getZtyvyoutykzenoutouymdsisuu() {
        return ztyvyoutykzenoutouymdsisuu;
    }

    public void setZtyvyoutykzenoutouymdsisuu(BizNumber pZtyvyoutykzenoutouymdsisuu) {
        ztyvyoutykzenoutouymdsisuu = pZtyvyoutykzenoutouymdsisuu;
    }

    private String ztytykzensisuukijyunymd;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYTYKZENSISUUKIJYUNYMD)
    public String getZtytykzensisuukijyunymd() {
        return ztytykzensisuukijyunymd;
    }

    public void setZtytykzensisuukijyunymd(String pZtytykzensisuukijyunymd) {
        ztytykzensisuukijyunymd = pZtytykzensisuukijyunymd;
    }

    private BizNumber ztyvyoukimatusisuu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYVYOUKIMATUSISUU)
    public BizNumber getZtyvyoukimatusisuu() {
        return ztyvyoukimatusisuu;
    }

    public void setZtyvyoukimatusisuu(BizNumber pZtyvyoukimatusisuu) {
        ztyvyoukimatusisuu = pZtyvyoukimatusisuu;
    }

    private String ztykmtsisuukijyunymd;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYKMTSISUUKIJYUNYMD)
    public String getZtykmtsisuukijyunymd() {
        return ztykmtsisuukijyunymd;
    }

    public void setZtykmtsisuukijyunymd(String pZtykmtsisuukijyunymd) {
        ztykmtsisuukijyunymd = pZtykmtsisuukijyunymd;
    }

    private BizNumber ztyvyoutmttknzoukaritujygn;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYVYOUTMTTKNZOUKARITUJYGN)
    public BizNumber getZtyvyoutmttknzoukaritujygn() {
        return ztyvyoutmttknzoukaritujygn;
    }

    public void setZtyvyoutmttknzoukaritujygn(BizNumber pZtyvyoutmttknzoukaritujygn) {
        ztyvyoutmttknzoukaritujygn = pZtyvyoutmttknzoukaritujygn;
    }

    private BizNumber ztyvyousetteibairitu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYVYOUSETTEIBAIRITU)
    public BizNumber getZtyvyousetteibairitu() {
        return ztyvyousetteibairitu;
    }

    public void setZtyvyousetteibairitu(BizNumber pZtyvyousetteibairitu) {
        ztyvyousetteibairitu = pZtyvyousetteibairitu;
    }

    private BizNumber ztyvyourendouritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYVYOURENDOURITU)
    public BizNumber getZtyvyourendouritu() {
        return ztyvyourendouritu;
    }

    public void setZtyvyourendouritu(BizNumber pZtyvyourendouritu) {
        ztyvyourendouritu = pZtyvyourendouritu;
    }

    private String ztysuuriyouyobin3x2;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSUURIYOUYOBIN3X2)
    public String getZtysuuriyouyobin3x2() {
        return ztysuuriyouyobin3x2;
    }

    public void setZtysuuriyouyobin3x2(String pZtysuuriyouyobin3x2) {
        ztysuuriyouyobin3x2 = pZtysuuriyouyobin3x2;
    }

    private String ztyyobiv8x2;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYYOBIV8X2)
    public String getZtyyobiv8x2() {
        return ztyyobiv8x2;
    }

    public void setZtyyobiv8x2(String pZtyyobiv8x2) {
        ztyyobiv8x2 = pZtyyobiv8x2;
    }

    private Long ztykimatusisuutyokugotmttkn;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYKIMATUSISUUTYOKUGOTMTTKN)
    public Long getZtykimatusisuutyokugotmttkn() {
        return ztykimatusisuutyokugotmttkn;
    }

    public void setZtykimatusisuutyokugotmttkn(Long pZtykimatusisuutyokugotmttkn) {
        ztykimatusisuutyokugotmttkn = pZtykimatusisuutyokugotmttkn;
    }

    private Long ztyyobin11x19;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYYOBIN11X19)
    public Long getZtyyobin11x19() {
        return ztyyobin11x19;
    }

    public void setZtyyobin11x19(Long pZtyyobin11x19) {
        ztyyobin11x19 = pZtyyobin11x19;
    }

    private Long ztyyobin11x20;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYYOBIN11X20)
    public Long getZtyyobin11x20() {
        return ztyyobin11x20;
    }

    public void setZtyyobin11x20(Long pZtyyobin11x20) {
        ztyyobin11x20 = pZtyyobin11x20;
    }

    private Long ztyjmttirttumitatekinnplus0;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYJMTTIRTTUMITATEKINNPLUS0)
    public Long getZtyjmttirttumitatekinnplus0() {
        return ztyjmttirttumitatekinnplus0;
    }

    public void setZtyjmttirttumitatekinnplus0(Long pZtyjmttirttumitatekinnplus0) {
        ztyjmttirttumitatekinnplus0 = pZtyjmttirttumitatekinnplus0;
    }

    private Long ztyjmttirttumitatekinnplus1;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYJMTTIRTTUMITATEKINNPLUS1)
    public Long getZtyjmttirttumitatekinnplus1() {
        return ztyjmttirttumitatekinnplus1;
    }

    public void setZtyjmttirttumitatekinnplus1(Long pZtyjmttirttumitatekinnplus1) {
        ztyjmttirttumitatekinnplus1 = pZtyjmttirttumitatekinnplus1;
    }

    private Long ztyjmttirttumitatekinnplus2;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYJMTTIRTTUMITATEKINNPLUS2)
    public Long getZtyjmttirttumitatekinnplus2() {
        return ztyjmttirttumitatekinnplus2;
    }

    public void setZtyjmttirttumitatekinnplus2(Long pZtyjmttirttumitatekinnplus2) {
        ztyjmttirttumitatekinnplus2 = pZtyjmttirttumitatekinnplus2;
    }

    private Long ztyjmtssutumitatekinnplus0;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYJMTSSUTUMITATEKINNPLUS0)
    public Long getZtyjmtssutumitatekinnplus0() {
        return ztyjmtssutumitatekinnplus0;
    }

    public void setZtyjmtssutumitatekinnplus0(Long pZtyjmtssutumitatekinnplus0) {
        ztyjmtssutumitatekinnplus0 = pZtyjmtssutumitatekinnplus0;
    }

    private Long ztyjmtssutumitatekinnplus1;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYJMTSSUTUMITATEKINNPLUS1)
    public Long getZtyjmtssutumitatekinnplus1() {
        return ztyjmtssutumitatekinnplus1;
    }

    public void setZtyjmtssutumitatekinnplus1(Long pZtyjmtssutumitatekinnplus1) {
        ztyjmtssutumitatekinnplus1 = pZtyjmtssutumitatekinnplus1;
    }

    private Long ztyjmtssutumitatekinnplus2;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYJMTSSUTUMITATEKINNPLUS2)
    public Long getZtyjmtssutumitatekinnplus2() {
        return ztyjmtssutumitatekinnplus2;
    }

    public void setZtyjmtssutumitatekinnplus2(Long pZtyjmtssutumitatekinnplus2) {
        ztyjmtssutumitatekinnplus2 = pZtyjmtssutumitatekinnplus2;
    }

    private Long ztyjmtmvatyouseigownplus0;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYJMTMVATYOUSEIGOWNPLUS0)
    public Long getZtyjmtmvatyouseigownplus0() {
        return ztyjmtmvatyouseigownplus0;
    }

    public void setZtyjmtmvatyouseigownplus0(Long pZtyjmtmvatyouseigownplus0) {
        ztyjmtmvatyouseigownplus0 = pZtyjmtmvatyouseigownplus0;
    }

    private Long ztyjmtmvakeisanjiwnplus0;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYJMTMVAKEISANJIWNPLUS0)
    public Long getZtyjmtmvakeisanjiwnplus0() {
        return ztyjmtmvakeisanjiwnplus0;
    }

    public void setZtyjmtmvakeisanjiwnplus0(Long pZtyjmtmvakeisanjiwnplus0) {
        ztyjmtmvakeisanjiwnplus0 = pZtyjmtmvakeisanjiwnplus0;
    }

    private Long ztyjmtmvatyouseigownplus1;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYJMTMVATYOUSEIGOWNPLUS1)
    public Long getZtyjmtmvatyouseigownplus1() {
        return ztyjmtmvatyouseigownplus1;
    }

    public void setZtyjmtmvatyouseigownplus1(Long pZtyjmtmvatyouseigownplus1) {
        ztyjmtmvatyouseigownplus1 = pZtyjmtmvatyouseigownplus1;
    }

    private Long ztyjmtmvakeisanjiwnplus1;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYJMTMVAKEISANJIWNPLUS1)
    public Long getZtyjmtmvakeisanjiwnplus1() {
        return ztyjmtmvakeisanjiwnplus1;
    }

    public void setZtyjmtmvakeisanjiwnplus1(Long pZtyjmtmvakeisanjiwnplus1) {
        ztyjmtmvakeisanjiwnplus1 = pZtyjmtmvakeisanjiwnplus1;
    }

    private Long ztyjmtmvatyouseigownplus2;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYJMTMVATYOUSEIGOWNPLUS2)
    public Long getZtyjmtmvatyouseigownplus2() {
        return ztyjmtmvatyouseigownplus2;
    }

    public void setZtyjmtmvatyouseigownplus2(Long pZtyjmtmvatyouseigownplus2) {
        ztyjmtmvatyouseigownplus2 = pZtyjmtmvatyouseigownplus2;
    }

    private Long ztyjmtmvakeisanjiwnplus2;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYJMTMVAKEISANJIWNPLUS2)
    public Long getZtyjmtmvakeisanjiwnplus2() {
        return ztyjmtmvakeisanjiwnplus2;
    }

    public void setZtyjmtmvakeisanjiwnplus2(Long pZtyjmtmvakeisanjiwnplus2) {
        ztyjmtmvakeisanjiwnplus2 = pZtyjmtmvakeisanjiwnplus2;
    }

    private Long ztyyobin11x21;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYYOBIN11X21)
    public Long getZtyyobin11x21() {
        return ztyyobin11x21;
    }

    public void setZtyyobin11x21(Long pZtyyobin11x21) {
        ztyyobin11x21 = pZtyyobin11x21;
    }

    private Long ztyyobin11x22;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYYOBIN11X22)
    public Long getZtyyobin11x22() {
        return ztyyobin11x22;
    }

    public void setZtyyobin11x22(Long pZtyyobin11x22) {
        ztyyobin11x22 = pZtyyobin11x22;
    }

    private Long ztyyobin11x23;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYYOBIN11X23)
    public Long getZtyyobin11x23() {
        return ztyyobin11x23;
    }

    public void setZtyyobin11x23(Long pZtyyobin11x23) {
        ztyyobin11x23 = pZtyyobin11x23;
    }

    private Long ztyyobin11x4;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYYOBIN11X4)
    public Long getZtyyobin11x4() {
        return ztyyobin11x4;
    }

    public void setZtyyobin11x4(Long pZtyyobin11x4) {
        ztyyobin11x4 = pZtyyobin11x4;
    }

    private Long ztyyobin11x25;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYYOBIN11X25)
    public Long getZtyyobin11x25() {
        return ztyyobin11x25;
    }

    public void setZtyyobin11x25(Long pZtyyobin11x25) {
        ztyyobin11x25 = pZtyyobin11x25;
    }

    private Long ztyyobin11x26;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYYOBIN11X26)
    public Long getZtyyobin11x26() {
        return ztyyobin11x26;
    }

    public void setZtyyobin11x26(Long pZtyyobin11x26) {
        ztyyobin11x26 = pZtyyobin11x26;
    }

    private String ztysuuriyouyobin15;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSUURIYOUYOBIN15)
    public String getZtysuuriyouyobin15() {
        return ztysuuriyouyobin15;
    }

    public void setZtysuuriyouyobin15(String pZtysuuriyouyobin15) {
        ztysuuriyouyobin15 = pZtysuuriyouyobin15;
    }

    private String ztysuuriyouyobin15x2;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYSUURIYOUYOBIN15X2)
    public String getZtysuuriyouyobin15x2() {
        return ztysuuriyouyobin15x2;
    }

    public void setZtysuuriyouyobin15x2(String pZtysuuriyouyobin15x2) {
        ztysuuriyouyobin15x2 = pZtysuuriyouyobin15x2;
    }

    private String ztyyobiv15;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYYOBIV15)
    public String getZtyyobiv15() {
        return ztyyobiv15;
    }

    public void setZtyyobiv15(String pZtyyobiv15) {
        ztyyobiv15 = pZtyyobiv15;
    }

    private String ztyyobiv20;

    @Column(name=GenZT_KbkSsuRnduHknIdouVTy.ZTYYOBIV20)
    public String getZtyyobiv20() {
        return ztyyobiv20;
    }

    public void setZtyyobiv20(String pZtyyobiv20) {
        ztyyobiv20 = pZtyyobiv20;
    }
}