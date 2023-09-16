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
import yuyu.def.db.entity.ZT_TjHitsyyugkNminusZeroRn;
import yuyu.def.db.id.PKZT_TjHitsyyugkNminusZeroRn;
import yuyu.def.db.meta.GenQZT_TjHitsyyugkNminusZeroRn;
import yuyu.def.db.meta.QZT_TjHitsyyugkNminusZeroRn;

/**
 * 通常配当所要額Ｆ（Ｎ－０）テーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_TjHitsyyugkNminusZeroRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_TjHitsyyugkNminusZeroRn}</td><td colspan="3">通常配当所要額Ｆ（Ｎ－０）テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnsequenceno zrnsequenceno}</td><td>（連携用）シーケンス番号</td><td align="center">{@link PKZT_TjHitsyyugkNminusZeroRn ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnyuukourecordlength zrnyuukourecordlength}</td><td>（連携用）有効レコード長</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnrdwarea zrnrdwarea}</td><td>（連携用）ＲＤＷ領域</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnerrkbnv2 zrnerrkbnv2}</td><td>（連携用）エラー区分Ｖ２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnratekbn zrnratekbn}</td><td>（連携用）レート区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeisandnendo zrnkeisandnendo}</td><td>（連携用）計算Ｄ年度</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeijyouym zrnkeijyouym}</td><td>（連携用）計上年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyouinkbn zrnsyouinkbn}</td><td>（連携用）消因区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkbnkeiriyousegmentkbn zrnkbnkeiriyousegmentkbn}</td><td>（連携用）区分経理用セグメント区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkbnkeiriyourgnbnskkbn zrnkbnkeiriyourgnbnskkbn}</td><td>（連携用）区分経理用利源分析区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukeiyakusyuruicdv2 zrnsyukeiyakusyuruicdv2}</td><td>（連携用）主契約種類コードＶ２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndaihyouyoteiriritu zrndaihyouyoteiriritu}</td><td>（連携用）代表予定利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnharaikatakbn zrnharaikatakbn}</td><td>（連携用）払方区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigohyouji zrnnenkinkaisigohyouji}</td><td>（連携用）年金開始後表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykjyoutai zrnkykjyoutai}</td><td>（連携用）契約状態</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnaizouteikiyoteiriritu zrnnaizouteikiyoteiriritu}</td><td>（連携用）内蔵定期予定利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrngoukeigyousekihyoujis zrngoukeigyousekihyoujis}</td><td>（連携用）合計業績表示Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsykykgyusekihyjs zrnsykykgyusekihyjs}</td><td>（連携用）主契約業績表示Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntnknitjbrsykykgyuskhyjs zrntnknitjbrsykykgyuskhyjs}</td><td>（連携用）転換一時払主契約業績表示Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrndatakanrino zrndatakanrino}</td><td>（連携用）データ管理番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknsyukigou zrnhknsyukigou}</td><td>（連携用）保険種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnannaifuyouriyuukbn zrnannaifuyouriyuukbn}</td><td>（連携用）案内不要理由区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntkbthsyumnryuhyouji zrntkbthsyumnryuhyouji}</td><td>（連携用）特別保障満了表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykymd zrnkykymd}</td><td>（連携用）契約年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknseikbn zrnhhknseikbn}</td><td>（連携用）被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhihokensyaagev2 zrnhihokensyaagev2}</td><td>（連携用）被保険者年令Ｖ２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknkkn zrnhknkkn}</td><td>（連携用）保険期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnphrkkikn zrnphrkkikn}</td><td>（連携用）Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsaimnkkykhyj zrnsaimnkkykhyj}</td><td>（連携用）才満期契約表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkaisuukbn zrnhrkkaisuukbn}</td><td>（連携用）払込回数区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnannaikigetu zrnannaikigetu}</td><td>（連携用）案内期月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnao3tyou3sibousdatehyouji zrnao3tyou3sibousdatehyouji}</td><td>（連携用）青３長３死亡Ｓ建表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkihons zrnkihons}</td><td>（連携用）基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnharaizumiymd zrnharaizumiymd}</td><td>（連携用）払済年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnharaizumis zrnharaizumis}</td><td>（連携用）払済Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnentyous zrnentyous}</td><td>（連携用）延長Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnseizons zrnseizons}</td><td>（連携用）生存Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnpmens zrnpmens}</td><td>（連携用）Ｐ免Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhendous zrnhendous}</td><td>（連携用）変動Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnitibuitijibarais zrnitibuitijibarais}</td><td>（連携用）一部一時払Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntenkanteikisyuruikigou zrntenkanteikisyuruikigou}</td><td>（連携用）転換定期種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntenkanteikikikan zrntenkanteikikikan}</td><td>（連携用）転換定期期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntnknteikinkshrkkn zrntnknteikinkshrkkn}</td><td>（連携用）転換定期年金支払期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngoukeitenkans zrngoukeitenkans}</td><td>（連携用）合計転換Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngoukeitenkanteikis zrngoukeitenkanteikis}</td><td>（連携用）合計転換定期Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngoukeipbubuntenkans zrngoukeipbubuntenkans}</td><td>（連携用）合計Ｐ部分転換Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntenkankaisuu zrntenkankaisuu}</td><td>（連携用）転換回数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndgoukei zrndgoukei}</td><td>（連携用）Ｄ合計</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsrankbetuhisad zrnsrankbetuhisad}</td><td>（連携用）Ｓランク別費差Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsyumtjsrankbetuhisad zrnsyumtjsrankbetuhisad}</td><td>（連携用）消滅時Ｓランク別費差Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnbairitubetuhisad zrnbairitubetuhisad}</td><td>（連携用）倍率別費差Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsyumtjtikbairtbetuhisad zrnsyumtjtikbairtbetuhisad}</td><td>（連携用）消滅時定期倍率別費差Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsyukeiyakukihongoukeid zrnsyukeiyakukihongoukeid}</td><td>（連携用）主契約基本合計Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsyukeiyakukihonsisad zrnsyukeiyakukihonsisad}</td><td>（連携用）主契約基本死差Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsyukeiyakukihonrisad zrnsyukeiyakukihonrisad}</td><td>（連携用）主契約基本利差Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsyukeiyakukihonramudad zrnsyukeiyakukihonramudad}</td><td>（連携用）主契約基本ラムダＤ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsyukeiyakukihonhisad zrnsyukeiyakukihonhisad}</td><td>（連携用）主契約基本費差Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsyukeiyakukihondtaisyous zrnsyukeiyakukihondtaisyous}</td><td>（連携用）主契約基本Ｄ対象Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsyukeiyakukihondyouv zrnsyukeiyakukihondyouv}</td><td>（連携用）主契約基本Ｄ用Ｖ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsyukeiyakukihondkikens zrnsyukeiyakukihondkikens}</td><td>（連携用）主契約基本Ｄ危険Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsykykkhnhisadtisyus zrnsykykkhnhisadtisyus}</td><td>（連携用）主契約基本費差Ｄ対象Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsyukeiyakuteikigoukeid zrnsyukeiyakuteikigoukeid}</td><td>（連携用）主契約定期合計Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsyukeiyakuteikisisad zrnsyukeiyakuteikisisad}</td><td>（連携用）主契約定期死差Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsyukeiyakuteikirisad zrnsyukeiyakuteikirisad}</td><td>（連携用）主契約定期利差Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsyukeiyakuteikiramudad zrnsyukeiyakuteikiramudad}</td><td>（連携用）主契約定期ラムダＤ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsyukeiyakuteikihisad zrnsyukeiyakuteikihisad}</td><td>（連携用）主契約定期費差Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsyukeiyakuteikidtaisyous zrnsyukeiyakuteikidtaisyous}</td><td>（連携用）主契約定期Ｄ対象Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsyukeiyakuteikidyouv zrnsyukeiyakuteikidyouv}</td><td>（連携用）主契約定期Ｄ用Ｖ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsyukeiyakuteikidkikens zrnsyukeiyakuteikidkikens}</td><td>（連携用）主契約定期Ｄ危険Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsykyktikhisadtisyus zrnsykyktikhisadtisyus}</td><td>（連携用）主契約定期費差Ｄ対象Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntenkankihongoukeid zrntenkankihongoukeid}</td><td>（連携用）転換基本合計Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntenkankihonsisad zrntenkankihonsisad}</td><td>（連携用）転換基本死差Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntenkankihonrisad zrntenkankihonrisad}</td><td>（連携用）転換基本利差Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntenkankihonramudad zrntenkankihonramudad}</td><td>（連携用）転換基本ラムダＤ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntenkankihonhisad zrntenkankihonhisad}</td><td>（連携用）転換基本費差Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntenkankihondtaisyous zrntenkankihondtaisyous}</td><td>（連携用）転換基本Ｄ対象Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntenkankihondyouv zrntenkankihondyouv}</td><td>（連携用）転換基本Ｄ用Ｖ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntenkankihondkikens zrntenkankihondkikens}</td><td>（連携用）転換基本Ｄ危険Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntenkankihonhisadtaisyous zrntenkankihonhisadtaisyous}</td><td>（連携用）転換基本費差Ｄ対象Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntenkanteikigoukeid zrntenkanteikigoukeid}</td><td>（連携用）転換定期合計Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntenkanteikisisad zrntenkanteikisisad}</td><td>（連携用）転換定期死差Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntenkanteikirisad zrntenkanteikirisad}</td><td>（連携用）転換定期利差Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntenkanteikiramudad zrntenkanteikiramudad}</td><td>（連携用）転換定期ラムダＤ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntenkanteikihisad zrntenkanteikihisad}</td><td>（連携用）転換定期費差Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntenkanteikidtaisyous zrntenkanteikidtaisyous}</td><td>（連携用）転換定期Ｄ対象Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntenkanteikidyouv zrntenkanteikidyouv}</td><td>（連携用）転換定期Ｄ用Ｖ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntenkanteikidkikens zrntenkanteikidkikens}</td><td>（連携用）転換定期Ｄ危険Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntenkanteikihisadtaisyous zrntenkanteikihisadtaisyous}</td><td>（連携用）転換定期費差Ｄ対象Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsyumtjtyusiyutnkntikgukd zrnsyumtjtyusiyutnkntikgukd}</td><td>（連携用）消滅時調整用転換定期合計Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsyumtjtyusiyutnkntiksisd zrnsyumtjtyusiyutnkntiksisd}</td><td>（連携用）消滅時調整用転換定期死差Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsyumtjtyusiyutnkntikrisd zrnsyumtjtyusiyutnkntikrisd}</td><td>（連携用）消滅時調整用転換定期利差Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsyumtjtyusiyutnkntikhisd zrnsyumtjtyusiyutnkntikhisd}</td><td>（連携用）消滅時調整用転換定期費差Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsyumtjtnkntikdtaisyous zrnsyumtjtnkntikdtaisyous}</td><td>（連携用）消滅時転換定期Ｄ対象Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsyumtjtnkntikdyouv zrnsyumtjtnkntikdyouv}</td><td>（連携用）消滅時転換定期Ｄ用Ｖ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsyumtjtnkntikdkikens zrnsyumtjtnkntikdkikens}</td><td>（連携用）消滅時転換定期Ｄ危険Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhendougoukeid zrnhendougoukeid}</td><td>（連携用）変動合計Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhendousisad zrnhendousisad}</td><td>（連携用）変動死差Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhendouhisad zrnhendouhisad}</td><td>（連携用）変動費差Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhendoudtaisyous zrnhendoudtaisyous}</td><td>（連携用）変動Ｄ対象Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhendoudyouv zrnhendoudyouv}</td><td>（連携用）変動Ｄ用Ｖ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhendoudkikens zrnhendoudkikens}</td><td>（連携用）変動Ｄ危険Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnitibuitijibaraigoukeid zrnitibuitijibaraigoukeid}</td><td>（連携用）一部一時払合計Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnitibuitijibaraisisad zrnitibuitijibaraisisad}</td><td>（連携用）一部一時払死差Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnitibuitijibaraihisad zrnitibuitijibaraihisad}</td><td>（連携用）一部一時払費差Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnitibuitijibaraidtaisyous zrnitibuitijibaraidtaisyous}</td><td>（連携用）一部一時払Ｄ対象Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnitibuitijibaraidyouv zrnitibuitijibaraidyouv}</td><td>（連携用）一部一時払Ｄ用Ｖ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnitibuitijibaraidkikens zrnitibuitijibaraidkikens}</td><td>（連携用）一部一時払Ｄ危険Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnitibitjbrhisadtisyus zrnitibitjbrhisadtisyus}</td><td>（連携用）一部一時払費差Ｄ対象Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnszoukouryokukaisiymd zrnszoukouryokukaisiymd}</td><td>（連携用）Ｓ増効力開始年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnszouhokensyuruikigou zrnszouhokensyuruikigou}</td><td>（連携用）Ｓ増保険種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnszoukikan zrnszoukikan}</td><td>（連携用）Ｓ増期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnszouhihokensyaage zrnszouhihokensyaage}</td><td>（連携用）Ｓ増被保険者年令</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzoukagoukeid zrnzoukagoukeid}</td><td>（連携用）増加合計Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnzoukasisad zrnzoukasisad}</td><td>（連携用）増加死差Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnzoukarisad zrnzoukarisad}</td><td>（連携用）増加利差Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnzoukaramudad zrnzoukaramudad}</td><td>（連携用）増加ラムダＤ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnzoukahisad zrnzoukahisad}</td><td>（連携用）増加費差Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnzoukadtaisyous zrnzoukadtaisyous}</td><td>（連携用）増加Ｄ対象Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnzoukadyouv zrnzoukadyouv}</td><td>（連携用）増加Ｄ用Ｖ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnzoukadkikens zrnzoukadkikens}</td><td>（連携用）増加Ｄ危険Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkakuteikakusasyuruikgu zrnkakuteikakusasyuruikgu}</td><td>（連携用）カク定カクサ種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkakuteikakusad zrnkakuteikakusad}</td><td>（連携用）カク定カクサＤ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkakuteikakusas zrnkakuteikakusas}</td><td>（連携用）カク定カクサＳ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkakuteikakusamanryoujid zrnkakuteikakusamanryoujid}</td><td>（連携用）カク定カクサ満了時Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnnaizoumarusasyuruikigou zrnnaizoumarusasyuruikigou}</td><td>（連携用）内蔵マルサ種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnaizoumarusad zrnnaizoumarusad}</td><td>（連携用）内蔵マルサＤ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnnaizoumarusas zrnnaizoumarusas}</td><td>（連携用）内蔵マルサＳ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnnaizoukakusasyuruikigou zrnnaizoukakusasyuruikigou}</td><td>（連携用）内蔵カクサ種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnaizoukakusad zrnnaizoukakusad}</td><td>（連携用）内蔵カクサＤ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnnaizoukakusas zrnnaizoukakusas}</td><td>（連携用）内蔵カクサＳ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntenkanpbubund zrntenkanpbubund}</td><td>（連携用）転換Ｐ部分Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntenkanpbubunsisad zrntenkanpbubunsisad}</td><td>（連携用）転換Ｐ部分死差Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntenkanpbubunrisad zrntenkanpbubunrisad}</td><td>（連携用）転換Ｐ部分利差Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntenkanpbubunhisad zrntenkanpbubunhisad}</td><td>（連携用）転換Ｐ部分費差Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntenkanpbubundtaisyous zrntenkanpbubundtaisyous}</td><td>（連携用）転換Ｐ部分Ｄ対象Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntenkanpbubundyouv zrntenkanpbubundyouv}</td><td>（連携用）転換Ｐ部分Ｄ用Ｖ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntenkanpbubundkikens zrntenkanpbubundkikens}</td><td>（連携用）転換Ｐ部分Ｄ危険Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnnaizougatateikimud zrnnaizougatateikimud}</td><td>（連携用）内蔵型定期ミューＤ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnnaizougatanenkansanp zrnnaizougatanenkansanp}</td><td>（連携用）内蔵型年換算Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnvhktgbbntnkntikmud zrnvhktgbbntnkntikmud}</td><td>（連携用）Ｖ引継部分転換定期ミューＤ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhikitugitenkanphireimud zrnhikitugitenkanphireimud}</td><td>（連携用）引継転換Ｐ比例ミューＤ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnitibitjbrgyuskhyjs zrnitibitjbrgyuskhyjs}</td><td>（連携用）一部一時払業績表示Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkariwariate4nenmae zrnkariwariate4nenmae}</td><td>（連携用）仮割当（４年前）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkariwariate3nenmae zrnkariwariate3nenmae}</td><td>（連携用）仮割当（３年前）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkariwariate2nenmae zrnkariwariate2nenmae}</td><td>（連携用）仮割当（２年前）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkariwariate1nenmae zrnkariwariate1nenmae}</td><td>（連携用）仮割当（１年前）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngukisisntnkntikmud zrngukisisntnkntikmud}</td><td>（連携用）合計精算転換定期ミューＤ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngoukeiseisanteikis zrngoukeiseisanteikis}</td><td>（連携用）合計精算定期Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngukisisntnknnenknsnp zrngukisisntnknnenknsnp}</td><td>（連携用）合計精算転換年換算Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntnkntikhtnknkykymd zrntnkntikhtnknkykymd}</td><td>（連携用）転換定期被転換契約年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntenkangophireimuritu zrntenkangophireimuritu}</td><td>（連携用）転換後Ｐ比例ミュー率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrngoukeitenkannenkansanp zrngoukeitenkannenkansanp}</td><td>（連携用）合計転換年換算Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngoukeitenkanteikimud zrngoukeitenkanteikimud}</td><td>（連携用）合計転換定期ミューＤ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntyoukikeizokutokubetud zrntyoukikeizokutokubetud}</td><td>（連携用）長期継続特別Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntyouseimaed zrntyouseimaed}</td><td>（連携用）調整前Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntuutokuhituusand zrntuutokuhituusand}</td><td>（連携用）通特非通算Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhknsyuruikigousedaikbn zrnhknsyuruikigousedaikbn}</td><td>（連携用）保険種類記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntenkanteikikigousedaikbn zrntenkanteikikigousedaikbn}</td><td>（連携用）転換定期記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnszoukigousedaikbn zrnszoukigousedaikbn}</td><td>（連携用）Ｓ増記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmankihyouji zrnmankihyouji}</td><td>（連携用）満期表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeiyakuoutoubikbn zrnkeiyakuoutoubikbn}</td><td>（連携用）契約応当日区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin2 zrnsuuriyouyobin2}</td><td>（連携用）数理用予備項目Ｎ２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakuhukasuu zrntokuyakuhukasuu}</td><td>（連携用）特約付加数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x1 zrnhokensyuruikigouyobi1x1}</td><td>（連携用）保険種類記号予備１＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x2 zrnhokensyuruikigouyobi1x2}</td><td>（連携用）保険種類記号予備１＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x3 zrnhokensyuruikigouyobi1x3}</td><td>（連携用）保険種類記号予備１＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x4 zrnhokensyuruikigouyobi1x4}</td><td>（連携用）保険種類記号予備１＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x5 zrnhokensyuruikigouyobi1x5}</td><td>（連携用）保険種類記号予備１＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x6 zrnhokensyuruikigouyobi1x6}</td><td>（連携用）保険種類記号予備１＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x7 zrnhokensyuruikigouyobi1x7}</td><td>（連携用）保険種類記号予備１＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x8 zrnhokensyuruikigouyobi1x8}</td><td>（連携用）保険種類記号予備１＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x9 zrnhokensyuruikigouyobi1x9}</td><td>（連携用）保険種類記号予備１＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x10 zrnhokensyuruikigouyobi1x10}</td><td>（連携用）保険種類記号予備１＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x11 zrnhokensyuruikigouyobi1x11}</td><td>（連携用）保険種類記号予備１＿１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x12 zrnhokensyuruikigouyobi1x12}</td><td>（連携用）保険種類記号予備１＿１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x13 zrnhokensyuruikigouyobi1x13}</td><td>（連携用）保険種類記号予備１＿１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x14 zrnhokensyuruikigouyobi1x14}</td><td>（連携用）保険種類記号予備１＿１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x15 zrnhokensyuruikigouyobi1x15}</td><td>（連携用）保険種類記号予備１＿１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi2x1 zrnhokensyuruikigouyobi2x1}</td><td>（連携用）保険種類記号予備２＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi2x2 zrnhokensyuruikigouyobi2x2}</td><td>（連携用）保険種類記号予備２＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi2x3 zrnhokensyuruikigouyobi2x3}</td><td>（連携用）保険種類記号予備２＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi2x4 zrnhokensyuruikigouyobi2x4}</td><td>（連携用）保険種類記号予備２＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi2x5 zrnhokensyuruikigouyobi2x5}</td><td>（連携用）保険種類記号予備２＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi2x6 zrnhokensyuruikigouyobi2x6}</td><td>（連携用）保険種類記号予備２＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi2x7 zrnhokensyuruikigouyobi2x7}</td><td>（連携用）保険種類記号予備２＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi2x8 zrnhokensyuruikigouyobi2x8}</td><td>（連携用）保険種類記号予備２＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi2x9 zrnhokensyuruikigouyobi2x9}</td><td>（連携用）保険種類記号予備２＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi2x10 zrnhokensyuruikigouyobi2x10}</td><td>（連携用）保険種類記号予備２＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi3x1 zrnhokensyuruikigouyobi3x1}</td><td>（連携用）保険種類記号予備３＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi3x2 zrnhokensyuruikigouyobi3x2}</td><td>（連携用）保険種類記号予備３＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi3x3 zrnhokensyuruikigouyobi3x3}</td><td>（連携用）保険種類記号予備３＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi3x4 zrnhokensyuruikigouyobi3x4}</td><td>（連携用）保険種類記号予備３＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi3x5 zrnhokensyuruikigouyobi3x5}</td><td>（連携用）保険種類記号予備３＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi3x6 zrnhokensyuruikigouyobi3x6}</td><td>（連携用）保険種類記号予備３＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi3x7 zrnhokensyuruikigouyobi3x7}</td><td>（連携用）保険種類記号予備３＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi3x8 zrnhokensyuruikigouyobi3x8}</td><td>（連携用）保険種類記号予備３＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi3x9 zrnhokensyuruikigouyobi3x9}</td><td>（連携用）保険種類記号予備３＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi3x10 zrnhokensyuruikigouyobi3x10}</td><td>（連携用）保険種類記号予備３＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntenkanteikikigouyobix1 zrntenkanteikikigouyobix1}</td><td>（連携用）転換定期記号予備＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntenkanteikikigouyobix2 zrntenkanteikikigouyobix2}</td><td>（連携用）転換定期記号予備＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntenkanteikikigouyobix3 zrntenkanteikikigouyobix3}</td><td>（連携用）転換定期記号予備＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntenkanteikikigouyobix4 zrntenkanteikikigouyobix4}</td><td>（連携用）転換定期記号予備＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntenkanteikikigouyobix5 zrntenkanteikikigouyobix5}</td><td>（連携用）転換定期記号予備＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkakuteikakusakgusdkbn zrnkakuteikakusakgusdkbn}</td><td>（連携用）カク定カクサ記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkakuteikakusakguybx1 zrnkakuteikakusakguybx1}</td><td>（連携用）カク定カクサ記号予備＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkakuteikakusakguybx2 zrnkakuteikakusakguybx2}</td><td>（連携用）カク定カクサ記号予備＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkakuteikakusakguybx3 zrnkakuteikakusakguybx3}</td><td>（連携用）カク定カクサ記号予備＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkakuteikakusakguybx4 zrnkakuteikakusakguybx4}</td><td>（連携用）カク定カクサ記号予備＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkakuteikakusakguybx5 zrnkakuteikakusakguybx5}</td><td>（連携用）カク定カクサ記号予備＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnaizoumarusakgusdkbn zrnnaizoumarusakgusdkbn}</td><td>（連携用）内蔵マルサ記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnaizoumarusakigouyobix1 zrnnaizoumarusakigouyobix1}</td><td>（連携用）内蔵マルサ記号予備＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnaizoumarusakigouyobix2 zrnnaizoumarusakigouyobix2}</td><td>（連携用）内蔵マルサ記号予備＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnaizoumarusakigouyobix3 zrnnaizoumarusakigouyobix3}</td><td>（連携用）内蔵マルサ記号予備＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnaizoumarusakigouyobix4 zrnnaizoumarusakigouyobix4}</td><td>（連携用）内蔵マルサ記号予備＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnaizoumarusakigouyobix5 zrnnaizoumarusakigouyobix5}</td><td>（連携用）内蔵マルサ記号予備＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnaizoukakusakgusdkbn zrnnaizoukakusakgusdkbn}</td><td>（連携用）内蔵カクサ記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnaizoukakusakigouyobix1 zrnnaizoukakusakigouyobix1}</td><td>（連携用）内蔵カクサ記号予備＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnaizoukakusakigouyobix2 zrnnaizoukakusakigouyobix2}</td><td>（連携用）内蔵カクサ記号予備＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnaizoukakusakigouyobix3 zrnnaizoukakusakigouyobix3}</td><td>（連携用）内蔵カクサ記号予備＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnaizoukakusakigouyobix4 zrnnaizoukakusakigouyobix4}</td><td>（連携用）内蔵カクサ記号予備＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnaizoukakusakigouyobix5 zrnnaizoukakusakigouyobix5}</td><td>（連携用）内蔵カクサ記号予備＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv92 zrnyobiv92}</td><td>（連携用）予備項目Ｖ９２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnraysystemhyj zrnraysystemhyj}</td><td>（連携用）ＲＡＹシステム表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngaikakbn zrngaikakbn}</td><td>（連携用）外貨区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkawaserate zrnkawaserate}</td><td>（連携用）為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnkawaseratetekiyouymd zrnkawaseratetekiyouymd}</td><td>（連携用）為替レート適用年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnenkdtsbujsitihsyukngk zrnenkdtsbujsitihsyukngk}</td><td>（連携用）円貨建死亡時最低保証金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin10 zrnsuuriyouyobin10}</td><td>（連携用）数理用予備項目Ｎ１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv10x2 zrnyobiv10x2}</td><td>（連携用）予備項目Ｖ１０＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobin11 zrnyobin11}</td><td>（連携用）予備項目Ｎ１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x2 zrnyobin11x2}</td><td>（連携用）予備項目Ｎ１１＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobiv17 zrnyobiv17}</td><td>（連携用）予備項目Ｖ１７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisadrate zrnsisadrate}</td><td>（連携用）死差Ｄレート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnrisadrate zrnrisadrate}</td><td>（連携用）利差Ｄレート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnhisadrate zrnhisadrate}</td><td>（連携用）費差Ｄレート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrndyouvrate zrndyouvrate}</td><td>（連携用）Ｄ用Ｖレート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnkikensrate zrnkikensrate}</td><td>（連携用）危険Ｓレート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrngoukeidrate zrngoukeidrate}</td><td>（連携用）合計Ｄレート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv180 zrntokuyakukoumokuv180}</td><td>（連携用）特約項目Ｖ１８０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv180x2 zrntokuyakukoumokuv180x2}</td><td>（連携用）特約項目Ｖ１８０＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv180x3 zrntokuyakukoumokuv180x3}</td><td>（連携用）特約項目Ｖ１８０＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv180x4 zrntokuyakukoumokuv180x4}</td><td>（連携用）特約項目Ｖ１８０＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv180x5 zrntokuyakukoumokuv180x5}</td><td>（連携用）特約項目Ｖ１８０＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv180x6 zrntokuyakukoumokuv180x6}</td><td>（連携用）特約項目Ｖ１８０＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv180x7 zrntokuyakukoumokuv180x7}</td><td>（連携用）特約項目Ｖ１８０＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv180x8 zrntokuyakukoumokuv180x8}</td><td>（連携用）特約項目Ｖ１８０＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv180x9 zrntokuyakukoumokuv180x9}</td><td>（連携用）特約項目Ｖ１８０＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv180x10 zrntokuyakukoumokuv180x10}</td><td>（連携用）特約項目Ｖ１８０＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv180x11 zrntokuyakukoumokuv180x11}</td><td>（連携用）特約項目Ｖ１８０＿１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv180x12 zrntokuyakukoumokuv180x12}</td><td>（連携用）特約項目Ｖ１８０＿１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv180x13 zrntokuyakukoumokuv180x13}</td><td>（連携用）特約項目Ｖ１８０＿１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv180x14 zrntokuyakukoumokuv180x14}</td><td>（連携用）特約項目Ｖ１８０＿１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv180x15 zrntokuyakukoumokuv180x15}</td><td>（連携用）特約項目Ｖ１８０＿１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv180x16 zrntokuyakukoumokuv180x16}</td><td>（連携用）特約項目Ｖ１８０＿１６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv180x17 zrntokuyakukoumokuv180x17}</td><td>（連携用）特約項目Ｖ１８０＿１７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv180x18 zrntokuyakukoumokuv180x18}</td><td>（連携用）特約項目Ｖ１８０＿１８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv180x19 zrntokuyakukoumokuv180x19}</td><td>（連携用）特約項目Ｖ１８０＿１９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv180x20 zrntokuyakukoumokuv180x20}</td><td>（連携用）特約項目Ｖ１８０＿２０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv180x21 zrntokuyakukoumokuv180x21}</td><td>（連携用）特約項目Ｖ１８０＿２１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv180x22 zrntokuyakukoumokuv180x22}</td><td>（連携用）特約項目Ｖ１８０＿２２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv180x23 zrntokuyakukoumokuv180x23}</td><td>（連携用）特約項目Ｖ１８０＿２３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv180x24 zrntokuyakukoumokuv180x24}</td><td>（連携用）特約項目Ｖ１８０＿２４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv180x25 zrntokuyakukoumokuv180x25}</td><td>（連携用）特約項目Ｖ１８０＿２５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv180x26 zrntokuyakukoumokuv180x26}</td><td>（連携用）特約項目Ｖ１８０＿２６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv180x27 zrntokuyakukoumokuv180x27}</td><td>（連携用）特約項目Ｖ１８０＿２７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv180x28 zrntokuyakukoumokuv180x28}</td><td>（連携用）特約項目Ｖ１８０＿２８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv180x29 zrntokuyakukoumokuv180x29}</td><td>（連携用）特約項目Ｖ１８０＿２９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv180x30 zrntokuyakukoumokuv180x30}</td><td>（連携用）特約項目Ｖ１８０＿３０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv180x31 zrntokuyakukoumokuv180x31}</td><td>（連携用）特約項目Ｖ１８０＿３１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv180x32 zrntokuyakukoumokuv180x32}</td><td>（連携用）特約項目Ｖ１８０＿３２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv180x33 zrntokuyakukoumokuv180x33}</td><td>（連携用）特約項目Ｖ１８０＿３３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv180x34 zrntokuyakukoumokuv180x34}</td><td>（連携用）特約項目Ｖ１８０＿３４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv180x35 zrntokuyakukoumokuv180x35}</td><td>（連携用）特約項目Ｖ１８０＿３５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv180x36 zrntokuyakukoumokuv180x36}</td><td>（連携用）特約項目Ｖ１８０＿３６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv180x37 zrntokuyakukoumokuv180x37}</td><td>（連携用）特約項目Ｖ１８０＿３７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv180x38 zrntokuyakukoumokuv180x38}</td><td>（連携用）特約項目Ｖ１８０＿３８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv180x39 zrntokuyakukoumokuv180x39}</td><td>（連携用）特約項目Ｖ１８０＿３９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv180x40 zrntokuyakukoumokuv180x40}</td><td>（連携用）特約項目Ｖ１８０＿４０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv180x41 zrntokuyakukoumokuv180x41}</td><td>（連携用）特約項目Ｖ１８０＿４１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv180x42 zrntokuyakukoumokuv180x42}</td><td>（連携用）特約項目Ｖ１８０＿４２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv180x43 zrntokuyakukoumokuv180x43}</td><td>（連携用）特約項目Ｖ１８０＿４３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv180x44 zrntokuyakukoumokuv180x44}</td><td>（連携用）特約項目Ｖ１８０＿４４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv180x45 zrntokuyakukoumokuv180x45}</td><td>（連携用）特約項目Ｖ１８０＿４５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv180x46 zrntokuyakukoumokuv180x46}</td><td>（連携用）特約項目Ｖ１８０＿４６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv180x47 zrntokuyakukoumokuv180x47}</td><td>（連携用）特約項目Ｖ１８０＿４７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv180x48 zrntokuyakukoumokuv180x48}</td><td>（連携用）特約項目Ｖ１８０＿４８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv180x49 zrntokuyakukoumokuv180x49}</td><td>（連携用）特約項目Ｖ１８０＿４９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv180x50 zrntokuyakukoumokuv180x50}</td><td>（連携用）特約項目Ｖ１８０＿５０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_TjHitsyyugkNminusZeroRn
 * @see     PKZT_TjHitsyyugkNminusZeroRn
 * @see     QZT_TjHitsyyugkNminusZeroRn
 * @see     GenQZT_TjHitsyyugkNminusZeroRn
 */
@MappedSuperclass
@Table(name=GenZT_TjHitsyyugkNminusZeroRn.TABLE_NAME)
@IdClass(value=PKZT_TjHitsyyugkNminusZeroRn.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_TjHitsyyugkNminusZeroRn extends AbstractExDBEntityForZDB<ZT_TjHitsyyugkNminusZeroRn, PKZT_TjHitsyyugkNminusZeroRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_TjHitsyyugkNminusZeroRn";
    public static final String ZRNSEQUENCENO            = "zrnsequenceno";
    public static final String ZRNYUUKOURECORDLENGTH    = "zrnyuukourecordlength";
    public static final String ZRNRDWAREA               = "zrnrdwarea";
    public static final String ZRNERRKBNV2              = "zrnerrkbnv2";
    public static final String ZRNRATEKBN               = "zrnratekbn";
    public static final String ZRNKEISANDNENDO          = "zrnkeisandnendo";
    public static final String ZRNKEIJYOUYM             = "zrnkeijyouym";
    public static final String ZRNSYOUINKBN             = "zrnsyouinkbn";
    public static final String ZRNKBNKEIRIYOUSEGMENTKBN = "zrnkbnkeiriyousegmentkbn";
    public static final String ZRNKBNKEIRIYOURGNBNSKKBN = "zrnkbnkeiriyourgnbnskkbn";
    public static final String ZRNSYUKEIYAKUSYURUICDV2  = "zrnsyukeiyakusyuruicdv2";
    public static final String ZRNDAIHYOUYOTEIRIRITU    = "zrndaihyouyoteiriritu";
    public static final String ZRNHARAIKATAKBN          = "zrnharaikatakbn";
    public static final String ZRNNENKINKAISIGOHYOUJI   = "zrnnenkinkaisigohyouji";
    public static final String ZRNKYKJYOUTAI            = "zrnkykjyoutai";
    public static final String ZRNNAIZOUTEIKIYOTEIRIRITU = "zrnnaizouteikiyoteiriritu";
    public static final String ZRNGOUKEIGYOUSEKIHYOUJIS = "zrngoukeigyousekihyoujis";
    public static final String ZRNSYKYKGYUSEKIHYJS      = "zrnsykykgyusekihyjs";
    public static final String ZRNTNKNITJBRSYKYKGYUSKHYJS = "zrntnknitjbrsykykgyuskhyjs";
    public static final String ZRNDATAKANRINO           = "zrndatakanrino";
    public static final String ZRNHKNSYUKIGOU           = "zrnhknsyukigou";
    public static final String ZRNANNAIFUYOURIYUUKBN    = "zrnannaifuyouriyuukbn";
    public static final String ZRNTKBTHSYUMNRYUHYOUJI   = "zrntkbthsyumnryuhyouji";
    public static final String ZRNKYKYMD                = "zrnkykymd";
    public static final String ZRNHHKNSEIKBN            = "zrnhhknseikbn";
    public static final String ZRNHIHOKENSYAAGEV2       = "zrnhihokensyaagev2";
    public static final String ZRNHKNKKN                = "zrnhknkkn";
    public static final String ZRNPHRKKIKN              = "zrnphrkkikn";
    public static final String ZRNSAIMNKKYKHYJ          = "zrnsaimnkkykhyj";
    public static final String ZRNHRKKAISUUKBN          = "zrnhrkkaisuukbn";
    public static final String ZRNANNAIKIGETU           = "zrnannaikigetu";
    public static final String ZRNAO3TYOU3SIBOUSDATEHYOUJI = "zrnao3tyou3sibousdatehyouji";
    public static final String ZRNKIHONS                = "zrnkihons";
    public static final String ZRNHARAIZUMIYMD          = "zrnharaizumiymd";
    public static final String ZRNHARAIZUMIS            = "zrnharaizumis";
    public static final String ZRNENTYOUS               = "zrnentyous";
    public static final String ZRNSEIZONS               = "zrnseizons";
    public static final String ZRNPMENS                 = "zrnpmens";
    public static final String ZRNHENDOUS               = "zrnhendous";
    public static final String ZRNITIBUITIJIBARAIS      = "zrnitibuitijibarais";
    public static final String ZRNTENKANTEIKISYURUIKIGOU = "zrntenkanteikisyuruikigou";
    public static final String ZRNTENKANTEIKIKIKAN      = "zrntenkanteikikikan";
    public static final String ZRNTNKNTEIKINKSHRKKN     = "zrntnknteikinkshrkkn";
    public static final String ZRNGOUKEITENKANS         = "zrngoukeitenkans";
    public static final String ZRNGOUKEITENKANTEIKIS    = "zrngoukeitenkanteikis";
    public static final String ZRNGOUKEIPBUBUNTENKANS   = "zrngoukeipbubuntenkans";
    public static final String ZRNTENKANKAISUU          = "zrntenkankaisuu";
    public static final String ZRNDGOUKEI               = "zrndgoukei";
    public static final String ZRNSRANKBETUHISAD        = "zrnsrankbetuhisad";
    public static final String ZRNSYUMTJSRANKBETUHISAD  = "zrnsyumtjsrankbetuhisad";
    public static final String ZRNBAIRITUBETUHISAD      = "zrnbairitubetuhisad";
    public static final String ZRNSYUMTJTIKBAIRTBETUHISAD = "zrnsyumtjtikbairtbetuhisad";
    public static final String ZRNSYUKEIYAKUKIHONGOUKEID = "zrnsyukeiyakukihongoukeid";
    public static final String ZRNSYUKEIYAKUKIHONSISAD  = "zrnsyukeiyakukihonsisad";
    public static final String ZRNSYUKEIYAKUKIHONRISAD  = "zrnsyukeiyakukihonrisad";
    public static final String ZRNSYUKEIYAKUKIHONRAMUDAD = "zrnsyukeiyakukihonramudad";
    public static final String ZRNSYUKEIYAKUKIHONHISAD  = "zrnsyukeiyakukihonhisad";
    public static final String ZRNSYUKEIYAKUKIHONDTAISYOUS = "zrnsyukeiyakukihondtaisyous";
    public static final String ZRNSYUKEIYAKUKIHONDYOUV  = "zrnsyukeiyakukihondyouv";
    public static final String ZRNSYUKEIYAKUKIHONDKIKENS = "zrnsyukeiyakukihondkikens";
    public static final String ZRNSYKYKKHNHISADTISYUS   = "zrnsykykkhnhisadtisyus";
    public static final String ZRNSYUKEIYAKUTEIKIGOUKEID = "zrnsyukeiyakuteikigoukeid";
    public static final String ZRNSYUKEIYAKUTEIKISISAD  = "zrnsyukeiyakuteikisisad";
    public static final String ZRNSYUKEIYAKUTEIKIRISAD  = "zrnsyukeiyakuteikirisad";
    public static final String ZRNSYUKEIYAKUTEIKIRAMUDAD = "zrnsyukeiyakuteikiramudad";
    public static final String ZRNSYUKEIYAKUTEIKIHISAD  = "zrnsyukeiyakuteikihisad";
    public static final String ZRNSYUKEIYAKUTEIKIDTAISYOUS = "zrnsyukeiyakuteikidtaisyous";
    public static final String ZRNSYUKEIYAKUTEIKIDYOUV  = "zrnsyukeiyakuteikidyouv";
    public static final String ZRNSYUKEIYAKUTEIKIDKIKENS = "zrnsyukeiyakuteikidkikens";
    public static final String ZRNSYKYKTIKHISADTISYUS   = "zrnsykyktikhisadtisyus";
    public static final String ZRNTENKANKIHONGOUKEID    = "zrntenkankihongoukeid";
    public static final String ZRNTENKANKIHONSISAD      = "zrntenkankihonsisad";
    public static final String ZRNTENKANKIHONRISAD      = "zrntenkankihonrisad";
    public static final String ZRNTENKANKIHONRAMUDAD    = "zrntenkankihonramudad";
    public static final String ZRNTENKANKIHONHISAD      = "zrntenkankihonhisad";
    public static final String ZRNTENKANKIHONDTAISYOUS  = "zrntenkankihondtaisyous";
    public static final String ZRNTENKANKIHONDYOUV      = "zrntenkankihondyouv";
    public static final String ZRNTENKANKIHONDKIKENS    = "zrntenkankihondkikens";
    public static final String ZRNTENKANKIHONHISADTAISYOUS = "zrntenkankihonhisadtaisyous";
    public static final String ZRNTENKANTEIKIGOUKEID    = "zrntenkanteikigoukeid";
    public static final String ZRNTENKANTEIKISISAD      = "zrntenkanteikisisad";
    public static final String ZRNTENKANTEIKIRISAD      = "zrntenkanteikirisad";
    public static final String ZRNTENKANTEIKIRAMUDAD    = "zrntenkanteikiramudad";
    public static final String ZRNTENKANTEIKIHISAD      = "zrntenkanteikihisad";
    public static final String ZRNTENKANTEIKIDTAISYOUS  = "zrntenkanteikidtaisyous";
    public static final String ZRNTENKANTEIKIDYOUV      = "zrntenkanteikidyouv";
    public static final String ZRNTENKANTEIKIDKIKENS    = "zrntenkanteikidkikens";
    public static final String ZRNTENKANTEIKIHISADTAISYOUS = "zrntenkanteikihisadtaisyous";
    public static final String ZRNSYUMTJTYUSIYUTNKNTIKGUKD = "zrnsyumtjtyusiyutnkntikgukd";
    public static final String ZRNSYUMTJTYUSIYUTNKNTIKSISD = "zrnsyumtjtyusiyutnkntiksisd";
    public static final String ZRNSYUMTJTYUSIYUTNKNTIKRISD = "zrnsyumtjtyusiyutnkntikrisd";
    public static final String ZRNSYUMTJTYUSIYUTNKNTIKHISD = "zrnsyumtjtyusiyutnkntikhisd";
    public static final String ZRNSYUMTJTNKNTIKDTAISYOUS = "zrnsyumtjtnkntikdtaisyous";
    public static final String ZRNSYUMTJTNKNTIKDYOUV    = "zrnsyumtjtnkntikdyouv";
    public static final String ZRNSYUMTJTNKNTIKDKIKENS  = "zrnsyumtjtnkntikdkikens";
    public static final String ZRNHENDOUGOUKEID         = "zrnhendougoukeid";
    public static final String ZRNHENDOUSISAD           = "zrnhendousisad";
    public static final String ZRNHENDOUHISAD           = "zrnhendouhisad";
    public static final String ZRNHENDOUDTAISYOUS       = "zrnhendoudtaisyous";
    public static final String ZRNHENDOUDYOUV           = "zrnhendoudyouv";
    public static final String ZRNHENDOUDKIKENS         = "zrnhendoudkikens";
    public static final String ZRNITIBUITIJIBARAIGOUKEID = "zrnitibuitijibaraigoukeid";
    public static final String ZRNITIBUITIJIBARAISISAD  = "zrnitibuitijibaraisisad";
    public static final String ZRNITIBUITIJIBARAIHISAD  = "zrnitibuitijibaraihisad";
    public static final String ZRNITIBUITIJIBARAIDTAISYOUS = "zrnitibuitijibaraidtaisyous";
    public static final String ZRNITIBUITIJIBARAIDYOUV  = "zrnitibuitijibaraidyouv";
    public static final String ZRNITIBUITIJIBARAIDKIKENS = "zrnitibuitijibaraidkikens";
    public static final String ZRNITIBITJBRHISADTISYUS  = "zrnitibitjbrhisadtisyus";
    public static final String ZRNSZOUKOURYOKUKAISIYMD  = "zrnszoukouryokukaisiymd";
    public static final String ZRNSZOUHOKENSYURUIKIGOU  = "zrnszouhokensyuruikigou";
    public static final String ZRNSZOUKIKAN             = "zrnszoukikan";
    public static final String ZRNSZOUHIHOKENSYAAGE     = "zrnszouhihokensyaage";
    public static final String ZRNZOUKAGOUKEID          = "zrnzoukagoukeid";
    public static final String ZRNZOUKASISAD            = "zrnzoukasisad";
    public static final String ZRNZOUKARISAD            = "zrnzoukarisad";
    public static final String ZRNZOUKARAMUDAD          = "zrnzoukaramudad";
    public static final String ZRNZOUKAHISAD            = "zrnzoukahisad";
    public static final String ZRNZOUKADTAISYOUS        = "zrnzoukadtaisyous";
    public static final String ZRNZOUKADYOUV            = "zrnzoukadyouv";
    public static final String ZRNZOUKADKIKENS          = "zrnzoukadkikens";
    public static final String ZRNKAKUTEIKAKUSASYURUIKGU = "zrnkakuteikakusasyuruikgu";
    public static final String ZRNKAKUTEIKAKUSAD        = "zrnkakuteikakusad";
    public static final String ZRNKAKUTEIKAKUSAS        = "zrnkakuteikakusas";
    public static final String ZRNKAKUTEIKAKUSAMANRYOUJID = "zrnkakuteikakusamanryoujid";
    public static final String ZRNNAIZOUMARUSASYURUIKIGOU = "zrnnaizoumarusasyuruikigou";
    public static final String ZRNNAIZOUMARUSAD         = "zrnnaizoumarusad";
    public static final String ZRNNAIZOUMARUSAS         = "zrnnaizoumarusas";
    public static final String ZRNNAIZOUKAKUSASYURUIKIGOU = "zrnnaizoukakusasyuruikigou";
    public static final String ZRNNAIZOUKAKUSAD         = "zrnnaizoukakusad";
    public static final String ZRNNAIZOUKAKUSAS         = "zrnnaizoukakusas";
    public static final String ZRNTENKANPBUBUND         = "zrntenkanpbubund";
    public static final String ZRNTENKANPBUBUNSISAD     = "zrntenkanpbubunsisad";
    public static final String ZRNTENKANPBUBUNRISAD     = "zrntenkanpbubunrisad";
    public static final String ZRNTENKANPBUBUNHISAD     = "zrntenkanpbubunhisad";
    public static final String ZRNTENKANPBUBUNDTAISYOUS = "zrntenkanpbubundtaisyous";
    public static final String ZRNTENKANPBUBUNDYOUV     = "zrntenkanpbubundyouv";
    public static final String ZRNTENKANPBUBUNDKIKENS   = "zrntenkanpbubundkikens";
    public static final String ZRNNAIZOUGATATEIKIMUD    = "zrnnaizougatateikimud";
    public static final String ZRNNAIZOUGATANENKANSANP  = "zrnnaizougatanenkansanp";
    public static final String ZRNVHKTGBBNTNKNTIKMUD    = "zrnvhktgbbntnkntikmud";
    public static final String ZRNHIKITUGITENKANPHIREIMUD = "zrnhikitugitenkanphireimud";
    public static final String ZRNITIBITJBRGYUSKHYJS    = "zrnitibitjbrgyuskhyjs";
    public static final String ZRNKARIWARIATE4NENMAE    = "zrnkariwariate4nenmae";
    public static final String ZRNKARIWARIATE3NENMAE    = "zrnkariwariate3nenmae";
    public static final String ZRNKARIWARIATE2NENMAE    = "zrnkariwariate2nenmae";
    public static final String ZRNKARIWARIATE1NENMAE    = "zrnkariwariate1nenmae";
    public static final String ZRNGUKISISNTNKNTIKMUD    = "zrngukisisntnkntikmud";
    public static final String ZRNGOUKEISEISANTEIKIS    = "zrngoukeiseisanteikis";
    public static final String ZRNGUKISISNTNKNNENKNSNP  = "zrngukisisntnknnenknsnp";
    public static final String ZRNTNKNTIKHTNKNKYKYMD    = "zrntnkntikhtnknkykymd";
    public static final String ZRNTENKANGOPHIREIMURITU  = "zrntenkangophireimuritu";
    public static final String ZRNGOUKEITENKANNENKANSANP = "zrngoukeitenkannenkansanp";
    public static final String ZRNGOUKEITENKANTEIKIMUD  = "zrngoukeitenkanteikimud";
    public static final String ZRNTYOUKIKEIZOKUTOKUBETUD = "zrntyoukikeizokutokubetud";
    public static final String ZRNTYOUSEIMAED           = "zrntyouseimaed";
    public static final String ZRNTUUTOKUHITUUSAND      = "zrntuutokuhituusand";
    public static final String ZRNHKNSYURUIKIGOUSEDAIKBN = "zrnhknsyuruikigousedaikbn";
    public static final String ZRNTENKANTEIKIKIGOUSEDAIKBN = "zrntenkanteikikigousedaikbn";
    public static final String ZRNSZOUKIGOUSEDAIKBN     = "zrnszoukigousedaikbn";
    public static final String ZRNMANKIHYOUJI           = "zrnmankihyouji";
    public static final String ZRNKEIYAKUOUTOUBIKBN     = "zrnkeiyakuoutoubikbn";
    public static final String ZRNSUURIYOUYOBIN2        = "zrnsuuriyouyobin2";
    public static final String ZRNTOKUYAKUHUKASUU       = "zrntokuyakuhukasuu";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X1 = "zrnhokensyuruikigouyobi1x1";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X2 = "zrnhokensyuruikigouyobi1x2";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X3 = "zrnhokensyuruikigouyobi1x3";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X4 = "zrnhokensyuruikigouyobi1x4";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X5 = "zrnhokensyuruikigouyobi1x5";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X6 = "zrnhokensyuruikigouyobi1x6";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X7 = "zrnhokensyuruikigouyobi1x7";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X8 = "zrnhokensyuruikigouyobi1x8";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X9 = "zrnhokensyuruikigouyobi1x9";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X10 = "zrnhokensyuruikigouyobi1x10";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X11 = "zrnhokensyuruikigouyobi1x11";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X12 = "zrnhokensyuruikigouyobi1x12";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X13 = "zrnhokensyuruikigouyobi1x13";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X14 = "zrnhokensyuruikigouyobi1x14";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X15 = "zrnhokensyuruikigouyobi1x15";
    public static final String ZRNHOKENSYURUIKIGOUYOBI2X1 = "zrnhokensyuruikigouyobi2x1";
    public static final String ZRNHOKENSYURUIKIGOUYOBI2X2 = "zrnhokensyuruikigouyobi2x2";
    public static final String ZRNHOKENSYURUIKIGOUYOBI2X3 = "zrnhokensyuruikigouyobi2x3";
    public static final String ZRNHOKENSYURUIKIGOUYOBI2X4 = "zrnhokensyuruikigouyobi2x4";
    public static final String ZRNHOKENSYURUIKIGOUYOBI2X5 = "zrnhokensyuruikigouyobi2x5";
    public static final String ZRNHOKENSYURUIKIGOUYOBI2X6 = "zrnhokensyuruikigouyobi2x6";
    public static final String ZRNHOKENSYURUIKIGOUYOBI2X7 = "zrnhokensyuruikigouyobi2x7";
    public static final String ZRNHOKENSYURUIKIGOUYOBI2X8 = "zrnhokensyuruikigouyobi2x8";
    public static final String ZRNHOKENSYURUIKIGOUYOBI2X9 = "zrnhokensyuruikigouyobi2x9";
    public static final String ZRNHOKENSYURUIKIGOUYOBI2X10 = "zrnhokensyuruikigouyobi2x10";
    public static final String ZRNHOKENSYURUIKIGOUYOBI3X1 = "zrnhokensyuruikigouyobi3x1";
    public static final String ZRNHOKENSYURUIKIGOUYOBI3X2 = "zrnhokensyuruikigouyobi3x2";
    public static final String ZRNHOKENSYURUIKIGOUYOBI3X3 = "zrnhokensyuruikigouyobi3x3";
    public static final String ZRNHOKENSYURUIKIGOUYOBI3X4 = "zrnhokensyuruikigouyobi3x4";
    public static final String ZRNHOKENSYURUIKIGOUYOBI3X5 = "zrnhokensyuruikigouyobi3x5";
    public static final String ZRNHOKENSYURUIKIGOUYOBI3X6 = "zrnhokensyuruikigouyobi3x6";
    public static final String ZRNHOKENSYURUIKIGOUYOBI3X7 = "zrnhokensyuruikigouyobi3x7";
    public static final String ZRNHOKENSYURUIKIGOUYOBI3X8 = "zrnhokensyuruikigouyobi3x8";
    public static final String ZRNHOKENSYURUIKIGOUYOBI3X9 = "zrnhokensyuruikigouyobi3x9";
    public static final String ZRNHOKENSYURUIKIGOUYOBI3X10 = "zrnhokensyuruikigouyobi3x10";
    public static final String ZRNTENKANTEIKIKIGOUYOBIX1 = "zrntenkanteikikigouyobix1";
    public static final String ZRNTENKANTEIKIKIGOUYOBIX2 = "zrntenkanteikikigouyobix2";
    public static final String ZRNTENKANTEIKIKIGOUYOBIX3 = "zrntenkanteikikigouyobix3";
    public static final String ZRNTENKANTEIKIKIGOUYOBIX4 = "zrntenkanteikikigouyobix4";
    public static final String ZRNTENKANTEIKIKIGOUYOBIX5 = "zrntenkanteikikigouyobix5";
    public static final String ZRNKAKUTEIKAKUSAKGUSDKBN = "zrnkakuteikakusakgusdkbn";
    public static final String ZRNKAKUTEIKAKUSAKGUYBX1  = "zrnkakuteikakusakguybx1";
    public static final String ZRNKAKUTEIKAKUSAKGUYBX2  = "zrnkakuteikakusakguybx2";
    public static final String ZRNKAKUTEIKAKUSAKGUYBX3  = "zrnkakuteikakusakguybx3";
    public static final String ZRNKAKUTEIKAKUSAKGUYBX4  = "zrnkakuteikakusakguybx4";
    public static final String ZRNKAKUTEIKAKUSAKGUYBX5  = "zrnkakuteikakusakguybx5";
    public static final String ZRNNAIZOUMARUSAKGUSDKBN  = "zrnnaizoumarusakgusdkbn";
    public static final String ZRNNAIZOUMARUSAKIGOUYOBIX1 = "zrnnaizoumarusakigouyobix1";
    public static final String ZRNNAIZOUMARUSAKIGOUYOBIX2 = "zrnnaizoumarusakigouyobix2";
    public static final String ZRNNAIZOUMARUSAKIGOUYOBIX3 = "zrnnaizoumarusakigouyobix3";
    public static final String ZRNNAIZOUMARUSAKIGOUYOBIX4 = "zrnnaizoumarusakigouyobix4";
    public static final String ZRNNAIZOUMARUSAKIGOUYOBIX5 = "zrnnaizoumarusakigouyobix5";
    public static final String ZRNNAIZOUKAKUSAKGUSDKBN  = "zrnnaizoukakusakgusdkbn";
    public static final String ZRNNAIZOUKAKUSAKIGOUYOBIX1 = "zrnnaizoukakusakigouyobix1";
    public static final String ZRNNAIZOUKAKUSAKIGOUYOBIX2 = "zrnnaizoukakusakigouyobix2";
    public static final String ZRNNAIZOUKAKUSAKIGOUYOBIX3 = "zrnnaizoukakusakigouyobix3";
    public static final String ZRNNAIZOUKAKUSAKIGOUYOBIX4 = "zrnnaizoukakusakigouyobix4";
    public static final String ZRNNAIZOUKAKUSAKIGOUYOBIX5 = "zrnnaizoukakusakigouyobix5";
    public static final String ZRNYOBIV92               = "zrnyobiv92";
    public static final String ZRNRAYSYSTEMHYJ          = "zrnraysystemhyj";
    public static final String ZRNGAIKAKBN              = "zrngaikakbn";
    public static final String ZRNKAWASERATE            = "zrnkawaserate";
    public static final String ZRNKAWASERATETEKIYOUYMD  = "zrnkawaseratetekiyouymd";
    public static final String ZRNENKDTSBUJSITIHSYUKNGK = "zrnenkdtsbujsitihsyukngk";
    public static final String ZRNSUURIYOUYOBIN10       = "zrnsuuriyouyobin10";
    public static final String ZRNYOBIV10X2             = "zrnyobiv10x2";
    public static final String ZRNYOBIN11               = "zrnyobin11";
    public static final String ZRNYOBIN11X2             = "zrnyobin11x2";
    public static final String ZRNYOBIV17               = "zrnyobiv17";
    public static final String ZRNSISADRATE             = "zrnsisadrate";
    public static final String ZRNRISADRATE             = "zrnrisadrate";
    public static final String ZRNHISADRATE             = "zrnhisadrate";
    public static final String ZRNDYOUVRATE             = "zrndyouvrate";
    public static final String ZRNKIKENSRATE            = "zrnkikensrate";
    public static final String ZRNGOUKEIDRATE           = "zrngoukeidrate";
    public static final String ZRNTOKUYAKUKOUMOKUV180   = "zrntokuyakukoumokuv180";
    public static final String ZRNTOKUYAKUKOUMOKUV180X2 = "zrntokuyakukoumokuv180x2";
    public static final String ZRNTOKUYAKUKOUMOKUV180X3 = "zrntokuyakukoumokuv180x3";
    public static final String ZRNTOKUYAKUKOUMOKUV180X4 = "zrntokuyakukoumokuv180x4";
    public static final String ZRNTOKUYAKUKOUMOKUV180X5 = "zrntokuyakukoumokuv180x5";
    public static final String ZRNTOKUYAKUKOUMOKUV180X6 = "zrntokuyakukoumokuv180x6";
    public static final String ZRNTOKUYAKUKOUMOKUV180X7 = "zrntokuyakukoumokuv180x7";
    public static final String ZRNTOKUYAKUKOUMOKUV180X8 = "zrntokuyakukoumokuv180x8";
    public static final String ZRNTOKUYAKUKOUMOKUV180X9 = "zrntokuyakukoumokuv180x9";
    public static final String ZRNTOKUYAKUKOUMOKUV180X10 = "zrntokuyakukoumokuv180x10";
    public static final String ZRNTOKUYAKUKOUMOKUV180X11 = "zrntokuyakukoumokuv180x11";
    public static final String ZRNTOKUYAKUKOUMOKUV180X12 = "zrntokuyakukoumokuv180x12";
    public static final String ZRNTOKUYAKUKOUMOKUV180X13 = "zrntokuyakukoumokuv180x13";
    public static final String ZRNTOKUYAKUKOUMOKUV180X14 = "zrntokuyakukoumokuv180x14";
    public static final String ZRNTOKUYAKUKOUMOKUV180X15 = "zrntokuyakukoumokuv180x15";
    public static final String ZRNTOKUYAKUKOUMOKUV180X16 = "zrntokuyakukoumokuv180x16";
    public static final String ZRNTOKUYAKUKOUMOKUV180X17 = "zrntokuyakukoumokuv180x17";
    public static final String ZRNTOKUYAKUKOUMOKUV180X18 = "zrntokuyakukoumokuv180x18";
    public static final String ZRNTOKUYAKUKOUMOKUV180X19 = "zrntokuyakukoumokuv180x19";
    public static final String ZRNTOKUYAKUKOUMOKUV180X20 = "zrntokuyakukoumokuv180x20";
    public static final String ZRNTOKUYAKUKOUMOKUV180X21 = "zrntokuyakukoumokuv180x21";
    public static final String ZRNTOKUYAKUKOUMOKUV180X22 = "zrntokuyakukoumokuv180x22";
    public static final String ZRNTOKUYAKUKOUMOKUV180X23 = "zrntokuyakukoumokuv180x23";
    public static final String ZRNTOKUYAKUKOUMOKUV180X24 = "zrntokuyakukoumokuv180x24";
    public static final String ZRNTOKUYAKUKOUMOKUV180X25 = "zrntokuyakukoumokuv180x25";
    public static final String ZRNTOKUYAKUKOUMOKUV180X26 = "zrntokuyakukoumokuv180x26";
    public static final String ZRNTOKUYAKUKOUMOKUV180X27 = "zrntokuyakukoumokuv180x27";
    public static final String ZRNTOKUYAKUKOUMOKUV180X28 = "zrntokuyakukoumokuv180x28";
    public static final String ZRNTOKUYAKUKOUMOKUV180X29 = "zrntokuyakukoumokuv180x29";
    public static final String ZRNTOKUYAKUKOUMOKUV180X30 = "zrntokuyakukoumokuv180x30";
    public static final String ZRNTOKUYAKUKOUMOKUV180X31 = "zrntokuyakukoumokuv180x31";
    public static final String ZRNTOKUYAKUKOUMOKUV180X32 = "zrntokuyakukoumokuv180x32";
    public static final String ZRNTOKUYAKUKOUMOKUV180X33 = "zrntokuyakukoumokuv180x33";
    public static final String ZRNTOKUYAKUKOUMOKUV180X34 = "zrntokuyakukoumokuv180x34";
    public static final String ZRNTOKUYAKUKOUMOKUV180X35 = "zrntokuyakukoumokuv180x35";
    public static final String ZRNTOKUYAKUKOUMOKUV180X36 = "zrntokuyakukoumokuv180x36";
    public static final String ZRNTOKUYAKUKOUMOKUV180X37 = "zrntokuyakukoumokuv180x37";
    public static final String ZRNTOKUYAKUKOUMOKUV180X38 = "zrntokuyakukoumokuv180x38";
    public static final String ZRNTOKUYAKUKOUMOKUV180X39 = "zrntokuyakukoumokuv180x39";
    public static final String ZRNTOKUYAKUKOUMOKUV180X40 = "zrntokuyakukoumokuv180x40";
    public static final String ZRNTOKUYAKUKOUMOKUV180X41 = "zrntokuyakukoumokuv180x41";
    public static final String ZRNTOKUYAKUKOUMOKUV180X42 = "zrntokuyakukoumokuv180x42";
    public static final String ZRNTOKUYAKUKOUMOKUV180X43 = "zrntokuyakukoumokuv180x43";
    public static final String ZRNTOKUYAKUKOUMOKUV180X44 = "zrntokuyakukoumokuv180x44";
    public static final String ZRNTOKUYAKUKOUMOKUV180X45 = "zrntokuyakukoumokuv180x45";
    public static final String ZRNTOKUYAKUKOUMOKUV180X46 = "zrntokuyakukoumokuv180x46";
    public static final String ZRNTOKUYAKUKOUMOKUV180X47 = "zrntokuyakukoumokuv180x47";
    public static final String ZRNTOKUYAKUKOUMOKUV180X48 = "zrntokuyakukoumokuv180x48";
    public static final String ZRNTOKUYAKUKOUMOKUV180X49 = "zrntokuyakukoumokuv180x49";
    public static final String ZRNTOKUYAKUKOUMOKUV180X50 = "zrntokuyakukoumokuv180x50";

    private final PKZT_TjHitsyyugkNminusZeroRn primaryKey;

    public GenZT_TjHitsyyugkNminusZeroRn() {
        primaryKey = new PKZT_TjHitsyyugkNminusZeroRn();
    }

    public GenZT_TjHitsyyugkNminusZeroRn(Integer pZrnsequenceno) {
        primaryKey = new PKZT_TjHitsyyugkNminusZeroRn(pZrnsequenceno);
    }

    @Transient
    @Override
    public PKZT_TjHitsyyugkNminusZeroRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_TjHitsyyugkNminusZeroRn> getMetaClass() {
        return QZT_TjHitsyyugkNminusZeroRn.class;
    }

    @Id
    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNSEQUENCENO)
    public Integer getZrnsequenceno() {
        return getPrimaryKey().getZrnsequenceno();
    }

    public void setZrnsequenceno(Integer pZrnsequenceno) {
        getPrimaryKey().setZrnsequenceno(pZrnsequenceno);
    }

    private Integer zrnyuukourecordlength;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNYUUKOURECORDLENGTH)
    public Integer getZrnyuukourecordlength() {
        return zrnyuukourecordlength;
    }

    public void setZrnyuukourecordlength(Integer pZrnyuukourecordlength) {
        zrnyuukourecordlength = pZrnyuukourecordlength;
    }

    private String zrnrdwarea;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNRDWAREA)
    public String getZrnrdwarea() {
        return zrnrdwarea;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrnrdwarea(String pZrnrdwarea) {
        zrnrdwarea = pZrnrdwarea;
    }

    private String zrnerrkbnv2;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNERRKBNV2)
    public String getZrnerrkbnv2() {
        return zrnerrkbnv2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnerrkbnv2(String pZrnerrkbnv2) {
        zrnerrkbnv2 = pZrnerrkbnv2;
    }

    private String zrnratekbn;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNRATEKBN)
    public String getZrnratekbn() {
        return zrnratekbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnratekbn(String pZrnratekbn) {
        zrnratekbn = pZrnratekbn;
    }

    private String zrnkeisandnendo;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNKEISANDNENDO)
    public String getZrnkeisandnendo() {
        return zrnkeisandnendo;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrnkeisandnendo(String pZrnkeisandnendo) {
        zrnkeisandnendo = pZrnkeisandnendo;
    }

    private String zrnkeijyouym;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNKEIJYOUYM)
    public String getZrnkeijyouym() {
        return zrnkeijyouym;
    }

    public void setZrnkeijyouym(String pZrnkeijyouym) {
        zrnkeijyouym = pZrnkeijyouym;
    }

    private String zrnsyouinkbn;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNSYOUINKBN)
    public String getZrnsyouinkbn() {
        return zrnsyouinkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsyouinkbn(String pZrnsyouinkbn) {
        zrnsyouinkbn = pZrnsyouinkbn;
    }

    private String zrnkbnkeiriyousegmentkbn;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNKBNKEIRIYOUSEGMENTKBN)
    public String getZrnkbnkeiriyousegmentkbn() {
        return zrnkbnkeiriyousegmentkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkbnkeiriyousegmentkbn(String pZrnkbnkeiriyousegmentkbn) {
        zrnkbnkeiriyousegmentkbn = pZrnkbnkeiriyousegmentkbn;
    }

    private String zrnkbnkeiriyourgnbnskkbn;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNKBNKEIRIYOURGNBNSKKBN)
    public String getZrnkbnkeiriyourgnbnskkbn() {
        return zrnkbnkeiriyourgnbnskkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkbnkeiriyourgnbnskkbn(String pZrnkbnkeiriyourgnbnskkbn) {
        zrnkbnkeiriyourgnbnskkbn = pZrnkbnkeiriyourgnbnskkbn;
    }

    private String zrnsyukeiyakusyuruicdv2;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNSYUKEIYAKUSYURUICDV2)
    public String getZrnsyukeiyakusyuruicdv2() {
        return zrnsyukeiyakusyuruicdv2;
    }

    public void setZrnsyukeiyakusyuruicdv2(String pZrnsyukeiyakusyuruicdv2) {
        zrnsyukeiyakusyuruicdv2 = pZrnsyukeiyakusyuruicdv2;
    }

    private BizNumber zrndaihyouyoteiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNDAIHYOUYOTEIRIRITU)
    public BizNumber getZrndaihyouyoteiriritu() {
        return zrndaihyouyoteiriritu;
    }

    public void setZrndaihyouyoteiriritu(BizNumber pZrndaihyouyoteiriritu) {
        zrndaihyouyoteiriritu = pZrndaihyouyoteiriritu;
    }

    private String zrnharaikatakbn;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNHARAIKATAKBN)
    public String getZrnharaikatakbn() {
        return zrnharaikatakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnharaikatakbn(String pZrnharaikatakbn) {
        zrnharaikatakbn = pZrnharaikatakbn;
    }

    private String zrnnenkinkaisigohyouji;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNNENKINKAISIGOHYOUJI)
    public String getZrnnenkinkaisigohyouji() {
        return zrnnenkinkaisigohyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnnenkinkaisigohyouji(String pZrnnenkinkaisigohyouji) {
        zrnnenkinkaisigohyouji = pZrnnenkinkaisigohyouji;
    }

    private String zrnkykjyoutai;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNKYKJYOUTAI)
    public String getZrnkykjyoutai() {
        return zrnkykjyoutai;
    }

    public void setZrnkykjyoutai(String pZrnkykjyoutai) {
        zrnkykjyoutai = pZrnkykjyoutai;
    }

    private BizNumber zrnnaizouteikiyoteiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNNAIZOUTEIKIYOTEIRIRITU)
    public BizNumber getZrnnaizouteikiyoteiriritu() {
        return zrnnaizouteikiyoteiriritu;
    }

    public void setZrnnaizouteikiyoteiriritu(BizNumber pZrnnaizouteikiyoteiriritu) {
        zrnnaizouteikiyoteiriritu = pZrnnaizouteikiyoteiriritu;
    }

    private Long zrngoukeigyousekihyoujis;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNGOUKEIGYOUSEKIHYOUJIS)
    public Long getZrngoukeigyousekihyoujis() {
        return zrngoukeigyousekihyoujis;
    }

    public void setZrngoukeigyousekihyoujis(Long pZrngoukeigyousekihyoujis) {
        zrngoukeigyousekihyoujis = pZrngoukeigyousekihyoujis;
    }

    private Long zrnsykykgyusekihyjs;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNSYKYKGYUSEKIHYJS)
    public Long getZrnsykykgyusekihyjs() {
        return zrnsykykgyusekihyjs;
    }

    public void setZrnsykykgyusekihyjs(Long pZrnsykykgyusekihyjs) {
        zrnsykykgyusekihyjs = pZrnsykykgyusekihyjs;
    }

    private Long zrntnknitjbrsykykgyuskhyjs;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTNKNITJBRSYKYKGYUSKHYJS)
    public Long getZrntnknitjbrsykykgyuskhyjs() {
        return zrntnknitjbrsykykgyuskhyjs;
    }

    public void setZrntnknitjbrsykykgyuskhyjs(Long pZrntnknitjbrsykykgyuskhyjs) {
        zrntnknitjbrsykykgyuskhyjs = pZrntnknitjbrsykykgyuskhyjs;
    }

    private String zrndatakanrino;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNDATAKANRINO)
    public String getZrndatakanrino() {
        return zrndatakanrino;
    }

    public void setZrndatakanrino(String pZrndatakanrino) {
        zrndatakanrino = pZrndatakanrino;
    }

    private String zrnhknsyukigou;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNHKNSYUKIGOU)
    public String getZrnhknsyukigou() {
        return zrnhknsyukigou;
    }

    public void setZrnhknsyukigou(String pZrnhknsyukigou) {
        zrnhknsyukigou = pZrnhknsyukigou;
    }

    private String zrnannaifuyouriyuukbn;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNANNAIFUYOURIYUUKBN)
    public String getZrnannaifuyouriyuukbn() {
        return zrnannaifuyouriyuukbn;
    }

    public void setZrnannaifuyouriyuukbn(String pZrnannaifuyouriyuukbn) {
        zrnannaifuyouriyuukbn = pZrnannaifuyouriyuukbn;
    }

    private String zrntkbthsyumnryuhyouji;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTKBTHSYUMNRYUHYOUJI)
    public String getZrntkbthsyumnryuhyouji() {
        return zrntkbthsyumnryuhyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntkbthsyumnryuhyouji(String pZrntkbthsyumnryuhyouji) {
        zrntkbthsyumnryuhyouji = pZrntkbthsyumnryuhyouji;
    }

    private String zrnkykymd;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNKYKYMD)
    public String getZrnkykymd() {
        return zrnkykymd;
    }

    public void setZrnkykymd(String pZrnkykymd) {
        zrnkykymd = pZrnkykymd;
    }

    private String zrnhhknseikbn;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNHHKNSEIKBN)
    public String getZrnhhknseikbn() {
        return zrnhhknseikbn;
    }

    public void setZrnhhknseikbn(String pZrnhhknseikbn) {
        zrnhhknseikbn = pZrnhhknseikbn;
    }

    private String zrnhihokensyaagev2;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNHIHOKENSYAAGEV2)
    public String getZrnhihokensyaagev2() {
        return zrnhihokensyaagev2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhihokensyaagev2(String pZrnhihokensyaagev2) {
        zrnhihokensyaagev2 = pZrnhihokensyaagev2;
    }

    private String zrnhknkkn;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNHKNKKN)
    public String getZrnhknkkn() {
        return zrnhknkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhknkkn(String pZrnhknkkn) {
        zrnhknkkn = pZrnhknkkn;
    }

    private String zrnphrkkikn;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNPHRKKIKN)
    public String getZrnphrkkikn() {
        return zrnphrkkikn;
    }

    public void setZrnphrkkikn(String pZrnphrkkikn) {
        zrnphrkkikn = pZrnphrkkikn;
    }

    private String zrnsaimnkkykhyj;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNSAIMNKKYKHYJ)
    public String getZrnsaimnkkykhyj() {
        return zrnsaimnkkykhyj;
    }

    public void setZrnsaimnkkykhyj(String pZrnsaimnkkykhyj) {
        zrnsaimnkkykhyj = pZrnsaimnkkykhyj;
    }

    private String zrnhrkkaisuukbn;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNHRKKAISUUKBN)
    public String getZrnhrkkaisuukbn() {
        return zrnhrkkaisuukbn;
    }

    public void setZrnhrkkaisuukbn(String pZrnhrkkaisuukbn) {
        zrnhrkkaisuukbn = pZrnhrkkaisuukbn;
    }

    private String zrnannaikigetu;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNANNAIKIGETU)
    public String getZrnannaikigetu() {
        return zrnannaikigetu;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnannaikigetu(String pZrnannaikigetu) {
        zrnannaikigetu = pZrnannaikigetu;
    }

    private String zrnao3tyou3sibousdatehyouji;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNAO3TYOU3SIBOUSDATEHYOUJI)
    public String getZrnao3tyou3sibousdatehyouji() {
        return zrnao3tyou3sibousdatehyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnao3tyou3sibousdatehyouji(String pZrnao3tyou3sibousdatehyouji) {
        zrnao3tyou3sibousdatehyouji = pZrnao3tyou3sibousdatehyouji;
    }

    private Long zrnkihons;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNKIHONS)
    public Long getZrnkihons() {
        return zrnkihons;
    }

    public void setZrnkihons(Long pZrnkihons) {
        zrnkihons = pZrnkihons;
    }

    private String zrnharaizumiymd;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNHARAIZUMIYMD)
    public String getZrnharaizumiymd() {
        return zrnharaizumiymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnharaizumiymd(String pZrnharaizumiymd) {
        zrnharaizumiymd = pZrnharaizumiymd;
    }

    private Long zrnharaizumis;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNHARAIZUMIS)
    public Long getZrnharaizumis() {
        return zrnharaizumis;
    }

    public void setZrnharaizumis(Long pZrnharaizumis) {
        zrnharaizumis = pZrnharaizumis;
    }

    private Long zrnentyous;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNENTYOUS)
    public Long getZrnentyous() {
        return zrnentyous;
    }

    public void setZrnentyous(Long pZrnentyous) {
        zrnentyous = pZrnentyous;
    }

    private Long zrnseizons;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNSEIZONS)
    public Long getZrnseizons() {
        return zrnseizons;
    }

    public void setZrnseizons(Long pZrnseizons) {
        zrnseizons = pZrnseizons;
    }

    private Long zrnpmens;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNPMENS)
    public Long getZrnpmens() {
        return zrnpmens;
    }

    public void setZrnpmens(Long pZrnpmens) {
        zrnpmens = pZrnpmens;
    }

    private Long zrnhendous;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNHENDOUS)
    public Long getZrnhendous() {
        return zrnhendous;
    }

    public void setZrnhendous(Long pZrnhendous) {
        zrnhendous = pZrnhendous;
    }

    private Long zrnitibuitijibarais;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNITIBUITIJIBARAIS)
    public Long getZrnitibuitijibarais() {
        return zrnitibuitijibarais;
    }

    public void setZrnitibuitijibarais(Long pZrnitibuitijibarais) {
        zrnitibuitijibarais = pZrnitibuitijibarais;
    }

    private String zrntenkanteikisyuruikigou;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTENKANTEIKISYURUIKIGOU)
    public String getZrntenkanteikisyuruikigou() {
        return zrntenkanteikisyuruikigou;
    }

    public void setZrntenkanteikisyuruikigou(String pZrntenkanteikisyuruikigou) {
        zrntenkanteikisyuruikigou = pZrntenkanteikisyuruikigou;
    }

    private String zrntenkanteikikikan;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTENKANTEIKIKIKAN)
    public String getZrntenkanteikikikan() {
        return zrntenkanteikikikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrntenkanteikikikan(String pZrntenkanteikikikan) {
        zrntenkanteikikikan = pZrntenkanteikikikan;
    }

    private String zrntnknteikinkshrkkn;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTNKNTEIKINKSHRKKN)
    public String getZrntnknteikinkshrkkn() {
        return zrntnknteikinkshrkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrntnknteikinkshrkkn(String pZrntnknteikinkshrkkn) {
        zrntnknteikinkshrkkn = pZrntnknteikinkshrkkn;
    }

    private Long zrngoukeitenkans;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNGOUKEITENKANS)
    public Long getZrngoukeitenkans() {
        return zrngoukeitenkans;
    }

    public void setZrngoukeitenkans(Long pZrngoukeitenkans) {
        zrngoukeitenkans = pZrngoukeitenkans;
    }

    private Long zrngoukeitenkanteikis;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNGOUKEITENKANTEIKIS)
    public Long getZrngoukeitenkanteikis() {
        return zrngoukeitenkanteikis;
    }

    public void setZrngoukeitenkanteikis(Long pZrngoukeitenkanteikis) {
        zrngoukeitenkanteikis = pZrngoukeitenkanteikis;
    }

    private Long zrngoukeipbubuntenkans;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNGOUKEIPBUBUNTENKANS)
    public Long getZrngoukeipbubuntenkans() {
        return zrngoukeipbubuntenkans;
    }

    public void setZrngoukeipbubuntenkans(Long pZrngoukeipbubuntenkans) {
        zrngoukeipbubuntenkans = pZrngoukeipbubuntenkans;
    }

    private String zrntenkankaisuu;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTENKANKAISUU)
    public String getZrntenkankaisuu() {
        return zrntenkankaisuu;
    }

    public void setZrntenkankaisuu(String pZrntenkankaisuu) {
        zrntenkankaisuu = pZrntenkankaisuu;
    }

    private Long zrndgoukei;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNDGOUKEI)
    public Long getZrndgoukei() {
        return zrndgoukei;
    }

    public void setZrndgoukei(Long pZrndgoukei) {
        zrndgoukei = pZrndgoukei;
    }

    private Long zrnsrankbetuhisad;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNSRANKBETUHISAD)
    public Long getZrnsrankbetuhisad() {
        return zrnsrankbetuhisad;
    }

    public void setZrnsrankbetuhisad(Long pZrnsrankbetuhisad) {
        zrnsrankbetuhisad = pZrnsrankbetuhisad;
    }

    private Long zrnsyumtjsrankbetuhisad;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNSYUMTJSRANKBETUHISAD)
    public Long getZrnsyumtjsrankbetuhisad() {
        return zrnsyumtjsrankbetuhisad;
    }

    public void setZrnsyumtjsrankbetuhisad(Long pZrnsyumtjsrankbetuhisad) {
        zrnsyumtjsrankbetuhisad = pZrnsyumtjsrankbetuhisad;
    }

    private Long zrnbairitubetuhisad;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNBAIRITUBETUHISAD)
    public Long getZrnbairitubetuhisad() {
        return zrnbairitubetuhisad;
    }

    public void setZrnbairitubetuhisad(Long pZrnbairitubetuhisad) {
        zrnbairitubetuhisad = pZrnbairitubetuhisad;
    }

    private Long zrnsyumtjtikbairtbetuhisad;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNSYUMTJTIKBAIRTBETUHISAD)
    public Long getZrnsyumtjtikbairtbetuhisad() {
        return zrnsyumtjtikbairtbetuhisad;
    }

    public void setZrnsyumtjtikbairtbetuhisad(Long pZrnsyumtjtikbairtbetuhisad) {
        zrnsyumtjtikbairtbetuhisad = pZrnsyumtjtikbairtbetuhisad;
    }

    private Long zrnsyukeiyakukihongoukeid;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNSYUKEIYAKUKIHONGOUKEID)
    public Long getZrnsyukeiyakukihongoukeid() {
        return zrnsyukeiyakukihongoukeid;
    }

    public void setZrnsyukeiyakukihongoukeid(Long pZrnsyukeiyakukihongoukeid) {
        zrnsyukeiyakukihongoukeid = pZrnsyukeiyakukihongoukeid;
    }

    private Long zrnsyukeiyakukihonsisad;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNSYUKEIYAKUKIHONSISAD)
    public Long getZrnsyukeiyakukihonsisad() {
        return zrnsyukeiyakukihonsisad;
    }

    public void setZrnsyukeiyakukihonsisad(Long pZrnsyukeiyakukihonsisad) {
        zrnsyukeiyakukihonsisad = pZrnsyukeiyakukihonsisad;
    }

    private Long zrnsyukeiyakukihonrisad;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNSYUKEIYAKUKIHONRISAD)
    public Long getZrnsyukeiyakukihonrisad() {
        return zrnsyukeiyakukihonrisad;
    }

    public void setZrnsyukeiyakukihonrisad(Long pZrnsyukeiyakukihonrisad) {
        zrnsyukeiyakukihonrisad = pZrnsyukeiyakukihonrisad;
    }

    private Long zrnsyukeiyakukihonramudad;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNSYUKEIYAKUKIHONRAMUDAD)
    public Long getZrnsyukeiyakukihonramudad() {
        return zrnsyukeiyakukihonramudad;
    }

    public void setZrnsyukeiyakukihonramudad(Long pZrnsyukeiyakukihonramudad) {
        zrnsyukeiyakukihonramudad = pZrnsyukeiyakukihonramudad;
    }

    private Long zrnsyukeiyakukihonhisad;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNSYUKEIYAKUKIHONHISAD)
    public Long getZrnsyukeiyakukihonhisad() {
        return zrnsyukeiyakukihonhisad;
    }

    public void setZrnsyukeiyakukihonhisad(Long pZrnsyukeiyakukihonhisad) {
        zrnsyukeiyakukihonhisad = pZrnsyukeiyakukihonhisad;
    }

    private Long zrnsyukeiyakukihondtaisyous;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNSYUKEIYAKUKIHONDTAISYOUS)
    public Long getZrnsyukeiyakukihondtaisyous() {
        return zrnsyukeiyakukihondtaisyous;
    }

    public void setZrnsyukeiyakukihondtaisyous(Long pZrnsyukeiyakukihondtaisyous) {
        zrnsyukeiyakukihondtaisyous = pZrnsyukeiyakukihondtaisyous;
    }

    private Long zrnsyukeiyakukihondyouv;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNSYUKEIYAKUKIHONDYOUV)
    public Long getZrnsyukeiyakukihondyouv() {
        return zrnsyukeiyakukihondyouv;
    }

    public void setZrnsyukeiyakukihondyouv(Long pZrnsyukeiyakukihondyouv) {
        zrnsyukeiyakukihondyouv = pZrnsyukeiyakukihondyouv;
    }

    private Long zrnsyukeiyakukihondkikens;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNSYUKEIYAKUKIHONDKIKENS)
    public Long getZrnsyukeiyakukihondkikens() {
        return zrnsyukeiyakukihondkikens;
    }

    public void setZrnsyukeiyakukihondkikens(Long pZrnsyukeiyakukihondkikens) {
        zrnsyukeiyakukihondkikens = pZrnsyukeiyakukihondkikens;
    }

    private Long zrnsykykkhnhisadtisyus;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNSYKYKKHNHISADTISYUS)
    public Long getZrnsykykkhnhisadtisyus() {
        return zrnsykykkhnhisadtisyus;
    }

    public void setZrnsykykkhnhisadtisyus(Long pZrnsykykkhnhisadtisyus) {
        zrnsykykkhnhisadtisyus = pZrnsykykkhnhisadtisyus;
    }

    private Long zrnsyukeiyakuteikigoukeid;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNSYUKEIYAKUTEIKIGOUKEID)
    public Long getZrnsyukeiyakuteikigoukeid() {
        return zrnsyukeiyakuteikigoukeid;
    }

    public void setZrnsyukeiyakuteikigoukeid(Long pZrnsyukeiyakuteikigoukeid) {
        zrnsyukeiyakuteikigoukeid = pZrnsyukeiyakuteikigoukeid;
    }

    private Long zrnsyukeiyakuteikisisad;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNSYUKEIYAKUTEIKISISAD)
    public Long getZrnsyukeiyakuteikisisad() {
        return zrnsyukeiyakuteikisisad;
    }

    public void setZrnsyukeiyakuteikisisad(Long pZrnsyukeiyakuteikisisad) {
        zrnsyukeiyakuteikisisad = pZrnsyukeiyakuteikisisad;
    }

    private Long zrnsyukeiyakuteikirisad;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNSYUKEIYAKUTEIKIRISAD)
    public Long getZrnsyukeiyakuteikirisad() {
        return zrnsyukeiyakuteikirisad;
    }

    public void setZrnsyukeiyakuteikirisad(Long pZrnsyukeiyakuteikirisad) {
        zrnsyukeiyakuteikirisad = pZrnsyukeiyakuteikirisad;
    }

    private Long zrnsyukeiyakuteikiramudad;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNSYUKEIYAKUTEIKIRAMUDAD)
    public Long getZrnsyukeiyakuteikiramudad() {
        return zrnsyukeiyakuteikiramudad;
    }

    public void setZrnsyukeiyakuteikiramudad(Long pZrnsyukeiyakuteikiramudad) {
        zrnsyukeiyakuteikiramudad = pZrnsyukeiyakuteikiramudad;
    }

    private Long zrnsyukeiyakuteikihisad;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNSYUKEIYAKUTEIKIHISAD)
    public Long getZrnsyukeiyakuteikihisad() {
        return zrnsyukeiyakuteikihisad;
    }

    public void setZrnsyukeiyakuteikihisad(Long pZrnsyukeiyakuteikihisad) {
        zrnsyukeiyakuteikihisad = pZrnsyukeiyakuteikihisad;
    }

    private Long zrnsyukeiyakuteikidtaisyous;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNSYUKEIYAKUTEIKIDTAISYOUS)
    public Long getZrnsyukeiyakuteikidtaisyous() {
        return zrnsyukeiyakuteikidtaisyous;
    }

    public void setZrnsyukeiyakuteikidtaisyous(Long pZrnsyukeiyakuteikidtaisyous) {
        zrnsyukeiyakuteikidtaisyous = pZrnsyukeiyakuteikidtaisyous;
    }

    private Long zrnsyukeiyakuteikidyouv;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNSYUKEIYAKUTEIKIDYOUV)
    public Long getZrnsyukeiyakuteikidyouv() {
        return zrnsyukeiyakuteikidyouv;
    }

    public void setZrnsyukeiyakuteikidyouv(Long pZrnsyukeiyakuteikidyouv) {
        zrnsyukeiyakuteikidyouv = pZrnsyukeiyakuteikidyouv;
    }

    private Long zrnsyukeiyakuteikidkikens;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNSYUKEIYAKUTEIKIDKIKENS)
    public Long getZrnsyukeiyakuteikidkikens() {
        return zrnsyukeiyakuteikidkikens;
    }

    public void setZrnsyukeiyakuteikidkikens(Long pZrnsyukeiyakuteikidkikens) {
        zrnsyukeiyakuteikidkikens = pZrnsyukeiyakuteikidkikens;
    }

    private Long zrnsykyktikhisadtisyus;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNSYKYKTIKHISADTISYUS)
    public Long getZrnsykyktikhisadtisyus() {
        return zrnsykyktikhisadtisyus;
    }

    public void setZrnsykyktikhisadtisyus(Long pZrnsykyktikhisadtisyus) {
        zrnsykyktikhisadtisyus = pZrnsykyktikhisadtisyus;
    }

    private Long zrntenkankihongoukeid;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTENKANKIHONGOUKEID)
    public Long getZrntenkankihongoukeid() {
        return zrntenkankihongoukeid;
    }

    public void setZrntenkankihongoukeid(Long pZrntenkankihongoukeid) {
        zrntenkankihongoukeid = pZrntenkankihongoukeid;
    }

    private Long zrntenkankihonsisad;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTENKANKIHONSISAD)
    public Long getZrntenkankihonsisad() {
        return zrntenkankihonsisad;
    }

    public void setZrntenkankihonsisad(Long pZrntenkankihonsisad) {
        zrntenkankihonsisad = pZrntenkankihonsisad;
    }

    private Long zrntenkankihonrisad;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTENKANKIHONRISAD)
    public Long getZrntenkankihonrisad() {
        return zrntenkankihonrisad;
    }

    public void setZrntenkankihonrisad(Long pZrntenkankihonrisad) {
        zrntenkankihonrisad = pZrntenkankihonrisad;
    }

    private Long zrntenkankihonramudad;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTENKANKIHONRAMUDAD)
    public Long getZrntenkankihonramudad() {
        return zrntenkankihonramudad;
    }

    public void setZrntenkankihonramudad(Long pZrntenkankihonramudad) {
        zrntenkankihonramudad = pZrntenkankihonramudad;
    }

    private Long zrntenkankihonhisad;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTENKANKIHONHISAD)
    public Long getZrntenkankihonhisad() {
        return zrntenkankihonhisad;
    }

    public void setZrntenkankihonhisad(Long pZrntenkankihonhisad) {
        zrntenkankihonhisad = pZrntenkankihonhisad;
    }

    private Long zrntenkankihondtaisyous;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTENKANKIHONDTAISYOUS)
    public Long getZrntenkankihondtaisyous() {
        return zrntenkankihondtaisyous;
    }

    public void setZrntenkankihondtaisyous(Long pZrntenkankihondtaisyous) {
        zrntenkankihondtaisyous = pZrntenkankihondtaisyous;
    }

    private Long zrntenkankihondyouv;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTENKANKIHONDYOUV)
    public Long getZrntenkankihondyouv() {
        return zrntenkankihondyouv;
    }

    public void setZrntenkankihondyouv(Long pZrntenkankihondyouv) {
        zrntenkankihondyouv = pZrntenkankihondyouv;
    }

    private Long zrntenkankihondkikens;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTENKANKIHONDKIKENS)
    public Long getZrntenkankihondkikens() {
        return zrntenkankihondkikens;
    }

    public void setZrntenkankihondkikens(Long pZrntenkankihondkikens) {
        zrntenkankihondkikens = pZrntenkankihondkikens;
    }

    private Long zrntenkankihonhisadtaisyous;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTENKANKIHONHISADTAISYOUS)
    public Long getZrntenkankihonhisadtaisyous() {
        return zrntenkankihonhisadtaisyous;
    }

    public void setZrntenkankihonhisadtaisyous(Long pZrntenkankihonhisadtaisyous) {
        zrntenkankihonhisadtaisyous = pZrntenkankihonhisadtaisyous;
    }

    private Long zrntenkanteikigoukeid;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTENKANTEIKIGOUKEID)
    public Long getZrntenkanteikigoukeid() {
        return zrntenkanteikigoukeid;
    }

    public void setZrntenkanteikigoukeid(Long pZrntenkanteikigoukeid) {
        zrntenkanteikigoukeid = pZrntenkanteikigoukeid;
    }

    private Long zrntenkanteikisisad;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTENKANTEIKISISAD)
    public Long getZrntenkanteikisisad() {
        return zrntenkanteikisisad;
    }

    public void setZrntenkanteikisisad(Long pZrntenkanteikisisad) {
        zrntenkanteikisisad = pZrntenkanteikisisad;
    }

    private Long zrntenkanteikirisad;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTENKANTEIKIRISAD)
    public Long getZrntenkanteikirisad() {
        return zrntenkanteikirisad;
    }

    public void setZrntenkanteikirisad(Long pZrntenkanteikirisad) {
        zrntenkanteikirisad = pZrntenkanteikirisad;
    }

    private Long zrntenkanteikiramudad;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTENKANTEIKIRAMUDAD)
    public Long getZrntenkanteikiramudad() {
        return zrntenkanteikiramudad;
    }

    public void setZrntenkanteikiramudad(Long pZrntenkanteikiramudad) {
        zrntenkanteikiramudad = pZrntenkanteikiramudad;
    }

    private Long zrntenkanteikihisad;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTENKANTEIKIHISAD)
    public Long getZrntenkanteikihisad() {
        return zrntenkanteikihisad;
    }

    public void setZrntenkanteikihisad(Long pZrntenkanteikihisad) {
        zrntenkanteikihisad = pZrntenkanteikihisad;
    }

    private Long zrntenkanteikidtaisyous;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTENKANTEIKIDTAISYOUS)
    public Long getZrntenkanteikidtaisyous() {
        return zrntenkanteikidtaisyous;
    }

    public void setZrntenkanteikidtaisyous(Long pZrntenkanteikidtaisyous) {
        zrntenkanteikidtaisyous = pZrntenkanteikidtaisyous;
    }

    private Long zrntenkanteikidyouv;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTENKANTEIKIDYOUV)
    public Long getZrntenkanteikidyouv() {
        return zrntenkanteikidyouv;
    }

    public void setZrntenkanteikidyouv(Long pZrntenkanteikidyouv) {
        zrntenkanteikidyouv = pZrntenkanteikidyouv;
    }

    private Long zrntenkanteikidkikens;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTENKANTEIKIDKIKENS)
    public Long getZrntenkanteikidkikens() {
        return zrntenkanteikidkikens;
    }

    public void setZrntenkanteikidkikens(Long pZrntenkanteikidkikens) {
        zrntenkanteikidkikens = pZrntenkanteikidkikens;
    }

    private Long zrntenkanteikihisadtaisyous;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTENKANTEIKIHISADTAISYOUS)
    public Long getZrntenkanteikihisadtaisyous() {
        return zrntenkanteikihisadtaisyous;
    }

    public void setZrntenkanteikihisadtaisyous(Long pZrntenkanteikihisadtaisyous) {
        zrntenkanteikihisadtaisyous = pZrntenkanteikihisadtaisyous;
    }

    private Long zrnsyumtjtyusiyutnkntikgukd;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNSYUMTJTYUSIYUTNKNTIKGUKD)
    public Long getZrnsyumtjtyusiyutnkntikgukd() {
        return zrnsyumtjtyusiyutnkntikgukd;
    }

    public void setZrnsyumtjtyusiyutnkntikgukd(Long pZrnsyumtjtyusiyutnkntikgukd) {
        zrnsyumtjtyusiyutnkntikgukd = pZrnsyumtjtyusiyutnkntikgukd;
    }

    private Long zrnsyumtjtyusiyutnkntiksisd;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNSYUMTJTYUSIYUTNKNTIKSISD)
    public Long getZrnsyumtjtyusiyutnkntiksisd() {
        return zrnsyumtjtyusiyutnkntiksisd;
    }

    public void setZrnsyumtjtyusiyutnkntiksisd(Long pZrnsyumtjtyusiyutnkntiksisd) {
        zrnsyumtjtyusiyutnkntiksisd = pZrnsyumtjtyusiyutnkntiksisd;
    }

    private Long zrnsyumtjtyusiyutnkntikrisd;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNSYUMTJTYUSIYUTNKNTIKRISD)
    public Long getZrnsyumtjtyusiyutnkntikrisd() {
        return zrnsyumtjtyusiyutnkntikrisd;
    }

    public void setZrnsyumtjtyusiyutnkntikrisd(Long pZrnsyumtjtyusiyutnkntikrisd) {
        zrnsyumtjtyusiyutnkntikrisd = pZrnsyumtjtyusiyutnkntikrisd;
    }

    private Long zrnsyumtjtyusiyutnkntikhisd;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNSYUMTJTYUSIYUTNKNTIKHISD)
    public Long getZrnsyumtjtyusiyutnkntikhisd() {
        return zrnsyumtjtyusiyutnkntikhisd;
    }

    public void setZrnsyumtjtyusiyutnkntikhisd(Long pZrnsyumtjtyusiyutnkntikhisd) {
        zrnsyumtjtyusiyutnkntikhisd = pZrnsyumtjtyusiyutnkntikhisd;
    }

    private Long zrnsyumtjtnkntikdtaisyous;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNSYUMTJTNKNTIKDTAISYOUS)
    public Long getZrnsyumtjtnkntikdtaisyous() {
        return zrnsyumtjtnkntikdtaisyous;
    }

    public void setZrnsyumtjtnkntikdtaisyous(Long pZrnsyumtjtnkntikdtaisyous) {
        zrnsyumtjtnkntikdtaisyous = pZrnsyumtjtnkntikdtaisyous;
    }

    private Long zrnsyumtjtnkntikdyouv;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNSYUMTJTNKNTIKDYOUV)
    public Long getZrnsyumtjtnkntikdyouv() {
        return zrnsyumtjtnkntikdyouv;
    }

    public void setZrnsyumtjtnkntikdyouv(Long pZrnsyumtjtnkntikdyouv) {
        zrnsyumtjtnkntikdyouv = pZrnsyumtjtnkntikdyouv;
    }

    private Long zrnsyumtjtnkntikdkikens;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNSYUMTJTNKNTIKDKIKENS)
    public Long getZrnsyumtjtnkntikdkikens() {
        return zrnsyumtjtnkntikdkikens;
    }

    public void setZrnsyumtjtnkntikdkikens(Long pZrnsyumtjtnkntikdkikens) {
        zrnsyumtjtnkntikdkikens = pZrnsyumtjtnkntikdkikens;
    }

    private Long zrnhendougoukeid;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNHENDOUGOUKEID)
    public Long getZrnhendougoukeid() {
        return zrnhendougoukeid;
    }

    public void setZrnhendougoukeid(Long pZrnhendougoukeid) {
        zrnhendougoukeid = pZrnhendougoukeid;
    }

    private Long zrnhendousisad;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNHENDOUSISAD)
    public Long getZrnhendousisad() {
        return zrnhendousisad;
    }

    public void setZrnhendousisad(Long pZrnhendousisad) {
        zrnhendousisad = pZrnhendousisad;
    }

    private Long zrnhendouhisad;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNHENDOUHISAD)
    public Long getZrnhendouhisad() {
        return zrnhendouhisad;
    }

    public void setZrnhendouhisad(Long pZrnhendouhisad) {
        zrnhendouhisad = pZrnhendouhisad;
    }

    private Long zrnhendoudtaisyous;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNHENDOUDTAISYOUS)
    public Long getZrnhendoudtaisyous() {
        return zrnhendoudtaisyous;
    }

    public void setZrnhendoudtaisyous(Long pZrnhendoudtaisyous) {
        zrnhendoudtaisyous = pZrnhendoudtaisyous;
    }

    private Long zrnhendoudyouv;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNHENDOUDYOUV)
    public Long getZrnhendoudyouv() {
        return zrnhendoudyouv;
    }

    public void setZrnhendoudyouv(Long pZrnhendoudyouv) {
        zrnhendoudyouv = pZrnhendoudyouv;
    }

    private Long zrnhendoudkikens;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNHENDOUDKIKENS)
    public Long getZrnhendoudkikens() {
        return zrnhendoudkikens;
    }

    public void setZrnhendoudkikens(Long pZrnhendoudkikens) {
        zrnhendoudkikens = pZrnhendoudkikens;
    }

    private Long zrnitibuitijibaraigoukeid;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNITIBUITIJIBARAIGOUKEID)
    public Long getZrnitibuitijibaraigoukeid() {
        return zrnitibuitijibaraigoukeid;
    }

    public void setZrnitibuitijibaraigoukeid(Long pZrnitibuitijibaraigoukeid) {
        zrnitibuitijibaraigoukeid = pZrnitibuitijibaraigoukeid;
    }

    private Long zrnitibuitijibaraisisad;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNITIBUITIJIBARAISISAD)
    public Long getZrnitibuitijibaraisisad() {
        return zrnitibuitijibaraisisad;
    }

    public void setZrnitibuitijibaraisisad(Long pZrnitibuitijibaraisisad) {
        zrnitibuitijibaraisisad = pZrnitibuitijibaraisisad;
    }

    private Long zrnitibuitijibaraihisad;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNITIBUITIJIBARAIHISAD)
    public Long getZrnitibuitijibaraihisad() {
        return zrnitibuitijibaraihisad;
    }

    public void setZrnitibuitijibaraihisad(Long pZrnitibuitijibaraihisad) {
        zrnitibuitijibaraihisad = pZrnitibuitijibaraihisad;
    }

    private Long zrnitibuitijibaraidtaisyous;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNITIBUITIJIBARAIDTAISYOUS)
    public Long getZrnitibuitijibaraidtaisyous() {
        return zrnitibuitijibaraidtaisyous;
    }

    public void setZrnitibuitijibaraidtaisyous(Long pZrnitibuitijibaraidtaisyous) {
        zrnitibuitijibaraidtaisyous = pZrnitibuitijibaraidtaisyous;
    }

    private Long zrnitibuitijibaraidyouv;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNITIBUITIJIBARAIDYOUV)
    public Long getZrnitibuitijibaraidyouv() {
        return zrnitibuitijibaraidyouv;
    }

    public void setZrnitibuitijibaraidyouv(Long pZrnitibuitijibaraidyouv) {
        zrnitibuitijibaraidyouv = pZrnitibuitijibaraidyouv;
    }

    private Long zrnitibuitijibaraidkikens;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNITIBUITIJIBARAIDKIKENS)
    public Long getZrnitibuitijibaraidkikens() {
        return zrnitibuitijibaraidkikens;
    }

    public void setZrnitibuitijibaraidkikens(Long pZrnitibuitijibaraidkikens) {
        zrnitibuitijibaraidkikens = pZrnitibuitijibaraidkikens;
    }

    private Long zrnitibitjbrhisadtisyus;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNITIBITJBRHISADTISYUS)
    public Long getZrnitibitjbrhisadtisyus() {
        return zrnitibitjbrhisadtisyus;
    }

    public void setZrnitibitjbrhisadtisyus(Long pZrnitibitjbrhisadtisyus) {
        zrnitibitjbrhisadtisyus = pZrnitibitjbrhisadtisyus;
    }

    private String zrnszoukouryokukaisiymd;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNSZOUKOURYOKUKAISIYMD)
    public String getZrnszoukouryokukaisiymd() {
        return zrnszoukouryokukaisiymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnszoukouryokukaisiymd(String pZrnszoukouryokukaisiymd) {
        zrnszoukouryokukaisiymd = pZrnszoukouryokukaisiymd;
    }

    private String zrnszouhokensyuruikigou;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNSZOUHOKENSYURUIKIGOU)
    public String getZrnszouhokensyuruikigou() {
        return zrnszouhokensyuruikigou;
    }

    public void setZrnszouhokensyuruikigou(String pZrnszouhokensyuruikigou) {
        zrnszouhokensyuruikigou = pZrnszouhokensyuruikigou;
    }

    private String zrnszoukikan;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNSZOUKIKAN)
    public String getZrnszoukikan() {
        return zrnszoukikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnszoukikan(String pZrnszoukikan) {
        zrnszoukikan = pZrnszoukikan;
    }

    private String zrnszouhihokensyaage;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNSZOUHIHOKENSYAAGE)
    public String getZrnszouhihokensyaage() {
        return zrnszouhihokensyaage;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnszouhihokensyaage(String pZrnszouhihokensyaage) {
        zrnszouhihokensyaage = pZrnszouhihokensyaage;
    }

    private Long zrnzoukagoukeid;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNZOUKAGOUKEID)
    public Long getZrnzoukagoukeid() {
        return zrnzoukagoukeid;
    }

    public void setZrnzoukagoukeid(Long pZrnzoukagoukeid) {
        zrnzoukagoukeid = pZrnzoukagoukeid;
    }

    private Long zrnzoukasisad;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNZOUKASISAD)
    public Long getZrnzoukasisad() {
        return zrnzoukasisad;
    }

    public void setZrnzoukasisad(Long pZrnzoukasisad) {
        zrnzoukasisad = pZrnzoukasisad;
    }

    private Long zrnzoukarisad;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNZOUKARISAD)
    public Long getZrnzoukarisad() {
        return zrnzoukarisad;
    }

    public void setZrnzoukarisad(Long pZrnzoukarisad) {
        zrnzoukarisad = pZrnzoukarisad;
    }

    private Long zrnzoukaramudad;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNZOUKARAMUDAD)
    public Long getZrnzoukaramudad() {
        return zrnzoukaramudad;
    }

    public void setZrnzoukaramudad(Long pZrnzoukaramudad) {
        zrnzoukaramudad = pZrnzoukaramudad;
    }

    private Long zrnzoukahisad;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNZOUKAHISAD)
    public Long getZrnzoukahisad() {
        return zrnzoukahisad;
    }

    public void setZrnzoukahisad(Long pZrnzoukahisad) {
        zrnzoukahisad = pZrnzoukahisad;
    }

    private Long zrnzoukadtaisyous;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNZOUKADTAISYOUS)
    public Long getZrnzoukadtaisyous() {
        return zrnzoukadtaisyous;
    }

    public void setZrnzoukadtaisyous(Long pZrnzoukadtaisyous) {
        zrnzoukadtaisyous = pZrnzoukadtaisyous;
    }

    private Long zrnzoukadyouv;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNZOUKADYOUV)
    public Long getZrnzoukadyouv() {
        return zrnzoukadyouv;
    }

    public void setZrnzoukadyouv(Long pZrnzoukadyouv) {
        zrnzoukadyouv = pZrnzoukadyouv;
    }

    private Long zrnzoukadkikens;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNZOUKADKIKENS)
    public Long getZrnzoukadkikens() {
        return zrnzoukadkikens;
    }

    public void setZrnzoukadkikens(Long pZrnzoukadkikens) {
        zrnzoukadkikens = pZrnzoukadkikens;
    }

    private String zrnkakuteikakusasyuruikgu;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNKAKUTEIKAKUSASYURUIKGU)
    public String getZrnkakuteikakusasyuruikgu() {
        return zrnkakuteikakusasyuruikgu;
    }

    public void setZrnkakuteikakusasyuruikgu(String pZrnkakuteikakusasyuruikgu) {
        zrnkakuteikakusasyuruikgu = pZrnkakuteikakusasyuruikgu;
    }

    private Long zrnkakuteikakusad;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNKAKUTEIKAKUSAD)
    public Long getZrnkakuteikakusad() {
        return zrnkakuteikakusad;
    }

    public void setZrnkakuteikakusad(Long pZrnkakuteikakusad) {
        zrnkakuteikakusad = pZrnkakuteikakusad;
    }

    private Long zrnkakuteikakusas;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNKAKUTEIKAKUSAS)
    public Long getZrnkakuteikakusas() {
        return zrnkakuteikakusas;
    }

    public void setZrnkakuteikakusas(Long pZrnkakuteikakusas) {
        zrnkakuteikakusas = pZrnkakuteikakusas;
    }

    private Long zrnkakuteikakusamanryoujid;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNKAKUTEIKAKUSAMANRYOUJID)
    public Long getZrnkakuteikakusamanryoujid() {
        return zrnkakuteikakusamanryoujid;
    }

    public void setZrnkakuteikakusamanryoujid(Long pZrnkakuteikakusamanryoujid) {
        zrnkakuteikakusamanryoujid = pZrnkakuteikakusamanryoujid;
    }

    private String zrnnaizoumarusasyuruikigou;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNNAIZOUMARUSASYURUIKIGOU)
    public String getZrnnaizoumarusasyuruikigou() {
        return zrnnaizoumarusasyuruikigou;
    }

    public void setZrnnaizoumarusasyuruikigou(String pZrnnaizoumarusasyuruikigou) {
        zrnnaizoumarusasyuruikigou = pZrnnaizoumarusasyuruikigou;
    }

    private Long zrnnaizoumarusad;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNNAIZOUMARUSAD)
    public Long getZrnnaizoumarusad() {
        return zrnnaizoumarusad;
    }

    public void setZrnnaizoumarusad(Long pZrnnaizoumarusad) {
        zrnnaizoumarusad = pZrnnaizoumarusad;
    }

    private Long zrnnaizoumarusas;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNNAIZOUMARUSAS)
    public Long getZrnnaizoumarusas() {
        return zrnnaizoumarusas;
    }

    public void setZrnnaizoumarusas(Long pZrnnaizoumarusas) {
        zrnnaizoumarusas = pZrnnaizoumarusas;
    }

    private String zrnnaizoukakusasyuruikigou;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNNAIZOUKAKUSASYURUIKIGOU)
    public String getZrnnaizoukakusasyuruikigou() {
        return zrnnaizoukakusasyuruikigou;
    }

    public void setZrnnaizoukakusasyuruikigou(String pZrnnaizoukakusasyuruikigou) {
        zrnnaizoukakusasyuruikigou = pZrnnaizoukakusasyuruikigou;
    }

    private Long zrnnaizoukakusad;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNNAIZOUKAKUSAD)
    public Long getZrnnaizoukakusad() {
        return zrnnaizoukakusad;
    }

    public void setZrnnaizoukakusad(Long pZrnnaizoukakusad) {
        zrnnaizoukakusad = pZrnnaizoukakusad;
    }

    private Long zrnnaizoukakusas;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNNAIZOUKAKUSAS)
    public Long getZrnnaizoukakusas() {
        return zrnnaizoukakusas;
    }

    public void setZrnnaizoukakusas(Long pZrnnaizoukakusas) {
        zrnnaizoukakusas = pZrnnaizoukakusas;
    }

    private Long zrntenkanpbubund;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTENKANPBUBUND)
    public Long getZrntenkanpbubund() {
        return zrntenkanpbubund;
    }

    public void setZrntenkanpbubund(Long pZrntenkanpbubund) {
        zrntenkanpbubund = pZrntenkanpbubund;
    }

    private Long zrntenkanpbubunsisad;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTENKANPBUBUNSISAD)
    public Long getZrntenkanpbubunsisad() {
        return zrntenkanpbubunsisad;
    }

    public void setZrntenkanpbubunsisad(Long pZrntenkanpbubunsisad) {
        zrntenkanpbubunsisad = pZrntenkanpbubunsisad;
    }

    private Long zrntenkanpbubunrisad;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTENKANPBUBUNRISAD)
    public Long getZrntenkanpbubunrisad() {
        return zrntenkanpbubunrisad;
    }

    public void setZrntenkanpbubunrisad(Long pZrntenkanpbubunrisad) {
        zrntenkanpbubunrisad = pZrntenkanpbubunrisad;
    }

    private Long zrntenkanpbubunhisad;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTENKANPBUBUNHISAD)
    public Long getZrntenkanpbubunhisad() {
        return zrntenkanpbubunhisad;
    }

    public void setZrntenkanpbubunhisad(Long pZrntenkanpbubunhisad) {
        zrntenkanpbubunhisad = pZrntenkanpbubunhisad;
    }

    private Long zrntenkanpbubundtaisyous;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTENKANPBUBUNDTAISYOUS)
    public Long getZrntenkanpbubundtaisyous() {
        return zrntenkanpbubundtaisyous;
    }

    public void setZrntenkanpbubundtaisyous(Long pZrntenkanpbubundtaisyous) {
        zrntenkanpbubundtaisyous = pZrntenkanpbubundtaisyous;
    }

    private Long zrntenkanpbubundyouv;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTENKANPBUBUNDYOUV)
    public Long getZrntenkanpbubundyouv() {
        return zrntenkanpbubundyouv;
    }

    public void setZrntenkanpbubundyouv(Long pZrntenkanpbubundyouv) {
        zrntenkanpbubundyouv = pZrntenkanpbubundyouv;
    }

    private Long zrntenkanpbubundkikens;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTENKANPBUBUNDKIKENS)
    public Long getZrntenkanpbubundkikens() {
        return zrntenkanpbubundkikens;
    }

    public void setZrntenkanpbubundkikens(Long pZrntenkanpbubundkikens) {
        zrntenkanpbubundkikens = pZrntenkanpbubundkikens;
    }

    private Long zrnnaizougatateikimud;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNNAIZOUGATATEIKIMUD)
    public Long getZrnnaizougatateikimud() {
        return zrnnaizougatateikimud;
    }

    public void setZrnnaizougatateikimud(Long pZrnnaizougatateikimud) {
        zrnnaizougatateikimud = pZrnnaizougatateikimud;
    }

    private Long zrnnaizougatanenkansanp;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNNAIZOUGATANENKANSANP)
    public Long getZrnnaizougatanenkansanp() {
        return zrnnaizougatanenkansanp;
    }

    public void setZrnnaizougatanenkansanp(Long pZrnnaizougatanenkansanp) {
        zrnnaizougatanenkansanp = pZrnnaizougatanenkansanp;
    }

    private Long zrnvhktgbbntnkntikmud;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNVHKTGBBNTNKNTIKMUD)
    public Long getZrnvhktgbbntnkntikmud() {
        return zrnvhktgbbntnkntikmud;
    }

    public void setZrnvhktgbbntnkntikmud(Long pZrnvhktgbbntnkntikmud) {
        zrnvhktgbbntnkntikmud = pZrnvhktgbbntnkntikmud;
    }

    private Long zrnhikitugitenkanphireimud;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNHIKITUGITENKANPHIREIMUD)
    public Long getZrnhikitugitenkanphireimud() {
        return zrnhikitugitenkanphireimud;
    }

    public void setZrnhikitugitenkanphireimud(Long pZrnhikitugitenkanphireimud) {
        zrnhikitugitenkanphireimud = pZrnhikitugitenkanphireimud;
    }

    private Long zrnitibitjbrgyuskhyjs;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNITIBITJBRGYUSKHYJS)
    public Long getZrnitibitjbrgyuskhyjs() {
        return zrnitibitjbrgyuskhyjs;
    }

    public void setZrnitibitjbrgyuskhyjs(Long pZrnitibitjbrgyuskhyjs) {
        zrnitibitjbrgyuskhyjs = pZrnitibitjbrgyuskhyjs;
    }

    private Long zrnkariwariate4nenmae;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNKARIWARIATE4NENMAE)
    public Long getZrnkariwariate4nenmae() {
        return zrnkariwariate4nenmae;
    }

    public void setZrnkariwariate4nenmae(Long pZrnkariwariate4nenmae) {
        zrnkariwariate4nenmae = pZrnkariwariate4nenmae;
    }

    private Long zrnkariwariate3nenmae;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNKARIWARIATE3NENMAE)
    public Long getZrnkariwariate3nenmae() {
        return zrnkariwariate3nenmae;
    }

    public void setZrnkariwariate3nenmae(Long pZrnkariwariate3nenmae) {
        zrnkariwariate3nenmae = pZrnkariwariate3nenmae;
    }

    private Long zrnkariwariate2nenmae;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNKARIWARIATE2NENMAE)
    public Long getZrnkariwariate2nenmae() {
        return zrnkariwariate2nenmae;
    }

    public void setZrnkariwariate2nenmae(Long pZrnkariwariate2nenmae) {
        zrnkariwariate2nenmae = pZrnkariwariate2nenmae;
    }

    private Long zrnkariwariate1nenmae;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNKARIWARIATE1NENMAE)
    public Long getZrnkariwariate1nenmae() {
        return zrnkariwariate1nenmae;
    }

    public void setZrnkariwariate1nenmae(Long pZrnkariwariate1nenmae) {
        zrnkariwariate1nenmae = pZrnkariwariate1nenmae;
    }

    private Long zrngukisisntnkntikmud;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNGUKISISNTNKNTIKMUD)
    public Long getZrngukisisntnkntikmud() {
        return zrngukisisntnkntikmud;
    }

    public void setZrngukisisntnkntikmud(Long pZrngukisisntnkntikmud) {
        zrngukisisntnkntikmud = pZrngukisisntnkntikmud;
    }

    private Long zrngoukeiseisanteikis;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNGOUKEISEISANTEIKIS)
    public Long getZrngoukeiseisanteikis() {
        return zrngoukeiseisanteikis;
    }

    public void setZrngoukeiseisanteikis(Long pZrngoukeiseisanteikis) {
        zrngoukeiseisanteikis = pZrngoukeiseisanteikis;
    }

    private Long zrngukisisntnknnenknsnp;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNGUKISISNTNKNNENKNSNP)
    public Long getZrngukisisntnknnenknsnp() {
        return zrngukisisntnknnenknsnp;
    }

    public void setZrngukisisntnknnenknsnp(Long pZrngukisisntnknnenknsnp) {
        zrngukisisntnknnenknsnp = pZrngukisisntnknnenknsnp;
    }

    private String zrntnkntikhtnknkykymd;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTNKNTIKHTNKNKYKYMD)
    public String getZrntnkntikhtnknkykymd() {
        return zrntnkntikhtnknkykymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrntnkntikhtnknkykymd(String pZrntnkntikhtnknkykymd) {
        zrntnkntikhtnknkykymd = pZrntnkntikhtnknkykymd;
    }

    private BizNumber zrntenkangophireimuritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTENKANGOPHIREIMURITU)
    public BizNumber getZrntenkangophireimuritu() {
        return zrntenkangophireimuritu;
    }

    public void setZrntenkangophireimuritu(BizNumber pZrntenkangophireimuritu) {
        zrntenkangophireimuritu = pZrntenkangophireimuritu;
    }

    private Long zrngoukeitenkannenkansanp;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNGOUKEITENKANNENKANSANP)
    public Long getZrngoukeitenkannenkansanp() {
        return zrngoukeitenkannenkansanp;
    }

    public void setZrngoukeitenkannenkansanp(Long pZrngoukeitenkannenkansanp) {
        zrngoukeitenkannenkansanp = pZrngoukeitenkannenkansanp;
    }

    private Long zrngoukeitenkanteikimud;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNGOUKEITENKANTEIKIMUD)
    public Long getZrngoukeitenkanteikimud() {
        return zrngoukeitenkanteikimud;
    }

    public void setZrngoukeitenkanteikimud(Long pZrngoukeitenkanteikimud) {
        zrngoukeitenkanteikimud = pZrngoukeitenkanteikimud;
    }

    private Long zrntyoukikeizokutokubetud;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTYOUKIKEIZOKUTOKUBETUD)
    public Long getZrntyoukikeizokutokubetud() {
        return zrntyoukikeizokutokubetud;
    }

    public void setZrntyoukikeizokutokubetud(Long pZrntyoukikeizokutokubetud) {
        zrntyoukikeizokutokubetud = pZrntyoukikeizokutokubetud;
    }

    private Long zrntyouseimaed;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTYOUSEIMAED)
    public Long getZrntyouseimaed() {
        return zrntyouseimaed;
    }

    public void setZrntyouseimaed(Long pZrntyouseimaed) {
        zrntyouseimaed = pZrntyouseimaed;
    }

    private Long zrntuutokuhituusand;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTUUTOKUHITUUSAND)
    public Long getZrntuutokuhituusand() {
        return zrntuutokuhituusand;
    }

    public void setZrntuutokuhituusand(Long pZrntuutokuhituusand) {
        zrntuutokuhituusand = pZrntuutokuhituusand;
    }

    private String zrnhknsyuruikigousedaikbn;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNHKNSYURUIKIGOUSEDAIKBN)
    public String getZrnhknsyuruikigousedaikbn() {
        return zrnhknsyuruikigousedaikbn;
    }

    public void setZrnhknsyuruikigousedaikbn(String pZrnhknsyuruikigousedaikbn) {
        zrnhknsyuruikigousedaikbn = pZrnhknsyuruikigousedaikbn;
    }

    private String zrntenkanteikikigousedaikbn;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTENKANTEIKIKIGOUSEDAIKBN)
    public String getZrntenkanteikikigousedaikbn() {
        return zrntenkanteikikigousedaikbn;
    }

    public void setZrntenkanteikikigousedaikbn(String pZrntenkanteikikigousedaikbn) {
        zrntenkanteikikigousedaikbn = pZrntenkanteikikigousedaikbn;
    }

    private String zrnszoukigousedaikbn;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNSZOUKIGOUSEDAIKBN)
    public String getZrnszoukigousedaikbn() {
        return zrnszoukigousedaikbn;
    }

    public void setZrnszoukigousedaikbn(String pZrnszoukigousedaikbn) {
        zrnszoukigousedaikbn = pZrnszoukigousedaikbn;
    }

    private String zrnmankihyouji;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNMANKIHYOUJI)
    public String getZrnmankihyouji() {
        return zrnmankihyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnmankihyouji(String pZrnmankihyouji) {
        zrnmankihyouji = pZrnmankihyouji;
    }

    private String zrnkeiyakuoutoubikbn;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNKEIYAKUOUTOUBIKBN)
    public String getZrnkeiyakuoutoubikbn() {
        return zrnkeiyakuoutoubikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkeiyakuoutoubikbn(String pZrnkeiyakuoutoubikbn) {
        zrnkeiyakuoutoubikbn = pZrnkeiyakuoutoubikbn;
    }

    private String zrnsuuriyouyobin2;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNSUURIYOUYOBIN2)
    public String getZrnsuuriyouyobin2() {
        return zrnsuuriyouyobin2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsuuriyouyobin2(String pZrnsuuriyouyobin2) {
        zrnsuuriyouyobin2 = pZrnsuuriyouyobin2;
    }

    private Integer zrntokuyakuhukasuu;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTOKUYAKUHUKASUU)
    public Integer getZrntokuyakuhukasuu() {
        return zrntokuyakuhukasuu;
    }

    public void setZrntokuyakuhukasuu(Integer pZrntokuyakuhukasuu) {
        zrntokuyakuhukasuu = pZrntokuyakuhukasuu;
    }

    private String zrnhokensyuruikigouyobi1x1;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNHOKENSYURUIKIGOUYOBI1X1)
    public String getZrnhokensyuruikigouyobi1x1() {
        return zrnhokensyuruikigouyobi1x1;
    }

    public void setZrnhokensyuruikigouyobi1x1(String pZrnhokensyuruikigouyobi1x1) {
        zrnhokensyuruikigouyobi1x1 = pZrnhokensyuruikigouyobi1x1;
    }

    private String zrnhokensyuruikigouyobi1x2;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNHOKENSYURUIKIGOUYOBI1X2)
    public String getZrnhokensyuruikigouyobi1x2() {
        return zrnhokensyuruikigouyobi1x2;
    }

    public void setZrnhokensyuruikigouyobi1x2(String pZrnhokensyuruikigouyobi1x2) {
        zrnhokensyuruikigouyobi1x2 = pZrnhokensyuruikigouyobi1x2;
    }

    private String zrnhokensyuruikigouyobi1x3;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNHOKENSYURUIKIGOUYOBI1X3)
    public String getZrnhokensyuruikigouyobi1x3() {
        return zrnhokensyuruikigouyobi1x3;
    }

    public void setZrnhokensyuruikigouyobi1x3(String pZrnhokensyuruikigouyobi1x3) {
        zrnhokensyuruikigouyobi1x3 = pZrnhokensyuruikigouyobi1x3;
    }

    private String zrnhokensyuruikigouyobi1x4;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNHOKENSYURUIKIGOUYOBI1X4)
    public String getZrnhokensyuruikigouyobi1x4() {
        return zrnhokensyuruikigouyobi1x4;
    }

    public void setZrnhokensyuruikigouyobi1x4(String pZrnhokensyuruikigouyobi1x4) {
        zrnhokensyuruikigouyobi1x4 = pZrnhokensyuruikigouyobi1x4;
    }

    private String zrnhokensyuruikigouyobi1x5;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNHOKENSYURUIKIGOUYOBI1X5)
    public String getZrnhokensyuruikigouyobi1x5() {
        return zrnhokensyuruikigouyobi1x5;
    }

    public void setZrnhokensyuruikigouyobi1x5(String pZrnhokensyuruikigouyobi1x5) {
        zrnhokensyuruikigouyobi1x5 = pZrnhokensyuruikigouyobi1x5;
    }

    private String zrnhokensyuruikigouyobi1x6;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNHOKENSYURUIKIGOUYOBI1X6)
    public String getZrnhokensyuruikigouyobi1x6() {
        return zrnhokensyuruikigouyobi1x6;
    }

    public void setZrnhokensyuruikigouyobi1x6(String pZrnhokensyuruikigouyobi1x6) {
        zrnhokensyuruikigouyobi1x6 = pZrnhokensyuruikigouyobi1x6;
    }

    private String zrnhokensyuruikigouyobi1x7;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNHOKENSYURUIKIGOUYOBI1X7)
    public String getZrnhokensyuruikigouyobi1x7() {
        return zrnhokensyuruikigouyobi1x7;
    }

    public void setZrnhokensyuruikigouyobi1x7(String pZrnhokensyuruikigouyobi1x7) {
        zrnhokensyuruikigouyobi1x7 = pZrnhokensyuruikigouyobi1x7;
    }

    private String zrnhokensyuruikigouyobi1x8;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNHOKENSYURUIKIGOUYOBI1X8)
    public String getZrnhokensyuruikigouyobi1x8() {
        return zrnhokensyuruikigouyobi1x8;
    }

    public void setZrnhokensyuruikigouyobi1x8(String pZrnhokensyuruikigouyobi1x8) {
        zrnhokensyuruikigouyobi1x8 = pZrnhokensyuruikigouyobi1x8;
    }

    private String zrnhokensyuruikigouyobi1x9;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNHOKENSYURUIKIGOUYOBI1X9)
    public String getZrnhokensyuruikigouyobi1x9() {
        return zrnhokensyuruikigouyobi1x9;
    }

    public void setZrnhokensyuruikigouyobi1x9(String pZrnhokensyuruikigouyobi1x9) {
        zrnhokensyuruikigouyobi1x9 = pZrnhokensyuruikigouyobi1x9;
    }

    private String zrnhokensyuruikigouyobi1x10;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNHOKENSYURUIKIGOUYOBI1X10)
    public String getZrnhokensyuruikigouyobi1x10() {
        return zrnhokensyuruikigouyobi1x10;
    }

    public void setZrnhokensyuruikigouyobi1x10(String pZrnhokensyuruikigouyobi1x10) {
        zrnhokensyuruikigouyobi1x10 = pZrnhokensyuruikigouyobi1x10;
    }

    private String zrnhokensyuruikigouyobi1x11;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNHOKENSYURUIKIGOUYOBI1X11)
    public String getZrnhokensyuruikigouyobi1x11() {
        return zrnhokensyuruikigouyobi1x11;
    }

    public void setZrnhokensyuruikigouyobi1x11(String pZrnhokensyuruikigouyobi1x11) {
        zrnhokensyuruikigouyobi1x11 = pZrnhokensyuruikigouyobi1x11;
    }

    private String zrnhokensyuruikigouyobi1x12;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNHOKENSYURUIKIGOUYOBI1X12)
    public String getZrnhokensyuruikigouyobi1x12() {
        return zrnhokensyuruikigouyobi1x12;
    }

    public void setZrnhokensyuruikigouyobi1x12(String pZrnhokensyuruikigouyobi1x12) {
        zrnhokensyuruikigouyobi1x12 = pZrnhokensyuruikigouyobi1x12;
    }

    private String zrnhokensyuruikigouyobi1x13;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNHOKENSYURUIKIGOUYOBI1X13)
    public String getZrnhokensyuruikigouyobi1x13() {
        return zrnhokensyuruikigouyobi1x13;
    }

    public void setZrnhokensyuruikigouyobi1x13(String pZrnhokensyuruikigouyobi1x13) {
        zrnhokensyuruikigouyobi1x13 = pZrnhokensyuruikigouyobi1x13;
    }

    private String zrnhokensyuruikigouyobi1x14;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNHOKENSYURUIKIGOUYOBI1X14)
    public String getZrnhokensyuruikigouyobi1x14() {
        return zrnhokensyuruikigouyobi1x14;
    }

    public void setZrnhokensyuruikigouyobi1x14(String pZrnhokensyuruikigouyobi1x14) {
        zrnhokensyuruikigouyobi1x14 = pZrnhokensyuruikigouyobi1x14;
    }

    private String zrnhokensyuruikigouyobi1x15;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNHOKENSYURUIKIGOUYOBI1X15)
    public String getZrnhokensyuruikigouyobi1x15() {
        return zrnhokensyuruikigouyobi1x15;
    }

    public void setZrnhokensyuruikigouyobi1x15(String pZrnhokensyuruikigouyobi1x15) {
        zrnhokensyuruikigouyobi1x15 = pZrnhokensyuruikigouyobi1x15;
    }

    private String zrnhokensyuruikigouyobi2x1;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNHOKENSYURUIKIGOUYOBI2X1)
    public String getZrnhokensyuruikigouyobi2x1() {
        return zrnhokensyuruikigouyobi2x1;
    }

    public void setZrnhokensyuruikigouyobi2x1(String pZrnhokensyuruikigouyobi2x1) {
        zrnhokensyuruikigouyobi2x1 = pZrnhokensyuruikigouyobi2x1;
    }

    private String zrnhokensyuruikigouyobi2x2;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNHOKENSYURUIKIGOUYOBI2X2)
    public String getZrnhokensyuruikigouyobi2x2() {
        return zrnhokensyuruikigouyobi2x2;
    }

    public void setZrnhokensyuruikigouyobi2x2(String pZrnhokensyuruikigouyobi2x2) {
        zrnhokensyuruikigouyobi2x2 = pZrnhokensyuruikigouyobi2x2;
    }

    private String zrnhokensyuruikigouyobi2x3;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNHOKENSYURUIKIGOUYOBI2X3)
    public String getZrnhokensyuruikigouyobi2x3() {
        return zrnhokensyuruikigouyobi2x3;
    }

    public void setZrnhokensyuruikigouyobi2x3(String pZrnhokensyuruikigouyobi2x3) {
        zrnhokensyuruikigouyobi2x3 = pZrnhokensyuruikigouyobi2x3;
    }

    private String zrnhokensyuruikigouyobi2x4;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNHOKENSYURUIKIGOUYOBI2X4)
    public String getZrnhokensyuruikigouyobi2x4() {
        return zrnhokensyuruikigouyobi2x4;
    }

    public void setZrnhokensyuruikigouyobi2x4(String pZrnhokensyuruikigouyobi2x4) {
        zrnhokensyuruikigouyobi2x4 = pZrnhokensyuruikigouyobi2x4;
    }

    private String zrnhokensyuruikigouyobi2x5;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNHOKENSYURUIKIGOUYOBI2X5)
    public String getZrnhokensyuruikigouyobi2x5() {
        return zrnhokensyuruikigouyobi2x5;
    }

    public void setZrnhokensyuruikigouyobi2x5(String pZrnhokensyuruikigouyobi2x5) {
        zrnhokensyuruikigouyobi2x5 = pZrnhokensyuruikigouyobi2x5;
    }

    private String zrnhokensyuruikigouyobi2x6;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNHOKENSYURUIKIGOUYOBI2X6)
    public String getZrnhokensyuruikigouyobi2x6() {
        return zrnhokensyuruikigouyobi2x6;
    }

    public void setZrnhokensyuruikigouyobi2x6(String pZrnhokensyuruikigouyobi2x6) {
        zrnhokensyuruikigouyobi2x6 = pZrnhokensyuruikigouyobi2x6;
    }

    private String zrnhokensyuruikigouyobi2x7;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNHOKENSYURUIKIGOUYOBI2X7)
    public String getZrnhokensyuruikigouyobi2x7() {
        return zrnhokensyuruikigouyobi2x7;
    }

    public void setZrnhokensyuruikigouyobi2x7(String pZrnhokensyuruikigouyobi2x7) {
        zrnhokensyuruikigouyobi2x7 = pZrnhokensyuruikigouyobi2x7;
    }

    private String zrnhokensyuruikigouyobi2x8;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNHOKENSYURUIKIGOUYOBI2X8)
    public String getZrnhokensyuruikigouyobi2x8() {
        return zrnhokensyuruikigouyobi2x8;
    }

    public void setZrnhokensyuruikigouyobi2x8(String pZrnhokensyuruikigouyobi2x8) {
        zrnhokensyuruikigouyobi2x8 = pZrnhokensyuruikigouyobi2x8;
    }

    private String zrnhokensyuruikigouyobi2x9;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNHOKENSYURUIKIGOUYOBI2X9)
    public String getZrnhokensyuruikigouyobi2x9() {
        return zrnhokensyuruikigouyobi2x9;
    }

    public void setZrnhokensyuruikigouyobi2x9(String pZrnhokensyuruikigouyobi2x9) {
        zrnhokensyuruikigouyobi2x9 = pZrnhokensyuruikigouyobi2x9;
    }

    private String zrnhokensyuruikigouyobi2x10;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNHOKENSYURUIKIGOUYOBI2X10)
    public String getZrnhokensyuruikigouyobi2x10() {
        return zrnhokensyuruikigouyobi2x10;
    }

    public void setZrnhokensyuruikigouyobi2x10(String pZrnhokensyuruikigouyobi2x10) {
        zrnhokensyuruikigouyobi2x10 = pZrnhokensyuruikigouyobi2x10;
    }

    private String zrnhokensyuruikigouyobi3x1;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNHOKENSYURUIKIGOUYOBI3X1)
    public String getZrnhokensyuruikigouyobi3x1() {
        return zrnhokensyuruikigouyobi3x1;
    }

    public void setZrnhokensyuruikigouyobi3x1(String pZrnhokensyuruikigouyobi3x1) {
        zrnhokensyuruikigouyobi3x1 = pZrnhokensyuruikigouyobi3x1;
    }

    private String zrnhokensyuruikigouyobi3x2;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNHOKENSYURUIKIGOUYOBI3X2)
    public String getZrnhokensyuruikigouyobi3x2() {
        return zrnhokensyuruikigouyobi3x2;
    }

    public void setZrnhokensyuruikigouyobi3x2(String pZrnhokensyuruikigouyobi3x2) {
        zrnhokensyuruikigouyobi3x2 = pZrnhokensyuruikigouyobi3x2;
    }

    private String zrnhokensyuruikigouyobi3x3;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNHOKENSYURUIKIGOUYOBI3X3)
    public String getZrnhokensyuruikigouyobi3x3() {
        return zrnhokensyuruikigouyobi3x3;
    }

    public void setZrnhokensyuruikigouyobi3x3(String pZrnhokensyuruikigouyobi3x3) {
        zrnhokensyuruikigouyobi3x3 = pZrnhokensyuruikigouyobi3x3;
    }

    private String zrnhokensyuruikigouyobi3x4;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNHOKENSYURUIKIGOUYOBI3X4)
    public String getZrnhokensyuruikigouyobi3x4() {
        return zrnhokensyuruikigouyobi3x4;
    }

    public void setZrnhokensyuruikigouyobi3x4(String pZrnhokensyuruikigouyobi3x4) {
        zrnhokensyuruikigouyobi3x4 = pZrnhokensyuruikigouyobi3x4;
    }

    private String zrnhokensyuruikigouyobi3x5;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNHOKENSYURUIKIGOUYOBI3X5)
    public String getZrnhokensyuruikigouyobi3x5() {
        return zrnhokensyuruikigouyobi3x5;
    }

    public void setZrnhokensyuruikigouyobi3x5(String pZrnhokensyuruikigouyobi3x5) {
        zrnhokensyuruikigouyobi3x5 = pZrnhokensyuruikigouyobi3x5;
    }

    private String zrnhokensyuruikigouyobi3x6;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNHOKENSYURUIKIGOUYOBI3X6)
    public String getZrnhokensyuruikigouyobi3x6() {
        return zrnhokensyuruikigouyobi3x6;
    }

    public void setZrnhokensyuruikigouyobi3x6(String pZrnhokensyuruikigouyobi3x6) {
        zrnhokensyuruikigouyobi3x6 = pZrnhokensyuruikigouyobi3x6;
    }

    private String zrnhokensyuruikigouyobi3x7;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNHOKENSYURUIKIGOUYOBI3X7)
    public String getZrnhokensyuruikigouyobi3x7() {
        return zrnhokensyuruikigouyobi3x7;
    }

    public void setZrnhokensyuruikigouyobi3x7(String pZrnhokensyuruikigouyobi3x7) {
        zrnhokensyuruikigouyobi3x7 = pZrnhokensyuruikigouyobi3x7;
    }

    private String zrnhokensyuruikigouyobi3x8;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNHOKENSYURUIKIGOUYOBI3X8)
    public String getZrnhokensyuruikigouyobi3x8() {
        return zrnhokensyuruikigouyobi3x8;
    }

    public void setZrnhokensyuruikigouyobi3x8(String pZrnhokensyuruikigouyobi3x8) {
        zrnhokensyuruikigouyobi3x8 = pZrnhokensyuruikigouyobi3x8;
    }

    private String zrnhokensyuruikigouyobi3x9;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNHOKENSYURUIKIGOUYOBI3X9)
    public String getZrnhokensyuruikigouyobi3x9() {
        return zrnhokensyuruikigouyobi3x9;
    }

    public void setZrnhokensyuruikigouyobi3x9(String pZrnhokensyuruikigouyobi3x9) {
        zrnhokensyuruikigouyobi3x9 = pZrnhokensyuruikigouyobi3x9;
    }

    private String zrnhokensyuruikigouyobi3x10;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNHOKENSYURUIKIGOUYOBI3X10)
    public String getZrnhokensyuruikigouyobi3x10() {
        return zrnhokensyuruikigouyobi3x10;
    }

    public void setZrnhokensyuruikigouyobi3x10(String pZrnhokensyuruikigouyobi3x10) {
        zrnhokensyuruikigouyobi3x10 = pZrnhokensyuruikigouyobi3x10;
    }

    private String zrntenkanteikikigouyobix1;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTENKANTEIKIKIGOUYOBIX1)
    public String getZrntenkanteikikigouyobix1() {
        return zrntenkanteikikigouyobix1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntenkanteikikigouyobix1(String pZrntenkanteikikigouyobix1) {
        zrntenkanteikikigouyobix1 = pZrntenkanteikikigouyobix1;
    }

    private String zrntenkanteikikigouyobix2;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTENKANTEIKIKIGOUYOBIX2)
    public String getZrntenkanteikikigouyobix2() {
        return zrntenkanteikikigouyobix2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntenkanteikikigouyobix2(String pZrntenkanteikikigouyobix2) {
        zrntenkanteikikigouyobix2 = pZrntenkanteikikigouyobix2;
    }

    private String zrntenkanteikikigouyobix3;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTENKANTEIKIKIGOUYOBIX3)
    public String getZrntenkanteikikigouyobix3() {
        return zrntenkanteikikigouyobix3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntenkanteikikigouyobix3(String pZrntenkanteikikigouyobix3) {
        zrntenkanteikikigouyobix3 = pZrntenkanteikikigouyobix3;
    }

    private String zrntenkanteikikigouyobix4;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTENKANTEIKIKIGOUYOBIX4)
    public String getZrntenkanteikikigouyobix4() {
        return zrntenkanteikikigouyobix4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntenkanteikikigouyobix4(String pZrntenkanteikikigouyobix4) {
        zrntenkanteikikigouyobix4 = pZrntenkanteikikigouyobix4;
    }

    private String zrntenkanteikikigouyobix5;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTENKANTEIKIKIGOUYOBIX5)
    public String getZrntenkanteikikigouyobix5() {
        return zrntenkanteikikigouyobix5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntenkanteikikigouyobix5(String pZrntenkanteikikigouyobix5) {
        zrntenkanteikikigouyobix5 = pZrntenkanteikikigouyobix5;
    }

    private String zrnkakuteikakusakgusdkbn;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNKAKUTEIKAKUSAKGUSDKBN)
    public String getZrnkakuteikakusakgusdkbn() {
        return zrnkakuteikakusakgusdkbn;
    }

    public void setZrnkakuteikakusakgusdkbn(String pZrnkakuteikakusakgusdkbn) {
        zrnkakuteikakusakgusdkbn = pZrnkakuteikakusakgusdkbn;
    }

    private String zrnkakuteikakusakguybx1;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNKAKUTEIKAKUSAKGUYBX1)
    public String getZrnkakuteikakusakguybx1() {
        return zrnkakuteikakusakguybx1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkakuteikakusakguybx1(String pZrnkakuteikakusakguybx1) {
        zrnkakuteikakusakguybx1 = pZrnkakuteikakusakguybx1;
    }

    private String zrnkakuteikakusakguybx2;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNKAKUTEIKAKUSAKGUYBX2)
    public String getZrnkakuteikakusakguybx2() {
        return zrnkakuteikakusakguybx2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkakuteikakusakguybx2(String pZrnkakuteikakusakguybx2) {
        zrnkakuteikakusakguybx2 = pZrnkakuteikakusakguybx2;
    }

    private String zrnkakuteikakusakguybx3;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNKAKUTEIKAKUSAKGUYBX3)
    public String getZrnkakuteikakusakguybx3() {
        return zrnkakuteikakusakguybx3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkakuteikakusakguybx3(String pZrnkakuteikakusakguybx3) {
        zrnkakuteikakusakguybx3 = pZrnkakuteikakusakguybx3;
    }

    private String zrnkakuteikakusakguybx4;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNKAKUTEIKAKUSAKGUYBX4)
    public String getZrnkakuteikakusakguybx4() {
        return zrnkakuteikakusakguybx4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkakuteikakusakguybx4(String pZrnkakuteikakusakguybx4) {
        zrnkakuteikakusakguybx4 = pZrnkakuteikakusakguybx4;
    }

    private String zrnkakuteikakusakguybx5;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNKAKUTEIKAKUSAKGUYBX5)
    public String getZrnkakuteikakusakguybx5() {
        return zrnkakuteikakusakguybx5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkakuteikakusakguybx5(String pZrnkakuteikakusakguybx5) {
        zrnkakuteikakusakguybx5 = pZrnkakuteikakusakguybx5;
    }

    private String zrnnaizoumarusakgusdkbn;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNNAIZOUMARUSAKGUSDKBN)
    public String getZrnnaizoumarusakgusdkbn() {
        return zrnnaizoumarusakgusdkbn;
    }

    public void setZrnnaizoumarusakgusdkbn(String pZrnnaizoumarusakgusdkbn) {
        zrnnaizoumarusakgusdkbn = pZrnnaizoumarusakgusdkbn;
    }

    private String zrnnaizoumarusakigouyobix1;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNNAIZOUMARUSAKIGOUYOBIX1)
    public String getZrnnaizoumarusakigouyobix1() {
        return zrnnaizoumarusakigouyobix1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnnaizoumarusakigouyobix1(String pZrnnaizoumarusakigouyobix1) {
        zrnnaizoumarusakigouyobix1 = pZrnnaizoumarusakigouyobix1;
    }

    private String zrnnaizoumarusakigouyobix2;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNNAIZOUMARUSAKIGOUYOBIX2)
    public String getZrnnaizoumarusakigouyobix2() {
        return zrnnaizoumarusakigouyobix2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnnaizoumarusakigouyobix2(String pZrnnaizoumarusakigouyobix2) {
        zrnnaizoumarusakigouyobix2 = pZrnnaizoumarusakigouyobix2;
    }

    private String zrnnaizoumarusakigouyobix3;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNNAIZOUMARUSAKIGOUYOBIX3)
    public String getZrnnaizoumarusakigouyobix3() {
        return zrnnaizoumarusakigouyobix3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnnaizoumarusakigouyobix3(String pZrnnaizoumarusakigouyobix3) {
        zrnnaizoumarusakigouyobix3 = pZrnnaizoumarusakigouyobix3;
    }

    private String zrnnaizoumarusakigouyobix4;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNNAIZOUMARUSAKIGOUYOBIX4)
    public String getZrnnaizoumarusakigouyobix4() {
        return zrnnaizoumarusakigouyobix4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnnaizoumarusakigouyobix4(String pZrnnaizoumarusakigouyobix4) {
        zrnnaizoumarusakigouyobix4 = pZrnnaizoumarusakigouyobix4;
    }

    private String zrnnaizoumarusakigouyobix5;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNNAIZOUMARUSAKIGOUYOBIX5)
    public String getZrnnaizoumarusakigouyobix5() {
        return zrnnaizoumarusakigouyobix5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnnaizoumarusakigouyobix5(String pZrnnaizoumarusakigouyobix5) {
        zrnnaizoumarusakigouyobix5 = pZrnnaizoumarusakigouyobix5;
    }

    private String zrnnaizoukakusakgusdkbn;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNNAIZOUKAKUSAKGUSDKBN)
    public String getZrnnaizoukakusakgusdkbn() {
        return zrnnaizoukakusakgusdkbn;
    }

    public void setZrnnaizoukakusakgusdkbn(String pZrnnaizoukakusakgusdkbn) {
        zrnnaizoukakusakgusdkbn = pZrnnaizoukakusakgusdkbn;
    }

    private String zrnnaizoukakusakigouyobix1;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNNAIZOUKAKUSAKIGOUYOBIX1)
    public String getZrnnaizoukakusakigouyobix1() {
        return zrnnaizoukakusakigouyobix1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnnaizoukakusakigouyobix1(String pZrnnaizoukakusakigouyobix1) {
        zrnnaizoukakusakigouyobix1 = pZrnnaizoukakusakigouyobix1;
    }

    private String zrnnaizoukakusakigouyobix2;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNNAIZOUKAKUSAKIGOUYOBIX2)
    public String getZrnnaizoukakusakigouyobix2() {
        return zrnnaizoukakusakigouyobix2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnnaizoukakusakigouyobix2(String pZrnnaizoukakusakigouyobix2) {
        zrnnaizoukakusakigouyobix2 = pZrnnaizoukakusakigouyobix2;
    }

    private String zrnnaizoukakusakigouyobix3;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNNAIZOUKAKUSAKIGOUYOBIX3)
    public String getZrnnaizoukakusakigouyobix3() {
        return zrnnaizoukakusakigouyobix3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnnaizoukakusakigouyobix3(String pZrnnaizoukakusakigouyobix3) {
        zrnnaizoukakusakigouyobix3 = pZrnnaizoukakusakigouyobix3;
    }

    private String zrnnaizoukakusakigouyobix4;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNNAIZOUKAKUSAKIGOUYOBIX4)
    public String getZrnnaizoukakusakigouyobix4() {
        return zrnnaizoukakusakigouyobix4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnnaizoukakusakigouyobix4(String pZrnnaizoukakusakigouyobix4) {
        zrnnaizoukakusakigouyobix4 = pZrnnaizoukakusakigouyobix4;
    }

    private String zrnnaizoukakusakigouyobix5;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNNAIZOUKAKUSAKIGOUYOBIX5)
    public String getZrnnaizoukakusakigouyobix5() {
        return zrnnaizoukakusakigouyobix5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnnaizoukakusakigouyobix5(String pZrnnaizoukakusakigouyobix5) {
        zrnnaizoukakusakigouyobix5 = pZrnnaizoukakusakigouyobix5;
    }

    private String zrnyobiv92;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNYOBIV92)
    public String getZrnyobiv92() {
        return zrnyobiv92;
    }

    public void setZrnyobiv92(String pZrnyobiv92) {
        zrnyobiv92 = pZrnyobiv92;
    }

    private String zrnraysystemhyj;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNRAYSYSTEMHYJ)
    public String getZrnraysystemhyj() {
        return zrnraysystemhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnraysystemhyj(String pZrnraysystemhyj) {
        zrnraysystemhyj = pZrnraysystemhyj;
    }

    private String zrngaikakbn;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNGAIKAKBN)
    public String getZrngaikakbn() {
        return zrngaikakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrngaikakbn(String pZrngaikakbn) {
        zrngaikakbn = pZrngaikakbn;
    }

    private BizNumber zrnkawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNKAWASERATE)
    public BizNumber getZrnkawaserate() {
        return zrnkawaserate;
    }

    public void setZrnkawaserate(BizNumber pZrnkawaserate) {
        zrnkawaserate = pZrnkawaserate;
    }

    private String zrnkawaseratetekiyouymd;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNKAWASERATETEKIYOUYMD)
    public String getZrnkawaseratetekiyouymd() {
        return zrnkawaseratetekiyouymd;
    }

    public void setZrnkawaseratetekiyouymd(String pZrnkawaseratetekiyouymd) {
        zrnkawaseratetekiyouymd = pZrnkawaseratetekiyouymd;
    }

    private Long zrnenkdtsbujsitihsyukngk;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNENKDTSBUJSITIHSYUKNGK)
    public Long getZrnenkdtsbujsitihsyukngk() {
        return zrnenkdtsbujsitihsyukngk;
    }

    public void setZrnenkdtsbujsitihsyukngk(Long pZrnenkdtsbujsitihsyukngk) {
        zrnenkdtsbujsitihsyukngk = pZrnenkdtsbujsitihsyukngk;
    }

    private String zrnsuuriyouyobin10;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNSUURIYOUYOBIN10)
    public String getZrnsuuriyouyobin10() {
        return zrnsuuriyouyobin10;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnsuuriyouyobin10(String pZrnsuuriyouyobin10) {
        zrnsuuriyouyobin10 = pZrnsuuriyouyobin10;
    }

    private String zrnyobiv10x2;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNYOBIV10X2)
    public String getZrnyobiv10x2() {
        return zrnyobiv10x2;
    }

    public void setZrnyobiv10x2(String pZrnyobiv10x2) {
        zrnyobiv10x2 = pZrnyobiv10x2;
    }

    private Long zrnyobin11;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNYOBIN11)
    public Long getZrnyobin11() {
        return zrnyobin11;
    }

    public void setZrnyobin11(Long pZrnyobin11) {
        zrnyobin11 = pZrnyobin11;
    }

    private Long zrnyobin11x2;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNYOBIN11X2)
    public Long getZrnyobin11x2() {
        return zrnyobin11x2;
    }

    public void setZrnyobin11x2(Long pZrnyobin11x2) {
        zrnyobin11x2 = pZrnyobin11x2;
    }

    private String zrnyobiv17;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNYOBIV17)
    public String getZrnyobiv17() {
        return zrnyobiv17;
    }

    public void setZrnyobiv17(String pZrnyobiv17) {
        zrnyobiv17 = pZrnyobiv17;
    }

    private BizNumber zrnsisadrate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNSISADRATE)
    public BizNumber getZrnsisadrate() {
        return zrnsisadrate;
    }

    public void setZrnsisadrate(BizNumber pZrnsisadrate) {
        zrnsisadrate = pZrnsisadrate;
    }

    private BizNumber zrnrisadrate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNRISADRATE)
    public BizNumber getZrnrisadrate() {
        return zrnrisadrate;
    }

    public void setZrnrisadrate(BizNumber pZrnrisadrate) {
        zrnrisadrate = pZrnrisadrate;
    }

    private BizNumber zrnhisadrate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNHISADRATE)
    public BizNumber getZrnhisadrate() {
        return zrnhisadrate;
    }

    public void setZrnhisadrate(BizNumber pZrnhisadrate) {
        zrnhisadrate = pZrnhisadrate;
    }

    private BizNumber zrndyouvrate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNDYOUVRATE)
    public BizNumber getZrndyouvrate() {
        return zrndyouvrate;
    }

    public void setZrndyouvrate(BizNumber pZrndyouvrate) {
        zrndyouvrate = pZrndyouvrate;
    }

    private BizNumber zrnkikensrate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNKIKENSRATE)
    public BizNumber getZrnkikensrate() {
        return zrnkikensrate;
    }

    public void setZrnkikensrate(BizNumber pZrnkikensrate) {
        zrnkikensrate = pZrnkikensrate;
    }

    private BizNumber zrngoukeidrate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNGOUKEIDRATE)
    public BizNumber getZrngoukeidrate() {
        return zrngoukeidrate;
    }

    public void setZrngoukeidrate(BizNumber pZrngoukeidrate) {
        zrngoukeidrate = pZrngoukeidrate;
    }

    private String zrntokuyakukoumokuv180;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTOKUYAKUKOUMOKUV180)
    public String getZrntokuyakukoumokuv180() {
        return zrntokuyakukoumokuv180;
    }

    public void setZrntokuyakukoumokuv180(String pZrntokuyakukoumokuv180) {
        zrntokuyakukoumokuv180 = pZrntokuyakukoumokuv180;
    }

    private String zrntokuyakukoumokuv180x2;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTOKUYAKUKOUMOKUV180X2)
    public String getZrntokuyakukoumokuv180x2() {
        return zrntokuyakukoumokuv180x2;
    }

    public void setZrntokuyakukoumokuv180x2(String pZrntokuyakukoumokuv180x2) {
        zrntokuyakukoumokuv180x2 = pZrntokuyakukoumokuv180x2;
    }

    private String zrntokuyakukoumokuv180x3;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTOKUYAKUKOUMOKUV180X3)
    public String getZrntokuyakukoumokuv180x3() {
        return zrntokuyakukoumokuv180x3;
    }

    public void setZrntokuyakukoumokuv180x3(String pZrntokuyakukoumokuv180x3) {
        zrntokuyakukoumokuv180x3 = pZrntokuyakukoumokuv180x3;
    }

    private String zrntokuyakukoumokuv180x4;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTOKUYAKUKOUMOKUV180X4)
    public String getZrntokuyakukoumokuv180x4() {
        return zrntokuyakukoumokuv180x4;
    }

    public void setZrntokuyakukoumokuv180x4(String pZrntokuyakukoumokuv180x4) {
        zrntokuyakukoumokuv180x4 = pZrntokuyakukoumokuv180x4;
    }

    private String zrntokuyakukoumokuv180x5;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTOKUYAKUKOUMOKUV180X5)
    public String getZrntokuyakukoumokuv180x5() {
        return zrntokuyakukoumokuv180x5;
    }

    public void setZrntokuyakukoumokuv180x5(String pZrntokuyakukoumokuv180x5) {
        zrntokuyakukoumokuv180x5 = pZrntokuyakukoumokuv180x5;
    }

    private String zrntokuyakukoumokuv180x6;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTOKUYAKUKOUMOKUV180X6)
    public String getZrntokuyakukoumokuv180x6() {
        return zrntokuyakukoumokuv180x6;
    }

    public void setZrntokuyakukoumokuv180x6(String pZrntokuyakukoumokuv180x6) {
        zrntokuyakukoumokuv180x6 = pZrntokuyakukoumokuv180x6;
    }

    private String zrntokuyakukoumokuv180x7;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTOKUYAKUKOUMOKUV180X7)
    public String getZrntokuyakukoumokuv180x7() {
        return zrntokuyakukoumokuv180x7;
    }

    public void setZrntokuyakukoumokuv180x7(String pZrntokuyakukoumokuv180x7) {
        zrntokuyakukoumokuv180x7 = pZrntokuyakukoumokuv180x7;
    }

    private String zrntokuyakukoumokuv180x8;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTOKUYAKUKOUMOKUV180X8)
    public String getZrntokuyakukoumokuv180x8() {
        return zrntokuyakukoumokuv180x8;
    }

    public void setZrntokuyakukoumokuv180x8(String pZrntokuyakukoumokuv180x8) {
        zrntokuyakukoumokuv180x8 = pZrntokuyakukoumokuv180x8;
    }

    private String zrntokuyakukoumokuv180x9;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTOKUYAKUKOUMOKUV180X9)
    public String getZrntokuyakukoumokuv180x9() {
        return zrntokuyakukoumokuv180x9;
    }

    public void setZrntokuyakukoumokuv180x9(String pZrntokuyakukoumokuv180x9) {
        zrntokuyakukoumokuv180x9 = pZrntokuyakukoumokuv180x9;
    }

    private String zrntokuyakukoumokuv180x10;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTOKUYAKUKOUMOKUV180X10)
    public String getZrntokuyakukoumokuv180x10() {
        return zrntokuyakukoumokuv180x10;
    }

    public void setZrntokuyakukoumokuv180x10(String pZrntokuyakukoumokuv180x10) {
        zrntokuyakukoumokuv180x10 = pZrntokuyakukoumokuv180x10;
    }

    private String zrntokuyakukoumokuv180x11;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTOKUYAKUKOUMOKUV180X11)
    public String getZrntokuyakukoumokuv180x11() {
        return zrntokuyakukoumokuv180x11;
    }

    public void setZrntokuyakukoumokuv180x11(String pZrntokuyakukoumokuv180x11) {
        zrntokuyakukoumokuv180x11 = pZrntokuyakukoumokuv180x11;
    }

    private String zrntokuyakukoumokuv180x12;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTOKUYAKUKOUMOKUV180X12)
    public String getZrntokuyakukoumokuv180x12() {
        return zrntokuyakukoumokuv180x12;
    }

    public void setZrntokuyakukoumokuv180x12(String pZrntokuyakukoumokuv180x12) {
        zrntokuyakukoumokuv180x12 = pZrntokuyakukoumokuv180x12;
    }

    private String zrntokuyakukoumokuv180x13;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTOKUYAKUKOUMOKUV180X13)
    public String getZrntokuyakukoumokuv180x13() {
        return zrntokuyakukoumokuv180x13;
    }

    public void setZrntokuyakukoumokuv180x13(String pZrntokuyakukoumokuv180x13) {
        zrntokuyakukoumokuv180x13 = pZrntokuyakukoumokuv180x13;
    }

    private String zrntokuyakukoumokuv180x14;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTOKUYAKUKOUMOKUV180X14)
    public String getZrntokuyakukoumokuv180x14() {
        return zrntokuyakukoumokuv180x14;
    }

    public void setZrntokuyakukoumokuv180x14(String pZrntokuyakukoumokuv180x14) {
        zrntokuyakukoumokuv180x14 = pZrntokuyakukoumokuv180x14;
    }

    private String zrntokuyakukoumokuv180x15;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTOKUYAKUKOUMOKUV180X15)
    public String getZrntokuyakukoumokuv180x15() {
        return zrntokuyakukoumokuv180x15;
    }

    public void setZrntokuyakukoumokuv180x15(String pZrntokuyakukoumokuv180x15) {
        zrntokuyakukoumokuv180x15 = pZrntokuyakukoumokuv180x15;
    }

    private String zrntokuyakukoumokuv180x16;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTOKUYAKUKOUMOKUV180X16)
    public String getZrntokuyakukoumokuv180x16() {
        return zrntokuyakukoumokuv180x16;
    }

    public void setZrntokuyakukoumokuv180x16(String pZrntokuyakukoumokuv180x16) {
        zrntokuyakukoumokuv180x16 = pZrntokuyakukoumokuv180x16;
    }

    private String zrntokuyakukoumokuv180x17;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTOKUYAKUKOUMOKUV180X17)
    public String getZrntokuyakukoumokuv180x17() {
        return zrntokuyakukoumokuv180x17;
    }

    public void setZrntokuyakukoumokuv180x17(String pZrntokuyakukoumokuv180x17) {
        zrntokuyakukoumokuv180x17 = pZrntokuyakukoumokuv180x17;
    }

    private String zrntokuyakukoumokuv180x18;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTOKUYAKUKOUMOKUV180X18)
    public String getZrntokuyakukoumokuv180x18() {
        return zrntokuyakukoumokuv180x18;
    }

    public void setZrntokuyakukoumokuv180x18(String pZrntokuyakukoumokuv180x18) {
        zrntokuyakukoumokuv180x18 = pZrntokuyakukoumokuv180x18;
    }

    private String zrntokuyakukoumokuv180x19;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTOKUYAKUKOUMOKUV180X19)
    public String getZrntokuyakukoumokuv180x19() {
        return zrntokuyakukoumokuv180x19;
    }

    public void setZrntokuyakukoumokuv180x19(String pZrntokuyakukoumokuv180x19) {
        zrntokuyakukoumokuv180x19 = pZrntokuyakukoumokuv180x19;
    }

    private String zrntokuyakukoumokuv180x20;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTOKUYAKUKOUMOKUV180X20)
    public String getZrntokuyakukoumokuv180x20() {
        return zrntokuyakukoumokuv180x20;
    }

    public void setZrntokuyakukoumokuv180x20(String pZrntokuyakukoumokuv180x20) {
        zrntokuyakukoumokuv180x20 = pZrntokuyakukoumokuv180x20;
    }

    private String zrntokuyakukoumokuv180x21;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTOKUYAKUKOUMOKUV180X21)
    public String getZrntokuyakukoumokuv180x21() {
        return zrntokuyakukoumokuv180x21;
    }

    public void setZrntokuyakukoumokuv180x21(String pZrntokuyakukoumokuv180x21) {
        zrntokuyakukoumokuv180x21 = pZrntokuyakukoumokuv180x21;
    }

    private String zrntokuyakukoumokuv180x22;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTOKUYAKUKOUMOKUV180X22)
    public String getZrntokuyakukoumokuv180x22() {
        return zrntokuyakukoumokuv180x22;
    }

    public void setZrntokuyakukoumokuv180x22(String pZrntokuyakukoumokuv180x22) {
        zrntokuyakukoumokuv180x22 = pZrntokuyakukoumokuv180x22;
    }

    private String zrntokuyakukoumokuv180x23;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTOKUYAKUKOUMOKUV180X23)
    public String getZrntokuyakukoumokuv180x23() {
        return zrntokuyakukoumokuv180x23;
    }

    public void setZrntokuyakukoumokuv180x23(String pZrntokuyakukoumokuv180x23) {
        zrntokuyakukoumokuv180x23 = pZrntokuyakukoumokuv180x23;
    }

    private String zrntokuyakukoumokuv180x24;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTOKUYAKUKOUMOKUV180X24)
    public String getZrntokuyakukoumokuv180x24() {
        return zrntokuyakukoumokuv180x24;
    }

    public void setZrntokuyakukoumokuv180x24(String pZrntokuyakukoumokuv180x24) {
        zrntokuyakukoumokuv180x24 = pZrntokuyakukoumokuv180x24;
    }

    private String zrntokuyakukoumokuv180x25;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTOKUYAKUKOUMOKUV180X25)
    public String getZrntokuyakukoumokuv180x25() {
        return zrntokuyakukoumokuv180x25;
    }

    public void setZrntokuyakukoumokuv180x25(String pZrntokuyakukoumokuv180x25) {
        zrntokuyakukoumokuv180x25 = pZrntokuyakukoumokuv180x25;
    }

    private String zrntokuyakukoumokuv180x26;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTOKUYAKUKOUMOKUV180X26)
    public String getZrntokuyakukoumokuv180x26() {
        return zrntokuyakukoumokuv180x26;
    }

    public void setZrntokuyakukoumokuv180x26(String pZrntokuyakukoumokuv180x26) {
        zrntokuyakukoumokuv180x26 = pZrntokuyakukoumokuv180x26;
    }

    private String zrntokuyakukoumokuv180x27;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTOKUYAKUKOUMOKUV180X27)
    public String getZrntokuyakukoumokuv180x27() {
        return zrntokuyakukoumokuv180x27;
    }

    public void setZrntokuyakukoumokuv180x27(String pZrntokuyakukoumokuv180x27) {
        zrntokuyakukoumokuv180x27 = pZrntokuyakukoumokuv180x27;
    }

    private String zrntokuyakukoumokuv180x28;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTOKUYAKUKOUMOKUV180X28)
    public String getZrntokuyakukoumokuv180x28() {
        return zrntokuyakukoumokuv180x28;
    }

    public void setZrntokuyakukoumokuv180x28(String pZrntokuyakukoumokuv180x28) {
        zrntokuyakukoumokuv180x28 = pZrntokuyakukoumokuv180x28;
    }

    private String zrntokuyakukoumokuv180x29;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTOKUYAKUKOUMOKUV180X29)
    public String getZrntokuyakukoumokuv180x29() {
        return zrntokuyakukoumokuv180x29;
    }

    public void setZrntokuyakukoumokuv180x29(String pZrntokuyakukoumokuv180x29) {
        zrntokuyakukoumokuv180x29 = pZrntokuyakukoumokuv180x29;
    }

    private String zrntokuyakukoumokuv180x30;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTOKUYAKUKOUMOKUV180X30)
    public String getZrntokuyakukoumokuv180x30() {
        return zrntokuyakukoumokuv180x30;
    }

    public void setZrntokuyakukoumokuv180x30(String pZrntokuyakukoumokuv180x30) {
        zrntokuyakukoumokuv180x30 = pZrntokuyakukoumokuv180x30;
    }

    private String zrntokuyakukoumokuv180x31;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTOKUYAKUKOUMOKUV180X31)
    public String getZrntokuyakukoumokuv180x31() {
        return zrntokuyakukoumokuv180x31;
    }

    public void setZrntokuyakukoumokuv180x31(String pZrntokuyakukoumokuv180x31) {
        zrntokuyakukoumokuv180x31 = pZrntokuyakukoumokuv180x31;
    }

    private String zrntokuyakukoumokuv180x32;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTOKUYAKUKOUMOKUV180X32)
    public String getZrntokuyakukoumokuv180x32() {
        return zrntokuyakukoumokuv180x32;
    }

    public void setZrntokuyakukoumokuv180x32(String pZrntokuyakukoumokuv180x32) {
        zrntokuyakukoumokuv180x32 = pZrntokuyakukoumokuv180x32;
    }

    private String zrntokuyakukoumokuv180x33;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTOKUYAKUKOUMOKUV180X33)
    public String getZrntokuyakukoumokuv180x33() {
        return zrntokuyakukoumokuv180x33;
    }

    public void setZrntokuyakukoumokuv180x33(String pZrntokuyakukoumokuv180x33) {
        zrntokuyakukoumokuv180x33 = pZrntokuyakukoumokuv180x33;
    }

    private String zrntokuyakukoumokuv180x34;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTOKUYAKUKOUMOKUV180X34)
    public String getZrntokuyakukoumokuv180x34() {
        return zrntokuyakukoumokuv180x34;
    }

    public void setZrntokuyakukoumokuv180x34(String pZrntokuyakukoumokuv180x34) {
        zrntokuyakukoumokuv180x34 = pZrntokuyakukoumokuv180x34;
    }

    private String zrntokuyakukoumokuv180x35;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTOKUYAKUKOUMOKUV180X35)
    public String getZrntokuyakukoumokuv180x35() {
        return zrntokuyakukoumokuv180x35;
    }

    public void setZrntokuyakukoumokuv180x35(String pZrntokuyakukoumokuv180x35) {
        zrntokuyakukoumokuv180x35 = pZrntokuyakukoumokuv180x35;
    }

    private String zrntokuyakukoumokuv180x36;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTOKUYAKUKOUMOKUV180X36)
    public String getZrntokuyakukoumokuv180x36() {
        return zrntokuyakukoumokuv180x36;
    }

    public void setZrntokuyakukoumokuv180x36(String pZrntokuyakukoumokuv180x36) {
        zrntokuyakukoumokuv180x36 = pZrntokuyakukoumokuv180x36;
    }

    private String zrntokuyakukoumokuv180x37;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTOKUYAKUKOUMOKUV180X37)
    public String getZrntokuyakukoumokuv180x37() {
        return zrntokuyakukoumokuv180x37;
    }

    public void setZrntokuyakukoumokuv180x37(String pZrntokuyakukoumokuv180x37) {
        zrntokuyakukoumokuv180x37 = pZrntokuyakukoumokuv180x37;
    }

    private String zrntokuyakukoumokuv180x38;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTOKUYAKUKOUMOKUV180X38)
    public String getZrntokuyakukoumokuv180x38() {
        return zrntokuyakukoumokuv180x38;
    }

    public void setZrntokuyakukoumokuv180x38(String pZrntokuyakukoumokuv180x38) {
        zrntokuyakukoumokuv180x38 = pZrntokuyakukoumokuv180x38;
    }

    private String zrntokuyakukoumokuv180x39;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTOKUYAKUKOUMOKUV180X39)
    public String getZrntokuyakukoumokuv180x39() {
        return zrntokuyakukoumokuv180x39;
    }

    public void setZrntokuyakukoumokuv180x39(String pZrntokuyakukoumokuv180x39) {
        zrntokuyakukoumokuv180x39 = pZrntokuyakukoumokuv180x39;
    }

    private String zrntokuyakukoumokuv180x40;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTOKUYAKUKOUMOKUV180X40)
    public String getZrntokuyakukoumokuv180x40() {
        return zrntokuyakukoumokuv180x40;
    }

    public void setZrntokuyakukoumokuv180x40(String pZrntokuyakukoumokuv180x40) {
        zrntokuyakukoumokuv180x40 = pZrntokuyakukoumokuv180x40;
    }

    private String zrntokuyakukoumokuv180x41;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTOKUYAKUKOUMOKUV180X41)
    public String getZrntokuyakukoumokuv180x41() {
        return zrntokuyakukoumokuv180x41;
    }

    public void setZrntokuyakukoumokuv180x41(String pZrntokuyakukoumokuv180x41) {
        zrntokuyakukoumokuv180x41 = pZrntokuyakukoumokuv180x41;
    }

    private String zrntokuyakukoumokuv180x42;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTOKUYAKUKOUMOKUV180X42)
    public String getZrntokuyakukoumokuv180x42() {
        return zrntokuyakukoumokuv180x42;
    }

    public void setZrntokuyakukoumokuv180x42(String pZrntokuyakukoumokuv180x42) {
        zrntokuyakukoumokuv180x42 = pZrntokuyakukoumokuv180x42;
    }

    private String zrntokuyakukoumokuv180x43;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTOKUYAKUKOUMOKUV180X43)
    public String getZrntokuyakukoumokuv180x43() {
        return zrntokuyakukoumokuv180x43;
    }

    public void setZrntokuyakukoumokuv180x43(String pZrntokuyakukoumokuv180x43) {
        zrntokuyakukoumokuv180x43 = pZrntokuyakukoumokuv180x43;
    }

    private String zrntokuyakukoumokuv180x44;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTOKUYAKUKOUMOKUV180X44)
    public String getZrntokuyakukoumokuv180x44() {
        return zrntokuyakukoumokuv180x44;
    }

    public void setZrntokuyakukoumokuv180x44(String pZrntokuyakukoumokuv180x44) {
        zrntokuyakukoumokuv180x44 = pZrntokuyakukoumokuv180x44;
    }

    private String zrntokuyakukoumokuv180x45;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTOKUYAKUKOUMOKUV180X45)
    public String getZrntokuyakukoumokuv180x45() {
        return zrntokuyakukoumokuv180x45;
    }

    public void setZrntokuyakukoumokuv180x45(String pZrntokuyakukoumokuv180x45) {
        zrntokuyakukoumokuv180x45 = pZrntokuyakukoumokuv180x45;
    }

    private String zrntokuyakukoumokuv180x46;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTOKUYAKUKOUMOKUV180X46)
    public String getZrntokuyakukoumokuv180x46() {
        return zrntokuyakukoumokuv180x46;
    }

    public void setZrntokuyakukoumokuv180x46(String pZrntokuyakukoumokuv180x46) {
        zrntokuyakukoumokuv180x46 = pZrntokuyakukoumokuv180x46;
    }

    private String zrntokuyakukoumokuv180x47;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTOKUYAKUKOUMOKUV180X47)
    public String getZrntokuyakukoumokuv180x47() {
        return zrntokuyakukoumokuv180x47;
    }

    public void setZrntokuyakukoumokuv180x47(String pZrntokuyakukoumokuv180x47) {
        zrntokuyakukoumokuv180x47 = pZrntokuyakukoumokuv180x47;
    }

    private String zrntokuyakukoumokuv180x48;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTOKUYAKUKOUMOKUV180X48)
    public String getZrntokuyakukoumokuv180x48() {
        return zrntokuyakukoumokuv180x48;
    }

    public void setZrntokuyakukoumokuv180x48(String pZrntokuyakukoumokuv180x48) {
        zrntokuyakukoumokuv180x48 = pZrntokuyakukoumokuv180x48;
    }

    private String zrntokuyakukoumokuv180x49;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTOKUYAKUKOUMOKUV180X49)
    public String getZrntokuyakukoumokuv180x49() {
        return zrntokuyakukoumokuv180x49;
    }

    public void setZrntokuyakukoumokuv180x49(String pZrntokuyakukoumokuv180x49) {
        zrntokuyakukoumokuv180x49 = pZrntokuyakukoumokuv180x49;
    }

    private String zrntokuyakukoumokuv180x50;

    @Column(name=GenZT_TjHitsyyugkNminusZeroRn.ZRNTOKUYAKUKOUMOKUV180X50)
    public String getZrntokuyakukoumokuv180x50() {
        return zrntokuyakukoumokuv180x50;
    }

    public void setZrntokuyakukoumokuv180x50(String pZrntokuyakukoumokuv180x50) {
        zrntokuyakukoumokuv180x50 = pZrntokuyakukoumokuv180x50;
    }
}