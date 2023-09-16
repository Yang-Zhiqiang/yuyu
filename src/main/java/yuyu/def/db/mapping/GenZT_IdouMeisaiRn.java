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
import yuyu.def.db.entity.ZT_IdouMeisaiRn;
import yuyu.def.db.id.PKZT_IdouMeisaiRn;
import yuyu.def.db.meta.GenQZT_IdouMeisaiRn;
import yuyu.def.db.meta.QZT_IdouMeisaiRn;

/**
 * 異動明細Ｆテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_IdouMeisaiRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_IdouMeisaiRn}</td><td colspan="3">異動明細Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnsequenceno zrnsequenceno}</td><td>（連携用）シーケンス番号</td><td align="center">{@link PKZT_IdouMeisaiRn ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnyuukourecordlength zrnyuukourecordlength}</td><td>（連携用）有効レコード長</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnrdwarea zrnrdwarea}</td><td>（連携用）ＲＤＷ領域</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnrecordkbn zrnrecordkbn}</td><td>（連携用）レコード区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigohyouji zrnnenkinkaisigohyouji}</td><td>（連携用）年金開始後表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksgokurikosidhyj zrnnksgokurikosidhyj}</td><td>（連携用）年金開始後繰越Ｄ表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeijyouym zrnkeijyouym}</td><td>（連携用）計上年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnidojiyukbn zrnidojiyukbn}</td><td>（連携用）異動事由区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzougenkbn zrnzougenkbn}</td><td>（連携用）増減区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnidourecordkbn zrnidourecordkbn}</td><td>（連携用）異動レコード区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeijyouctrlkbn zrnkeijyouctrlkbn}</td><td>（連携用）計上コントロール区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhenkousyoriymd zrnhenkousyoriymd}</td><td>（連携用）変更処理年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykmfksnctr zrnkykmfksnctr}</td><td>（連携用）契約ＭＦ更新ＣＴＲ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnrecordctr zrnrecordctr}</td><td>（連携用）レコードＣＴＲ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnsuuriyoukouryokukaisiymd zrnsuuriyoukouryokukaisiymd}</td><td>（連携用）数理用効力開始年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndenymd zrndenymd}</td><td>（連携用）伝票日付</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbluekeizokuhyouji zrnbluekeizokuhyouji}</td><td>（連携用）Ｂｌｕｅ継続表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin1x2 zrnsuuriyouyobin1x2}</td><td>（連携用）数理用予備項目Ｎ１＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntoukeikeijyoukbn zrntoukeikeijyoukbn}</td><td>（連携用）統計計上区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnraysystemhyj zrnraysystemhyj}</td><td>（連携用）ＲＡＹシステム表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzenkiidouteiseikbn zrnzenkiidouteiseikbn}</td><td>（連携用）前期異動訂正区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbsyym zrnbsyym}</td><td>（連携用）募集年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntenkangokeiyakubosyuuym zrntenkangokeiyakubosyuuym}</td><td>（連携用）転換後契約募集年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnidoujiyuucd zrnidoujiyuucd}</td><td>（連携用）異動事由コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyoricd zrnsyoricd}</td><td>（連携用）処理コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsekininteiseihyouji zrnsekininteiseihyouji}</td><td>（連携用）責任訂正表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin8 zrnsuuriyouyobin8}</td><td>（連携用）数理用予備項目Ｎ８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsihankibikinkbn zrnsihankibikinkbn}</td><td>（連携用）四半期備金区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin1x3 zrnsuuriyouyobin1x3}</td><td>（連携用）数理用予備項目Ｎ１＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndatakanrino zrndatakanrino}</td><td>（連携用）データ管理番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknsyukigou zrnhknsyukigou}</td><td>（連携用）保険種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknsyuruikigousedaikbn zrnhknsyuruikigousedaikbn}</td><td>（連携用）保険種類記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsotodasipmenkbn zrnsotodasipmenkbn}</td><td>（連携用）外出Ｐ免区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnstdssytikbn zrnstdssytikbn}</td><td>（連携用）外出集定区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnstdssnskbn zrnstdssnskbn}</td><td>（連携用）外出診査区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsotodasimanagehyouji zrnsotodasimanagehyouji}</td><td>（連携用）外出満年令表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsotodasiphkbnmnoshyouji zrnsotodasiphkbnmnoshyouji}</td><td>（連携用）外出Ｐ不可分見直表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnstdsstkjytkyuhyj zrnstdsstkjytkyuhyj}</td><td>（連携用）外出新特条適用表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkbnkeiriyousegmentkbn zrnkbnkeiriyousegmentkbn}</td><td>（連携用）区分経理用セグメント区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkbnkeiriyourgnbnskkbn zrnkbnkeiriyourgnbnskkbn}</td><td>（連携用）区分経理用利源分析区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuurisyuruicd zrnsuurisyuruicd}</td><td>（連携用）数理種類コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhosyoukinoukbn zrnhosyoukinoukbn}</td><td>（連携用）保障機能区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndaikbn zrndaikbn}</td><td>（連携用）大区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntyuukbn zrntyuukbn}</td><td>（連携用）中区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyoukbn zrnsyoukbn}</td><td>（連携用）小区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsedaikbn zrnsedaikbn}</td><td>（連携用）世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnharaikatakbn zrnharaikatakbn}</td><td>（連携用）払方区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykymd zrnkykymd}</td><td>（連携用）契約年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknkkn zrnhknkkn}</td><td>（連携用）保険期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnphrkkikn zrnphrkkikn}</td><td>（連携用）Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsaimnkkykhyj zrnsaimnkkykhyj}</td><td>（連携用）才満期契約表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnannaifuyouriyuukbn zrnannaifuyouriyuukbn}</td><td>（連携用）案内不要理由区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntksyuannaikykkbn zrntksyuannaikykkbn}</td><td>（連携用）特殊案内契約区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkaisuukbn zrnhrkkaisuukbn}</td><td>（連携用）払込回数区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkeirokbn zrnhrkkeirokbn}</td><td>（連携用）払込経路区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsdpdkbn zrnsdpdkbn}</td><td>（連携用）Ｓ建Ｐ建区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnryouritukbn zrnryouritukbn}</td><td>（連携用）料率区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnao3tyou3sibousdatehyouji zrnao3tyou3sibousdatehyouji}</td><td>（連携用）青３長３死亡Ｓ建表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknseikbn zrnhhknseikbn}</td><td>（連携用）被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhihokensyaagev2 zrnhihokensyaagev2}</td><td>（連携用）被保険者年令Ｖ２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyksyanen zrnkyksyanen}</td><td>（連携用）契約者年令</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2hhknnen zrndai2hhknnen}</td><td>（連携用）第２被保険者年令</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntkbthsyumnryuhyouji zrntkbthsyumnryuhyouji}</td><td>（連携用）特別保障満了表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukeiyakupwaribikikbn zrnsyukeiyakupwaribikikbn}</td><td>（連携用）主契約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntenkanwaribikikbn zrntenkanwaribikikbn}</td><td>（連携用）転換割引区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyuuhitutnknyuguryurtkbn zrnyuuhitutnknyuguryurtkbn}</td><td>（連携用）有配当転換優遇料率区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukeiyakup zrnsyukeiyakup}</td><td>（連携用）主契約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntokujyoup zrntokujyoup}</td><td>（連携用）特条Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsiteizukisyukeiyakup zrnsiteizukisyukeiyakup}</td><td>（連携用）指定月主契約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkihons zrnkihons}</td><td>（連携用）基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsibous zrnsibous}</td><td>（連携用）死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhenkougokihons zrnhenkougokihons}</td><td>（連携用）変更後基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhenkougosibous zrnhenkougosibous}</td><td>（連携用）変更後死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhenkouymd zrnhenkouymd}</td><td>（連携用）変更年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnentyoukikan zrnentyoukikan}</td><td>（連携用）延長期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseizonkyuuhukinsiteimd zrnseizonkyuuhukinsiteimd}</td><td>（連携用）生存給付金指定月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukeiyakusiharaikingaku zrnsyukeiyakusiharaikingaku}</td><td>（連携用）主契約支払金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnatukaisisyatodouhukencd zrnatukaisisyatodouhukencd}</td><td>（連携用）扱支社都道府県コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakuhukasuu zrntokuyakuhukasuu}</td><td>（連携用）特約付加数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrndi2hknkknikoujihisyaage zrndi2hknkknikoujihisyaage}</td><td>（連携用）第２保険期間移行時被者年令</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrimnentyoumaephrkkkn zrnhrimnentyoumaephrkkkn}</td><td>（連携用）払満延長前Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokubetuhosyoukikan zrntokubetuhosyoukikan}</td><td>（連携用）特別保障期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkousinmanryouage zrnkousinmanryouage}</td><td>（連携用）更新満了年令</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnknkuzusnzyrttekitkarihyj zrnknkuzusnzyrttekitkarihyj}</td><td>（連携用）健康増進乗率適用特約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkuriagekurisagekbn zrnkuriagekurisagekbn}</td><td>（連携用）繰上げ繰下げ区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrizmjhknsyukigousdkbn zrnhrizmjhknsyukigousdkbn}</td><td>（連携用）払済時保険種類記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkrsgjhknsyukigousdkbn zrnkrsgjhknsyukigousdkbn}</td><td>（連携用）繰下げ時保険種類記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsotodasisyouhinkaiteikbn zrnsotodasisyouhinkaiteikbn}</td><td>（連携用）外出商品改定区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv4 zrnyobiv4}</td><td>（連携用）予備項目Ｖ４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngoukeitenkans zrngoukeitenkans}</td><td>（連携用）合計転換Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngoukeipbubuntenkans zrngoukeipbubuntenkans}</td><td>（連携用）合計Ｐ部分転換Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntenkanteikisyuruikigou zrntenkanteikisyuruikigou}</td><td>（連携用）転換定期種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntenkanteikikigousedaikbn zrntenkanteikikigousedaikbn}</td><td>（連携用）転換定期記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntnkntiksotodasikusnkbn zrntnkntiksotodasikusnkbn}</td><td>（連携用）転換定期外出更新区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntnkntikstdspmenkbn zrntnkntikstdspmenkbn}</td><td>（連携用）転換定期外出Ｐ免区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntenkanteikikigouyobi zrntenkanteikikigouyobi}</td><td>（連携用）転換定期記号予備</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntenkanteikikikan zrntenkanteikikikan}</td><td>（連携用）転換定期期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngoukeitenkanteikis zrngoukeitenkanteikis}</td><td>（連携用）合計転換定期Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntnknteikinkshrkkn zrntnknteikinkshrkkn}</td><td>（連携用）転換定期年金支払期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntenkansiharaikingaku zrntenkansiharaikingaku}</td><td>（連携用）転換支払金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntnkntikshrkngk zrntnkntikshrkngk}</td><td>（連携用）転換定期支払金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntenkankaisuu zrntenkankaisuu}</td><td>（連携用）転換回数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngoukeitenkankakaku zrngoukeitenkankakaku}</td><td>（連携用）合計転換価格</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntnknkhnbbnjyuturt zrntnknkhnbbnjyuturt}</td><td>（連携用）転換基本部分充当率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnwnasigoukeitenkanteikis zrnwnasigoukeitenkanteikis}</td><td>（連携用）Ｗなし合計転換定期Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntnknteikikousinmnryouage zrntnknteikikousinmnryouage}</td><td>（連携用）転換定期更新満了年令</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv5 zrnyobiv5}</td><td>（連携用）予備項目Ｖ５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkanyujidatakanrino zrnkanyujidatakanrino}</td><td>（連携用）加入時データ管理番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkanyujikykymd zrnkanyujikykymd}</td><td>（連携用）加入時契約年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkanyuujihihokensyaage zrnkanyuujihihokensyaage}</td><td>（連携用）加入時被保険者年令</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkanyuujitenkanhyouji zrnkanyuujitenkanhyouji}</td><td>（連携用）加入時転換表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhsyuikktminaosikaisu zrnhsyuikktminaosikaisu}</td><td>（連携用）保障一括見直回数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsknnjynbknsisnrt zrnsknnjynbknsisnrt}</td><td>（連携用）責任準備金精算率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrntkjykbn zrntkjykbn}</td><td>（連携用）特条区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsakugenkikan zrnsakugenkikan}</td><td>（連携用）削減期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnryoumasihyouten zrnryoumasihyouten}</td><td>（連携用）料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnsykyktkjyuryumsratehyj zrnsykyktkjyuryumsratehyj}</td><td>（連携用）主契約特条料増レート表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsykyktkjyuryumsrate zrnsykyktkjyuryumsrate}</td><td>（連携用）主契約特条料増レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrndai2tokujyoukbn zrndai2tokujyoukbn}</td><td>（連携用）第２特条区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2sakugenkikan zrndai2sakugenkikan}</td><td>（連携用）第２削減期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2ryoumasihyouten zrndai2ryoumasihyouten}</td><td>（連携用）第２料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrntokuteibuijyoukenhyouji zrntokuteibuijyoukenhyouji}</td><td>（連携用）特定部位条件表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuteibuino1 zrntokuteibuino1}</td><td>（連携用）特定部位番号１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnpkkn1 zrnhtnpkkn1}</td><td>（連携用）不担保期間１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuteibuino2 zrntokuteibuino2}</td><td>（連携用）特定部位番号２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnpkkn2 zrnhtnpkkn2}</td><td>（連携用）不担保期間２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmhituiryuyutktbijyknhyj zrnmhituiryuyutktbijyknhyj}</td><td>（連携用）無配当医療用特定部位条件表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmuhaitouiryouyoutktbino1 zrnmuhaitouiryouyoutktbino1}</td><td>（連携用）無配当医療用特定部位番号１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmuhaitouiryouyouhtnpkkn1 zrnmuhaitouiryouyouhtnpkkn1}</td><td>（連携用）無配当医療用不担保期間１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmuhaitouiryouyoutktbino2 zrnmuhaitouiryouyoutktbino2}</td><td>（連携用）無配当医療用特定部位番号２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmuhaitouiryouyouhtnpkkn2 zrnmuhaitouiryouyouhtnpkkn2}</td><td>（連携用）無配当医療用不担保期間２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiteizukipwarimasihyouji zrnsiteizukipwarimasihyouji}</td><td>（連携用）指定月Ｐ割増表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpwarimasisiteim1 zrnpwarimasisiteim1}</td><td>（連携用）Ｐ割増指定月１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpwarimasisiteim2 zrnpwarimasisiteim2}</td><td>（連携用）Ｐ割増指定月２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiteimsykykpbairitu zrnsiteimsykykpbairitu}</td><td>（連携用）指定月主契約Ｐ倍率</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsaisyuusiteiym zrnsaisyuusiteiym}</td><td>（連携用）最終指定年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsykykkitmttvkeisanym zrnsykykkitmttvkeisanym}</td><td>（連携用）主契約既積立Ｖ計算年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsykykkitmttsknnjynbkngk zrnsykykkitmttsknnjynbkngk}</td><td>（連携用）主契約既積立責任準備金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrndftumitatekingaku zrndftumitatekingaku}</td><td>（連携用）ＤＦ積立金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrndftumimasikin zrndftumimasikin}</td><td>（連携用）ＤＦ積増金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnvbubundftenkankakaku zrnvbubundftenkankakaku}</td><td>（連携用）Ｖ部分ＤＦ転換価格</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrndpbubundftenkankakaku zrndpbubundftenkankakaku}</td><td>（連携用）ＤＰ部分ＤＦ転換価格</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrndftmttkngkitjbrbbn zrndftmttkngkitjbrbbn}</td><td>（連携用）ＤＦ積立金額一時払部分</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhendous zrnhendous}</td><td>（連携用）変動Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhengakujigyounendomatucv zrnhengakujigyounendomatucv}</td><td>（連携用）変額事業年度末ＣＶ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnitibuitijibarais zrnitibuitijibarais}</td><td>（連携用）一部一時払Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnitibuitijibaraip zrnitibuitijibaraip}</td><td>（連携用）一部一時払Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnitibitjbrshrkngk zrnitibitjbrshrkngk}</td><td>（連携用）一部一時払支払金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngoukeicv zrngoukeicv}</td><td>（連携用）合計ＣＶ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnminasicv zrnminasicv}</td><td>（連携用）みなしＣＶ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnloanfund zrnloanfund}</td><td>（連携用）ローンファンド</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsaiteihosyougaku zrnsaiteihosyougaku}</td><td>（連携用）最低保証額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhngksitihsyuyusykykp zrnhngksitihsyuyusykykp}</td><td>（連携用）変額最低保証用主契約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhijynbrivasbujsitihsyugk zrnhijynbrivasbujsitihsyugk}</td><td>（連携用）平準払ＶＡ死亡時最低保証金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhijynbrivamnkjsitihsyugk zrnhijynbrivamnkjsitihsyugk}</td><td>（連携用）平準払ＶＡ満期時最低保証金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsiinkbn zrnsiinkbn}</td><td>（連携用）死因区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmudkaimasikihons zrnmudkaimasikihons}</td><td>（連携用）ミューＤ買増基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkaimasiymd zrnkaimasiymd}</td><td>（連携用）買増年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaimasikikan zrnkaimasikikan}</td><td>（連携用）買増期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhikitugikaimasis zrnhikitugikaimasis}</td><td>（連携用）引継買増Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnmudkaimasisiharaikingaku zrnmudkaimasisiharaikingaku}</td><td>（連携用）ミューＤ買増支払金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnszoukouryokukaisiymdx1 zrnszoukouryokukaisiymdx1}</td><td>（連携用）Ｓ増効力開始年月日＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnszouhokensyuruikigoux1 zrnszouhokensyuruikigoux1}</td><td>（連携用）Ｓ増保険種類記号＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnszoukigousedaikbnx1 zrnszoukigousedaikbnx1}</td><td>（連携用）Ｓ増記号世代区分＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnszoukikanx1 zrnszoukikanx1}</td><td>（連携用）Ｓ増期間＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnszouhihokensyaagex1 zrnszouhihokensyaagex1}</td><td>（連携用）Ｓ増被保険者年令＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnszoudai2hihknsyaagex1 zrnszoudai2hihknsyaagex1}</td><td>（連携用）Ｓ増第２被保険者年令＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzoukasx1 zrnzoukasx1}</td><td>（連携用）増加Ｓ＿１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnzennendozoukasx1 zrnzennendozoukasx1}</td><td>（連携用）前年度増加Ｓ＿１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnszousiharaikingakux1 zrnszousiharaikingakux1}</td><td>（連携用）Ｓ増支払金額＿１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnszoukouryokukaisiymdx2 zrnszoukouryokukaisiymdx2}</td><td>（連携用）Ｓ増効力開始年月日＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnszouhokensyuruikigoux2 zrnszouhokensyuruikigoux2}</td><td>（連携用）Ｓ増保険種類記号＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnszoukigousedaikbnx2 zrnszoukigousedaikbnx2}</td><td>（連携用）Ｓ増記号世代区分＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnszoukikanx2 zrnszoukikanx2}</td><td>（連携用）Ｓ増期間＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnszouhihokensyaagex2 zrnszouhihokensyaagex2}</td><td>（連携用）Ｓ増被保険者年令＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnszoudai2hihknsyaagex2 zrnszoudai2hihknsyaagex2}</td><td>（連携用）Ｓ増第２被保険者年令＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzoukasx2 zrnzoukasx2}</td><td>（連携用）増加Ｓ＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnzennendozoukasx2 zrnzennendozoukasx2}</td><td>（連携用）前年度増加Ｓ＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnszousiharaikingakux2 zrnszousiharaikingakux2}</td><td>（連携用）Ｓ増支払金額＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin1x5 zrnsuuriyouyobin1x5}</td><td>（連携用）数理用予備項目Ｎ１＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin1x6 zrnsuuriyouyobin1x6}</td><td>（連携用）数理用予備項目Ｎ１＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrimngkizktkykpmenhyj zrnhrimngkizktkykpmenhyj}</td><td>（連携用）払満後継続特約Ｐ免表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmisyuustartym zrnmisyuustartym}</td><td>（連携用）未収開始年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmisyuukaisuu zrnmisyuukaisuu}</td><td>（連携用）未収回数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnitjbrtkykkousnuktkarhyj zrnitjbrtkykkousnuktkarhyj}</td><td>（連携用）一時払特約更新受付有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngyousekihyoujis zrngyousekihyoujis}</td><td>（連携用）業績表示Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsykykgyusekihyjs zrnsykykgyusekihyjs}</td><td>（連携用）主契約業績表示Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntenkangyousekihyoujis zrntenkangyousekihyoujis}</td><td>（連携用）転換業績表示Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntnknteikigyousekihyjs zrntnknteikigyousekihyjs}</td><td>（連携用）転換定期業績表示Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntnkndpbbngyuskhyjs zrntnkndpbbngyuskhyjs}</td><td>（連携用）転換ＤＰ部分業績表示Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkykjyoutai zrnkykjyoutai}</td><td>（連携用）契約状態</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpmenhukakbn zrnpmenhukakbn}</td><td>（連携用）Ｐ免付加区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkousinkbn zrnkousinkbn}</td><td>（連携用）更新区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmankiyoteikbn zrnmankiyoteikbn}</td><td>（連携用）満期予定区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsykyktikmnkyoteikbn zrnsykyktikmnkyoteikbn}</td><td>（連携用）主契約定期満期予定区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntnknsykykkhnmnkytikbn zrntnknsykykkhnmnkytikbn}</td><td>（連携用）転換主契約基本満期予定区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntnknsykyktikmnkytikbn zrntnknsykyktikmnkytikbn}</td><td>（連携用）転換主契約定期満期予定区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntenkanteikimankiyoteikbn zrntenkanteikimankiyoteikbn}</td><td>（連携用）転換定期満期予定区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnszoumankiyoteikbnx1 zrnszoumankiyoteikbnx1}</td><td>（連携用）Ｓ増満期予定区分＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnszoumankiyoteikbnx2 zrnszoumankiyoteikbnx2}</td><td>（連携用）Ｓ増満期予定区分＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnvestingmankiyoteikbn zrnvestingmankiyoteikbn}</td><td>（連携用）ベスティング満期予定区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnvkeisanhyouji zrnvkeisanhyouji}</td><td>（連携用）Ｖ計算表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntoukisinkeiyakuhyouji zrntoukisinkeiyakuhyouji}</td><td>（連携用）当期新契約表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsykykhokenhoutekiyouhyj zrnsykykhokenhoutekiyouhyj}</td><td>（連携用）主契約保険法適用表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuteijyoutaihushrhyj zrntokuteijyoutaihushrhyj}</td><td>（連携用）特定状態不支払表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnytirrthndsysnmnskaisuu zrnytirrthndsysnmnskaisuu}</td><td>（連携用）予定利率変動終身見直回数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin3 zrnsuuriyouyobin3}</td><td>（連携用）数理用予備項目Ｎ３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin11 zrnsuuriyouyobin11}</td><td>（連携用）数理用予備項目Ｎ１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwnasigoukeitenkankakaku zrnwnasigoukeitenkankakaku}</td><td>（連携用）Ｗなし合計転換価格</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11 zrnyobin11}</td><td>（連携用）予備項目Ｎ１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x2 zrnyobin11x2}</td><td>（連携用）予備項目Ｎ１１＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x3 zrnyobin11x3}</td><td>（連携用）予備項目Ｎ１１＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntukibaraikansantokujyoup zrntukibaraikansantokujyoup}</td><td>（連携用）月払換算特条Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntnkngkykkssnkijyuym zrntnkngkykkssnkijyuym}</td><td>（連携用）転換後契約決算計上年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsaiteihosyouhyouji zrnsaiteihosyouhyouji}</td><td>（連携用）最低保証表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin8x2 zrnsuuriyouyobin8x2}</td><td>（連携用）数理用予備項目Ｎ８＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin14 zrnsuuriyouyobin14}</td><td>（連携用）数理用予備項目Ｎ１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrimngtkykphrkkaisuukbn zrnhrimngtkykphrkkaisuukbn}</td><td>（連携用）払満後特約Ｐ払込回数区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrimngtkykphrkkirkbn zrnhrimngtkykphrkkirkbn}</td><td>（連携用）払満後特約Ｐ払込経路区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrimngtkykpryurtkbn zrnhrimngtkykpryurtkbn}</td><td>（連携用）払満後特約Ｐ料率区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv13 zrnyobiv13}</td><td>（連携用）予備項目Ｖ１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnidoujisaiteihosyoukngk zrnidoujisaiteihosyoukngk}</td><td>（連携用）異動時最低保証金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnidoujisaiteihosyoucost zrnidoujisaiteihosyoucost}</td><td>（連携用）異動時最低保証コスト</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsinhokenfundtumitatekin zrnsinhokenfundtumitatekin}</td><td>（連携用）新保険ファンド積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnmsyuptusshkgkaiykhnrikn zrnmsyuptusshkgkaiykhnrikn}</td><td>（連携用）未収Ｐ等差引後解約返戻金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnrrthndugtnkgetumatuv zrnrrthndugtnkgetumatuv}</td><td>（連携用）利率変動型年金月末Ｖ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnrrthndnksaiteihosyonkgns zrnrrthndnksaiteihosyonkgns}</td><td>（連携用）利率変動年金最低保証年金原資</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnrrthendougatanksibous zrnrrthendougatanksibous}</td><td>（連携用）利率変動型年金死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnalmyousohutomeisyoukbn zrnalmyousohutomeisyoukbn}</td><td>（連携用）ＡＬＭ用ソフト名称区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsnkyksoftmeisyoukbn zrnsnkyksoftmeisyoukbn}</td><td>（連携用）新契約ソフト名称区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsoftmeisyoukbn zrnsoftmeisyoukbn}</td><td>（連携用）ソフト名称区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykjitokujyouarihyj zrnkykjitokujyouarihyj}</td><td>（連携用）契約時特条有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbnkttnknkbn zrnbnkttnknkbn}</td><td>（連携用）分割転換区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntenkanminaosikbn zrntenkanminaosikbn}</td><td>（連携用）転換見直区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsoujikeitenkankbn zrnsoujikeitenkankbn}</td><td>（連携用）相似形転換区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisinendo zrnnenkinkaisinendo}</td><td>（連携用）年金開始年度</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkingatakbn zrnnenkingatakbn}</td><td>（連携用）年金型区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnknshry zrnnknshry}</td><td>（連携用）年金支払期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnheiyoubaraikeiyakukbn zrnheiyoubaraikeiyakukbn}</td><td>（連携用）併用払契約区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinmaruteihukakbn zrnnenkinmaruteihukakbn}</td><td>（連携用）年金マル定付加区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsinseizonmrtiarihyj zrnsinseizonmrtiarihyj}</td><td>（連携用）新生存マル定有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsnkykyouibokijyukbn zrnsnkykyouibokijyukbn}</td><td>（連携用）新契約用異募計上区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokusitujyuusitusetkbn zrntokusitujyuusitusetkbn}</td><td>（連携用）特疾重疾セット区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiktsyuknbyugnhsyunshyj zrnsiktsyuknbyugnhsyunshyj}</td><td>（連携用）生活習慣病がん保障無表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpmensugugtganhsyunshyj zrnpmensugugtganhsyunshyj}</td><td>（連携用）Ｐ免総合型がん保障無表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntkykgyousekihyjszerohyj zrntkykgyousekihyjszerohyj}</td><td>（連携用）特約業績表示Ｓゼロ表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin7 zrnsuuriyouyobin7}</td><td>（連携用）数理用予備項目Ｎ７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyussaikeitaikbn zrnsyussaikeitaikbn}</td><td>（連携用）出再形態区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv6 zrnyobiv6}</td><td>（連携用）予備項目Ｖ６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbosyuukeitaikbn zrnbosyuukeitaikbn}</td><td>（連携用）募集形態区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnaatukaisosikicd zrnaatukaisosikicd}</td><td>（連携用）Ａ扱者組織コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnaatukaikojincd zrnaatukaikojincd}</td><td>（連携用）Ａ扱者個人コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbsydrtencd zrnbsydrtencd}</td><td>（連携用）募集代理店コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrncifcd zrncifcd}</td><td>（連携用）ＣＩＦコード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobiv8 zrnsuuriyouyobiv8}</td><td>（連携用）数理用予備項目Ｖ８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsinsakbn zrnsinsakbn}</td><td>（連携用）診査区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2hihokensyasinsakbn zrndai2hihokensyasinsakbn}</td><td>（連携用）第２被保険者診査区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntoukeiyousinsakbn zrntoukeiyousinsakbn}</td><td>（連携用）統計用診査区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2toukeiyousinsakbn zrndai2toukeiyousinsakbn}</td><td>（連携用）第２統計用診査区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnketteikijyunkanwakbn zrnketteikijyunkanwakbn}</td><td>（連携用）決定基準緩和区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkihonsibouhyoukbn zrnkihonsibouhyoukbn}</td><td>（連携用）基本死亡表区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteikisibouhyoukbn zrnteikisibouhyoukbn}</td><td>（連携用）定期死亡表区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsonotasibouhyoukbn zrnsonotasibouhyoukbn}</td><td>（連携用）その他死亡表区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmrarihyj zrnmrarihyj}</td><td>（連携用）ＭＲ有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsentakujyouhouarihyouji zrnsentakujyouhouarihyouji}</td><td>（連携用）選択情報有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndugktnknsntkhuhukbn zrndugktnknsntkhuhukbn}</td><td>（連携用）同額転換選択方法区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngengakutenkankykhyj zrngengakutenkankykhyj}</td><td>（連携用）減額転換契約表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsykgycd zrnsykgycd}</td><td>（連携用）職業コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjidoukousinkykkanyuuymd zrnjidoukousinkykkanyuuymd}</td><td>（連携用）自動更新契約加入年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsaikohtnknkykkykymd zrnsaikohtnknkykkykymd}</td><td>（連携用）最古被転換契約契約年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkousinmaesykyksburtkbn zrnkousinmaesykyksburtkbn}</td><td>（連携用）更新前主契約死亡率区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhjnkykhyj zrnhjnkykhyj}</td><td>（連携用）法人契約表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnanniskcd zrnanniskcd}</td><td>（連携用）案内先コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhjncd zrnhjncd}</td><td>（連携用）法人コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhjnjigyosyocd zrnhjnjigyosyocd}</td><td>（連携用）法人事業所コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsaihokenno zrnsaihokenno}</td><td>（連携用）再保険番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndakuhikettikekkacd zrndakuhikettikekkacd}</td><td>（連携用）諾否決定結果コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2dakuhiketteikekkacd zrndai2dakuhiketteikekkacd}</td><td>（連携用）第２諾否決定結果コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpmenkbnv2 zrnpmenkbnv2}</td><td>（連携用）Ｐ免区分Ｖ２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiboukyuuhukin zrnsiboukyuuhukin}</td><td>（連携用）死亡給付金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnjyudthumeharaitkykhkhyj zrnjyudthumeharaitkykhkhyj}</td><td>（連携用）重度痴呆前払特約付加表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhaitoukbn zrnhaitoukbn}</td><td>（連携用）配当区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknnentysihyj zrnhhknnentysihyj}</td><td>（連携用）被保険者年令調整表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2hhknnentysihyj zrndai2hhknnentysihyj}</td><td>（連携用）第２被保険者年令調整表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyksyaagetyouseihyj zrnkyksyaagetyouseihyj}</td><td>（連携用）契約者年令調整表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkituenkbn zrnkituenkbn}</td><td>（連携用）喫煙区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkituenhonsuu zrnkituenhonsuu}</td><td>（連携用）喫煙本数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmusentakukeiyakukbn zrnmusentakukeiyakukbn}</td><td>（連携用）無選択契約区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv6x2 zrnyobiv6x2}</td><td>（連携用）予備項目Ｖ６＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnlivingneedstkykarihyj zrnlivingneedstkykarihyj}</td><td>（連携用）リビングニーズ特約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnlivingneedssiharaihyouji zrnlivingneedssiharaihyouji}</td><td>（連携用）リビングニーズ支払表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnlnseikyuuymd zrnlnseikyuuymd}</td><td>（連携用）ＬＮ請求年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnlnshrgenincd zrnlnshrgenincd}</td><td>（連携用）ＬＮ支払原因コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndakuhikettisyacd zrndakuhikettisyacd}</td><td>（連携用）諾否決定者コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2dakuhiketteisyacd zrndai2dakuhiketteisyacd}</td><td>（連携用）第２諾否決定者コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngansapotokuyakuarihyouji zrngansapotokuyakuarihyouji}</td><td>（連携用）がんサポ特約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngnspshrhyj zrngnspshrhyj}</td><td>（連携用）がんサポ支払表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngansaposeikyuuymd zrngansaposeikyuuymd}</td><td>（連携用）がんサポ請求年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngnspshrgenincd zrngnspshrgenincd}</td><td>（連携用）がんサポ支払原因コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv3x2 zrnyobiv3x2}</td><td>（連携用）予備項目Ｖ３＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntargetmokuhyouritu zrntargetmokuhyouritu}</td><td>（連携用）ターゲット目標率</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnautoswitchmokuhyouritu zrnautoswitchmokuhyouritu}</td><td>（連携用）オートスイッチ目標率</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntumitatekinitenarihyj zrntumitatekinitenarihyj}</td><td>（連携用）積立金移転有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntumitatekinitenkaisuu zrntumitatekinitenkaisuu}</td><td>（連携用）積立金移転回数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndatakanrino2 zrndatakanrino2}</td><td>（連携用）データ管理番号２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndatakanrino3 zrndatakanrino3}</td><td>（連携用）データ管理番号３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnknkuzusnzyrttekinendo zrnknkuzusnzyrttekinendo}</td><td>（連携用）健康増進乗率適用年度</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnknkuzusnzyrt zrnknkuzusnzyrt}</td><td>（連携用）健康増進乗率</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnknkuzusnzyrtx2 zrnknkuzusnzyrtx2}</td><td>（連携用）健康増進乗率＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnknkuzusnzyrtx3 zrnknkuzusnzyrtx3}</td><td>（連携用）健康増進乗率＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsinkeiyakujiknkuzusnzyrt zrnsinkeiyakujiknkuzusnzyrt}</td><td>（連携用）新契約時健康増進乗率</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntenkanjiknkuzusnzyrt zrntenkanjiknkuzusnzyrt}</td><td>（連携用）転換時健康増進乗率</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsinkeiyakujivithkhyouji zrnsinkeiyakujivithkhyouji}</td><td>（連携用）新契約時Ｖｉｔ保険表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykjivithukusuukykhyj zrnkykjivithukusuukykhyj}</td><td>（連携用）契約時Ｖｉｔ複数契約表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin9x2 zrnsuuriyouyobin9x2}</td><td>（連携用）数理用予備項目Ｎ９＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpwrbksidhitekiyouhyj zrnpwrbksidhitekiyouhyj}</td><td>（連携用）保険料割引制度非適用表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin9 zrnsuuriyouyobin9}</td><td>（連携用）数理用予備項目Ｎ９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin10x7 zrnsuuriyouyobin10x7}</td><td>（連携用）数理用予備項目Ｎ１０＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin10x8 zrnsuuriyouyobin10x8}</td><td>（連携用）数理用予備項目Ｎ１０＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin10x9 zrnsuuriyouyobin10x9}</td><td>（連携用）数理用予備項目Ｎ１０＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntumitatekinitenbubun zrntumitatekinitenbubun}</td><td>（連携用）積立金移転部分</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsagakusknnjynbknzndk zrnsagakusknnjynbknzndk}</td><td>（連携用）差額責任準備金残高</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x5 zrnyobin11x5}</td><td>（連携用）予備項目Ｎ１１＿５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x6 zrnyobin11x6}</td><td>（連携用）予備項目Ｎ１１＿６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x7 zrnyobin11x7}</td><td>（連携用）予備項目Ｎ１１＿７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x8 zrnyobin11x8}</td><td>（連携用）予備項目Ｎ１１＿８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x9 zrnyobin11x9}</td><td>（連携用）予備項目Ｎ１１＿９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x10 zrnyobin11x10}</td><td>（連携用）予備項目Ｎ１１＿１０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x11 zrnyobin11x11}</td><td>（連携用）予備項目Ｎ１１＿１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x12 zrnyobin11x12}</td><td>（連携用）予備項目Ｎ１１＿１２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x13 zrnyobin11x13}</td><td>（連携用）予備項目Ｎ１１＿１３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x14 zrnyobin11x14}</td><td>（連携用）予備項目Ｎ１１＿１４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x15 zrnyobin11x15}</td><td>（連携用）予備項目Ｎ１１＿１５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x16 zrnyobin11x16}</td><td>（連携用）予備項目Ｎ１１＿１６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x17 zrnyobin11x17}</td><td>（連携用）予備項目Ｎ１１＿１７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnzyrthntiyustatuskbn zrnzyrthntiyustatuskbn}</td><td>（連携用）乗率判定用ステータス区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzyrthntiyustatuskbnx2 zrnzyrthntiyustatuskbnx2}</td><td>（連携用）乗率判定用ステータス区分＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzyrthntiyustatuskbnx3 zrnzyrthntiyustatuskbnx3}</td><td>（連携用）乗率判定用ステータス区分＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzyrthntiyustatuskbnx4 zrnzyrthntiyustatuskbnx4}</td><td>（連携用）乗率判定用ステータス区分＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzyrthntiyustatuskbnx5 zrnzyrthntiyustatuskbnx5}</td><td>（連携用）乗率判定用ステータス区分＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv10 zrnyobiv10}</td><td>（連携用）予備項目Ｖ１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv15x2 zrnyobiv15x2}</td><td>（連携用）予備項目Ｖ１５＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv15x3 zrnyobiv15x3}</td><td>（連携用）予備項目Ｖ１５＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv15x4 zrnyobiv15x4}</td><td>（連携用）予備項目Ｖ１５＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngaikakbn zrngaikakbn}</td><td>（連携用）外貨区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkawaserate1 zrnkawaserate1}</td><td>（連携用）為替レート１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnkawaseratetekiyouymd1 zrnkawaseratetekiyouymd1}</td><td>（連携用）為替レート適用年月日１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkawaserate2 zrnkawaserate2}</td><td>（連携用）為替レート２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnkawaseratetekiyouymd2 zrnkawaseratetekiyouymd2}</td><td>（連携用）為替レート適用年月日２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykjikawaserate zrnkykjikawaserate}</td><td>（連携用）契約時為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnkykjikawaseratetkyuymd zrnkykjikawaseratetkyuymd}</td><td>（連携用）契約時為替レート適用年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvatyouseigow zrnmvatyouseigow}</td><td>（連携用）ＭＶＡ調整後Ｗ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnmvakeisanjisknnjynbkn zrnmvakeisanjisknnjynbkn}</td><td>（連携用）ＭＶＡ計算時責任準備金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkaiyakukoujyoritu zrnkaiyakukoujyoritu}</td><td>（連携用）解約控除率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnrendouritu zrnrendouritu}</td><td>（連携用）連動率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnsrkaiyakusjkkktyouseirrt zrnsrkaiyakusjkkktyouseirrt}</td><td>（連携用）数理用解約時市場価格調整用利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnsrkyksjkkktyouseiriritu zrnsrkyksjkkktyouseiriritu}</td><td>（連携用）数理用契約時市場価格調整用利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnmvakeisankijyunymd zrnmvakeisankijyunymd}</td><td>（連携用）ＭＶＡ計算基準年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvatyouseikou zrnmvatyouseikou}</td><td>（連携用）ＭＶＡ調整項</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnenkdtsbujsitihsyukngk zrnenkdtsbujsitihsyukngk}</td><td>（連携用）円貨建死亡時最低保証金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnenkdtsbujsitihsyucost zrnenkdtsbujsitihsyucost}</td><td>（連携用）円貨建死亡時最低保証コスト</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnenkdtsbujsitihsyuarihyj zrnenkdtsbujsitihsyuarihyj}</td><td>（連携用）円貨建死亡時最低保証あり表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeiyakujiyoteiriritu zrnkeiyakujiyoteiriritu}</td><td>（連携用）契約時予定利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrntumitateriritu zrntumitateriritu}</td><td>（連携用）積立利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnkaigomaebaraitkykarihyj zrnkaigomaebaraitkykarihyj}</td><td>（連携用）介護前払特約あり表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsibouhyoukbn zrnsibouhyoukbn}</td><td>（連携用）死亡表区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnyuukintuukakbn zrnnyuukintuukakbn}</td><td>（連携用）入金通貨区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiharaituukakbn zrnsiharaituukakbn}</td><td>（連携用）支払通貨区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwyendttargetmokuhyouritu zrnwyendttargetmokuhyouritu}</td><td>（連携用）円建Ｗターゲット目標率</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuurendourate zrnsisuurendourate}</td><td>（連携用）指数連動部分割合</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuukbn zrnsisuukbn}</td><td>（連携用）指数区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteirituikouhyouji zrnteirituikouhyouji}</td><td>（連携用）定率移行表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsrdai1hknkkn zrnsrdai1hknkkn}</td><td>（連携用）数理用第１保険期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin10x11 zrnsuuriyouyobin10x11}</td><td>（連携用）数理用予備項目Ｎ１０＿１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntmttknzoukaritujygn zrntmttknzoukaritujygn}</td><td>（連携用）積立金増加率上限</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnsetteibairitu zrnsetteibairitu}</td><td>（連携用）設定倍率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrntykzenoutouymdsisuu zrntykzenoutouymdsisuu}</td><td>（連携用）直前応当日指数</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnkimatusisuu zrnkimatusisuu}</td><td>（連携用）期末指数</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrntuukasyukbn zrntuukasyukbn}</td><td>（連携用）通貨種類区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv2 zrnyobiv2}</td><td>（連携用）予備項目Ｖ２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyenkadatekihons zrnyenkadatekihons}</td><td>（連携用）円貨建基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsitihsyumegkdtsibous zrnsitihsyumegkdtsibous}</td><td>（連携用）最低保証前外貨建死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnenkdtssrentumitatekin zrnenkdtssrentumitatekin}</td><td>（連携用）円貨建指数連動部分積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsisuurentumitatekin zrnsisuurentumitatekin}</td><td>（連携用）指数連動部分積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnnksjitirttumitatekin zrnnksjitirttumitatekin}</td><td>（連携用）年金開始時定率部分積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkimatutirttumitatekin zrnkimatutirttumitatekin}</td><td>（連携用）期末定率部分積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngaikadatejyuutoup zrngaikadatejyuutoup}</td><td>（連携用）外貨建充当Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyendttargetkijyunkingaku zrnyendttargetkijyunkingaku}</td><td>（連携用）円建ターゲット基準金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobiv7 zrnyobiv7}</td><td>（連携用）予備項目Ｖ７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsitivkisnyukykjikwsrate zrnsitivkisnyukykjikwsrate}</td><td>（連携用）最低Ｖ計算用契約時為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnsisuurentyokugotmttkn zrnsisuurentyokugotmttkn}</td><td>（連携用）指数連動部分直後積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyoteiririturironbase zrnyoteiririturironbase}</td><td>（連携用）予定利率（理論ベース）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnyoteiriritujtnyknbase zrnyoteiriritujtnyknbase}</td><td>（連携用）予定利率（実入金ベース）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnkihrkmpjtnyknbase zrnkihrkmpjtnyknbase}</td><td>（連携用）既払込Ｐ（実入金ベース）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsyuptumitatekin zrnsyuptumitatekin}</td><td>（連携用）主契約保険料積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsyuptumitatekingsc zrnsyuptumitatekingsc}</td><td>（連携用）主契約保険料積立金（月初）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngaikadatenkgns zrngaikadatenkgns}</td><td>（連携用）外貨建年金原資</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnjikaipjyuutouym2 zrnjikaipjyuutouym2}</td><td>（連携用）次回Ｐ充当年月２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyobin9 zrnsuuriyobin9}</td><td>（連携用）数理予備項目Ｎ９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrngessitumitatekin zrngessitumitatekin}</td><td>（連携用）月始積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngaikadatetougetujuutoup zrngaikadatetougetujuutoup}</td><td>（連携用）外貨建当月充当Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkihrkmpmsukisymbase zrnkihrkmpmsukisymbase}</td><td>（連携用）既払込Ｐ（未収開始月ベース）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkeisanhanteiyoutmttkn zrnkeisanhanteiyoutmttkn}</td><td>（連携用）計算判定用積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngtmtv zrngtmtv}</td><td>（連携用）月末Ｖ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnzettaisibouritu zrnzettaisibouritu}</td><td>（連携用）絶対死亡率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnsoutaisibouritu zrnsoutaisibouritu}</td><td>（連携用）相対死亡率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnsoutaikaiyakuritu zrnsoutaikaiyakuritu}</td><td>（連携用）相対解約率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnvhireilritu2 zrnvhireilritu2}</td><td>（連携用）Ｖ比例Ｌ率２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnphireialpha zrnphireialpha}</td><td>（連携用）Ｐ比例α</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnphireibeta zrnphireibeta}</td><td>（連携用）Ｐ比例β</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnphireiganma zrnphireiganma}</td><td>（連携用）Ｐ比例γ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnphireilwrbkritu zrnphireilwrbkritu}</td><td>（連携用）Ｐ比例Ｌ割引率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnyoteiriritumsukisymbase zrnyoteiriritumsukisymbase}</td><td>（連携用）予定利率（未収開始月ベース）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnrrthnduhknvkisovkisnyu1 zrnrrthnduhknvkisovkisnyu1}</td><td>（連携用）利率変動保険Ｖ基礎Ｖ計算用１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnrrthnduhknvkisovkisnyu2 zrnrrthnduhknvkisovkisnyu2}</td><td>（連携用）利率変動保険Ｖ基礎Ｖ計算用２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnrrthnduhknvkisovkisnyu3 zrnrrthnduhknvkisovkisnyu3}</td><td>（連携用）利率変動保険Ｖ基礎Ｖ計算用３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnrrthnduhknvkisovkisnyu4 zrnrrthnduhknvkisovkisnyu4}</td><td>（連携用）利率変動保険Ｖ基礎Ｖ計算用４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnrrthnduhknvkiso zrnrrthnduhknvkiso}</td><td>（連携用）利率変動保険Ｖ基礎Ｖ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntumitatekin zrntumitatekin}</td><td>（連携用）積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkiharaikomip zrnkiharaikomip}</td><td>（連携用）既払込Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngaikadatesyukeiyakup zrngaikadatesyukeiyakup}</td><td>（連携用）外貨建主契約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkykkjmmvatyouseigow zrnkykkjmmvatyouseigow}</td><td>（連携用）解約控除前ＭＶＡ調整後Ｗ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x39 zrnyobin11x39}</td><td>（連携用）予備項目Ｎ１１＿３９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x41 zrnyobin11x41}</td><td>（連携用）予備項目Ｎ１１＿４１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x42 zrnyobin11x42}</td><td>（連携用）予備項目Ｎ１１＿４２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x43 zrnyobin11x43}</td><td>（連携用）予備項目Ｎ１１＿４３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x44 zrnyobin11x44}</td><td>（連携用）予備項目Ｎ１１＿４４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x45 zrnyobin11x45}</td><td>（連携用）予備項目Ｎ１１＿４５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin15x3 zrnsuuriyouyobin15x3}</td><td>（連携用）数理用予備項目Ｎ１５＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin15x4 zrnsuuriyouyobin15x4}</td><td>（連携用）数理用予備項目Ｎ１５＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin15x5 zrnsuuriyouyobin15x5}</td><td>（連携用）数理用予備項目Ｎ１５＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin15x6 zrnsuuriyouyobin15x6}</td><td>（連携用）数理用予備項目Ｎ１５＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv14 zrnyobiv14}</td><td>（連携用）予備項目Ｖ１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyksyhhknsydouituhyouji zrnkyksyhhknsydouituhyouji}</td><td>（連携用）契約者被保険者同一表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyksyaskinmeino zrnkyksyaskinmeino}</td><td>（連携用）契約者索引名番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngoukeikihons zrngoukeikihons}</td><td>（連携用）合計基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngoukeigyousekihyjsibous zrngoukeigyousekihyjsibous}</td><td>（連携用）合計業績表示死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnalmyousibous zrnalmyousibous}</td><td>（連携用）ＡＬＭ用死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnharaikomip zrnharaikomip}</td><td>（連携用）払込Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsiteizukiharaikomip zrnsiteizukiharaikomip}</td><td>（連携用）指定月払込Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsaisyuusiteimhrkp zrnsaisyuusiteimhrkp}</td><td>（連携用）最終指定月払込Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngoukeinenbaraikansanp zrngoukeinenbaraikansanp}</td><td>（連携用）合計年払換算Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngyousekihyoujisrank zrngyousekihyoujisrank}</td><td>（連携用）業績表示Ｓランク</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteikibairitu zrnteikibairitu}</td><td>（連携用）定期倍率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrntenkangodatakanrino zrntenkangodatakanrino}</td><td>（連携用）転換後データ管理番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnaitekykdatakanrino1 zrnaitekykdatakanrino1}</td><td>（連携用）相手契約データ管理番号１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnaitekykdatakanrino2 zrnaitekykdatakanrino2}</td><td>（連携用）相手契約データ管理番号２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntnknsyokaipcashlesshyj zrntnknsyokaipcashlesshyj}</td><td>（連携用）転換初回Ｐキャッシュレス表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyokaipannaikbn zrnsyokaipannaikbn}</td><td>（連携用）初回Ｐ案内区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzennoukaisiymd zrnzennoukaisiymd}</td><td>（連携用）前納開始年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzennoukikan zrnzennoukikan}</td><td>（連携用）前納期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseizonkyuuhukinsiteiy zrnseizonkyuuhukinsiteiy}</td><td>（連携用）生存給付金指定年</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnalmyouseizonkyhknsiteimd zrnalmyouseizonkyhknsiteimd}</td><td>（連携用）ＡＬＭ用生存給付金指定月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjikaipjyuutouym zrnjikaipjyuutouym}</td><td>（連携用）次回Ｐ充当年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykjiqpackhyj zrnkykjiqpackhyj}</td><td>（連携用）契約時Ｑパック表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhktgtikkikkkn3x1 zrnhktgtikkikkkn3x1}</td><td>（連携用）引継定期経過期間３＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhktgtikkikkkn3x2 zrnhktgtikkikkkn3x2}</td><td>（連携用）引継定期経過期間３＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhktgtikkikkkn3x3 zrnhktgtikkikkkn3x3}</td><td>（連携用）引継定期経過期間３＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhktgtikkikkkn3x4 zrnhktgtikkikkkn3x4}</td><td>（連携用）引継定期経過期間３＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkappadkeisankbnx1 zrnkappadkeisankbnx1}</td><td>（連携用）カッパーＤ計算区分＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkappadkeisankbnx2 zrnkappadkeisankbnx2}</td><td>（連携用）カッパーＤ計算区分＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkappadkeisankbnx3 zrnkappadkeisankbnx3}</td><td>（連携用）カッパーＤ計算区分＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkappadkeisankbnx4 zrnkappadkeisankbnx4}</td><td>（連携用）カッパーＤ計算区分＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin2 zrnsuuriyouyobin2}</td><td>（連携用）数理用予備項目Ｎ２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv6x3 zrnyobiv6x3}</td><td>（連携用）予備項目Ｖ６＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkimatuvyoutumimasikin zrnkimatuvyoutumimasikin}</td><td>（連携用）期末Ｖ用積増金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkmtvyusnhknfundtmttkin zrnkmtvyusnhknfundtmttkin}</td><td>（連携用）期末Ｖ用新保険ファンド積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngoukeinenkansanp3x1 zrngoukeinenkansanp3x1}</td><td>（連携用）合計年換算Ｐ３＿１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngoukeinenkansanp3x2 zrngoukeinenkansanp3x2}</td><td>（連携用）合計年換算Ｐ３＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngoukeinenkansanp3x3 zrngoukeinenkansanp3x3}</td><td>（連携用）合計年換算Ｐ３＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngoukeinenkansanp3x4 zrngoukeinenkansanp3x4}</td><td>（連携用）合計年換算Ｐ３＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkmtvyuhijynbritmttkin zrnkmtvyuhijynbritmttkin}</td><td>（連携用）期末Ｖ用平準払積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkimatuvyouitjbrtmttkin zrnkimatuvyouitjbrtmttkin}</td><td>（連携用）期末Ｖ用一時払積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x26 zrnyobin11x26}</td><td>（連携用）予備項目Ｎ１１＿２６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x27 zrnyobin11x27}</td><td>（連携用）予備項目Ｎ１１＿２７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x28 zrnyobin11x28}</td><td>（連携用）予備項目Ｎ１１＿２８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x29 zrnyobin11x29}</td><td>（連携用）予備項目Ｎ１１＿２９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x30 zrnyobin11x30}</td><td>（連携用）予備項目Ｎ１１＿３０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x31 zrnyobin11x31}</td><td>（連携用）予備項目Ｎ１１＿３１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x32 zrnyobin11x32}</td><td>（連携用）予備項目Ｎ１１＿３２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x33 zrnyobin11x33}</td><td>（連携用）予備項目Ｎ１１＿３３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhaitouyouloadingkijyuns zrnhaitouyouloadingkijyuns}</td><td>（連携用）配当用ローディング基準Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntouduketorihouhoukbn zrntouduketorihouhoukbn}</td><td>（連携用）当Ｄ受取方法区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntumitated zrntumitated}</td><td>（連携用）積立Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkariwariated zrnkariwariated}</td><td>（連携用）仮割当Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntyokuzensiharaikijitu zrntyokuzensiharaikijitu}</td><td>（連携用）直前支払期日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntyokuzentuusanhanteis zrntyokuzentuusanhanteis}</td><td>（連携用）直前通算判定Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntyokugosiharaikijitu zrntyokugosiharaikijitu}</td><td>（連携用）直後支払期日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntyokugotuusanhanteis zrntyokugotuusanhanteis}</td><td>（連携用）直後通算判定Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntyokugokyuuhutaisyous zrntyokugokyuuhutaisyous}</td><td>（連携用）直後給付対象Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntyokugocbkingaku zrntyokugocbkingaku}</td><td>（連携用）直後ＣＢ金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsyokaisiharaikijitu zrnsyokaisiharaikijitu}</td><td>（連携用）初回支払期日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyokaituusanhanteis zrnsyokaituusanhanteis}</td><td>（連携用）初回通算判定Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrncbnayosetuusanhanteis zrncbnayosetuusanhanteis}</td><td>（連携用）ＣＢ名寄せ通算判定Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhitenkankeiyakusuu zrnhitenkankeiyakusuu}</td><td>（連携用）被転換契約数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngoukeipbubuntenkanteikis zrngoukeipbubuntenkanteikis}</td><td>（連携用）合計Ｐ部分転換定期Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsaidaihktgtikkikkkn zrnsaidaihktgtikkikkkn}</td><td>（連携用）最大引継定期経過期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisyutnknhktgkujygk zrnsisyutnknhktgkujygk}</td><td>（連携用）最終転換引継控除額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x34 zrnyobin11x34}</td><td>（連携用）予備項目Ｎ１１＿３４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykkykymdx1 zrnhtnknkykkykymdx1}</td><td>（連携用）被転換契約契約年月日＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntnkntkbtdkisnyusx1 zrntnkntkbtdkisnyusx1}</td><td>（連携用）転換特別Ｄ計算用Ｓ＿１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntnknkaiykkujytksux1 zrntnknkaiykkujytksux1}</td><td>（連携用）転換解約控除月数＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntnknkaiykkujygkx1 zrntnknkaiykkujygkx1}</td><td>（連携用）転換解約控除額＿１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntenkanteikihyoujix1 zrntenkanteikihyoujix1}</td><td>（連携用）転換定期表示＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkyknenknsnpx1 zrnhtnknkyknenknsnpx1}</td><td>（連携用）被転換契約年換算Ｐ＿１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhktgtikkikkknx1 zrnhktgtikkikkknx1}</td><td>（連携用）引継定期経過期間＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykkykymdx2 zrnhtnknkykkykymdx2}</td><td>（連携用）被転換契約契約年月日＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntnkntkbtdkisnyusx2 zrntnkntkbtdkisnyusx2}</td><td>（連携用）転換特別Ｄ計算用Ｓ＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntnknkaiykkujytksux2 zrntnknkaiykkujytksux2}</td><td>（連携用）転換解約控除月数＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntnknkaiykkujygkx2 zrntnknkaiykkujygkx2}</td><td>（連携用）転換解約控除額＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntenkanteikihyoujix2 zrntenkanteikihyoujix2}</td><td>（連携用）転換定期表示＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkyknenknsnpx2 zrnhtnknkyknenknsnpx2}</td><td>（連携用）被転換契約年換算Ｐ＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhktgtikkikkknx2 zrnhktgtikkikkknx2}</td><td>（連携用）引継定期経過期間＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykkykymdx3 zrnhtnknkykkykymdx3}</td><td>（連携用）被転換契約契約年月日＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntnkntkbtdkisnyusx3 zrntnkntkbtdkisnyusx3}</td><td>（連携用）転換特別Ｄ計算用Ｓ＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntnknkaiykkujytksux3 zrntnknkaiykkujytksux3}</td><td>（連携用）転換解約控除月数＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntnknkaiykkujygkx3 zrntnknkaiykkujygkx3}</td><td>（連携用）転換解約控除額＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntenkanteikihyoujix3 zrntenkanteikihyoujix3}</td><td>（連携用）転換定期表示＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkyknenknsnpx3 zrnhtnknkyknenknsnpx3}</td><td>（連携用）被転換契約年換算Ｐ＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhktgtikkikkknx3 zrnhktgtikkikkknx3}</td><td>（連携用）引継定期経過期間＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykkykymdx4 zrnhtnknkykkykymdx4}</td><td>（連携用）被転換契約契約年月日＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntnkntkbtdkisnyusx4 zrntnkntkbtdkisnyusx4}</td><td>（連携用）転換特別Ｄ計算用Ｓ＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntnknkaiykkujytksux4 zrntnknkaiykkujytksux4}</td><td>（連携用）転換解約控除月数＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntnknkaiykkujygkx4 zrntnknkaiykkujygkx4}</td><td>（連携用）転換解約控除額＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntenkanteikihyoujix4 zrntenkanteikihyoujix4}</td><td>（連携用）転換定期表示＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkyknenknsnpx4 zrnhtnknkyknenknsnpx4}</td><td>（連携用）被転換契約年換算Ｐ＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhktgtikkikkknx4 zrnhktgtikkikkknx4}</td><td>（連携用）引継定期経過期間＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsknjyututkykkykkbn zrnsknjyututkykkykkbn}</td><td>（連携用）資金充当特約契約区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnswingminyuuphrkekngk zrnswingminyuuphrkekngk}</td><td>（連携用）スイング未入Ｐ振替金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnswingminyuuphrkejyutuym zrnswingminyuuphrkejyutuym}</td><td>（連携用）スイング未入Ｐ振替充当年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndftounendoitijitounyuup zrndftounendoitijitounyuup}</td><td>（連携用）ＤＦ当年度一時投入Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrndfkaiyakukujyhktggk zrndfkaiyakukujyhktggk}</td><td>（連携用）ＤＦ解約控除引継額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkaiyakukoujyotukisuu zrnkaiyakukoujyotukisuu}</td><td>（連携用）解約控除月数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndfkaiyakuhenreikin zrndfkaiyakuhenreikin}</td><td>（連携用）ＤＦ解約返戻金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsyuuseis zrnsyuuseis}</td><td>（連携用）修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnaatukaisyakeisyousisyacd zrnaatukaisyakeisyousisyacd}</td><td>（連携用）Ａ扱者継承支社コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnaatukaisyazaisekihyouji zrnaatukaisyazaisekihyouji}</td><td>（連携用）Ａ扱者在籍表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnaatukaisyabosyuujiage zrnaatukaisyabosyuujiage}</td><td>（連携用）Ａ扱者募集時年令</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnaatukaisyabsyjisikakucd zrnaatukaisyabsyjisikakucd}</td><td>（連携用）Ａ扱者募集時資格コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnaatukaisyasikakucd zrnaatukaisyasikakucd}</td><td>（連携用）Ａ扱者資格コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnokyksmkuztrhkkitikbn zrnokyksmkuztrhkkitikbn}</td><td>（連携用）お客様口座取引形態区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhoyuusisyacd zrnhoyuusisyacd}</td><td>（連携用）保有支社コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyokansisyacd zrnsyokansisyacd}</td><td>（連携用）所管支社コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntantousyakbn zrntantousyakbn}</td><td>（連携用）担当者区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntantousyakbnnew zrntantousyakbnnew}</td><td>（連携用）担当者区分（新）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnclubsumiseikbn zrnclubsumiseikbn}</td><td>（連携用）クラブスミセイ区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfollowtantousyakbn zrnfollowtantousyakbn}</td><td>（連携用）フォロー担当者区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntantousyajyoutaikbn zrntantousyajyoutaikbn}</td><td>（連携用）担当者状態区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkihonyoteii zrnkihonyoteii}</td><td>（連携用）基本予定ｉ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteikiyoteii zrnteikiyoteii}</td><td>（連携用）定期予定ｉ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsonotayoteii zrnsonotayoteii}</td><td>（連携用）その他予定ｉ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnitijibaraikihonyoteii zrnitijibaraikihonyoteii}</td><td>（連携用）一時払基本予定ｉ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnitijibaraiteikiyoteii zrnitijibaraiteikiyoteii}</td><td>（連携用）一時払定期予定ｉ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnitijibaraisonotayoteii zrnitijibaraisonotayoteii}</td><td>（連携用）一時払その他予定ｉ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntenkankihonyoteii zrntenkankihonyoteii}</td><td>（連携用）転換基本予定ｉ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntenkanteikiyoteii zrntenkanteikiyoteii}</td><td>（連携用）転換定期予定ｉ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnszouyoteii zrnszouyoteii}</td><td>（連携用）Ｓ増予定ｉ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnvestingyoteii zrnvestingyoteii}</td><td>（連携用）ベスティング予定ｉ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsippeitokuyakuyoteii zrnsippeitokuyakuyoteii}</td><td>（連携用）疾病特約予定ｉ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseijinbyoutokuyakuyoteii zrnseijinbyoutokuyakuyoteii}</td><td>（連携用）成人病特約予定ｉ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjyoseitokuyakuyoteii zrnjyoseitokuyakuyoteii}</td><td>（連携用）女性特約予定ｉ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntuuintokuyakuyoteii zrntuuintokuyakuyoteii}</td><td>（連携用）通院特約予定ｉ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsaiteihosyoui zrnsaiteihosyoui}</td><td>（連携用）最低保証ｉ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnvkisoitjbrkhnyoteii zrnvkisoitjbrkhnyoteii}</td><td>（連携用）Ｖ基礎一時払基本予定ｉ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnvkisorrtzeroikahyouji zrnvkisorrtzeroikahyouji}</td><td>（連携用）Ｖ基礎利率ゼロ％以下表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin3x2 zrnsuuriyouyobin3x2}</td><td>（連携用）数理用予備項目Ｎ３＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhoyuusisyacd2 zrnhoyuusisyacd2}</td><td>（連携用）保有支社コード２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndftujyukujykisnkisiym zrndftujyukujykisnkisiym}</td><td>（連携用）ＤＦ通常控除計算期始年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntikikktbrijyututksu zrntikikktbrijyututksu}</td><td>（連携用）定期一括払充当月数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyunyumrtikykjtigngtkbn zrnsyunyumrtikykjtigngtkbn}</td><td>（連携用）収入マル定契約時逓減型区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhkdrtkykarihyj zrnhhkdrtkykarihyj}</td><td>（連携用）被保険者代理特約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykdrtkykarihyj zrnkykdrtkykarihyj}</td><td>（連携用）契約者代理特約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv10x14 zrnyobiv10x14}</td><td>（連携用）予備項目Ｖ１０＿１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkappadhktgkujygkx1 zrnkappadhktgkujygkx1}</td><td>（連携用）カッパーＤ引継控除額＿１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkappadhktgkujygkx2 zrnkappadhktgkujygkx2}</td><td>（連携用）カッパーＤ引継控除額＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkappadhktgkujygkx3 zrnkappadhktgkujygkx3}</td><td>（連携用）カッパーＤ引継控除額＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkappadhktgkujygkx4 zrnkappadhktgkujygkx4}</td><td>（連携用）カッパーＤ引継控除額＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntrkzsgkaiykkjynstmtkzndk zrntrkzsgkaiykkjynstmtkzndk}</td><td>（連携用）取崩後解約控除なし積立金残高</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnpmenkouryokuhasseiymd zrnpmenkouryokuhasseiymd}</td><td>（連携用）Ｐ免効力発生年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin5 zrnsuuriyouyobin5}</td><td>（連携用）数理用予備項目Ｎ５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin13 zrnsuuriyouyobin13}</td><td>（連携用）数理用予備項目Ｎ１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobin11x35 zrnyobin11x35}</td><td>（連携用）予備項目Ｎ１１＿３５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x36 zrnyobin11x36}</td><td>（連携用）予備項目Ｎ１１＿３６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x37 zrnyobin11x37}</td><td>（連携用）予備項目Ｎ１１＿３７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv200 zrntokuyakukoumokuv200}</td><td>（連携用）特約項目Ｖ２００</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv200x2 zrntokuyakukoumokuv200x2}</td><td>（連携用）特約項目Ｖ２００＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv200x3 zrntokuyakukoumokuv200x3}</td><td>（連携用）特約項目Ｖ２００＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv200x4 zrntokuyakukoumokuv200x4}</td><td>（連携用）特約項目Ｖ２００＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv200x5 zrntokuyakukoumokuv200x5}</td><td>（連携用）特約項目Ｖ２００＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv200x6 zrntokuyakukoumokuv200x6}</td><td>（連携用）特約項目Ｖ２００＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv200x7 zrntokuyakukoumokuv200x7}</td><td>（連携用）特約項目Ｖ２００＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv200x8 zrntokuyakukoumokuv200x8}</td><td>（連携用）特約項目Ｖ２００＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv200x9 zrntokuyakukoumokuv200x9}</td><td>（連携用）特約項目Ｖ２００＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv200x10 zrntokuyakukoumokuv200x10}</td><td>（連携用）特約項目Ｖ２００＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv200x11 zrntokuyakukoumokuv200x11}</td><td>（連携用）特約項目Ｖ２００＿１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv200x12 zrntokuyakukoumokuv200x12}</td><td>（連携用）特約項目Ｖ２００＿１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv200x13 zrntokuyakukoumokuv200x13}</td><td>（連携用）特約項目Ｖ２００＿１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv200x14 zrntokuyakukoumokuv200x14}</td><td>（連携用）特約項目Ｖ２００＿１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv200x15 zrntokuyakukoumokuv200x15}</td><td>（連携用）特約項目Ｖ２００＿１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv200x16 zrntokuyakukoumokuv200x16}</td><td>（連携用）特約項目Ｖ２００＿１６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv200x17 zrntokuyakukoumokuv200x17}</td><td>（連携用）特約項目Ｖ２００＿１７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv200x18 zrntokuyakukoumokuv200x18}</td><td>（連携用）特約項目Ｖ２００＿１８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv200x19 zrntokuyakukoumokuv200x19}</td><td>（連携用）特約項目Ｖ２００＿１９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv200x20 zrntokuyakukoumokuv200x20}</td><td>（連携用）特約項目Ｖ２００＿２０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv200x21 zrntokuyakukoumokuv200x21}</td><td>（連携用）特約項目Ｖ２００＿２１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv200x22 zrntokuyakukoumokuv200x22}</td><td>（連携用）特約項目Ｖ２００＿２２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv200x23 zrntokuyakukoumokuv200x23}</td><td>（連携用）特約項目Ｖ２００＿２３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv200x24 zrntokuyakukoumokuv200x24}</td><td>（連携用）特約項目Ｖ２００＿２４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv200x25 zrntokuyakukoumokuv200x25}</td><td>（連携用）特約項目Ｖ２００＿２５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv200x26 zrntokuyakukoumokuv200x26}</td><td>（連携用）特約項目Ｖ２００＿２６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv200x27 zrntokuyakukoumokuv200x27}</td><td>（連携用）特約項目Ｖ２００＿２７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv200x28 zrntokuyakukoumokuv200x28}</td><td>（連携用）特約項目Ｖ２００＿２８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv200x29 zrntokuyakukoumokuv200x29}</td><td>（連携用）特約項目Ｖ２００＿２９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv200x30 zrntokuyakukoumokuv200x30}</td><td>（連携用）特約項目Ｖ２００＿３０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv200x31 zrntokuyakukoumokuv200x31}</td><td>（連携用）特約項目Ｖ２００＿３１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv200x32 zrntokuyakukoumokuv200x32}</td><td>（連携用）特約項目Ｖ２００＿３２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv200x33 zrntokuyakukoumokuv200x33}</td><td>（連携用）特約項目Ｖ２００＿３３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv200x34 zrntokuyakukoumokuv200x34}</td><td>（連携用）特約項目Ｖ２００＿３４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv200x35 zrntokuyakukoumokuv200x35}</td><td>（連携用）特約項目Ｖ２００＿３５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv200x36 zrntokuyakukoumokuv200x36}</td><td>（連携用）特約項目Ｖ２００＿３６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv200x37 zrntokuyakukoumokuv200x37}</td><td>（連携用）特約項目Ｖ２００＿３７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv200x38 zrntokuyakukoumokuv200x38}</td><td>（連携用）特約項目Ｖ２００＿３８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv200x39 zrntokuyakukoumokuv200x39}</td><td>（連携用）特約項目Ｖ２００＿３９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv200x40 zrntokuyakukoumokuv200x40}</td><td>（連携用）特約項目Ｖ２００＿４０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_IdouMeisaiRn
 * @see     PKZT_IdouMeisaiRn
 * @see     QZT_IdouMeisaiRn
 * @see     GenQZT_IdouMeisaiRn
 */
@MappedSuperclass
@Table(name=GenZT_IdouMeisaiRn.TABLE_NAME)
@IdClass(value=PKZT_IdouMeisaiRn.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_IdouMeisaiRn extends AbstractExDBEntityForZDB<ZT_IdouMeisaiRn, PKZT_IdouMeisaiRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_IdouMeisaiRn";
    public static final String ZRNSEQUENCENO            = "zrnsequenceno";
    public static final String ZRNYUUKOURECORDLENGTH    = "zrnyuukourecordlength";
    public static final String ZRNRDWAREA               = "zrnrdwarea";
    public static final String ZRNRECORDKBN             = "zrnrecordkbn";
    public static final String ZRNNENKINKAISIGOHYOUJI   = "zrnnenkinkaisigohyouji";
    public static final String ZRNNKSGOKURIKOSIDHYJ     = "zrnnksgokurikosidhyj";
    public static final String ZRNKEIJYOUYM             = "zrnkeijyouym";
    public static final String ZRNIDOJIYUKBN            = "zrnidojiyukbn";
    public static final String ZRNZOUGENKBN             = "zrnzougenkbn";
    public static final String ZRNIDOURECORDKBN         = "zrnidourecordkbn";
    public static final String ZRNKEIJYOUCTRLKBN        = "zrnkeijyouctrlkbn";
    public static final String ZRNHENKOUSYORIYMD        = "zrnhenkousyoriymd";
    public static final String ZRNKYKMFKSNCTR           = "zrnkykmfksnctr";
    public static final String ZRNRECORDCTR             = "zrnrecordctr";
    public static final String ZRNSUURIYOUKOURYOKUKAISIYMD = "zrnsuuriyoukouryokukaisiymd";
    public static final String ZRNDENYMD                = "zrndenymd";
    public static final String ZRNBLUEKEIZOKUHYOUJI     = "zrnbluekeizokuhyouji";
    public static final String ZRNSUURIYOUYOBIN1X2      = "zrnsuuriyouyobin1x2";
    public static final String ZRNTOUKEIKEIJYOUKBN      = "zrntoukeikeijyoukbn";
    public static final String ZRNRAYSYSTEMHYJ          = "zrnraysystemhyj";
    public static final String ZRNZENKIIDOUTEISEIKBN    = "zrnzenkiidouteiseikbn";
    public static final String ZRNBSYYM                 = "zrnbsyym";
    public static final String ZRNTENKANGOKEIYAKUBOSYUUYM = "zrntenkangokeiyakubosyuuym";
    public static final String ZRNIDOUJIYUUCD           = "zrnidoujiyuucd";
    public static final String ZRNSYORICD               = "zrnsyoricd";
    public static final String ZRNSEKININTEISEIHYOUJI   = "zrnsekininteiseihyouji";
    public static final String ZRNSUURIYOUYOBIN8        = "zrnsuuriyouyobin8";
    public static final String ZRNSIHANKIBIKINKBN       = "zrnsihankibikinkbn";
    public static final String ZRNSUURIYOUYOBIN1X3      = "zrnsuuriyouyobin1x3";
    public static final String ZRNDATAKANRINO           = "zrndatakanrino";
    public static final String ZRNHKNSYUKIGOU           = "zrnhknsyukigou";
    public static final String ZRNHKNSYURUIKIGOUSEDAIKBN = "zrnhknsyuruikigousedaikbn";
    public static final String ZRNSOTODASIPMENKBN       = "zrnsotodasipmenkbn";
    public static final String ZRNSTDSSYTIKBN           = "zrnstdssytikbn";
    public static final String ZRNSTDSSNSKBN            = "zrnstdssnskbn";
    public static final String ZRNSOTODASIMANAGEHYOUJI  = "zrnsotodasimanagehyouji";
    public static final String ZRNSOTODASIPHKBNMNOSHYOUJI = "zrnsotodasiphkbnmnoshyouji";
    public static final String ZRNSTDSSTKJYTKYUHYJ      = "zrnstdsstkjytkyuhyj";
    public static final String ZRNKBNKEIRIYOUSEGMENTKBN = "zrnkbnkeiriyousegmentkbn";
    public static final String ZRNKBNKEIRIYOURGNBNSKKBN = "zrnkbnkeiriyourgnbnskkbn";
    public static final String ZRNSUURISYURUICD         = "zrnsuurisyuruicd";
    public static final String ZRNHOSYOUKINOUKBN        = "zrnhosyoukinoukbn";
    public static final String ZRNDAIKBN                = "zrndaikbn";
    public static final String ZRNTYUUKBN               = "zrntyuukbn";
    public static final String ZRNSYOUKBN               = "zrnsyoukbn";
    public static final String ZRNSEDAIKBN              = "zrnsedaikbn";
    public static final String ZRNHARAIKATAKBN          = "zrnharaikatakbn";
    public static final String ZRNKYKYMD                = "zrnkykymd";
    public static final String ZRNHKNKKN                = "zrnhknkkn";
    public static final String ZRNPHRKKIKN              = "zrnphrkkikn";
    public static final String ZRNSAIMNKKYKHYJ          = "zrnsaimnkkykhyj";
    public static final String ZRNANNAIFUYOURIYUUKBN    = "zrnannaifuyouriyuukbn";
    public static final String ZRNTKSYUANNAIKYKKBN      = "zrntksyuannaikykkbn";
    public static final String ZRNHRKKAISUUKBN          = "zrnhrkkaisuukbn";
    public static final String ZRNHRKKEIROKBN           = "zrnhrkkeirokbn";
    public static final String ZRNSDPDKBN               = "zrnsdpdkbn";
    public static final String ZRNRYOURITUKBN           = "zrnryouritukbn";
    public static final String ZRNAO3TYOU3SIBOUSDATEHYOUJI = "zrnao3tyou3sibousdatehyouji";
    public static final String ZRNHHKNSEIKBN            = "zrnhhknseikbn";
    public static final String ZRNHIHOKENSYAAGEV2       = "zrnhihokensyaagev2";
    public static final String ZRNKYKSYANEN             = "zrnkyksyanen";
    public static final String ZRNDAI2HHKNNEN           = "zrndai2hhknnen";
    public static final String ZRNTKBTHSYUMNRYUHYOUJI   = "zrntkbthsyumnryuhyouji";
    public static final String ZRNSYUKEIYAKUPWARIBIKIKBN = "zrnsyukeiyakupwaribikikbn";
    public static final String ZRNTENKANWARIBIKIKBN     = "zrntenkanwaribikikbn";
    public static final String ZRNYUUHITUTNKNYUGURYURTKBN = "zrnyuuhitutnknyuguryurtkbn";
    public static final String ZRNSYUKEIYAKUP           = "zrnsyukeiyakup";
    public static final String ZRNTOKUJYOUP             = "zrntokujyoup";
    public static final String ZRNSITEIZUKISYUKEIYAKUP  = "zrnsiteizukisyukeiyakup";
    public static final String ZRNKIHONS                = "zrnkihons";
    public static final String ZRNSIBOUS                = "zrnsibous";
    public static final String ZRNHENKOUGOKIHONS        = "zrnhenkougokihons";
    public static final String ZRNHENKOUGOSIBOUS        = "zrnhenkougosibous";
    public static final String ZRNHENKOUYMD             = "zrnhenkouymd";
    public static final String ZRNENTYOUKIKAN           = "zrnentyoukikan";
    public static final String ZRNSEIZONKYUUHUKINSITEIMD = "zrnseizonkyuuhukinsiteimd";
    public static final String ZRNSYUKEIYAKUSIHARAIKINGAKU = "zrnsyukeiyakusiharaikingaku";
    public static final String ZRNATUKAISISYATODOUHUKENCD = "zrnatukaisisyatodouhukencd";
    public static final String ZRNTOKUYAKUHUKASUU       = "zrntokuyakuhukasuu";
    public static final String ZRNDI2HKNKKNIKOUJIHISYAAGE = "zrndi2hknkknikoujihisyaage";
    public static final String ZRNHRIMNENTYOUMAEPHRKKKN = "zrnhrimnentyoumaephrkkkn";
    public static final String ZRNTOKUBETUHOSYOUKIKAN   = "zrntokubetuhosyoukikan";
    public static final String ZRNKOUSINMANRYOUAGE      = "zrnkousinmanryouage";
    public static final String ZRNKNKUZUSNZYRTTEKITKARIHYJ = "zrnknkuzusnzyrttekitkarihyj";
    public static final String ZRNKURIAGEKURISAGEKBN    = "zrnkuriagekurisagekbn";
    public static final String ZRNHRIZMJHKNSYUKIGOUSDKBN = "zrnhrizmjhknsyukigousdkbn";
    public static final String ZRNKRSGJHKNSYUKIGOUSDKBN = "zrnkrsgjhknsyukigousdkbn";
    public static final String ZRNSOTODASISYOUHINKAITEIKBN = "zrnsotodasisyouhinkaiteikbn";
    public static final String ZRNYOBIV4                = "zrnyobiv4";
    public static final String ZRNGOUKEITENKANS         = "zrngoukeitenkans";
    public static final String ZRNGOUKEIPBUBUNTENKANS   = "zrngoukeipbubuntenkans";
    public static final String ZRNTENKANTEIKISYURUIKIGOU = "zrntenkanteikisyuruikigou";
    public static final String ZRNTENKANTEIKIKIGOUSEDAIKBN = "zrntenkanteikikigousedaikbn";
    public static final String ZRNTNKNTIKSOTODASIKUSNKBN = "zrntnkntiksotodasikusnkbn";
    public static final String ZRNTNKNTIKSTDSPMENKBN    = "zrntnkntikstdspmenkbn";
    public static final String ZRNTENKANTEIKIKIGOUYOBI  = "zrntenkanteikikigouyobi";
    public static final String ZRNTENKANTEIKIKIKAN      = "zrntenkanteikikikan";
    public static final String ZRNGOUKEITENKANTEIKIS    = "zrngoukeitenkanteikis";
    public static final String ZRNTNKNTEIKINKSHRKKN     = "zrntnknteikinkshrkkn";
    public static final String ZRNTENKANSIHARAIKINGAKU  = "zrntenkansiharaikingaku";
    public static final String ZRNTNKNTIKSHRKNGK        = "zrntnkntikshrkngk";
    public static final String ZRNTENKANKAISUU          = "zrntenkankaisuu";
    public static final String ZRNGOUKEITENKANKAKAKU    = "zrngoukeitenkankakaku";
    public static final String ZRNTNKNKHNBBNJYUTURT     = "zrntnknkhnbbnjyuturt";
    public static final String ZRNWNASIGOUKEITENKANTEIKIS = "zrnwnasigoukeitenkanteikis";
    public static final String ZRNTNKNTEIKIKOUSINMNRYOUAGE = "zrntnknteikikousinmnryouage";
    public static final String ZRNYOBIV5                = "zrnyobiv5";
    public static final String ZRNKANYUJIDATAKANRINO    = "zrnkanyujidatakanrino";
    public static final String ZRNKANYUJIKYKYMD         = "zrnkanyujikykymd";
    public static final String ZRNKANYUUJIHIHOKENSYAAGE = "zrnkanyuujihihokensyaage";
    public static final String ZRNKANYUUJITENKANHYOUJI  = "zrnkanyuujitenkanhyouji";
    public static final String ZRNHSYUIKKTMINAOSIKAISU  = "zrnhsyuikktminaosikaisu";
    public static final String ZRNSKNNJYNBKNSISNRT      = "zrnsknnjynbknsisnrt";
    public static final String ZRNTKJYKBN               = "zrntkjykbn";
    public static final String ZRNSAKUGENKIKAN          = "zrnsakugenkikan";
    public static final String ZRNRYOUMASIHYOUTEN       = "zrnryoumasihyouten";
    public static final String ZRNSYKYKTKJYURYUMSRATEHYJ = "zrnsykyktkjyuryumsratehyj";
    public static final String ZRNSYKYKTKJYURYUMSRATE   = "zrnsykyktkjyuryumsrate";
    public static final String ZRNDAI2TOKUJYOUKBN       = "zrndai2tokujyoukbn";
    public static final String ZRNDAI2SAKUGENKIKAN      = "zrndai2sakugenkikan";
    public static final String ZRNDAI2RYOUMASIHYOUTEN   = "zrndai2ryoumasihyouten";
    public static final String ZRNTOKUTEIBUIJYOUKENHYOUJI = "zrntokuteibuijyoukenhyouji";
    public static final String ZRNTOKUTEIBUINO1         = "zrntokuteibuino1";
    public static final String ZRNHTNPKKN1              = "zrnhtnpkkn1";
    public static final String ZRNTOKUTEIBUINO2         = "zrntokuteibuino2";
    public static final String ZRNHTNPKKN2              = "zrnhtnpkkn2";
    public static final String ZRNMHITUIRYUYUTKTBIJYKNHYJ = "zrnmhituiryuyutktbijyknhyj";
    public static final String ZRNMUHAITOUIRYOUYOUTKTBINO1 = "zrnmuhaitouiryouyoutktbino1";
    public static final String ZRNMUHAITOUIRYOUYOUHTNPKKN1 = "zrnmuhaitouiryouyouhtnpkkn1";
    public static final String ZRNMUHAITOUIRYOUYOUTKTBINO2 = "zrnmuhaitouiryouyoutktbino2";
    public static final String ZRNMUHAITOUIRYOUYOUHTNPKKN2 = "zrnmuhaitouiryouyouhtnpkkn2";
    public static final String ZRNSITEIZUKIPWARIMASIHYOUJI = "zrnsiteizukipwarimasihyouji";
    public static final String ZRNPWARIMASISITEIM1      = "zrnpwarimasisiteim1";
    public static final String ZRNPWARIMASISITEIM2      = "zrnpwarimasisiteim2";
    public static final String ZRNSITEIMSYKYKPBAIRITU   = "zrnsiteimsykykpbairitu";
    public static final String ZRNSAISYUUSITEIYM        = "zrnsaisyuusiteiym";
    public static final String ZRNSYKYKKITMTTVKEISANYM  = "zrnsykykkitmttvkeisanym";
    public static final String ZRNSYKYKKITMTTSKNNJYNBKNGK = "zrnsykykkitmttsknnjynbkngk";
    public static final String ZRNDFTUMITATEKINGAKU     = "zrndftumitatekingaku";
    public static final String ZRNDFTUMIMASIKIN         = "zrndftumimasikin";
    public static final String ZRNVBUBUNDFTENKANKAKAKU  = "zrnvbubundftenkankakaku";
    public static final String ZRNDPBUBUNDFTENKANKAKAKU = "zrndpbubundftenkankakaku";
    public static final String ZRNDFTMTTKNGKITJBRBBN    = "zrndftmttkngkitjbrbbn";
    public static final String ZRNHENDOUS               = "zrnhendous";
    public static final String ZRNHENGAKUJIGYOUNENDOMATUCV = "zrnhengakujigyounendomatucv";
    public static final String ZRNITIBUITIJIBARAIS      = "zrnitibuitijibarais";
    public static final String ZRNITIBUITIJIBARAIP      = "zrnitibuitijibaraip";
    public static final String ZRNITIBITJBRSHRKNGK      = "zrnitibitjbrshrkngk";
    public static final String ZRNGOUKEICV              = "zrngoukeicv";
    public static final String ZRNMINASICV              = "zrnminasicv";
    public static final String ZRNLOANFUND              = "zrnloanfund";
    public static final String ZRNSAITEIHOSYOUGAKU      = "zrnsaiteihosyougaku";
    public static final String ZRNHNGKSITIHSYUYUSYKYKP  = "zrnhngksitihsyuyusykykp";
    public static final String ZRNHIJYNBRIVASBUJSITIHSYUGK = "zrnhijynbrivasbujsitihsyugk";
    public static final String ZRNHIJYNBRIVAMNKJSITIHSYUGK = "zrnhijynbrivamnkjsitihsyugk";
    public static final String ZRNSIINKBN               = "zrnsiinkbn";
    public static final String ZRNMUDKAIMASIKIHONS      = "zrnmudkaimasikihons";
    public static final String ZRNKAIMASIYMD            = "zrnkaimasiymd";
    public static final String ZRNKAIMASIKIKAN          = "zrnkaimasikikan";
    public static final String ZRNHIKITUGIKAIMASIS      = "zrnhikitugikaimasis";
    public static final String ZRNMUDKAIMASISIHARAIKINGAKU = "zrnmudkaimasisiharaikingaku";
    public static final String ZRNSZOUKOURYOKUKAISIYMDX1 = "zrnszoukouryokukaisiymdx1";
    public static final String ZRNSZOUHOKENSYURUIKIGOUX1 = "zrnszouhokensyuruikigoux1";
    public static final String ZRNSZOUKIGOUSEDAIKBNX1   = "zrnszoukigousedaikbnx1";
    public static final String ZRNSZOUKIKANX1           = "zrnszoukikanx1";
    public static final String ZRNSZOUHIHOKENSYAAGEX1   = "zrnszouhihokensyaagex1";
    public static final String ZRNSZOUDAI2HIHKNSYAAGEX1 = "zrnszoudai2hihknsyaagex1";
    public static final String ZRNZOUKASX1              = "zrnzoukasx1";
    public static final String ZRNZENNENDOZOUKASX1      = "zrnzennendozoukasx1";
    public static final String ZRNSZOUSIHARAIKINGAKUX1  = "zrnszousiharaikingakux1";
    public static final String ZRNSZOUKOURYOKUKAISIYMDX2 = "zrnszoukouryokukaisiymdx2";
    public static final String ZRNSZOUHOKENSYURUIKIGOUX2 = "zrnszouhokensyuruikigoux2";
    public static final String ZRNSZOUKIGOUSEDAIKBNX2   = "zrnszoukigousedaikbnx2";
    public static final String ZRNSZOUKIKANX2           = "zrnszoukikanx2";
    public static final String ZRNSZOUHIHOKENSYAAGEX2   = "zrnszouhihokensyaagex2";
    public static final String ZRNSZOUDAI2HIHKNSYAAGEX2 = "zrnszoudai2hihknsyaagex2";
    public static final String ZRNZOUKASX2              = "zrnzoukasx2";
    public static final String ZRNZENNENDOZOUKASX2      = "zrnzennendozoukasx2";
    public static final String ZRNSZOUSIHARAIKINGAKUX2  = "zrnszousiharaikingakux2";
    public static final String ZRNSUURIYOUYOBIN1X5      = "zrnsuuriyouyobin1x5";
    public static final String ZRNSUURIYOUYOBIN1X6      = "zrnsuuriyouyobin1x6";
    public static final String ZRNHRIMNGKIZKTKYKPMENHYJ = "zrnhrimngkizktkykpmenhyj";
    public static final String ZRNMISYUUSTARTYM         = "zrnmisyuustartym";
    public static final String ZRNMISYUUKAISUU          = "zrnmisyuukaisuu";
    public static final String ZRNITJBRTKYKKOUSNUKTKARHYJ = "zrnitjbrtkykkousnuktkarhyj";
    public static final String ZRNGYOUSEKIHYOUJIS       = "zrngyousekihyoujis";
    public static final String ZRNSYKYKGYUSEKIHYJS      = "zrnsykykgyusekihyjs";
    public static final String ZRNTENKANGYOUSEKIHYOUJIS = "zrntenkangyousekihyoujis";
    public static final String ZRNTNKNTEIKIGYOUSEKIHYJS = "zrntnknteikigyousekihyjs";
    public static final String ZRNTNKNDPBBNGYUSKHYJS    = "zrntnkndpbbngyuskhyjs";
    public static final String ZRNKYKJYOUTAI            = "zrnkykjyoutai";
    public static final String ZRNPMENHUKAKBN           = "zrnpmenhukakbn";
    public static final String ZRNKOUSINKBN             = "zrnkousinkbn";
    public static final String ZRNMANKIYOTEIKBN         = "zrnmankiyoteikbn";
    public static final String ZRNSYKYKTIKMNKYOTEIKBN   = "zrnsykyktikmnkyoteikbn";
    public static final String ZRNTNKNSYKYKKHNMNKYTIKBN = "zrntnknsykykkhnmnkytikbn";
    public static final String ZRNTNKNSYKYKTIKMNKYTIKBN = "zrntnknsykyktikmnkytikbn";
    public static final String ZRNTENKANTEIKIMANKIYOTEIKBN = "zrntenkanteikimankiyoteikbn";
    public static final String ZRNSZOUMANKIYOTEIKBNX1   = "zrnszoumankiyoteikbnx1";
    public static final String ZRNSZOUMANKIYOTEIKBNX2   = "zrnszoumankiyoteikbnx2";
    public static final String ZRNVESTINGMANKIYOTEIKBN  = "zrnvestingmankiyoteikbn";
    public static final String ZRNVKEISANHYOUJI         = "zrnvkeisanhyouji";
    public static final String ZRNTOUKISINKEIYAKUHYOUJI = "zrntoukisinkeiyakuhyouji";
    public static final String ZRNSYKYKHOKENHOUTEKIYOUHYJ = "zrnsykykhokenhoutekiyouhyj";
    public static final String ZRNTOKUTEIJYOUTAIHUSHRHYJ = "zrntokuteijyoutaihushrhyj";
    public static final String ZRNYTIRRTHNDSYSNMNSKAISUU = "zrnytirrthndsysnmnskaisuu";
    public static final String ZRNSUURIYOUYOBIN3        = "zrnsuuriyouyobin3";
    public static final String ZRNSUURIYOUYOBIN11       = "zrnsuuriyouyobin11";
    public static final String ZRNWNASIGOUKEITENKANKAKAKU = "zrnwnasigoukeitenkankakaku";
    public static final String ZRNYOBIN11               = "zrnyobin11";
    public static final String ZRNYOBIN11X2             = "zrnyobin11x2";
    public static final String ZRNYOBIN11X3             = "zrnyobin11x3";
    public static final String ZRNTUKIBARAIKANSANTOKUJYOUP = "zrntukibaraikansantokujyoup";
    public static final String ZRNTNKNGKYKKSSNKIJYUYM   = "zrntnkngkykkssnkijyuym";
    public static final String ZRNSAITEIHOSYOUHYOUJI    = "zrnsaiteihosyouhyouji";
    public static final String ZRNSUURIYOUYOBIN8X2      = "zrnsuuriyouyobin8x2";
    public static final String ZRNSUURIYOUYOBIN14       = "zrnsuuriyouyobin14";
    public static final String ZRNHRIMNGTKYKPHRKKAISUUKBN = "zrnhrimngtkykphrkkaisuukbn";
    public static final String ZRNHRIMNGTKYKPHRKKIRKBN  = "zrnhrimngtkykphrkkirkbn";
    public static final String ZRNHRIMNGTKYKPRYURTKBN   = "zrnhrimngtkykpryurtkbn";
    public static final String ZRNYOBIV13               = "zrnyobiv13";
    public static final String ZRNIDOUJISAITEIHOSYOUKNGK = "zrnidoujisaiteihosyoukngk";
    public static final String ZRNIDOUJISAITEIHOSYOUCOST = "zrnidoujisaiteihosyoucost";
    public static final String ZRNSINHOKENFUNDTUMITATEKIN = "zrnsinhokenfundtumitatekin";
    public static final String ZRNMSYUPTUSSHKGKAIYKHNRIKN = "zrnmsyuptusshkgkaiykhnrikn";
    public static final String ZRNRRTHNDUGTNKGETUMATUV  = "zrnrrthndugtnkgetumatuv";
    public static final String ZRNRRTHNDNKSAITEIHOSYONKGNS = "zrnrrthndnksaiteihosyonkgns";
    public static final String ZRNRRTHENDOUGATANKSIBOUS = "zrnrrthendougatanksibous";
    public static final String ZRNALMYOUSOHUTOMEISYOUKBN = "zrnalmyousohutomeisyoukbn";
    public static final String ZRNSNKYKSOFTMEISYOUKBN   = "zrnsnkyksoftmeisyoukbn";
    public static final String ZRNSOFTMEISYOUKBN        = "zrnsoftmeisyoukbn";
    public static final String ZRNKYKJITOKUJYOUARIHYJ   = "zrnkykjitokujyouarihyj";
    public static final String ZRNBNKTTNKNKBN           = "zrnbnkttnknkbn";
    public static final String ZRNTENKANMINAOSIKBN      = "zrntenkanminaosikbn";
    public static final String ZRNSOUJIKEITENKANKBN     = "zrnsoujikeitenkankbn";
    public static final String ZRNNENKINKAISINENDO      = "zrnnenkinkaisinendo";
    public static final String ZRNNENKINGATAKBN         = "zrnnenkingatakbn";
    public static final String ZRNNKNSHRY               = "zrnnknshry";
    public static final String ZRNHEIYOUBARAIKEIYAKUKBN = "zrnheiyoubaraikeiyakukbn";
    public static final String ZRNNENKINMARUTEIHUKAKBN  = "zrnnenkinmaruteihukakbn";
    public static final String ZRNSINSEIZONMRTIARIHYJ   = "zrnsinseizonmrtiarihyj";
    public static final String ZRNSNKYKYOUIBOKIJYUKBN   = "zrnsnkykyouibokijyukbn";
    public static final String ZRNTOKUSITUJYUUSITUSETKBN = "zrntokusitujyuusitusetkbn";
    public static final String ZRNSIKTSYUKNBYUGNHSYUNSHYJ = "zrnsiktsyuknbyugnhsyunshyj";
    public static final String ZRNPMENSUGUGTGANHSYUNSHYJ = "zrnpmensugugtganhsyunshyj";
    public static final String ZRNTKYKGYOUSEKIHYJSZEROHYJ = "zrntkykgyousekihyjszerohyj";
    public static final String ZRNSUURIYOUYOBIN7        = "zrnsuuriyouyobin7";
    public static final String ZRNSYUSSAIKEITAIKBN      = "zrnsyussaikeitaikbn";
    public static final String ZRNYOBIV6                = "zrnyobiv6";
    public static final String ZRNBOSYUUKEITAIKBN       = "zrnbosyuukeitaikbn";
    public static final String ZRNAATUKAISOSIKICD       = "zrnaatukaisosikicd";
    public static final String ZRNAATUKAIKOJINCD        = "zrnaatukaikojincd";
    public static final String ZRNBSYDRTENCD            = "zrnbsydrtencd";
    public static final String ZRNCIFCD                 = "zrncifcd";
    public static final String ZRNSUURIYOUYOBIV8        = "zrnsuuriyouyobiv8";
    public static final String ZRNSINSAKBN              = "zrnsinsakbn";
    public static final String ZRNDAI2HIHOKENSYASINSAKBN = "zrndai2hihokensyasinsakbn";
    public static final String ZRNTOUKEIYOUSINSAKBN     = "zrntoukeiyousinsakbn";
    public static final String ZRNDAI2TOUKEIYOUSINSAKBN = "zrndai2toukeiyousinsakbn";
    public static final String ZRNKETTEIKIJYUNKANWAKBN  = "zrnketteikijyunkanwakbn";
    public static final String ZRNKIHONSIBOUHYOUKBN     = "zrnkihonsibouhyoukbn";
    public static final String ZRNTEIKISIBOUHYOUKBN     = "zrnteikisibouhyoukbn";
    public static final String ZRNSONOTASIBOUHYOUKBN    = "zrnsonotasibouhyoukbn";
    public static final String ZRNMRARIHYJ              = "zrnmrarihyj";
    public static final String ZRNSENTAKUJYOUHOUARIHYOUJI = "zrnsentakujyouhouarihyouji";
    public static final String ZRNDUGKTNKNSNTKHUHUKBN   = "zrndugktnknsntkhuhukbn";
    public static final String ZRNGENGAKUTENKANKYKHYJ   = "zrngengakutenkankykhyj";
    public static final String ZRNSYKGYCD               = "zrnsykgycd";
    public static final String ZRNJIDOUKOUSINKYKKANYUUYMD = "zrnjidoukousinkykkanyuuymd";
    public static final String ZRNSAIKOHTNKNKYKKYKYMD   = "zrnsaikohtnknkykkykymd";
    public static final String ZRNKOUSINMAESYKYKSBURTKBN = "zrnkousinmaesykyksburtkbn";
    public static final String ZRNHJNKYKHYJ             = "zrnhjnkykhyj";
    public static final String ZRNANNISKCD              = "zrnanniskcd";
    public static final String ZRNHJNCD                 = "zrnhjncd";
    public static final String ZRNHJNJIGYOSYOCD         = "zrnhjnjigyosyocd";
    public static final String ZRNSAIHOKENNO            = "zrnsaihokenno";
    public static final String ZRNDAKUHIKETTIKEKKACD    = "zrndakuhikettikekkacd";
    public static final String ZRNDAI2DAKUHIKETTEIKEKKACD = "zrndai2dakuhiketteikekkacd";
    public static final String ZRNPMENKBNV2             = "zrnpmenkbnv2";
    public static final String ZRNSIBOUKYUUHUKIN        = "zrnsiboukyuuhukin";
    public static final String ZRNJYUDTHUMEHARAITKYKHKHYJ = "zrnjyudthumeharaitkykhkhyj";
    public static final String ZRNHAITOUKBN             = "zrnhaitoukbn";
    public static final String ZRNHHKNNENTYSIHYJ        = "zrnhhknnentysihyj";
    public static final String ZRNDAI2HHKNNENTYSIHYJ    = "zrndai2hhknnentysihyj";
    public static final String ZRNKYKSYAAGETYOUSEIHYJ   = "zrnkyksyaagetyouseihyj";
    public static final String ZRNKITUENKBN             = "zrnkituenkbn";
    public static final String ZRNKITUENHONSUU          = "zrnkituenhonsuu";
    public static final String ZRNMUSENTAKUKEIYAKUKBN   = "zrnmusentakukeiyakukbn";
    public static final String ZRNYOBIV6X2              = "zrnyobiv6x2";
    public static final String ZRNLIVINGNEEDSTKYKARIHYJ = "zrnlivingneedstkykarihyj";
    public static final String ZRNLIVINGNEEDSSIHARAIHYOUJI = "zrnlivingneedssiharaihyouji";
    public static final String ZRNLNSEIKYUUYMD          = "zrnlnseikyuuymd";
    public static final String ZRNLNSHRGENINCD          = "zrnlnshrgenincd";
    public static final String ZRNDAKUHIKETTISYACD      = "zrndakuhikettisyacd";
    public static final String ZRNDAI2DAKUHIKETTEISYACD = "zrndai2dakuhiketteisyacd";
    public static final String ZRNGANSAPOTOKUYAKUARIHYOUJI = "zrngansapotokuyakuarihyouji";
    public static final String ZRNGNSPSHRHYJ            = "zrngnspshrhyj";
    public static final String ZRNGANSAPOSEIKYUUYMD     = "zrngansaposeikyuuymd";
    public static final String ZRNGNSPSHRGENINCD        = "zrngnspshrgenincd";
    public static final String ZRNYOBIV3X2              = "zrnyobiv3x2";
    public static final String ZRNTARGETMOKUHYOURITU    = "zrntargetmokuhyouritu";
    public static final String ZRNAUTOSWITCHMOKUHYOURITU = "zrnautoswitchmokuhyouritu";
    public static final String ZRNTUMITATEKINITENARIHYJ = "zrntumitatekinitenarihyj";
    public static final String ZRNTUMITATEKINITENKAISUU = "zrntumitatekinitenkaisuu";
    public static final String ZRNDATAKANRINO2          = "zrndatakanrino2";
    public static final String ZRNDATAKANRINO3          = "zrndatakanrino3";
    public static final String ZRNKNKUZUSNZYRTTEKINENDO = "zrnknkuzusnzyrttekinendo";
    public static final String ZRNKNKUZUSNZYRT          = "zrnknkuzusnzyrt";
    public static final String ZRNKNKUZUSNZYRTX2        = "zrnknkuzusnzyrtx2";
    public static final String ZRNKNKUZUSNZYRTX3        = "zrnknkuzusnzyrtx3";
    public static final String ZRNSINKEIYAKUJIKNKUZUSNZYRT = "zrnsinkeiyakujiknkuzusnzyrt";
    public static final String ZRNTENKANJIKNKUZUSNZYRT  = "zrntenkanjiknkuzusnzyrt";
    public static final String ZRNSINKEIYAKUJIVITHKHYOUJI = "zrnsinkeiyakujivithkhyouji";
    public static final String ZRNKYKJIVITHUKUSUUKYKHYJ = "zrnkykjivithukusuukykhyj";
    public static final String ZRNSUURIYOUYOBIN9X2      = "zrnsuuriyouyobin9x2";
    public static final String ZRNPWRBKSIDHITEKIYOUHYJ  = "zrnpwrbksidhitekiyouhyj";
    public static final String ZRNSUURIYOUYOBIN9        = "zrnsuuriyouyobin9";
    public static final String ZRNSUURIYOUYOBIN10X7     = "zrnsuuriyouyobin10x7";
    public static final String ZRNSUURIYOUYOBIN10X8     = "zrnsuuriyouyobin10x8";
    public static final String ZRNSUURIYOUYOBIN10X9     = "zrnsuuriyouyobin10x9";
    public static final String ZRNTUMITATEKINITENBUBUN  = "zrntumitatekinitenbubun";
    public static final String ZRNSAGAKUSKNNJYNBKNZNDK  = "zrnsagakusknnjynbknzndk";
    public static final String ZRNYOBIN11X5             = "zrnyobin11x5";
    public static final String ZRNYOBIN11X6             = "zrnyobin11x6";
    public static final String ZRNYOBIN11X7             = "zrnyobin11x7";
    public static final String ZRNYOBIN11X8             = "zrnyobin11x8";
    public static final String ZRNYOBIN11X9             = "zrnyobin11x9";
    public static final String ZRNYOBIN11X10            = "zrnyobin11x10";
    public static final String ZRNYOBIN11X11            = "zrnyobin11x11";
    public static final String ZRNYOBIN11X12            = "zrnyobin11x12";
    public static final String ZRNYOBIN11X13            = "zrnyobin11x13";
    public static final String ZRNYOBIN11X14            = "zrnyobin11x14";
    public static final String ZRNYOBIN11X15            = "zrnyobin11x15";
    public static final String ZRNYOBIN11X16            = "zrnyobin11x16";
    public static final String ZRNYOBIN11X17            = "zrnyobin11x17";
    public static final String ZRNZYRTHNTIYUSTATUSKBN   = "zrnzyrthntiyustatuskbn";
    public static final String ZRNZYRTHNTIYUSTATUSKBNX2 = "zrnzyrthntiyustatuskbnx2";
    public static final String ZRNZYRTHNTIYUSTATUSKBNX3 = "zrnzyrthntiyustatuskbnx3";
    public static final String ZRNZYRTHNTIYUSTATUSKBNX4 = "zrnzyrthntiyustatuskbnx4";
    public static final String ZRNZYRTHNTIYUSTATUSKBNX5 = "zrnzyrthntiyustatuskbnx5";
    public static final String ZRNYOBIV10               = "zrnyobiv10";
    public static final String ZRNYOBIV15X2             = "zrnyobiv15x2";
    public static final String ZRNYOBIV15X3             = "zrnyobiv15x3";
    public static final String ZRNYOBIV15X4             = "zrnyobiv15x4";
    public static final String ZRNGAIKAKBN              = "zrngaikakbn";
    public static final String ZRNKAWASERATE1           = "zrnkawaserate1";
    public static final String ZRNKAWASERATETEKIYOUYMD1 = "zrnkawaseratetekiyouymd1";
    public static final String ZRNKAWASERATE2           = "zrnkawaserate2";
    public static final String ZRNKAWASERATETEKIYOUYMD2 = "zrnkawaseratetekiyouymd2";
    public static final String ZRNKYKJIKAWASERATE       = "zrnkykjikawaserate";
    public static final String ZRNKYKJIKAWASERATETKYUYMD = "zrnkykjikawaseratetkyuymd";
    public static final String ZRNMVATYOUSEIGOW         = "zrnmvatyouseigow";
    public static final String ZRNMVAKEISANJISKNNJYNBKN = "zrnmvakeisanjisknnjynbkn";
    public static final String ZRNKAIYAKUKOUJYORITU     = "zrnkaiyakukoujyoritu";
    public static final String ZRNRENDOURITU            = "zrnrendouritu";
    public static final String ZRNSRKAIYAKUSJKKKTYOUSEIRRT = "zrnsrkaiyakusjkkktyouseirrt";
    public static final String ZRNSRKYKSJKKKTYOUSEIRIRITU = "zrnsrkyksjkkktyouseiriritu";
    public static final String ZRNMVAKEISANKIJYUNYMD    = "zrnmvakeisankijyunymd";
    public static final String ZRNMVATYOUSEIKOU         = "zrnmvatyouseikou";
    public static final String ZRNENKDTSBUJSITIHSYUKNGK = "zrnenkdtsbujsitihsyukngk";
    public static final String ZRNENKDTSBUJSITIHSYUCOST = "zrnenkdtsbujsitihsyucost";
    public static final String ZRNENKDTSBUJSITIHSYUARIHYJ = "zrnenkdtsbujsitihsyuarihyj";
    public static final String ZRNKEIYAKUJIYOTEIRIRITU  = "zrnkeiyakujiyoteiriritu";
    public static final String ZRNTUMITATERIRITU        = "zrntumitateriritu";
    public static final String ZRNKAIGOMAEBARAITKYKARIHYJ = "zrnkaigomaebaraitkykarihyj";
    public static final String ZRNSIBOUHYOUKBN          = "zrnsibouhyoukbn";
    public static final String ZRNNYUUKINTUUKAKBN       = "zrnnyuukintuukakbn";
    public static final String ZRNSIHARAITUUKAKBN       = "zrnsiharaituukakbn";
    public static final String ZRNWYENDTTARGETMOKUHYOURITU = "zrnwyendttargetmokuhyouritu";
    public static final String ZRNSISUURENDOURATE       = "zrnsisuurendourate";
    public static final String ZRNSISUUKBN              = "zrnsisuukbn";
    public static final String ZRNTEIRITUIKOUHYOUJI     = "zrnteirituikouhyouji";
    public static final String ZRNSRDAI1HKNKKN          = "zrnsrdai1hknkkn";
    public static final String ZRNSUURIYOUYOBIN10X11    = "zrnsuuriyouyobin10x11";
    public static final String ZRNTMTTKNZOUKARITUJYGN   = "zrntmttknzoukaritujygn";
    public static final String ZRNSETTEIBAIRITU         = "zrnsetteibairitu";
    public static final String ZRNTYKZENOUTOUYMDSISUU   = "zrntykzenoutouymdsisuu";
    public static final String ZRNKIMATUSISUU           = "zrnkimatusisuu";
    public static final String ZRNTUUKASYUKBN           = "zrntuukasyukbn";
    public static final String ZRNYOBIV2                = "zrnyobiv2";
    public static final String ZRNYENKADATEKIHONS       = "zrnyenkadatekihons";
    public static final String ZRNSITIHSYUMEGKDTSIBOUS  = "zrnsitihsyumegkdtsibous";
    public static final String ZRNENKDTSSRENTUMITATEKIN = "zrnenkdtssrentumitatekin";
    public static final String ZRNSISUURENTUMITATEKIN   = "zrnsisuurentumitatekin";
    public static final String ZRNNKSJITIRTTUMITATEKIN  = "zrnnksjitirttumitatekin";
    public static final String ZRNKIMATUTIRTTUMITATEKIN = "zrnkimatutirttumitatekin";
    public static final String ZRNGAIKADATEJYUUTOUP     = "zrngaikadatejyuutoup";
    public static final String ZRNYENDTTARGETKIJYUNKINGAKU = "zrnyendttargetkijyunkingaku";
    public static final String ZRNYOBIV7                = "zrnyobiv7";
    public static final String ZRNSITIVKISNYUKYKJIKWSRATE = "zrnsitivkisnyukykjikwsrate";
    public static final String ZRNSISUURENTYOKUGOTMTTKN = "zrnsisuurentyokugotmttkn";
    public static final String ZRNYOTEIRIRITURIRONBASE  = "zrnyoteiririturironbase";
    public static final String ZRNYOTEIRIRITUJTNYKNBASE = "zrnyoteiriritujtnyknbase";
    public static final String ZRNKIHRKMPJTNYKNBASE     = "zrnkihrkmpjtnyknbase";
    public static final String ZRNSYUPTUMITATEKIN       = "zrnsyuptumitatekin";
    public static final String ZRNSYUPTUMITATEKINGSC    = "zrnsyuptumitatekingsc";
    public static final String ZRNGAIKADATENKGNS        = "zrngaikadatenkgns";
    public static final String ZRNJIKAIPJYUUTOUYM2      = "zrnjikaipjyuutouym2";
    public static final String ZRNSUURIYOBIN9           = "zrnsuuriyobin9";
    public static final String ZRNGESSITUMITATEKIN      = "zrngessitumitatekin";
    public static final String ZRNGAIKADATETOUGETUJUUTOUP = "zrngaikadatetougetujuutoup";
    public static final String ZRNKIHRKMPMSUKISYMBASE   = "zrnkihrkmpmsukisymbase";
    public static final String ZRNKEISANHANTEIYOUTMTTKN = "zrnkeisanhanteiyoutmttkn";
    public static final String ZRNGTMTV                 = "zrngtmtv";
    public static final String ZRNZETTAISIBOURITU       = "zrnzettaisibouritu";
    public static final String ZRNSOUTAISIBOURITU       = "zrnsoutaisibouritu";
    public static final String ZRNSOUTAIKAIYAKURITU     = "zrnsoutaikaiyakuritu";
    public static final String ZRNVHIREILRITU2          = "zrnvhireilritu2";
    public static final String ZRNPHIREIALPHA           = "zrnphireialpha";
    public static final String ZRNPHIREIBETA            = "zrnphireibeta";
    public static final String ZRNPHIREIGANMA           = "zrnphireiganma";
    public static final String ZRNPHIREILWRBKRITU       = "zrnphireilwrbkritu";
    public static final String ZRNYOTEIRIRITUMSUKISYMBASE = "zrnyoteiriritumsukisymbase";
    public static final String ZRNRRTHNDUHKNVKISOVKISNYU1 = "zrnrrthnduhknvkisovkisnyu1";
    public static final String ZRNRRTHNDUHKNVKISOVKISNYU2 = "zrnrrthnduhknvkisovkisnyu2";
    public static final String ZRNRRTHNDUHKNVKISOVKISNYU3 = "zrnrrthnduhknvkisovkisnyu3";
    public static final String ZRNRRTHNDUHKNVKISOVKISNYU4 = "zrnrrthnduhknvkisovkisnyu4";
    public static final String ZRNRRTHNDUHKNVKISO       = "zrnrrthnduhknvkiso";
    public static final String ZRNTUMITATEKIN           = "zrntumitatekin";
    public static final String ZRNKIHARAIKOMIP          = "zrnkiharaikomip";
    public static final String ZRNGAIKADATESYUKEIYAKUP  = "zrngaikadatesyukeiyakup";
    public static final String ZRNKYKKJMMVATYOUSEIGOW   = "zrnkykkjmmvatyouseigow";
    public static final String ZRNYOBIN11X39            = "zrnyobin11x39";
    public static final String ZRNYOBIN11X41            = "zrnyobin11x41";
    public static final String ZRNYOBIN11X42            = "zrnyobin11x42";
    public static final String ZRNYOBIN11X43            = "zrnyobin11x43";
    public static final String ZRNYOBIN11X44            = "zrnyobin11x44";
    public static final String ZRNYOBIN11X45            = "zrnyobin11x45";
    public static final String ZRNSUURIYOUYOBIN15X3     = "zrnsuuriyouyobin15x3";
    public static final String ZRNSUURIYOUYOBIN15X4     = "zrnsuuriyouyobin15x4";
    public static final String ZRNSUURIYOUYOBIN15X5     = "zrnsuuriyouyobin15x5";
    public static final String ZRNSUURIYOUYOBIN15X6     = "zrnsuuriyouyobin15x6";
    public static final String ZRNYOBIV14               = "zrnyobiv14";
    public static final String ZRNKYKSYHHKNSYDOUITUHYOUJI = "zrnkyksyhhknsydouituhyouji";
    public static final String ZRNKYKSYASKINMEINO       = "zrnkyksyaskinmeino";
    public static final String ZRNGOUKEIKIHONS          = "zrngoukeikihons";
    public static final String ZRNGOUKEIGYOUSEKIHYJSIBOUS = "zrngoukeigyousekihyjsibous";
    public static final String ZRNALMYOUSIBOUS          = "zrnalmyousibous";
    public static final String ZRNHARAIKOMIP            = "zrnharaikomip";
    public static final String ZRNSITEIZUKIHARAIKOMIP   = "zrnsiteizukiharaikomip";
    public static final String ZRNSAISYUUSITEIMHRKP     = "zrnsaisyuusiteimhrkp";
    public static final String ZRNGOUKEINENBARAIKANSANP = "zrngoukeinenbaraikansanp";
    public static final String ZRNGYOUSEKIHYOUJISRANK   = "zrngyousekihyoujisrank";
    public static final String ZRNTEIKIBAIRITU          = "zrnteikibairitu";
    public static final String ZRNTENKANGODATAKANRINO   = "zrntenkangodatakanrino";
    public static final String ZRNAITEKYKDATAKANRINO1   = "zrnaitekykdatakanrino1";
    public static final String ZRNAITEKYKDATAKANRINO2   = "zrnaitekykdatakanrino2";
    public static final String ZRNTNKNSYOKAIPCASHLESSHYJ = "zrntnknsyokaipcashlesshyj";
    public static final String ZRNSYOKAIPANNAIKBN       = "zrnsyokaipannaikbn";
    public static final String ZRNZENNOUKAISIYMD        = "zrnzennoukaisiymd";
    public static final String ZRNZENNOUKIKAN           = "zrnzennoukikan";
    public static final String ZRNSEIZONKYUUHUKINSITEIY = "zrnseizonkyuuhukinsiteiy";
    public static final String ZRNALMYOUSEIZONKYHKNSITEIMD = "zrnalmyouseizonkyhknsiteimd";
    public static final String ZRNJIKAIPJYUUTOUYM       = "zrnjikaipjyuutouym";
    public static final String ZRNKYKJIQPACKHYJ         = "zrnkykjiqpackhyj";
    public static final String ZRNHKTGTIKKIKKKN3X1      = "zrnhktgtikkikkkn3x1";
    public static final String ZRNHKTGTIKKIKKKN3X2      = "zrnhktgtikkikkkn3x2";
    public static final String ZRNHKTGTIKKIKKKN3X3      = "zrnhktgtikkikkkn3x3";
    public static final String ZRNHKTGTIKKIKKKN3X4      = "zrnhktgtikkikkkn3x4";
    public static final String ZRNKAPPADKEISANKBNX1     = "zrnkappadkeisankbnx1";
    public static final String ZRNKAPPADKEISANKBNX2     = "zrnkappadkeisankbnx2";
    public static final String ZRNKAPPADKEISANKBNX3     = "zrnkappadkeisankbnx3";
    public static final String ZRNKAPPADKEISANKBNX4     = "zrnkappadkeisankbnx4";
    public static final String ZRNSUURIYOUYOBIN2        = "zrnsuuriyouyobin2";
    public static final String ZRNYOBIV6X3              = "zrnyobiv6x3";
    public static final String ZRNKIMATUVYOUTUMIMASIKIN = "zrnkimatuvyoutumimasikin";
    public static final String ZRNKMTVYUSNHKNFUNDTMTTKIN = "zrnkmtvyusnhknfundtmttkin";
    public static final String ZRNGOUKEINENKANSANP3X1   = "zrngoukeinenkansanp3x1";
    public static final String ZRNGOUKEINENKANSANP3X2   = "zrngoukeinenkansanp3x2";
    public static final String ZRNGOUKEINENKANSANP3X3   = "zrngoukeinenkansanp3x3";
    public static final String ZRNGOUKEINENKANSANP3X4   = "zrngoukeinenkansanp3x4";
    public static final String ZRNKMTVYUHIJYNBRITMTTKIN = "zrnkmtvyuhijynbritmttkin";
    public static final String ZRNKIMATUVYOUITJBRTMTTKIN = "zrnkimatuvyouitjbrtmttkin";
    public static final String ZRNYOBIN11X26            = "zrnyobin11x26";
    public static final String ZRNYOBIN11X27            = "zrnyobin11x27";
    public static final String ZRNYOBIN11X28            = "zrnyobin11x28";
    public static final String ZRNYOBIN11X29            = "zrnyobin11x29";
    public static final String ZRNYOBIN11X30            = "zrnyobin11x30";
    public static final String ZRNYOBIN11X31            = "zrnyobin11x31";
    public static final String ZRNYOBIN11X32            = "zrnyobin11x32";
    public static final String ZRNYOBIN11X33            = "zrnyobin11x33";
    public static final String ZRNHAITOUYOULOADINGKIJYUNS = "zrnhaitouyouloadingkijyuns";
    public static final String ZRNTOUDUKETORIHOUHOUKBN  = "zrntouduketorihouhoukbn";
    public static final String ZRNTUMITATED             = "zrntumitated";
    public static final String ZRNKARIWARIATED          = "zrnkariwariated";
    public static final String ZRNTYOKUZENSIHARAIKIJITU = "zrntyokuzensiharaikijitu";
    public static final String ZRNTYOKUZENTUUSANHANTEIS = "zrntyokuzentuusanhanteis";
    public static final String ZRNTYOKUGOSIHARAIKIJITU  = "zrntyokugosiharaikijitu";
    public static final String ZRNTYOKUGOTUUSANHANTEIS  = "zrntyokugotuusanhanteis";
    public static final String ZRNTYOKUGOKYUUHUTAISYOUS = "zrntyokugokyuuhutaisyous";
    public static final String ZRNTYOKUGOCBKINGAKU      = "zrntyokugocbkingaku";
    public static final String ZRNSYOKAISIHARAIKIJITU   = "zrnsyokaisiharaikijitu";
    public static final String ZRNSYOKAITUUSANHANTEIS   = "zrnsyokaituusanhanteis";
    public static final String ZRNCBNAYOSETUUSANHANTEIS = "zrncbnayosetuusanhanteis";
    public static final String ZRNHITENKANKEIYAKUSUU    = "zrnhitenkankeiyakusuu";
    public static final String ZRNGOUKEIPBUBUNTENKANTEIKIS = "zrngoukeipbubuntenkanteikis";
    public static final String ZRNSAIDAIHKTGTIKKIKKKN   = "zrnsaidaihktgtikkikkkn";
    public static final String ZRNSISYUTNKNHKTGKUJYGK   = "zrnsisyutnknhktgkujygk";
    public static final String ZRNYOBIN11X34            = "zrnyobin11x34";
    public static final String ZRNHTNKNKYKKYKYMDX1      = "zrnhtnknkykkykymdx1";
    public static final String ZRNTNKNTKBTDKISNYUSX1    = "zrntnkntkbtdkisnyusx1";
    public static final String ZRNTNKNKAIYKKUJYTKSUX1   = "zrntnknkaiykkujytksux1";
    public static final String ZRNTNKNKAIYKKUJYGKX1     = "zrntnknkaiykkujygkx1";
    public static final String ZRNTENKANTEIKIHYOUJIX1   = "zrntenkanteikihyoujix1";
    public static final String ZRNHTNKNKYKNENKNSNPX1    = "zrnhtnknkyknenknsnpx1";
    public static final String ZRNHKTGTIKKIKKKNX1       = "zrnhktgtikkikkknx1";
    public static final String ZRNHTNKNKYKKYKYMDX2      = "zrnhtnknkykkykymdx2";
    public static final String ZRNTNKNTKBTDKISNYUSX2    = "zrntnkntkbtdkisnyusx2";
    public static final String ZRNTNKNKAIYKKUJYTKSUX2   = "zrntnknkaiykkujytksux2";
    public static final String ZRNTNKNKAIYKKUJYGKX2     = "zrntnknkaiykkujygkx2";
    public static final String ZRNTENKANTEIKIHYOUJIX2   = "zrntenkanteikihyoujix2";
    public static final String ZRNHTNKNKYKNENKNSNPX2    = "zrnhtnknkyknenknsnpx2";
    public static final String ZRNHKTGTIKKIKKKNX2       = "zrnhktgtikkikkknx2";
    public static final String ZRNHTNKNKYKKYKYMDX3      = "zrnhtnknkykkykymdx3";
    public static final String ZRNTNKNTKBTDKISNYUSX3    = "zrntnkntkbtdkisnyusx3";
    public static final String ZRNTNKNKAIYKKUJYTKSUX3   = "zrntnknkaiykkujytksux3";
    public static final String ZRNTNKNKAIYKKUJYGKX3     = "zrntnknkaiykkujygkx3";
    public static final String ZRNTENKANTEIKIHYOUJIX3   = "zrntenkanteikihyoujix3";
    public static final String ZRNHTNKNKYKNENKNSNPX3    = "zrnhtnknkyknenknsnpx3";
    public static final String ZRNHKTGTIKKIKKKNX3       = "zrnhktgtikkikkknx3";
    public static final String ZRNHTNKNKYKKYKYMDX4      = "zrnhtnknkykkykymdx4";
    public static final String ZRNTNKNTKBTDKISNYUSX4    = "zrntnkntkbtdkisnyusx4";
    public static final String ZRNTNKNKAIYKKUJYTKSUX4   = "zrntnknkaiykkujytksux4";
    public static final String ZRNTNKNKAIYKKUJYGKX4     = "zrntnknkaiykkujygkx4";
    public static final String ZRNTENKANTEIKIHYOUJIX4   = "zrntenkanteikihyoujix4";
    public static final String ZRNHTNKNKYKNENKNSNPX4    = "zrnhtnknkyknenknsnpx4";
    public static final String ZRNHKTGTIKKIKKKNX4       = "zrnhktgtikkikkknx4";
    public static final String ZRNSKNJYUTUTKYKKYKKBN    = "zrnsknjyututkykkykkbn";
    public static final String ZRNSWINGMINYUUPHRKEKNGK  = "zrnswingminyuuphrkekngk";
    public static final String ZRNSWINGMINYUUPHRKEJYUTUYM = "zrnswingminyuuphrkejyutuym";
    public static final String ZRNDFTOUNENDOITIJITOUNYUUP = "zrndftounendoitijitounyuup";
    public static final String ZRNDFKAIYAKUKUJYHKTGGK   = "zrndfkaiyakukujyhktggk";
    public static final String ZRNKAIYAKUKOUJYOTUKISUU  = "zrnkaiyakukoujyotukisuu";
    public static final String ZRNDFKAIYAKUHENREIKIN    = "zrndfkaiyakuhenreikin";
    public static final String ZRNSYUUSEIS              = "zrnsyuuseis";
    public static final String ZRNAATUKAISYAKEISYOUSISYACD = "zrnaatukaisyakeisyousisyacd";
    public static final String ZRNAATUKAISYAZAISEKIHYOUJI = "zrnaatukaisyazaisekihyouji";
    public static final String ZRNAATUKAISYABOSYUUJIAGE = "zrnaatukaisyabosyuujiage";
    public static final String ZRNAATUKAISYABSYJISIKAKUCD = "zrnaatukaisyabsyjisikakucd";
    public static final String ZRNAATUKAISYASIKAKUCD    = "zrnaatukaisyasikakucd";
    public static final String ZRNOKYKSMKUZTRHKKITIKBN  = "zrnokyksmkuztrhkkitikbn";
    public static final String ZRNHOYUUSISYACD          = "zrnhoyuusisyacd";
    public static final String ZRNSYOKANSISYACD         = "zrnsyokansisyacd";
    public static final String ZRNTANTOUSYAKBN          = "zrntantousyakbn";
    public static final String ZRNTANTOUSYAKBNNEW       = "zrntantousyakbnnew";
    public static final String ZRNCLUBSUMISEIKBN        = "zrnclubsumiseikbn";
    public static final String ZRNFOLLOWTANTOUSYAKBN    = "zrnfollowtantousyakbn";
    public static final String ZRNTANTOUSYAJYOUTAIKBN   = "zrntantousyajyoutaikbn";
    public static final String ZRNKIHONYOTEII           = "zrnkihonyoteii";
    public static final String ZRNTEIKIYOTEII           = "zrnteikiyoteii";
    public static final String ZRNSONOTAYOTEII          = "zrnsonotayoteii";
    public static final String ZRNITIJIBARAIKIHONYOTEII = "zrnitijibaraikihonyoteii";
    public static final String ZRNITIJIBARAITEIKIYOTEII = "zrnitijibaraiteikiyoteii";
    public static final String ZRNITIJIBARAISONOTAYOTEII = "zrnitijibaraisonotayoteii";
    public static final String ZRNTENKANKIHONYOTEII     = "zrntenkankihonyoteii";
    public static final String ZRNTENKANTEIKIYOTEII     = "zrntenkanteikiyoteii";
    public static final String ZRNSZOUYOTEII            = "zrnszouyoteii";
    public static final String ZRNVESTINGYOTEII         = "zrnvestingyoteii";
    public static final String ZRNSIPPEITOKUYAKUYOTEII  = "zrnsippeitokuyakuyoteii";
    public static final String ZRNSEIJINBYOUTOKUYAKUYOTEII = "zrnseijinbyoutokuyakuyoteii";
    public static final String ZRNJYOSEITOKUYAKUYOTEII  = "zrnjyoseitokuyakuyoteii";
    public static final String ZRNTUUINTOKUYAKUYOTEII   = "zrntuuintokuyakuyoteii";
    public static final String ZRNSAITEIHOSYOUI         = "zrnsaiteihosyoui";
    public static final String ZRNVKISOITJBRKHNYOTEII   = "zrnvkisoitjbrkhnyoteii";
    public static final String ZRNVKISORRTZEROIKAHYOUJI = "zrnvkisorrtzeroikahyouji";
    public static final String ZRNSUURIYOUYOBIN3X2      = "zrnsuuriyouyobin3x2";
    public static final String ZRNHOYUUSISYACD2         = "zrnhoyuusisyacd2";
    public static final String ZRNDFTUJYUKUJYKISNKISIYM = "zrndftujyukujykisnkisiym";
    public static final String ZRNTIKIKKTBRIJYUTUTKSU   = "zrntikikktbrijyututksu";
    public static final String ZRNSYUNYUMRTIKYKJTIGNGTKBN = "zrnsyunyumrtikykjtigngtkbn";
    public static final String ZRNHHKDRTKYKARIHYJ       = "zrnhhkdrtkykarihyj";
    public static final String ZRNKYKDRTKYKARIHYJ       = "zrnkykdrtkykarihyj";
    public static final String ZRNYOBIV10X14            = "zrnyobiv10x14";
    public static final String ZRNKAPPADHKTGKUJYGKX1    = "zrnkappadhktgkujygkx1";
    public static final String ZRNKAPPADHKTGKUJYGKX2    = "zrnkappadhktgkujygkx2";
    public static final String ZRNKAPPADHKTGKUJYGKX3    = "zrnkappadhktgkujygkx3";
    public static final String ZRNKAPPADHKTGKUJYGKX4    = "zrnkappadhktgkujygkx4";
    public static final String ZRNTRKZSGKAIYKKJYNSTMTKZNDK = "zrntrkzsgkaiykkjynstmtkzndk";
    public static final String ZRNPMENKOURYOKUHASSEIYMD = "zrnpmenkouryokuhasseiymd";
    public static final String ZRNSUURIYOUYOBIN5        = "zrnsuuriyouyobin5";
    public static final String ZRNSUURIYOUYOBIN13       = "zrnsuuriyouyobin13";
    public static final String ZRNYOBIN11X35            = "zrnyobin11x35";
    public static final String ZRNYOBIN11X36            = "zrnyobin11x36";
    public static final String ZRNYOBIN11X37            = "zrnyobin11x37";
    public static final String ZRNTOKUYAKUKOUMOKUV200   = "zrntokuyakukoumokuv200";
    public static final String ZRNTOKUYAKUKOUMOKUV200X2 = "zrntokuyakukoumokuv200x2";
    public static final String ZRNTOKUYAKUKOUMOKUV200X3 = "zrntokuyakukoumokuv200x3";
    public static final String ZRNTOKUYAKUKOUMOKUV200X4 = "zrntokuyakukoumokuv200x4";
    public static final String ZRNTOKUYAKUKOUMOKUV200X5 = "zrntokuyakukoumokuv200x5";
    public static final String ZRNTOKUYAKUKOUMOKUV200X6 = "zrntokuyakukoumokuv200x6";
    public static final String ZRNTOKUYAKUKOUMOKUV200X7 = "zrntokuyakukoumokuv200x7";
    public static final String ZRNTOKUYAKUKOUMOKUV200X8 = "zrntokuyakukoumokuv200x8";
    public static final String ZRNTOKUYAKUKOUMOKUV200X9 = "zrntokuyakukoumokuv200x9";
    public static final String ZRNTOKUYAKUKOUMOKUV200X10 = "zrntokuyakukoumokuv200x10";
    public static final String ZRNTOKUYAKUKOUMOKUV200X11 = "zrntokuyakukoumokuv200x11";
    public static final String ZRNTOKUYAKUKOUMOKUV200X12 = "zrntokuyakukoumokuv200x12";
    public static final String ZRNTOKUYAKUKOUMOKUV200X13 = "zrntokuyakukoumokuv200x13";
    public static final String ZRNTOKUYAKUKOUMOKUV200X14 = "zrntokuyakukoumokuv200x14";
    public static final String ZRNTOKUYAKUKOUMOKUV200X15 = "zrntokuyakukoumokuv200x15";
    public static final String ZRNTOKUYAKUKOUMOKUV200X16 = "zrntokuyakukoumokuv200x16";
    public static final String ZRNTOKUYAKUKOUMOKUV200X17 = "zrntokuyakukoumokuv200x17";
    public static final String ZRNTOKUYAKUKOUMOKUV200X18 = "zrntokuyakukoumokuv200x18";
    public static final String ZRNTOKUYAKUKOUMOKUV200X19 = "zrntokuyakukoumokuv200x19";
    public static final String ZRNTOKUYAKUKOUMOKUV200X20 = "zrntokuyakukoumokuv200x20";
    public static final String ZRNTOKUYAKUKOUMOKUV200X21 = "zrntokuyakukoumokuv200x21";
    public static final String ZRNTOKUYAKUKOUMOKUV200X22 = "zrntokuyakukoumokuv200x22";
    public static final String ZRNTOKUYAKUKOUMOKUV200X23 = "zrntokuyakukoumokuv200x23";
    public static final String ZRNTOKUYAKUKOUMOKUV200X24 = "zrntokuyakukoumokuv200x24";
    public static final String ZRNTOKUYAKUKOUMOKUV200X25 = "zrntokuyakukoumokuv200x25";
    public static final String ZRNTOKUYAKUKOUMOKUV200X26 = "zrntokuyakukoumokuv200x26";
    public static final String ZRNTOKUYAKUKOUMOKUV200X27 = "zrntokuyakukoumokuv200x27";
    public static final String ZRNTOKUYAKUKOUMOKUV200X28 = "zrntokuyakukoumokuv200x28";
    public static final String ZRNTOKUYAKUKOUMOKUV200X29 = "zrntokuyakukoumokuv200x29";
    public static final String ZRNTOKUYAKUKOUMOKUV200X30 = "zrntokuyakukoumokuv200x30";
    public static final String ZRNTOKUYAKUKOUMOKUV200X31 = "zrntokuyakukoumokuv200x31";
    public static final String ZRNTOKUYAKUKOUMOKUV200X32 = "zrntokuyakukoumokuv200x32";
    public static final String ZRNTOKUYAKUKOUMOKUV200X33 = "zrntokuyakukoumokuv200x33";
    public static final String ZRNTOKUYAKUKOUMOKUV200X34 = "zrntokuyakukoumokuv200x34";
    public static final String ZRNTOKUYAKUKOUMOKUV200X35 = "zrntokuyakukoumokuv200x35";
    public static final String ZRNTOKUYAKUKOUMOKUV200X36 = "zrntokuyakukoumokuv200x36";
    public static final String ZRNTOKUYAKUKOUMOKUV200X37 = "zrntokuyakukoumokuv200x37";
    public static final String ZRNTOKUYAKUKOUMOKUV200X38 = "zrntokuyakukoumokuv200x38";
    public static final String ZRNTOKUYAKUKOUMOKUV200X39 = "zrntokuyakukoumokuv200x39";
    public static final String ZRNTOKUYAKUKOUMOKUV200X40 = "zrntokuyakukoumokuv200x40";

    private final PKZT_IdouMeisaiRn primaryKey;

    public GenZT_IdouMeisaiRn() {
        primaryKey = new PKZT_IdouMeisaiRn();
    }

    public GenZT_IdouMeisaiRn(Integer pZrnsequenceno) {
        primaryKey = new PKZT_IdouMeisaiRn(pZrnsequenceno);
    }

    @Transient
    @Override
    public PKZT_IdouMeisaiRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_IdouMeisaiRn> getMetaClass() {
        return QZT_IdouMeisaiRn.class;
    }

    @Id
    @Column(name=GenZT_IdouMeisaiRn.ZRNSEQUENCENO)
    public Integer getZrnsequenceno() {
        return getPrimaryKey().getZrnsequenceno();
    }

    public void setZrnsequenceno(Integer pZrnsequenceno) {
        getPrimaryKey().setZrnsequenceno(pZrnsequenceno);
    }

    private Integer zrnyuukourecordlength;

    @Column(name=GenZT_IdouMeisaiRn.ZRNYUUKOURECORDLENGTH)
    public Integer getZrnyuukourecordlength() {
        return zrnyuukourecordlength;
    }

    public void setZrnyuukourecordlength(Integer pZrnyuukourecordlength) {
        zrnyuukourecordlength = pZrnyuukourecordlength;
    }

    private String zrnrdwarea;

    @Column(name=GenZT_IdouMeisaiRn.ZRNRDWAREA)
    public String getZrnrdwarea() {
        return zrnrdwarea;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrnrdwarea(String pZrnrdwarea) {
        zrnrdwarea = pZrnrdwarea;
    }

    private String zrnrecordkbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNRECORDKBN)
    public String getZrnrecordkbn() {
        return zrnrecordkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnrecordkbn(String pZrnrecordkbn) {
        zrnrecordkbn = pZrnrecordkbn;
    }

    private String zrnnenkinkaisigohyouji;

    @Column(name=GenZT_IdouMeisaiRn.ZRNNENKINKAISIGOHYOUJI)
    public String getZrnnenkinkaisigohyouji() {
        return zrnnenkinkaisigohyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnnenkinkaisigohyouji(String pZrnnenkinkaisigohyouji) {
        zrnnenkinkaisigohyouji = pZrnnenkinkaisigohyouji;
    }

    private String zrnnksgokurikosidhyj;

    @Column(name=GenZT_IdouMeisaiRn.ZRNNKSGOKURIKOSIDHYJ)
    public String getZrnnksgokurikosidhyj() {
        return zrnnksgokurikosidhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnnksgokurikosidhyj(String pZrnnksgokurikosidhyj) {
        zrnnksgokurikosidhyj = pZrnnksgokurikosidhyj;
    }

    private String zrnkeijyouym;

    @Column(name=GenZT_IdouMeisaiRn.ZRNKEIJYOUYM)
    public String getZrnkeijyouym() {
        return zrnkeijyouym;
    }

    public void setZrnkeijyouym(String pZrnkeijyouym) {
        zrnkeijyouym = pZrnkeijyouym;
    }

    private String zrnidojiyukbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNIDOJIYUKBN)
    public String getZrnidojiyukbn() {
        return zrnidojiyukbn;
    }

    public void setZrnidojiyukbn(String pZrnidojiyukbn) {
        zrnidojiyukbn = pZrnidojiyukbn;
    }

    private String zrnzougenkbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNZOUGENKBN)
    public String getZrnzougenkbn() {
        return zrnzougenkbn;
    }

    public void setZrnzougenkbn(String pZrnzougenkbn) {
        zrnzougenkbn = pZrnzougenkbn;
    }

    private String zrnidourecordkbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNIDOURECORDKBN)
    public String getZrnidourecordkbn() {
        return zrnidourecordkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnidourecordkbn(String pZrnidourecordkbn) {
        zrnidourecordkbn = pZrnidourecordkbn;
    }

    private String zrnkeijyouctrlkbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNKEIJYOUCTRLKBN)
    public String getZrnkeijyouctrlkbn() {
        return zrnkeijyouctrlkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkeijyouctrlkbn(String pZrnkeijyouctrlkbn) {
        zrnkeijyouctrlkbn = pZrnkeijyouctrlkbn;
    }

    private String zrnhenkousyoriymd;

    @Column(name=GenZT_IdouMeisaiRn.ZRNHENKOUSYORIYMD)
    public String getZrnhenkousyoriymd() {
        return zrnhenkousyoriymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnhenkousyoriymd(String pZrnhenkousyoriymd) {
        zrnhenkousyoriymd = pZrnhenkousyoriymd;
    }

    private Integer zrnkykmfksnctr;

    @Column(name=GenZT_IdouMeisaiRn.ZRNKYKMFKSNCTR)
    public Integer getZrnkykmfksnctr() {
        return zrnkykmfksnctr;
    }

    public void setZrnkykmfksnctr(Integer pZrnkykmfksnctr) {
        zrnkykmfksnctr = pZrnkykmfksnctr;
    }

    private Integer zrnrecordctr;

    @Column(name=GenZT_IdouMeisaiRn.ZRNRECORDCTR)
    public Integer getZrnrecordctr() {
        return zrnrecordctr;
    }

    public void setZrnrecordctr(Integer pZrnrecordctr) {
        zrnrecordctr = pZrnrecordctr;
    }

    private String zrnsuuriyoukouryokukaisiymd;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSUURIYOUKOURYOKUKAISIYMD)
    public String getZrnsuuriyoukouryokukaisiymd() {
        return zrnsuuriyoukouryokukaisiymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnsuuriyoukouryokukaisiymd(String pZrnsuuriyoukouryokukaisiymd) {
        zrnsuuriyoukouryokukaisiymd = pZrnsuuriyoukouryokukaisiymd;
    }

    private String zrndenymd;

    @Column(name=GenZT_IdouMeisaiRn.ZRNDENYMD)
    public String getZrndenymd() {
        return zrndenymd;
    }

    public void setZrndenymd(String pZrndenymd) {
        zrndenymd = pZrndenymd;
    }

    private String zrnbluekeizokuhyouji;

    @Column(name=GenZT_IdouMeisaiRn.ZRNBLUEKEIZOKUHYOUJI)
    public String getZrnbluekeizokuhyouji() {
        return zrnbluekeizokuhyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnbluekeizokuhyouji(String pZrnbluekeizokuhyouji) {
        zrnbluekeizokuhyouji = pZrnbluekeizokuhyouji;
    }

    private String zrnsuuriyouyobin1x2;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSUURIYOUYOBIN1X2)
    public String getZrnsuuriyouyobin1x2() {
        return zrnsuuriyouyobin1x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsuuriyouyobin1x2(String pZrnsuuriyouyobin1x2) {
        zrnsuuriyouyobin1x2 = pZrnsuuriyouyobin1x2;
    }

    private String zrntoukeikeijyoukbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTOUKEIKEIJYOUKBN)
    public String getZrntoukeikeijyoukbn() {
        return zrntoukeikeijyoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntoukeikeijyoukbn(String pZrntoukeikeijyoukbn) {
        zrntoukeikeijyoukbn = pZrntoukeikeijyoukbn;
    }

    private String zrnraysystemhyj;

    @Column(name=GenZT_IdouMeisaiRn.ZRNRAYSYSTEMHYJ)
    public String getZrnraysystemhyj() {
        return zrnraysystemhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnraysystemhyj(String pZrnraysystemhyj) {
        zrnraysystemhyj = pZrnraysystemhyj;
    }

    private String zrnzenkiidouteiseikbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNZENKIIDOUTEISEIKBN)
    public String getZrnzenkiidouteiseikbn() {
        return zrnzenkiidouteiseikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnzenkiidouteiseikbn(String pZrnzenkiidouteiseikbn) {
        zrnzenkiidouteiseikbn = pZrnzenkiidouteiseikbn;
    }

    private String zrnbsyym;

    @Column(name=GenZT_IdouMeisaiRn.ZRNBSYYM)
    public String getZrnbsyym() {
        return zrnbsyym;
    }

    public void setZrnbsyym(String pZrnbsyym) {
        zrnbsyym = pZrnbsyym;
    }

    private String zrntenkangokeiyakubosyuuym;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTENKANGOKEIYAKUBOSYUUYM)
    public String getZrntenkangokeiyakubosyuuym() {
        return zrntenkangokeiyakubosyuuym;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrntenkangokeiyakubosyuuym(String pZrntenkangokeiyakubosyuuym) {
        zrntenkangokeiyakubosyuuym = pZrntenkangokeiyakubosyuuym;
    }

    private String zrnidoujiyuucd;

    @Column(name=GenZT_IdouMeisaiRn.ZRNIDOUJIYUUCD)
    public String getZrnidoujiyuucd() {
        return zrnidoujiyuucd;
    }

    public void setZrnidoujiyuucd(String pZrnidoujiyuucd) {
        zrnidoujiyuucd = pZrnidoujiyuucd;
    }

    private String zrnsyoricd;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSYORICD)
    public String getZrnsyoricd() {
        return zrnsyoricd;
    }

    public void setZrnsyoricd(String pZrnsyoricd) {
        zrnsyoricd = pZrnsyoricd;
    }

    private String zrnsekininteiseihyouji;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSEKININTEISEIHYOUJI)
    public String getZrnsekininteiseihyouji() {
        return zrnsekininteiseihyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsekininteiseihyouji(String pZrnsekininteiseihyouji) {
        zrnsekininteiseihyouji = pZrnsekininteiseihyouji;
    }

    private String zrnsuuriyouyobin8;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSUURIYOUYOBIN8)
    public String getZrnsuuriyouyobin8() {
        return zrnsuuriyouyobin8;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnsuuriyouyobin8(String pZrnsuuriyouyobin8) {
        zrnsuuriyouyobin8 = pZrnsuuriyouyobin8;
    }

    private String zrnsihankibikinkbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSIHANKIBIKINKBN)
    public String getZrnsihankibikinkbn() {
        return zrnsihankibikinkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsihankibikinkbn(String pZrnsihankibikinkbn) {
        zrnsihankibikinkbn = pZrnsihankibikinkbn;
    }

    private String zrnsuuriyouyobin1x3;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSUURIYOUYOBIN1X3)
    public String getZrnsuuriyouyobin1x3() {
        return zrnsuuriyouyobin1x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsuuriyouyobin1x3(String pZrnsuuriyouyobin1x3) {
        zrnsuuriyouyobin1x3 = pZrnsuuriyouyobin1x3;
    }

    private String zrndatakanrino;

    @Column(name=GenZT_IdouMeisaiRn.ZRNDATAKANRINO)
    public String getZrndatakanrino() {
        return zrndatakanrino;
    }

    public void setZrndatakanrino(String pZrndatakanrino) {
        zrndatakanrino = pZrndatakanrino;
    }

    private String zrnhknsyukigou;

    @Column(name=GenZT_IdouMeisaiRn.ZRNHKNSYUKIGOU)
    public String getZrnhknsyukigou() {
        return zrnhknsyukigou;
    }

    public void setZrnhknsyukigou(String pZrnhknsyukigou) {
        zrnhknsyukigou = pZrnhknsyukigou;
    }

    private String zrnhknsyuruikigousedaikbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNHKNSYURUIKIGOUSEDAIKBN)
    public String getZrnhknsyuruikigousedaikbn() {
        return zrnhknsyuruikigousedaikbn;
    }

    public void setZrnhknsyuruikigousedaikbn(String pZrnhknsyuruikigousedaikbn) {
        zrnhknsyuruikigousedaikbn = pZrnhknsyuruikigousedaikbn;
    }

    private String zrnsotodasipmenkbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSOTODASIPMENKBN)
    public String getZrnsotodasipmenkbn() {
        return zrnsotodasipmenkbn;
    }

    public void setZrnsotodasipmenkbn(String pZrnsotodasipmenkbn) {
        zrnsotodasipmenkbn = pZrnsotodasipmenkbn;
    }

    private String zrnstdssytikbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSTDSSYTIKBN)
    public String getZrnstdssytikbn() {
        return zrnstdssytikbn;
    }

    public void setZrnstdssytikbn(String pZrnstdssytikbn) {
        zrnstdssytikbn = pZrnstdssytikbn;
    }

    private String zrnstdssnskbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSTDSSNSKBN)
    public String getZrnstdssnskbn() {
        return zrnstdssnskbn;
    }

    public void setZrnstdssnskbn(String pZrnstdssnskbn) {
        zrnstdssnskbn = pZrnstdssnskbn;
    }

    private String zrnsotodasimanagehyouji;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSOTODASIMANAGEHYOUJI)
    public String getZrnsotodasimanagehyouji() {
        return zrnsotodasimanagehyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsotodasimanagehyouji(String pZrnsotodasimanagehyouji) {
        zrnsotodasimanagehyouji = pZrnsotodasimanagehyouji;
    }

    private String zrnsotodasiphkbnmnoshyouji;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSOTODASIPHKBNMNOSHYOUJI)
    public String getZrnsotodasiphkbnmnoshyouji() {
        return zrnsotodasiphkbnmnoshyouji;
    }

    public void setZrnsotodasiphkbnmnoshyouji(String pZrnsotodasiphkbnmnoshyouji) {
        zrnsotodasiphkbnmnoshyouji = pZrnsotodasiphkbnmnoshyouji;
    }

    private String zrnstdsstkjytkyuhyj;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSTDSSTKJYTKYUHYJ)
    public String getZrnstdsstkjytkyuhyj() {
        return zrnstdsstkjytkyuhyj;
    }

    public void setZrnstdsstkjytkyuhyj(String pZrnstdsstkjytkyuhyj) {
        zrnstdsstkjytkyuhyj = pZrnstdsstkjytkyuhyj;
    }

    private String zrnkbnkeiriyousegmentkbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNKBNKEIRIYOUSEGMENTKBN)
    public String getZrnkbnkeiriyousegmentkbn() {
        return zrnkbnkeiriyousegmentkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkbnkeiriyousegmentkbn(String pZrnkbnkeiriyousegmentkbn) {
        zrnkbnkeiriyousegmentkbn = pZrnkbnkeiriyousegmentkbn;
    }

    private String zrnkbnkeiriyourgnbnskkbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNKBNKEIRIYOURGNBNSKKBN)
    public String getZrnkbnkeiriyourgnbnskkbn() {
        return zrnkbnkeiriyourgnbnskkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkbnkeiriyourgnbnskkbn(String pZrnkbnkeiriyourgnbnskkbn) {
        zrnkbnkeiriyourgnbnskkbn = pZrnkbnkeiriyourgnbnskkbn;
    }

    private String zrnsuurisyuruicd;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSUURISYURUICD)
    public String getZrnsuurisyuruicd() {
        return zrnsuurisyuruicd;
    }

    public void setZrnsuurisyuruicd(String pZrnsuurisyuruicd) {
        zrnsuurisyuruicd = pZrnsuurisyuruicd;
    }

    private String zrnhosyoukinoukbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNHOSYOUKINOUKBN)
    public String getZrnhosyoukinoukbn() {
        return zrnhosyoukinoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhosyoukinoukbn(String pZrnhosyoukinoukbn) {
        zrnhosyoukinoukbn = pZrnhosyoukinoukbn;
    }

    private String zrndaikbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNDAIKBN)
    public String getZrndaikbn() {
        return zrndaikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndaikbn(String pZrndaikbn) {
        zrndaikbn = pZrndaikbn;
    }

    private String zrntyuukbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTYUUKBN)
    public String getZrntyuukbn() {
        return zrntyuukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrntyuukbn(String pZrntyuukbn) {
        zrntyuukbn = pZrntyuukbn;
    }

    private String zrnsyoukbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSYOUKBN)
    public String getZrnsyoukbn() {
        return zrnsyoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrnsyoukbn(String pZrnsyoukbn) {
        zrnsyoukbn = pZrnsyoukbn;
    }

    private String zrnsedaikbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSEDAIKBN)
    public String getZrnsedaikbn() {
        return zrnsedaikbn;
    }

    public void setZrnsedaikbn(String pZrnsedaikbn) {
        zrnsedaikbn = pZrnsedaikbn;
    }

    private String zrnharaikatakbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNHARAIKATAKBN)
    public String getZrnharaikatakbn() {
        return zrnharaikatakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnharaikatakbn(String pZrnharaikatakbn) {
        zrnharaikatakbn = pZrnharaikatakbn;
    }

    private String zrnkykymd;

    @Column(name=GenZT_IdouMeisaiRn.ZRNKYKYMD)
    public String getZrnkykymd() {
        return zrnkykymd;
    }

    public void setZrnkykymd(String pZrnkykymd) {
        zrnkykymd = pZrnkykymd;
    }

    private String zrnhknkkn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNHKNKKN)
    public String getZrnhknkkn() {
        return zrnhknkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhknkkn(String pZrnhknkkn) {
        zrnhknkkn = pZrnhknkkn;
    }

    private String zrnphrkkikn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNPHRKKIKN)
    public String getZrnphrkkikn() {
        return zrnphrkkikn;
    }

    public void setZrnphrkkikn(String pZrnphrkkikn) {
        zrnphrkkikn = pZrnphrkkikn;
    }

    private String zrnsaimnkkykhyj;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSAIMNKKYKHYJ)
    public String getZrnsaimnkkykhyj() {
        return zrnsaimnkkykhyj;
    }

    public void setZrnsaimnkkykhyj(String pZrnsaimnkkykhyj) {
        zrnsaimnkkykhyj = pZrnsaimnkkykhyj;
    }

    private String zrnannaifuyouriyuukbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNANNAIFUYOURIYUUKBN)
    public String getZrnannaifuyouriyuukbn() {
        return zrnannaifuyouriyuukbn;
    }

    public void setZrnannaifuyouriyuukbn(String pZrnannaifuyouriyuukbn) {
        zrnannaifuyouriyuukbn = pZrnannaifuyouriyuukbn;
    }

    private String zrntksyuannaikykkbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTKSYUANNAIKYKKBN)
    public String getZrntksyuannaikykkbn() {
        return zrntksyuannaikykkbn;
    }

    public void setZrntksyuannaikykkbn(String pZrntksyuannaikykkbn) {
        zrntksyuannaikykkbn = pZrntksyuannaikykkbn;
    }

    private String zrnhrkkaisuukbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNHRKKAISUUKBN)
    public String getZrnhrkkaisuukbn() {
        return zrnhrkkaisuukbn;
    }

    public void setZrnhrkkaisuukbn(String pZrnhrkkaisuukbn) {
        zrnhrkkaisuukbn = pZrnhrkkaisuukbn;
    }

    private String zrnhrkkeirokbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNHRKKEIROKBN)
    public String getZrnhrkkeirokbn() {
        return zrnhrkkeirokbn;
    }

    public void setZrnhrkkeirokbn(String pZrnhrkkeirokbn) {
        zrnhrkkeirokbn = pZrnhrkkeirokbn;
    }

    private String zrnsdpdkbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSDPDKBN)
    public String getZrnsdpdkbn() {
        return zrnsdpdkbn;
    }

    public void setZrnsdpdkbn(String pZrnsdpdkbn) {
        zrnsdpdkbn = pZrnsdpdkbn;
    }

    private String zrnryouritukbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNRYOURITUKBN)
    public String getZrnryouritukbn() {
        return zrnryouritukbn;
    }

    public void setZrnryouritukbn(String pZrnryouritukbn) {
        zrnryouritukbn = pZrnryouritukbn;
    }

    private String zrnao3tyou3sibousdatehyouji;

    @Column(name=GenZT_IdouMeisaiRn.ZRNAO3TYOU3SIBOUSDATEHYOUJI)
    public String getZrnao3tyou3sibousdatehyouji() {
        return zrnao3tyou3sibousdatehyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnao3tyou3sibousdatehyouji(String pZrnao3tyou3sibousdatehyouji) {
        zrnao3tyou3sibousdatehyouji = pZrnao3tyou3sibousdatehyouji;
    }

    private String zrnhhknseikbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNHHKNSEIKBN)
    public String getZrnhhknseikbn() {
        return zrnhhknseikbn;
    }

    public void setZrnhhknseikbn(String pZrnhhknseikbn) {
        zrnhhknseikbn = pZrnhhknseikbn;
    }

    private String zrnhihokensyaagev2;

    @Column(name=GenZT_IdouMeisaiRn.ZRNHIHOKENSYAAGEV2)
    public String getZrnhihokensyaagev2() {
        return zrnhihokensyaagev2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhihokensyaagev2(String pZrnhihokensyaagev2) {
        zrnhihokensyaagev2 = pZrnhihokensyaagev2;
    }

    private String zrnkyksyanen;

    @Column(name=GenZT_IdouMeisaiRn.ZRNKYKSYANEN)
    public String getZrnkyksyanen() {
        return zrnkyksyanen;
    }

    public void setZrnkyksyanen(String pZrnkyksyanen) {
        zrnkyksyanen = pZrnkyksyanen;
    }

    private String zrndai2hhknnen;

    @Column(name=GenZT_IdouMeisaiRn.ZRNDAI2HHKNNEN)
    public String getZrndai2hhknnen() {
        return zrndai2hhknnen;
    }

    public void setZrndai2hhknnen(String pZrndai2hhknnen) {
        zrndai2hhknnen = pZrndai2hhknnen;
    }

    private String zrntkbthsyumnryuhyouji;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTKBTHSYUMNRYUHYOUJI)
    public String getZrntkbthsyumnryuhyouji() {
        return zrntkbthsyumnryuhyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntkbthsyumnryuhyouji(String pZrntkbthsyumnryuhyouji) {
        zrntkbthsyumnryuhyouji = pZrntkbthsyumnryuhyouji;
    }

    private String zrnsyukeiyakupwaribikikbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSYUKEIYAKUPWARIBIKIKBN)
    public String getZrnsyukeiyakupwaribikikbn() {
        return zrnsyukeiyakupwaribikikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsyukeiyakupwaribikikbn(String pZrnsyukeiyakupwaribikikbn) {
        zrnsyukeiyakupwaribikikbn = pZrnsyukeiyakupwaribikikbn;
    }

    private String zrntenkanwaribikikbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTENKANWARIBIKIKBN)
    public String getZrntenkanwaribikikbn() {
        return zrntenkanwaribikikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrntenkanwaribikikbn(String pZrntenkanwaribikikbn) {
        zrntenkanwaribikikbn = pZrntenkanwaribikikbn;
    }

    private String zrnyuuhitutnknyuguryurtkbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNYUUHITUTNKNYUGURYURTKBN)
    public String getZrnyuuhitutnknyuguryurtkbn() {
        return zrnyuuhitutnknyuguryurtkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnyuuhitutnknyuguryurtkbn(String pZrnyuuhitutnknyuguryurtkbn) {
        zrnyuuhitutnknyuguryurtkbn = pZrnyuuhitutnknyuguryurtkbn;
    }

    private Long zrnsyukeiyakup;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSYUKEIYAKUP)
    public Long getZrnsyukeiyakup() {
        return zrnsyukeiyakup;
    }

    public void setZrnsyukeiyakup(Long pZrnsyukeiyakup) {
        zrnsyukeiyakup = pZrnsyukeiyakup;
    }

    private Long zrntokujyoup;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTOKUJYOUP)
    public Long getZrntokujyoup() {
        return zrntokujyoup;
    }

    public void setZrntokujyoup(Long pZrntokujyoup) {
        zrntokujyoup = pZrntokujyoup;
    }

    private Long zrnsiteizukisyukeiyakup;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSITEIZUKISYUKEIYAKUP)
    public Long getZrnsiteizukisyukeiyakup() {
        return zrnsiteizukisyukeiyakup;
    }

    public void setZrnsiteizukisyukeiyakup(Long pZrnsiteizukisyukeiyakup) {
        zrnsiteizukisyukeiyakup = pZrnsiteizukisyukeiyakup;
    }

    private Long zrnkihons;

    @Column(name=GenZT_IdouMeisaiRn.ZRNKIHONS)
    public Long getZrnkihons() {
        return zrnkihons;
    }

    public void setZrnkihons(Long pZrnkihons) {
        zrnkihons = pZrnkihons;
    }

    private Long zrnsibous;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSIBOUS)
    public Long getZrnsibous() {
        return zrnsibous;
    }

    public void setZrnsibous(Long pZrnsibous) {
        zrnsibous = pZrnsibous;
    }

    private Long zrnhenkougokihons;

    @Column(name=GenZT_IdouMeisaiRn.ZRNHENKOUGOKIHONS)
    public Long getZrnhenkougokihons() {
        return zrnhenkougokihons;
    }

    public void setZrnhenkougokihons(Long pZrnhenkougokihons) {
        zrnhenkougokihons = pZrnhenkougokihons;
    }

    private Long zrnhenkougosibous;

    @Column(name=GenZT_IdouMeisaiRn.ZRNHENKOUGOSIBOUS)
    public Long getZrnhenkougosibous() {
        return zrnhenkougosibous;
    }

    public void setZrnhenkougosibous(Long pZrnhenkougosibous) {
        zrnhenkougosibous = pZrnhenkougosibous;
    }

    private String zrnhenkouymd;

    @Column(name=GenZT_IdouMeisaiRn.ZRNHENKOUYMD)
    public String getZrnhenkouymd() {
        return zrnhenkouymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnhenkouymd(String pZrnhenkouymd) {
        zrnhenkouymd = pZrnhenkouymd;
    }

    private String zrnentyoukikan;

    @Column(name=GenZT_IdouMeisaiRn.ZRNENTYOUKIKAN)
    public String getZrnentyoukikan() {
        return zrnentyoukikan;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrnentyoukikan(String pZrnentyoukikan) {
        zrnentyoukikan = pZrnentyoukikan;
    }

    private String zrnseizonkyuuhukinsiteimd;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSEIZONKYUUHUKINSITEIMD)
    public String getZrnseizonkyuuhukinsiteimd() {
        return zrnseizonkyuuhukinsiteimd;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrnseizonkyuuhukinsiteimd(String pZrnseizonkyuuhukinsiteimd) {
        zrnseizonkyuuhukinsiteimd = pZrnseizonkyuuhukinsiteimd;
    }

    private Long zrnsyukeiyakusiharaikingaku;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSYUKEIYAKUSIHARAIKINGAKU)
    public Long getZrnsyukeiyakusiharaikingaku() {
        return zrnsyukeiyakusiharaikingaku;
    }

    public void setZrnsyukeiyakusiharaikingaku(Long pZrnsyukeiyakusiharaikingaku) {
        zrnsyukeiyakusiharaikingaku = pZrnsyukeiyakusiharaikingaku;
    }

    private String zrnatukaisisyatodouhukencd;

    @Column(name=GenZT_IdouMeisaiRn.ZRNATUKAISISYATODOUHUKENCD)
    public String getZrnatukaisisyatodouhukencd() {
        return zrnatukaisisyatodouhukencd;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnatukaisisyatodouhukencd(String pZrnatukaisisyatodouhukencd) {
        zrnatukaisisyatodouhukencd = pZrnatukaisisyatodouhukencd;
    }

    private Integer zrntokuyakuhukasuu;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTOKUYAKUHUKASUU)
    public Integer getZrntokuyakuhukasuu() {
        return zrntokuyakuhukasuu;
    }

    public void setZrntokuyakuhukasuu(Integer pZrntokuyakuhukasuu) {
        zrntokuyakuhukasuu = pZrntokuyakuhukasuu;
    }

    private String zrndi2hknkknikoujihisyaage;

    @Column(name=GenZT_IdouMeisaiRn.ZRNDI2HKNKKNIKOUJIHISYAAGE)
    public String getZrndi2hknkknikoujihisyaage() {
        return zrndi2hknkknikoujihisyaage;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2hknkknikoujihisyaage(String pZrndi2hknkknikoujihisyaage) {
        zrndi2hknkknikoujihisyaage = pZrndi2hknkknikoujihisyaage;
    }

    private String zrnhrimnentyoumaephrkkkn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNHRIMNENTYOUMAEPHRKKKN)
    public String getZrnhrimnentyoumaephrkkkn() {
        return zrnhrimnentyoumaephrkkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhrimnentyoumaephrkkkn(String pZrnhrimnentyoumaephrkkkn) {
        zrnhrimnentyoumaephrkkkn = pZrnhrimnentyoumaephrkkkn;
    }

    private String zrntokubetuhosyoukikan;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTOKUBETUHOSYOUKIKAN)
    public String getZrntokubetuhosyoukikan() {
        return zrntokubetuhosyoukikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrntokubetuhosyoukikan(String pZrntokubetuhosyoukikan) {
        zrntokubetuhosyoukikan = pZrntokubetuhosyoukikan;
    }

    private String zrnkousinmanryouage;

    @Column(name=GenZT_IdouMeisaiRn.ZRNKOUSINMANRYOUAGE)
    public String getZrnkousinmanryouage() {
        return zrnkousinmanryouage;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkousinmanryouage(String pZrnkousinmanryouage) {
        zrnkousinmanryouage = pZrnkousinmanryouage;
    }

    private String zrnknkuzusnzyrttekitkarihyj;

    @Column(name=GenZT_IdouMeisaiRn.ZRNKNKUZUSNZYRTTEKITKARIHYJ)
    public String getZrnknkuzusnzyrttekitkarihyj() {
        return zrnknkuzusnzyrttekitkarihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnknkuzusnzyrttekitkarihyj(String pZrnknkuzusnzyrttekitkarihyj) {
        zrnknkuzusnzyrttekitkarihyj = pZrnknkuzusnzyrttekitkarihyj;
    }

    private String zrnkuriagekurisagekbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNKURIAGEKURISAGEKBN)
    public String getZrnkuriagekurisagekbn() {
        return zrnkuriagekurisagekbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkuriagekurisagekbn(String pZrnkuriagekurisagekbn) {
        zrnkuriagekurisagekbn = pZrnkuriagekurisagekbn;
    }

    private String zrnhrizmjhknsyukigousdkbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNHRIZMJHKNSYUKIGOUSDKBN)
    public String getZrnhrizmjhknsyukigousdkbn() {
        return zrnhrizmjhknsyukigousdkbn;
    }

    public void setZrnhrizmjhknsyukigousdkbn(String pZrnhrizmjhknsyukigousdkbn) {
        zrnhrizmjhknsyukigousdkbn = pZrnhrizmjhknsyukigousdkbn;
    }

    private String zrnkrsgjhknsyukigousdkbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNKRSGJHKNSYUKIGOUSDKBN)
    public String getZrnkrsgjhknsyukigousdkbn() {
        return zrnkrsgjhknsyukigousdkbn;
    }

    public void setZrnkrsgjhknsyukigousdkbn(String pZrnkrsgjhknsyukigousdkbn) {
        zrnkrsgjhknsyukigousdkbn = pZrnkrsgjhknsyukigousdkbn;
    }

    private String zrnsotodasisyouhinkaiteikbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSOTODASISYOUHINKAITEIKBN)
    public String getZrnsotodasisyouhinkaiteikbn() {
        return zrnsotodasisyouhinkaiteikbn;
    }

    public void setZrnsotodasisyouhinkaiteikbn(String pZrnsotodasisyouhinkaiteikbn) {
        zrnsotodasisyouhinkaiteikbn = pZrnsotodasisyouhinkaiteikbn;
    }

    private String zrnyobiv4;

    @Column(name=GenZT_IdouMeisaiRn.ZRNYOBIV4)
    public String getZrnyobiv4() {
        return zrnyobiv4;
    }

    public void setZrnyobiv4(String pZrnyobiv4) {
        zrnyobiv4 = pZrnyobiv4;
    }

    private Long zrngoukeitenkans;

    @Column(name=GenZT_IdouMeisaiRn.ZRNGOUKEITENKANS)
    public Long getZrngoukeitenkans() {
        return zrngoukeitenkans;
    }

    public void setZrngoukeitenkans(Long pZrngoukeitenkans) {
        zrngoukeitenkans = pZrngoukeitenkans;
    }

    private Long zrngoukeipbubuntenkans;

    @Column(name=GenZT_IdouMeisaiRn.ZRNGOUKEIPBUBUNTENKANS)
    public Long getZrngoukeipbubuntenkans() {
        return zrngoukeipbubuntenkans;
    }

    public void setZrngoukeipbubuntenkans(Long pZrngoukeipbubuntenkans) {
        zrngoukeipbubuntenkans = pZrngoukeipbubuntenkans;
    }

    private String zrntenkanteikisyuruikigou;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTENKANTEIKISYURUIKIGOU)
    public String getZrntenkanteikisyuruikigou() {
        return zrntenkanteikisyuruikigou;
    }

    public void setZrntenkanteikisyuruikigou(String pZrntenkanteikisyuruikigou) {
        zrntenkanteikisyuruikigou = pZrntenkanteikisyuruikigou;
    }

    private String zrntenkanteikikigousedaikbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTENKANTEIKIKIGOUSEDAIKBN)
    public String getZrntenkanteikikigousedaikbn() {
        return zrntenkanteikikigousedaikbn;
    }

    public void setZrntenkanteikikigousedaikbn(String pZrntenkanteikikigousedaikbn) {
        zrntenkanteikikigousedaikbn = pZrntenkanteikikigousedaikbn;
    }

    private String zrntnkntiksotodasikusnkbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTNKNTIKSOTODASIKUSNKBN)
    public String getZrntnkntiksotodasikusnkbn() {
        return zrntnkntiksotodasikusnkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntnkntiksotodasikusnkbn(String pZrntnkntiksotodasikusnkbn) {
        zrntnkntiksotodasikusnkbn = pZrntnkntiksotodasikusnkbn;
    }

    private String zrntnkntikstdspmenkbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTNKNTIKSTDSPMENKBN)
    public String getZrntnkntikstdspmenkbn() {
        return zrntnkntikstdspmenkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntnkntikstdspmenkbn(String pZrntnkntikstdspmenkbn) {
        zrntnkntikstdspmenkbn = pZrntnkntikstdspmenkbn;
    }

    private String zrntenkanteikikigouyobi;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTENKANTEIKIKIGOUYOBI)
    public String getZrntenkanteikikigouyobi() {
        return zrntenkanteikikigouyobi;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntenkanteikikigouyobi(String pZrntenkanteikikigouyobi) {
        zrntenkanteikikigouyobi = pZrntenkanteikikigouyobi;
    }

    private String zrntenkanteikikikan;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTENKANTEIKIKIKAN)
    public String getZrntenkanteikikikan() {
        return zrntenkanteikikikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrntenkanteikikikan(String pZrntenkanteikikikan) {
        zrntenkanteikikikan = pZrntenkanteikikikan;
    }

    private Long zrngoukeitenkanteikis;

    @Column(name=GenZT_IdouMeisaiRn.ZRNGOUKEITENKANTEIKIS)
    public Long getZrngoukeitenkanteikis() {
        return zrngoukeitenkanteikis;
    }

    public void setZrngoukeitenkanteikis(Long pZrngoukeitenkanteikis) {
        zrngoukeitenkanteikis = pZrngoukeitenkanteikis;
    }

    private String zrntnknteikinkshrkkn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTNKNTEIKINKSHRKKN)
    public String getZrntnknteikinkshrkkn() {
        return zrntnknteikinkshrkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrntnknteikinkshrkkn(String pZrntnknteikinkshrkkn) {
        zrntnknteikinkshrkkn = pZrntnknteikinkshrkkn;
    }

    private Long zrntenkansiharaikingaku;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTENKANSIHARAIKINGAKU)
    public Long getZrntenkansiharaikingaku() {
        return zrntenkansiharaikingaku;
    }

    public void setZrntenkansiharaikingaku(Long pZrntenkansiharaikingaku) {
        zrntenkansiharaikingaku = pZrntenkansiharaikingaku;
    }

    private Long zrntnkntikshrkngk;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTNKNTIKSHRKNGK)
    public Long getZrntnkntikshrkngk() {
        return zrntnkntikshrkngk;
    }

    public void setZrntnkntikshrkngk(Long pZrntnkntikshrkngk) {
        zrntnkntikshrkngk = pZrntnkntikshrkngk;
    }

    private String zrntenkankaisuu;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTENKANKAISUU)
    public String getZrntenkankaisuu() {
        return zrntenkankaisuu;
    }

    public void setZrntenkankaisuu(String pZrntenkankaisuu) {
        zrntenkankaisuu = pZrntenkankaisuu;
    }

    private Long zrngoukeitenkankakaku;

    @Column(name=GenZT_IdouMeisaiRn.ZRNGOUKEITENKANKAKAKU)
    public Long getZrngoukeitenkankakaku() {
        return zrngoukeitenkankakaku;
    }

    public void setZrngoukeitenkankakaku(Long pZrngoukeitenkankakaku) {
        zrngoukeitenkankakaku = pZrngoukeitenkankakaku;
    }

    private BizNumber zrntnknkhnbbnjyuturt;

    @Type(type="BizNumberType")
    @Column(name=GenZT_IdouMeisaiRn.ZRNTNKNKHNBBNJYUTURT)
    public BizNumber getZrntnknkhnbbnjyuturt() {
        return zrntnknkhnbbnjyuturt;
    }

    public void setZrntnknkhnbbnjyuturt(BizNumber pZrntnknkhnbbnjyuturt) {
        zrntnknkhnbbnjyuturt = pZrntnknkhnbbnjyuturt;
    }

    private Long zrnwnasigoukeitenkanteikis;

    @Column(name=GenZT_IdouMeisaiRn.ZRNWNASIGOUKEITENKANTEIKIS)
    public Long getZrnwnasigoukeitenkanteikis() {
        return zrnwnasigoukeitenkanteikis;
    }

    public void setZrnwnasigoukeitenkanteikis(Long pZrnwnasigoukeitenkanteikis) {
        zrnwnasigoukeitenkanteikis = pZrnwnasigoukeitenkanteikis;
    }

    private String zrntnknteikikousinmnryouage;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTNKNTEIKIKOUSINMNRYOUAGE)
    public String getZrntnknteikikousinmnryouage() {
        return zrntnknteikikousinmnryouage;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrntnknteikikousinmnryouage(String pZrntnknteikikousinmnryouage) {
        zrntnknteikikousinmnryouage = pZrntnknteikikousinmnryouage;
    }

    private String zrnyobiv5;

    @Column(name=GenZT_IdouMeisaiRn.ZRNYOBIV5)
    public String getZrnyobiv5() {
        return zrnyobiv5;
    }

    public void setZrnyobiv5(String pZrnyobiv5) {
        zrnyobiv5 = pZrnyobiv5;
    }

    private String zrnkanyujidatakanrino;

    @Column(name=GenZT_IdouMeisaiRn.ZRNKANYUJIDATAKANRINO)
    public String getZrnkanyujidatakanrino() {
        return zrnkanyujidatakanrino;
    }

    @Padding(mode = "left", padChar = '0', length = 11)
    public void setZrnkanyujidatakanrino(String pZrnkanyujidatakanrino) {
        zrnkanyujidatakanrino = pZrnkanyujidatakanrino;
    }

    private String zrnkanyujikykymd;

    @Column(name=GenZT_IdouMeisaiRn.ZRNKANYUJIKYKYMD)
    public String getZrnkanyujikykymd() {
        return zrnkanyujikykymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnkanyujikykymd(String pZrnkanyujikykymd) {
        zrnkanyujikykymd = pZrnkanyujikykymd;
    }

    private String zrnkanyuujihihokensyaage;

    @Column(name=GenZT_IdouMeisaiRn.ZRNKANYUUJIHIHOKENSYAAGE)
    public String getZrnkanyuujihihokensyaage() {
        return zrnkanyuujihihokensyaage;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkanyuujihihokensyaage(String pZrnkanyuujihihokensyaage) {
        zrnkanyuujihihokensyaage = pZrnkanyuujihihokensyaage;
    }

    private String zrnkanyuujitenkanhyouji;

    @Column(name=GenZT_IdouMeisaiRn.ZRNKANYUUJITENKANHYOUJI)
    public String getZrnkanyuujitenkanhyouji() {
        return zrnkanyuujitenkanhyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkanyuujitenkanhyouji(String pZrnkanyuujitenkanhyouji) {
        zrnkanyuujitenkanhyouji = pZrnkanyuujitenkanhyouji;
    }

    private String zrnhsyuikktminaosikaisu;

    @Column(name=GenZT_IdouMeisaiRn.ZRNHSYUIKKTMINAOSIKAISU)
    public String getZrnhsyuikktminaosikaisu() {
        return zrnhsyuikktminaosikaisu;
    }

    public void setZrnhsyuikktminaosikaisu(String pZrnhsyuikktminaosikaisu) {
        zrnhsyuikktminaosikaisu = pZrnhsyuikktminaosikaisu;
    }

    private BizNumber zrnsknnjynbknsisnrt;

    @Type(type="BizNumberType")
    @Column(name=GenZT_IdouMeisaiRn.ZRNSKNNJYNBKNSISNRT)
    public BizNumber getZrnsknnjynbknsisnrt() {
        return zrnsknnjynbknsisnrt;
    }

    public void setZrnsknnjynbknsisnrt(BizNumber pZrnsknnjynbknsisnrt) {
        zrnsknnjynbknsisnrt = pZrnsknnjynbknsisnrt;
    }

    private String zrntkjykbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTKJYKBN)
    public String getZrntkjykbn() {
        return zrntkjykbn;
    }

    public void setZrntkjykbn(String pZrntkjykbn) {
        zrntkjykbn = pZrntkjykbn;
    }

    private String zrnsakugenkikan;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSAKUGENKIKAN)
    public String getZrnsakugenkikan() {
        return zrnsakugenkikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsakugenkikan(String pZrnsakugenkikan) {
        zrnsakugenkikan = pZrnsakugenkikan;
    }

    private Integer zrnryoumasihyouten;

    @Column(name=GenZT_IdouMeisaiRn.ZRNRYOUMASIHYOUTEN)
    public Integer getZrnryoumasihyouten() {
        return zrnryoumasihyouten;
    }

    public void setZrnryoumasihyouten(Integer pZrnryoumasihyouten) {
        zrnryoumasihyouten = pZrnryoumasihyouten;
    }

    private String zrnsykyktkjyuryumsratehyj;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSYKYKTKJYURYUMSRATEHYJ)
    public String getZrnsykyktkjyuryumsratehyj() {
        return zrnsykyktkjyuryumsratehyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsykyktkjyuryumsratehyj(String pZrnsykyktkjyuryumsratehyj) {
        zrnsykyktkjyuryumsratehyj = pZrnsykyktkjyuryumsratehyj;
    }

    private BizNumber zrnsykyktkjyuryumsrate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_IdouMeisaiRn.ZRNSYKYKTKJYURYUMSRATE)
    public BizNumber getZrnsykyktkjyuryumsrate() {
        return zrnsykyktkjyuryumsrate;
    }

    public void setZrnsykyktkjyuryumsrate(BizNumber pZrnsykyktkjyuryumsrate) {
        zrnsykyktkjyuryumsrate = pZrnsykyktkjyuryumsrate;
    }

    private String zrndai2tokujyoukbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNDAI2TOKUJYOUKBN)
    public String getZrndai2tokujyoukbn() {
        return zrndai2tokujyoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndai2tokujyoukbn(String pZrndai2tokujyoukbn) {
        zrndai2tokujyoukbn = pZrndai2tokujyoukbn;
    }

    private String zrndai2sakugenkikan;

    @Column(name=GenZT_IdouMeisaiRn.ZRNDAI2SAKUGENKIKAN)
    public String getZrndai2sakugenkikan() {
        return zrndai2sakugenkikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndai2sakugenkikan(String pZrndai2sakugenkikan) {
        zrndai2sakugenkikan = pZrndai2sakugenkikan;
    }

    private Integer zrndai2ryoumasihyouten;

    @Column(name=GenZT_IdouMeisaiRn.ZRNDAI2RYOUMASIHYOUTEN)
    public Integer getZrndai2ryoumasihyouten() {
        return zrndai2ryoumasihyouten;
    }

    public void setZrndai2ryoumasihyouten(Integer pZrndai2ryoumasihyouten) {
        zrndai2ryoumasihyouten = pZrndai2ryoumasihyouten;
    }

    private String zrntokuteibuijyoukenhyouji;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTOKUTEIBUIJYOUKENHYOUJI)
    public String getZrntokuteibuijyoukenhyouji() {
        return zrntokuteibuijyoukenhyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntokuteibuijyoukenhyouji(String pZrntokuteibuijyoukenhyouji) {
        zrntokuteibuijyoukenhyouji = pZrntokuteibuijyoukenhyouji;
    }

    private String zrntokuteibuino1;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTOKUTEIBUINO1)
    public String getZrntokuteibuino1() {
        return zrntokuteibuino1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrntokuteibuino1(String pZrntokuteibuino1) {
        zrntokuteibuino1 = pZrntokuteibuino1;
    }

    private String zrnhtnpkkn1;

    @Column(name=GenZT_IdouMeisaiRn.ZRNHTNPKKN1)
    public String getZrnhtnpkkn1() {
        return zrnhtnpkkn1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhtnpkkn1(String pZrnhtnpkkn1) {
        zrnhtnpkkn1 = pZrnhtnpkkn1;
    }

    private String zrntokuteibuino2;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTOKUTEIBUINO2)
    public String getZrntokuteibuino2() {
        return zrntokuteibuino2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrntokuteibuino2(String pZrntokuteibuino2) {
        zrntokuteibuino2 = pZrntokuteibuino2;
    }

    private String zrnhtnpkkn2;

    @Column(name=GenZT_IdouMeisaiRn.ZRNHTNPKKN2)
    public String getZrnhtnpkkn2() {
        return zrnhtnpkkn2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhtnpkkn2(String pZrnhtnpkkn2) {
        zrnhtnpkkn2 = pZrnhtnpkkn2;
    }

    private String zrnmhituiryuyutktbijyknhyj;

    @Column(name=GenZT_IdouMeisaiRn.ZRNMHITUIRYUYUTKTBIJYKNHYJ)
    public String getZrnmhituiryuyutktbijyknhyj() {
        return zrnmhituiryuyutktbijyknhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnmhituiryuyutktbijyknhyj(String pZrnmhituiryuyutktbijyknhyj) {
        zrnmhituiryuyutktbijyknhyj = pZrnmhituiryuyutktbijyknhyj;
    }

    private String zrnmuhaitouiryouyoutktbino1;

    @Column(name=GenZT_IdouMeisaiRn.ZRNMUHAITOUIRYOUYOUTKTBINO1)
    public String getZrnmuhaitouiryouyoutktbino1() {
        return zrnmuhaitouiryouyoutktbino1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnmuhaitouiryouyoutktbino1(String pZrnmuhaitouiryouyoutktbino1) {
        zrnmuhaitouiryouyoutktbino1 = pZrnmuhaitouiryouyoutktbino1;
    }

    private String zrnmuhaitouiryouyouhtnpkkn1;

    @Column(name=GenZT_IdouMeisaiRn.ZRNMUHAITOUIRYOUYOUHTNPKKN1)
    public String getZrnmuhaitouiryouyouhtnpkkn1() {
        return zrnmuhaitouiryouyouhtnpkkn1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnmuhaitouiryouyouhtnpkkn1(String pZrnmuhaitouiryouyouhtnpkkn1) {
        zrnmuhaitouiryouyouhtnpkkn1 = pZrnmuhaitouiryouyouhtnpkkn1;
    }

    private String zrnmuhaitouiryouyoutktbino2;

    @Column(name=GenZT_IdouMeisaiRn.ZRNMUHAITOUIRYOUYOUTKTBINO2)
    public String getZrnmuhaitouiryouyoutktbino2() {
        return zrnmuhaitouiryouyoutktbino2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnmuhaitouiryouyoutktbino2(String pZrnmuhaitouiryouyoutktbino2) {
        zrnmuhaitouiryouyoutktbino2 = pZrnmuhaitouiryouyoutktbino2;
    }

    private String zrnmuhaitouiryouyouhtnpkkn2;

    @Column(name=GenZT_IdouMeisaiRn.ZRNMUHAITOUIRYOUYOUHTNPKKN2)
    public String getZrnmuhaitouiryouyouhtnpkkn2() {
        return zrnmuhaitouiryouyouhtnpkkn2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnmuhaitouiryouyouhtnpkkn2(String pZrnmuhaitouiryouyouhtnpkkn2) {
        zrnmuhaitouiryouyouhtnpkkn2 = pZrnmuhaitouiryouyouhtnpkkn2;
    }

    private String zrnsiteizukipwarimasihyouji;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSITEIZUKIPWARIMASIHYOUJI)
    public String getZrnsiteizukipwarimasihyouji() {
        return zrnsiteizukipwarimasihyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsiteizukipwarimasihyouji(String pZrnsiteizukipwarimasihyouji) {
        zrnsiteizukipwarimasihyouji = pZrnsiteizukipwarimasihyouji;
    }

    private String zrnpwarimasisiteim1;

    @Column(name=GenZT_IdouMeisaiRn.ZRNPWARIMASISITEIM1)
    public String getZrnpwarimasisiteim1() {
        return zrnpwarimasisiteim1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnpwarimasisiteim1(String pZrnpwarimasisiteim1) {
        zrnpwarimasisiteim1 = pZrnpwarimasisiteim1;
    }

    private String zrnpwarimasisiteim2;

    @Column(name=GenZT_IdouMeisaiRn.ZRNPWARIMASISITEIM2)
    public String getZrnpwarimasisiteim2() {
        return zrnpwarimasisiteim2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnpwarimasisiteim2(String pZrnpwarimasisiteim2) {
        zrnpwarimasisiteim2 = pZrnpwarimasisiteim2;
    }

    private String zrnsiteimsykykpbairitu;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSITEIMSYKYKPBAIRITU)
    public String getZrnsiteimsykykpbairitu() {
        return zrnsiteimsykykpbairitu;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsiteimsykykpbairitu(String pZrnsiteimsykykpbairitu) {
        zrnsiteimsykykpbairitu = pZrnsiteimsykykpbairitu;
    }

    private String zrnsaisyuusiteiym;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSAISYUUSITEIYM)
    public String getZrnsaisyuusiteiym() {
        return zrnsaisyuusiteiym;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrnsaisyuusiteiym(String pZrnsaisyuusiteiym) {
        zrnsaisyuusiteiym = pZrnsaisyuusiteiym;
    }

    private String zrnsykykkitmttvkeisanym;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSYKYKKITMTTVKEISANYM)
    public String getZrnsykykkitmttvkeisanym() {
        return zrnsykykkitmttvkeisanym;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrnsykykkitmttvkeisanym(String pZrnsykykkitmttvkeisanym) {
        zrnsykykkitmttvkeisanym = pZrnsykykkitmttvkeisanym;
    }

    private Long zrnsykykkitmttsknnjynbkngk;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSYKYKKITMTTSKNNJYNBKNGK)
    public Long getZrnsykykkitmttsknnjynbkngk() {
        return zrnsykykkitmttsknnjynbkngk;
    }

    public void setZrnsykykkitmttsknnjynbkngk(Long pZrnsykykkitmttsknnjynbkngk) {
        zrnsykykkitmttsknnjynbkngk = pZrnsykykkitmttsknnjynbkngk;
    }

    private Long zrndftumitatekingaku;

    @Column(name=GenZT_IdouMeisaiRn.ZRNDFTUMITATEKINGAKU)
    public Long getZrndftumitatekingaku() {
        return zrndftumitatekingaku;
    }

    public void setZrndftumitatekingaku(Long pZrndftumitatekingaku) {
        zrndftumitatekingaku = pZrndftumitatekingaku;
    }

    private Long zrndftumimasikin;

    @Column(name=GenZT_IdouMeisaiRn.ZRNDFTUMIMASIKIN)
    public Long getZrndftumimasikin() {
        return zrndftumimasikin;
    }

    public void setZrndftumimasikin(Long pZrndftumimasikin) {
        zrndftumimasikin = pZrndftumimasikin;
    }

    private Long zrnvbubundftenkankakaku;

    @Column(name=GenZT_IdouMeisaiRn.ZRNVBUBUNDFTENKANKAKAKU)
    public Long getZrnvbubundftenkankakaku() {
        return zrnvbubundftenkankakaku;
    }

    public void setZrnvbubundftenkankakaku(Long pZrnvbubundftenkankakaku) {
        zrnvbubundftenkankakaku = pZrnvbubundftenkankakaku;
    }

    private Long zrndpbubundftenkankakaku;

    @Column(name=GenZT_IdouMeisaiRn.ZRNDPBUBUNDFTENKANKAKAKU)
    public Long getZrndpbubundftenkankakaku() {
        return zrndpbubundftenkankakaku;
    }

    public void setZrndpbubundftenkankakaku(Long pZrndpbubundftenkankakaku) {
        zrndpbubundftenkankakaku = pZrndpbubundftenkankakaku;
    }

    private Long zrndftmttkngkitjbrbbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNDFTMTTKNGKITJBRBBN)
    public Long getZrndftmttkngkitjbrbbn() {
        return zrndftmttkngkitjbrbbn;
    }

    public void setZrndftmttkngkitjbrbbn(Long pZrndftmttkngkitjbrbbn) {
        zrndftmttkngkitjbrbbn = pZrndftmttkngkitjbrbbn;
    }

    private Long zrnhendous;

    @Column(name=GenZT_IdouMeisaiRn.ZRNHENDOUS)
    public Long getZrnhendous() {
        return zrnhendous;
    }

    public void setZrnhendous(Long pZrnhendous) {
        zrnhendous = pZrnhendous;
    }

    private Long zrnhengakujigyounendomatucv;

    @Column(name=GenZT_IdouMeisaiRn.ZRNHENGAKUJIGYOUNENDOMATUCV)
    public Long getZrnhengakujigyounendomatucv() {
        return zrnhengakujigyounendomatucv;
    }

    public void setZrnhengakujigyounendomatucv(Long pZrnhengakujigyounendomatucv) {
        zrnhengakujigyounendomatucv = pZrnhengakujigyounendomatucv;
    }

    private Long zrnitibuitijibarais;

    @Column(name=GenZT_IdouMeisaiRn.ZRNITIBUITIJIBARAIS)
    public Long getZrnitibuitijibarais() {
        return zrnitibuitijibarais;
    }

    public void setZrnitibuitijibarais(Long pZrnitibuitijibarais) {
        zrnitibuitijibarais = pZrnitibuitijibarais;
    }

    private Long zrnitibuitijibaraip;

    @Column(name=GenZT_IdouMeisaiRn.ZRNITIBUITIJIBARAIP)
    public Long getZrnitibuitijibaraip() {
        return zrnitibuitijibaraip;
    }

    public void setZrnitibuitijibaraip(Long pZrnitibuitijibaraip) {
        zrnitibuitijibaraip = pZrnitibuitijibaraip;
    }

    private Long zrnitibitjbrshrkngk;

    @Column(name=GenZT_IdouMeisaiRn.ZRNITIBITJBRSHRKNGK)
    public Long getZrnitibitjbrshrkngk() {
        return zrnitibitjbrshrkngk;
    }

    public void setZrnitibitjbrshrkngk(Long pZrnitibitjbrshrkngk) {
        zrnitibitjbrshrkngk = pZrnitibitjbrshrkngk;
    }

    private Long zrngoukeicv;

    @Column(name=GenZT_IdouMeisaiRn.ZRNGOUKEICV)
    public Long getZrngoukeicv() {
        return zrngoukeicv;
    }

    public void setZrngoukeicv(Long pZrngoukeicv) {
        zrngoukeicv = pZrngoukeicv;
    }

    private Long zrnminasicv;

    @Column(name=GenZT_IdouMeisaiRn.ZRNMINASICV)
    public Long getZrnminasicv() {
        return zrnminasicv;
    }

    public void setZrnminasicv(Long pZrnminasicv) {
        zrnminasicv = pZrnminasicv;
    }

    private Long zrnloanfund;

    @Column(name=GenZT_IdouMeisaiRn.ZRNLOANFUND)
    public Long getZrnloanfund() {
        return zrnloanfund;
    }

    public void setZrnloanfund(Long pZrnloanfund) {
        zrnloanfund = pZrnloanfund;
    }

    private Long zrnsaiteihosyougaku;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSAITEIHOSYOUGAKU)
    public Long getZrnsaiteihosyougaku() {
        return zrnsaiteihosyougaku;
    }

    public void setZrnsaiteihosyougaku(Long pZrnsaiteihosyougaku) {
        zrnsaiteihosyougaku = pZrnsaiteihosyougaku;
    }

    private Long zrnhngksitihsyuyusykykp;

    @Column(name=GenZT_IdouMeisaiRn.ZRNHNGKSITIHSYUYUSYKYKP)
    public Long getZrnhngksitihsyuyusykykp() {
        return zrnhngksitihsyuyusykykp;
    }

    public void setZrnhngksitihsyuyusykykp(Long pZrnhngksitihsyuyusykykp) {
        zrnhngksitihsyuyusykykp = pZrnhngksitihsyuyusykykp;
    }

    private Long zrnhijynbrivasbujsitihsyugk;

    @Column(name=GenZT_IdouMeisaiRn.ZRNHIJYNBRIVASBUJSITIHSYUGK)
    public Long getZrnhijynbrivasbujsitihsyugk() {
        return zrnhijynbrivasbujsitihsyugk;
    }

    public void setZrnhijynbrivasbujsitihsyugk(Long pZrnhijynbrivasbujsitihsyugk) {
        zrnhijynbrivasbujsitihsyugk = pZrnhijynbrivasbujsitihsyugk;
    }

    private Long zrnhijynbrivamnkjsitihsyugk;

    @Column(name=GenZT_IdouMeisaiRn.ZRNHIJYNBRIVAMNKJSITIHSYUGK)
    public Long getZrnhijynbrivamnkjsitihsyugk() {
        return zrnhijynbrivamnkjsitihsyugk;
    }

    public void setZrnhijynbrivamnkjsitihsyugk(Long pZrnhijynbrivamnkjsitihsyugk) {
        zrnhijynbrivamnkjsitihsyugk = pZrnhijynbrivamnkjsitihsyugk;
    }

    private String zrnsiinkbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSIINKBN)
    public String getZrnsiinkbn() {
        return zrnsiinkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsiinkbn(String pZrnsiinkbn) {
        zrnsiinkbn = pZrnsiinkbn;
    }

    private Long zrnmudkaimasikihons;

    @Column(name=GenZT_IdouMeisaiRn.ZRNMUDKAIMASIKIHONS)
    public Long getZrnmudkaimasikihons() {
        return zrnmudkaimasikihons;
    }

    public void setZrnmudkaimasikihons(Long pZrnmudkaimasikihons) {
        zrnmudkaimasikihons = pZrnmudkaimasikihons;
    }

    private String zrnkaimasiymd;

    @Column(name=GenZT_IdouMeisaiRn.ZRNKAIMASIYMD)
    public String getZrnkaimasiymd() {
        return zrnkaimasiymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnkaimasiymd(String pZrnkaimasiymd) {
        zrnkaimasiymd = pZrnkaimasiymd;
    }

    private String zrnkaimasikikan;

    @Column(name=GenZT_IdouMeisaiRn.ZRNKAIMASIKIKAN)
    public String getZrnkaimasikikan() {
        return zrnkaimasikikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkaimasikikan(String pZrnkaimasikikan) {
        zrnkaimasikikan = pZrnkaimasikikan;
    }

    private Long zrnhikitugikaimasis;

    @Column(name=GenZT_IdouMeisaiRn.ZRNHIKITUGIKAIMASIS)
    public Long getZrnhikitugikaimasis() {
        return zrnhikitugikaimasis;
    }

    public void setZrnhikitugikaimasis(Long pZrnhikitugikaimasis) {
        zrnhikitugikaimasis = pZrnhikitugikaimasis;
    }

    private Long zrnmudkaimasisiharaikingaku;

    @Column(name=GenZT_IdouMeisaiRn.ZRNMUDKAIMASISIHARAIKINGAKU)
    public Long getZrnmudkaimasisiharaikingaku() {
        return zrnmudkaimasisiharaikingaku;
    }

    public void setZrnmudkaimasisiharaikingaku(Long pZrnmudkaimasisiharaikingaku) {
        zrnmudkaimasisiharaikingaku = pZrnmudkaimasisiharaikingaku;
    }

    private String zrnszoukouryokukaisiymdx1;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSZOUKOURYOKUKAISIYMDX1)
    public String getZrnszoukouryokukaisiymdx1() {
        return zrnszoukouryokukaisiymdx1;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnszoukouryokukaisiymdx1(String pZrnszoukouryokukaisiymdx1) {
        zrnszoukouryokukaisiymdx1 = pZrnszoukouryokukaisiymdx1;
    }

    private String zrnszouhokensyuruikigoux1;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSZOUHOKENSYURUIKIGOUX1)
    public String getZrnszouhokensyuruikigoux1() {
        return zrnszouhokensyuruikigoux1;
    }

    public void setZrnszouhokensyuruikigoux1(String pZrnszouhokensyuruikigoux1) {
        zrnszouhokensyuruikigoux1 = pZrnszouhokensyuruikigoux1;
    }

    private String zrnszoukigousedaikbnx1;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSZOUKIGOUSEDAIKBNX1)
    public String getZrnszoukigousedaikbnx1() {
        return zrnszoukigousedaikbnx1;
    }

    public void setZrnszoukigousedaikbnx1(String pZrnszoukigousedaikbnx1) {
        zrnszoukigousedaikbnx1 = pZrnszoukigousedaikbnx1;
    }

    private String zrnszoukikanx1;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSZOUKIKANX1)
    public String getZrnszoukikanx1() {
        return zrnszoukikanx1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnszoukikanx1(String pZrnszoukikanx1) {
        zrnszoukikanx1 = pZrnszoukikanx1;
    }

    private String zrnszouhihokensyaagex1;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSZOUHIHOKENSYAAGEX1)
    public String getZrnszouhihokensyaagex1() {
        return zrnszouhihokensyaagex1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnszouhihokensyaagex1(String pZrnszouhihokensyaagex1) {
        zrnszouhihokensyaagex1 = pZrnszouhihokensyaagex1;
    }

    private String zrnszoudai2hihknsyaagex1;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSZOUDAI2HIHKNSYAAGEX1)
    public String getZrnszoudai2hihknsyaagex1() {
        return zrnszoudai2hihknsyaagex1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnszoudai2hihknsyaagex1(String pZrnszoudai2hihknsyaagex1) {
        zrnszoudai2hihknsyaagex1 = pZrnszoudai2hihknsyaagex1;
    }

    private Long zrnzoukasx1;

    @Column(name=GenZT_IdouMeisaiRn.ZRNZOUKASX1)
    public Long getZrnzoukasx1() {
        return zrnzoukasx1;
    }

    public void setZrnzoukasx1(Long pZrnzoukasx1) {
        zrnzoukasx1 = pZrnzoukasx1;
    }

    private Long zrnzennendozoukasx1;

    @Column(name=GenZT_IdouMeisaiRn.ZRNZENNENDOZOUKASX1)
    public Long getZrnzennendozoukasx1() {
        return zrnzennendozoukasx1;
    }

    public void setZrnzennendozoukasx1(Long pZrnzennendozoukasx1) {
        zrnzennendozoukasx1 = pZrnzennendozoukasx1;
    }

    private Long zrnszousiharaikingakux1;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSZOUSIHARAIKINGAKUX1)
    public Long getZrnszousiharaikingakux1() {
        return zrnszousiharaikingakux1;
    }

    public void setZrnszousiharaikingakux1(Long pZrnszousiharaikingakux1) {
        zrnszousiharaikingakux1 = pZrnszousiharaikingakux1;
    }

    private String zrnszoukouryokukaisiymdx2;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSZOUKOURYOKUKAISIYMDX2)
    public String getZrnszoukouryokukaisiymdx2() {
        return zrnszoukouryokukaisiymdx2;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnszoukouryokukaisiymdx2(String pZrnszoukouryokukaisiymdx2) {
        zrnszoukouryokukaisiymdx2 = pZrnszoukouryokukaisiymdx2;
    }

    private String zrnszouhokensyuruikigoux2;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSZOUHOKENSYURUIKIGOUX2)
    public String getZrnszouhokensyuruikigoux2() {
        return zrnszouhokensyuruikigoux2;
    }

    public void setZrnszouhokensyuruikigoux2(String pZrnszouhokensyuruikigoux2) {
        zrnszouhokensyuruikigoux2 = pZrnszouhokensyuruikigoux2;
    }

    private String zrnszoukigousedaikbnx2;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSZOUKIGOUSEDAIKBNX2)
    public String getZrnszoukigousedaikbnx2() {
        return zrnszoukigousedaikbnx2;
    }

    public void setZrnszoukigousedaikbnx2(String pZrnszoukigousedaikbnx2) {
        zrnszoukigousedaikbnx2 = pZrnszoukigousedaikbnx2;
    }

    private String zrnszoukikanx2;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSZOUKIKANX2)
    public String getZrnszoukikanx2() {
        return zrnszoukikanx2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnszoukikanx2(String pZrnszoukikanx2) {
        zrnszoukikanx2 = pZrnszoukikanx2;
    }

    private String zrnszouhihokensyaagex2;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSZOUHIHOKENSYAAGEX2)
    public String getZrnszouhihokensyaagex2() {
        return zrnszouhihokensyaagex2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnszouhihokensyaagex2(String pZrnszouhihokensyaagex2) {
        zrnszouhihokensyaagex2 = pZrnszouhihokensyaagex2;
    }

    private String zrnszoudai2hihknsyaagex2;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSZOUDAI2HIHKNSYAAGEX2)
    public String getZrnszoudai2hihknsyaagex2() {
        return zrnszoudai2hihknsyaagex2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnszoudai2hihknsyaagex2(String pZrnszoudai2hihknsyaagex2) {
        zrnszoudai2hihknsyaagex2 = pZrnszoudai2hihknsyaagex2;
    }

    private Long zrnzoukasx2;

    @Column(name=GenZT_IdouMeisaiRn.ZRNZOUKASX2)
    public Long getZrnzoukasx2() {
        return zrnzoukasx2;
    }

    public void setZrnzoukasx2(Long pZrnzoukasx2) {
        zrnzoukasx2 = pZrnzoukasx2;
    }

    private Long zrnzennendozoukasx2;

    @Column(name=GenZT_IdouMeisaiRn.ZRNZENNENDOZOUKASX2)
    public Long getZrnzennendozoukasx2() {
        return zrnzennendozoukasx2;
    }

    public void setZrnzennendozoukasx2(Long pZrnzennendozoukasx2) {
        zrnzennendozoukasx2 = pZrnzennendozoukasx2;
    }

    private Long zrnszousiharaikingakux2;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSZOUSIHARAIKINGAKUX2)
    public Long getZrnszousiharaikingakux2() {
        return zrnszousiharaikingakux2;
    }

    public void setZrnszousiharaikingakux2(Long pZrnszousiharaikingakux2) {
        zrnszousiharaikingakux2 = pZrnszousiharaikingakux2;
    }

    private String zrnsuuriyouyobin1x5;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSUURIYOUYOBIN1X5)
    public String getZrnsuuriyouyobin1x5() {
        return zrnsuuriyouyobin1x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsuuriyouyobin1x5(String pZrnsuuriyouyobin1x5) {
        zrnsuuriyouyobin1x5 = pZrnsuuriyouyobin1x5;
    }

    private String zrnsuuriyouyobin1x6;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSUURIYOUYOBIN1X6)
    public String getZrnsuuriyouyobin1x6() {
        return zrnsuuriyouyobin1x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsuuriyouyobin1x6(String pZrnsuuriyouyobin1x6) {
        zrnsuuriyouyobin1x6 = pZrnsuuriyouyobin1x6;
    }

    private String zrnhrimngkizktkykpmenhyj;

    @Column(name=GenZT_IdouMeisaiRn.ZRNHRIMNGKIZKTKYKPMENHYJ)
    public String getZrnhrimngkizktkykpmenhyj() {
        return zrnhrimngkizktkykpmenhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhrimngkizktkykpmenhyj(String pZrnhrimngkizktkykpmenhyj) {
        zrnhrimngkizktkykpmenhyj = pZrnhrimngkizktkykpmenhyj;
    }

    private String zrnmisyuustartym;

    @Column(name=GenZT_IdouMeisaiRn.ZRNMISYUUSTARTYM)
    public String getZrnmisyuustartym() {
        return zrnmisyuustartym;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrnmisyuustartym(String pZrnmisyuustartym) {
        zrnmisyuustartym = pZrnmisyuustartym;
    }

    private String zrnmisyuukaisuu;

    @Column(name=GenZT_IdouMeisaiRn.ZRNMISYUUKAISUU)
    public String getZrnmisyuukaisuu() {
        return zrnmisyuukaisuu;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnmisyuukaisuu(String pZrnmisyuukaisuu) {
        zrnmisyuukaisuu = pZrnmisyuukaisuu;
    }

    private String zrnitjbrtkykkousnuktkarhyj;

    @Column(name=GenZT_IdouMeisaiRn.ZRNITJBRTKYKKOUSNUKTKARHYJ)
    public String getZrnitjbrtkykkousnuktkarhyj() {
        return zrnitjbrtkykkousnuktkarhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnitjbrtkykkousnuktkarhyj(String pZrnitjbrtkykkousnuktkarhyj) {
        zrnitjbrtkykkousnuktkarhyj = pZrnitjbrtkykkousnuktkarhyj;
    }

    private Long zrngyousekihyoujis;

    @Column(name=GenZT_IdouMeisaiRn.ZRNGYOUSEKIHYOUJIS)
    public Long getZrngyousekihyoujis() {
        return zrngyousekihyoujis;
    }

    public void setZrngyousekihyoujis(Long pZrngyousekihyoujis) {
        zrngyousekihyoujis = pZrngyousekihyoujis;
    }

    private Long zrnsykykgyusekihyjs;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSYKYKGYUSEKIHYJS)
    public Long getZrnsykykgyusekihyjs() {
        return zrnsykykgyusekihyjs;
    }

    public void setZrnsykykgyusekihyjs(Long pZrnsykykgyusekihyjs) {
        zrnsykykgyusekihyjs = pZrnsykykgyusekihyjs;
    }

    private Long zrntenkangyousekihyoujis;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTENKANGYOUSEKIHYOUJIS)
    public Long getZrntenkangyousekihyoujis() {
        return zrntenkangyousekihyoujis;
    }

    public void setZrntenkangyousekihyoujis(Long pZrntenkangyousekihyoujis) {
        zrntenkangyousekihyoujis = pZrntenkangyousekihyoujis;
    }

    private Long zrntnknteikigyousekihyjs;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTNKNTEIKIGYOUSEKIHYJS)
    public Long getZrntnknteikigyousekihyjs() {
        return zrntnknteikigyousekihyjs;
    }

    public void setZrntnknteikigyousekihyjs(Long pZrntnknteikigyousekihyjs) {
        zrntnknteikigyousekihyjs = pZrntnknteikigyousekihyjs;
    }

    private Long zrntnkndpbbngyuskhyjs;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTNKNDPBBNGYUSKHYJS)
    public Long getZrntnkndpbbngyuskhyjs() {
        return zrntnkndpbbngyuskhyjs;
    }

    public void setZrntnkndpbbngyuskhyjs(Long pZrntnkndpbbngyuskhyjs) {
        zrntnkndpbbngyuskhyjs = pZrntnkndpbbngyuskhyjs;
    }

    private String zrnkykjyoutai;

    @Column(name=GenZT_IdouMeisaiRn.ZRNKYKJYOUTAI)
    public String getZrnkykjyoutai() {
        return zrnkykjyoutai;
    }

    public void setZrnkykjyoutai(String pZrnkykjyoutai) {
        zrnkykjyoutai = pZrnkykjyoutai;
    }

    private String zrnpmenhukakbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNPMENHUKAKBN)
    public String getZrnpmenhukakbn() {
        return zrnpmenhukakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnpmenhukakbn(String pZrnpmenhukakbn) {
        zrnpmenhukakbn = pZrnpmenhukakbn;
    }

    private String zrnkousinkbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNKOUSINKBN)
    public String getZrnkousinkbn() {
        return zrnkousinkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkousinkbn(String pZrnkousinkbn) {
        zrnkousinkbn = pZrnkousinkbn;
    }

    private String zrnmankiyoteikbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNMANKIYOTEIKBN)
    public String getZrnmankiyoteikbn() {
        return zrnmankiyoteikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnmankiyoteikbn(String pZrnmankiyoteikbn) {
        zrnmankiyoteikbn = pZrnmankiyoteikbn;
    }

    private String zrnsykyktikmnkyoteikbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSYKYKTIKMNKYOTEIKBN)
    public String getZrnsykyktikmnkyoteikbn() {
        return zrnsykyktikmnkyoteikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsykyktikmnkyoteikbn(String pZrnsykyktikmnkyoteikbn) {
        zrnsykyktikmnkyoteikbn = pZrnsykyktikmnkyoteikbn;
    }

    private String zrntnknsykykkhnmnkytikbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTNKNSYKYKKHNMNKYTIKBN)
    public String getZrntnknsykykkhnmnkytikbn() {
        return zrntnknsykykkhnmnkytikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntnknsykykkhnmnkytikbn(String pZrntnknsykykkhnmnkytikbn) {
        zrntnknsykykkhnmnkytikbn = pZrntnknsykykkhnmnkytikbn;
    }

    private String zrntnknsykyktikmnkytikbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTNKNSYKYKTIKMNKYTIKBN)
    public String getZrntnknsykyktikmnkytikbn() {
        return zrntnknsykyktikmnkytikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntnknsykyktikmnkytikbn(String pZrntnknsykyktikmnkytikbn) {
        zrntnknsykyktikmnkytikbn = pZrntnknsykyktikmnkytikbn;
    }

    private String zrntenkanteikimankiyoteikbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTENKANTEIKIMANKIYOTEIKBN)
    public String getZrntenkanteikimankiyoteikbn() {
        return zrntenkanteikimankiyoteikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntenkanteikimankiyoteikbn(String pZrntenkanteikimankiyoteikbn) {
        zrntenkanteikimankiyoteikbn = pZrntenkanteikimankiyoteikbn;
    }

    private String zrnszoumankiyoteikbnx1;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSZOUMANKIYOTEIKBNX1)
    public String getZrnszoumankiyoteikbnx1() {
        return zrnszoumankiyoteikbnx1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnszoumankiyoteikbnx1(String pZrnszoumankiyoteikbnx1) {
        zrnszoumankiyoteikbnx1 = pZrnszoumankiyoteikbnx1;
    }

    private String zrnszoumankiyoteikbnx2;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSZOUMANKIYOTEIKBNX2)
    public String getZrnszoumankiyoteikbnx2() {
        return zrnszoumankiyoteikbnx2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnszoumankiyoteikbnx2(String pZrnszoumankiyoteikbnx2) {
        zrnszoumankiyoteikbnx2 = pZrnszoumankiyoteikbnx2;
    }

    private String zrnvestingmankiyoteikbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNVESTINGMANKIYOTEIKBN)
    public String getZrnvestingmankiyoteikbn() {
        return zrnvestingmankiyoteikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnvestingmankiyoteikbn(String pZrnvestingmankiyoteikbn) {
        zrnvestingmankiyoteikbn = pZrnvestingmankiyoteikbn;
    }

    private String zrnvkeisanhyouji;

    @Column(name=GenZT_IdouMeisaiRn.ZRNVKEISANHYOUJI)
    public String getZrnvkeisanhyouji() {
        return zrnvkeisanhyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnvkeisanhyouji(String pZrnvkeisanhyouji) {
        zrnvkeisanhyouji = pZrnvkeisanhyouji;
    }

    private String zrntoukisinkeiyakuhyouji;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTOUKISINKEIYAKUHYOUJI)
    public String getZrntoukisinkeiyakuhyouji() {
        return zrntoukisinkeiyakuhyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntoukisinkeiyakuhyouji(String pZrntoukisinkeiyakuhyouji) {
        zrntoukisinkeiyakuhyouji = pZrntoukisinkeiyakuhyouji;
    }

    private String zrnsykykhokenhoutekiyouhyj;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSYKYKHOKENHOUTEKIYOUHYJ)
    public String getZrnsykykhokenhoutekiyouhyj() {
        return zrnsykykhokenhoutekiyouhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsykykhokenhoutekiyouhyj(String pZrnsykykhokenhoutekiyouhyj) {
        zrnsykykhokenhoutekiyouhyj = pZrnsykykhokenhoutekiyouhyj;
    }

    private String zrntokuteijyoutaihushrhyj;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTOKUTEIJYOUTAIHUSHRHYJ)
    public String getZrntokuteijyoutaihushrhyj() {
        return zrntokuteijyoutaihushrhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntokuteijyoutaihushrhyj(String pZrntokuteijyoutaihushrhyj) {
        zrntokuteijyoutaihushrhyj = pZrntokuteijyoutaihushrhyj;
    }

    private String zrnytirrthndsysnmnskaisuu;

    @Column(name=GenZT_IdouMeisaiRn.ZRNYTIRRTHNDSYSNMNSKAISUU)
    public String getZrnytirrthndsysnmnskaisuu() {
        return zrnytirrthndsysnmnskaisuu;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnytirrthndsysnmnskaisuu(String pZrnytirrthndsysnmnskaisuu) {
        zrnytirrthndsysnmnskaisuu = pZrnytirrthndsysnmnskaisuu;
    }

    private String zrnsuuriyouyobin3;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSUURIYOUYOBIN3)
    public String getZrnsuuriyouyobin3() {
        return zrnsuuriyouyobin3;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrnsuuriyouyobin3(String pZrnsuuriyouyobin3) {
        zrnsuuriyouyobin3 = pZrnsuuriyouyobin3;
    }

    private String zrnsuuriyouyobin11;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSUURIYOUYOBIN11)
    public String getZrnsuuriyouyobin11() {
        return zrnsuuriyouyobin11;
    }

    @Padding(mode = "left", padChar = '0', length = 11)
    public void setZrnsuuriyouyobin11(String pZrnsuuriyouyobin11) {
        zrnsuuriyouyobin11 = pZrnsuuriyouyobin11;
    }

    private Long zrnwnasigoukeitenkankakaku;

    @Column(name=GenZT_IdouMeisaiRn.ZRNWNASIGOUKEITENKANKAKAKU)
    public Long getZrnwnasigoukeitenkankakaku() {
        return zrnwnasigoukeitenkankakaku;
    }

    public void setZrnwnasigoukeitenkankakaku(Long pZrnwnasigoukeitenkankakaku) {
        zrnwnasigoukeitenkankakaku = pZrnwnasigoukeitenkankakaku;
    }

    private Long zrnyobin11;

    @Column(name=GenZT_IdouMeisaiRn.ZRNYOBIN11)
    public Long getZrnyobin11() {
        return zrnyobin11;
    }

    public void setZrnyobin11(Long pZrnyobin11) {
        zrnyobin11 = pZrnyobin11;
    }

    private Long zrnyobin11x2;

    @Column(name=GenZT_IdouMeisaiRn.ZRNYOBIN11X2)
    public Long getZrnyobin11x2() {
        return zrnyobin11x2;
    }

    public void setZrnyobin11x2(Long pZrnyobin11x2) {
        zrnyobin11x2 = pZrnyobin11x2;
    }

    private Long zrnyobin11x3;

    @Column(name=GenZT_IdouMeisaiRn.ZRNYOBIN11X3)
    public Long getZrnyobin11x3() {
        return zrnyobin11x3;
    }

    public void setZrnyobin11x3(Long pZrnyobin11x3) {
        zrnyobin11x3 = pZrnyobin11x3;
    }

    private Long zrntukibaraikansantokujyoup;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTUKIBARAIKANSANTOKUJYOUP)
    public Long getZrntukibaraikansantokujyoup() {
        return zrntukibaraikansantokujyoup;
    }

    public void setZrntukibaraikansantokujyoup(Long pZrntukibaraikansantokujyoup) {
        zrntukibaraikansantokujyoup = pZrntukibaraikansantokujyoup;
    }

    private String zrntnkngkykkssnkijyuym;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTNKNGKYKKSSNKIJYUYM)
    public String getZrntnkngkykkssnkijyuym() {
        return zrntnkngkykkssnkijyuym;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrntnkngkykkssnkijyuym(String pZrntnkngkykkssnkijyuym) {
        zrntnkngkykkssnkijyuym = pZrntnkngkykkssnkijyuym;
    }

    private String zrnsaiteihosyouhyouji;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSAITEIHOSYOUHYOUJI)
    public String getZrnsaiteihosyouhyouji() {
        return zrnsaiteihosyouhyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsaiteihosyouhyouji(String pZrnsaiteihosyouhyouji) {
        zrnsaiteihosyouhyouji = pZrnsaiteihosyouhyouji;
    }

    private String zrnsuuriyouyobin8x2;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSUURIYOUYOBIN8X2)
    public String getZrnsuuriyouyobin8x2() {
        return zrnsuuriyouyobin8x2;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnsuuriyouyobin8x2(String pZrnsuuriyouyobin8x2) {
        zrnsuuriyouyobin8x2 = pZrnsuuriyouyobin8x2;
    }

    private String zrnsuuriyouyobin14;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSUURIYOUYOBIN14)
    public String getZrnsuuriyouyobin14() {
        return zrnsuuriyouyobin14;
    }

    @Padding(mode = "left", padChar = '0', length = 14)
    public void setZrnsuuriyouyobin14(String pZrnsuuriyouyobin14) {
        zrnsuuriyouyobin14 = pZrnsuuriyouyobin14;
    }

    private String zrnhrimngtkykphrkkaisuukbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNHRIMNGTKYKPHRKKAISUUKBN)
    public String getZrnhrimngtkykphrkkaisuukbn() {
        return zrnhrimngtkykphrkkaisuukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhrimngtkykphrkkaisuukbn(String pZrnhrimngtkykphrkkaisuukbn) {
        zrnhrimngtkykphrkkaisuukbn = pZrnhrimngtkykphrkkaisuukbn;
    }

    private String zrnhrimngtkykphrkkirkbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNHRIMNGTKYKPHRKKIRKBN)
    public String getZrnhrimngtkykphrkkirkbn() {
        return zrnhrimngtkykphrkkirkbn;
    }

    public void setZrnhrimngtkykphrkkirkbn(String pZrnhrimngtkykphrkkirkbn) {
        zrnhrimngtkykphrkkirkbn = pZrnhrimngtkykphrkkirkbn;
    }

    private String zrnhrimngtkykpryurtkbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNHRIMNGTKYKPRYURTKBN)
    public String getZrnhrimngtkykpryurtkbn() {
        return zrnhrimngtkykpryurtkbn;
    }

    public void setZrnhrimngtkykpryurtkbn(String pZrnhrimngtkykpryurtkbn) {
        zrnhrimngtkykpryurtkbn = pZrnhrimngtkykpryurtkbn;
    }

    private String zrnyobiv13;

    @Column(name=GenZT_IdouMeisaiRn.ZRNYOBIV13)
    public String getZrnyobiv13() {
        return zrnyobiv13;
    }

    public void setZrnyobiv13(String pZrnyobiv13) {
        zrnyobiv13 = pZrnyobiv13;
    }

    private Long zrnidoujisaiteihosyoukngk;

    @Column(name=GenZT_IdouMeisaiRn.ZRNIDOUJISAITEIHOSYOUKNGK)
    public Long getZrnidoujisaiteihosyoukngk() {
        return zrnidoujisaiteihosyoukngk;
    }

    public void setZrnidoujisaiteihosyoukngk(Long pZrnidoujisaiteihosyoukngk) {
        zrnidoujisaiteihosyoukngk = pZrnidoujisaiteihosyoukngk;
    }

    private Long zrnidoujisaiteihosyoucost;

    @Column(name=GenZT_IdouMeisaiRn.ZRNIDOUJISAITEIHOSYOUCOST)
    public Long getZrnidoujisaiteihosyoucost() {
        return zrnidoujisaiteihosyoucost;
    }

    public void setZrnidoujisaiteihosyoucost(Long pZrnidoujisaiteihosyoucost) {
        zrnidoujisaiteihosyoucost = pZrnidoujisaiteihosyoucost;
    }

    private Long zrnsinhokenfundtumitatekin;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSINHOKENFUNDTUMITATEKIN)
    public Long getZrnsinhokenfundtumitatekin() {
        return zrnsinhokenfundtumitatekin;
    }

    public void setZrnsinhokenfundtumitatekin(Long pZrnsinhokenfundtumitatekin) {
        zrnsinhokenfundtumitatekin = pZrnsinhokenfundtumitatekin;
    }

    private Long zrnmsyuptusshkgkaiykhnrikn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNMSYUPTUSSHKGKAIYKHNRIKN)
    public Long getZrnmsyuptusshkgkaiykhnrikn() {
        return zrnmsyuptusshkgkaiykhnrikn;
    }

    public void setZrnmsyuptusshkgkaiykhnrikn(Long pZrnmsyuptusshkgkaiykhnrikn) {
        zrnmsyuptusshkgkaiykhnrikn = pZrnmsyuptusshkgkaiykhnrikn;
    }

    private Long zrnrrthndugtnkgetumatuv;

    @Column(name=GenZT_IdouMeisaiRn.ZRNRRTHNDUGTNKGETUMATUV)
    public Long getZrnrrthndugtnkgetumatuv() {
        return zrnrrthndugtnkgetumatuv;
    }

    public void setZrnrrthndugtnkgetumatuv(Long pZrnrrthndugtnkgetumatuv) {
        zrnrrthndugtnkgetumatuv = pZrnrrthndugtnkgetumatuv;
    }

    private Long zrnrrthndnksaiteihosyonkgns;

    @Column(name=GenZT_IdouMeisaiRn.ZRNRRTHNDNKSAITEIHOSYONKGNS)
    public Long getZrnrrthndnksaiteihosyonkgns() {
        return zrnrrthndnksaiteihosyonkgns;
    }

    public void setZrnrrthndnksaiteihosyonkgns(Long pZrnrrthndnksaiteihosyonkgns) {
        zrnrrthndnksaiteihosyonkgns = pZrnrrthndnksaiteihosyonkgns;
    }

    private Long zrnrrthendougatanksibous;

    @Column(name=GenZT_IdouMeisaiRn.ZRNRRTHENDOUGATANKSIBOUS)
    public Long getZrnrrthendougatanksibous() {
        return zrnrrthendougatanksibous;
    }

    public void setZrnrrthendougatanksibous(Long pZrnrrthendougatanksibous) {
        zrnrrthendougatanksibous = pZrnrrthendougatanksibous;
    }

    private String zrnalmyousohutomeisyoukbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNALMYOUSOHUTOMEISYOUKBN)
    public String getZrnalmyousohutomeisyoukbn() {
        return zrnalmyousohutomeisyoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnalmyousohutomeisyoukbn(String pZrnalmyousohutomeisyoukbn) {
        zrnalmyousohutomeisyoukbn = pZrnalmyousohutomeisyoukbn;
    }

    private String zrnsnkyksoftmeisyoukbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSNKYKSOFTMEISYOUKBN)
    public String getZrnsnkyksoftmeisyoukbn() {
        return zrnsnkyksoftmeisyoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsnkyksoftmeisyoukbn(String pZrnsnkyksoftmeisyoukbn) {
        zrnsnkyksoftmeisyoukbn = pZrnsnkyksoftmeisyoukbn;
    }

    private String zrnsoftmeisyoukbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSOFTMEISYOUKBN)
    public String getZrnsoftmeisyoukbn() {
        return zrnsoftmeisyoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsoftmeisyoukbn(String pZrnsoftmeisyoukbn) {
        zrnsoftmeisyoukbn = pZrnsoftmeisyoukbn;
    }

    private String zrnkykjitokujyouarihyj;

    @Column(name=GenZT_IdouMeisaiRn.ZRNKYKJITOKUJYOUARIHYJ)
    public String getZrnkykjitokujyouarihyj() {
        return zrnkykjitokujyouarihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkykjitokujyouarihyj(String pZrnkykjitokujyouarihyj) {
        zrnkykjitokujyouarihyj = pZrnkykjitokujyouarihyj;
    }

    private String zrnbnkttnknkbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNBNKTTNKNKBN)
    public String getZrnbnkttnknkbn() {
        return zrnbnkttnknkbn;
    }

    public void setZrnbnkttnknkbn(String pZrnbnkttnknkbn) {
        zrnbnkttnknkbn = pZrnbnkttnknkbn;
    }

    private String zrntenkanminaosikbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTENKANMINAOSIKBN)
    public String getZrntenkanminaosikbn() {
        return zrntenkanminaosikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntenkanminaosikbn(String pZrntenkanminaosikbn) {
        zrntenkanminaosikbn = pZrntenkanminaosikbn;
    }

    private String zrnsoujikeitenkankbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSOUJIKEITENKANKBN)
    public String getZrnsoujikeitenkankbn() {
        return zrnsoujikeitenkankbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsoujikeitenkankbn(String pZrnsoujikeitenkankbn) {
        zrnsoujikeitenkankbn = pZrnsoujikeitenkankbn;
    }

    private String zrnnenkinkaisinendo;

    @Column(name=GenZT_IdouMeisaiRn.ZRNNENKINKAISINENDO)
    public String getZrnnenkinkaisinendo() {
        return zrnnenkinkaisinendo;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrnnenkinkaisinendo(String pZrnnenkinkaisinendo) {
        zrnnenkinkaisinendo = pZrnnenkinkaisinendo;
    }

    private String zrnnenkingatakbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNNENKINGATAKBN)
    public String getZrnnenkingatakbn() {
        return zrnnenkingatakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnnenkingatakbn(String pZrnnenkingatakbn) {
        zrnnenkingatakbn = pZrnnenkingatakbn;
    }

    private String zrnnknshry;

    @Column(name=GenZT_IdouMeisaiRn.ZRNNKNSHRY)
    public String getZrnnknshry() {
        return zrnnknshry;
    }

    public void setZrnnknshry(String pZrnnknshry) {
        zrnnknshry = pZrnnknshry;
    }

    private String zrnheiyoubaraikeiyakukbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNHEIYOUBARAIKEIYAKUKBN)
    public String getZrnheiyoubaraikeiyakukbn() {
        return zrnheiyoubaraikeiyakukbn;
    }

    public void setZrnheiyoubaraikeiyakukbn(String pZrnheiyoubaraikeiyakukbn) {
        zrnheiyoubaraikeiyakukbn = pZrnheiyoubaraikeiyakukbn;
    }

    private String zrnnenkinmaruteihukakbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNNENKINMARUTEIHUKAKBN)
    public String getZrnnenkinmaruteihukakbn() {
        return zrnnenkinmaruteihukakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnnenkinmaruteihukakbn(String pZrnnenkinmaruteihukakbn) {
        zrnnenkinmaruteihukakbn = pZrnnenkinmaruteihukakbn;
    }

    private String zrnsinseizonmrtiarihyj;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSINSEIZONMRTIARIHYJ)
    public String getZrnsinseizonmrtiarihyj() {
        return zrnsinseizonmrtiarihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsinseizonmrtiarihyj(String pZrnsinseizonmrtiarihyj) {
        zrnsinseizonmrtiarihyj = pZrnsinseizonmrtiarihyj;
    }

    private String zrnsnkykyouibokijyukbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSNKYKYOUIBOKIJYUKBN)
    public String getZrnsnkykyouibokijyukbn() {
        return zrnsnkykyouibokijyukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsnkykyouibokijyukbn(String pZrnsnkykyouibokijyukbn) {
        zrnsnkykyouibokijyukbn = pZrnsnkykyouibokijyukbn;
    }

    private String zrntokusitujyuusitusetkbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTOKUSITUJYUUSITUSETKBN)
    public String getZrntokusitujyuusitusetkbn() {
        return zrntokusitujyuusitusetkbn;
    }

    public void setZrntokusitujyuusitusetkbn(String pZrntokusitujyuusitusetkbn) {
        zrntokusitujyuusitusetkbn = pZrntokusitujyuusitusetkbn;
    }

    private String zrnsiktsyuknbyugnhsyunshyj;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSIKTSYUKNBYUGNHSYUNSHYJ)
    public String getZrnsiktsyuknbyugnhsyunshyj() {
        return zrnsiktsyuknbyugnhsyunshyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsiktsyuknbyugnhsyunshyj(String pZrnsiktsyuknbyugnhsyunshyj) {
        zrnsiktsyuknbyugnhsyunshyj = pZrnsiktsyuknbyugnhsyunshyj;
    }

    private String zrnpmensugugtganhsyunshyj;

    @Column(name=GenZT_IdouMeisaiRn.ZRNPMENSUGUGTGANHSYUNSHYJ)
    public String getZrnpmensugugtganhsyunshyj() {
        return zrnpmensugugtganhsyunshyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnpmensugugtganhsyunshyj(String pZrnpmensugugtganhsyunshyj) {
        zrnpmensugugtganhsyunshyj = pZrnpmensugugtganhsyunshyj;
    }

    private String zrntkykgyousekihyjszerohyj;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTKYKGYOUSEKIHYJSZEROHYJ)
    public String getZrntkykgyousekihyjszerohyj() {
        return zrntkykgyousekihyjszerohyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntkykgyousekihyjszerohyj(String pZrntkykgyousekihyjszerohyj) {
        zrntkykgyousekihyjszerohyj = pZrntkykgyousekihyjszerohyj;
    }

    private String zrnsuuriyouyobin7;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSUURIYOUYOBIN7)
    public String getZrnsuuriyouyobin7() {
        return zrnsuuriyouyobin7;
    }

    @Padding(mode = "left", padChar = '0', length = 7)
    public void setZrnsuuriyouyobin7(String pZrnsuuriyouyobin7) {
        zrnsuuriyouyobin7 = pZrnsuuriyouyobin7;
    }

    private String zrnsyussaikeitaikbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSYUSSAIKEITAIKBN)
    public String getZrnsyussaikeitaikbn() {
        return zrnsyussaikeitaikbn;
    }

    public void setZrnsyussaikeitaikbn(String pZrnsyussaikeitaikbn) {
        zrnsyussaikeitaikbn = pZrnsyussaikeitaikbn;
    }

    private String zrnyobiv6;

    @Column(name=GenZT_IdouMeisaiRn.ZRNYOBIV6)
    public String getZrnyobiv6() {
        return zrnyobiv6;
    }

    public void setZrnyobiv6(String pZrnyobiv6) {
        zrnyobiv6 = pZrnyobiv6;
    }

    private String zrnbosyuukeitaikbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNBOSYUUKEITAIKBN)
    public String getZrnbosyuukeitaikbn() {
        return zrnbosyuukeitaikbn;
    }

    public void setZrnbosyuukeitaikbn(String pZrnbosyuukeitaikbn) {
        zrnbosyuukeitaikbn = pZrnbosyuukeitaikbn;
    }

    private String zrnaatukaisosikicd;

    @Column(name=GenZT_IdouMeisaiRn.ZRNAATUKAISOSIKICD)
    public String getZrnaatukaisosikicd() {
        return zrnaatukaisosikicd;
    }

    public void setZrnaatukaisosikicd(String pZrnaatukaisosikicd) {
        zrnaatukaisosikicd = pZrnaatukaisosikicd;
    }

    private String zrnaatukaikojincd;

    @Column(name=GenZT_IdouMeisaiRn.ZRNAATUKAIKOJINCD)
    public String getZrnaatukaikojincd() {
        return zrnaatukaikojincd;
    }

    public void setZrnaatukaikojincd(String pZrnaatukaikojincd) {
        zrnaatukaikojincd = pZrnaatukaikojincd;
    }

    private String zrnbsydrtencd;

    @Column(name=GenZT_IdouMeisaiRn.ZRNBSYDRTENCD)
    public String getZrnbsydrtencd() {
        return zrnbsydrtencd;
    }

    public void setZrnbsydrtencd(String pZrnbsydrtencd) {
        zrnbsydrtencd = pZrnbsydrtencd;
    }

    private String zrncifcd;

    @Column(name=GenZT_IdouMeisaiRn.ZRNCIFCD)
    public String getZrncifcd() {
        return zrncifcd;
    }

    public void setZrncifcd(String pZrncifcd) {
        zrncifcd = pZrncifcd;
    }

    private String zrnsuuriyouyobiv8;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSUURIYOUYOBIV8)
    public String getZrnsuuriyouyobiv8() {
        return zrnsuuriyouyobiv8;
    }

    public void setZrnsuuriyouyobiv8(String pZrnsuuriyouyobiv8) {
        zrnsuuriyouyobiv8 = pZrnsuuriyouyobiv8;
    }

    private String zrnsinsakbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSINSAKBN)
    public String getZrnsinsakbn() {
        return zrnsinsakbn;
    }

    public void setZrnsinsakbn(String pZrnsinsakbn) {
        zrnsinsakbn = pZrnsinsakbn;
    }

    private String zrndai2hihokensyasinsakbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNDAI2HIHOKENSYASINSAKBN)
    public String getZrndai2hihokensyasinsakbn() {
        return zrndai2hihokensyasinsakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndai2hihokensyasinsakbn(String pZrndai2hihokensyasinsakbn) {
        zrndai2hihokensyasinsakbn = pZrndai2hihokensyasinsakbn;
    }

    private String zrntoukeiyousinsakbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTOUKEIYOUSINSAKBN)
    public String getZrntoukeiyousinsakbn() {
        return zrntoukeiyousinsakbn;
    }

    public void setZrntoukeiyousinsakbn(String pZrntoukeiyousinsakbn) {
        zrntoukeiyousinsakbn = pZrntoukeiyousinsakbn;
    }

    private String zrndai2toukeiyousinsakbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNDAI2TOUKEIYOUSINSAKBN)
    public String getZrndai2toukeiyousinsakbn() {
        return zrndai2toukeiyousinsakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndai2toukeiyousinsakbn(String pZrndai2toukeiyousinsakbn) {
        zrndai2toukeiyousinsakbn = pZrndai2toukeiyousinsakbn;
    }

    private String zrnketteikijyunkanwakbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNKETTEIKIJYUNKANWAKBN)
    public String getZrnketteikijyunkanwakbn() {
        return zrnketteikijyunkanwakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnketteikijyunkanwakbn(String pZrnketteikijyunkanwakbn) {
        zrnketteikijyunkanwakbn = pZrnketteikijyunkanwakbn;
    }

    private String zrnkihonsibouhyoukbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNKIHONSIBOUHYOUKBN)
    public String getZrnkihonsibouhyoukbn() {
        return zrnkihonsibouhyoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkihonsibouhyoukbn(String pZrnkihonsibouhyoukbn) {
        zrnkihonsibouhyoukbn = pZrnkihonsibouhyoukbn;
    }

    private String zrnteikisibouhyoukbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTEIKISIBOUHYOUKBN)
    public String getZrnteikisibouhyoukbn() {
        return zrnteikisibouhyoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnteikisibouhyoukbn(String pZrnteikisibouhyoukbn) {
        zrnteikisibouhyoukbn = pZrnteikisibouhyoukbn;
    }

    private String zrnsonotasibouhyoukbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSONOTASIBOUHYOUKBN)
    public String getZrnsonotasibouhyoukbn() {
        return zrnsonotasibouhyoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsonotasibouhyoukbn(String pZrnsonotasibouhyoukbn) {
        zrnsonotasibouhyoukbn = pZrnsonotasibouhyoukbn;
    }

    private String zrnmrarihyj;

    @Column(name=GenZT_IdouMeisaiRn.ZRNMRARIHYJ)
    public String getZrnmrarihyj() {
        return zrnmrarihyj;
    }

    public void setZrnmrarihyj(String pZrnmrarihyj) {
        zrnmrarihyj = pZrnmrarihyj;
    }

    private String zrnsentakujyouhouarihyouji;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSENTAKUJYOUHOUARIHYOUJI)
    public String getZrnsentakujyouhouarihyouji() {
        return zrnsentakujyouhouarihyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsentakujyouhouarihyouji(String pZrnsentakujyouhouarihyouji) {
        zrnsentakujyouhouarihyouji = pZrnsentakujyouhouarihyouji;
    }

    private String zrndugktnknsntkhuhukbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNDUGKTNKNSNTKHUHUKBN)
    public String getZrndugktnknsntkhuhukbn() {
        return zrndugktnknsntkhuhukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndugktnknsntkhuhukbn(String pZrndugktnknsntkhuhukbn) {
        zrndugktnknsntkhuhukbn = pZrndugktnknsntkhuhukbn;
    }

    private String zrngengakutenkankykhyj;

    @Column(name=GenZT_IdouMeisaiRn.ZRNGENGAKUTENKANKYKHYJ)
    public String getZrngengakutenkankykhyj() {
        return zrngengakutenkankykhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrngengakutenkankykhyj(String pZrngengakutenkankykhyj) {
        zrngengakutenkankykhyj = pZrngengakutenkankykhyj;
    }

    private String zrnsykgycd;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSYKGYCD)
    public String getZrnsykgycd() {
        return zrnsykgycd;
    }

    public void setZrnsykgycd(String pZrnsykgycd) {
        zrnsykgycd = pZrnsykgycd;
    }

    private String zrnjidoukousinkykkanyuuymd;

    @Column(name=GenZT_IdouMeisaiRn.ZRNJIDOUKOUSINKYKKANYUUYMD)
    public String getZrnjidoukousinkykkanyuuymd() {
        return zrnjidoukousinkykkanyuuymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnjidoukousinkykkanyuuymd(String pZrnjidoukousinkykkanyuuymd) {
        zrnjidoukousinkykkanyuuymd = pZrnjidoukousinkykkanyuuymd;
    }

    private String zrnsaikohtnknkykkykymd;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSAIKOHTNKNKYKKYKYMD)
    public String getZrnsaikohtnknkykkykymd() {
        return zrnsaikohtnknkykkykymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnsaikohtnknkykkykymd(String pZrnsaikohtnknkykkykymd) {
        zrnsaikohtnknkykkykymd = pZrnsaikohtnknkykkykymd;
    }

    private String zrnkousinmaesykyksburtkbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNKOUSINMAESYKYKSBURTKBN)
    public String getZrnkousinmaesykyksburtkbn() {
        return zrnkousinmaesykyksburtkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkousinmaesykyksburtkbn(String pZrnkousinmaesykyksburtkbn) {
        zrnkousinmaesykyksburtkbn = pZrnkousinmaesykyksburtkbn;
    }

    private String zrnhjnkykhyj;

    @Column(name=GenZT_IdouMeisaiRn.ZRNHJNKYKHYJ)
    public String getZrnhjnkykhyj() {
        return zrnhjnkykhyj;
    }

    public void setZrnhjnkykhyj(String pZrnhjnkykhyj) {
        zrnhjnkykhyj = pZrnhjnkykhyj;
    }

    private String zrnanniskcd;

    @Column(name=GenZT_IdouMeisaiRn.ZRNANNISKCD)
    public String getZrnanniskcd() {
        return zrnanniskcd;
    }

    public void setZrnanniskcd(String pZrnanniskcd) {
        zrnanniskcd = pZrnanniskcd;
    }

    private String zrnhjncd;

    @Column(name=GenZT_IdouMeisaiRn.ZRNHJNCD)
    public String getZrnhjncd() {
        return zrnhjncd;
    }

    public void setZrnhjncd(String pZrnhjncd) {
        zrnhjncd = pZrnhjncd;
    }

    private String zrnhjnjigyosyocd;

    @Column(name=GenZT_IdouMeisaiRn.ZRNHJNJIGYOSYOCD)
    public String getZrnhjnjigyosyocd() {
        return zrnhjnjigyosyocd;
    }

    public void setZrnhjnjigyosyocd(String pZrnhjnjigyosyocd) {
        zrnhjnjigyosyocd = pZrnhjnjigyosyocd;
    }

    private String zrnsaihokenno;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSAIHOKENNO)
    public String getZrnsaihokenno() {
        return zrnsaihokenno;
    }

    @Padding(mode = "left", padChar = '0', length = 5)
    public void setZrnsaihokenno(String pZrnsaihokenno) {
        zrnsaihokenno = pZrnsaihokenno;
    }

    private String zrndakuhikettikekkacd;

    @Column(name=GenZT_IdouMeisaiRn.ZRNDAKUHIKETTIKEKKACD)
    public String getZrndakuhikettikekkacd() {
        return zrndakuhikettikekkacd;
    }

    public void setZrndakuhikettikekkacd(String pZrndakuhikettikekkacd) {
        zrndakuhikettikekkacd = pZrndakuhikettikekkacd;
    }

    private String zrndai2dakuhiketteikekkacd;

    @Column(name=GenZT_IdouMeisaiRn.ZRNDAI2DAKUHIKETTEIKEKKACD)
    public String getZrndai2dakuhiketteikekkacd() {
        return zrndai2dakuhiketteikekkacd;
    }

    public void setZrndai2dakuhiketteikekkacd(String pZrndai2dakuhiketteikekkacd) {
        zrndai2dakuhiketteikekkacd = pZrndai2dakuhiketteikekkacd;
    }

    private String zrnpmenkbnv2;

    @Column(name=GenZT_IdouMeisaiRn.ZRNPMENKBNV2)
    public String getZrnpmenkbnv2() {
        return zrnpmenkbnv2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnpmenkbnv2(String pZrnpmenkbnv2) {
        zrnpmenkbnv2 = pZrnpmenkbnv2;
    }

    private Long zrnsiboukyuuhukin;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSIBOUKYUUHUKIN)
    public Long getZrnsiboukyuuhukin() {
        return zrnsiboukyuuhukin;
    }

    public void setZrnsiboukyuuhukin(Long pZrnsiboukyuuhukin) {
        zrnsiboukyuuhukin = pZrnsiboukyuuhukin;
    }

    private String zrnjyudthumeharaitkykhkhyj;

    @Column(name=GenZT_IdouMeisaiRn.ZRNJYUDTHUMEHARAITKYKHKHYJ)
    public String getZrnjyudthumeharaitkykhkhyj() {
        return zrnjyudthumeharaitkykhkhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnjyudthumeharaitkykhkhyj(String pZrnjyudthumeharaitkykhkhyj) {
        zrnjyudthumeharaitkykhkhyj = pZrnjyudthumeharaitkykhkhyj;
    }

    private String zrnhaitoukbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNHAITOUKBN)
    public String getZrnhaitoukbn() {
        return zrnhaitoukbn;
    }

    public void setZrnhaitoukbn(String pZrnhaitoukbn) {
        zrnhaitoukbn = pZrnhaitoukbn;
    }

    private String zrnhhknnentysihyj;

    @Column(name=GenZT_IdouMeisaiRn.ZRNHHKNNENTYSIHYJ)
    public String getZrnhhknnentysihyj() {
        return zrnhhknnentysihyj;
    }

    public void setZrnhhknnentysihyj(String pZrnhhknnentysihyj) {
        zrnhhknnentysihyj = pZrnhhknnentysihyj;
    }

    private String zrndai2hhknnentysihyj;

    @Column(name=GenZT_IdouMeisaiRn.ZRNDAI2HHKNNENTYSIHYJ)
    public String getZrndai2hhknnentysihyj() {
        return zrndai2hhknnentysihyj;
    }

    public void setZrndai2hhknnentysihyj(String pZrndai2hhknnentysihyj) {
        zrndai2hhknnentysihyj = pZrndai2hhknnentysihyj;
    }

    private String zrnkyksyaagetyouseihyj;

    @Column(name=GenZT_IdouMeisaiRn.ZRNKYKSYAAGETYOUSEIHYJ)
    public String getZrnkyksyaagetyouseihyj() {
        return zrnkyksyaagetyouseihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkyksyaagetyouseihyj(String pZrnkyksyaagetyouseihyj) {
        zrnkyksyaagetyouseihyj = pZrnkyksyaagetyouseihyj;
    }

    private String zrnkituenkbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNKITUENKBN)
    public String getZrnkituenkbn() {
        return zrnkituenkbn;
    }

    public void setZrnkituenkbn(String pZrnkituenkbn) {
        zrnkituenkbn = pZrnkituenkbn;
    }

    private String zrnkituenhonsuu;

    @Column(name=GenZT_IdouMeisaiRn.ZRNKITUENHONSUU)
    public String getZrnkituenhonsuu() {
        return zrnkituenhonsuu;
    }

    public void setZrnkituenhonsuu(String pZrnkituenhonsuu) {
        zrnkituenhonsuu = pZrnkituenhonsuu;
    }

    private String zrnmusentakukeiyakukbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNMUSENTAKUKEIYAKUKBN)
    public String getZrnmusentakukeiyakukbn() {
        return zrnmusentakukeiyakukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnmusentakukeiyakukbn(String pZrnmusentakukeiyakukbn) {
        zrnmusentakukeiyakukbn = pZrnmusentakukeiyakukbn;
    }

    private String zrnyobiv6x2;

    @Column(name=GenZT_IdouMeisaiRn.ZRNYOBIV6X2)
    public String getZrnyobiv6x2() {
        return zrnyobiv6x2;
    }

    public void setZrnyobiv6x2(String pZrnyobiv6x2) {
        zrnyobiv6x2 = pZrnyobiv6x2;
    }

    private String zrnlivingneedstkykarihyj;

    @Column(name=GenZT_IdouMeisaiRn.ZRNLIVINGNEEDSTKYKARIHYJ)
    public String getZrnlivingneedstkykarihyj() {
        return zrnlivingneedstkykarihyj;
    }

    public void setZrnlivingneedstkykarihyj(String pZrnlivingneedstkykarihyj) {
        zrnlivingneedstkykarihyj = pZrnlivingneedstkykarihyj;
    }

    private String zrnlivingneedssiharaihyouji;

    @Column(name=GenZT_IdouMeisaiRn.ZRNLIVINGNEEDSSIHARAIHYOUJI)
    public String getZrnlivingneedssiharaihyouji() {
        return zrnlivingneedssiharaihyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnlivingneedssiharaihyouji(String pZrnlivingneedssiharaihyouji) {
        zrnlivingneedssiharaihyouji = pZrnlivingneedssiharaihyouji;
    }

    private String zrnlnseikyuuymd;

    @Column(name=GenZT_IdouMeisaiRn.ZRNLNSEIKYUUYMD)
    public String getZrnlnseikyuuymd() {
        return zrnlnseikyuuymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnlnseikyuuymd(String pZrnlnseikyuuymd) {
        zrnlnseikyuuymd = pZrnlnseikyuuymd;
    }

    private String zrnlnshrgenincd;

    @Column(name=GenZT_IdouMeisaiRn.ZRNLNSHRGENINCD)
    public String getZrnlnshrgenincd() {
        return zrnlnshrgenincd;
    }

    public void setZrnlnshrgenincd(String pZrnlnshrgenincd) {
        zrnlnshrgenincd = pZrnlnshrgenincd;
    }

    private String zrndakuhikettisyacd;

    @Column(name=GenZT_IdouMeisaiRn.ZRNDAKUHIKETTISYACD)
    public String getZrndakuhikettisyacd() {
        return zrndakuhikettisyacd;
    }

    public void setZrndakuhikettisyacd(String pZrndakuhikettisyacd) {
        zrndakuhikettisyacd = pZrndakuhikettisyacd;
    }

    private String zrndai2dakuhiketteisyacd;

    @Column(name=GenZT_IdouMeisaiRn.ZRNDAI2DAKUHIKETTEISYACD)
    public String getZrndai2dakuhiketteisyacd() {
        return zrndai2dakuhiketteisyacd;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndai2dakuhiketteisyacd(String pZrndai2dakuhiketteisyacd) {
        zrndai2dakuhiketteisyacd = pZrndai2dakuhiketteisyacd;
    }

    private String zrngansapotokuyakuarihyouji;

    @Column(name=GenZT_IdouMeisaiRn.ZRNGANSAPOTOKUYAKUARIHYOUJI)
    public String getZrngansapotokuyakuarihyouji() {
        return zrngansapotokuyakuarihyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrngansapotokuyakuarihyouji(String pZrngansapotokuyakuarihyouji) {
        zrngansapotokuyakuarihyouji = pZrngansapotokuyakuarihyouji;
    }

    private String zrngnspshrhyj;

    @Column(name=GenZT_IdouMeisaiRn.ZRNGNSPSHRHYJ)
    public String getZrngnspshrhyj() {
        return zrngnspshrhyj;
    }

    public void setZrngnspshrhyj(String pZrngnspshrhyj) {
        zrngnspshrhyj = pZrngnspshrhyj;
    }

    private String zrngansaposeikyuuymd;

    @Column(name=GenZT_IdouMeisaiRn.ZRNGANSAPOSEIKYUUYMD)
    public String getZrngansaposeikyuuymd() {
        return zrngansaposeikyuuymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrngansaposeikyuuymd(String pZrngansaposeikyuuymd) {
        zrngansaposeikyuuymd = pZrngansaposeikyuuymd;
    }

    private String zrngnspshrgenincd;

    @Column(name=GenZT_IdouMeisaiRn.ZRNGNSPSHRGENINCD)
    public String getZrngnspshrgenincd() {
        return zrngnspshrgenincd;
    }

    public void setZrngnspshrgenincd(String pZrngnspshrgenincd) {
        zrngnspshrgenincd = pZrngnspshrgenincd;
    }

    private String zrnyobiv3x2;

    @Column(name=GenZT_IdouMeisaiRn.ZRNYOBIV3X2)
    public String getZrnyobiv3x2() {
        return zrnyobiv3x2;
    }

    public void setZrnyobiv3x2(String pZrnyobiv3x2) {
        zrnyobiv3x2 = pZrnyobiv3x2;
    }

    private String zrntargetmokuhyouritu;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTARGETMOKUHYOURITU)
    public String getZrntargetmokuhyouritu() {
        return zrntargetmokuhyouritu;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrntargetmokuhyouritu(String pZrntargetmokuhyouritu) {
        zrntargetmokuhyouritu = pZrntargetmokuhyouritu;
    }

    private String zrnautoswitchmokuhyouritu;

    @Column(name=GenZT_IdouMeisaiRn.ZRNAUTOSWITCHMOKUHYOURITU)
    public String getZrnautoswitchmokuhyouritu() {
        return zrnautoswitchmokuhyouritu;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrnautoswitchmokuhyouritu(String pZrnautoswitchmokuhyouritu) {
        zrnautoswitchmokuhyouritu = pZrnautoswitchmokuhyouritu;
    }

    private String zrntumitatekinitenarihyj;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTUMITATEKINITENARIHYJ)
    public String getZrntumitatekinitenarihyj() {
        return zrntumitatekinitenarihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntumitatekinitenarihyj(String pZrntumitatekinitenarihyj) {
        zrntumitatekinitenarihyj = pZrntumitatekinitenarihyj;
    }

    private String zrntumitatekinitenkaisuu;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTUMITATEKINITENKAISUU)
    public String getZrntumitatekinitenkaisuu() {
        return zrntumitatekinitenkaisuu;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrntumitatekinitenkaisuu(String pZrntumitatekinitenkaisuu) {
        zrntumitatekinitenkaisuu = pZrntumitatekinitenkaisuu;
    }

    private String zrndatakanrino2;

    @Column(name=GenZT_IdouMeisaiRn.ZRNDATAKANRINO2)
    public String getZrndatakanrino2() {
        return zrndatakanrino2;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrndatakanrino2(String pZrndatakanrino2) {
        zrndatakanrino2 = pZrndatakanrino2;
    }

    private String zrndatakanrino3;

    @Column(name=GenZT_IdouMeisaiRn.ZRNDATAKANRINO3)
    public String getZrndatakanrino3() {
        return zrndatakanrino3;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrndatakanrino3(String pZrndatakanrino3) {
        zrndatakanrino3 = pZrndatakanrino3;
    }

    private String zrnknkuzusnzyrttekinendo;

    @Column(name=GenZT_IdouMeisaiRn.ZRNKNKUZUSNZYRTTEKINENDO)
    public String getZrnknkuzusnzyrttekinendo() {
        return zrnknkuzusnzyrttekinendo;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrnknkuzusnzyrttekinendo(String pZrnknkuzusnzyrttekinendo) {
        zrnknkuzusnzyrttekinendo = pZrnknkuzusnzyrttekinendo;
    }

    private String zrnknkuzusnzyrt;

    @Column(name=GenZT_IdouMeisaiRn.ZRNKNKUZUSNZYRT)
    public String getZrnknkuzusnzyrt() {
        return zrnknkuzusnzyrt;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrnknkuzusnzyrt(String pZrnknkuzusnzyrt) {
        zrnknkuzusnzyrt = pZrnknkuzusnzyrt;
    }

    private String zrnknkuzusnzyrtx2;

    @Column(name=GenZT_IdouMeisaiRn.ZRNKNKUZUSNZYRTX2)
    public String getZrnknkuzusnzyrtx2() {
        return zrnknkuzusnzyrtx2;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrnknkuzusnzyrtx2(String pZrnknkuzusnzyrtx2) {
        zrnknkuzusnzyrtx2 = pZrnknkuzusnzyrtx2;
    }

    private String zrnknkuzusnzyrtx3;

    @Column(name=GenZT_IdouMeisaiRn.ZRNKNKUZUSNZYRTX3)
    public String getZrnknkuzusnzyrtx3() {
        return zrnknkuzusnzyrtx3;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrnknkuzusnzyrtx3(String pZrnknkuzusnzyrtx3) {
        zrnknkuzusnzyrtx3 = pZrnknkuzusnzyrtx3;
    }

    private String zrnsinkeiyakujiknkuzusnzyrt;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSINKEIYAKUJIKNKUZUSNZYRT)
    public String getZrnsinkeiyakujiknkuzusnzyrt() {
        return zrnsinkeiyakujiknkuzusnzyrt;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrnsinkeiyakujiknkuzusnzyrt(String pZrnsinkeiyakujiknkuzusnzyrt) {
        zrnsinkeiyakujiknkuzusnzyrt = pZrnsinkeiyakujiknkuzusnzyrt;
    }

    private String zrntenkanjiknkuzusnzyrt;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTENKANJIKNKUZUSNZYRT)
    public String getZrntenkanjiknkuzusnzyrt() {
        return zrntenkanjiknkuzusnzyrt;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrntenkanjiknkuzusnzyrt(String pZrntenkanjiknkuzusnzyrt) {
        zrntenkanjiknkuzusnzyrt = pZrntenkanjiknkuzusnzyrt;
    }

    private String zrnsinkeiyakujivithkhyouji;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSINKEIYAKUJIVITHKHYOUJI)
    public String getZrnsinkeiyakujivithkhyouji() {
        return zrnsinkeiyakujivithkhyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsinkeiyakujivithkhyouji(String pZrnsinkeiyakujivithkhyouji) {
        zrnsinkeiyakujivithkhyouji = pZrnsinkeiyakujivithkhyouji;
    }

    private String zrnkykjivithukusuukykhyj;

    @Column(name=GenZT_IdouMeisaiRn.ZRNKYKJIVITHUKUSUUKYKHYJ)
    public String getZrnkykjivithukusuukykhyj() {
        return zrnkykjivithukusuukykhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkykjivithukusuukykhyj(String pZrnkykjivithukusuukykhyj) {
        zrnkykjivithukusuukykhyj = pZrnkykjivithukusuukykhyj;
    }

    private String zrnsuuriyouyobin9x2;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSUURIYOUYOBIN9X2)
    public String getZrnsuuriyouyobin9x2() {
        return zrnsuuriyouyobin9x2;
    }

    @Padding(mode = "left", padChar = '0', length = 9)
    public void setZrnsuuriyouyobin9x2(String pZrnsuuriyouyobin9x2) {
        zrnsuuriyouyobin9x2 = pZrnsuuriyouyobin9x2;
    }

    private String zrnpwrbksidhitekiyouhyj;

    @Column(name=GenZT_IdouMeisaiRn.ZRNPWRBKSIDHITEKIYOUHYJ)
    public String getZrnpwrbksidhitekiyouhyj() {
        return zrnpwrbksidhitekiyouhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnpwrbksidhitekiyouhyj(String pZrnpwrbksidhitekiyouhyj) {
        zrnpwrbksidhitekiyouhyj = pZrnpwrbksidhitekiyouhyj;
    }

    private String zrnsuuriyouyobin9;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSUURIYOUYOBIN9)
    public String getZrnsuuriyouyobin9() {
        return zrnsuuriyouyobin9;
    }

    @Padding(mode = "left", padChar = '0', length = 9)
    public void setZrnsuuriyouyobin9(String pZrnsuuriyouyobin9) {
        zrnsuuriyouyobin9 = pZrnsuuriyouyobin9;
    }

    private String zrnsuuriyouyobin10x7;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSUURIYOUYOBIN10X7)
    public String getZrnsuuriyouyobin10x7() {
        return zrnsuuriyouyobin10x7;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnsuuriyouyobin10x7(String pZrnsuuriyouyobin10x7) {
        zrnsuuriyouyobin10x7 = pZrnsuuriyouyobin10x7;
    }

    private String zrnsuuriyouyobin10x8;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSUURIYOUYOBIN10X8)
    public String getZrnsuuriyouyobin10x8() {
        return zrnsuuriyouyobin10x8;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnsuuriyouyobin10x8(String pZrnsuuriyouyobin10x8) {
        zrnsuuriyouyobin10x8 = pZrnsuuriyouyobin10x8;
    }

    private String zrnsuuriyouyobin10x9;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSUURIYOUYOBIN10X9)
    public String getZrnsuuriyouyobin10x9() {
        return zrnsuuriyouyobin10x9;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnsuuriyouyobin10x9(String pZrnsuuriyouyobin10x9) {
        zrnsuuriyouyobin10x9 = pZrnsuuriyouyobin10x9;
    }

    private Long zrntumitatekinitenbubun;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTUMITATEKINITENBUBUN)
    public Long getZrntumitatekinitenbubun() {
        return zrntumitatekinitenbubun;
    }

    public void setZrntumitatekinitenbubun(Long pZrntumitatekinitenbubun) {
        zrntumitatekinitenbubun = pZrntumitatekinitenbubun;
    }

    private Long zrnsagakusknnjynbknzndk;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSAGAKUSKNNJYNBKNZNDK)
    public Long getZrnsagakusknnjynbknzndk() {
        return zrnsagakusknnjynbknzndk;
    }

    public void setZrnsagakusknnjynbknzndk(Long pZrnsagakusknnjynbknzndk) {
        zrnsagakusknnjynbknzndk = pZrnsagakusknnjynbknzndk;
    }

    private Long zrnyobin11x5;

    @Column(name=GenZT_IdouMeisaiRn.ZRNYOBIN11X5)
    public Long getZrnyobin11x5() {
        return zrnyobin11x5;
    }

    public void setZrnyobin11x5(Long pZrnyobin11x5) {
        zrnyobin11x5 = pZrnyobin11x5;
    }

    private Long zrnyobin11x6;

    @Column(name=GenZT_IdouMeisaiRn.ZRNYOBIN11X6)
    public Long getZrnyobin11x6() {
        return zrnyobin11x6;
    }

    public void setZrnyobin11x6(Long pZrnyobin11x6) {
        zrnyobin11x6 = pZrnyobin11x6;
    }

    private Long zrnyobin11x7;

    @Column(name=GenZT_IdouMeisaiRn.ZRNYOBIN11X7)
    public Long getZrnyobin11x7() {
        return zrnyobin11x7;
    }

    public void setZrnyobin11x7(Long pZrnyobin11x7) {
        zrnyobin11x7 = pZrnyobin11x7;
    }

    private Long zrnyobin11x8;

    @Column(name=GenZT_IdouMeisaiRn.ZRNYOBIN11X8)
    public Long getZrnyobin11x8() {
        return zrnyobin11x8;
    }

    public void setZrnyobin11x8(Long pZrnyobin11x8) {
        zrnyobin11x8 = pZrnyobin11x8;
    }

    private Long zrnyobin11x9;

    @Column(name=GenZT_IdouMeisaiRn.ZRNYOBIN11X9)
    public Long getZrnyobin11x9() {
        return zrnyobin11x9;
    }

    public void setZrnyobin11x9(Long pZrnyobin11x9) {
        zrnyobin11x9 = pZrnyobin11x9;
    }

    private Long zrnyobin11x10;

    @Column(name=GenZT_IdouMeisaiRn.ZRNYOBIN11X10)
    public Long getZrnyobin11x10() {
        return zrnyobin11x10;
    }

    public void setZrnyobin11x10(Long pZrnyobin11x10) {
        zrnyobin11x10 = pZrnyobin11x10;
    }

    private Long zrnyobin11x11;

    @Column(name=GenZT_IdouMeisaiRn.ZRNYOBIN11X11)
    public Long getZrnyobin11x11() {
        return zrnyobin11x11;
    }

    public void setZrnyobin11x11(Long pZrnyobin11x11) {
        zrnyobin11x11 = pZrnyobin11x11;
    }

    private Long zrnyobin11x12;

    @Column(name=GenZT_IdouMeisaiRn.ZRNYOBIN11X12)
    public Long getZrnyobin11x12() {
        return zrnyobin11x12;
    }

    public void setZrnyobin11x12(Long pZrnyobin11x12) {
        zrnyobin11x12 = pZrnyobin11x12;
    }

    private Long zrnyobin11x13;

    @Column(name=GenZT_IdouMeisaiRn.ZRNYOBIN11X13)
    public Long getZrnyobin11x13() {
        return zrnyobin11x13;
    }

    public void setZrnyobin11x13(Long pZrnyobin11x13) {
        zrnyobin11x13 = pZrnyobin11x13;
    }

    private Long zrnyobin11x14;

    @Column(name=GenZT_IdouMeisaiRn.ZRNYOBIN11X14)
    public Long getZrnyobin11x14() {
        return zrnyobin11x14;
    }

    public void setZrnyobin11x14(Long pZrnyobin11x14) {
        zrnyobin11x14 = pZrnyobin11x14;
    }

    private Long zrnyobin11x15;

    @Column(name=GenZT_IdouMeisaiRn.ZRNYOBIN11X15)
    public Long getZrnyobin11x15() {
        return zrnyobin11x15;
    }

    public void setZrnyobin11x15(Long pZrnyobin11x15) {
        zrnyobin11x15 = pZrnyobin11x15;
    }

    private Long zrnyobin11x16;

    @Column(name=GenZT_IdouMeisaiRn.ZRNYOBIN11X16)
    public Long getZrnyobin11x16() {
        return zrnyobin11x16;
    }

    public void setZrnyobin11x16(Long pZrnyobin11x16) {
        zrnyobin11x16 = pZrnyobin11x16;
    }

    private Long zrnyobin11x17;

    @Column(name=GenZT_IdouMeisaiRn.ZRNYOBIN11X17)
    public Long getZrnyobin11x17() {
        return zrnyobin11x17;
    }

    public void setZrnyobin11x17(Long pZrnyobin11x17) {
        zrnyobin11x17 = pZrnyobin11x17;
    }

    private String zrnzyrthntiyustatuskbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNZYRTHNTIYUSTATUSKBN)
    public String getZrnzyrthntiyustatuskbn() {
        return zrnzyrthntiyustatuskbn;
    }

    public void setZrnzyrthntiyustatuskbn(String pZrnzyrthntiyustatuskbn) {
        zrnzyrthntiyustatuskbn = pZrnzyrthntiyustatuskbn;
    }

    private String zrnzyrthntiyustatuskbnx2;

    @Column(name=GenZT_IdouMeisaiRn.ZRNZYRTHNTIYUSTATUSKBNX2)
    public String getZrnzyrthntiyustatuskbnx2() {
        return zrnzyrthntiyustatuskbnx2;
    }

    public void setZrnzyrthntiyustatuskbnx2(String pZrnzyrthntiyustatuskbnx2) {
        zrnzyrthntiyustatuskbnx2 = pZrnzyrthntiyustatuskbnx2;
    }

    private String zrnzyrthntiyustatuskbnx3;

    @Column(name=GenZT_IdouMeisaiRn.ZRNZYRTHNTIYUSTATUSKBNX3)
    public String getZrnzyrthntiyustatuskbnx3() {
        return zrnzyrthntiyustatuskbnx3;
    }

    public void setZrnzyrthntiyustatuskbnx3(String pZrnzyrthntiyustatuskbnx3) {
        zrnzyrthntiyustatuskbnx3 = pZrnzyrthntiyustatuskbnx3;
    }

    private String zrnzyrthntiyustatuskbnx4;

    @Column(name=GenZT_IdouMeisaiRn.ZRNZYRTHNTIYUSTATUSKBNX4)
    public String getZrnzyrthntiyustatuskbnx4() {
        return zrnzyrthntiyustatuskbnx4;
    }

    public void setZrnzyrthntiyustatuskbnx4(String pZrnzyrthntiyustatuskbnx4) {
        zrnzyrthntiyustatuskbnx4 = pZrnzyrthntiyustatuskbnx4;
    }

    private String zrnzyrthntiyustatuskbnx5;

    @Column(name=GenZT_IdouMeisaiRn.ZRNZYRTHNTIYUSTATUSKBNX5)
    public String getZrnzyrthntiyustatuskbnx5() {
        return zrnzyrthntiyustatuskbnx5;
    }

    public void setZrnzyrthntiyustatuskbnx5(String pZrnzyrthntiyustatuskbnx5) {
        zrnzyrthntiyustatuskbnx5 = pZrnzyrthntiyustatuskbnx5;
    }

    private String zrnyobiv10;

    @Column(name=GenZT_IdouMeisaiRn.ZRNYOBIV10)
    public String getZrnyobiv10() {
        return zrnyobiv10;
    }

    public void setZrnyobiv10(String pZrnyobiv10) {
        zrnyobiv10 = pZrnyobiv10;
    }

    private String zrnyobiv15x2;

    @Column(name=GenZT_IdouMeisaiRn.ZRNYOBIV15X2)
    public String getZrnyobiv15x2() {
        return zrnyobiv15x2;
    }

    public void setZrnyobiv15x2(String pZrnyobiv15x2) {
        zrnyobiv15x2 = pZrnyobiv15x2;
    }

    private String zrnyobiv15x3;

    @Column(name=GenZT_IdouMeisaiRn.ZRNYOBIV15X3)
    public String getZrnyobiv15x3() {
        return zrnyobiv15x3;
    }

    public void setZrnyobiv15x3(String pZrnyobiv15x3) {
        zrnyobiv15x3 = pZrnyobiv15x3;
    }

    private String zrnyobiv15x4;

    @Column(name=GenZT_IdouMeisaiRn.ZRNYOBIV15X4)
    public String getZrnyobiv15x4() {
        return zrnyobiv15x4;
    }

    public void setZrnyobiv15x4(String pZrnyobiv15x4) {
        zrnyobiv15x4 = pZrnyobiv15x4;
    }

    private String zrngaikakbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNGAIKAKBN)
    public String getZrngaikakbn() {
        return zrngaikakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrngaikakbn(String pZrngaikakbn) {
        zrngaikakbn = pZrngaikakbn;
    }

    private BizNumber zrnkawaserate1;

    @Type(type="BizNumberType")
    @Column(name=GenZT_IdouMeisaiRn.ZRNKAWASERATE1)
    public BizNumber getZrnkawaserate1() {
        return zrnkawaserate1;
    }

    public void setZrnkawaserate1(BizNumber pZrnkawaserate1) {
        zrnkawaserate1 = pZrnkawaserate1;
    }

    private String zrnkawaseratetekiyouymd1;

    @Column(name=GenZT_IdouMeisaiRn.ZRNKAWASERATETEKIYOUYMD1)
    public String getZrnkawaseratetekiyouymd1() {
        return zrnkawaseratetekiyouymd1;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnkawaseratetekiyouymd1(String pZrnkawaseratetekiyouymd1) {
        zrnkawaseratetekiyouymd1 = pZrnkawaseratetekiyouymd1;
    }

    private BizNumber zrnkawaserate2;

    @Type(type="BizNumberType")
    @Column(name=GenZT_IdouMeisaiRn.ZRNKAWASERATE2)
    public BizNumber getZrnkawaserate2() {
        return zrnkawaserate2;
    }

    public void setZrnkawaserate2(BizNumber pZrnkawaserate2) {
        zrnkawaserate2 = pZrnkawaserate2;
    }

    private String zrnkawaseratetekiyouymd2;

    @Column(name=GenZT_IdouMeisaiRn.ZRNKAWASERATETEKIYOUYMD2)
    public String getZrnkawaseratetekiyouymd2() {
        return zrnkawaseratetekiyouymd2;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnkawaseratetekiyouymd2(String pZrnkawaseratetekiyouymd2) {
        zrnkawaseratetekiyouymd2 = pZrnkawaseratetekiyouymd2;
    }

    private BizNumber zrnkykjikawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_IdouMeisaiRn.ZRNKYKJIKAWASERATE)
    public BizNumber getZrnkykjikawaserate() {
        return zrnkykjikawaserate;
    }

    public void setZrnkykjikawaserate(BizNumber pZrnkykjikawaserate) {
        zrnkykjikawaserate = pZrnkykjikawaserate;
    }

    private String zrnkykjikawaseratetkyuymd;

    @Column(name=GenZT_IdouMeisaiRn.ZRNKYKJIKAWASERATETKYUYMD)
    public String getZrnkykjikawaseratetkyuymd() {
        return zrnkykjikawaseratetkyuymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnkykjikawaseratetkyuymd(String pZrnkykjikawaseratetkyuymd) {
        zrnkykjikawaseratetkyuymd = pZrnkykjikawaseratetkyuymd;
    }

    private Long zrnmvatyouseigow;

    @Column(name=GenZT_IdouMeisaiRn.ZRNMVATYOUSEIGOW)
    public Long getZrnmvatyouseigow() {
        return zrnmvatyouseigow;
    }

    public void setZrnmvatyouseigow(Long pZrnmvatyouseigow) {
        zrnmvatyouseigow = pZrnmvatyouseigow;
    }

    private Long zrnmvakeisanjisknnjynbkn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNMVAKEISANJISKNNJYNBKN)
    public Long getZrnmvakeisanjisknnjynbkn() {
        return zrnmvakeisanjisknnjynbkn;
    }

    public void setZrnmvakeisanjisknnjynbkn(Long pZrnmvakeisanjisknnjynbkn) {
        zrnmvakeisanjisknnjynbkn = pZrnmvakeisanjisknnjynbkn;
    }

    private BizNumber zrnkaiyakukoujyoritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_IdouMeisaiRn.ZRNKAIYAKUKOUJYORITU)
    public BizNumber getZrnkaiyakukoujyoritu() {
        return zrnkaiyakukoujyoritu;
    }

    public void setZrnkaiyakukoujyoritu(BizNumber pZrnkaiyakukoujyoritu) {
        zrnkaiyakukoujyoritu = pZrnkaiyakukoujyoritu;
    }

    private BizNumber zrnrendouritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_IdouMeisaiRn.ZRNRENDOURITU)
    public BizNumber getZrnrendouritu() {
        return zrnrendouritu;
    }

    public void setZrnrendouritu(BizNumber pZrnrendouritu) {
        zrnrendouritu = pZrnrendouritu;
    }

    private BizNumber zrnsrkaiyakusjkkktyouseirrt;

    @Type(type="BizNumberType")
    @Column(name=GenZT_IdouMeisaiRn.ZRNSRKAIYAKUSJKKKTYOUSEIRRT)
    public BizNumber getZrnsrkaiyakusjkkktyouseirrt() {
        return zrnsrkaiyakusjkkktyouseirrt;
    }

    public void setZrnsrkaiyakusjkkktyouseirrt(BizNumber pZrnsrkaiyakusjkkktyouseirrt) {
        zrnsrkaiyakusjkkktyouseirrt = pZrnsrkaiyakusjkkktyouseirrt;
    }

    private BizNumber zrnsrkyksjkkktyouseiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_IdouMeisaiRn.ZRNSRKYKSJKKKTYOUSEIRIRITU)
    public BizNumber getZrnsrkyksjkkktyouseiriritu() {
        return zrnsrkyksjkkktyouseiriritu;
    }

    public void setZrnsrkyksjkkktyouseiriritu(BizNumber pZrnsrkyksjkkktyouseiriritu) {
        zrnsrkyksjkkktyouseiriritu = pZrnsrkyksjkkktyouseiriritu;
    }

    private String zrnmvakeisankijyunymd;

    @Column(name=GenZT_IdouMeisaiRn.ZRNMVAKEISANKIJYUNYMD)
    public String getZrnmvakeisankijyunymd() {
        return zrnmvakeisankijyunymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnmvakeisankijyunymd(String pZrnmvakeisankijyunymd) {
        zrnmvakeisankijyunymd = pZrnmvakeisankijyunymd;
    }

    private BizNumber zrnmvatyouseikou;

    @Type(type="BizNumberType")
    @Column(name=GenZT_IdouMeisaiRn.ZRNMVATYOUSEIKOU)
    public BizNumber getZrnmvatyouseikou() {
        return zrnmvatyouseikou;
    }

    public void setZrnmvatyouseikou(BizNumber pZrnmvatyouseikou) {
        zrnmvatyouseikou = pZrnmvatyouseikou;
    }

    private Long zrnenkdtsbujsitihsyukngk;

    @Column(name=GenZT_IdouMeisaiRn.ZRNENKDTSBUJSITIHSYUKNGK)
    public Long getZrnenkdtsbujsitihsyukngk() {
        return zrnenkdtsbujsitihsyukngk;
    }

    public void setZrnenkdtsbujsitihsyukngk(Long pZrnenkdtsbujsitihsyukngk) {
        zrnenkdtsbujsitihsyukngk = pZrnenkdtsbujsitihsyukngk;
    }

    private Long zrnenkdtsbujsitihsyucost;

    @Column(name=GenZT_IdouMeisaiRn.ZRNENKDTSBUJSITIHSYUCOST)
    public Long getZrnenkdtsbujsitihsyucost() {
        return zrnenkdtsbujsitihsyucost;
    }

    public void setZrnenkdtsbujsitihsyucost(Long pZrnenkdtsbujsitihsyucost) {
        zrnenkdtsbujsitihsyucost = pZrnenkdtsbujsitihsyucost;
    }

    private String zrnenkdtsbujsitihsyuarihyj;

    @Column(name=GenZT_IdouMeisaiRn.ZRNENKDTSBUJSITIHSYUARIHYJ)
    public String getZrnenkdtsbujsitihsyuarihyj() {
        return zrnenkdtsbujsitihsyuarihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnenkdtsbujsitihsyuarihyj(String pZrnenkdtsbujsitihsyuarihyj) {
        zrnenkdtsbujsitihsyuarihyj = pZrnenkdtsbujsitihsyuarihyj;
    }

    private BizNumber zrnkeiyakujiyoteiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_IdouMeisaiRn.ZRNKEIYAKUJIYOTEIRIRITU)
    public BizNumber getZrnkeiyakujiyoteiriritu() {
        return zrnkeiyakujiyoteiriritu;
    }

    public void setZrnkeiyakujiyoteiriritu(BizNumber pZrnkeiyakujiyoteiriritu) {
        zrnkeiyakujiyoteiriritu = pZrnkeiyakujiyoteiriritu;
    }

    private BizNumber zrntumitateriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_IdouMeisaiRn.ZRNTUMITATERIRITU)
    public BizNumber getZrntumitateriritu() {
        return zrntumitateriritu;
    }

    public void setZrntumitateriritu(BizNumber pZrntumitateriritu) {
        zrntumitateriritu = pZrntumitateriritu;
    }

    private String zrnkaigomaebaraitkykarihyj;

    @Column(name=GenZT_IdouMeisaiRn.ZRNKAIGOMAEBARAITKYKARIHYJ)
    public String getZrnkaigomaebaraitkykarihyj() {
        return zrnkaigomaebaraitkykarihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkaigomaebaraitkykarihyj(String pZrnkaigomaebaraitkykarihyj) {
        zrnkaigomaebaraitkykarihyj = pZrnkaigomaebaraitkykarihyj;
    }

    private String zrnsibouhyoukbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSIBOUHYOUKBN)
    public String getZrnsibouhyoukbn() {
        return zrnsibouhyoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsibouhyoukbn(String pZrnsibouhyoukbn) {
        zrnsibouhyoukbn = pZrnsibouhyoukbn;
    }

    private String zrnnyuukintuukakbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNNYUUKINTUUKAKBN)
    public String getZrnnyuukintuukakbn() {
        return zrnnyuukintuukakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnnyuukintuukakbn(String pZrnnyuukintuukakbn) {
        zrnnyuukintuukakbn = pZrnnyuukintuukakbn;
    }

    private String zrnsiharaituukakbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSIHARAITUUKAKBN)
    public String getZrnsiharaituukakbn() {
        return zrnsiharaituukakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsiharaituukakbn(String pZrnsiharaituukakbn) {
        zrnsiharaituukakbn = pZrnsiharaituukakbn;
    }

    private String zrnwyendttargetmokuhyouritu;

    @Column(name=GenZT_IdouMeisaiRn.ZRNWYENDTTARGETMOKUHYOURITU)
    public String getZrnwyendttargetmokuhyouritu() {
        return zrnwyendttargetmokuhyouritu;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrnwyendttargetmokuhyouritu(String pZrnwyendttargetmokuhyouritu) {
        zrnwyendttargetmokuhyouritu = pZrnwyendttargetmokuhyouritu;
    }

    private String zrnsisuurendourate;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSISUURENDOURATE)
    public String getZrnsisuurendourate() {
        return zrnsisuurendourate;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrnsisuurendourate(String pZrnsisuurendourate) {
        zrnsisuurendourate = pZrnsisuurendourate;
    }

    private String zrnsisuukbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSISUUKBN)
    public String getZrnsisuukbn() {
        return zrnsisuukbn;
    }

    public void setZrnsisuukbn(String pZrnsisuukbn) {
        zrnsisuukbn = pZrnsisuukbn;
    }

    private String zrnteirituikouhyouji;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTEIRITUIKOUHYOUJI)
    public String getZrnteirituikouhyouji() {
        return zrnteirituikouhyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnteirituikouhyouji(String pZrnteirituikouhyouji) {
        zrnteirituikouhyouji = pZrnteirituikouhyouji;
    }

    private String zrnsrdai1hknkkn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSRDAI1HKNKKN)
    public String getZrnsrdai1hknkkn() {
        return zrnsrdai1hknkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsrdai1hknkkn(String pZrnsrdai1hknkkn) {
        zrnsrdai1hknkkn = pZrnsrdai1hknkkn;
    }

    private String zrnsuuriyouyobin10x11;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSUURIYOUYOBIN10X11)
    public String getZrnsuuriyouyobin10x11() {
        return zrnsuuriyouyobin10x11;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnsuuriyouyobin10x11(String pZrnsuuriyouyobin10x11) {
        zrnsuuriyouyobin10x11 = pZrnsuuriyouyobin10x11;
    }

    private BizNumber zrntmttknzoukaritujygn;

    @Type(type="BizNumberType")
    @Column(name=GenZT_IdouMeisaiRn.ZRNTMTTKNZOUKARITUJYGN)
    public BizNumber getZrntmttknzoukaritujygn() {
        return zrntmttknzoukaritujygn;
    }

    public void setZrntmttknzoukaritujygn(BizNumber pZrntmttknzoukaritujygn) {
        zrntmttknzoukaritujygn = pZrntmttknzoukaritujygn;
    }

    private BizNumber zrnsetteibairitu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_IdouMeisaiRn.ZRNSETTEIBAIRITU)
    public BizNumber getZrnsetteibairitu() {
        return zrnsetteibairitu;
    }

    public void setZrnsetteibairitu(BizNumber pZrnsetteibairitu) {
        zrnsetteibairitu = pZrnsetteibairitu;
    }

    private BizNumber zrntykzenoutouymdsisuu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_IdouMeisaiRn.ZRNTYKZENOUTOUYMDSISUU)
    public BizNumber getZrntykzenoutouymdsisuu() {
        return zrntykzenoutouymdsisuu;
    }

    public void setZrntykzenoutouymdsisuu(BizNumber pZrntykzenoutouymdsisuu) {
        zrntykzenoutouymdsisuu = pZrntykzenoutouymdsisuu;
    }

    private BizNumber zrnkimatusisuu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_IdouMeisaiRn.ZRNKIMATUSISUU)
    public BizNumber getZrnkimatusisuu() {
        return zrnkimatusisuu;
    }

    public void setZrnkimatusisuu(BizNumber pZrnkimatusisuu) {
        zrnkimatusisuu = pZrnkimatusisuu;
    }

    private String zrntuukasyukbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTUUKASYUKBN)
    public String getZrntuukasyukbn() {
        return zrntuukasyukbn;
    }

    public void setZrntuukasyukbn(String pZrntuukasyukbn) {
        zrntuukasyukbn = pZrntuukasyukbn;
    }

    private String zrnyobiv2;

    @Column(name=GenZT_IdouMeisaiRn.ZRNYOBIV2)
    public String getZrnyobiv2() {
        return zrnyobiv2;
    }

    public void setZrnyobiv2(String pZrnyobiv2) {
        zrnyobiv2 = pZrnyobiv2;
    }

    private Long zrnyenkadatekihons;

    @Column(name=GenZT_IdouMeisaiRn.ZRNYENKADATEKIHONS)
    public Long getZrnyenkadatekihons() {
        return zrnyenkadatekihons;
    }

    public void setZrnyenkadatekihons(Long pZrnyenkadatekihons) {
        zrnyenkadatekihons = pZrnyenkadatekihons;
    }

    private Long zrnsitihsyumegkdtsibous;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSITIHSYUMEGKDTSIBOUS)
    public Long getZrnsitihsyumegkdtsibous() {
        return zrnsitihsyumegkdtsibous;
    }

    public void setZrnsitihsyumegkdtsibous(Long pZrnsitihsyumegkdtsibous) {
        zrnsitihsyumegkdtsibous = pZrnsitihsyumegkdtsibous;
    }

    private Long zrnenkdtssrentumitatekin;

    @Column(name=GenZT_IdouMeisaiRn.ZRNENKDTSSRENTUMITATEKIN)
    public Long getZrnenkdtssrentumitatekin() {
        return zrnenkdtssrentumitatekin;
    }

    public void setZrnenkdtssrentumitatekin(Long pZrnenkdtssrentumitatekin) {
        zrnenkdtssrentumitatekin = pZrnenkdtssrentumitatekin;
    }

    private Long zrnsisuurentumitatekin;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSISUURENTUMITATEKIN)
    public Long getZrnsisuurentumitatekin() {
        return zrnsisuurentumitatekin;
    }

    public void setZrnsisuurentumitatekin(Long pZrnsisuurentumitatekin) {
        zrnsisuurentumitatekin = pZrnsisuurentumitatekin;
    }

    private Long zrnnksjitirttumitatekin;

    @Column(name=GenZT_IdouMeisaiRn.ZRNNKSJITIRTTUMITATEKIN)
    public Long getZrnnksjitirttumitatekin() {
        return zrnnksjitirttumitatekin;
    }

    public void setZrnnksjitirttumitatekin(Long pZrnnksjitirttumitatekin) {
        zrnnksjitirttumitatekin = pZrnnksjitirttumitatekin;
    }

    private Long zrnkimatutirttumitatekin;

    @Column(name=GenZT_IdouMeisaiRn.ZRNKIMATUTIRTTUMITATEKIN)
    public Long getZrnkimatutirttumitatekin() {
        return zrnkimatutirttumitatekin;
    }

    public void setZrnkimatutirttumitatekin(Long pZrnkimatutirttumitatekin) {
        zrnkimatutirttumitatekin = pZrnkimatutirttumitatekin;
    }

    private Long zrngaikadatejyuutoup;

    @Column(name=GenZT_IdouMeisaiRn.ZRNGAIKADATEJYUUTOUP)
    public Long getZrngaikadatejyuutoup() {
        return zrngaikadatejyuutoup;
    }

    public void setZrngaikadatejyuutoup(Long pZrngaikadatejyuutoup) {
        zrngaikadatejyuutoup = pZrngaikadatejyuutoup;
    }

    private Long zrnyendttargetkijyunkingaku;

    @Column(name=GenZT_IdouMeisaiRn.ZRNYENDTTARGETKIJYUNKINGAKU)
    public Long getZrnyendttargetkijyunkingaku() {
        return zrnyendttargetkijyunkingaku;
    }

    public void setZrnyendttargetkijyunkingaku(Long pZrnyendttargetkijyunkingaku) {
        zrnyendttargetkijyunkingaku = pZrnyendttargetkijyunkingaku;
    }

    private String zrnyobiv7;

    @Column(name=GenZT_IdouMeisaiRn.ZRNYOBIV7)
    public String getZrnyobiv7() {
        return zrnyobiv7;
    }

    public void setZrnyobiv7(String pZrnyobiv7) {
        zrnyobiv7 = pZrnyobiv7;
    }

    private BizNumber zrnsitivkisnyukykjikwsrate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_IdouMeisaiRn.ZRNSITIVKISNYUKYKJIKWSRATE)
    public BizNumber getZrnsitivkisnyukykjikwsrate() {
        return zrnsitivkisnyukykjikwsrate;
    }

    public void setZrnsitivkisnyukykjikwsrate(BizNumber pZrnsitivkisnyukykjikwsrate) {
        zrnsitivkisnyukykjikwsrate = pZrnsitivkisnyukykjikwsrate;
    }

    private Long zrnsisuurentyokugotmttkn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSISUURENTYOKUGOTMTTKN)
    public Long getZrnsisuurentyokugotmttkn() {
        return zrnsisuurentyokugotmttkn;
    }

    public void setZrnsisuurentyokugotmttkn(Long pZrnsisuurentyokugotmttkn) {
        zrnsisuurentyokugotmttkn = pZrnsisuurentyokugotmttkn;
    }

    private BizNumber zrnyoteiririturironbase;

    @Type(type="BizNumberType")
    @Column(name=GenZT_IdouMeisaiRn.ZRNYOTEIRIRITURIRONBASE)
    public BizNumber getZrnyoteiririturironbase() {
        return zrnyoteiririturironbase;
    }

    public void setZrnyoteiririturironbase(BizNumber pZrnyoteiririturironbase) {
        zrnyoteiririturironbase = pZrnyoteiririturironbase;
    }

    private BizNumber zrnyoteiriritujtnyknbase;

    @Type(type="BizNumberType")
    @Column(name=GenZT_IdouMeisaiRn.ZRNYOTEIRIRITUJTNYKNBASE)
    public BizNumber getZrnyoteiriritujtnyknbase() {
        return zrnyoteiriritujtnyknbase;
    }

    public void setZrnyoteiriritujtnyknbase(BizNumber pZrnyoteiriritujtnyknbase) {
        zrnyoteiriritujtnyknbase = pZrnyoteiriritujtnyknbase;
    }

    private Long zrnkihrkmpjtnyknbase;

    @Column(name=GenZT_IdouMeisaiRn.ZRNKIHRKMPJTNYKNBASE)
    public Long getZrnkihrkmpjtnyknbase() {
        return zrnkihrkmpjtnyknbase;
    }

    public void setZrnkihrkmpjtnyknbase(Long pZrnkihrkmpjtnyknbase) {
        zrnkihrkmpjtnyknbase = pZrnkihrkmpjtnyknbase;
    }

    private Long zrnsyuptumitatekin;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSYUPTUMITATEKIN)
    public Long getZrnsyuptumitatekin() {
        return zrnsyuptumitatekin;
    }

    public void setZrnsyuptumitatekin(Long pZrnsyuptumitatekin) {
        zrnsyuptumitatekin = pZrnsyuptumitatekin;
    }

    private Long zrnsyuptumitatekingsc;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSYUPTUMITATEKINGSC)
    public Long getZrnsyuptumitatekingsc() {
        return zrnsyuptumitatekingsc;
    }

    public void setZrnsyuptumitatekingsc(Long pZrnsyuptumitatekingsc) {
        zrnsyuptumitatekingsc = pZrnsyuptumitatekingsc;
    }

    private Long zrngaikadatenkgns;

    @Column(name=GenZT_IdouMeisaiRn.ZRNGAIKADATENKGNS)
    public Long getZrngaikadatenkgns() {
        return zrngaikadatenkgns;
    }

    public void setZrngaikadatenkgns(Long pZrngaikadatenkgns) {
        zrngaikadatenkgns = pZrngaikadatenkgns;
    }

    private String zrnjikaipjyuutouym2;

    @Column(name=GenZT_IdouMeisaiRn.ZRNJIKAIPJYUUTOUYM2)
    public String getZrnjikaipjyuutouym2() {
        return zrnjikaipjyuutouym2;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrnjikaipjyuutouym2(String pZrnjikaipjyuutouym2) {
        zrnjikaipjyuutouym2 = pZrnjikaipjyuutouym2;
    }

    private Integer zrnsuuriyobin9;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSUURIYOBIN9)
    public Integer getZrnsuuriyobin9() {
        return zrnsuuriyobin9;
    }

    public void setZrnsuuriyobin9(Integer pZrnsuuriyobin9) {
        zrnsuuriyobin9 = pZrnsuuriyobin9;
    }

    private Long zrngessitumitatekin;

    @Column(name=GenZT_IdouMeisaiRn.ZRNGESSITUMITATEKIN)
    public Long getZrngessitumitatekin() {
        return zrngessitumitatekin;
    }

    public void setZrngessitumitatekin(Long pZrngessitumitatekin) {
        zrngessitumitatekin = pZrngessitumitatekin;
    }

    private Long zrngaikadatetougetujuutoup;

    @Column(name=GenZT_IdouMeisaiRn.ZRNGAIKADATETOUGETUJUUTOUP)
    public Long getZrngaikadatetougetujuutoup() {
        return zrngaikadatetougetujuutoup;
    }

    public void setZrngaikadatetougetujuutoup(Long pZrngaikadatetougetujuutoup) {
        zrngaikadatetougetujuutoup = pZrngaikadatetougetujuutoup;
    }

    private Long zrnkihrkmpmsukisymbase;

    @Column(name=GenZT_IdouMeisaiRn.ZRNKIHRKMPMSUKISYMBASE)
    public Long getZrnkihrkmpmsukisymbase() {
        return zrnkihrkmpmsukisymbase;
    }

    public void setZrnkihrkmpmsukisymbase(Long pZrnkihrkmpmsukisymbase) {
        zrnkihrkmpmsukisymbase = pZrnkihrkmpmsukisymbase;
    }

    private Long zrnkeisanhanteiyoutmttkn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNKEISANHANTEIYOUTMTTKN)
    public Long getZrnkeisanhanteiyoutmttkn() {
        return zrnkeisanhanteiyoutmttkn;
    }

    public void setZrnkeisanhanteiyoutmttkn(Long pZrnkeisanhanteiyoutmttkn) {
        zrnkeisanhanteiyoutmttkn = pZrnkeisanhanteiyoutmttkn;
    }

    private Long zrngtmtv;

    @Column(name=GenZT_IdouMeisaiRn.ZRNGTMTV)
    public Long getZrngtmtv() {
        return zrngtmtv;
    }

    public void setZrngtmtv(Long pZrngtmtv) {
        zrngtmtv = pZrngtmtv;
    }

    private BizNumber zrnzettaisibouritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_IdouMeisaiRn.ZRNZETTAISIBOURITU)
    public BizNumber getZrnzettaisibouritu() {
        return zrnzettaisibouritu;
    }

    public void setZrnzettaisibouritu(BizNumber pZrnzettaisibouritu) {
        zrnzettaisibouritu = pZrnzettaisibouritu;
    }

    private BizNumber zrnsoutaisibouritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_IdouMeisaiRn.ZRNSOUTAISIBOURITU)
    public BizNumber getZrnsoutaisibouritu() {
        return zrnsoutaisibouritu;
    }

    public void setZrnsoutaisibouritu(BizNumber pZrnsoutaisibouritu) {
        zrnsoutaisibouritu = pZrnsoutaisibouritu;
    }

    private BizNumber zrnsoutaikaiyakuritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_IdouMeisaiRn.ZRNSOUTAIKAIYAKURITU)
    public BizNumber getZrnsoutaikaiyakuritu() {
        return zrnsoutaikaiyakuritu;
    }

    public void setZrnsoutaikaiyakuritu(BizNumber pZrnsoutaikaiyakuritu) {
        zrnsoutaikaiyakuritu = pZrnsoutaikaiyakuritu;
    }

    private BizNumber zrnvhireilritu2;

    @Type(type="BizNumberType")
    @Column(name=GenZT_IdouMeisaiRn.ZRNVHIREILRITU2)
    public BizNumber getZrnvhireilritu2() {
        return zrnvhireilritu2;
    }

    public void setZrnvhireilritu2(BizNumber pZrnvhireilritu2) {
        zrnvhireilritu2 = pZrnvhireilritu2;
    }

    private BizNumber zrnphireialpha;

    @Type(type="BizNumberType")
    @Column(name=GenZT_IdouMeisaiRn.ZRNPHIREIALPHA)
    public BizNumber getZrnphireialpha() {
        return zrnphireialpha;
    }

    public void setZrnphireialpha(BizNumber pZrnphireialpha) {
        zrnphireialpha = pZrnphireialpha;
    }

    private BizNumber zrnphireibeta;

    @Type(type="BizNumberType")
    @Column(name=GenZT_IdouMeisaiRn.ZRNPHIREIBETA)
    public BizNumber getZrnphireibeta() {
        return zrnphireibeta;
    }

    public void setZrnphireibeta(BizNumber pZrnphireibeta) {
        zrnphireibeta = pZrnphireibeta;
    }

    private BizNumber zrnphireiganma;

    @Type(type="BizNumberType")
    @Column(name=GenZT_IdouMeisaiRn.ZRNPHIREIGANMA)
    public BizNumber getZrnphireiganma() {
        return zrnphireiganma;
    }

    public void setZrnphireiganma(BizNumber pZrnphireiganma) {
        zrnphireiganma = pZrnphireiganma;
    }

    private BizNumber zrnphireilwrbkritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_IdouMeisaiRn.ZRNPHIREILWRBKRITU)
    public BizNumber getZrnphireilwrbkritu() {
        return zrnphireilwrbkritu;
    }

    public void setZrnphireilwrbkritu(BizNumber pZrnphireilwrbkritu) {
        zrnphireilwrbkritu = pZrnphireilwrbkritu;
    }

    private BizNumber zrnyoteiriritumsukisymbase;

    @Type(type="BizNumberType")
    @Column(name=GenZT_IdouMeisaiRn.ZRNYOTEIRIRITUMSUKISYMBASE)
    public BizNumber getZrnyoteiriritumsukisymbase() {
        return zrnyoteiriritumsukisymbase;
    }

    public void setZrnyoteiriritumsukisymbase(BizNumber pZrnyoteiriritumsukisymbase) {
        zrnyoteiriritumsukisymbase = pZrnyoteiriritumsukisymbase;
    }

    private Long zrnrrthnduhknvkisovkisnyu1;

    @Column(name=GenZT_IdouMeisaiRn.ZRNRRTHNDUHKNVKISOVKISNYU1)
    public Long getZrnrrthnduhknvkisovkisnyu1() {
        return zrnrrthnduhknvkisovkisnyu1;
    }

    public void setZrnrrthnduhknvkisovkisnyu1(Long pZrnrrthnduhknvkisovkisnyu1) {
        zrnrrthnduhknvkisovkisnyu1 = pZrnrrthnduhknvkisovkisnyu1;
    }

    private Long zrnrrthnduhknvkisovkisnyu2;

    @Column(name=GenZT_IdouMeisaiRn.ZRNRRTHNDUHKNVKISOVKISNYU2)
    public Long getZrnrrthnduhknvkisovkisnyu2() {
        return zrnrrthnduhknvkisovkisnyu2;
    }

    public void setZrnrrthnduhknvkisovkisnyu2(Long pZrnrrthnduhknvkisovkisnyu2) {
        zrnrrthnduhknvkisovkisnyu2 = pZrnrrthnduhknvkisovkisnyu2;
    }

    private Long zrnrrthnduhknvkisovkisnyu3;

    @Column(name=GenZT_IdouMeisaiRn.ZRNRRTHNDUHKNVKISOVKISNYU3)
    public Long getZrnrrthnduhknvkisovkisnyu3() {
        return zrnrrthnduhknvkisovkisnyu3;
    }

    public void setZrnrrthnduhknvkisovkisnyu3(Long pZrnrrthnduhknvkisovkisnyu3) {
        zrnrrthnduhknvkisovkisnyu3 = pZrnrrthnduhknvkisovkisnyu3;
    }

    private Long zrnrrthnduhknvkisovkisnyu4;

    @Column(name=GenZT_IdouMeisaiRn.ZRNRRTHNDUHKNVKISOVKISNYU4)
    public Long getZrnrrthnduhknvkisovkisnyu4() {
        return zrnrrthnduhknvkisovkisnyu4;
    }

    public void setZrnrrthnduhknvkisovkisnyu4(Long pZrnrrthnduhknvkisovkisnyu4) {
        zrnrrthnduhknvkisovkisnyu4 = pZrnrrthnduhknvkisovkisnyu4;
    }

    private Long zrnrrthnduhknvkiso;

    @Column(name=GenZT_IdouMeisaiRn.ZRNRRTHNDUHKNVKISO)
    public Long getZrnrrthnduhknvkiso() {
        return zrnrrthnduhknvkiso;
    }

    public void setZrnrrthnduhknvkiso(Long pZrnrrthnduhknvkiso) {
        zrnrrthnduhknvkiso = pZrnrrthnduhknvkiso;
    }

    private Long zrntumitatekin;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTUMITATEKIN)
    public Long getZrntumitatekin() {
        return zrntumitatekin;
    }

    public void setZrntumitatekin(Long pZrntumitatekin) {
        zrntumitatekin = pZrntumitatekin;
    }

    private Long zrnkiharaikomip;

    @Column(name=GenZT_IdouMeisaiRn.ZRNKIHARAIKOMIP)
    public Long getZrnkiharaikomip() {
        return zrnkiharaikomip;
    }

    public void setZrnkiharaikomip(Long pZrnkiharaikomip) {
        zrnkiharaikomip = pZrnkiharaikomip;
    }

    private Long zrngaikadatesyukeiyakup;

    @Column(name=GenZT_IdouMeisaiRn.ZRNGAIKADATESYUKEIYAKUP)
    public Long getZrngaikadatesyukeiyakup() {
        return zrngaikadatesyukeiyakup;
    }

    public void setZrngaikadatesyukeiyakup(Long pZrngaikadatesyukeiyakup) {
        zrngaikadatesyukeiyakup = pZrngaikadatesyukeiyakup;
    }

    private Long zrnkykkjmmvatyouseigow;

    @Column(name=GenZT_IdouMeisaiRn.ZRNKYKKJMMVATYOUSEIGOW)
    public Long getZrnkykkjmmvatyouseigow() {
        return zrnkykkjmmvatyouseigow;
    }

    public void setZrnkykkjmmvatyouseigow(Long pZrnkykkjmmvatyouseigow) {
        zrnkykkjmmvatyouseigow = pZrnkykkjmmvatyouseigow;
    }

    private Long zrnyobin11x39;

    @Column(name=GenZT_IdouMeisaiRn.ZRNYOBIN11X39)
    public Long getZrnyobin11x39() {
        return zrnyobin11x39;
    }

    public void setZrnyobin11x39(Long pZrnyobin11x39) {
        zrnyobin11x39 = pZrnyobin11x39;
    }

    private Long zrnyobin11x41;

    @Column(name=GenZT_IdouMeisaiRn.ZRNYOBIN11X41)
    public Long getZrnyobin11x41() {
        return zrnyobin11x41;
    }

    public void setZrnyobin11x41(Long pZrnyobin11x41) {
        zrnyobin11x41 = pZrnyobin11x41;
    }

    private Long zrnyobin11x42;

    @Column(name=GenZT_IdouMeisaiRn.ZRNYOBIN11X42)
    public Long getZrnyobin11x42() {
        return zrnyobin11x42;
    }

    public void setZrnyobin11x42(Long pZrnyobin11x42) {
        zrnyobin11x42 = pZrnyobin11x42;
    }

    private Long zrnyobin11x43;

    @Column(name=GenZT_IdouMeisaiRn.ZRNYOBIN11X43)
    public Long getZrnyobin11x43() {
        return zrnyobin11x43;
    }

    public void setZrnyobin11x43(Long pZrnyobin11x43) {
        zrnyobin11x43 = pZrnyobin11x43;
    }

    private Long zrnyobin11x44;

    @Column(name=GenZT_IdouMeisaiRn.ZRNYOBIN11X44)
    public Long getZrnyobin11x44() {
        return zrnyobin11x44;
    }

    public void setZrnyobin11x44(Long pZrnyobin11x44) {
        zrnyobin11x44 = pZrnyobin11x44;
    }

    private Long zrnyobin11x45;

    @Column(name=GenZT_IdouMeisaiRn.ZRNYOBIN11X45)
    public Long getZrnyobin11x45() {
        return zrnyobin11x45;
    }

    public void setZrnyobin11x45(Long pZrnyobin11x45) {
        zrnyobin11x45 = pZrnyobin11x45;
    }

    private String zrnsuuriyouyobin15x3;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSUURIYOUYOBIN15X3)
    public String getZrnsuuriyouyobin15x3() {
        return zrnsuuriyouyobin15x3;
    }

    @Padding(mode = "left", padChar = '0', length = 15)
    public void setZrnsuuriyouyobin15x3(String pZrnsuuriyouyobin15x3) {
        zrnsuuriyouyobin15x3 = pZrnsuuriyouyobin15x3;
    }

    private String zrnsuuriyouyobin15x4;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSUURIYOUYOBIN15X4)
    public String getZrnsuuriyouyobin15x4() {
        return zrnsuuriyouyobin15x4;
    }

    @Padding(mode = "left", padChar = '0', length = 15)
    public void setZrnsuuriyouyobin15x4(String pZrnsuuriyouyobin15x4) {
        zrnsuuriyouyobin15x4 = pZrnsuuriyouyobin15x4;
    }

    private String zrnsuuriyouyobin15x5;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSUURIYOUYOBIN15X5)
    public String getZrnsuuriyouyobin15x5() {
        return zrnsuuriyouyobin15x5;
    }

    @Padding(mode = "left", padChar = '0', length = 15)
    public void setZrnsuuriyouyobin15x5(String pZrnsuuriyouyobin15x5) {
        zrnsuuriyouyobin15x5 = pZrnsuuriyouyobin15x5;
    }

    private String zrnsuuriyouyobin15x6;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSUURIYOUYOBIN15X6)
    public String getZrnsuuriyouyobin15x6() {
        return zrnsuuriyouyobin15x6;
    }

    @Padding(mode = "left", padChar = '0', length = 15)
    public void setZrnsuuriyouyobin15x6(String pZrnsuuriyouyobin15x6) {
        zrnsuuriyouyobin15x6 = pZrnsuuriyouyobin15x6;
    }

    private String zrnyobiv14;

    @Column(name=GenZT_IdouMeisaiRn.ZRNYOBIV14)
    public String getZrnyobiv14() {
        return zrnyobiv14;
    }

    public void setZrnyobiv14(String pZrnyobiv14) {
        zrnyobiv14 = pZrnyobiv14;
    }

    private String zrnkyksyhhknsydouituhyouji;

    @Column(name=GenZT_IdouMeisaiRn.ZRNKYKSYHHKNSYDOUITUHYOUJI)
    public String getZrnkyksyhhknsydouituhyouji() {
        return zrnkyksyhhknsydouituhyouji;
    }

    public void setZrnkyksyhhknsydouituhyouji(String pZrnkyksyhhknsydouituhyouji) {
        zrnkyksyhhknsydouituhyouji = pZrnkyksyhhknsydouituhyouji;
    }

    private String zrnkyksyaskinmeino;

    @Column(name=GenZT_IdouMeisaiRn.ZRNKYKSYASKINMEINO)
    public String getZrnkyksyaskinmeino() {
        return zrnkyksyaskinmeino;
    }

    public void setZrnkyksyaskinmeino(String pZrnkyksyaskinmeino) {
        zrnkyksyaskinmeino = pZrnkyksyaskinmeino;
    }

    private Long zrngoukeikihons;

    @Column(name=GenZT_IdouMeisaiRn.ZRNGOUKEIKIHONS)
    public Long getZrngoukeikihons() {
        return zrngoukeikihons;
    }

    public void setZrngoukeikihons(Long pZrngoukeikihons) {
        zrngoukeikihons = pZrngoukeikihons;
    }

    private Long zrngoukeigyousekihyjsibous;

    @Column(name=GenZT_IdouMeisaiRn.ZRNGOUKEIGYOUSEKIHYJSIBOUS)
    public Long getZrngoukeigyousekihyjsibous() {
        return zrngoukeigyousekihyjsibous;
    }

    public void setZrngoukeigyousekihyjsibous(Long pZrngoukeigyousekihyjsibous) {
        zrngoukeigyousekihyjsibous = pZrngoukeigyousekihyjsibous;
    }

    private Long zrnalmyousibous;

    @Column(name=GenZT_IdouMeisaiRn.ZRNALMYOUSIBOUS)
    public Long getZrnalmyousibous() {
        return zrnalmyousibous;
    }

    public void setZrnalmyousibous(Long pZrnalmyousibous) {
        zrnalmyousibous = pZrnalmyousibous;
    }

    private Long zrnharaikomip;

    @Column(name=GenZT_IdouMeisaiRn.ZRNHARAIKOMIP)
    public Long getZrnharaikomip() {
        return zrnharaikomip;
    }

    public void setZrnharaikomip(Long pZrnharaikomip) {
        zrnharaikomip = pZrnharaikomip;
    }

    private Long zrnsiteizukiharaikomip;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSITEIZUKIHARAIKOMIP)
    public Long getZrnsiteizukiharaikomip() {
        return zrnsiteizukiharaikomip;
    }

    public void setZrnsiteizukiharaikomip(Long pZrnsiteizukiharaikomip) {
        zrnsiteizukiharaikomip = pZrnsiteizukiharaikomip;
    }

    private Long zrnsaisyuusiteimhrkp;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSAISYUUSITEIMHRKP)
    public Long getZrnsaisyuusiteimhrkp() {
        return zrnsaisyuusiteimhrkp;
    }

    public void setZrnsaisyuusiteimhrkp(Long pZrnsaisyuusiteimhrkp) {
        zrnsaisyuusiteimhrkp = pZrnsaisyuusiteimhrkp;
    }

    private Long zrngoukeinenbaraikansanp;

    @Column(name=GenZT_IdouMeisaiRn.ZRNGOUKEINENBARAIKANSANP)
    public Long getZrngoukeinenbaraikansanp() {
        return zrngoukeinenbaraikansanp;
    }

    public void setZrngoukeinenbaraikansanp(Long pZrngoukeinenbaraikansanp) {
        zrngoukeinenbaraikansanp = pZrngoukeinenbaraikansanp;
    }

    private String zrngyousekihyoujisrank;

    @Column(name=GenZT_IdouMeisaiRn.ZRNGYOUSEKIHYOUJISRANK)
    public String getZrngyousekihyoujisrank() {
        return zrngyousekihyoujisrank;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrngyousekihyoujisrank(String pZrngyousekihyoujisrank) {
        zrngyousekihyoujisrank = pZrngyousekihyoujisrank;
    }

    private BizNumber zrnteikibairitu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_IdouMeisaiRn.ZRNTEIKIBAIRITU)
    public BizNumber getZrnteikibairitu() {
        return zrnteikibairitu;
    }

    public void setZrnteikibairitu(BizNumber pZrnteikibairitu) {
        zrnteikibairitu = pZrnteikibairitu;
    }

    private String zrntenkangodatakanrino;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTENKANGODATAKANRINO)
    public String getZrntenkangodatakanrino() {
        return zrntenkangodatakanrino;
    }

    @Padding(mode = "left", padChar = '0', length = 11)
    public void setZrntenkangodatakanrino(String pZrntenkangodatakanrino) {
        zrntenkangodatakanrino = pZrntenkangodatakanrino;
    }

    private String zrnaitekykdatakanrino1;

    @Column(name=GenZT_IdouMeisaiRn.ZRNAITEKYKDATAKANRINO1)
    public String getZrnaitekykdatakanrino1() {
        return zrnaitekykdatakanrino1;
    }

    @Padding(mode = "left", padChar = '0', length = 11)
    public void setZrnaitekykdatakanrino1(String pZrnaitekykdatakanrino1) {
        zrnaitekykdatakanrino1 = pZrnaitekykdatakanrino1;
    }

    private String zrnaitekykdatakanrino2;

    @Column(name=GenZT_IdouMeisaiRn.ZRNAITEKYKDATAKANRINO2)
    public String getZrnaitekykdatakanrino2() {
        return zrnaitekykdatakanrino2;
    }

    @Padding(mode = "left", padChar = '0', length = 11)
    public void setZrnaitekykdatakanrino2(String pZrnaitekykdatakanrino2) {
        zrnaitekykdatakanrino2 = pZrnaitekykdatakanrino2;
    }

    private String zrntnknsyokaipcashlesshyj;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTNKNSYOKAIPCASHLESSHYJ)
    public String getZrntnknsyokaipcashlesshyj() {
        return zrntnknsyokaipcashlesshyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntnknsyokaipcashlesshyj(String pZrntnknsyokaipcashlesshyj) {
        zrntnknsyokaipcashlesshyj = pZrntnknsyokaipcashlesshyj;
    }

    private String zrnsyokaipannaikbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSYOKAIPANNAIKBN)
    public String getZrnsyokaipannaikbn() {
        return zrnsyokaipannaikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsyokaipannaikbn(String pZrnsyokaipannaikbn) {
        zrnsyokaipannaikbn = pZrnsyokaipannaikbn;
    }

    private String zrnzennoukaisiymd;

    @Column(name=GenZT_IdouMeisaiRn.ZRNZENNOUKAISIYMD)
    public String getZrnzennoukaisiymd() {
        return zrnzennoukaisiymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnzennoukaisiymd(String pZrnzennoukaisiymd) {
        zrnzennoukaisiymd = pZrnzennoukaisiymd;
    }

    private String zrnzennoukikan;

    @Column(name=GenZT_IdouMeisaiRn.ZRNZENNOUKIKAN)
    public String getZrnzennoukikan() {
        return zrnzennoukikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnzennoukikan(String pZrnzennoukikan) {
        zrnzennoukikan = pZrnzennoukikan;
    }

    private String zrnseizonkyuuhukinsiteiy;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSEIZONKYUUHUKINSITEIY)
    public String getZrnseizonkyuuhukinsiteiy() {
        return zrnseizonkyuuhukinsiteiy;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrnseizonkyuuhukinsiteiy(String pZrnseizonkyuuhukinsiteiy) {
        zrnseizonkyuuhukinsiteiy = pZrnseizonkyuuhukinsiteiy;
    }

    private String zrnalmyouseizonkyhknsiteimd;

    @Column(name=GenZT_IdouMeisaiRn.ZRNALMYOUSEIZONKYHKNSITEIMD)
    public String getZrnalmyouseizonkyhknsiteimd() {
        return zrnalmyouseizonkyhknsiteimd;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrnalmyouseizonkyhknsiteimd(String pZrnalmyouseizonkyhknsiteimd) {
        zrnalmyouseizonkyhknsiteimd = pZrnalmyouseizonkyhknsiteimd;
    }

    private String zrnjikaipjyuutouym;

    @Column(name=GenZT_IdouMeisaiRn.ZRNJIKAIPJYUUTOUYM)
    public String getZrnjikaipjyuutouym() {
        return zrnjikaipjyuutouym;
    }

    public void setZrnjikaipjyuutouym(String pZrnjikaipjyuutouym) {
        zrnjikaipjyuutouym = pZrnjikaipjyuutouym;
    }

    private String zrnkykjiqpackhyj;

    @Column(name=GenZT_IdouMeisaiRn.ZRNKYKJIQPACKHYJ)
    public String getZrnkykjiqpackhyj() {
        return zrnkykjiqpackhyj;
    }

    public void setZrnkykjiqpackhyj(String pZrnkykjiqpackhyj) {
        zrnkykjiqpackhyj = pZrnkykjiqpackhyj;
    }

    private String zrnhktgtikkikkkn3x1;

    @Column(name=GenZT_IdouMeisaiRn.ZRNHKTGTIKKIKKKN3X1)
    public String getZrnhktgtikkikkkn3x1() {
        return zrnhktgtikkikkkn3x1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhktgtikkikkkn3x1(String pZrnhktgtikkikkkn3x1) {
        zrnhktgtikkikkkn3x1 = pZrnhktgtikkikkkn3x1;
    }

    private String zrnhktgtikkikkkn3x2;

    @Column(name=GenZT_IdouMeisaiRn.ZRNHKTGTIKKIKKKN3X2)
    public String getZrnhktgtikkikkkn3x2() {
        return zrnhktgtikkikkkn3x2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhktgtikkikkkn3x2(String pZrnhktgtikkikkkn3x2) {
        zrnhktgtikkikkkn3x2 = pZrnhktgtikkikkkn3x2;
    }

    private String zrnhktgtikkikkkn3x3;

    @Column(name=GenZT_IdouMeisaiRn.ZRNHKTGTIKKIKKKN3X3)
    public String getZrnhktgtikkikkkn3x3() {
        return zrnhktgtikkikkkn3x3;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhktgtikkikkkn3x3(String pZrnhktgtikkikkkn3x3) {
        zrnhktgtikkikkkn3x3 = pZrnhktgtikkikkkn3x3;
    }

    private String zrnhktgtikkikkkn3x4;

    @Column(name=GenZT_IdouMeisaiRn.ZRNHKTGTIKKIKKKN3X4)
    public String getZrnhktgtikkikkkn3x4() {
        return zrnhktgtikkikkkn3x4;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhktgtikkikkkn3x4(String pZrnhktgtikkikkkn3x4) {
        zrnhktgtikkikkkn3x4 = pZrnhktgtikkikkkn3x4;
    }

    private String zrnkappadkeisankbnx1;

    @Column(name=GenZT_IdouMeisaiRn.ZRNKAPPADKEISANKBNX1)
    public String getZrnkappadkeisankbnx1() {
        return zrnkappadkeisankbnx1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkappadkeisankbnx1(String pZrnkappadkeisankbnx1) {
        zrnkappadkeisankbnx1 = pZrnkappadkeisankbnx1;
    }

    private String zrnkappadkeisankbnx2;

    @Column(name=GenZT_IdouMeisaiRn.ZRNKAPPADKEISANKBNX2)
    public String getZrnkappadkeisankbnx2() {
        return zrnkappadkeisankbnx2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkappadkeisankbnx2(String pZrnkappadkeisankbnx2) {
        zrnkappadkeisankbnx2 = pZrnkappadkeisankbnx2;
    }

    private String zrnkappadkeisankbnx3;

    @Column(name=GenZT_IdouMeisaiRn.ZRNKAPPADKEISANKBNX3)
    public String getZrnkappadkeisankbnx3() {
        return zrnkappadkeisankbnx3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkappadkeisankbnx3(String pZrnkappadkeisankbnx3) {
        zrnkappadkeisankbnx3 = pZrnkappadkeisankbnx3;
    }

    private String zrnkappadkeisankbnx4;

    @Column(name=GenZT_IdouMeisaiRn.ZRNKAPPADKEISANKBNX4)
    public String getZrnkappadkeisankbnx4() {
        return zrnkappadkeisankbnx4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkappadkeisankbnx4(String pZrnkappadkeisankbnx4) {
        zrnkappadkeisankbnx4 = pZrnkappadkeisankbnx4;
    }

    private String zrnsuuriyouyobin2;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSUURIYOUYOBIN2)
    public String getZrnsuuriyouyobin2() {
        return zrnsuuriyouyobin2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsuuriyouyobin2(String pZrnsuuriyouyobin2) {
        zrnsuuriyouyobin2 = pZrnsuuriyouyobin2;
    }

    private String zrnyobiv6x3;

    @Column(name=GenZT_IdouMeisaiRn.ZRNYOBIV6X3)
    public String getZrnyobiv6x3() {
        return zrnyobiv6x3;
    }

    public void setZrnyobiv6x3(String pZrnyobiv6x3) {
        zrnyobiv6x3 = pZrnyobiv6x3;
    }

    private Long zrnkimatuvyoutumimasikin;

    @Column(name=GenZT_IdouMeisaiRn.ZRNKIMATUVYOUTUMIMASIKIN)
    public Long getZrnkimatuvyoutumimasikin() {
        return zrnkimatuvyoutumimasikin;
    }

    public void setZrnkimatuvyoutumimasikin(Long pZrnkimatuvyoutumimasikin) {
        zrnkimatuvyoutumimasikin = pZrnkimatuvyoutumimasikin;
    }

    private Long zrnkmtvyusnhknfundtmttkin;

    @Column(name=GenZT_IdouMeisaiRn.ZRNKMTVYUSNHKNFUNDTMTTKIN)
    public Long getZrnkmtvyusnhknfundtmttkin() {
        return zrnkmtvyusnhknfundtmttkin;
    }

    public void setZrnkmtvyusnhknfundtmttkin(Long pZrnkmtvyusnhknfundtmttkin) {
        zrnkmtvyusnhknfundtmttkin = pZrnkmtvyusnhknfundtmttkin;
    }

    private Long zrngoukeinenkansanp3x1;

    @Column(name=GenZT_IdouMeisaiRn.ZRNGOUKEINENKANSANP3X1)
    public Long getZrngoukeinenkansanp3x1() {
        return zrngoukeinenkansanp3x1;
    }

    public void setZrngoukeinenkansanp3x1(Long pZrngoukeinenkansanp3x1) {
        zrngoukeinenkansanp3x1 = pZrngoukeinenkansanp3x1;
    }

    private Long zrngoukeinenkansanp3x2;

    @Column(name=GenZT_IdouMeisaiRn.ZRNGOUKEINENKANSANP3X2)
    public Long getZrngoukeinenkansanp3x2() {
        return zrngoukeinenkansanp3x2;
    }

    public void setZrngoukeinenkansanp3x2(Long pZrngoukeinenkansanp3x2) {
        zrngoukeinenkansanp3x2 = pZrngoukeinenkansanp3x2;
    }

    private Long zrngoukeinenkansanp3x3;

    @Column(name=GenZT_IdouMeisaiRn.ZRNGOUKEINENKANSANP3X3)
    public Long getZrngoukeinenkansanp3x3() {
        return zrngoukeinenkansanp3x3;
    }

    public void setZrngoukeinenkansanp3x3(Long pZrngoukeinenkansanp3x3) {
        zrngoukeinenkansanp3x3 = pZrngoukeinenkansanp3x3;
    }

    private Long zrngoukeinenkansanp3x4;

    @Column(name=GenZT_IdouMeisaiRn.ZRNGOUKEINENKANSANP3X4)
    public Long getZrngoukeinenkansanp3x4() {
        return zrngoukeinenkansanp3x4;
    }

    public void setZrngoukeinenkansanp3x4(Long pZrngoukeinenkansanp3x4) {
        zrngoukeinenkansanp3x4 = pZrngoukeinenkansanp3x4;
    }

    private Long zrnkmtvyuhijynbritmttkin;

    @Column(name=GenZT_IdouMeisaiRn.ZRNKMTVYUHIJYNBRITMTTKIN)
    public Long getZrnkmtvyuhijynbritmttkin() {
        return zrnkmtvyuhijynbritmttkin;
    }

    public void setZrnkmtvyuhijynbritmttkin(Long pZrnkmtvyuhijynbritmttkin) {
        zrnkmtvyuhijynbritmttkin = pZrnkmtvyuhijynbritmttkin;
    }

    private Long zrnkimatuvyouitjbrtmttkin;

    @Column(name=GenZT_IdouMeisaiRn.ZRNKIMATUVYOUITJBRTMTTKIN)
    public Long getZrnkimatuvyouitjbrtmttkin() {
        return zrnkimatuvyouitjbrtmttkin;
    }

    public void setZrnkimatuvyouitjbrtmttkin(Long pZrnkimatuvyouitjbrtmttkin) {
        zrnkimatuvyouitjbrtmttkin = pZrnkimatuvyouitjbrtmttkin;
    }

    private Long zrnyobin11x26;

    @Column(name=GenZT_IdouMeisaiRn.ZRNYOBIN11X26)
    public Long getZrnyobin11x26() {
        return zrnyobin11x26;
    }

    public void setZrnyobin11x26(Long pZrnyobin11x26) {
        zrnyobin11x26 = pZrnyobin11x26;
    }

    private Long zrnyobin11x27;

    @Column(name=GenZT_IdouMeisaiRn.ZRNYOBIN11X27)
    public Long getZrnyobin11x27() {
        return zrnyobin11x27;
    }

    public void setZrnyobin11x27(Long pZrnyobin11x27) {
        zrnyobin11x27 = pZrnyobin11x27;
    }

    private Long zrnyobin11x28;

    @Column(name=GenZT_IdouMeisaiRn.ZRNYOBIN11X28)
    public Long getZrnyobin11x28() {
        return zrnyobin11x28;
    }

    public void setZrnyobin11x28(Long pZrnyobin11x28) {
        zrnyobin11x28 = pZrnyobin11x28;
    }

    private Long zrnyobin11x29;

    @Column(name=GenZT_IdouMeisaiRn.ZRNYOBIN11X29)
    public Long getZrnyobin11x29() {
        return zrnyobin11x29;
    }

    public void setZrnyobin11x29(Long pZrnyobin11x29) {
        zrnyobin11x29 = pZrnyobin11x29;
    }

    private Long zrnyobin11x30;

    @Column(name=GenZT_IdouMeisaiRn.ZRNYOBIN11X30)
    public Long getZrnyobin11x30() {
        return zrnyobin11x30;
    }

    public void setZrnyobin11x30(Long pZrnyobin11x30) {
        zrnyobin11x30 = pZrnyobin11x30;
    }

    private Long zrnyobin11x31;

    @Column(name=GenZT_IdouMeisaiRn.ZRNYOBIN11X31)
    public Long getZrnyobin11x31() {
        return zrnyobin11x31;
    }

    public void setZrnyobin11x31(Long pZrnyobin11x31) {
        zrnyobin11x31 = pZrnyobin11x31;
    }

    private Long zrnyobin11x32;

    @Column(name=GenZT_IdouMeisaiRn.ZRNYOBIN11X32)
    public Long getZrnyobin11x32() {
        return zrnyobin11x32;
    }

    public void setZrnyobin11x32(Long pZrnyobin11x32) {
        zrnyobin11x32 = pZrnyobin11x32;
    }

    private Long zrnyobin11x33;

    @Column(name=GenZT_IdouMeisaiRn.ZRNYOBIN11X33)
    public Long getZrnyobin11x33() {
        return zrnyobin11x33;
    }

    public void setZrnyobin11x33(Long pZrnyobin11x33) {
        zrnyobin11x33 = pZrnyobin11x33;
    }

    private Long zrnhaitouyouloadingkijyuns;

    @Column(name=GenZT_IdouMeisaiRn.ZRNHAITOUYOULOADINGKIJYUNS)
    public Long getZrnhaitouyouloadingkijyuns() {
        return zrnhaitouyouloadingkijyuns;
    }

    public void setZrnhaitouyouloadingkijyuns(Long pZrnhaitouyouloadingkijyuns) {
        zrnhaitouyouloadingkijyuns = pZrnhaitouyouloadingkijyuns;
    }

    private String zrntouduketorihouhoukbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTOUDUKETORIHOUHOUKBN)
    public String getZrntouduketorihouhoukbn() {
        return zrntouduketorihouhoukbn;
    }

    public void setZrntouduketorihouhoukbn(String pZrntouduketorihouhoukbn) {
        zrntouduketorihouhoukbn = pZrntouduketorihouhoukbn;
    }

    private Long zrntumitated;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTUMITATED)
    public Long getZrntumitated() {
        return zrntumitated;
    }

    public void setZrntumitated(Long pZrntumitated) {
        zrntumitated = pZrntumitated;
    }

    private Long zrnkariwariated;

    @Column(name=GenZT_IdouMeisaiRn.ZRNKARIWARIATED)
    public Long getZrnkariwariated() {
        return zrnkariwariated;
    }

    public void setZrnkariwariated(Long pZrnkariwariated) {
        zrnkariwariated = pZrnkariwariated;
    }

    private String zrntyokuzensiharaikijitu;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTYOKUZENSIHARAIKIJITU)
    public String getZrntyokuzensiharaikijitu() {
        return zrntyokuzensiharaikijitu;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrntyokuzensiharaikijitu(String pZrntyokuzensiharaikijitu) {
        zrntyokuzensiharaikijitu = pZrntyokuzensiharaikijitu;
    }

    private Long zrntyokuzentuusanhanteis;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTYOKUZENTUUSANHANTEIS)
    public Long getZrntyokuzentuusanhanteis() {
        return zrntyokuzentuusanhanteis;
    }

    public void setZrntyokuzentuusanhanteis(Long pZrntyokuzentuusanhanteis) {
        zrntyokuzentuusanhanteis = pZrntyokuzentuusanhanteis;
    }

    private String zrntyokugosiharaikijitu;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTYOKUGOSIHARAIKIJITU)
    public String getZrntyokugosiharaikijitu() {
        return zrntyokugosiharaikijitu;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrntyokugosiharaikijitu(String pZrntyokugosiharaikijitu) {
        zrntyokugosiharaikijitu = pZrntyokugosiharaikijitu;
    }

    private Long zrntyokugotuusanhanteis;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTYOKUGOTUUSANHANTEIS)
    public Long getZrntyokugotuusanhanteis() {
        return zrntyokugotuusanhanteis;
    }

    public void setZrntyokugotuusanhanteis(Long pZrntyokugotuusanhanteis) {
        zrntyokugotuusanhanteis = pZrntyokugotuusanhanteis;
    }

    private Long zrntyokugokyuuhutaisyous;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTYOKUGOKYUUHUTAISYOUS)
    public Long getZrntyokugokyuuhutaisyous() {
        return zrntyokugokyuuhutaisyous;
    }

    public void setZrntyokugokyuuhutaisyous(Long pZrntyokugokyuuhutaisyous) {
        zrntyokugokyuuhutaisyous = pZrntyokugokyuuhutaisyous;
    }

    private Long zrntyokugocbkingaku;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTYOKUGOCBKINGAKU)
    public Long getZrntyokugocbkingaku() {
        return zrntyokugocbkingaku;
    }

    public void setZrntyokugocbkingaku(Long pZrntyokugocbkingaku) {
        zrntyokugocbkingaku = pZrntyokugocbkingaku;
    }

    private String zrnsyokaisiharaikijitu;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSYOKAISIHARAIKIJITU)
    public String getZrnsyokaisiharaikijitu() {
        return zrnsyokaisiharaikijitu;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnsyokaisiharaikijitu(String pZrnsyokaisiharaikijitu) {
        zrnsyokaisiharaikijitu = pZrnsyokaisiharaikijitu;
    }

    private Long zrnsyokaituusanhanteis;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSYOKAITUUSANHANTEIS)
    public Long getZrnsyokaituusanhanteis() {
        return zrnsyokaituusanhanteis;
    }

    public void setZrnsyokaituusanhanteis(Long pZrnsyokaituusanhanteis) {
        zrnsyokaituusanhanteis = pZrnsyokaituusanhanteis;
    }

    private Long zrncbnayosetuusanhanteis;

    @Column(name=GenZT_IdouMeisaiRn.ZRNCBNAYOSETUUSANHANTEIS)
    public Long getZrncbnayosetuusanhanteis() {
        return zrncbnayosetuusanhanteis;
    }

    public void setZrncbnayosetuusanhanteis(Long pZrncbnayosetuusanhanteis) {
        zrncbnayosetuusanhanteis = pZrncbnayosetuusanhanteis;
    }

    private String zrnhitenkankeiyakusuu;

    @Column(name=GenZT_IdouMeisaiRn.ZRNHITENKANKEIYAKUSUU)
    public String getZrnhitenkankeiyakusuu() {
        return zrnhitenkankeiyakusuu;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhitenkankeiyakusuu(String pZrnhitenkankeiyakusuu) {
        zrnhitenkankeiyakusuu = pZrnhitenkankeiyakusuu;
    }

    private Long zrngoukeipbubuntenkanteikis;

    @Column(name=GenZT_IdouMeisaiRn.ZRNGOUKEIPBUBUNTENKANTEIKIS)
    public Long getZrngoukeipbubuntenkanteikis() {
        return zrngoukeipbubuntenkanteikis;
    }

    public void setZrngoukeipbubuntenkanteikis(Long pZrngoukeipbubuntenkanteikis) {
        zrngoukeipbubuntenkanteikis = pZrngoukeipbubuntenkanteikis;
    }

    private String zrnsaidaihktgtikkikkkn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSAIDAIHKTGTIKKIKKKN)
    public String getZrnsaidaihktgtikkikkkn() {
        return zrnsaidaihktgtikkikkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsaidaihktgtikkikkkn(String pZrnsaidaihktgtikkikkkn) {
        zrnsaidaihktgtikkikkkn = pZrnsaidaihktgtikkikkkn;
    }

    private Long zrnsisyutnknhktgkujygk;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSISYUTNKNHKTGKUJYGK)
    public Long getZrnsisyutnknhktgkujygk() {
        return zrnsisyutnknhktgkujygk;
    }

    public void setZrnsisyutnknhktgkujygk(Long pZrnsisyutnknhktgkujygk) {
        zrnsisyutnknhktgkujygk = pZrnsisyutnknhktgkujygk;
    }

    private Long zrnyobin11x34;

    @Column(name=GenZT_IdouMeisaiRn.ZRNYOBIN11X34)
    public Long getZrnyobin11x34() {
        return zrnyobin11x34;
    }

    public void setZrnyobin11x34(Long pZrnyobin11x34) {
        zrnyobin11x34 = pZrnyobin11x34;
    }

    private String zrnhtnknkykkykymdx1;

    @Column(name=GenZT_IdouMeisaiRn.ZRNHTNKNKYKKYKYMDX1)
    public String getZrnhtnknkykkykymdx1() {
        return zrnhtnknkykkykymdx1;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnhtnknkykkykymdx1(String pZrnhtnknkykkykymdx1) {
        zrnhtnknkykkykymdx1 = pZrnhtnknkykkykymdx1;
    }

    private Long zrntnkntkbtdkisnyusx1;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTNKNTKBTDKISNYUSX1)
    public Long getZrntnkntkbtdkisnyusx1() {
        return zrntnkntkbtdkisnyusx1;
    }

    public void setZrntnkntkbtdkisnyusx1(Long pZrntnkntkbtdkisnyusx1) {
        zrntnkntkbtdkisnyusx1 = pZrntnkntkbtdkisnyusx1;
    }

    private String zrntnknkaiykkujytksux1;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTNKNKAIYKKUJYTKSUX1)
    public String getZrntnknkaiykkujytksux1() {
        return zrntnknkaiykkujytksux1;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrntnknkaiykkujytksux1(String pZrntnknkaiykkujytksux1) {
        zrntnknkaiykkujytksux1 = pZrntnknkaiykkujytksux1;
    }

    private Long zrntnknkaiykkujygkx1;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTNKNKAIYKKUJYGKX1)
    public Long getZrntnknkaiykkujygkx1() {
        return zrntnknkaiykkujygkx1;
    }

    public void setZrntnknkaiykkujygkx1(Long pZrntnknkaiykkujygkx1) {
        zrntnknkaiykkujygkx1 = pZrntnknkaiykkujygkx1;
    }

    private String zrntenkanteikihyoujix1;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTENKANTEIKIHYOUJIX1)
    public String getZrntenkanteikihyoujix1() {
        return zrntenkanteikihyoujix1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntenkanteikihyoujix1(String pZrntenkanteikihyoujix1) {
        zrntenkanteikihyoujix1 = pZrntenkanteikihyoujix1;
    }

    private Long zrnhtnknkyknenknsnpx1;

    @Column(name=GenZT_IdouMeisaiRn.ZRNHTNKNKYKNENKNSNPX1)
    public Long getZrnhtnknkyknenknsnpx1() {
        return zrnhtnknkyknenknsnpx1;
    }

    public void setZrnhtnknkyknenknsnpx1(Long pZrnhtnknkyknenknsnpx1) {
        zrnhtnknkyknenknsnpx1 = pZrnhtnknkyknenknsnpx1;
    }

    private String zrnhktgtikkikkknx1;

    @Column(name=GenZT_IdouMeisaiRn.ZRNHKTGTIKKIKKKNX1)
    public String getZrnhktgtikkikkknx1() {
        return zrnhktgtikkikkknx1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhktgtikkikkknx1(String pZrnhktgtikkikkknx1) {
        zrnhktgtikkikkknx1 = pZrnhktgtikkikkknx1;
    }

    private String zrnhtnknkykkykymdx2;

    @Column(name=GenZT_IdouMeisaiRn.ZRNHTNKNKYKKYKYMDX2)
    public String getZrnhtnknkykkykymdx2() {
        return zrnhtnknkykkykymdx2;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnhtnknkykkykymdx2(String pZrnhtnknkykkykymdx2) {
        zrnhtnknkykkykymdx2 = pZrnhtnknkykkykymdx2;
    }

    private Long zrntnkntkbtdkisnyusx2;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTNKNTKBTDKISNYUSX2)
    public Long getZrntnkntkbtdkisnyusx2() {
        return zrntnkntkbtdkisnyusx2;
    }

    public void setZrntnkntkbtdkisnyusx2(Long pZrntnkntkbtdkisnyusx2) {
        zrntnkntkbtdkisnyusx2 = pZrntnkntkbtdkisnyusx2;
    }

    private String zrntnknkaiykkujytksux2;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTNKNKAIYKKUJYTKSUX2)
    public String getZrntnknkaiykkujytksux2() {
        return zrntnknkaiykkujytksux2;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrntnknkaiykkujytksux2(String pZrntnknkaiykkujytksux2) {
        zrntnknkaiykkujytksux2 = pZrntnknkaiykkujytksux2;
    }

    private Long zrntnknkaiykkujygkx2;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTNKNKAIYKKUJYGKX2)
    public Long getZrntnknkaiykkujygkx2() {
        return zrntnknkaiykkujygkx2;
    }

    public void setZrntnknkaiykkujygkx2(Long pZrntnknkaiykkujygkx2) {
        zrntnknkaiykkujygkx2 = pZrntnknkaiykkujygkx2;
    }

    private String zrntenkanteikihyoujix2;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTENKANTEIKIHYOUJIX2)
    public String getZrntenkanteikihyoujix2() {
        return zrntenkanteikihyoujix2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntenkanteikihyoujix2(String pZrntenkanteikihyoujix2) {
        zrntenkanteikihyoujix2 = pZrntenkanteikihyoujix2;
    }

    private Long zrnhtnknkyknenknsnpx2;

    @Column(name=GenZT_IdouMeisaiRn.ZRNHTNKNKYKNENKNSNPX2)
    public Long getZrnhtnknkyknenknsnpx2() {
        return zrnhtnknkyknenknsnpx2;
    }

    public void setZrnhtnknkyknenknsnpx2(Long pZrnhtnknkyknenknsnpx2) {
        zrnhtnknkyknenknsnpx2 = pZrnhtnknkyknenknsnpx2;
    }

    private String zrnhktgtikkikkknx2;

    @Column(name=GenZT_IdouMeisaiRn.ZRNHKTGTIKKIKKKNX2)
    public String getZrnhktgtikkikkknx2() {
        return zrnhktgtikkikkknx2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhktgtikkikkknx2(String pZrnhktgtikkikkknx2) {
        zrnhktgtikkikkknx2 = pZrnhktgtikkikkknx2;
    }

    private String zrnhtnknkykkykymdx3;

    @Column(name=GenZT_IdouMeisaiRn.ZRNHTNKNKYKKYKYMDX3)
    public String getZrnhtnknkykkykymdx3() {
        return zrnhtnknkykkykymdx3;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnhtnknkykkykymdx3(String pZrnhtnknkykkykymdx3) {
        zrnhtnknkykkykymdx3 = pZrnhtnknkykkykymdx3;
    }

    private Long zrntnkntkbtdkisnyusx3;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTNKNTKBTDKISNYUSX3)
    public Long getZrntnkntkbtdkisnyusx3() {
        return zrntnkntkbtdkisnyusx3;
    }

    public void setZrntnkntkbtdkisnyusx3(Long pZrntnkntkbtdkisnyusx3) {
        zrntnkntkbtdkisnyusx3 = pZrntnkntkbtdkisnyusx3;
    }

    private String zrntnknkaiykkujytksux3;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTNKNKAIYKKUJYTKSUX3)
    public String getZrntnknkaiykkujytksux3() {
        return zrntnknkaiykkujytksux3;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrntnknkaiykkujytksux3(String pZrntnknkaiykkujytksux3) {
        zrntnknkaiykkujytksux3 = pZrntnknkaiykkujytksux3;
    }

    private Long zrntnknkaiykkujygkx3;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTNKNKAIYKKUJYGKX3)
    public Long getZrntnknkaiykkujygkx3() {
        return zrntnknkaiykkujygkx3;
    }

    public void setZrntnknkaiykkujygkx3(Long pZrntnknkaiykkujygkx3) {
        zrntnknkaiykkujygkx3 = pZrntnknkaiykkujygkx3;
    }

    private String zrntenkanteikihyoujix3;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTENKANTEIKIHYOUJIX3)
    public String getZrntenkanteikihyoujix3() {
        return zrntenkanteikihyoujix3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntenkanteikihyoujix3(String pZrntenkanteikihyoujix3) {
        zrntenkanteikihyoujix3 = pZrntenkanteikihyoujix3;
    }

    private Long zrnhtnknkyknenknsnpx3;

    @Column(name=GenZT_IdouMeisaiRn.ZRNHTNKNKYKNENKNSNPX3)
    public Long getZrnhtnknkyknenknsnpx3() {
        return zrnhtnknkyknenknsnpx3;
    }

    public void setZrnhtnknkyknenknsnpx3(Long pZrnhtnknkyknenknsnpx3) {
        zrnhtnknkyknenknsnpx3 = pZrnhtnknkyknenknsnpx3;
    }

    private String zrnhktgtikkikkknx3;

    @Column(name=GenZT_IdouMeisaiRn.ZRNHKTGTIKKIKKKNX3)
    public String getZrnhktgtikkikkknx3() {
        return zrnhktgtikkikkknx3;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhktgtikkikkknx3(String pZrnhktgtikkikkknx3) {
        zrnhktgtikkikkknx3 = pZrnhktgtikkikkknx3;
    }

    private String zrnhtnknkykkykymdx4;

    @Column(name=GenZT_IdouMeisaiRn.ZRNHTNKNKYKKYKYMDX4)
    public String getZrnhtnknkykkykymdx4() {
        return zrnhtnknkykkykymdx4;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnhtnknkykkykymdx4(String pZrnhtnknkykkykymdx4) {
        zrnhtnknkykkykymdx4 = pZrnhtnknkykkykymdx4;
    }

    private Long zrntnkntkbtdkisnyusx4;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTNKNTKBTDKISNYUSX4)
    public Long getZrntnkntkbtdkisnyusx4() {
        return zrntnkntkbtdkisnyusx4;
    }

    public void setZrntnkntkbtdkisnyusx4(Long pZrntnkntkbtdkisnyusx4) {
        zrntnkntkbtdkisnyusx4 = pZrntnkntkbtdkisnyusx4;
    }

    private String zrntnknkaiykkujytksux4;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTNKNKAIYKKUJYTKSUX4)
    public String getZrntnknkaiykkujytksux4() {
        return zrntnknkaiykkujytksux4;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrntnknkaiykkujytksux4(String pZrntnknkaiykkujytksux4) {
        zrntnknkaiykkujytksux4 = pZrntnknkaiykkujytksux4;
    }

    private Long zrntnknkaiykkujygkx4;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTNKNKAIYKKUJYGKX4)
    public Long getZrntnknkaiykkujygkx4() {
        return zrntnknkaiykkujygkx4;
    }

    public void setZrntnknkaiykkujygkx4(Long pZrntnknkaiykkujygkx4) {
        zrntnknkaiykkujygkx4 = pZrntnknkaiykkujygkx4;
    }

    private String zrntenkanteikihyoujix4;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTENKANTEIKIHYOUJIX4)
    public String getZrntenkanteikihyoujix4() {
        return zrntenkanteikihyoujix4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntenkanteikihyoujix4(String pZrntenkanteikihyoujix4) {
        zrntenkanteikihyoujix4 = pZrntenkanteikihyoujix4;
    }

    private Long zrnhtnknkyknenknsnpx4;

    @Column(name=GenZT_IdouMeisaiRn.ZRNHTNKNKYKNENKNSNPX4)
    public Long getZrnhtnknkyknenknsnpx4() {
        return zrnhtnknkyknenknsnpx4;
    }

    public void setZrnhtnknkyknenknsnpx4(Long pZrnhtnknkyknenknsnpx4) {
        zrnhtnknkyknenknsnpx4 = pZrnhtnknkyknenknsnpx4;
    }

    private String zrnhktgtikkikkknx4;

    @Column(name=GenZT_IdouMeisaiRn.ZRNHKTGTIKKIKKKNX4)
    public String getZrnhktgtikkikkknx4() {
        return zrnhktgtikkikkknx4;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhktgtikkikkknx4(String pZrnhktgtikkikkknx4) {
        zrnhktgtikkikkknx4 = pZrnhktgtikkikkknx4;
    }

    private String zrnsknjyututkykkykkbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSKNJYUTUTKYKKYKKBN)
    public String getZrnsknjyututkykkykkbn() {
        return zrnsknjyututkykkykkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsknjyututkykkykkbn(String pZrnsknjyututkykkykkbn) {
        zrnsknjyututkykkykkbn = pZrnsknjyututkykkykkbn;
    }

    private Long zrnswingminyuuphrkekngk;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSWINGMINYUUPHRKEKNGK)
    public Long getZrnswingminyuuphrkekngk() {
        return zrnswingminyuuphrkekngk;
    }

    public void setZrnswingminyuuphrkekngk(Long pZrnswingminyuuphrkekngk) {
        zrnswingminyuuphrkekngk = pZrnswingminyuuphrkekngk;
    }

    private String zrnswingminyuuphrkejyutuym;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSWINGMINYUUPHRKEJYUTUYM)
    public String getZrnswingminyuuphrkejyutuym() {
        return zrnswingminyuuphrkejyutuym;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrnswingminyuuphrkejyutuym(String pZrnswingminyuuphrkejyutuym) {
        zrnswingminyuuphrkejyutuym = pZrnswingminyuuphrkejyutuym;
    }

    private Long zrndftounendoitijitounyuup;

    @Column(name=GenZT_IdouMeisaiRn.ZRNDFTOUNENDOITIJITOUNYUUP)
    public Long getZrndftounendoitijitounyuup() {
        return zrndftounendoitijitounyuup;
    }

    public void setZrndftounendoitijitounyuup(Long pZrndftounendoitijitounyuup) {
        zrndftounendoitijitounyuup = pZrndftounendoitijitounyuup;
    }

    private Long zrndfkaiyakukujyhktggk;

    @Column(name=GenZT_IdouMeisaiRn.ZRNDFKAIYAKUKUJYHKTGGK)
    public Long getZrndfkaiyakukujyhktggk() {
        return zrndfkaiyakukujyhktggk;
    }

    public void setZrndfkaiyakukujyhktggk(Long pZrndfkaiyakukujyhktggk) {
        zrndfkaiyakukujyhktggk = pZrndfkaiyakukujyhktggk;
    }

    private String zrnkaiyakukoujyotukisuu;

    @Column(name=GenZT_IdouMeisaiRn.ZRNKAIYAKUKOUJYOTUKISUU)
    public String getZrnkaiyakukoujyotukisuu() {
        return zrnkaiyakukoujyotukisuu;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrnkaiyakukoujyotukisuu(String pZrnkaiyakukoujyotukisuu) {
        zrnkaiyakukoujyotukisuu = pZrnkaiyakukoujyotukisuu;
    }

    private Long zrndfkaiyakuhenreikin;

    @Column(name=GenZT_IdouMeisaiRn.ZRNDFKAIYAKUHENREIKIN)
    public Long getZrndfkaiyakuhenreikin() {
        return zrndfkaiyakuhenreikin;
    }

    public void setZrndfkaiyakuhenreikin(Long pZrndfkaiyakuhenreikin) {
        zrndfkaiyakuhenreikin = pZrndfkaiyakuhenreikin;
    }

    private Long zrnsyuuseis;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSYUUSEIS)
    public Long getZrnsyuuseis() {
        return zrnsyuuseis;
    }

    public void setZrnsyuuseis(Long pZrnsyuuseis) {
        zrnsyuuseis = pZrnsyuuseis;
    }

    private String zrnaatukaisyakeisyousisyacd;

    @Column(name=GenZT_IdouMeisaiRn.ZRNAATUKAISYAKEISYOUSISYACD)
    public String getZrnaatukaisyakeisyousisyacd() {
        return zrnaatukaisyakeisyousisyacd;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrnaatukaisyakeisyousisyacd(String pZrnaatukaisyakeisyousisyacd) {
        zrnaatukaisyakeisyousisyacd = pZrnaatukaisyakeisyousisyacd;
    }

    private String zrnaatukaisyazaisekihyouji;

    @Column(name=GenZT_IdouMeisaiRn.ZRNAATUKAISYAZAISEKIHYOUJI)
    public String getZrnaatukaisyazaisekihyouji() {
        return zrnaatukaisyazaisekihyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnaatukaisyazaisekihyouji(String pZrnaatukaisyazaisekihyouji) {
        zrnaatukaisyazaisekihyouji = pZrnaatukaisyazaisekihyouji;
    }

    private String zrnaatukaisyabosyuujiage;

    @Column(name=GenZT_IdouMeisaiRn.ZRNAATUKAISYABOSYUUJIAGE)
    public String getZrnaatukaisyabosyuujiage() {
        return zrnaatukaisyabosyuujiage;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnaatukaisyabosyuujiage(String pZrnaatukaisyabosyuujiage) {
        zrnaatukaisyabosyuujiage = pZrnaatukaisyabosyuujiage;
    }

    private String zrnaatukaisyabsyjisikakucd;

    @Column(name=GenZT_IdouMeisaiRn.ZRNAATUKAISYABSYJISIKAKUCD)
    public String getZrnaatukaisyabsyjisikakucd() {
        return zrnaatukaisyabsyjisikakucd;
    }

    @Padding(mode = "left", padChar = '0', length = 5)
    public void setZrnaatukaisyabsyjisikakucd(String pZrnaatukaisyabsyjisikakucd) {
        zrnaatukaisyabsyjisikakucd = pZrnaatukaisyabsyjisikakucd;
    }

    private String zrnaatukaisyasikakucd;

    @Column(name=GenZT_IdouMeisaiRn.ZRNAATUKAISYASIKAKUCD)
    public String getZrnaatukaisyasikakucd() {
        return zrnaatukaisyasikakucd;
    }

    @Padding(mode = "left", padChar = '0', length = 5)
    public void setZrnaatukaisyasikakucd(String pZrnaatukaisyasikakucd) {
        zrnaatukaisyasikakucd = pZrnaatukaisyasikakucd;
    }

    private String zrnokyksmkuztrhkkitikbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNOKYKSMKUZTRHKKITIKBN)
    public String getZrnokyksmkuztrhkkitikbn() {
        return zrnokyksmkuztrhkkitikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnokyksmkuztrhkkitikbn(String pZrnokyksmkuztrhkkitikbn) {
        zrnokyksmkuztrhkkitikbn = pZrnokyksmkuztrhkkitikbn;
    }

    private String zrnhoyuusisyacd;

    @Column(name=GenZT_IdouMeisaiRn.ZRNHOYUUSISYACD)
    public String getZrnhoyuusisyacd() {
        return zrnhoyuusisyacd;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrnhoyuusisyacd(String pZrnhoyuusisyacd) {
        zrnhoyuusisyacd = pZrnhoyuusisyacd;
    }

    private String zrnsyokansisyacd;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSYOKANSISYACD)
    public String getZrnsyokansisyacd() {
        return zrnsyokansisyacd;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrnsyokansisyacd(String pZrnsyokansisyacd) {
        zrnsyokansisyacd = pZrnsyokansisyacd;
    }

    private String zrntantousyakbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTANTOUSYAKBN)
    public String getZrntantousyakbn() {
        return zrntantousyakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrntantousyakbn(String pZrntantousyakbn) {
        zrntantousyakbn = pZrntantousyakbn;
    }

    private String zrntantousyakbnnew;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTANTOUSYAKBNNEW)
    public String getZrntantousyakbnnew() {
        return zrntantousyakbnnew;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntantousyakbnnew(String pZrntantousyakbnnew) {
        zrntantousyakbnnew = pZrntantousyakbnnew;
    }

    private String zrnclubsumiseikbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNCLUBSUMISEIKBN)
    public String getZrnclubsumiseikbn() {
        return zrnclubsumiseikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnclubsumiseikbn(String pZrnclubsumiseikbn) {
        zrnclubsumiseikbn = pZrnclubsumiseikbn;
    }

    private String zrnfollowtantousyakbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNFOLLOWTANTOUSYAKBN)
    public String getZrnfollowtantousyakbn() {
        return zrnfollowtantousyakbn;
    }

    public void setZrnfollowtantousyakbn(String pZrnfollowtantousyakbn) {
        zrnfollowtantousyakbn = pZrnfollowtantousyakbn;
    }

    private String zrntantousyajyoutaikbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTANTOUSYAJYOUTAIKBN)
    public String getZrntantousyajyoutaikbn() {
        return zrntantousyajyoutaikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrntantousyajyoutaikbn(String pZrntantousyajyoutaikbn) {
        zrntantousyajyoutaikbn = pZrntantousyajyoutaikbn;
    }

    private String zrnkihonyoteii;

    @Column(name=GenZT_IdouMeisaiRn.ZRNKIHONYOTEII)
    public String getZrnkihonyoteii() {
        return zrnkihonyoteii;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrnkihonyoteii(String pZrnkihonyoteii) {
        zrnkihonyoteii = pZrnkihonyoteii;
    }

    private String zrnteikiyoteii;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTEIKIYOTEII)
    public String getZrnteikiyoteii() {
        return zrnteikiyoteii;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrnteikiyoteii(String pZrnteikiyoteii) {
        zrnteikiyoteii = pZrnteikiyoteii;
    }

    private String zrnsonotayoteii;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSONOTAYOTEII)
    public String getZrnsonotayoteii() {
        return zrnsonotayoteii;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrnsonotayoteii(String pZrnsonotayoteii) {
        zrnsonotayoteii = pZrnsonotayoteii;
    }

    private String zrnitijibaraikihonyoteii;

    @Column(name=GenZT_IdouMeisaiRn.ZRNITIJIBARAIKIHONYOTEII)
    public String getZrnitijibaraikihonyoteii() {
        return zrnitijibaraikihonyoteii;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrnitijibaraikihonyoteii(String pZrnitijibaraikihonyoteii) {
        zrnitijibaraikihonyoteii = pZrnitijibaraikihonyoteii;
    }

    private String zrnitijibaraiteikiyoteii;

    @Column(name=GenZT_IdouMeisaiRn.ZRNITIJIBARAITEIKIYOTEII)
    public String getZrnitijibaraiteikiyoteii() {
        return zrnitijibaraiteikiyoteii;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrnitijibaraiteikiyoteii(String pZrnitijibaraiteikiyoteii) {
        zrnitijibaraiteikiyoteii = pZrnitijibaraiteikiyoteii;
    }

    private String zrnitijibaraisonotayoteii;

    @Column(name=GenZT_IdouMeisaiRn.ZRNITIJIBARAISONOTAYOTEII)
    public String getZrnitijibaraisonotayoteii() {
        return zrnitijibaraisonotayoteii;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrnitijibaraisonotayoteii(String pZrnitijibaraisonotayoteii) {
        zrnitijibaraisonotayoteii = pZrnitijibaraisonotayoteii;
    }

    private String zrntenkankihonyoteii;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTENKANKIHONYOTEII)
    public String getZrntenkankihonyoteii() {
        return zrntenkankihonyoteii;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrntenkankihonyoteii(String pZrntenkankihonyoteii) {
        zrntenkankihonyoteii = pZrntenkankihonyoteii;
    }

    private String zrntenkanteikiyoteii;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTENKANTEIKIYOTEII)
    public String getZrntenkanteikiyoteii() {
        return zrntenkanteikiyoteii;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrntenkanteikiyoteii(String pZrntenkanteikiyoteii) {
        zrntenkanteikiyoteii = pZrntenkanteikiyoteii;
    }

    private String zrnszouyoteii;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSZOUYOTEII)
    public String getZrnszouyoteii() {
        return zrnszouyoteii;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrnszouyoteii(String pZrnszouyoteii) {
        zrnszouyoteii = pZrnszouyoteii;
    }

    private String zrnvestingyoteii;

    @Column(name=GenZT_IdouMeisaiRn.ZRNVESTINGYOTEII)
    public String getZrnvestingyoteii() {
        return zrnvestingyoteii;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrnvestingyoteii(String pZrnvestingyoteii) {
        zrnvestingyoteii = pZrnvestingyoteii;
    }

    private String zrnsippeitokuyakuyoteii;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSIPPEITOKUYAKUYOTEII)
    public String getZrnsippeitokuyakuyoteii() {
        return zrnsippeitokuyakuyoteii;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrnsippeitokuyakuyoteii(String pZrnsippeitokuyakuyoteii) {
        zrnsippeitokuyakuyoteii = pZrnsippeitokuyakuyoteii;
    }

    private String zrnseijinbyoutokuyakuyoteii;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSEIJINBYOUTOKUYAKUYOTEII)
    public String getZrnseijinbyoutokuyakuyoteii() {
        return zrnseijinbyoutokuyakuyoteii;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrnseijinbyoutokuyakuyoteii(String pZrnseijinbyoutokuyakuyoteii) {
        zrnseijinbyoutokuyakuyoteii = pZrnseijinbyoutokuyakuyoteii;
    }

    private String zrnjyoseitokuyakuyoteii;

    @Column(name=GenZT_IdouMeisaiRn.ZRNJYOSEITOKUYAKUYOTEII)
    public String getZrnjyoseitokuyakuyoteii() {
        return zrnjyoseitokuyakuyoteii;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrnjyoseitokuyakuyoteii(String pZrnjyoseitokuyakuyoteii) {
        zrnjyoseitokuyakuyoteii = pZrnjyoseitokuyakuyoteii;
    }

    private String zrntuuintokuyakuyoteii;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTUUINTOKUYAKUYOTEII)
    public String getZrntuuintokuyakuyoteii() {
        return zrntuuintokuyakuyoteii;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrntuuintokuyakuyoteii(String pZrntuuintokuyakuyoteii) {
        zrntuuintokuyakuyoteii = pZrntuuintokuyakuyoteii;
    }

    private String zrnsaiteihosyoui;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSAITEIHOSYOUI)
    public String getZrnsaiteihosyoui() {
        return zrnsaiteihosyoui;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrnsaiteihosyoui(String pZrnsaiteihosyoui) {
        zrnsaiteihosyoui = pZrnsaiteihosyoui;
    }

    private String zrnvkisoitjbrkhnyoteii;

    @Column(name=GenZT_IdouMeisaiRn.ZRNVKISOITJBRKHNYOTEII)
    public String getZrnvkisoitjbrkhnyoteii() {
        return zrnvkisoitjbrkhnyoteii;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrnvkisoitjbrkhnyoteii(String pZrnvkisoitjbrkhnyoteii) {
        zrnvkisoitjbrkhnyoteii = pZrnvkisoitjbrkhnyoteii;
    }

    private String zrnvkisorrtzeroikahyouji;

    @Column(name=GenZT_IdouMeisaiRn.ZRNVKISORRTZEROIKAHYOUJI)
    public String getZrnvkisorrtzeroikahyouji() {
        return zrnvkisorrtzeroikahyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnvkisorrtzeroikahyouji(String pZrnvkisorrtzeroikahyouji) {
        zrnvkisorrtzeroikahyouji = pZrnvkisorrtzeroikahyouji;
    }

    private String zrnsuuriyouyobin3x2;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSUURIYOUYOBIN3X2)
    public String getZrnsuuriyouyobin3x2() {
        return zrnsuuriyouyobin3x2;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrnsuuriyouyobin3x2(String pZrnsuuriyouyobin3x2) {
        zrnsuuriyouyobin3x2 = pZrnsuuriyouyobin3x2;
    }

    private String zrnhoyuusisyacd2;

    @Column(name=GenZT_IdouMeisaiRn.ZRNHOYUUSISYACD2)
    public String getZrnhoyuusisyacd2() {
        return zrnhoyuusisyacd2;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrnhoyuusisyacd2(String pZrnhoyuusisyacd2) {
        zrnhoyuusisyacd2 = pZrnhoyuusisyacd2;
    }

    private String zrndftujyukujykisnkisiym;

    @Column(name=GenZT_IdouMeisaiRn.ZRNDFTUJYUKUJYKISNKISIYM)
    public String getZrndftujyukujykisnkisiym() {
        return zrndftujyukujykisnkisiym;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrndftujyukujykisnkisiym(String pZrndftujyukujykisnkisiym) {
        zrndftujyukujykisnkisiym = pZrndftujyukujykisnkisiym;
    }

    private String zrntikikktbrijyututksu;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTIKIKKTBRIJYUTUTKSU)
    public String getZrntikikktbrijyututksu() {
        return zrntikikktbrijyututksu;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrntikikktbrijyututksu(String pZrntikikktbrijyututksu) {
        zrntikikktbrijyututksu = pZrntikikktbrijyututksu;
    }

    private String zrnsyunyumrtikykjtigngtkbn;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSYUNYUMRTIKYKJTIGNGTKBN)
    public String getZrnsyunyumrtikykjtigngtkbn() {
        return zrnsyunyumrtikykjtigngtkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsyunyumrtikykjtigngtkbn(String pZrnsyunyumrtikykjtigngtkbn) {
        zrnsyunyumrtikykjtigngtkbn = pZrnsyunyumrtikykjtigngtkbn;
    }

    private String zrnhhkdrtkykarihyj;

    @Column(name=GenZT_IdouMeisaiRn.ZRNHHKDRTKYKARIHYJ)
    public String getZrnhhkdrtkykarihyj() {
        return zrnhhkdrtkykarihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhhkdrtkykarihyj(String pZrnhhkdrtkykarihyj) {
        zrnhhkdrtkykarihyj = pZrnhhkdrtkykarihyj;
    }

    private String zrnkykdrtkykarihyj;

    @Column(name=GenZT_IdouMeisaiRn.ZRNKYKDRTKYKARIHYJ)
    public String getZrnkykdrtkykarihyj() {
        return zrnkykdrtkykarihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkykdrtkykarihyj(String pZrnkykdrtkykarihyj) {
        zrnkykdrtkykarihyj = pZrnkykdrtkykarihyj;
    }

    private String zrnyobiv10x14;

    @Column(name=GenZT_IdouMeisaiRn.ZRNYOBIV10X14)
    public String getZrnyobiv10x14() {
        return zrnyobiv10x14;
    }

    public void setZrnyobiv10x14(String pZrnyobiv10x14) {
        zrnyobiv10x14 = pZrnyobiv10x14;
    }

    private Long zrnkappadhktgkujygkx1;

    @Column(name=GenZT_IdouMeisaiRn.ZRNKAPPADHKTGKUJYGKX1)
    public Long getZrnkappadhktgkujygkx1() {
        return zrnkappadhktgkujygkx1;
    }

    public void setZrnkappadhktgkujygkx1(Long pZrnkappadhktgkujygkx1) {
        zrnkappadhktgkujygkx1 = pZrnkappadhktgkujygkx1;
    }

    private Long zrnkappadhktgkujygkx2;

    @Column(name=GenZT_IdouMeisaiRn.ZRNKAPPADHKTGKUJYGKX2)
    public Long getZrnkappadhktgkujygkx2() {
        return zrnkappadhktgkujygkx2;
    }

    public void setZrnkappadhktgkujygkx2(Long pZrnkappadhktgkujygkx2) {
        zrnkappadhktgkujygkx2 = pZrnkappadhktgkujygkx2;
    }

    private Long zrnkappadhktgkujygkx3;

    @Column(name=GenZT_IdouMeisaiRn.ZRNKAPPADHKTGKUJYGKX3)
    public Long getZrnkappadhktgkujygkx3() {
        return zrnkappadhktgkujygkx3;
    }

    public void setZrnkappadhktgkujygkx3(Long pZrnkappadhktgkujygkx3) {
        zrnkappadhktgkujygkx3 = pZrnkappadhktgkujygkx3;
    }

    private Long zrnkappadhktgkujygkx4;

    @Column(name=GenZT_IdouMeisaiRn.ZRNKAPPADHKTGKUJYGKX4)
    public Long getZrnkappadhktgkujygkx4() {
        return zrnkappadhktgkujygkx4;
    }

    public void setZrnkappadhktgkujygkx4(Long pZrnkappadhktgkujygkx4) {
        zrnkappadhktgkujygkx4 = pZrnkappadhktgkujygkx4;
    }

    private Long zrntrkzsgkaiykkjynstmtkzndk;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTRKZSGKAIYKKJYNSTMTKZNDK)
    public Long getZrntrkzsgkaiykkjynstmtkzndk() {
        return zrntrkzsgkaiykkjynstmtkzndk;
    }

    public void setZrntrkzsgkaiykkjynstmtkzndk(Long pZrntrkzsgkaiykkjynstmtkzndk) {
        zrntrkzsgkaiykkjynstmtkzndk = pZrntrkzsgkaiykkjynstmtkzndk;
    }

    private String zrnpmenkouryokuhasseiymd;

    @Column(name=GenZT_IdouMeisaiRn.ZRNPMENKOURYOKUHASSEIYMD)
    public String getZrnpmenkouryokuhasseiymd() {
        return zrnpmenkouryokuhasseiymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnpmenkouryokuhasseiymd(String pZrnpmenkouryokuhasseiymd) {
        zrnpmenkouryokuhasseiymd = pZrnpmenkouryokuhasseiymd;
    }

    private String zrnsuuriyouyobin5;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSUURIYOUYOBIN5)
    public String getZrnsuuriyouyobin5() {
        return zrnsuuriyouyobin5;
    }

    @Padding(mode = "left", padChar = '0', length = 5)
    public void setZrnsuuriyouyobin5(String pZrnsuuriyouyobin5) {
        zrnsuuriyouyobin5 = pZrnsuuriyouyobin5;
    }

    private String zrnsuuriyouyobin13;

    @Column(name=GenZT_IdouMeisaiRn.ZRNSUURIYOUYOBIN13)
    public String getZrnsuuriyouyobin13() {
        return zrnsuuriyouyobin13;
    }

    @Padding(mode = "left", padChar = '0', length = 13)
    public void setZrnsuuriyouyobin13(String pZrnsuuriyouyobin13) {
        zrnsuuriyouyobin13 = pZrnsuuriyouyobin13;
    }

    private Long zrnyobin11x35;

    @Column(name=GenZT_IdouMeisaiRn.ZRNYOBIN11X35)
    public Long getZrnyobin11x35() {
        return zrnyobin11x35;
    }

    public void setZrnyobin11x35(Long pZrnyobin11x35) {
        zrnyobin11x35 = pZrnyobin11x35;
    }

    private Long zrnyobin11x36;

    @Column(name=GenZT_IdouMeisaiRn.ZRNYOBIN11X36)
    public Long getZrnyobin11x36() {
        return zrnyobin11x36;
    }

    public void setZrnyobin11x36(Long pZrnyobin11x36) {
        zrnyobin11x36 = pZrnyobin11x36;
    }

    private Long zrnyobin11x37;

    @Column(name=GenZT_IdouMeisaiRn.ZRNYOBIN11X37)
    public Long getZrnyobin11x37() {
        return zrnyobin11x37;
    }

    public void setZrnyobin11x37(Long pZrnyobin11x37) {
        zrnyobin11x37 = pZrnyobin11x37;
    }

    private String zrntokuyakukoumokuv200;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTOKUYAKUKOUMOKUV200)
    public String getZrntokuyakukoumokuv200() {
        return zrntokuyakukoumokuv200;
    }

    public void setZrntokuyakukoumokuv200(String pZrntokuyakukoumokuv200) {
        zrntokuyakukoumokuv200 = pZrntokuyakukoumokuv200;
    }

    private String zrntokuyakukoumokuv200x2;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTOKUYAKUKOUMOKUV200X2)
    public String getZrntokuyakukoumokuv200x2() {
        return zrntokuyakukoumokuv200x2;
    }

    public void setZrntokuyakukoumokuv200x2(String pZrntokuyakukoumokuv200x2) {
        zrntokuyakukoumokuv200x2 = pZrntokuyakukoumokuv200x2;
    }

    private String zrntokuyakukoumokuv200x3;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTOKUYAKUKOUMOKUV200X3)
    public String getZrntokuyakukoumokuv200x3() {
        return zrntokuyakukoumokuv200x3;
    }

    public void setZrntokuyakukoumokuv200x3(String pZrntokuyakukoumokuv200x3) {
        zrntokuyakukoumokuv200x3 = pZrntokuyakukoumokuv200x3;
    }

    private String zrntokuyakukoumokuv200x4;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTOKUYAKUKOUMOKUV200X4)
    public String getZrntokuyakukoumokuv200x4() {
        return zrntokuyakukoumokuv200x4;
    }

    public void setZrntokuyakukoumokuv200x4(String pZrntokuyakukoumokuv200x4) {
        zrntokuyakukoumokuv200x4 = pZrntokuyakukoumokuv200x4;
    }

    private String zrntokuyakukoumokuv200x5;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTOKUYAKUKOUMOKUV200X5)
    public String getZrntokuyakukoumokuv200x5() {
        return zrntokuyakukoumokuv200x5;
    }

    public void setZrntokuyakukoumokuv200x5(String pZrntokuyakukoumokuv200x5) {
        zrntokuyakukoumokuv200x5 = pZrntokuyakukoumokuv200x5;
    }

    private String zrntokuyakukoumokuv200x6;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTOKUYAKUKOUMOKUV200X6)
    public String getZrntokuyakukoumokuv200x6() {
        return zrntokuyakukoumokuv200x6;
    }

    public void setZrntokuyakukoumokuv200x6(String pZrntokuyakukoumokuv200x6) {
        zrntokuyakukoumokuv200x6 = pZrntokuyakukoumokuv200x6;
    }

    private String zrntokuyakukoumokuv200x7;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTOKUYAKUKOUMOKUV200X7)
    public String getZrntokuyakukoumokuv200x7() {
        return zrntokuyakukoumokuv200x7;
    }

    public void setZrntokuyakukoumokuv200x7(String pZrntokuyakukoumokuv200x7) {
        zrntokuyakukoumokuv200x7 = pZrntokuyakukoumokuv200x7;
    }

    private String zrntokuyakukoumokuv200x8;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTOKUYAKUKOUMOKUV200X8)
    public String getZrntokuyakukoumokuv200x8() {
        return zrntokuyakukoumokuv200x8;
    }

    public void setZrntokuyakukoumokuv200x8(String pZrntokuyakukoumokuv200x8) {
        zrntokuyakukoumokuv200x8 = pZrntokuyakukoumokuv200x8;
    }

    private String zrntokuyakukoumokuv200x9;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTOKUYAKUKOUMOKUV200X9)
    public String getZrntokuyakukoumokuv200x9() {
        return zrntokuyakukoumokuv200x9;
    }

    public void setZrntokuyakukoumokuv200x9(String pZrntokuyakukoumokuv200x9) {
        zrntokuyakukoumokuv200x9 = pZrntokuyakukoumokuv200x9;
    }

    private String zrntokuyakukoumokuv200x10;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTOKUYAKUKOUMOKUV200X10)
    public String getZrntokuyakukoumokuv200x10() {
        return zrntokuyakukoumokuv200x10;
    }

    public void setZrntokuyakukoumokuv200x10(String pZrntokuyakukoumokuv200x10) {
        zrntokuyakukoumokuv200x10 = pZrntokuyakukoumokuv200x10;
    }

    private String zrntokuyakukoumokuv200x11;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTOKUYAKUKOUMOKUV200X11)
    public String getZrntokuyakukoumokuv200x11() {
        return zrntokuyakukoumokuv200x11;
    }

    public void setZrntokuyakukoumokuv200x11(String pZrntokuyakukoumokuv200x11) {
        zrntokuyakukoumokuv200x11 = pZrntokuyakukoumokuv200x11;
    }

    private String zrntokuyakukoumokuv200x12;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTOKUYAKUKOUMOKUV200X12)
    public String getZrntokuyakukoumokuv200x12() {
        return zrntokuyakukoumokuv200x12;
    }

    public void setZrntokuyakukoumokuv200x12(String pZrntokuyakukoumokuv200x12) {
        zrntokuyakukoumokuv200x12 = pZrntokuyakukoumokuv200x12;
    }

    private String zrntokuyakukoumokuv200x13;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTOKUYAKUKOUMOKUV200X13)
    public String getZrntokuyakukoumokuv200x13() {
        return zrntokuyakukoumokuv200x13;
    }

    public void setZrntokuyakukoumokuv200x13(String pZrntokuyakukoumokuv200x13) {
        zrntokuyakukoumokuv200x13 = pZrntokuyakukoumokuv200x13;
    }

    private String zrntokuyakukoumokuv200x14;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTOKUYAKUKOUMOKUV200X14)
    public String getZrntokuyakukoumokuv200x14() {
        return zrntokuyakukoumokuv200x14;
    }

    public void setZrntokuyakukoumokuv200x14(String pZrntokuyakukoumokuv200x14) {
        zrntokuyakukoumokuv200x14 = pZrntokuyakukoumokuv200x14;
    }

    private String zrntokuyakukoumokuv200x15;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTOKUYAKUKOUMOKUV200X15)
    public String getZrntokuyakukoumokuv200x15() {
        return zrntokuyakukoumokuv200x15;
    }

    public void setZrntokuyakukoumokuv200x15(String pZrntokuyakukoumokuv200x15) {
        zrntokuyakukoumokuv200x15 = pZrntokuyakukoumokuv200x15;
    }

    private String zrntokuyakukoumokuv200x16;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTOKUYAKUKOUMOKUV200X16)
    public String getZrntokuyakukoumokuv200x16() {
        return zrntokuyakukoumokuv200x16;
    }

    public void setZrntokuyakukoumokuv200x16(String pZrntokuyakukoumokuv200x16) {
        zrntokuyakukoumokuv200x16 = pZrntokuyakukoumokuv200x16;
    }

    private String zrntokuyakukoumokuv200x17;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTOKUYAKUKOUMOKUV200X17)
    public String getZrntokuyakukoumokuv200x17() {
        return zrntokuyakukoumokuv200x17;
    }

    public void setZrntokuyakukoumokuv200x17(String pZrntokuyakukoumokuv200x17) {
        zrntokuyakukoumokuv200x17 = pZrntokuyakukoumokuv200x17;
    }

    private String zrntokuyakukoumokuv200x18;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTOKUYAKUKOUMOKUV200X18)
    public String getZrntokuyakukoumokuv200x18() {
        return zrntokuyakukoumokuv200x18;
    }

    public void setZrntokuyakukoumokuv200x18(String pZrntokuyakukoumokuv200x18) {
        zrntokuyakukoumokuv200x18 = pZrntokuyakukoumokuv200x18;
    }

    private String zrntokuyakukoumokuv200x19;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTOKUYAKUKOUMOKUV200X19)
    public String getZrntokuyakukoumokuv200x19() {
        return zrntokuyakukoumokuv200x19;
    }

    public void setZrntokuyakukoumokuv200x19(String pZrntokuyakukoumokuv200x19) {
        zrntokuyakukoumokuv200x19 = pZrntokuyakukoumokuv200x19;
    }

    private String zrntokuyakukoumokuv200x20;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTOKUYAKUKOUMOKUV200X20)
    public String getZrntokuyakukoumokuv200x20() {
        return zrntokuyakukoumokuv200x20;
    }

    public void setZrntokuyakukoumokuv200x20(String pZrntokuyakukoumokuv200x20) {
        zrntokuyakukoumokuv200x20 = pZrntokuyakukoumokuv200x20;
    }

    private String zrntokuyakukoumokuv200x21;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTOKUYAKUKOUMOKUV200X21)
    public String getZrntokuyakukoumokuv200x21() {
        return zrntokuyakukoumokuv200x21;
    }

    public void setZrntokuyakukoumokuv200x21(String pZrntokuyakukoumokuv200x21) {
        zrntokuyakukoumokuv200x21 = pZrntokuyakukoumokuv200x21;
    }

    private String zrntokuyakukoumokuv200x22;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTOKUYAKUKOUMOKUV200X22)
    public String getZrntokuyakukoumokuv200x22() {
        return zrntokuyakukoumokuv200x22;
    }

    public void setZrntokuyakukoumokuv200x22(String pZrntokuyakukoumokuv200x22) {
        zrntokuyakukoumokuv200x22 = pZrntokuyakukoumokuv200x22;
    }

    private String zrntokuyakukoumokuv200x23;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTOKUYAKUKOUMOKUV200X23)
    public String getZrntokuyakukoumokuv200x23() {
        return zrntokuyakukoumokuv200x23;
    }

    public void setZrntokuyakukoumokuv200x23(String pZrntokuyakukoumokuv200x23) {
        zrntokuyakukoumokuv200x23 = pZrntokuyakukoumokuv200x23;
    }

    private String zrntokuyakukoumokuv200x24;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTOKUYAKUKOUMOKUV200X24)
    public String getZrntokuyakukoumokuv200x24() {
        return zrntokuyakukoumokuv200x24;
    }

    public void setZrntokuyakukoumokuv200x24(String pZrntokuyakukoumokuv200x24) {
        zrntokuyakukoumokuv200x24 = pZrntokuyakukoumokuv200x24;
    }

    private String zrntokuyakukoumokuv200x25;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTOKUYAKUKOUMOKUV200X25)
    public String getZrntokuyakukoumokuv200x25() {
        return zrntokuyakukoumokuv200x25;
    }

    public void setZrntokuyakukoumokuv200x25(String pZrntokuyakukoumokuv200x25) {
        zrntokuyakukoumokuv200x25 = pZrntokuyakukoumokuv200x25;
    }

    private String zrntokuyakukoumokuv200x26;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTOKUYAKUKOUMOKUV200X26)
    public String getZrntokuyakukoumokuv200x26() {
        return zrntokuyakukoumokuv200x26;
    }

    public void setZrntokuyakukoumokuv200x26(String pZrntokuyakukoumokuv200x26) {
        zrntokuyakukoumokuv200x26 = pZrntokuyakukoumokuv200x26;
    }

    private String zrntokuyakukoumokuv200x27;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTOKUYAKUKOUMOKUV200X27)
    public String getZrntokuyakukoumokuv200x27() {
        return zrntokuyakukoumokuv200x27;
    }

    public void setZrntokuyakukoumokuv200x27(String pZrntokuyakukoumokuv200x27) {
        zrntokuyakukoumokuv200x27 = pZrntokuyakukoumokuv200x27;
    }

    private String zrntokuyakukoumokuv200x28;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTOKUYAKUKOUMOKUV200X28)
    public String getZrntokuyakukoumokuv200x28() {
        return zrntokuyakukoumokuv200x28;
    }

    public void setZrntokuyakukoumokuv200x28(String pZrntokuyakukoumokuv200x28) {
        zrntokuyakukoumokuv200x28 = pZrntokuyakukoumokuv200x28;
    }

    private String zrntokuyakukoumokuv200x29;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTOKUYAKUKOUMOKUV200X29)
    public String getZrntokuyakukoumokuv200x29() {
        return zrntokuyakukoumokuv200x29;
    }

    public void setZrntokuyakukoumokuv200x29(String pZrntokuyakukoumokuv200x29) {
        zrntokuyakukoumokuv200x29 = pZrntokuyakukoumokuv200x29;
    }

    private String zrntokuyakukoumokuv200x30;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTOKUYAKUKOUMOKUV200X30)
    public String getZrntokuyakukoumokuv200x30() {
        return zrntokuyakukoumokuv200x30;
    }

    public void setZrntokuyakukoumokuv200x30(String pZrntokuyakukoumokuv200x30) {
        zrntokuyakukoumokuv200x30 = pZrntokuyakukoumokuv200x30;
    }

    private String zrntokuyakukoumokuv200x31;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTOKUYAKUKOUMOKUV200X31)
    public String getZrntokuyakukoumokuv200x31() {
        return zrntokuyakukoumokuv200x31;
    }

    public void setZrntokuyakukoumokuv200x31(String pZrntokuyakukoumokuv200x31) {
        zrntokuyakukoumokuv200x31 = pZrntokuyakukoumokuv200x31;
    }

    private String zrntokuyakukoumokuv200x32;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTOKUYAKUKOUMOKUV200X32)
    public String getZrntokuyakukoumokuv200x32() {
        return zrntokuyakukoumokuv200x32;
    }

    public void setZrntokuyakukoumokuv200x32(String pZrntokuyakukoumokuv200x32) {
        zrntokuyakukoumokuv200x32 = pZrntokuyakukoumokuv200x32;
    }

    private String zrntokuyakukoumokuv200x33;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTOKUYAKUKOUMOKUV200X33)
    public String getZrntokuyakukoumokuv200x33() {
        return zrntokuyakukoumokuv200x33;
    }

    public void setZrntokuyakukoumokuv200x33(String pZrntokuyakukoumokuv200x33) {
        zrntokuyakukoumokuv200x33 = pZrntokuyakukoumokuv200x33;
    }

    private String zrntokuyakukoumokuv200x34;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTOKUYAKUKOUMOKUV200X34)
    public String getZrntokuyakukoumokuv200x34() {
        return zrntokuyakukoumokuv200x34;
    }

    public void setZrntokuyakukoumokuv200x34(String pZrntokuyakukoumokuv200x34) {
        zrntokuyakukoumokuv200x34 = pZrntokuyakukoumokuv200x34;
    }

    private String zrntokuyakukoumokuv200x35;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTOKUYAKUKOUMOKUV200X35)
    public String getZrntokuyakukoumokuv200x35() {
        return zrntokuyakukoumokuv200x35;
    }

    public void setZrntokuyakukoumokuv200x35(String pZrntokuyakukoumokuv200x35) {
        zrntokuyakukoumokuv200x35 = pZrntokuyakukoumokuv200x35;
    }

    private String zrntokuyakukoumokuv200x36;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTOKUYAKUKOUMOKUV200X36)
    public String getZrntokuyakukoumokuv200x36() {
        return zrntokuyakukoumokuv200x36;
    }

    public void setZrntokuyakukoumokuv200x36(String pZrntokuyakukoumokuv200x36) {
        zrntokuyakukoumokuv200x36 = pZrntokuyakukoumokuv200x36;
    }

    private String zrntokuyakukoumokuv200x37;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTOKUYAKUKOUMOKUV200X37)
    public String getZrntokuyakukoumokuv200x37() {
        return zrntokuyakukoumokuv200x37;
    }

    public void setZrntokuyakukoumokuv200x37(String pZrntokuyakukoumokuv200x37) {
        zrntokuyakukoumokuv200x37 = pZrntokuyakukoumokuv200x37;
    }

    private String zrntokuyakukoumokuv200x38;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTOKUYAKUKOUMOKUV200X38)
    public String getZrntokuyakukoumokuv200x38() {
        return zrntokuyakukoumokuv200x38;
    }

    public void setZrntokuyakukoumokuv200x38(String pZrntokuyakukoumokuv200x38) {
        zrntokuyakukoumokuv200x38 = pZrntokuyakukoumokuv200x38;
    }

    private String zrntokuyakukoumokuv200x39;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTOKUYAKUKOUMOKUV200X39)
    public String getZrntokuyakukoumokuv200x39() {
        return zrntokuyakukoumokuv200x39;
    }

    public void setZrntokuyakukoumokuv200x39(String pZrntokuyakukoumokuv200x39) {
        zrntokuyakukoumokuv200x39 = pZrntokuyakukoumokuv200x39;
    }

    private String zrntokuyakukoumokuv200x40;

    @Column(name=GenZT_IdouMeisaiRn.ZRNTOKUYAKUKOUMOKUV200X40)
    public String getZrntokuyakukoumokuv200x40() {
        return zrntokuyakukoumokuv200x40;
    }

    public void setZrntokuyakukoumokuv200x40(String pZrntokuyakukoumokuv200x40) {
        zrntokuyakukoumokuv200x40 = pZrntokuyakukoumokuv200x40;
    }
}