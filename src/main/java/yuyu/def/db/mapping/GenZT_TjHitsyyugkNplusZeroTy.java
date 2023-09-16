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
import yuyu.def.db.entity.ZT_TjHitsyyugkNplusZeroTy;
import yuyu.def.db.id.PKZT_TjHitsyyugkNplusZeroTy;
import yuyu.def.db.meta.GenQZT_TjHitsyyugkNplusZeroTy;
import yuyu.def.db.meta.QZT_TjHitsyyugkNplusZeroTy;

/**
 * 通常配当所要額Ｆ（Ｎ＋０）テーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_TjHitsyyugkNplusZeroTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_TjHitsyyugkNplusZeroTy}</td><td colspan="3">通常配当所要額Ｆ（Ｎ＋０）テーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtysequenceno ztysequenceno}</td><td>（中継用）シーケンス番号</td><td align="center">{@link PKZT_TjHitsyyugkNplusZeroTy ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyyuukourecordlength ztyyuukourecordlength}</td><td>（中継用）有効レコード長</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyrdwarea ztyrdwarea}</td><td>（中継用）ＲＤＷ領域</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyerrkbnv2 ztyerrkbnv2}</td><td>（中継用）エラー区分Ｖ２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyratekbn ztyratekbn}</td><td>（中継用）レート区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeisandnendo ztykeisandnendo}</td><td>（中継用）計算Ｄ年度</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeijyouym ztykeijyouym}</td><td>（中継用）計上年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyouinkbn ztysyouinkbn}</td><td>（中継用）消因区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykbnkeiriyousegmentkbn ztykbnkeiriyousegmentkbn}</td><td>（中継用）区分経理用セグメント区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykbnkeiriyourgnbnskkbn ztykbnkeiriyourgnbnskkbn}</td><td>（中継用）区分経理用利源分析区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukeiyakusyuruicdv2 ztysyukeiyakusyuruicdv2}</td><td>（中継用）主契約種類コードＶ２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydaihyouyoteiriritu ztydaihyouyoteiriritu}</td><td>（中継用）代表予定利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyharaikatakbn ztyharaikatakbn}</td><td>（中継用）払方区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynenkinkaisigohyouji ztynenkinkaisigohyouji}</td><td>（中継用）年金開始後表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykjyoutai ztykykjyoutai}</td><td>（中継用）契約状態</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynaizouteikiyoteiriritu ztynaizouteikiyoteiriritu}</td><td>（中継用）内蔵定期予定利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtygoukeigyousekihyoujis ztygoukeigyousekihyoujis}</td><td>（中継用）合計業績表示Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysykykgyusekihyjs ztysykykgyusekihyjs}</td><td>（中継用）主契約業績表示Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytnknitjbrsykykgyuskhyjs ztytnknitjbrsykykgyuskhyjs}</td><td>（中継用）転換一時払主契約業績表示Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtydatakanrino ztydatakanrino}</td><td>（中継用）データ管理番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknsyukigou ztyhknsyukigou}</td><td>（中継用）保険種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyannaifuyouriyuukbn ztyannaifuyouriyuukbn}</td><td>（中継用）案内不要理由区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytkbthsyumnryuhyouji ztytkbthsyumnryuhyouji}</td><td>（中継用）特別保障満了表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykymd ztykykymd}</td><td>（中継用）契約年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknseikbn ztyhhknseikbn}</td><td>（中継用）被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhihokensyaagev2 ztyhihokensyaagev2}</td><td>（中継用）被保険者年令Ｖ２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknkkn ztyhknkkn}</td><td>（中継用）保険期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyphrkkikn ztyphrkkikn}</td><td>（中継用）Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysaimnkkykhyj ztysaimnkkykhyj}</td><td>（中継用）才満期契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkaisuukbn ztyhrkkaisuukbn}</td><td>（中継用）払込回数区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyannaikigetu ztyannaikigetu}</td><td>（中継用）案内期月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyao3tyou3sibousdatehyouji ztyao3tyou3sibousdatehyouji}</td><td>（中継用）青３長３死亡Ｓ建表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykihons ztykihons}</td><td>（中継用）基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyharaizumiymd ztyharaizumiymd}</td><td>（中継用）払済年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyharaizumis ztyharaizumis}</td><td>（中継用）払済Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyentyous ztyentyous}</td><td>（中継用）延長Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyseizons ztyseizons}</td><td>（中継用）生存Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtypmens ztypmens}</td><td>（中継用）Ｐ免Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhendous ztyhendous}</td><td>（中継用）変動Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyitibuitijibarais ztyitibuitijibarais}</td><td>（中継用）一部一時払Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytenkanteikisyuruikigou ztytenkanteikisyuruikigou}</td><td>（中継用）転換定期種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytenkanteikikikan ztytenkanteikikikan}</td><td>（中継用）転換定期期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytnknteikinkshrkkn ztytnknteikinkshrkkn}</td><td>（中継用）転換定期年金支払期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygoukeitenkans ztygoukeitenkans}</td><td>（中継用）合計転換Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygoukeitenkanteikis ztygoukeitenkanteikis}</td><td>（中継用）合計転換定期Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygoukeipbubuntenkans ztygoukeipbubuntenkans}</td><td>（中継用）合計Ｐ部分転換Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytenkankaisuu ztytenkankaisuu}</td><td>（中継用）転換回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydgoukei ztydgoukei}</td><td>（中継用）Ｄ合計</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysrankbetuhisad ztysrankbetuhisad}</td><td>（中継用）Ｓランク別費差Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysyumtjsrankbetuhisad ztysyumtjsrankbetuhisad}</td><td>（中継用）消滅時Ｓランク別費差Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtybairitubetuhisad ztybairitubetuhisad}</td><td>（中継用）倍率別費差Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysyumtjtikbairtbetuhisad ztysyumtjtikbairtbetuhisad}</td><td>（中継用）消滅時定期倍率別費差Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysyukeiyakukihongoukeid ztysyukeiyakukihongoukeid}</td><td>（中継用）主契約基本合計Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysyukeiyakukihonsisad ztysyukeiyakukihonsisad}</td><td>（中継用）主契約基本死差Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysyukeiyakukihonrisad ztysyukeiyakukihonrisad}</td><td>（中継用）主契約基本利差Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysyukeiyakukihonramudad ztysyukeiyakukihonramudad}</td><td>（中継用）主契約基本ラムダＤ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysyukeiyakukihonhisad ztysyukeiyakukihonhisad}</td><td>（中継用）主契約基本費差Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysyukeiyakukihondtaisyous ztysyukeiyakukihondtaisyous}</td><td>（中継用）主契約基本Ｄ対象Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysyukeiyakukihondyouv ztysyukeiyakukihondyouv}</td><td>（中継用）主契約基本Ｄ用Ｖ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysyukeiyakukihondkikens ztysyukeiyakukihondkikens}</td><td>（中継用）主契約基本Ｄ危険Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysykykkhnhisadtisyus ztysykykkhnhisadtisyus}</td><td>（中継用）主契約基本費差Ｄ対象Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysyukeiyakuteikigoukeid ztysyukeiyakuteikigoukeid}</td><td>（中継用）主契約定期合計Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysyukeiyakuteikisisad ztysyukeiyakuteikisisad}</td><td>（中継用）主契約定期死差Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysyukeiyakuteikirisad ztysyukeiyakuteikirisad}</td><td>（中継用）主契約定期利差Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysyukeiyakuteikiramudad ztysyukeiyakuteikiramudad}</td><td>（中継用）主契約定期ラムダＤ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysyukeiyakuteikihisad ztysyukeiyakuteikihisad}</td><td>（中継用）主契約定期費差Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysyukeiyakuteikidtaisyous ztysyukeiyakuteikidtaisyous}</td><td>（中継用）主契約定期Ｄ対象Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysyukeiyakuteikidyouv ztysyukeiyakuteikidyouv}</td><td>（中継用）主契約定期Ｄ用Ｖ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysyukeiyakuteikidkikens ztysyukeiyakuteikidkikens}</td><td>（中継用）主契約定期Ｄ危険Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysykyktikhisadtisyus ztysykyktikhisadtisyus}</td><td>（中継用）主契約定期費差Ｄ対象Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytenkankihongoukeid ztytenkankihongoukeid}</td><td>（中継用）転換基本合計Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytenkankihonsisad ztytenkankihonsisad}</td><td>（中継用）転換基本死差Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytenkankihonrisad ztytenkankihonrisad}</td><td>（中継用）転換基本利差Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytenkankihonramudad ztytenkankihonramudad}</td><td>（中継用）転換基本ラムダＤ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytenkankihonhisad ztytenkankihonhisad}</td><td>（中継用）転換基本費差Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytenkankihondtaisyous ztytenkankihondtaisyous}</td><td>（中継用）転換基本Ｄ対象Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytenkankihondyouv ztytenkankihondyouv}</td><td>（中継用）転換基本Ｄ用Ｖ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytenkankihondkikens ztytenkankihondkikens}</td><td>（中継用）転換基本Ｄ危険Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytenkankihonhisadtaisyous ztytenkankihonhisadtaisyous}</td><td>（中継用）転換基本費差Ｄ対象Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytenkanteikigoukeid ztytenkanteikigoukeid}</td><td>（中継用）転換定期合計Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytenkanteikisisad ztytenkanteikisisad}</td><td>（中継用）転換定期死差Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytenkanteikirisad ztytenkanteikirisad}</td><td>（中継用）転換定期利差Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytenkanteikiramudad ztytenkanteikiramudad}</td><td>（中継用）転換定期ラムダＤ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytenkanteikihisad ztytenkanteikihisad}</td><td>（中継用）転換定期費差Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytenkanteikidtaisyous ztytenkanteikidtaisyous}</td><td>（中継用）転換定期Ｄ対象Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytenkanteikidyouv ztytenkanteikidyouv}</td><td>（中継用）転換定期Ｄ用Ｖ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytenkanteikidkikens ztytenkanteikidkikens}</td><td>（中継用）転換定期Ｄ危険Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytenkanteikihisadtaisyous ztytenkanteikihisadtaisyous}</td><td>（中継用）転換定期費差Ｄ対象Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysyumtjtyusiyutnkntikgukd ztysyumtjtyusiyutnkntikgukd}</td><td>（中継用）消滅時調整用転換定期合計Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysyumtjtyusiyutnkntiksisd ztysyumtjtyusiyutnkntiksisd}</td><td>（中継用）消滅時調整用転換定期死差Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysyumtjtyusiyutnkntikrisd ztysyumtjtyusiyutnkntikrisd}</td><td>（中継用）消滅時調整用転換定期利差Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysyumtjtyusiyutnkntikhisd ztysyumtjtyusiyutnkntikhisd}</td><td>（中継用）消滅時調整用転換定期費差Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysyumtjtnkntikdtaisyous ztysyumtjtnkntikdtaisyous}</td><td>（中継用）消滅時転換定期Ｄ対象Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysyumtjtnkntikdyouv ztysyumtjtnkntikdyouv}</td><td>（中継用）消滅時転換定期Ｄ用Ｖ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysyumtjtnkntikdkikens ztysyumtjtnkntikdkikens}</td><td>（中継用）消滅時転換定期Ｄ危険Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhendougoukeid ztyhendougoukeid}</td><td>（中継用）変動合計Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhendousisad ztyhendousisad}</td><td>（中継用）変動死差Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhendouhisad ztyhendouhisad}</td><td>（中継用）変動費差Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhendoudtaisyous ztyhendoudtaisyous}</td><td>（中継用）変動Ｄ対象Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhendoudyouv ztyhendoudyouv}</td><td>（中継用）変動Ｄ用Ｖ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhendoudkikens ztyhendoudkikens}</td><td>（中継用）変動Ｄ危険Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyitibuitijibaraigoukeid ztyitibuitijibaraigoukeid}</td><td>（中継用）一部一時払合計Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyitibuitijibaraisisad ztyitibuitijibaraisisad}</td><td>（中継用）一部一時払死差Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyitibuitijibaraihisad ztyitibuitijibaraihisad}</td><td>（中継用）一部一時払費差Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyitibuitijibaraidtaisyous ztyitibuitijibaraidtaisyous}</td><td>（中継用）一部一時払Ｄ対象Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyitibuitijibaraidyouv ztyitibuitijibaraidyouv}</td><td>（中継用）一部一時払Ｄ用Ｖ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyitibuitijibaraidkikens ztyitibuitijibaraidkikens}</td><td>（中継用）一部一時払Ｄ危険Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyitibitjbrhisadtisyus ztyitibitjbrhisadtisyus}</td><td>（中継用）一部一時払費差Ｄ対象Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyszoukouryokukaisiymd ztyszoukouryokukaisiymd}</td><td>（中継用）Ｓ増効力開始年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyszouhokensyuruikigou ztyszouhokensyuruikigou}</td><td>（中継用）Ｓ増保険種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyszoukikan ztyszoukikan}</td><td>（中継用）Ｓ増期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyszouhihokensyaage ztyszouhihokensyaage}</td><td>（中継用）Ｓ増被保険者年令</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzoukagoukeid ztyzoukagoukeid}</td><td>（中継用）増加合計Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyzoukasisad ztyzoukasisad}</td><td>（中継用）増加死差Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyzoukarisad ztyzoukarisad}</td><td>（中継用）増加利差Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyzoukaramudad ztyzoukaramudad}</td><td>（中継用）増加ラムダＤ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyzoukahisad ztyzoukahisad}</td><td>（中継用）増加費差Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyzoukadtaisyous ztyzoukadtaisyous}</td><td>（中継用）増加Ｄ対象Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyzoukadyouv ztyzoukadyouv}</td><td>（中継用）増加Ｄ用Ｖ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyzoukadkikens ztyzoukadkikens}</td><td>（中継用）増加Ｄ危険Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykakuteikakusasyuruikgu ztykakuteikakusasyuruikgu}</td><td>（中継用）カク定カクサ種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykakuteikakusad ztykakuteikakusad}</td><td>（中継用）カク定カクサＤ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykakuteikakusas ztykakuteikakusas}</td><td>（中継用）カク定カクサＳ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykakuteikakusamanryoujid ztykakuteikakusamanryoujid}</td><td>（中継用）カク定カクサ満了時Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtynaizoumarusasyuruikigou ztynaizoumarusasyuruikigou}</td><td>（中継用）内蔵マルサ種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynaizoumarusad ztynaizoumarusad}</td><td>（中継用）内蔵マルサＤ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtynaizoumarusas ztynaizoumarusas}</td><td>（中継用）内蔵マルサＳ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtynaizoukakusasyuruikigou ztynaizoukakusasyuruikigou}</td><td>（中継用）内蔵カクサ種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynaizoukakusad ztynaizoukakusad}</td><td>（中継用）内蔵カクサＤ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtynaizoukakusas ztynaizoukakusas}</td><td>（中継用）内蔵カクサＳ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytenkanpbubund ztytenkanpbubund}</td><td>（中継用）転換Ｐ部分Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytenkanpbubunsisad ztytenkanpbubunsisad}</td><td>（中継用）転換Ｐ部分死差Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytenkanpbubunrisad ztytenkanpbubunrisad}</td><td>（中継用）転換Ｐ部分利差Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytenkanpbubunhisad ztytenkanpbubunhisad}</td><td>（中継用）転換Ｐ部分費差Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytenkanpbubundtaisyous ztytenkanpbubundtaisyous}</td><td>（中継用）転換Ｐ部分Ｄ対象Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytenkanpbubundyouv ztytenkanpbubundyouv}</td><td>（中継用）転換Ｐ部分Ｄ用Ｖ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytenkanpbubundkikens ztytenkanpbubundkikens}</td><td>（中継用）転換Ｐ部分Ｄ危険Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtynaizougatateikimud ztynaizougatateikimud}</td><td>（中継用）内蔵型定期ミューＤ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtynaizougatanenkansanp ztynaizougatanenkansanp}</td><td>（中継用）内蔵型年換算Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyvhktgbbntnkntikmud ztyvhktgbbntnkntikmud}</td><td>（中継用）Ｖ引継部分転換定期ミューＤ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhikitugitenkanphireimud ztyhikitugitenkanphireimud}</td><td>（中継用）引継転換Ｐ比例ミューＤ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyitibitjbrgyuskhyjs ztyitibitjbrgyuskhyjs}</td><td>（中継用）一部一時払業績表示Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykariwariate4nenmae ztykariwariate4nenmae}</td><td>（中継用）仮割当（４年前）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykariwariate3nenmae ztykariwariate3nenmae}</td><td>（中継用）仮割当（３年前）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykariwariate2nenmae ztykariwariate2nenmae}</td><td>（中継用）仮割当（２年前）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykariwariate1nenmae ztykariwariate1nenmae}</td><td>（中継用）仮割当（１年前）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygukisisntnkntikmud ztygukisisntnkntikmud}</td><td>（中継用）合計精算転換定期ミューＤ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygoukeiseisanteikis ztygoukeiseisanteikis}</td><td>（中継用）合計精算定期Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygukisisntnknnenknsnp ztygukisisntnknnenknsnp}</td><td>（中継用）合計精算転換年換算Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytnkntikhtnknkykymd ztytnkntikhtnknkykymd}</td><td>（中継用）転換定期被転換契約年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytenkangophireimuritu ztytenkangophireimuritu}</td><td>（中継用）転換後Ｐ比例ミュー率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtygoukeitenkannenkansanp ztygoukeitenkannenkansanp}</td><td>（中継用）合計転換年換算Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygoukeitenkanteikimud ztygoukeitenkanteikimud}</td><td>（中継用）合計転換定期ミューＤ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytyoukikeizokutokubetud ztytyoukikeizokutokubetud}</td><td>（中継用）長期継続特別Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytyouseimaed ztytyouseimaed}</td><td>（中継用）調整前Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytuutokuhituusand ztytuutokuhituusand}</td><td>（中継用）通特非通算Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhknsyuruikigousedaikbn ztyhknsyuruikigousedaikbn}</td><td>（中継用）保険種類記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytenkanteikikigousedaikbn ztytenkanteikikigousedaikbn}</td><td>（中継用）転換定期記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyszoukigousedaikbn ztyszoukigousedaikbn}</td><td>（中継用）Ｓ増記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymankihyouji ztymankihyouji}</td><td>（中継用）満期表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeiyakuoutoubikbn ztykeiyakuoutoubikbn}</td><td>（中継用）契約応当日区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin2 ztysuuriyouyobin2}</td><td>（中継用）数理用予備項目Ｎ２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakuhukasuu ztytokuyakuhukasuu}</td><td>（中継用）特約付加数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
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
 *  <tr><td>{@link #getZtytenkanteikikigouyobix1 ztytenkanteikikigouyobix1}</td><td>（中継用）転換定期記号予備＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytenkanteikikigouyobix2 ztytenkanteikikigouyobix2}</td><td>（中継用）転換定期記号予備＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytenkanteikikigouyobix3 ztytenkanteikikigouyobix3}</td><td>（中継用）転換定期記号予備＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytenkanteikikigouyobix4 ztytenkanteikikigouyobix4}</td><td>（中継用）転換定期記号予備＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytenkanteikikigouyobix5 ztytenkanteikikigouyobix5}</td><td>（中継用）転換定期記号予備＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykakuteikakusakgusdkbn ztykakuteikakusakgusdkbn}</td><td>（中継用）カク定カクサ記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykakuteikakusakguybx1 ztykakuteikakusakguybx1}</td><td>（中継用）カク定カクサ記号予備＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykakuteikakusakguybx2 ztykakuteikakusakguybx2}</td><td>（中継用）カク定カクサ記号予備＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykakuteikakusakguybx3 ztykakuteikakusakguybx3}</td><td>（中継用）カク定カクサ記号予備＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykakuteikakusakguybx4 ztykakuteikakusakguybx4}</td><td>（中継用）カク定カクサ記号予備＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykakuteikakusakguybx5 ztykakuteikakusakguybx5}</td><td>（中継用）カク定カクサ記号予備＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynaizoumarusakgusdkbn ztynaizoumarusakgusdkbn}</td><td>（中継用）内蔵マルサ記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynaizoumarusakigouyobix1 ztynaizoumarusakigouyobix1}</td><td>（中継用）内蔵マルサ記号予備＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynaizoumarusakigouyobix2 ztynaizoumarusakigouyobix2}</td><td>（中継用）内蔵マルサ記号予備＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynaizoumarusakigouyobix3 ztynaizoumarusakigouyobix3}</td><td>（中継用）内蔵マルサ記号予備＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynaizoumarusakigouyobix4 ztynaizoumarusakigouyobix4}</td><td>（中継用）内蔵マルサ記号予備＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynaizoumarusakigouyobix5 ztynaizoumarusakigouyobix5}</td><td>（中継用）内蔵マルサ記号予備＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynaizoukakusakgusdkbn ztynaizoukakusakgusdkbn}</td><td>（中継用）内蔵カクサ記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynaizoukakusakigouyobix1 ztynaizoukakusakigouyobix1}</td><td>（中継用）内蔵カクサ記号予備＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynaizoukakusakigouyobix2 ztynaizoukakusakigouyobix2}</td><td>（中継用）内蔵カクサ記号予備＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynaizoukakusakigouyobix3 ztynaizoukakusakigouyobix3}</td><td>（中継用）内蔵カクサ記号予備＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynaizoukakusakigouyobix4 ztynaizoukakusakigouyobix4}</td><td>（中継用）内蔵カクサ記号予備＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynaizoukakusakigouyobix5 ztynaizoukakusakigouyobix5}</td><td>（中継用）内蔵カクサ記号予備＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv92 ztyyobiv92}</td><td>（中継用）予備項目Ｖ９２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyraysystemhyj ztyraysystemhyj}</td><td>（中継用）ＲＡＹシステム表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygaikakbn ztygaikakbn}</td><td>（中継用）外貨区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykawaserate ztykawaserate}</td><td>（中継用）為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtykawaseratetekiyouymd ztykawaseratetekiyouymd}</td><td>（中継用）為替レート適用年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyenkdtsbujsitihsyukngk ztyenkdtsbujsitihsyukngk}</td><td>（中継用）円貨建死亡時最低保証金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin10 ztysuuriyouyobin10}</td><td>（中継用）数理用予備項目Ｎ１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv10x2 ztyyobiv10x2}</td><td>（中継用）予備項目Ｖ１０＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobin11 ztyyobin11}</td><td>（中継用）予備項目Ｎ１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x2 ztyyobin11x2}</td><td>（中継用）予備項目Ｎ１１＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobiv17 ztyyobiv17}</td><td>（中継用）予備項目Ｖ１７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisadrate ztysisadrate}</td><td>（中継用）死差Ｄレート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyrisadrate ztyrisadrate}</td><td>（中継用）利差Ｄレート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyhisadrate ztyhisadrate}</td><td>（中継用）費差Ｄレート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtydyouvrate ztydyouvrate}</td><td>（中継用）Ｄ用Ｖレート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtykikensrate ztykikensrate}</td><td>（中継用）危険Ｓレート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtygoukeidrate ztygoukeidrate}</td><td>（中継用）合計Ｄレート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv180 ztytokuyakukoumokuv180}</td><td>（中継用）特約項目Ｖ１８０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv180x2 ztytokuyakukoumokuv180x2}</td><td>（中継用）特約項目Ｖ１８０＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv180x3 ztytokuyakukoumokuv180x3}</td><td>（中継用）特約項目Ｖ１８０＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv180x4 ztytokuyakukoumokuv180x4}</td><td>（中継用）特約項目Ｖ１８０＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv180x5 ztytokuyakukoumokuv180x5}</td><td>（中継用）特約項目Ｖ１８０＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv180x6 ztytokuyakukoumokuv180x6}</td><td>（中継用）特約項目Ｖ１８０＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv180x7 ztytokuyakukoumokuv180x7}</td><td>（中継用）特約項目Ｖ１８０＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv180x8 ztytokuyakukoumokuv180x8}</td><td>（中継用）特約項目Ｖ１８０＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv180x9 ztytokuyakukoumokuv180x9}</td><td>（中継用）特約項目Ｖ１８０＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv180x10 ztytokuyakukoumokuv180x10}</td><td>（中継用）特約項目Ｖ１８０＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv180x11 ztytokuyakukoumokuv180x11}</td><td>（中継用）特約項目Ｖ１８０＿１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv180x12 ztytokuyakukoumokuv180x12}</td><td>（中継用）特約項目Ｖ１８０＿１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv180x13 ztytokuyakukoumokuv180x13}</td><td>（中継用）特約項目Ｖ１８０＿１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv180x14 ztytokuyakukoumokuv180x14}</td><td>（中継用）特約項目Ｖ１８０＿１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv180x15 ztytokuyakukoumokuv180x15}</td><td>（中継用）特約項目Ｖ１８０＿１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv180x16 ztytokuyakukoumokuv180x16}</td><td>（中継用）特約項目Ｖ１８０＿１６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv180x17 ztytokuyakukoumokuv180x17}</td><td>（中継用）特約項目Ｖ１８０＿１７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv180x18 ztytokuyakukoumokuv180x18}</td><td>（中継用）特約項目Ｖ１８０＿１８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv180x19 ztytokuyakukoumokuv180x19}</td><td>（中継用）特約項目Ｖ１８０＿１９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv180x20 ztytokuyakukoumokuv180x20}</td><td>（中継用）特約項目Ｖ１８０＿２０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv180x21 ztytokuyakukoumokuv180x21}</td><td>（中継用）特約項目Ｖ１８０＿２１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv180x22 ztytokuyakukoumokuv180x22}</td><td>（中継用）特約項目Ｖ１８０＿２２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv180x23 ztytokuyakukoumokuv180x23}</td><td>（中継用）特約項目Ｖ１８０＿２３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv180x24 ztytokuyakukoumokuv180x24}</td><td>（中継用）特約項目Ｖ１８０＿２４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv180x25 ztytokuyakukoumokuv180x25}</td><td>（中継用）特約項目Ｖ１８０＿２５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv180x26 ztytokuyakukoumokuv180x26}</td><td>（中継用）特約項目Ｖ１８０＿２６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv180x27 ztytokuyakukoumokuv180x27}</td><td>（中継用）特約項目Ｖ１８０＿２７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv180x28 ztytokuyakukoumokuv180x28}</td><td>（中継用）特約項目Ｖ１８０＿２８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv180x29 ztytokuyakukoumokuv180x29}</td><td>（中継用）特約項目Ｖ１８０＿２９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv180x30 ztytokuyakukoumokuv180x30}</td><td>（中継用）特約項目Ｖ１８０＿３０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv180x31 ztytokuyakukoumokuv180x31}</td><td>（中継用）特約項目Ｖ１８０＿３１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv180x32 ztytokuyakukoumokuv180x32}</td><td>（中継用）特約項目Ｖ１８０＿３２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv180x33 ztytokuyakukoumokuv180x33}</td><td>（中継用）特約項目Ｖ１８０＿３３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv180x34 ztytokuyakukoumokuv180x34}</td><td>（中継用）特約項目Ｖ１８０＿３４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv180x35 ztytokuyakukoumokuv180x35}</td><td>（中継用）特約項目Ｖ１８０＿３５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv180x36 ztytokuyakukoumokuv180x36}</td><td>（中継用）特約項目Ｖ１８０＿３６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv180x37 ztytokuyakukoumokuv180x37}</td><td>（中継用）特約項目Ｖ１８０＿３７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv180x38 ztytokuyakukoumokuv180x38}</td><td>（中継用）特約項目Ｖ１８０＿３８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv180x39 ztytokuyakukoumokuv180x39}</td><td>（中継用）特約項目Ｖ１８０＿３９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv180x40 ztytokuyakukoumokuv180x40}</td><td>（中継用）特約項目Ｖ１８０＿４０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv180x41 ztytokuyakukoumokuv180x41}</td><td>（中継用）特約項目Ｖ１８０＿４１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv180x42 ztytokuyakukoumokuv180x42}</td><td>（中継用）特約項目Ｖ１８０＿４２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv180x43 ztytokuyakukoumokuv180x43}</td><td>（中継用）特約項目Ｖ１８０＿４３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv180x44 ztytokuyakukoumokuv180x44}</td><td>（中継用）特約項目Ｖ１８０＿４４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv180x45 ztytokuyakukoumokuv180x45}</td><td>（中継用）特約項目Ｖ１８０＿４５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv180x46 ztytokuyakukoumokuv180x46}</td><td>（中継用）特約項目Ｖ１８０＿４６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv180x47 ztytokuyakukoumokuv180x47}</td><td>（中継用）特約項目Ｖ１８０＿４７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv180x48 ztytokuyakukoumokuv180x48}</td><td>（中継用）特約項目Ｖ１８０＿４８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv180x49 ztytokuyakukoumokuv180x49}</td><td>（中継用）特約項目Ｖ１８０＿４９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv180x50 ztytokuyakukoumokuv180x50}</td><td>（中継用）特約項目Ｖ１８０＿５０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_TjHitsyyugkNplusZeroTy
 * @see     PKZT_TjHitsyyugkNplusZeroTy
 * @see     QZT_TjHitsyyugkNplusZeroTy
 * @see     GenQZT_TjHitsyyugkNplusZeroTy
 */
@MappedSuperclass
@Table(name=GenZT_TjHitsyyugkNplusZeroTy.TABLE_NAME)
@IdClass(value=PKZT_TjHitsyyugkNplusZeroTy.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_TjHitsyyugkNplusZeroTy extends AbstractExDBEntity<ZT_TjHitsyyugkNplusZeroTy, PKZT_TjHitsyyugkNplusZeroTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_TjHitsyyugkNplusZeroTy";
    public static final String ZTYSEQUENCENO            = "ztysequenceno";
    public static final String ZTYYUUKOURECORDLENGTH    = "ztyyuukourecordlength";
    public static final String ZTYRDWAREA               = "ztyrdwarea";
    public static final String ZTYERRKBNV2              = "ztyerrkbnv2";
    public static final String ZTYRATEKBN               = "ztyratekbn";
    public static final String ZTYKEISANDNENDO          = "ztykeisandnendo";
    public static final String ZTYKEIJYOUYM             = "ztykeijyouym";
    public static final String ZTYSYOUINKBN             = "ztysyouinkbn";
    public static final String ZTYKBNKEIRIYOUSEGMENTKBN = "ztykbnkeiriyousegmentkbn";
    public static final String ZTYKBNKEIRIYOURGNBNSKKBN = "ztykbnkeiriyourgnbnskkbn";
    public static final String ZTYSYUKEIYAKUSYURUICDV2  = "ztysyukeiyakusyuruicdv2";
    public static final String ZTYDAIHYOUYOTEIRIRITU    = "ztydaihyouyoteiriritu";
    public static final String ZTYHARAIKATAKBN          = "ztyharaikatakbn";
    public static final String ZTYNENKINKAISIGOHYOUJI   = "ztynenkinkaisigohyouji";
    public static final String ZTYKYKJYOUTAI            = "ztykykjyoutai";
    public static final String ZTYNAIZOUTEIKIYOTEIRIRITU = "ztynaizouteikiyoteiriritu";
    public static final String ZTYGOUKEIGYOUSEKIHYOUJIS = "ztygoukeigyousekihyoujis";
    public static final String ZTYSYKYKGYUSEKIHYJS      = "ztysykykgyusekihyjs";
    public static final String ZTYTNKNITJBRSYKYKGYUSKHYJS = "ztytnknitjbrsykykgyuskhyjs";
    public static final String ZTYDATAKANRINO           = "ztydatakanrino";
    public static final String ZTYHKNSYUKIGOU           = "ztyhknsyukigou";
    public static final String ZTYANNAIFUYOURIYUUKBN    = "ztyannaifuyouriyuukbn";
    public static final String ZTYTKBTHSYUMNRYUHYOUJI   = "ztytkbthsyumnryuhyouji";
    public static final String ZTYKYKYMD                = "ztykykymd";
    public static final String ZTYHHKNSEIKBN            = "ztyhhknseikbn";
    public static final String ZTYHIHOKENSYAAGEV2       = "ztyhihokensyaagev2";
    public static final String ZTYHKNKKN                = "ztyhknkkn";
    public static final String ZTYPHRKKIKN              = "ztyphrkkikn";
    public static final String ZTYSAIMNKKYKHYJ          = "ztysaimnkkykhyj";
    public static final String ZTYHRKKAISUUKBN          = "ztyhrkkaisuukbn";
    public static final String ZTYANNAIKIGETU           = "ztyannaikigetu";
    public static final String ZTYAO3TYOU3SIBOUSDATEHYOUJI = "ztyao3tyou3sibousdatehyouji";
    public static final String ZTYKIHONS                = "ztykihons";
    public static final String ZTYHARAIZUMIYMD          = "ztyharaizumiymd";
    public static final String ZTYHARAIZUMIS            = "ztyharaizumis";
    public static final String ZTYENTYOUS               = "ztyentyous";
    public static final String ZTYSEIZONS               = "ztyseizons";
    public static final String ZTYPMENS                 = "ztypmens";
    public static final String ZTYHENDOUS               = "ztyhendous";
    public static final String ZTYITIBUITIJIBARAIS      = "ztyitibuitijibarais";
    public static final String ZTYTENKANTEIKISYURUIKIGOU = "ztytenkanteikisyuruikigou";
    public static final String ZTYTENKANTEIKIKIKAN      = "ztytenkanteikikikan";
    public static final String ZTYTNKNTEIKINKSHRKKN     = "ztytnknteikinkshrkkn";
    public static final String ZTYGOUKEITENKANS         = "ztygoukeitenkans";
    public static final String ZTYGOUKEITENKANTEIKIS    = "ztygoukeitenkanteikis";
    public static final String ZTYGOUKEIPBUBUNTENKANS   = "ztygoukeipbubuntenkans";
    public static final String ZTYTENKANKAISUU          = "ztytenkankaisuu";
    public static final String ZTYDGOUKEI               = "ztydgoukei";
    public static final String ZTYSRANKBETUHISAD        = "ztysrankbetuhisad";
    public static final String ZTYSYUMTJSRANKBETUHISAD  = "ztysyumtjsrankbetuhisad";
    public static final String ZTYBAIRITUBETUHISAD      = "ztybairitubetuhisad";
    public static final String ZTYSYUMTJTIKBAIRTBETUHISAD = "ztysyumtjtikbairtbetuhisad";
    public static final String ZTYSYUKEIYAKUKIHONGOUKEID = "ztysyukeiyakukihongoukeid";
    public static final String ZTYSYUKEIYAKUKIHONSISAD  = "ztysyukeiyakukihonsisad";
    public static final String ZTYSYUKEIYAKUKIHONRISAD  = "ztysyukeiyakukihonrisad";
    public static final String ZTYSYUKEIYAKUKIHONRAMUDAD = "ztysyukeiyakukihonramudad";
    public static final String ZTYSYUKEIYAKUKIHONHISAD  = "ztysyukeiyakukihonhisad";
    public static final String ZTYSYUKEIYAKUKIHONDTAISYOUS = "ztysyukeiyakukihondtaisyous";
    public static final String ZTYSYUKEIYAKUKIHONDYOUV  = "ztysyukeiyakukihondyouv";
    public static final String ZTYSYUKEIYAKUKIHONDKIKENS = "ztysyukeiyakukihondkikens";
    public static final String ZTYSYKYKKHNHISADTISYUS   = "ztysykykkhnhisadtisyus";
    public static final String ZTYSYUKEIYAKUTEIKIGOUKEID = "ztysyukeiyakuteikigoukeid";
    public static final String ZTYSYUKEIYAKUTEIKISISAD  = "ztysyukeiyakuteikisisad";
    public static final String ZTYSYUKEIYAKUTEIKIRISAD  = "ztysyukeiyakuteikirisad";
    public static final String ZTYSYUKEIYAKUTEIKIRAMUDAD = "ztysyukeiyakuteikiramudad";
    public static final String ZTYSYUKEIYAKUTEIKIHISAD  = "ztysyukeiyakuteikihisad";
    public static final String ZTYSYUKEIYAKUTEIKIDTAISYOUS = "ztysyukeiyakuteikidtaisyous";
    public static final String ZTYSYUKEIYAKUTEIKIDYOUV  = "ztysyukeiyakuteikidyouv";
    public static final String ZTYSYUKEIYAKUTEIKIDKIKENS = "ztysyukeiyakuteikidkikens";
    public static final String ZTYSYKYKTIKHISADTISYUS   = "ztysykyktikhisadtisyus";
    public static final String ZTYTENKANKIHONGOUKEID    = "ztytenkankihongoukeid";
    public static final String ZTYTENKANKIHONSISAD      = "ztytenkankihonsisad";
    public static final String ZTYTENKANKIHONRISAD      = "ztytenkankihonrisad";
    public static final String ZTYTENKANKIHONRAMUDAD    = "ztytenkankihonramudad";
    public static final String ZTYTENKANKIHONHISAD      = "ztytenkankihonhisad";
    public static final String ZTYTENKANKIHONDTAISYOUS  = "ztytenkankihondtaisyous";
    public static final String ZTYTENKANKIHONDYOUV      = "ztytenkankihondyouv";
    public static final String ZTYTENKANKIHONDKIKENS    = "ztytenkankihondkikens";
    public static final String ZTYTENKANKIHONHISADTAISYOUS = "ztytenkankihonhisadtaisyous";
    public static final String ZTYTENKANTEIKIGOUKEID    = "ztytenkanteikigoukeid";
    public static final String ZTYTENKANTEIKISISAD      = "ztytenkanteikisisad";
    public static final String ZTYTENKANTEIKIRISAD      = "ztytenkanteikirisad";
    public static final String ZTYTENKANTEIKIRAMUDAD    = "ztytenkanteikiramudad";
    public static final String ZTYTENKANTEIKIHISAD      = "ztytenkanteikihisad";
    public static final String ZTYTENKANTEIKIDTAISYOUS  = "ztytenkanteikidtaisyous";
    public static final String ZTYTENKANTEIKIDYOUV      = "ztytenkanteikidyouv";
    public static final String ZTYTENKANTEIKIDKIKENS    = "ztytenkanteikidkikens";
    public static final String ZTYTENKANTEIKIHISADTAISYOUS = "ztytenkanteikihisadtaisyous";
    public static final String ZTYSYUMTJTYUSIYUTNKNTIKGUKD = "ztysyumtjtyusiyutnkntikgukd";
    public static final String ZTYSYUMTJTYUSIYUTNKNTIKSISD = "ztysyumtjtyusiyutnkntiksisd";
    public static final String ZTYSYUMTJTYUSIYUTNKNTIKRISD = "ztysyumtjtyusiyutnkntikrisd";
    public static final String ZTYSYUMTJTYUSIYUTNKNTIKHISD = "ztysyumtjtyusiyutnkntikhisd";
    public static final String ZTYSYUMTJTNKNTIKDTAISYOUS = "ztysyumtjtnkntikdtaisyous";
    public static final String ZTYSYUMTJTNKNTIKDYOUV    = "ztysyumtjtnkntikdyouv";
    public static final String ZTYSYUMTJTNKNTIKDKIKENS  = "ztysyumtjtnkntikdkikens";
    public static final String ZTYHENDOUGOUKEID         = "ztyhendougoukeid";
    public static final String ZTYHENDOUSISAD           = "ztyhendousisad";
    public static final String ZTYHENDOUHISAD           = "ztyhendouhisad";
    public static final String ZTYHENDOUDTAISYOUS       = "ztyhendoudtaisyous";
    public static final String ZTYHENDOUDYOUV           = "ztyhendoudyouv";
    public static final String ZTYHENDOUDKIKENS         = "ztyhendoudkikens";
    public static final String ZTYITIBUITIJIBARAIGOUKEID = "ztyitibuitijibaraigoukeid";
    public static final String ZTYITIBUITIJIBARAISISAD  = "ztyitibuitijibaraisisad";
    public static final String ZTYITIBUITIJIBARAIHISAD  = "ztyitibuitijibaraihisad";
    public static final String ZTYITIBUITIJIBARAIDTAISYOUS = "ztyitibuitijibaraidtaisyous";
    public static final String ZTYITIBUITIJIBARAIDYOUV  = "ztyitibuitijibaraidyouv";
    public static final String ZTYITIBUITIJIBARAIDKIKENS = "ztyitibuitijibaraidkikens";
    public static final String ZTYITIBITJBRHISADTISYUS  = "ztyitibitjbrhisadtisyus";
    public static final String ZTYSZOUKOURYOKUKAISIYMD  = "ztyszoukouryokukaisiymd";
    public static final String ZTYSZOUHOKENSYURUIKIGOU  = "ztyszouhokensyuruikigou";
    public static final String ZTYSZOUKIKAN             = "ztyszoukikan";
    public static final String ZTYSZOUHIHOKENSYAAGE     = "ztyszouhihokensyaage";
    public static final String ZTYZOUKAGOUKEID          = "ztyzoukagoukeid";
    public static final String ZTYZOUKASISAD            = "ztyzoukasisad";
    public static final String ZTYZOUKARISAD            = "ztyzoukarisad";
    public static final String ZTYZOUKARAMUDAD          = "ztyzoukaramudad";
    public static final String ZTYZOUKAHISAD            = "ztyzoukahisad";
    public static final String ZTYZOUKADTAISYOUS        = "ztyzoukadtaisyous";
    public static final String ZTYZOUKADYOUV            = "ztyzoukadyouv";
    public static final String ZTYZOUKADKIKENS          = "ztyzoukadkikens";
    public static final String ZTYKAKUTEIKAKUSASYURUIKGU = "ztykakuteikakusasyuruikgu";
    public static final String ZTYKAKUTEIKAKUSAD        = "ztykakuteikakusad";
    public static final String ZTYKAKUTEIKAKUSAS        = "ztykakuteikakusas";
    public static final String ZTYKAKUTEIKAKUSAMANRYOUJID = "ztykakuteikakusamanryoujid";
    public static final String ZTYNAIZOUMARUSASYURUIKIGOU = "ztynaizoumarusasyuruikigou";
    public static final String ZTYNAIZOUMARUSAD         = "ztynaizoumarusad";
    public static final String ZTYNAIZOUMARUSAS         = "ztynaizoumarusas";
    public static final String ZTYNAIZOUKAKUSASYURUIKIGOU = "ztynaizoukakusasyuruikigou";
    public static final String ZTYNAIZOUKAKUSAD         = "ztynaizoukakusad";
    public static final String ZTYNAIZOUKAKUSAS         = "ztynaizoukakusas";
    public static final String ZTYTENKANPBUBUND         = "ztytenkanpbubund";
    public static final String ZTYTENKANPBUBUNSISAD     = "ztytenkanpbubunsisad";
    public static final String ZTYTENKANPBUBUNRISAD     = "ztytenkanpbubunrisad";
    public static final String ZTYTENKANPBUBUNHISAD     = "ztytenkanpbubunhisad";
    public static final String ZTYTENKANPBUBUNDTAISYOUS = "ztytenkanpbubundtaisyous";
    public static final String ZTYTENKANPBUBUNDYOUV     = "ztytenkanpbubundyouv";
    public static final String ZTYTENKANPBUBUNDKIKENS   = "ztytenkanpbubundkikens";
    public static final String ZTYNAIZOUGATATEIKIMUD    = "ztynaizougatateikimud";
    public static final String ZTYNAIZOUGATANENKANSANP  = "ztynaizougatanenkansanp";
    public static final String ZTYVHKTGBBNTNKNTIKMUD    = "ztyvhktgbbntnkntikmud";
    public static final String ZTYHIKITUGITENKANPHIREIMUD = "ztyhikitugitenkanphireimud";
    public static final String ZTYITIBITJBRGYUSKHYJS    = "ztyitibitjbrgyuskhyjs";
    public static final String ZTYKARIWARIATE4NENMAE    = "ztykariwariate4nenmae";
    public static final String ZTYKARIWARIATE3NENMAE    = "ztykariwariate3nenmae";
    public static final String ZTYKARIWARIATE2NENMAE    = "ztykariwariate2nenmae";
    public static final String ZTYKARIWARIATE1NENMAE    = "ztykariwariate1nenmae";
    public static final String ZTYGUKISISNTNKNTIKMUD    = "ztygukisisntnkntikmud";
    public static final String ZTYGOUKEISEISANTEIKIS    = "ztygoukeiseisanteikis";
    public static final String ZTYGUKISISNTNKNNENKNSNP  = "ztygukisisntnknnenknsnp";
    public static final String ZTYTNKNTIKHTNKNKYKYMD    = "ztytnkntikhtnknkykymd";
    public static final String ZTYTENKANGOPHIREIMURITU  = "ztytenkangophireimuritu";
    public static final String ZTYGOUKEITENKANNENKANSANP = "ztygoukeitenkannenkansanp";
    public static final String ZTYGOUKEITENKANTEIKIMUD  = "ztygoukeitenkanteikimud";
    public static final String ZTYTYOUKIKEIZOKUTOKUBETUD = "ztytyoukikeizokutokubetud";
    public static final String ZTYTYOUSEIMAED           = "ztytyouseimaed";
    public static final String ZTYTUUTOKUHITUUSAND      = "ztytuutokuhituusand";
    public static final String ZTYHKNSYURUIKIGOUSEDAIKBN = "ztyhknsyuruikigousedaikbn";
    public static final String ZTYTENKANTEIKIKIGOUSEDAIKBN = "ztytenkanteikikigousedaikbn";
    public static final String ZTYSZOUKIGOUSEDAIKBN     = "ztyszoukigousedaikbn";
    public static final String ZTYMANKIHYOUJI           = "ztymankihyouji";
    public static final String ZTYKEIYAKUOUTOUBIKBN     = "ztykeiyakuoutoubikbn";
    public static final String ZTYSUURIYOUYOBIN2        = "ztysuuriyouyobin2";
    public static final String ZTYTOKUYAKUHUKASUU       = "ztytokuyakuhukasuu";
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
    public static final String ZTYTENKANTEIKIKIGOUYOBIX1 = "ztytenkanteikikigouyobix1";
    public static final String ZTYTENKANTEIKIKIGOUYOBIX2 = "ztytenkanteikikigouyobix2";
    public static final String ZTYTENKANTEIKIKIGOUYOBIX3 = "ztytenkanteikikigouyobix3";
    public static final String ZTYTENKANTEIKIKIGOUYOBIX4 = "ztytenkanteikikigouyobix4";
    public static final String ZTYTENKANTEIKIKIGOUYOBIX5 = "ztytenkanteikikigouyobix5";
    public static final String ZTYKAKUTEIKAKUSAKGUSDKBN = "ztykakuteikakusakgusdkbn";
    public static final String ZTYKAKUTEIKAKUSAKGUYBX1  = "ztykakuteikakusakguybx1";
    public static final String ZTYKAKUTEIKAKUSAKGUYBX2  = "ztykakuteikakusakguybx2";
    public static final String ZTYKAKUTEIKAKUSAKGUYBX3  = "ztykakuteikakusakguybx3";
    public static final String ZTYKAKUTEIKAKUSAKGUYBX4  = "ztykakuteikakusakguybx4";
    public static final String ZTYKAKUTEIKAKUSAKGUYBX5  = "ztykakuteikakusakguybx5";
    public static final String ZTYNAIZOUMARUSAKGUSDKBN  = "ztynaizoumarusakgusdkbn";
    public static final String ZTYNAIZOUMARUSAKIGOUYOBIX1 = "ztynaizoumarusakigouyobix1";
    public static final String ZTYNAIZOUMARUSAKIGOUYOBIX2 = "ztynaizoumarusakigouyobix2";
    public static final String ZTYNAIZOUMARUSAKIGOUYOBIX3 = "ztynaizoumarusakigouyobix3";
    public static final String ZTYNAIZOUMARUSAKIGOUYOBIX4 = "ztynaizoumarusakigouyobix4";
    public static final String ZTYNAIZOUMARUSAKIGOUYOBIX5 = "ztynaizoumarusakigouyobix5";
    public static final String ZTYNAIZOUKAKUSAKGUSDKBN  = "ztynaizoukakusakgusdkbn";
    public static final String ZTYNAIZOUKAKUSAKIGOUYOBIX1 = "ztynaizoukakusakigouyobix1";
    public static final String ZTYNAIZOUKAKUSAKIGOUYOBIX2 = "ztynaizoukakusakigouyobix2";
    public static final String ZTYNAIZOUKAKUSAKIGOUYOBIX3 = "ztynaizoukakusakigouyobix3";
    public static final String ZTYNAIZOUKAKUSAKIGOUYOBIX4 = "ztynaizoukakusakigouyobix4";
    public static final String ZTYNAIZOUKAKUSAKIGOUYOBIX5 = "ztynaizoukakusakigouyobix5";
    public static final String ZTYYOBIV92               = "ztyyobiv92";
    public static final String ZTYRAYSYSTEMHYJ          = "ztyraysystemhyj";
    public static final String ZTYGAIKAKBN              = "ztygaikakbn";
    public static final String ZTYKAWASERATE            = "ztykawaserate";
    public static final String ZTYKAWASERATETEKIYOUYMD  = "ztykawaseratetekiyouymd";
    public static final String ZTYENKDTSBUJSITIHSYUKNGK = "ztyenkdtsbujsitihsyukngk";
    public static final String ZTYSUURIYOUYOBIN10       = "ztysuuriyouyobin10";
    public static final String ZTYYOBIV10X2             = "ztyyobiv10x2";
    public static final String ZTYYOBIN11               = "ztyyobin11";
    public static final String ZTYYOBIN11X2             = "ztyyobin11x2";
    public static final String ZTYYOBIV17               = "ztyyobiv17";
    public static final String ZTYSISADRATE             = "ztysisadrate";
    public static final String ZTYRISADRATE             = "ztyrisadrate";
    public static final String ZTYHISADRATE             = "ztyhisadrate";
    public static final String ZTYDYOUVRATE             = "ztydyouvrate";
    public static final String ZTYKIKENSRATE            = "ztykikensrate";
    public static final String ZTYGOUKEIDRATE           = "ztygoukeidrate";
    public static final String ZTYTOKUYAKUKOUMOKUV180   = "ztytokuyakukoumokuv180";
    public static final String ZTYTOKUYAKUKOUMOKUV180X2 = "ztytokuyakukoumokuv180x2";
    public static final String ZTYTOKUYAKUKOUMOKUV180X3 = "ztytokuyakukoumokuv180x3";
    public static final String ZTYTOKUYAKUKOUMOKUV180X4 = "ztytokuyakukoumokuv180x4";
    public static final String ZTYTOKUYAKUKOUMOKUV180X5 = "ztytokuyakukoumokuv180x5";
    public static final String ZTYTOKUYAKUKOUMOKUV180X6 = "ztytokuyakukoumokuv180x6";
    public static final String ZTYTOKUYAKUKOUMOKUV180X7 = "ztytokuyakukoumokuv180x7";
    public static final String ZTYTOKUYAKUKOUMOKUV180X8 = "ztytokuyakukoumokuv180x8";
    public static final String ZTYTOKUYAKUKOUMOKUV180X9 = "ztytokuyakukoumokuv180x9";
    public static final String ZTYTOKUYAKUKOUMOKUV180X10 = "ztytokuyakukoumokuv180x10";
    public static final String ZTYTOKUYAKUKOUMOKUV180X11 = "ztytokuyakukoumokuv180x11";
    public static final String ZTYTOKUYAKUKOUMOKUV180X12 = "ztytokuyakukoumokuv180x12";
    public static final String ZTYTOKUYAKUKOUMOKUV180X13 = "ztytokuyakukoumokuv180x13";
    public static final String ZTYTOKUYAKUKOUMOKUV180X14 = "ztytokuyakukoumokuv180x14";
    public static final String ZTYTOKUYAKUKOUMOKUV180X15 = "ztytokuyakukoumokuv180x15";
    public static final String ZTYTOKUYAKUKOUMOKUV180X16 = "ztytokuyakukoumokuv180x16";
    public static final String ZTYTOKUYAKUKOUMOKUV180X17 = "ztytokuyakukoumokuv180x17";
    public static final String ZTYTOKUYAKUKOUMOKUV180X18 = "ztytokuyakukoumokuv180x18";
    public static final String ZTYTOKUYAKUKOUMOKUV180X19 = "ztytokuyakukoumokuv180x19";
    public static final String ZTYTOKUYAKUKOUMOKUV180X20 = "ztytokuyakukoumokuv180x20";
    public static final String ZTYTOKUYAKUKOUMOKUV180X21 = "ztytokuyakukoumokuv180x21";
    public static final String ZTYTOKUYAKUKOUMOKUV180X22 = "ztytokuyakukoumokuv180x22";
    public static final String ZTYTOKUYAKUKOUMOKUV180X23 = "ztytokuyakukoumokuv180x23";
    public static final String ZTYTOKUYAKUKOUMOKUV180X24 = "ztytokuyakukoumokuv180x24";
    public static final String ZTYTOKUYAKUKOUMOKUV180X25 = "ztytokuyakukoumokuv180x25";
    public static final String ZTYTOKUYAKUKOUMOKUV180X26 = "ztytokuyakukoumokuv180x26";
    public static final String ZTYTOKUYAKUKOUMOKUV180X27 = "ztytokuyakukoumokuv180x27";
    public static final String ZTYTOKUYAKUKOUMOKUV180X28 = "ztytokuyakukoumokuv180x28";
    public static final String ZTYTOKUYAKUKOUMOKUV180X29 = "ztytokuyakukoumokuv180x29";
    public static final String ZTYTOKUYAKUKOUMOKUV180X30 = "ztytokuyakukoumokuv180x30";
    public static final String ZTYTOKUYAKUKOUMOKUV180X31 = "ztytokuyakukoumokuv180x31";
    public static final String ZTYTOKUYAKUKOUMOKUV180X32 = "ztytokuyakukoumokuv180x32";
    public static final String ZTYTOKUYAKUKOUMOKUV180X33 = "ztytokuyakukoumokuv180x33";
    public static final String ZTYTOKUYAKUKOUMOKUV180X34 = "ztytokuyakukoumokuv180x34";
    public static final String ZTYTOKUYAKUKOUMOKUV180X35 = "ztytokuyakukoumokuv180x35";
    public static final String ZTYTOKUYAKUKOUMOKUV180X36 = "ztytokuyakukoumokuv180x36";
    public static final String ZTYTOKUYAKUKOUMOKUV180X37 = "ztytokuyakukoumokuv180x37";
    public static final String ZTYTOKUYAKUKOUMOKUV180X38 = "ztytokuyakukoumokuv180x38";
    public static final String ZTYTOKUYAKUKOUMOKUV180X39 = "ztytokuyakukoumokuv180x39";
    public static final String ZTYTOKUYAKUKOUMOKUV180X40 = "ztytokuyakukoumokuv180x40";
    public static final String ZTYTOKUYAKUKOUMOKUV180X41 = "ztytokuyakukoumokuv180x41";
    public static final String ZTYTOKUYAKUKOUMOKUV180X42 = "ztytokuyakukoumokuv180x42";
    public static final String ZTYTOKUYAKUKOUMOKUV180X43 = "ztytokuyakukoumokuv180x43";
    public static final String ZTYTOKUYAKUKOUMOKUV180X44 = "ztytokuyakukoumokuv180x44";
    public static final String ZTYTOKUYAKUKOUMOKUV180X45 = "ztytokuyakukoumokuv180x45";
    public static final String ZTYTOKUYAKUKOUMOKUV180X46 = "ztytokuyakukoumokuv180x46";
    public static final String ZTYTOKUYAKUKOUMOKUV180X47 = "ztytokuyakukoumokuv180x47";
    public static final String ZTYTOKUYAKUKOUMOKUV180X48 = "ztytokuyakukoumokuv180x48";
    public static final String ZTYTOKUYAKUKOUMOKUV180X49 = "ztytokuyakukoumokuv180x49";
    public static final String ZTYTOKUYAKUKOUMOKUV180X50 = "ztytokuyakukoumokuv180x50";

    private final PKZT_TjHitsyyugkNplusZeroTy primaryKey;

    public GenZT_TjHitsyyugkNplusZeroTy() {
        primaryKey = new PKZT_TjHitsyyugkNplusZeroTy();
    }

    public GenZT_TjHitsyyugkNplusZeroTy(Integer pZtysequenceno) {
        primaryKey = new PKZT_TjHitsyyugkNplusZeroTy(pZtysequenceno);
    }

    @Transient
    @Override
    public PKZT_TjHitsyyugkNplusZeroTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_TjHitsyyugkNplusZeroTy> getMetaClass() {
        return QZT_TjHitsyyugkNplusZeroTy.class;
    }

    @Id
    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYSEQUENCENO)
    public Integer getZtysequenceno() {
        return getPrimaryKey().getZtysequenceno();
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtysequenceno(Integer pZtysequenceno) {
        getPrimaryKey().setZtysequenceno(pZtysequenceno);
    }

    private Integer ztyyuukourecordlength;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYYUUKOURECORDLENGTH)
    public Integer getZtyyuukourecordlength() {
        return ztyyuukourecordlength;
    }

    public void setZtyyuukourecordlength(Integer pZtyyuukourecordlength) {
        ztyyuukourecordlength = pZtyyuukourecordlength;
    }

    private String ztyrdwarea;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYRDWAREA)
    public String getZtyrdwarea() {
        return ztyrdwarea;
    }

    public void setZtyrdwarea(String pZtyrdwarea) {
        ztyrdwarea = pZtyrdwarea;
    }

    private String ztyerrkbnv2;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYERRKBNV2)
    public String getZtyerrkbnv2() {
        return ztyerrkbnv2;
    }

    public void setZtyerrkbnv2(String pZtyerrkbnv2) {
        ztyerrkbnv2 = pZtyerrkbnv2;
    }

    private String ztyratekbn;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYRATEKBN)
    public String getZtyratekbn() {
        return ztyratekbn;
    }

    public void setZtyratekbn(String pZtyratekbn) {
        ztyratekbn = pZtyratekbn;
    }

    private String ztykeisandnendo;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYKEISANDNENDO)
    public String getZtykeisandnendo() {
        return ztykeisandnendo;
    }

    public void setZtykeisandnendo(String pZtykeisandnendo) {
        ztykeisandnendo = pZtykeisandnendo;
    }

    private String ztykeijyouym;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYKEIJYOUYM)
    public String getZtykeijyouym() {
        return ztykeijyouym;
    }

    public void setZtykeijyouym(String pZtykeijyouym) {
        ztykeijyouym = pZtykeijyouym;
    }

    private String ztysyouinkbn;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYSYOUINKBN)
    public String getZtysyouinkbn() {
        return ztysyouinkbn;
    }

    public void setZtysyouinkbn(String pZtysyouinkbn) {
        ztysyouinkbn = pZtysyouinkbn;
    }

    private String ztykbnkeiriyousegmentkbn;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYKBNKEIRIYOUSEGMENTKBN)
    public String getZtykbnkeiriyousegmentkbn() {
        return ztykbnkeiriyousegmentkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtykbnkeiriyousegmentkbn(String pZtykbnkeiriyousegmentkbn) {
        ztykbnkeiriyousegmentkbn = pZtykbnkeiriyousegmentkbn;
    }

    private String ztykbnkeiriyourgnbnskkbn;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYKBNKEIRIYOURGNBNSKKBN)
    public String getZtykbnkeiriyourgnbnskkbn() {
        return ztykbnkeiriyourgnbnskkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtykbnkeiriyourgnbnskkbn(String pZtykbnkeiriyourgnbnskkbn) {
        ztykbnkeiriyourgnbnskkbn = pZtykbnkeiriyourgnbnskkbn;
    }

    private String ztysyukeiyakusyuruicdv2;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYSYUKEIYAKUSYURUICDV2)
    public String getZtysyukeiyakusyuruicdv2() {
        return ztysyukeiyakusyuruicdv2;
    }

    public void setZtysyukeiyakusyuruicdv2(String pZtysyukeiyakusyuruicdv2) {
        ztysyukeiyakusyuruicdv2 = pZtysyukeiyakusyuruicdv2;
    }

    private BizNumber ztydaihyouyoteiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYDAIHYOUYOTEIRIRITU)
    public BizNumber getZtydaihyouyoteiriritu() {
        return ztydaihyouyoteiriritu;
    }

    public void setZtydaihyouyoteiriritu(BizNumber pZtydaihyouyoteiriritu) {
        ztydaihyouyoteiriritu = pZtydaihyouyoteiriritu;
    }

    private String ztyharaikatakbn;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYHARAIKATAKBN)
    public String getZtyharaikatakbn() {
        return ztyharaikatakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyharaikatakbn(String pZtyharaikatakbn) {
        ztyharaikatakbn = pZtyharaikatakbn;
    }

    private String ztynenkinkaisigohyouji;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYNENKINKAISIGOHYOUJI)
    public String getZtynenkinkaisigohyouji() {
        return ztynenkinkaisigohyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtynenkinkaisigohyouji(String pZtynenkinkaisigohyouji) {
        ztynenkinkaisigohyouji = pZtynenkinkaisigohyouji;
    }

    private String ztykykjyoutai;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYKYKJYOUTAI)
    public String getZtykykjyoutai() {
        return ztykykjyoutai;
    }

    public void setZtykykjyoutai(String pZtykykjyoutai) {
        ztykykjyoutai = pZtykykjyoutai;
    }

    private BizNumber ztynaizouteikiyoteiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYNAIZOUTEIKIYOTEIRIRITU)
    public BizNumber getZtynaizouteikiyoteiriritu() {
        return ztynaizouteikiyoteiriritu;
    }

    public void setZtynaizouteikiyoteiriritu(BizNumber pZtynaizouteikiyoteiriritu) {
        ztynaizouteikiyoteiriritu = pZtynaizouteikiyoteiriritu;
    }

    private Long ztygoukeigyousekihyoujis;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYGOUKEIGYOUSEKIHYOUJIS)
    public Long getZtygoukeigyousekihyoujis() {
        return ztygoukeigyousekihyoujis;
    }

    public void setZtygoukeigyousekihyoujis(Long pZtygoukeigyousekihyoujis) {
        ztygoukeigyousekihyoujis = pZtygoukeigyousekihyoujis;
    }

    private Long ztysykykgyusekihyjs;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYSYKYKGYUSEKIHYJS)
    public Long getZtysykykgyusekihyjs() {
        return ztysykykgyusekihyjs;
    }

    public void setZtysykykgyusekihyjs(Long pZtysykykgyusekihyjs) {
        ztysykykgyusekihyjs = pZtysykykgyusekihyjs;
    }

    private Long ztytnknitjbrsykykgyuskhyjs;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTNKNITJBRSYKYKGYUSKHYJS)
    public Long getZtytnknitjbrsykykgyuskhyjs() {
        return ztytnknitjbrsykykgyuskhyjs;
    }

    public void setZtytnknitjbrsykykgyuskhyjs(Long pZtytnknitjbrsykykgyuskhyjs) {
        ztytnknitjbrsykykgyuskhyjs = pZtytnknitjbrsykykgyuskhyjs;
    }

    private String ztydatakanrino;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYDATAKANRINO)
    public String getZtydatakanrino() {
        return ztydatakanrino;
    }

    public void setZtydatakanrino(String pZtydatakanrino) {
        ztydatakanrino = pZtydatakanrino;
    }

    private String ztyhknsyukigou;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYHKNSYUKIGOU)
    public String getZtyhknsyukigou() {
        return ztyhknsyukigou;
    }

    public void setZtyhknsyukigou(String pZtyhknsyukigou) {
        ztyhknsyukigou = pZtyhknsyukigou;
    }

    private String ztyannaifuyouriyuukbn;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYANNAIFUYOURIYUUKBN)
    public String getZtyannaifuyouriyuukbn() {
        return ztyannaifuyouriyuukbn;
    }

    public void setZtyannaifuyouriyuukbn(String pZtyannaifuyouriyuukbn) {
        ztyannaifuyouriyuukbn = pZtyannaifuyouriyuukbn;
    }

    private String ztytkbthsyumnryuhyouji;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTKBTHSYUMNRYUHYOUJI)
    public String getZtytkbthsyumnryuhyouji() {
        return ztytkbthsyumnryuhyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtytkbthsyumnryuhyouji(String pZtytkbthsyumnryuhyouji) {
        ztytkbthsyumnryuhyouji = pZtytkbthsyumnryuhyouji;
    }

    private String ztykykymd;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYKYKYMD)
    public String getZtykykymd() {
        return ztykykymd;
    }

    public void setZtykykymd(String pZtykykymd) {
        ztykykymd = pZtykykymd;
    }

    private String ztyhhknseikbn;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYHHKNSEIKBN)
    public String getZtyhhknseikbn() {
        return ztyhhknseikbn;
    }

    public void setZtyhhknseikbn(String pZtyhhknseikbn) {
        ztyhhknseikbn = pZtyhhknseikbn;
    }

    private String ztyhihokensyaagev2;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYHIHOKENSYAAGEV2)
    public String getZtyhihokensyaagev2() {
        return ztyhihokensyaagev2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyhihokensyaagev2(String pZtyhihokensyaagev2) {
        ztyhihokensyaagev2 = pZtyhihokensyaagev2;
    }

    private String ztyhknkkn;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYHKNKKN)
    public String getZtyhknkkn() {
        return ztyhknkkn;
    }

    public void setZtyhknkkn(String pZtyhknkkn) {
        ztyhknkkn = pZtyhknkkn;
    }

    private String ztyphrkkikn;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYPHRKKIKN)
    public String getZtyphrkkikn() {
        return ztyphrkkikn;
    }

    public void setZtyphrkkikn(String pZtyphrkkikn) {
        ztyphrkkikn = pZtyphrkkikn;
    }

    private String ztysaimnkkykhyj;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYSAIMNKKYKHYJ)
    public String getZtysaimnkkykhyj() {
        return ztysaimnkkykhyj;
    }

    public void setZtysaimnkkykhyj(String pZtysaimnkkykhyj) {
        ztysaimnkkykhyj = pZtysaimnkkykhyj;
    }

    private String ztyhrkkaisuukbn;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYHRKKAISUUKBN)
    public String getZtyhrkkaisuukbn() {
        return ztyhrkkaisuukbn;
    }

    public void setZtyhrkkaisuukbn(String pZtyhrkkaisuukbn) {
        ztyhrkkaisuukbn = pZtyhrkkaisuukbn;
    }

    private String ztyannaikigetu;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYANNAIKIGETU)
    public String getZtyannaikigetu() {
        return ztyannaikigetu;
    }

    public void setZtyannaikigetu(String pZtyannaikigetu) {
        ztyannaikigetu = pZtyannaikigetu;
    }

    private String ztyao3tyou3sibousdatehyouji;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYAO3TYOU3SIBOUSDATEHYOUJI)
    public String getZtyao3tyou3sibousdatehyouji() {
        return ztyao3tyou3sibousdatehyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtyao3tyou3sibousdatehyouji(String pZtyao3tyou3sibousdatehyouji) {
        ztyao3tyou3sibousdatehyouji = pZtyao3tyou3sibousdatehyouji;
    }

    private Long ztykihons;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYKIHONS)
    public Long getZtykihons() {
        return ztykihons;
    }

    public void setZtykihons(Long pZtykihons) {
        ztykihons = pZtykihons;
    }

    private String ztyharaizumiymd;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYHARAIZUMIYMD)
    public String getZtyharaizumiymd() {
        return ztyharaizumiymd;
    }

    public void setZtyharaizumiymd(String pZtyharaizumiymd) {
        ztyharaizumiymd = pZtyharaizumiymd;
    }

    private Long ztyharaizumis;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYHARAIZUMIS)
    public Long getZtyharaizumis() {
        return ztyharaizumis;
    }

    public void setZtyharaizumis(Long pZtyharaizumis) {
        ztyharaizumis = pZtyharaizumis;
    }

    private Long ztyentyous;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYENTYOUS)
    public Long getZtyentyous() {
        return ztyentyous;
    }

    public void setZtyentyous(Long pZtyentyous) {
        ztyentyous = pZtyentyous;
    }

    private Long ztyseizons;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYSEIZONS)
    public Long getZtyseizons() {
        return ztyseizons;
    }

    public void setZtyseizons(Long pZtyseizons) {
        ztyseizons = pZtyseizons;
    }

    private Long ztypmens;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYPMENS)
    public Long getZtypmens() {
        return ztypmens;
    }

    public void setZtypmens(Long pZtypmens) {
        ztypmens = pZtypmens;
    }

    private Long ztyhendous;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYHENDOUS)
    public Long getZtyhendous() {
        return ztyhendous;
    }

    public void setZtyhendous(Long pZtyhendous) {
        ztyhendous = pZtyhendous;
    }

    private Long ztyitibuitijibarais;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYITIBUITIJIBARAIS)
    public Long getZtyitibuitijibarais() {
        return ztyitibuitijibarais;
    }

    public void setZtyitibuitijibarais(Long pZtyitibuitijibarais) {
        ztyitibuitijibarais = pZtyitibuitijibarais;
    }

    private String ztytenkanteikisyuruikigou;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTENKANTEIKISYURUIKIGOU)
    public String getZtytenkanteikisyuruikigou() {
        return ztytenkanteikisyuruikigou;
    }

    public void setZtytenkanteikisyuruikigou(String pZtytenkanteikisyuruikigou) {
        ztytenkanteikisyuruikigou = pZtytenkanteikisyuruikigou;
    }

    private String ztytenkanteikikikan;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTENKANTEIKIKIKAN)
    public String getZtytenkanteikikikan() {
        return ztytenkanteikikikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtytenkanteikikikan(String pZtytenkanteikikikan) {
        ztytenkanteikikikan = pZtytenkanteikikikan;
    }

    private String ztytnknteikinkshrkkn;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTNKNTEIKINKSHRKKN)
    public String getZtytnknteikinkshrkkn() {
        return ztytnknteikinkshrkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtytnknteikinkshrkkn(String pZtytnknteikinkshrkkn) {
        ztytnknteikinkshrkkn = pZtytnknteikinkshrkkn;
    }

    private Long ztygoukeitenkans;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYGOUKEITENKANS)
    public Long getZtygoukeitenkans() {
        return ztygoukeitenkans;
    }

    public void setZtygoukeitenkans(Long pZtygoukeitenkans) {
        ztygoukeitenkans = pZtygoukeitenkans;
    }

    private Long ztygoukeitenkanteikis;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYGOUKEITENKANTEIKIS)
    public Long getZtygoukeitenkanteikis() {
        return ztygoukeitenkanteikis;
    }

    public void setZtygoukeitenkanteikis(Long pZtygoukeitenkanteikis) {
        ztygoukeitenkanteikis = pZtygoukeitenkanteikis;
    }

    private Long ztygoukeipbubuntenkans;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYGOUKEIPBUBUNTENKANS)
    public Long getZtygoukeipbubuntenkans() {
        return ztygoukeipbubuntenkans;
    }

    public void setZtygoukeipbubuntenkans(Long pZtygoukeipbubuntenkans) {
        ztygoukeipbubuntenkans = pZtygoukeipbubuntenkans;
    }

    private String ztytenkankaisuu;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTENKANKAISUU)
    public String getZtytenkankaisuu() {
        return ztytenkankaisuu;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtytenkankaisuu(String pZtytenkankaisuu) {
        ztytenkankaisuu = pZtytenkankaisuu;
    }

    private Long ztydgoukei;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYDGOUKEI)
    public Long getZtydgoukei() {
        return ztydgoukei;
    }

    public void setZtydgoukei(Long pZtydgoukei) {
        ztydgoukei = pZtydgoukei;
    }

    private Long ztysrankbetuhisad;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYSRANKBETUHISAD)
    public Long getZtysrankbetuhisad() {
        return ztysrankbetuhisad;
    }

    public void setZtysrankbetuhisad(Long pZtysrankbetuhisad) {
        ztysrankbetuhisad = pZtysrankbetuhisad;
    }

    private Long ztysyumtjsrankbetuhisad;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYSYUMTJSRANKBETUHISAD)
    public Long getZtysyumtjsrankbetuhisad() {
        return ztysyumtjsrankbetuhisad;
    }

    public void setZtysyumtjsrankbetuhisad(Long pZtysyumtjsrankbetuhisad) {
        ztysyumtjsrankbetuhisad = pZtysyumtjsrankbetuhisad;
    }

    private Long ztybairitubetuhisad;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYBAIRITUBETUHISAD)
    public Long getZtybairitubetuhisad() {
        return ztybairitubetuhisad;
    }

    public void setZtybairitubetuhisad(Long pZtybairitubetuhisad) {
        ztybairitubetuhisad = pZtybairitubetuhisad;
    }

    private Long ztysyumtjtikbairtbetuhisad;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYSYUMTJTIKBAIRTBETUHISAD)
    public Long getZtysyumtjtikbairtbetuhisad() {
        return ztysyumtjtikbairtbetuhisad;
    }

    public void setZtysyumtjtikbairtbetuhisad(Long pZtysyumtjtikbairtbetuhisad) {
        ztysyumtjtikbairtbetuhisad = pZtysyumtjtikbairtbetuhisad;
    }

    private Long ztysyukeiyakukihongoukeid;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYSYUKEIYAKUKIHONGOUKEID)
    public Long getZtysyukeiyakukihongoukeid() {
        return ztysyukeiyakukihongoukeid;
    }

    public void setZtysyukeiyakukihongoukeid(Long pZtysyukeiyakukihongoukeid) {
        ztysyukeiyakukihongoukeid = pZtysyukeiyakukihongoukeid;
    }

    private Long ztysyukeiyakukihonsisad;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYSYUKEIYAKUKIHONSISAD)
    public Long getZtysyukeiyakukihonsisad() {
        return ztysyukeiyakukihonsisad;
    }

    public void setZtysyukeiyakukihonsisad(Long pZtysyukeiyakukihonsisad) {
        ztysyukeiyakukihonsisad = pZtysyukeiyakukihonsisad;
    }

    private Long ztysyukeiyakukihonrisad;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYSYUKEIYAKUKIHONRISAD)
    public Long getZtysyukeiyakukihonrisad() {
        return ztysyukeiyakukihonrisad;
    }

    public void setZtysyukeiyakukihonrisad(Long pZtysyukeiyakukihonrisad) {
        ztysyukeiyakukihonrisad = pZtysyukeiyakukihonrisad;
    }

    private Long ztysyukeiyakukihonramudad;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYSYUKEIYAKUKIHONRAMUDAD)
    public Long getZtysyukeiyakukihonramudad() {
        return ztysyukeiyakukihonramudad;
    }

    public void setZtysyukeiyakukihonramudad(Long pZtysyukeiyakukihonramudad) {
        ztysyukeiyakukihonramudad = pZtysyukeiyakukihonramudad;
    }

    private Long ztysyukeiyakukihonhisad;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYSYUKEIYAKUKIHONHISAD)
    public Long getZtysyukeiyakukihonhisad() {
        return ztysyukeiyakukihonhisad;
    }

    public void setZtysyukeiyakukihonhisad(Long pZtysyukeiyakukihonhisad) {
        ztysyukeiyakukihonhisad = pZtysyukeiyakukihonhisad;
    }

    private Long ztysyukeiyakukihondtaisyous;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYSYUKEIYAKUKIHONDTAISYOUS)
    public Long getZtysyukeiyakukihondtaisyous() {
        return ztysyukeiyakukihondtaisyous;
    }

    public void setZtysyukeiyakukihondtaisyous(Long pZtysyukeiyakukihondtaisyous) {
        ztysyukeiyakukihondtaisyous = pZtysyukeiyakukihondtaisyous;
    }

    private Long ztysyukeiyakukihondyouv;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYSYUKEIYAKUKIHONDYOUV)
    public Long getZtysyukeiyakukihondyouv() {
        return ztysyukeiyakukihondyouv;
    }

    public void setZtysyukeiyakukihondyouv(Long pZtysyukeiyakukihondyouv) {
        ztysyukeiyakukihondyouv = pZtysyukeiyakukihondyouv;
    }

    private Long ztysyukeiyakukihondkikens;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYSYUKEIYAKUKIHONDKIKENS)
    public Long getZtysyukeiyakukihondkikens() {
        return ztysyukeiyakukihondkikens;
    }

    public void setZtysyukeiyakukihondkikens(Long pZtysyukeiyakukihondkikens) {
        ztysyukeiyakukihondkikens = pZtysyukeiyakukihondkikens;
    }

    private Long ztysykykkhnhisadtisyus;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYSYKYKKHNHISADTISYUS)
    public Long getZtysykykkhnhisadtisyus() {
        return ztysykykkhnhisadtisyus;
    }

    public void setZtysykykkhnhisadtisyus(Long pZtysykykkhnhisadtisyus) {
        ztysykykkhnhisadtisyus = pZtysykykkhnhisadtisyus;
    }

    private Long ztysyukeiyakuteikigoukeid;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYSYUKEIYAKUTEIKIGOUKEID)
    public Long getZtysyukeiyakuteikigoukeid() {
        return ztysyukeiyakuteikigoukeid;
    }

    public void setZtysyukeiyakuteikigoukeid(Long pZtysyukeiyakuteikigoukeid) {
        ztysyukeiyakuteikigoukeid = pZtysyukeiyakuteikigoukeid;
    }

    private Long ztysyukeiyakuteikisisad;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYSYUKEIYAKUTEIKISISAD)
    public Long getZtysyukeiyakuteikisisad() {
        return ztysyukeiyakuteikisisad;
    }

    public void setZtysyukeiyakuteikisisad(Long pZtysyukeiyakuteikisisad) {
        ztysyukeiyakuteikisisad = pZtysyukeiyakuteikisisad;
    }

    private Long ztysyukeiyakuteikirisad;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYSYUKEIYAKUTEIKIRISAD)
    public Long getZtysyukeiyakuteikirisad() {
        return ztysyukeiyakuteikirisad;
    }

    public void setZtysyukeiyakuteikirisad(Long pZtysyukeiyakuteikirisad) {
        ztysyukeiyakuteikirisad = pZtysyukeiyakuteikirisad;
    }

    private Long ztysyukeiyakuteikiramudad;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYSYUKEIYAKUTEIKIRAMUDAD)
    public Long getZtysyukeiyakuteikiramudad() {
        return ztysyukeiyakuteikiramudad;
    }

    public void setZtysyukeiyakuteikiramudad(Long pZtysyukeiyakuteikiramudad) {
        ztysyukeiyakuteikiramudad = pZtysyukeiyakuteikiramudad;
    }

    private Long ztysyukeiyakuteikihisad;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYSYUKEIYAKUTEIKIHISAD)
    public Long getZtysyukeiyakuteikihisad() {
        return ztysyukeiyakuteikihisad;
    }

    public void setZtysyukeiyakuteikihisad(Long pZtysyukeiyakuteikihisad) {
        ztysyukeiyakuteikihisad = pZtysyukeiyakuteikihisad;
    }

    private Long ztysyukeiyakuteikidtaisyous;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYSYUKEIYAKUTEIKIDTAISYOUS)
    public Long getZtysyukeiyakuteikidtaisyous() {
        return ztysyukeiyakuteikidtaisyous;
    }

    public void setZtysyukeiyakuteikidtaisyous(Long pZtysyukeiyakuteikidtaisyous) {
        ztysyukeiyakuteikidtaisyous = pZtysyukeiyakuteikidtaisyous;
    }

    private Long ztysyukeiyakuteikidyouv;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYSYUKEIYAKUTEIKIDYOUV)
    public Long getZtysyukeiyakuteikidyouv() {
        return ztysyukeiyakuteikidyouv;
    }

    public void setZtysyukeiyakuteikidyouv(Long pZtysyukeiyakuteikidyouv) {
        ztysyukeiyakuteikidyouv = pZtysyukeiyakuteikidyouv;
    }

    private Long ztysyukeiyakuteikidkikens;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYSYUKEIYAKUTEIKIDKIKENS)
    public Long getZtysyukeiyakuteikidkikens() {
        return ztysyukeiyakuteikidkikens;
    }

    public void setZtysyukeiyakuteikidkikens(Long pZtysyukeiyakuteikidkikens) {
        ztysyukeiyakuteikidkikens = pZtysyukeiyakuteikidkikens;
    }

    private Long ztysykyktikhisadtisyus;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYSYKYKTIKHISADTISYUS)
    public Long getZtysykyktikhisadtisyus() {
        return ztysykyktikhisadtisyus;
    }

    public void setZtysykyktikhisadtisyus(Long pZtysykyktikhisadtisyus) {
        ztysykyktikhisadtisyus = pZtysykyktikhisadtisyus;
    }

    private Long ztytenkankihongoukeid;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTENKANKIHONGOUKEID)
    public Long getZtytenkankihongoukeid() {
        return ztytenkankihongoukeid;
    }

    public void setZtytenkankihongoukeid(Long pZtytenkankihongoukeid) {
        ztytenkankihongoukeid = pZtytenkankihongoukeid;
    }

    private Long ztytenkankihonsisad;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTENKANKIHONSISAD)
    public Long getZtytenkankihonsisad() {
        return ztytenkankihonsisad;
    }

    public void setZtytenkankihonsisad(Long pZtytenkankihonsisad) {
        ztytenkankihonsisad = pZtytenkankihonsisad;
    }

    private Long ztytenkankihonrisad;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTENKANKIHONRISAD)
    public Long getZtytenkankihonrisad() {
        return ztytenkankihonrisad;
    }

    public void setZtytenkankihonrisad(Long pZtytenkankihonrisad) {
        ztytenkankihonrisad = pZtytenkankihonrisad;
    }

    private Long ztytenkankihonramudad;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTENKANKIHONRAMUDAD)
    public Long getZtytenkankihonramudad() {
        return ztytenkankihonramudad;
    }

    public void setZtytenkankihonramudad(Long pZtytenkankihonramudad) {
        ztytenkankihonramudad = pZtytenkankihonramudad;
    }

    private Long ztytenkankihonhisad;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTENKANKIHONHISAD)
    public Long getZtytenkankihonhisad() {
        return ztytenkankihonhisad;
    }

    public void setZtytenkankihonhisad(Long pZtytenkankihonhisad) {
        ztytenkankihonhisad = pZtytenkankihonhisad;
    }

    private Long ztytenkankihondtaisyous;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTENKANKIHONDTAISYOUS)
    public Long getZtytenkankihondtaisyous() {
        return ztytenkankihondtaisyous;
    }

    public void setZtytenkankihondtaisyous(Long pZtytenkankihondtaisyous) {
        ztytenkankihondtaisyous = pZtytenkankihondtaisyous;
    }

    private Long ztytenkankihondyouv;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTENKANKIHONDYOUV)
    public Long getZtytenkankihondyouv() {
        return ztytenkankihondyouv;
    }

    public void setZtytenkankihondyouv(Long pZtytenkankihondyouv) {
        ztytenkankihondyouv = pZtytenkankihondyouv;
    }

    private Long ztytenkankihondkikens;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTENKANKIHONDKIKENS)
    public Long getZtytenkankihondkikens() {
        return ztytenkankihondkikens;
    }

    public void setZtytenkankihondkikens(Long pZtytenkankihondkikens) {
        ztytenkankihondkikens = pZtytenkankihondkikens;
    }

    private Long ztytenkankihonhisadtaisyous;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTENKANKIHONHISADTAISYOUS)
    public Long getZtytenkankihonhisadtaisyous() {
        return ztytenkankihonhisadtaisyous;
    }

    public void setZtytenkankihonhisadtaisyous(Long pZtytenkankihonhisadtaisyous) {
        ztytenkankihonhisadtaisyous = pZtytenkankihonhisadtaisyous;
    }

    private Long ztytenkanteikigoukeid;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTENKANTEIKIGOUKEID)
    public Long getZtytenkanteikigoukeid() {
        return ztytenkanteikigoukeid;
    }

    public void setZtytenkanteikigoukeid(Long pZtytenkanteikigoukeid) {
        ztytenkanteikigoukeid = pZtytenkanteikigoukeid;
    }

    private Long ztytenkanteikisisad;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTENKANTEIKISISAD)
    public Long getZtytenkanteikisisad() {
        return ztytenkanteikisisad;
    }

    public void setZtytenkanteikisisad(Long pZtytenkanteikisisad) {
        ztytenkanteikisisad = pZtytenkanteikisisad;
    }

    private Long ztytenkanteikirisad;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTENKANTEIKIRISAD)
    public Long getZtytenkanteikirisad() {
        return ztytenkanteikirisad;
    }

    public void setZtytenkanteikirisad(Long pZtytenkanteikirisad) {
        ztytenkanteikirisad = pZtytenkanteikirisad;
    }

    private Long ztytenkanteikiramudad;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTENKANTEIKIRAMUDAD)
    public Long getZtytenkanteikiramudad() {
        return ztytenkanteikiramudad;
    }

    public void setZtytenkanteikiramudad(Long pZtytenkanteikiramudad) {
        ztytenkanteikiramudad = pZtytenkanteikiramudad;
    }

    private Long ztytenkanteikihisad;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTENKANTEIKIHISAD)
    public Long getZtytenkanteikihisad() {
        return ztytenkanteikihisad;
    }

    public void setZtytenkanteikihisad(Long pZtytenkanteikihisad) {
        ztytenkanteikihisad = pZtytenkanteikihisad;
    }

    private Long ztytenkanteikidtaisyous;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTENKANTEIKIDTAISYOUS)
    public Long getZtytenkanteikidtaisyous() {
        return ztytenkanteikidtaisyous;
    }

    public void setZtytenkanteikidtaisyous(Long pZtytenkanteikidtaisyous) {
        ztytenkanteikidtaisyous = pZtytenkanteikidtaisyous;
    }

    private Long ztytenkanteikidyouv;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTENKANTEIKIDYOUV)
    public Long getZtytenkanteikidyouv() {
        return ztytenkanteikidyouv;
    }

    public void setZtytenkanteikidyouv(Long pZtytenkanteikidyouv) {
        ztytenkanteikidyouv = pZtytenkanteikidyouv;
    }

    private Long ztytenkanteikidkikens;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTENKANTEIKIDKIKENS)
    public Long getZtytenkanteikidkikens() {
        return ztytenkanteikidkikens;
    }

    public void setZtytenkanteikidkikens(Long pZtytenkanteikidkikens) {
        ztytenkanteikidkikens = pZtytenkanteikidkikens;
    }

    private Long ztytenkanteikihisadtaisyous;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTENKANTEIKIHISADTAISYOUS)
    public Long getZtytenkanteikihisadtaisyous() {
        return ztytenkanteikihisadtaisyous;
    }

    public void setZtytenkanteikihisadtaisyous(Long pZtytenkanteikihisadtaisyous) {
        ztytenkanteikihisadtaisyous = pZtytenkanteikihisadtaisyous;
    }

    private Long ztysyumtjtyusiyutnkntikgukd;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYSYUMTJTYUSIYUTNKNTIKGUKD)
    public Long getZtysyumtjtyusiyutnkntikgukd() {
        return ztysyumtjtyusiyutnkntikgukd;
    }

    public void setZtysyumtjtyusiyutnkntikgukd(Long pZtysyumtjtyusiyutnkntikgukd) {
        ztysyumtjtyusiyutnkntikgukd = pZtysyumtjtyusiyutnkntikgukd;
    }

    private Long ztysyumtjtyusiyutnkntiksisd;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYSYUMTJTYUSIYUTNKNTIKSISD)
    public Long getZtysyumtjtyusiyutnkntiksisd() {
        return ztysyumtjtyusiyutnkntiksisd;
    }

    public void setZtysyumtjtyusiyutnkntiksisd(Long pZtysyumtjtyusiyutnkntiksisd) {
        ztysyumtjtyusiyutnkntiksisd = pZtysyumtjtyusiyutnkntiksisd;
    }

    private Long ztysyumtjtyusiyutnkntikrisd;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYSYUMTJTYUSIYUTNKNTIKRISD)
    public Long getZtysyumtjtyusiyutnkntikrisd() {
        return ztysyumtjtyusiyutnkntikrisd;
    }

    public void setZtysyumtjtyusiyutnkntikrisd(Long pZtysyumtjtyusiyutnkntikrisd) {
        ztysyumtjtyusiyutnkntikrisd = pZtysyumtjtyusiyutnkntikrisd;
    }

    private Long ztysyumtjtyusiyutnkntikhisd;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYSYUMTJTYUSIYUTNKNTIKHISD)
    public Long getZtysyumtjtyusiyutnkntikhisd() {
        return ztysyumtjtyusiyutnkntikhisd;
    }

    public void setZtysyumtjtyusiyutnkntikhisd(Long pZtysyumtjtyusiyutnkntikhisd) {
        ztysyumtjtyusiyutnkntikhisd = pZtysyumtjtyusiyutnkntikhisd;
    }

    private Long ztysyumtjtnkntikdtaisyous;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYSYUMTJTNKNTIKDTAISYOUS)
    public Long getZtysyumtjtnkntikdtaisyous() {
        return ztysyumtjtnkntikdtaisyous;
    }

    public void setZtysyumtjtnkntikdtaisyous(Long pZtysyumtjtnkntikdtaisyous) {
        ztysyumtjtnkntikdtaisyous = pZtysyumtjtnkntikdtaisyous;
    }

    private Long ztysyumtjtnkntikdyouv;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYSYUMTJTNKNTIKDYOUV)
    public Long getZtysyumtjtnkntikdyouv() {
        return ztysyumtjtnkntikdyouv;
    }

    public void setZtysyumtjtnkntikdyouv(Long pZtysyumtjtnkntikdyouv) {
        ztysyumtjtnkntikdyouv = pZtysyumtjtnkntikdyouv;
    }

    private Long ztysyumtjtnkntikdkikens;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYSYUMTJTNKNTIKDKIKENS)
    public Long getZtysyumtjtnkntikdkikens() {
        return ztysyumtjtnkntikdkikens;
    }

    public void setZtysyumtjtnkntikdkikens(Long pZtysyumtjtnkntikdkikens) {
        ztysyumtjtnkntikdkikens = pZtysyumtjtnkntikdkikens;
    }

    private Long ztyhendougoukeid;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYHENDOUGOUKEID)
    public Long getZtyhendougoukeid() {
        return ztyhendougoukeid;
    }

    public void setZtyhendougoukeid(Long pZtyhendougoukeid) {
        ztyhendougoukeid = pZtyhendougoukeid;
    }

    private Long ztyhendousisad;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYHENDOUSISAD)
    public Long getZtyhendousisad() {
        return ztyhendousisad;
    }

    public void setZtyhendousisad(Long pZtyhendousisad) {
        ztyhendousisad = pZtyhendousisad;
    }

    private Long ztyhendouhisad;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYHENDOUHISAD)
    public Long getZtyhendouhisad() {
        return ztyhendouhisad;
    }

    public void setZtyhendouhisad(Long pZtyhendouhisad) {
        ztyhendouhisad = pZtyhendouhisad;
    }

    private Long ztyhendoudtaisyous;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYHENDOUDTAISYOUS)
    public Long getZtyhendoudtaisyous() {
        return ztyhendoudtaisyous;
    }

    public void setZtyhendoudtaisyous(Long pZtyhendoudtaisyous) {
        ztyhendoudtaisyous = pZtyhendoudtaisyous;
    }

    private Long ztyhendoudyouv;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYHENDOUDYOUV)
    public Long getZtyhendoudyouv() {
        return ztyhendoudyouv;
    }

    public void setZtyhendoudyouv(Long pZtyhendoudyouv) {
        ztyhendoudyouv = pZtyhendoudyouv;
    }

    private Long ztyhendoudkikens;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYHENDOUDKIKENS)
    public Long getZtyhendoudkikens() {
        return ztyhendoudkikens;
    }

    public void setZtyhendoudkikens(Long pZtyhendoudkikens) {
        ztyhendoudkikens = pZtyhendoudkikens;
    }

    private Long ztyitibuitijibaraigoukeid;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYITIBUITIJIBARAIGOUKEID)
    public Long getZtyitibuitijibaraigoukeid() {
        return ztyitibuitijibaraigoukeid;
    }

    public void setZtyitibuitijibaraigoukeid(Long pZtyitibuitijibaraigoukeid) {
        ztyitibuitijibaraigoukeid = pZtyitibuitijibaraigoukeid;
    }

    private Long ztyitibuitijibaraisisad;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYITIBUITIJIBARAISISAD)
    public Long getZtyitibuitijibaraisisad() {
        return ztyitibuitijibaraisisad;
    }

    public void setZtyitibuitijibaraisisad(Long pZtyitibuitijibaraisisad) {
        ztyitibuitijibaraisisad = pZtyitibuitijibaraisisad;
    }

    private Long ztyitibuitijibaraihisad;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYITIBUITIJIBARAIHISAD)
    public Long getZtyitibuitijibaraihisad() {
        return ztyitibuitijibaraihisad;
    }

    public void setZtyitibuitijibaraihisad(Long pZtyitibuitijibaraihisad) {
        ztyitibuitijibaraihisad = pZtyitibuitijibaraihisad;
    }

    private Long ztyitibuitijibaraidtaisyous;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYITIBUITIJIBARAIDTAISYOUS)
    public Long getZtyitibuitijibaraidtaisyous() {
        return ztyitibuitijibaraidtaisyous;
    }

    public void setZtyitibuitijibaraidtaisyous(Long pZtyitibuitijibaraidtaisyous) {
        ztyitibuitijibaraidtaisyous = pZtyitibuitijibaraidtaisyous;
    }

    private Long ztyitibuitijibaraidyouv;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYITIBUITIJIBARAIDYOUV)
    public Long getZtyitibuitijibaraidyouv() {
        return ztyitibuitijibaraidyouv;
    }

    public void setZtyitibuitijibaraidyouv(Long pZtyitibuitijibaraidyouv) {
        ztyitibuitijibaraidyouv = pZtyitibuitijibaraidyouv;
    }

    private Long ztyitibuitijibaraidkikens;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYITIBUITIJIBARAIDKIKENS)
    public Long getZtyitibuitijibaraidkikens() {
        return ztyitibuitijibaraidkikens;
    }

    public void setZtyitibuitijibaraidkikens(Long pZtyitibuitijibaraidkikens) {
        ztyitibuitijibaraidkikens = pZtyitibuitijibaraidkikens;
    }

    private Long ztyitibitjbrhisadtisyus;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYITIBITJBRHISADTISYUS)
    public Long getZtyitibitjbrhisadtisyus() {
        return ztyitibitjbrhisadtisyus;
    }

    public void setZtyitibitjbrhisadtisyus(Long pZtyitibitjbrhisadtisyus) {
        ztyitibitjbrhisadtisyus = pZtyitibitjbrhisadtisyus;
    }

    private String ztyszoukouryokukaisiymd;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYSZOUKOURYOKUKAISIYMD)
    public String getZtyszoukouryokukaisiymd() {
        return ztyszoukouryokukaisiymd;
    }

    public void setZtyszoukouryokukaisiymd(String pZtyszoukouryokukaisiymd) {
        ztyszoukouryokukaisiymd = pZtyszoukouryokukaisiymd;
    }

    private String ztyszouhokensyuruikigou;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYSZOUHOKENSYURUIKIGOU)
    public String getZtyszouhokensyuruikigou() {
        return ztyszouhokensyuruikigou;
    }

    public void setZtyszouhokensyuruikigou(String pZtyszouhokensyuruikigou) {
        ztyszouhokensyuruikigou = pZtyszouhokensyuruikigou;
    }

    private String ztyszoukikan;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYSZOUKIKAN)
    public String getZtyszoukikan() {
        return ztyszoukikan;
    }

    public void setZtyszoukikan(String pZtyszoukikan) {
        ztyszoukikan = pZtyszoukikan;
    }

    private String ztyszouhihokensyaage;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYSZOUHIHOKENSYAAGE)
    public String getZtyszouhihokensyaage() {
        return ztyszouhihokensyaage;
    }

    public void setZtyszouhihokensyaage(String pZtyszouhihokensyaage) {
        ztyszouhihokensyaage = pZtyszouhihokensyaage;
    }

    private Long ztyzoukagoukeid;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYZOUKAGOUKEID)
    public Long getZtyzoukagoukeid() {
        return ztyzoukagoukeid;
    }

    public void setZtyzoukagoukeid(Long pZtyzoukagoukeid) {
        ztyzoukagoukeid = pZtyzoukagoukeid;
    }

    private Long ztyzoukasisad;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYZOUKASISAD)
    public Long getZtyzoukasisad() {
        return ztyzoukasisad;
    }

    public void setZtyzoukasisad(Long pZtyzoukasisad) {
        ztyzoukasisad = pZtyzoukasisad;
    }

    private Long ztyzoukarisad;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYZOUKARISAD)
    public Long getZtyzoukarisad() {
        return ztyzoukarisad;
    }

    public void setZtyzoukarisad(Long pZtyzoukarisad) {
        ztyzoukarisad = pZtyzoukarisad;
    }

    private Long ztyzoukaramudad;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYZOUKARAMUDAD)
    public Long getZtyzoukaramudad() {
        return ztyzoukaramudad;
    }

    public void setZtyzoukaramudad(Long pZtyzoukaramudad) {
        ztyzoukaramudad = pZtyzoukaramudad;
    }

    private Long ztyzoukahisad;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYZOUKAHISAD)
    public Long getZtyzoukahisad() {
        return ztyzoukahisad;
    }

    public void setZtyzoukahisad(Long pZtyzoukahisad) {
        ztyzoukahisad = pZtyzoukahisad;
    }

    private Long ztyzoukadtaisyous;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYZOUKADTAISYOUS)
    public Long getZtyzoukadtaisyous() {
        return ztyzoukadtaisyous;
    }

    public void setZtyzoukadtaisyous(Long pZtyzoukadtaisyous) {
        ztyzoukadtaisyous = pZtyzoukadtaisyous;
    }

    private Long ztyzoukadyouv;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYZOUKADYOUV)
    public Long getZtyzoukadyouv() {
        return ztyzoukadyouv;
    }

    public void setZtyzoukadyouv(Long pZtyzoukadyouv) {
        ztyzoukadyouv = pZtyzoukadyouv;
    }

    private Long ztyzoukadkikens;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYZOUKADKIKENS)
    public Long getZtyzoukadkikens() {
        return ztyzoukadkikens;
    }

    public void setZtyzoukadkikens(Long pZtyzoukadkikens) {
        ztyzoukadkikens = pZtyzoukadkikens;
    }

    private String ztykakuteikakusasyuruikgu;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYKAKUTEIKAKUSASYURUIKGU)
    public String getZtykakuteikakusasyuruikgu() {
        return ztykakuteikakusasyuruikgu;
    }

    public void setZtykakuteikakusasyuruikgu(String pZtykakuteikakusasyuruikgu) {
        ztykakuteikakusasyuruikgu = pZtykakuteikakusasyuruikgu;
    }

    private Long ztykakuteikakusad;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYKAKUTEIKAKUSAD)
    public Long getZtykakuteikakusad() {
        return ztykakuteikakusad;
    }

    public void setZtykakuteikakusad(Long pZtykakuteikakusad) {
        ztykakuteikakusad = pZtykakuteikakusad;
    }

    private Long ztykakuteikakusas;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYKAKUTEIKAKUSAS)
    public Long getZtykakuteikakusas() {
        return ztykakuteikakusas;
    }

    public void setZtykakuteikakusas(Long pZtykakuteikakusas) {
        ztykakuteikakusas = pZtykakuteikakusas;
    }

    private Long ztykakuteikakusamanryoujid;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYKAKUTEIKAKUSAMANRYOUJID)
    public Long getZtykakuteikakusamanryoujid() {
        return ztykakuteikakusamanryoujid;
    }

    public void setZtykakuteikakusamanryoujid(Long pZtykakuteikakusamanryoujid) {
        ztykakuteikakusamanryoujid = pZtykakuteikakusamanryoujid;
    }

    private String ztynaizoumarusasyuruikigou;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYNAIZOUMARUSASYURUIKIGOU)
    public String getZtynaizoumarusasyuruikigou() {
        return ztynaizoumarusasyuruikigou;
    }

    public void setZtynaizoumarusasyuruikigou(String pZtynaizoumarusasyuruikigou) {
        ztynaizoumarusasyuruikigou = pZtynaizoumarusasyuruikigou;
    }

    private Long ztynaizoumarusad;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYNAIZOUMARUSAD)
    public Long getZtynaizoumarusad() {
        return ztynaizoumarusad;
    }

    public void setZtynaizoumarusad(Long pZtynaizoumarusad) {
        ztynaizoumarusad = pZtynaizoumarusad;
    }

    private Long ztynaizoumarusas;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYNAIZOUMARUSAS)
    public Long getZtynaizoumarusas() {
        return ztynaizoumarusas;
    }

    public void setZtynaizoumarusas(Long pZtynaizoumarusas) {
        ztynaizoumarusas = pZtynaizoumarusas;
    }

    private String ztynaizoukakusasyuruikigou;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYNAIZOUKAKUSASYURUIKIGOU)
    public String getZtynaizoukakusasyuruikigou() {
        return ztynaizoukakusasyuruikigou;
    }

    public void setZtynaizoukakusasyuruikigou(String pZtynaizoukakusasyuruikigou) {
        ztynaizoukakusasyuruikigou = pZtynaizoukakusasyuruikigou;
    }

    private Long ztynaizoukakusad;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYNAIZOUKAKUSAD)
    public Long getZtynaizoukakusad() {
        return ztynaizoukakusad;
    }

    public void setZtynaizoukakusad(Long pZtynaizoukakusad) {
        ztynaizoukakusad = pZtynaizoukakusad;
    }

    private Long ztynaizoukakusas;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYNAIZOUKAKUSAS)
    public Long getZtynaizoukakusas() {
        return ztynaizoukakusas;
    }

    public void setZtynaizoukakusas(Long pZtynaizoukakusas) {
        ztynaizoukakusas = pZtynaizoukakusas;
    }

    private Long ztytenkanpbubund;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTENKANPBUBUND)
    public Long getZtytenkanpbubund() {
        return ztytenkanpbubund;
    }

    public void setZtytenkanpbubund(Long pZtytenkanpbubund) {
        ztytenkanpbubund = pZtytenkanpbubund;
    }

    private Long ztytenkanpbubunsisad;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTENKANPBUBUNSISAD)
    public Long getZtytenkanpbubunsisad() {
        return ztytenkanpbubunsisad;
    }

    public void setZtytenkanpbubunsisad(Long pZtytenkanpbubunsisad) {
        ztytenkanpbubunsisad = pZtytenkanpbubunsisad;
    }

    private Long ztytenkanpbubunrisad;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTENKANPBUBUNRISAD)
    public Long getZtytenkanpbubunrisad() {
        return ztytenkanpbubunrisad;
    }

    public void setZtytenkanpbubunrisad(Long pZtytenkanpbubunrisad) {
        ztytenkanpbubunrisad = pZtytenkanpbubunrisad;
    }

    private Long ztytenkanpbubunhisad;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTENKANPBUBUNHISAD)
    public Long getZtytenkanpbubunhisad() {
        return ztytenkanpbubunhisad;
    }

    public void setZtytenkanpbubunhisad(Long pZtytenkanpbubunhisad) {
        ztytenkanpbubunhisad = pZtytenkanpbubunhisad;
    }

    private Long ztytenkanpbubundtaisyous;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTENKANPBUBUNDTAISYOUS)
    public Long getZtytenkanpbubundtaisyous() {
        return ztytenkanpbubundtaisyous;
    }

    public void setZtytenkanpbubundtaisyous(Long pZtytenkanpbubundtaisyous) {
        ztytenkanpbubundtaisyous = pZtytenkanpbubundtaisyous;
    }

    private Long ztytenkanpbubundyouv;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTENKANPBUBUNDYOUV)
    public Long getZtytenkanpbubundyouv() {
        return ztytenkanpbubundyouv;
    }

    public void setZtytenkanpbubundyouv(Long pZtytenkanpbubundyouv) {
        ztytenkanpbubundyouv = pZtytenkanpbubundyouv;
    }

    private Long ztytenkanpbubundkikens;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTENKANPBUBUNDKIKENS)
    public Long getZtytenkanpbubundkikens() {
        return ztytenkanpbubundkikens;
    }

    public void setZtytenkanpbubundkikens(Long pZtytenkanpbubundkikens) {
        ztytenkanpbubundkikens = pZtytenkanpbubundkikens;
    }

    private Long ztynaizougatateikimud;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYNAIZOUGATATEIKIMUD)
    public Long getZtynaizougatateikimud() {
        return ztynaizougatateikimud;
    }

    public void setZtynaizougatateikimud(Long pZtynaizougatateikimud) {
        ztynaizougatateikimud = pZtynaizougatateikimud;
    }

    private Long ztynaizougatanenkansanp;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYNAIZOUGATANENKANSANP)
    public Long getZtynaizougatanenkansanp() {
        return ztynaizougatanenkansanp;
    }

    public void setZtynaizougatanenkansanp(Long pZtynaizougatanenkansanp) {
        ztynaizougatanenkansanp = pZtynaizougatanenkansanp;
    }

    private Long ztyvhktgbbntnkntikmud;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYVHKTGBBNTNKNTIKMUD)
    public Long getZtyvhktgbbntnkntikmud() {
        return ztyvhktgbbntnkntikmud;
    }

    public void setZtyvhktgbbntnkntikmud(Long pZtyvhktgbbntnkntikmud) {
        ztyvhktgbbntnkntikmud = pZtyvhktgbbntnkntikmud;
    }

    private Long ztyhikitugitenkanphireimud;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYHIKITUGITENKANPHIREIMUD)
    public Long getZtyhikitugitenkanphireimud() {
        return ztyhikitugitenkanphireimud;
    }

    public void setZtyhikitugitenkanphireimud(Long pZtyhikitugitenkanphireimud) {
        ztyhikitugitenkanphireimud = pZtyhikitugitenkanphireimud;
    }

    private Long ztyitibitjbrgyuskhyjs;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYITIBITJBRGYUSKHYJS)
    public Long getZtyitibitjbrgyuskhyjs() {
        return ztyitibitjbrgyuskhyjs;
    }

    public void setZtyitibitjbrgyuskhyjs(Long pZtyitibitjbrgyuskhyjs) {
        ztyitibitjbrgyuskhyjs = pZtyitibitjbrgyuskhyjs;
    }

    private Long ztykariwariate4nenmae;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYKARIWARIATE4NENMAE)
    public Long getZtykariwariate4nenmae() {
        return ztykariwariate4nenmae;
    }

    public void setZtykariwariate4nenmae(Long pZtykariwariate4nenmae) {
        ztykariwariate4nenmae = pZtykariwariate4nenmae;
    }

    private Long ztykariwariate3nenmae;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYKARIWARIATE3NENMAE)
    public Long getZtykariwariate3nenmae() {
        return ztykariwariate3nenmae;
    }

    public void setZtykariwariate3nenmae(Long pZtykariwariate3nenmae) {
        ztykariwariate3nenmae = pZtykariwariate3nenmae;
    }

    private Long ztykariwariate2nenmae;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYKARIWARIATE2NENMAE)
    public Long getZtykariwariate2nenmae() {
        return ztykariwariate2nenmae;
    }

    public void setZtykariwariate2nenmae(Long pZtykariwariate2nenmae) {
        ztykariwariate2nenmae = pZtykariwariate2nenmae;
    }

    private Long ztykariwariate1nenmae;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYKARIWARIATE1NENMAE)
    public Long getZtykariwariate1nenmae() {
        return ztykariwariate1nenmae;
    }

    public void setZtykariwariate1nenmae(Long pZtykariwariate1nenmae) {
        ztykariwariate1nenmae = pZtykariwariate1nenmae;
    }

    private Long ztygukisisntnkntikmud;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYGUKISISNTNKNTIKMUD)
    public Long getZtygukisisntnkntikmud() {
        return ztygukisisntnkntikmud;
    }

    public void setZtygukisisntnkntikmud(Long pZtygukisisntnkntikmud) {
        ztygukisisntnkntikmud = pZtygukisisntnkntikmud;
    }

    private Long ztygoukeiseisanteikis;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYGOUKEISEISANTEIKIS)
    public Long getZtygoukeiseisanteikis() {
        return ztygoukeiseisanteikis;
    }

    public void setZtygoukeiseisanteikis(Long pZtygoukeiseisanteikis) {
        ztygoukeiseisanteikis = pZtygoukeiseisanteikis;
    }

    private Long ztygukisisntnknnenknsnp;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYGUKISISNTNKNNENKNSNP)
    public Long getZtygukisisntnknnenknsnp() {
        return ztygukisisntnknnenknsnp;
    }

    public void setZtygukisisntnknnenknsnp(Long pZtygukisisntnknnenknsnp) {
        ztygukisisntnknnenknsnp = pZtygukisisntnknnenknsnp;
    }

    private String ztytnkntikhtnknkykymd;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTNKNTIKHTNKNKYKYMD)
    public String getZtytnkntikhtnknkykymd() {
        return ztytnkntikhtnknkykymd;
    }

    public void setZtytnkntikhtnknkykymd(String pZtytnkntikhtnknkykymd) {
        ztytnkntikhtnknkykymd = pZtytnkntikhtnknkykymd;
    }

    private BizNumber ztytenkangophireimuritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTENKANGOPHIREIMURITU)
    public BizNumber getZtytenkangophireimuritu() {
        return ztytenkangophireimuritu;
    }

    public void setZtytenkangophireimuritu(BizNumber pZtytenkangophireimuritu) {
        ztytenkangophireimuritu = pZtytenkangophireimuritu;
    }

    private Long ztygoukeitenkannenkansanp;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYGOUKEITENKANNENKANSANP)
    public Long getZtygoukeitenkannenkansanp() {
        return ztygoukeitenkannenkansanp;
    }

    public void setZtygoukeitenkannenkansanp(Long pZtygoukeitenkannenkansanp) {
        ztygoukeitenkannenkansanp = pZtygoukeitenkannenkansanp;
    }

    private Long ztygoukeitenkanteikimud;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYGOUKEITENKANTEIKIMUD)
    public Long getZtygoukeitenkanteikimud() {
        return ztygoukeitenkanteikimud;
    }

    public void setZtygoukeitenkanteikimud(Long pZtygoukeitenkanteikimud) {
        ztygoukeitenkanteikimud = pZtygoukeitenkanteikimud;
    }

    private Long ztytyoukikeizokutokubetud;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTYOUKIKEIZOKUTOKUBETUD)
    public Long getZtytyoukikeizokutokubetud() {
        return ztytyoukikeizokutokubetud;
    }

    public void setZtytyoukikeizokutokubetud(Long pZtytyoukikeizokutokubetud) {
        ztytyoukikeizokutokubetud = pZtytyoukikeizokutokubetud;
    }

    private Long ztytyouseimaed;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTYOUSEIMAED)
    public Long getZtytyouseimaed() {
        return ztytyouseimaed;
    }

    public void setZtytyouseimaed(Long pZtytyouseimaed) {
        ztytyouseimaed = pZtytyouseimaed;
    }

    private Long ztytuutokuhituusand;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTUUTOKUHITUUSAND)
    public Long getZtytuutokuhituusand() {
        return ztytuutokuhituusand;
    }

    public void setZtytuutokuhituusand(Long pZtytuutokuhituusand) {
        ztytuutokuhituusand = pZtytuutokuhituusand;
    }

    private String ztyhknsyuruikigousedaikbn;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYHKNSYURUIKIGOUSEDAIKBN)
    public String getZtyhknsyuruikigousedaikbn() {
        return ztyhknsyuruikigousedaikbn;
    }

    public void setZtyhknsyuruikigousedaikbn(String pZtyhknsyuruikigousedaikbn) {
        ztyhknsyuruikigousedaikbn = pZtyhknsyuruikigousedaikbn;
    }

    private String ztytenkanteikikigousedaikbn;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTENKANTEIKIKIGOUSEDAIKBN)
    public String getZtytenkanteikikigousedaikbn() {
        return ztytenkanteikikigousedaikbn;
    }

    public void setZtytenkanteikikigousedaikbn(String pZtytenkanteikikigousedaikbn) {
        ztytenkanteikikigousedaikbn = pZtytenkanteikikigousedaikbn;
    }

    private String ztyszoukigousedaikbn;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYSZOUKIGOUSEDAIKBN)
    public String getZtyszoukigousedaikbn() {
        return ztyszoukigousedaikbn;
    }

    public void setZtyszoukigousedaikbn(String pZtyszoukigousedaikbn) {
        ztyszoukigousedaikbn = pZtyszoukigousedaikbn;
    }

    private String ztymankihyouji;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYMANKIHYOUJI)
    public String getZtymankihyouji() {
        return ztymankihyouji;
    }

    public void setZtymankihyouji(String pZtymankihyouji) {
        ztymankihyouji = pZtymankihyouji;
    }

    private String ztykeiyakuoutoubikbn;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYKEIYAKUOUTOUBIKBN)
    public String getZtykeiyakuoutoubikbn() {
        return ztykeiyakuoutoubikbn;
    }

    public void setZtykeiyakuoutoubikbn(String pZtykeiyakuoutoubikbn) {
        ztykeiyakuoutoubikbn = pZtykeiyakuoutoubikbn;
    }

    private String ztysuuriyouyobin2;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYSUURIYOUYOBIN2)
    public String getZtysuuriyouyobin2() {
        return ztysuuriyouyobin2;
    }

    public void setZtysuuriyouyobin2(String pZtysuuriyouyobin2) {
        ztysuuriyouyobin2 = pZtysuuriyouyobin2;
    }

    private Integer ztytokuyakuhukasuu;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTOKUYAKUHUKASUU)
    public Integer getZtytokuyakuhukasuu() {
        return ztytokuyakuhukasuu;
    }

    public void setZtytokuyakuhukasuu(Integer pZtytokuyakuhukasuu) {
        ztytokuyakuhukasuu = pZtytokuyakuhukasuu;
    }

    private String ztyhokensyuruikigouyobi1x1;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYHOKENSYURUIKIGOUYOBI1X1)
    public String getZtyhokensyuruikigouyobi1x1() {
        return ztyhokensyuruikigouyobi1x1;
    }

    public void setZtyhokensyuruikigouyobi1x1(String pZtyhokensyuruikigouyobi1x1) {
        ztyhokensyuruikigouyobi1x1 = pZtyhokensyuruikigouyobi1x1;
    }

    private String ztyhokensyuruikigouyobi1x2;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYHOKENSYURUIKIGOUYOBI1X2)
    public String getZtyhokensyuruikigouyobi1x2() {
        return ztyhokensyuruikigouyobi1x2;
    }

    public void setZtyhokensyuruikigouyobi1x2(String pZtyhokensyuruikigouyobi1x2) {
        ztyhokensyuruikigouyobi1x2 = pZtyhokensyuruikigouyobi1x2;
    }

    private String ztyhokensyuruikigouyobi1x3;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYHOKENSYURUIKIGOUYOBI1X3)
    public String getZtyhokensyuruikigouyobi1x3() {
        return ztyhokensyuruikigouyobi1x3;
    }

    public void setZtyhokensyuruikigouyobi1x3(String pZtyhokensyuruikigouyobi1x3) {
        ztyhokensyuruikigouyobi1x3 = pZtyhokensyuruikigouyobi1x3;
    }

    private String ztyhokensyuruikigouyobi1x4;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYHOKENSYURUIKIGOUYOBI1X4)
    public String getZtyhokensyuruikigouyobi1x4() {
        return ztyhokensyuruikigouyobi1x4;
    }

    public void setZtyhokensyuruikigouyobi1x4(String pZtyhokensyuruikigouyobi1x4) {
        ztyhokensyuruikigouyobi1x4 = pZtyhokensyuruikigouyobi1x4;
    }

    private String ztyhokensyuruikigouyobi1x5;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYHOKENSYURUIKIGOUYOBI1X5)
    public String getZtyhokensyuruikigouyobi1x5() {
        return ztyhokensyuruikigouyobi1x5;
    }

    public void setZtyhokensyuruikigouyobi1x5(String pZtyhokensyuruikigouyobi1x5) {
        ztyhokensyuruikigouyobi1x5 = pZtyhokensyuruikigouyobi1x5;
    }

    private String ztyhokensyuruikigouyobi1x6;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYHOKENSYURUIKIGOUYOBI1X6)
    public String getZtyhokensyuruikigouyobi1x6() {
        return ztyhokensyuruikigouyobi1x6;
    }

    public void setZtyhokensyuruikigouyobi1x6(String pZtyhokensyuruikigouyobi1x6) {
        ztyhokensyuruikigouyobi1x6 = pZtyhokensyuruikigouyobi1x6;
    }

    private String ztyhokensyuruikigouyobi1x7;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYHOKENSYURUIKIGOUYOBI1X7)
    public String getZtyhokensyuruikigouyobi1x7() {
        return ztyhokensyuruikigouyobi1x7;
    }

    public void setZtyhokensyuruikigouyobi1x7(String pZtyhokensyuruikigouyobi1x7) {
        ztyhokensyuruikigouyobi1x7 = pZtyhokensyuruikigouyobi1x7;
    }

    private String ztyhokensyuruikigouyobi1x8;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYHOKENSYURUIKIGOUYOBI1X8)
    public String getZtyhokensyuruikigouyobi1x8() {
        return ztyhokensyuruikigouyobi1x8;
    }

    public void setZtyhokensyuruikigouyobi1x8(String pZtyhokensyuruikigouyobi1x8) {
        ztyhokensyuruikigouyobi1x8 = pZtyhokensyuruikigouyobi1x8;
    }

    private String ztyhokensyuruikigouyobi1x9;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYHOKENSYURUIKIGOUYOBI1X9)
    public String getZtyhokensyuruikigouyobi1x9() {
        return ztyhokensyuruikigouyobi1x9;
    }

    public void setZtyhokensyuruikigouyobi1x9(String pZtyhokensyuruikigouyobi1x9) {
        ztyhokensyuruikigouyobi1x9 = pZtyhokensyuruikigouyobi1x9;
    }

    private String ztyhokensyuruikigouyobi1x10;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYHOKENSYURUIKIGOUYOBI1X10)
    public String getZtyhokensyuruikigouyobi1x10() {
        return ztyhokensyuruikigouyobi1x10;
    }

    public void setZtyhokensyuruikigouyobi1x10(String pZtyhokensyuruikigouyobi1x10) {
        ztyhokensyuruikigouyobi1x10 = pZtyhokensyuruikigouyobi1x10;
    }

    private String ztyhokensyuruikigouyobi1x11;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYHOKENSYURUIKIGOUYOBI1X11)
    public String getZtyhokensyuruikigouyobi1x11() {
        return ztyhokensyuruikigouyobi1x11;
    }

    public void setZtyhokensyuruikigouyobi1x11(String pZtyhokensyuruikigouyobi1x11) {
        ztyhokensyuruikigouyobi1x11 = pZtyhokensyuruikigouyobi1x11;
    }

    private String ztyhokensyuruikigouyobi1x12;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYHOKENSYURUIKIGOUYOBI1X12)
    public String getZtyhokensyuruikigouyobi1x12() {
        return ztyhokensyuruikigouyobi1x12;
    }

    public void setZtyhokensyuruikigouyobi1x12(String pZtyhokensyuruikigouyobi1x12) {
        ztyhokensyuruikigouyobi1x12 = pZtyhokensyuruikigouyobi1x12;
    }

    private String ztyhokensyuruikigouyobi1x13;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYHOKENSYURUIKIGOUYOBI1X13)
    public String getZtyhokensyuruikigouyobi1x13() {
        return ztyhokensyuruikigouyobi1x13;
    }

    public void setZtyhokensyuruikigouyobi1x13(String pZtyhokensyuruikigouyobi1x13) {
        ztyhokensyuruikigouyobi1x13 = pZtyhokensyuruikigouyobi1x13;
    }

    private String ztyhokensyuruikigouyobi1x14;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYHOKENSYURUIKIGOUYOBI1X14)
    public String getZtyhokensyuruikigouyobi1x14() {
        return ztyhokensyuruikigouyobi1x14;
    }

    public void setZtyhokensyuruikigouyobi1x14(String pZtyhokensyuruikigouyobi1x14) {
        ztyhokensyuruikigouyobi1x14 = pZtyhokensyuruikigouyobi1x14;
    }

    private String ztyhokensyuruikigouyobi1x15;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYHOKENSYURUIKIGOUYOBI1X15)
    public String getZtyhokensyuruikigouyobi1x15() {
        return ztyhokensyuruikigouyobi1x15;
    }

    public void setZtyhokensyuruikigouyobi1x15(String pZtyhokensyuruikigouyobi1x15) {
        ztyhokensyuruikigouyobi1x15 = pZtyhokensyuruikigouyobi1x15;
    }

    private String ztyhokensyuruikigouyobi2x1;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYHOKENSYURUIKIGOUYOBI2X1)
    public String getZtyhokensyuruikigouyobi2x1() {
        return ztyhokensyuruikigouyobi2x1;
    }

    public void setZtyhokensyuruikigouyobi2x1(String pZtyhokensyuruikigouyobi2x1) {
        ztyhokensyuruikigouyobi2x1 = pZtyhokensyuruikigouyobi2x1;
    }

    private String ztyhokensyuruikigouyobi2x2;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYHOKENSYURUIKIGOUYOBI2X2)
    public String getZtyhokensyuruikigouyobi2x2() {
        return ztyhokensyuruikigouyobi2x2;
    }

    public void setZtyhokensyuruikigouyobi2x2(String pZtyhokensyuruikigouyobi2x2) {
        ztyhokensyuruikigouyobi2x2 = pZtyhokensyuruikigouyobi2x2;
    }

    private String ztyhokensyuruikigouyobi2x3;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYHOKENSYURUIKIGOUYOBI2X3)
    public String getZtyhokensyuruikigouyobi2x3() {
        return ztyhokensyuruikigouyobi2x3;
    }

    public void setZtyhokensyuruikigouyobi2x3(String pZtyhokensyuruikigouyobi2x3) {
        ztyhokensyuruikigouyobi2x3 = pZtyhokensyuruikigouyobi2x3;
    }

    private String ztyhokensyuruikigouyobi2x4;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYHOKENSYURUIKIGOUYOBI2X4)
    public String getZtyhokensyuruikigouyobi2x4() {
        return ztyhokensyuruikigouyobi2x4;
    }

    public void setZtyhokensyuruikigouyobi2x4(String pZtyhokensyuruikigouyobi2x4) {
        ztyhokensyuruikigouyobi2x4 = pZtyhokensyuruikigouyobi2x4;
    }

    private String ztyhokensyuruikigouyobi2x5;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYHOKENSYURUIKIGOUYOBI2X5)
    public String getZtyhokensyuruikigouyobi2x5() {
        return ztyhokensyuruikigouyobi2x5;
    }

    public void setZtyhokensyuruikigouyobi2x5(String pZtyhokensyuruikigouyobi2x5) {
        ztyhokensyuruikigouyobi2x5 = pZtyhokensyuruikigouyobi2x5;
    }

    private String ztyhokensyuruikigouyobi2x6;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYHOKENSYURUIKIGOUYOBI2X6)
    public String getZtyhokensyuruikigouyobi2x6() {
        return ztyhokensyuruikigouyobi2x6;
    }

    public void setZtyhokensyuruikigouyobi2x6(String pZtyhokensyuruikigouyobi2x6) {
        ztyhokensyuruikigouyobi2x6 = pZtyhokensyuruikigouyobi2x6;
    }

    private String ztyhokensyuruikigouyobi2x7;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYHOKENSYURUIKIGOUYOBI2X7)
    public String getZtyhokensyuruikigouyobi2x7() {
        return ztyhokensyuruikigouyobi2x7;
    }

    public void setZtyhokensyuruikigouyobi2x7(String pZtyhokensyuruikigouyobi2x7) {
        ztyhokensyuruikigouyobi2x7 = pZtyhokensyuruikigouyobi2x7;
    }

    private String ztyhokensyuruikigouyobi2x8;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYHOKENSYURUIKIGOUYOBI2X8)
    public String getZtyhokensyuruikigouyobi2x8() {
        return ztyhokensyuruikigouyobi2x8;
    }

    public void setZtyhokensyuruikigouyobi2x8(String pZtyhokensyuruikigouyobi2x8) {
        ztyhokensyuruikigouyobi2x8 = pZtyhokensyuruikigouyobi2x8;
    }

    private String ztyhokensyuruikigouyobi2x9;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYHOKENSYURUIKIGOUYOBI2X9)
    public String getZtyhokensyuruikigouyobi2x9() {
        return ztyhokensyuruikigouyobi2x9;
    }

    public void setZtyhokensyuruikigouyobi2x9(String pZtyhokensyuruikigouyobi2x9) {
        ztyhokensyuruikigouyobi2x9 = pZtyhokensyuruikigouyobi2x9;
    }

    private String ztyhokensyuruikigouyobi2x10;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYHOKENSYURUIKIGOUYOBI2X10)
    public String getZtyhokensyuruikigouyobi2x10() {
        return ztyhokensyuruikigouyobi2x10;
    }

    public void setZtyhokensyuruikigouyobi2x10(String pZtyhokensyuruikigouyobi2x10) {
        ztyhokensyuruikigouyobi2x10 = pZtyhokensyuruikigouyobi2x10;
    }

    private String ztyhokensyuruikigouyobi3x1;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYHOKENSYURUIKIGOUYOBI3X1)
    public String getZtyhokensyuruikigouyobi3x1() {
        return ztyhokensyuruikigouyobi3x1;
    }

    public void setZtyhokensyuruikigouyobi3x1(String pZtyhokensyuruikigouyobi3x1) {
        ztyhokensyuruikigouyobi3x1 = pZtyhokensyuruikigouyobi3x1;
    }

    private String ztyhokensyuruikigouyobi3x2;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYHOKENSYURUIKIGOUYOBI3X2)
    public String getZtyhokensyuruikigouyobi3x2() {
        return ztyhokensyuruikigouyobi3x2;
    }

    public void setZtyhokensyuruikigouyobi3x2(String pZtyhokensyuruikigouyobi3x2) {
        ztyhokensyuruikigouyobi3x2 = pZtyhokensyuruikigouyobi3x2;
    }

    private String ztyhokensyuruikigouyobi3x3;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYHOKENSYURUIKIGOUYOBI3X3)
    public String getZtyhokensyuruikigouyobi3x3() {
        return ztyhokensyuruikigouyobi3x3;
    }

    public void setZtyhokensyuruikigouyobi3x3(String pZtyhokensyuruikigouyobi3x3) {
        ztyhokensyuruikigouyobi3x3 = pZtyhokensyuruikigouyobi3x3;
    }

    private String ztyhokensyuruikigouyobi3x4;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYHOKENSYURUIKIGOUYOBI3X4)
    public String getZtyhokensyuruikigouyobi3x4() {
        return ztyhokensyuruikigouyobi3x4;
    }

    public void setZtyhokensyuruikigouyobi3x4(String pZtyhokensyuruikigouyobi3x4) {
        ztyhokensyuruikigouyobi3x4 = pZtyhokensyuruikigouyobi3x4;
    }

    private String ztyhokensyuruikigouyobi3x5;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYHOKENSYURUIKIGOUYOBI3X5)
    public String getZtyhokensyuruikigouyobi3x5() {
        return ztyhokensyuruikigouyobi3x5;
    }

    public void setZtyhokensyuruikigouyobi3x5(String pZtyhokensyuruikigouyobi3x5) {
        ztyhokensyuruikigouyobi3x5 = pZtyhokensyuruikigouyobi3x5;
    }

    private String ztyhokensyuruikigouyobi3x6;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYHOKENSYURUIKIGOUYOBI3X6)
    public String getZtyhokensyuruikigouyobi3x6() {
        return ztyhokensyuruikigouyobi3x6;
    }

    public void setZtyhokensyuruikigouyobi3x6(String pZtyhokensyuruikigouyobi3x6) {
        ztyhokensyuruikigouyobi3x6 = pZtyhokensyuruikigouyobi3x6;
    }

    private String ztyhokensyuruikigouyobi3x7;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYHOKENSYURUIKIGOUYOBI3X7)
    public String getZtyhokensyuruikigouyobi3x7() {
        return ztyhokensyuruikigouyobi3x7;
    }

    public void setZtyhokensyuruikigouyobi3x7(String pZtyhokensyuruikigouyobi3x7) {
        ztyhokensyuruikigouyobi3x7 = pZtyhokensyuruikigouyobi3x7;
    }

    private String ztyhokensyuruikigouyobi3x8;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYHOKENSYURUIKIGOUYOBI3X8)
    public String getZtyhokensyuruikigouyobi3x8() {
        return ztyhokensyuruikigouyobi3x8;
    }

    public void setZtyhokensyuruikigouyobi3x8(String pZtyhokensyuruikigouyobi3x8) {
        ztyhokensyuruikigouyobi3x8 = pZtyhokensyuruikigouyobi3x8;
    }

    private String ztyhokensyuruikigouyobi3x9;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYHOKENSYURUIKIGOUYOBI3X9)
    public String getZtyhokensyuruikigouyobi3x9() {
        return ztyhokensyuruikigouyobi3x9;
    }

    public void setZtyhokensyuruikigouyobi3x9(String pZtyhokensyuruikigouyobi3x9) {
        ztyhokensyuruikigouyobi3x9 = pZtyhokensyuruikigouyobi3x9;
    }

    private String ztyhokensyuruikigouyobi3x10;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYHOKENSYURUIKIGOUYOBI3X10)
    public String getZtyhokensyuruikigouyobi3x10() {
        return ztyhokensyuruikigouyobi3x10;
    }

    public void setZtyhokensyuruikigouyobi3x10(String pZtyhokensyuruikigouyobi3x10) {
        ztyhokensyuruikigouyobi3x10 = pZtyhokensyuruikigouyobi3x10;
    }

    private String ztytenkanteikikigouyobix1;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTENKANTEIKIKIGOUYOBIX1)
    public String getZtytenkanteikikigouyobix1() {
        return ztytenkanteikikigouyobix1;
    }

    public void setZtytenkanteikikigouyobix1(String pZtytenkanteikikigouyobix1) {
        ztytenkanteikikigouyobix1 = pZtytenkanteikikigouyobix1;
    }

    private String ztytenkanteikikigouyobix2;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTENKANTEIKIKIGOUYOBIX2)
    public String getZtytenkanteikikigouyobix2() {
        return ztytenkanteikikigouyobix2;
    }

    public void setZtytenkanteikikigouyobix2(String pZtytenkanteikikigouyobix2) {
        ztytenkanteikikigouyobix2 = pZtytenkanteikikigouyobix2;
    }

    private String ztytenkanteikikigouyobix3;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTENKANTEIKIKIGOUYOBIX3)
    public String getZtytenkanteikikigouyobix3() {
        return ztytenkanteikikigouyobix3;
    }

    public void setZtytenkanteikikigouyobix3(String pZtytenkanteikikigouyobix3) {
        ztytenkanteikikigouyobix3 = pZtytenkanteikikigouyobix3;
    }

    private String ztytenkanteikikigouyobix4;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTENKANTEIKIKIGOUYOBIX4)
    public String getZtytenkanteikikigouyobix4() {
        return ztytenkanteikikigouyobix4;
    }

    public void setZtytenkanteikikigouyobix4(String pZtytenkanteikikigouyobix4) {
        ztytenkanteikikigouyobix4 = pZtytenkanteikikigouyobix4;
    }

    private String ztytenkanteikikigouyobix5;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTENKANTEIKIKIGOUYOBIX5)
    public String getZtytenkanteikikigouyobix5() {
        return ztytenkanteikikigouyobix5;
    }

    public void setZtytenkanteikikigouyobix5(String pZtytenkanteikikigouyobix5) {
        ztytenkanteikikigouyobix5 = pZtytenkanteikikigouyobix5;
    }

    private String ztykakuteikakusakgusdkbn;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYKAKUTEIKAKUSAKGUSDKBN)
    public String getZtykakuteikakusakgusdkbn() {
        return ztykakuteikakusakgusdkbn;
    }

    public void setZtykakuteikakusakgusdkbn(String pZtykakuteikakusakgusdkbn) {
        ztykakuteikakusakgusdkbn = pZtykakuteikakusakgusdkbn;
    }

    private String ztykakuteikakusakguybx1;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYKAKUTEIKAKUSAKGUYBX1)
    public String getZtykakuteikakusakguybx1() {
        return ztykakuteikakusakguybx1;
    }

    public void setZtykakuteikakusakguybx1(String pZtykakuteikakusakguybx1) {
        ztykakuteikakusakguybx1 = pZtykakuteikakusakguybx1;
    }

    private String ztykakuteikakusakguybx2;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYKAKUTEIKAKUSAKGUYBX2)
    public String getZtykakuteikakusakguybx2() {
        return ztykakuteikakusakguybx2;
    }

    public void setZtykakuteikakusakguybx2(String pZtykakuteikakusakguybx2) {
        ztykakuteikakusakguybx2 = pZtykakuteikakusakguybx2;
    }

    private String ztykakuteikakusakguybx3;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYKAKUTEIKAKUSAKGUYBX3)
    public String getZtykakuteikakusakguybx3() {
        return ztykakuteikakusakguybx3;
    }

    public void setZtykakuteikakusakguybx3(String pZtykakuteikakusakguybx3) {
        ztykakuteikakusakguybx3 = pZtykakuteikakusakguybx3;
    }

    private String ztykakuteikakusakguybx4;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYKAKUTEIKAKUSAKGUYBX4)
    public String getZtykakuteikakusakguybx4() {
        return ztykakuteikakusakguybx4;
    }

    public void setZtykakuteikakusakguybx4(String pZtykakuteikakusakguybx4) {
        ztykakuteikakusakguybx4 = pZtykakuteikakusakguybx4;
    }

    private String ztykakuteikakusakguybx5;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYKAKUTEIKAKUSAKGUYBX5)
    public String getZtykakuteikakusakguybx5() {
        return ztykakuteikakusakguybx5;
    }

    public void setZtykakuteikakusakguybx5(String pZtykakuteikakusakguybx5) {
        ztykakuteikakusakguybx5 = pZtykakuteikakusakguybx5;
    }

    private String ztynaizoumarusakgusdkbn;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYNAIZOUMARUSAKGUSDKBN)
    public String getZtynaizoumarusakgusdkbn() {
        return ztynaizoumarusakgusdkbn;
    }

    public void setZtynaizoumarusakgusdkbn(String pZtynaizoumarusakgusdkbn) {
        ztynaizoumarusakgusdkbn = pZtynaizoumarusakgusdkbn;
    }

    private String ztynaizoumarusakigouyobix1;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYNAIZOUMARUSAKIGOUYOBIX1)
    public String getZtynaizoumarusakigouyobix1() {
        return ztynaizoumarusakigouyobix1;
    }

    public void setZtynaizoumarusakigouyobix1(String pZtynaizoumarusakigouyobix1) {
        ztynaizoumarusakigouyobix1 = pZtynaizoumarusakigouyobix1;
    }

    private String ztynaizoumarusakigouyobix2;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYNAIZOUMARUSAKIGOUYOBIX2)
    public String getZtynaizoumarusakigouyobix2() {
        return ztynaizoumarusakigouyobix2;
    }

    public void setZtynaizoumarusakigouyobix2(String pZtynaizoumarusakigouyobix2) {
        ztynaizoumarusakigouyobix2 = pZtynaizoumarusakigouyobix2;
    }

    private String ztynaizoumarusakigouyobix3;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYNAIZOUMARUSAKIGOUYOBIX3)
    public String getZtynaizoumarusakigouyobix3() {
        return ztynaizoumarusakigouyobix3;
    }

    public void setZtynaizoumarusakigouyobix3(String pZtynaizoumarusakigouyobix3) {
        ztynaizoumarusakigouyobix3 = pZtynaizoumarusakigouyobix3;
    }

    private String ztynaizoumarusakigouyobix4;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYNAIZOUMARUSAKIGOUYOBIX4)
    public String getZtynaizoumarusakigouyobix4() {
        return ztynaizoumarusakigouyobix4;
    }

    public void setZtynaizoumarusakigouyobix4(String pZtynaizoumarusakigouyobix4) {
        ztynaizoumarusakigouyobix4 = pZtynaizoumarusakigouyobix4;
    }

    private String ztynaizoumarusakigouyobix5;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYNAIZOUMARUSAKIGOUYOBIX5)
    public String getZtynaizoumarusakigouyobix5() {
        return ztynaizoumarusakigouyobix5;
    }

    public void setZtynaizoumarusakigouyobix5(String pZtynaizoumarusakigouyobix5) {
        ztynaizoumarusakigouyobix5 = pZtynaizoumarusakigouyobix5;
    }

    private String ztynaizoukakusakgusdkbn;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYNAIZOUKAKUSAKGUSDKBN)
    public String getZtynaizoukakusakgusdkbn() {
        return ztynaizoukakusakgusdkbn;
    }

    public void setZtynaizoukakusakgusdkbn(String pZtynaizoukakusakgusdkbn) {
        ztynaizoukakusakgusdkbn = pZtynaizoukakusakgusdkbn;
    }

    private String ztynaizoukakusakigouyobix1;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYNAIZOUKAKUSAKIGOUYOBIX1)
    public String getZtynaizoukakusakigouyobix1() {
        return ztynaizoukakusakigouyobix1;
    }

    public void setZtynaizoukakusakigouyobix1(String pZtynaizoukakusakigouyobix1) {
        ztynaizoukakusakigouyobix1 = pZtynaizoukakusakigouyobix1;
    }

    private String ztynaizoukakusakigouyobix2;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYNAIZOUKAKUSAKIGOUYOBIX2)
    public String getZtynaizoukakusakigouyobix2() {
        return ztynaizoukakusakigouyobix2;
    }

    public void setZtynaizoukakusakigouyobix2(String pZtynaizoukakusakigouyobix2) {
        ztynaizoukakusakigouyobix2 = pZtynaizoukakusakigouyobix2;
    }

    private String ztynaizoukakusakigouyobix3;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYNAIZOUKAKUSAKIGOUYOBIX3)
    public String getZtynaizoukakusakigouyobix3() {
        return ztynaizoukakusakigouyobix3;
    }

    public void setZtynaizoukakusakigouyobix3(String pZtynaizoukakusakigouyobix3) {
        ztynaizoukakusakigouyobix3 = pZtynaizoukakusakigouyobix3;
    }

    private String ztynaizoukakusakigouyobix4;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYNAIZOUKAKUSAKIGOUYOBIX4)
    public String getZtynaizoukakusakigouyobix4() {
        return ztynaizoukakusakigouyobix4;
    }

    public void setZtynaizoukakusakigouyobix4(String pZtynaizoukakusakigouyobix4) {
        ztynaizoukakusakigouyobix4 = pZtynaizoukakusakigouyobix4;
    }

    private String ztynaizoukakusakigouyobix5;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYNAIZOUKAKUSAKIGOUYOBIX5)
    public String getZtynaizoukakusakigouyobix5() {
        return ztynaizoukakusakigouyobix5;
    }

    public void setZtynaizoukakusakigouyobix5(String pZtynaizoukakusakigouyobix5) {
        ztynaizoukakusakigouyobix5 = pZtynaizoukakusakigouyobix5;
    }

    private String ztyyobiv92;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYYOBIV92)
    public String getZtyyobiv92() {
        return ztyyobiv92;
    }

    public void setZtyyobiv92(String pZtyyobiv92) {
        ztyyobiv92 = pZtyyobiv92;
    }

    private String ztyraysystemhyj;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYRAYSYSTEMHYJ)
    public String getZtyraysystemhyj() {
        return ztyraysystemhyj;
    }

    public void setZtyraysystemhyj(String pZtyraysystemhyj) {
        ztyraysystemhyj = pZtyraysystemhyj;
    }

    private String ztygaikakbn;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYGAIKAKBN)
    public String getZtygaikakbn() {
        return ztygaikakbn;
    }

    public void setZtygaikakbn(String pZtygaikakbn) {
        ztygaikakbn = pZtygaikakbn;
    }

    private BizNumber ztykawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYKAWASERATE)
    public BizNumber getZtykawaserate() {
        return ztykawaserate;
    }

    public void setZtykawaserate(BizNumber pZtykawaserate) {
        ztykawaserate = pZtykawaserate;
    }

    private String ztykawaseratetekiyouymd;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYKAWASERATETEKIYOUYMD)
    public String getZtykawaseratetekiyouymd() {
        return ztykawaseratetekiyouymd;
    }

    public void setZtykawaseratetekiyouymd(String pZtykawaseratetekiyouymd) {
        ztykawaseratetekiyouymd = pZtykawaseratetekiyouymd;
    }

    private Long ztyenkdtsbujsitihsyukngk;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYENKDTSBUJSITIHSYUKNGK)
    public Long getZtyenkdtsbujsitihsyukngk() {
        return ztyenkdtsbujsitihsyukngk;
    }

    public void setZtyenkdtsbujsitihsyukngk(Long pZtyenkdtsbujsitihsyukngk) {
        ztyenkdtsbujsitihsyukngk = pZtyenkdtsbujsitihsyukngk;
    }

    private String ztysuuriyouyobin10;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYSUURIYOUYOBIN10)
    public String getZtysuuriyouyobin10() {
        return ztysuuriyouyobin10;
    }

    public void setZtysuuriyouyobin10(String pZtysuuriyouyobin10) {
        ztysuuriyouyobin10 = pZtysuuriyouyobin10;
    }

    private String ztyyobiv10x2;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYYOBIV10X2)
    public String getZtyyobiv10x2() {
        return ztyyobiv10x2;
    }

    public void setZtyyobiv10x2(String pZtyyobiv10x2) {
        ztyyobiv10x2 = pZtyyobiv10x2;
    }

    private Long ztyyobin11;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYYOBIN11)
    public Long getZtyyobin11() {
        return ztyyobin11;
    }

    public void setZtyyobin11(Long pZtyyobin11) {
        ztyyobin11 = pZtyyobin11;
    }

    private Long ztyyobin11x2;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYYOBIN11X2)
    public Long getZtyyobin11x2() {
        return ztyyobin11x2;
    }

    public void setZtyyobin11x2(Long pZtyyobin11x2) {
        ztyyobin11x2 = pZtyyobin11x2;
    }

    private String ztyyobiv17;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYYOBIV17)
    public String getZtyyobiv17() {
        return ztyyobiv17;
    }

    public void setZtyyobiv17(String pZtyyobiv17) {
        ztyyobiv17 = pZtyyobiv17;
    }

    private BizNumber ztysisadrate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYSISADRATE)
    public BizNumber getZtysisadrate() {
        return ztysisadrate;
    }

    public void setZtysisadrate(BizNumber pZtysisadrate) {
        ztysisadrate = pZtysisadrate;
    }

    private BizNumber ztyrisadrate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYRISADRATE)
    public BizNumber getZtyrisadrate() {
        return ztyrisadrate;
    }

    public void setZtyrisadrate(BizNumber pZtyrisadrate) {
        ztyrisadrate = pZtyrisadrate;
    }

    private BizNumber ztyhisadrate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYHISADRATE)
    public BizNumber getZtyhisadrate() {
        return ztyhisadrate;
    }

    public void setZtyhisadrate(BizNumber pZtyhisadrate) {
        ztyhisadrate = pZtyhisadrate;
    }

    private BizNumber ztydyouvrate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYDYOUVRATE)
    public BizNumber getZtydyouvrate() {
        return ztydyouvrate;
    }

    public void setZtydyouvrate(BizNumber pZtydyouvrate) {
        ztydyouvrate = pZtydyouvrate;
    }

    private BizNumber ztykikensrate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYKIKENSRATE)
    public BizNumber getZtykikensrate() {
        return ztykikensrate;
    }

    public void setZtykikensrate(BizNumber pZtykikensrate) {
        ztykikensrate = pZtykikensrate;
    }

    private BizNumber ztygoukeidrate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYGOUKEIDRATE)
    public BizNumber getZtygoukeidrate() {
        return ztygoukeidrate;
    }

    public void setZtygoukeidrate(BizNumber pZtygoukeidrate) {
        ztygoukeidrate = pZtygoukeidrate;
    }

    private String ztytokuyakukoumokuv180;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTOKUYAKUKOUMOKUV180)
    public String getZtytokuyakukoumokuv180() {
        return ztytokuyakukoumokuv180;
    }

    public void setZtytokuyakukoumokuv180(String pZtytokuyakukoumokuv180) {
        ztytokuyakukoumokuv180 = pZtytokuyakukoumokuv180;
    }

    private String ztytokuyakukoumokuv180x2;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTOKUYAKUKOUMOKUV180X2)
    public String getZtytokuyakukoumokuv180x2() {
        return ztytokuyakukoumokuv180x2;
    }

    public void setZtytokuyakukoumokuv180x2(String pZtytokuyakukoumokuv180x2) {
        ztytokuyakukoumokuv180x2 = pZtytokuyakukoumokuv180x2;
    }

    private String ztytokuyakukoumokuv180x3;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTOKUYAKUKOUMOKUV180X3)
    public String getZtytokuyakukoumokuv180x3() {
        return ztytokuyakukoumokuv180x3;
    }

    public void setZtytokuyakukoumokuv180x3(String pZtytokuyakukoumokuv180x3) {
        ztytokuyakukoumokuv180x3 = pZtytokuyakukoumokuv180x3;
    }

    private String ztytokuyakukoumokuv180x4;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTOKUYAKUKOUMOKUV180X4)
    public String getZtytokuyakukoumokuv180x4() {
        return ztytokuyakukoumokuv180x4;
    }

    public void setZtytokuyakukoumokuv180x4(String pZtytokuyakukoumokuv180x4) {
        ztytokuyakukoumokuv180x4 = pZtytokuyakukoumokuv180x4;
    }

    private String ztytokuyakukoumokuv180x5;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTOKUYAKUKOUMOKUV180X5)
    public String getZtytokuyakukoumokuv180x5() {
        return ztytokuyakukoumokuv180x5;
    }

    public void setZtytokuyakukoumokuv180x5(String pZtytokuyakukoumokuv180x5) {
        ztytokuyakukoumokuv180x5 = pZtytokuyakukoumokuv180x5;
    }

    private String ztytokuyakukoumokuv180x6;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTOKUYAKUKOUMOKUV180X6)
    public String getZtytokuyakukoumokuv180x6() {
        return ztytokuyakukoumokuv180x6;
    }

    public void setZtytokuyakukoumokuv180x6(String pZtytokuyakukoumokuv180x6) {
        ztytokuyakukoumokuv180x6 = pZtytokuyakukoumokuv180x6;
    }

    private String ztytokuyakukoumokuv180x7;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTOKUYAKUKOUMOKUV180X7)
    public String getZtytokuyakukoumokuv180x7() {
        return ztytokuyakukoumokuv180x7;
    }

    public void setZtytokuyakukoumokuv180x7(String pZtytokuyakukoumokuv180x7) {
        ztytokuyakukoumokuv180x7 = pZtytokuyakukoumokuv180x7;
    }

    private String ztytokuyakukoumokuv180x8;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTOKUYAKUKOUMOKUV180X8)
    public String getZtytokuyakukoumokuv180x8() {
        return ztytokuyakukoumokuv180x8;
    }

    public void setZtytokuyakukoumokuv180x8(String pZtytokuyakukoumokuv180x8) {
        ztytokuyakukoumokuv180x8 = pZtytokuyakukoumokuv180x8;
    }

    private String ztytokuyakukoumokuv180x9;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTOKUYAKUKOUMOKUV180X9)
    public String getZtytokuyakukoumokuv180x9() {
        return ztytokuyakukoumokuv180x9;
    }

    public void setZtytokuyakukoumokuv180x9(String pZtytokuyakukoumokuv180x9) {
        ztytokuyakukoumokuv180x9 = pZtytokuyakukoumokuv180x9;
    }

    private String ztytokuyakukoumokuv180x10;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTOKUYAKUKOUMOKUV180X10)
    public String getZtytokuyakukoumokuv180x10() {
        return ztytokuyakukoumokuv180x10;
    }

    public void setZtytokuyakukoumokuv180x10(String pZtytokuyakukoumokuv180x10) {
        ztytokuyakukoumokuv180x10 = pZtytokuyakukoumokuv180x10;
    }

    private String ztytokuyakukoumokuv180x11;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTOKUYAKUKOUMOKUV180X11)
    public String getZtytokuyakukoumokuv180x11() {
        return ztytokuyakukoumokuv180x11;
    }

    public void setZtytokuyakukoumokuv180x11(String pZtytokuyakukoumokuv180x11) {
        ztytokuyakukoumokuv180x11 = pZtytokuyakukoumokuv180x11;
    }

    private String ztytokuyakukoumokuv180x12;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTOKUYAKUKOUMOKUV180X12)
    public String getZtytokuyakukoumokuv180x12() {
        return ztytokuyakukoumokuv180x12;
    }

    public void setZtytokuyakukoumokuv180x12(String pZtytokuyakukoumokuv180x12) {
        ztytokuyakukoumokuv180x12 = pZtytokuyakukoumokuv180x12;
    }

    private String ztytokuyakukoumokuv180x13;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTOKUYAKUKOUMOKUV180X13)
    public String getZtytokuyakukoumokuv180x13() {
        return ztytokuyakukoumokuv180x13;
    }

    public void setZtytokuyakukoumokuv180x13(String pZtytokuyakukoumokuv180x13) {
        ztytokuyakukoumokuv180x13 = pZtytokuyakukoumokuv180x13;
    }

    private String ztytokuyakukoumokuv180x14;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTOKUYAKUKOUMOKUV180X14)
    public String getZtytokuyakukoumokuv180x14() {
        return ztytokuyakukoumokuv180x14;
    }

    public void setZtytokuyakukoumokuv180x14(String pZtytokuyakukoumokuv180x14) {
        ztytokuyakukoumokuv180x14 = pZtytokuyakukoumokuv180x14;
    }

    private String ztytokuyakukoumokuv180x15;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTOKUYAKUKOUMOKUV180X15)
    public String getZtytokuyakukoumokuv180x15() {
        return ztytokuyakukoumokuv180x15;
    }

    public void setZtytokuyakukoumokuv180x15(String pZtytokuyakukoumokuv180x15) {
        ztytokuyakukoumokuv180x15 = pZtytokuyakukoumokuv180x15;
    }

    private String ztytokuyakukoumokuv180x16;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTOKUYAKUKOUMOKUV180X16)
    public String getZtytokuyakukoumokuv180x16() {
        return ztytokuyakukoumokuv180x16;
    }

    public void setZtytokuyakukoumokuv180x16(String pZtytokuyakukoumokuv180x16) {
        ztytokuyakukoumokuv180x16 = pZtytokuyakukoumokuv180x16;
    }

    private String ztytokuyakukoumokuv180x17;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTOKUYAKUKOUMOKUV180X17)
    public String getZtytokuyakukoumokuv180x17() {
        return ztytokuyakukoumokuv180x17;
    }

    public void setZtytokuyakukoumokuv180x17(String pZtytokuyakukoumokuv180x17) {
        ztytokuyakukoumokuv180x17 = pZtytokuyakukoumokuv180x17;
    }

    private String ztytokuyakukoumokuv180x18;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTOKUYAKUKOUMOKUV180X18)
    public String getZtytokuyakukoumokuv180x18() {
        return ztytokuyakukoumokuv180x18;
    }

    public void setZtytokuyakukoumokuv180x18(String pZtytokuyakukoumokuv180x18) {
        ztytokuyakukoumokuv180x18 = pZtytokuyakukoumokuv180x18;
    }

    private String ztytokuyakukoumokuv180x19;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTOKUYAKUKOUMOKUV180X19)
    public String getZtytokuyakukoumokuv180x19() {
        return ztytokuyakukoumokuv180x19;
    }

    public void setZtytokuyakukoumokuv180x19(String pZtytokuyakukoumokuv180x19) {
        ztytokuyakukoumokuv180x19 = pZtytokuyakukoumokuv180x19;
    }

    private String ztytokuyakukoumokuv180x20;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTOKUYAKUKOUMOKUV180X20)
    public String getZtytokuyakukoumokuv180x20() {
        return ztytokuyakukoumokuv180x20;
    }

    public void setZtytokuyakukoumokuv180x20(String pZtytokuyakukoumokuv180x20) {
        ztytokuyakukoumokuv180x20 = pZtytokuyakukoumokuv180x20;
    }

    private String ztytokuyakukoumokuv180x21;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTOKUYAKUKOUMOKUV180X21)
    public String getZtytokuyakukoumokuv180x21() {
        return ztytokuyakukoumokuv180x21;
    }

    public void setZtytokuyakukoumokuv180x21(String pZtytokuyakukoumokuv180x21) {
        ztytokuyakukoumokuv180x21 = pZtytokuyakukoumokuv180x21;
    }

    private String ztytokuyakukoumokuv180x22;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTOKUYAKUKOUMOKUV180X22)
    public String getZtytokuyakukoumokuv180x22() {
        return ztytokuyakukoumokuv180x22;
    }

    public void setZtytokuyakukoumokuv180x22(String pZtytokuyakukoumokuv180x22) {
        ztytokuyakukoumokuv180x22 = pZtytokuyakukoumokuv180x22;
    }

    private String ztytokuyakukoumokuv180x23;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTOKUYAKUKOUMOKUV180X23)
    public String getZtytokuyakukoumokuv180x23() {
        return ztytokuyakukoumokuv180x23;
    }

    public void setZtytokuyakukoumokuv180x23(String pZtytokuyakukoumokuv180x23) {
        ztytokuyakukoumokuv180x23 = pZtytokuyakukoumokuv180x23;
    }

    private String ztytokuyakukoumokuv180x24;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTOKUYAKUKOUMOKUV180X24)
    public String getZtytokuyakukoumokuv180x24() {
        return ztytokuyakukoumokuv180x24;
    }

    public void setZtytokuyakukoumokuv180x24(String pZtytokuyakukoumokuv180x24) {
        ztytokuyakukoumokuv180x24 = pZtytokuyakukoumokuv180x24;
    }

    private String ztytokuyakukoumokuv180x25;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTOKUYAKUKOUMOKUV180X25)
    public String getZtytokuyakukoumokuv180x25() {
        return ztytokuyakukoumokuv180x25;
    }

    public void setZtytokuyakukoumokuv180x25(String pZtytokuyakukoumokuv180x25) {
        ztytokuyakukoumokuv180x25 = pZtytokuyakukoumokuv180x25;
    }

    private String ztytokuyakukoumokuv180x26;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTOKUYAKUKOUMOKUV180X26)
    public String getZtytokuyakukoumokuv180x26() {
        return ztytokuyakukoumokuv180x26;
    }

    public void setZtytokuyakukoumokuv180x26(String pZtytokuyakukoumokuv180x26) {
        ztytokuyakukoumokuv180x26 = pZtytokuyakukoumokuv180x26;
    }

    private String ztytokuyakukoumokuv180x27;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTOKUYAKUKOUMOKUV180X27)
    public String getZtytokuyakukoumokuv180x27() {
        return ztytokuyakukoumokuv180x27;
    }

    public void setZtytokuyakukoumokuv180x27(String pZtytokuyakukoumokuv180x27) {
        ztytokuyakukoumokuv180x27 = pZtytokuyakukoumokuv180x27;
    }

    private String ztytokuyakukoumokuv180x28;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTOKUYAKUKOUMOKUV180X28)
    public String getZtytokuyakukoumokuv180x28() {
        return ztytokuyakukoumokuv180x28;
    }

    public void setZtytokuyakukoumokuv180x28(String pZtytokuyakukoumokuv180x28) {
        ztytokuyakukoumokuv180x28 = pZtytokuyakukoumokuv180x28;
    }

    private String ztytokuyakukoumokuv180x29;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTOKUYAKUKOUMOKUV180X29)
    public String getZtytokuyakukoumokuv180x29() {
        return ztytokuyakukoumokuv180x29;
    }

    public void setZtytokuyakukoumokuv180x29(String pZtytokuyakukoumokuv180x29) {
        ztytokuyakukoumokuv180x29 = pZtytokuyakukoumokuv180x29;
    }

    private String ztytokuyakukoumokuv180x30;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTOKUYAKUKOUMOKUV180X30)
    public String getZtytokuyakukoumokuv180x30() {
        return ztytokuyakukoumokuv180x30;
    }

    public void setZtytokuyakukoumokuv180x30(String pZtytokuyakukoumokuv180x30) {
        ztytokuyakukoumokuv180x30 = pZtytokuyakukoumokuv180x30;
    }

    private String ztytokuyakukoumokuv180x31;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTOKUYAKUKOUMOKUV180X31)
    public String getZtytokuyakukoumokuv180x31() {
        return ztytokuyakukoumokuv180x31;
    }

    public void setZtytokuyakukoumokuv180x31(String pZtytokuyakukoumokuv180x31) {
        ztytokuyakukoumokuv180x31 = pZtytokuyakukoumokuv180x31;
    }

    private String ztytokuyakukoumokuv180x32;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTOKUYAKUKOUMOKUV180X32)
    public String getZtytokuyakukoumokuv180x32() {
        return ztytokuyakukoumokuv180x32;
    }

    public void setZtytokuyakukoumokuv180x32(String pZtytokuyakukoumokuv180x32) {
        ztytokuyakukoumokuv180x32 = pZtytokuyakukoumokuv180x32;
    }

    private String ztytokuyakukoumokuv180x33;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTOKUYAKUKOUMOKUV180X33)
    public String getZtytokuyakukoumokuv180x33() {
        return ztytokuyakukoumokuv180x33;
    }

    public void setZtytokuyakukoumokuv180x33(String pZtytokuyakukoumokuv180x33) {
        ztytokuyakukoumokuv180x33 = pZtytokuyakukoumokuv180x33;
    }

    private String ztytokuyakukoumokuv180x34;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTOKUYAKUKOUMOKUV180X34)
    public String getZtytokuyakukoumokuv180x34() {
        return ztytokuyakukoumokuv180x34;
    }

    public void setZtytokuyakukoumokuv180x34(String pZtytokuyakukoumokuv180x34) {
        ztytokuyakukoumokuv180x34 = pZtytokuyakukoumokuv180x34;
    }

    private String ztytokuyakukoumokuv180x35;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTOKUYAKUKOUMOKUV180X35)
    public String getZtytokuyakukoumokuv180x35() {
        return ztytokuyakukoumokuv180x35;
    }

    public void setZtytokuyakukoumokuv180x35(String pZtytokuyakukoumokuv180x35) {
        ztytokuyakukoumokuv180x35 = pZtytokuyakukoumokuv180x35;
    }

    private String ztytokuyakukoumokuv180x36;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTOKUYAKUKOUMOKUV180X36)
    public String getZtytokuyakukoumokuv180x36() {
        return ztytokuyakukoumokuv180x36;
    }

    public void setZtytokuyakukoumokuv180x36(String pZtytokuyakukoumokuv180x36) {
        ztytokuyakukoumokuv180x36 = pZtytokuyakukoumokuv180x36;
    }

    private String ztytokuyakukoumokuv180x37;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTOKUYAKUKOUMOKUV180X37)
    public String getZtytokuyakukoumokuv180x37() {
        return ztytokuyakukoumokuv180x37;
    }

    public void setZtytokuyakukoumokuv180x37(String pZtytokuyakukoumokuv180x37) {
        ztytokuyakukoumokuv180x37 = pZtytokuyakukoumokuv180x37;
    }

    private String ztytokuyakukoumokuv180x38;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTOKUYAKUKOUMOKUV180X38)
    public String getZtytokuyakukoumokuv180x38() {
        return ztytokuyakukoumokuv180x38;
    }

    public void setZtytokuyakukoumokuv180x38(String pZtytokuyakukoumokuv180x38) {
        ztytokuyakukoumokuv180x38 = pZtytokuyakukoumokuv180x38;
    }

    private String ztytokuyakukoumokuv180x39;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTOKUYAKUKOUMOKUV180X39)
    public String getZtytokuyakukoumokuv180x39() {
        return ztytokuyakukoumokuv180x39;
    }

    public void setZtytokuyakukoumokuv180x39(String pZtytokuyakukoumokuv180x39) {
        ztytokuyakukoumokuv180x39 = pZtytokuyakukoumokuv180x39;
    }

    private String ztytokuyakukoumokuv180x40;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTOKUYAKUKOUMOKUV180X40)
    public String getZtytokuyakukoumokuv180x40() {
        return ztytokuyakukoumokuv180x40;
    }

    public void setZtytokuyakukoumokuv180x40(String pZtytokuyakukoumokuv180x40) {
        ztytokuyakukoumokuv180x40 = pZtytokuyakukoumokuv180x40;
    }

    private String ztytokuyakukoumokuv180x41;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTOKUYAKUKOUMOKUV180X41)
    public String getZtytokuyakukoumokuv180x41() {
        return ztytokuyakukoumokuv180x41;
    }

    public void setZtytokuyakukoumokuv180x41(String pZtytokuyakukoumokuv180x41) {
        ztytokuyakukoumokuv180x41 = pZtytokuyakukoumokuv180x41;
    }

    private String ztytokuyakukoumokuv180x42;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTOKUYAKUKOUMOKUV180X42)
    public String getZtytokuyakukoumokuv180x42() {
        return ztytokuyakukoumokuv180x42;
    }

    public void setZtytokuyakukoumokuv180x42(String pZtytokuyakukoumokuv180x42) {
        ztytokuyakukoumokuv180x42 = pZtytokuyakukoumokuv180x42;
    }

    private String ztytokuyakukoumokuv180x43;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTOKUYAKUKOUMOKUV180X43)
    public String getZtytokuyakukoumokuv180x43() {
        return ztytokuyakukoumokuv180x43;
    }

    public void setZtytokuyakukoumokuv180x43(String pZtytokuyakukoumokuv180x43) {
        ztytokuyakukoumokuv180x43 = pZtytokuyakukoumokuv180x43;
    }

    private String ztytokuyakukoumokuv180x44;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTOKUYAKUKOUMOKUV180X44)
    public String getZtytokuyakukoumokuv180x44() {
        return ztytokuyakukoumokuv180x44;
    }

    public void setZtytokuyakukoumokuv180x44(String pZtytokuyakukoumokuv180x44) {
        ztytokuyakukoumokuv180x44 = pZtytokuyakukoumokuv180x44;
    }

    private String ztytokuyakukoumokuv180x45;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTOKUYAKUKOUMOKUV180X45)
    public String getZtytokuyakukoumokuv180x45() {
        return ztytokuyakukoumokuv180x45;
    }

    public void setZtytokuyakukoumokuv180x45(String pZtytokuyakukoumokuv180x45) {
        ztytokuyakukoumokuv180x45 = pZtytokuyakukoumokuv180x45;
    }

    private String ztytokuyakukoumokuv180x46;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTOKUYAKUKOUMOKUV180X46)
    public String getZtytokuyakukoumokuv180x46() {
        return ztytokuyakukoumokuv180x46;
    }

    public void setZtytokuyakukoumokuv180x46(String pZtytokuyakukoumokuv180x46) {
        ztytokuyakukoumokuv180x46 = pZtytokuyakukoumokuv180x46;
    }

    private String ztytokuyakukoumokuv180x47;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTOKUYAKUKOUMOKUV180X47)
    public String getZtytokuyakukoumokuv180x47() {
        return ztytokuyakukoumokuv180x47;
    }

    public void setZtytokuyakukoumokuv180x47(String pZtytokuyakukoumokuv180x47) {
        ztytokuyakukoumokuv180x47 = pZtytokuyakukoumokuv180x47;
    }

    private String ztytokuyakukoumokuv180x48;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTOKUYAKUKOUMOKUV180X48)
    public String getZtytokuyakukoumokuv180x48() {
        return ztytokuyakukoumokuv180x48;
    }

    public void setZtytokuyakukoumokuv180x48(String pZtytokuyakukoumokuv180x48) {
        ztytokuyakukoumokuv180x48 = pZtytokuyakukoumokuv180x48;
    }

    private String ztytokuyakukoumokuv180x49;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTOKUYAKUKOUMOKUV180X49)
    public String getZtytokuyakukoumokuv180x49() {
        return ztytokuyakukoumokuv180x49;
    }

    public void setZtytokuyakukoumokuv180x49(String pZtytokuyakukoumokuv180x49) {
        ztytokuyakukoumokuv180x49 = pZtytokuyakukoumokuv180x49;
    }

    private String ztytokuyakukoumokuv180x50;

    @Column(name=GenZT_TjHitsyyugkNplusZeroTy.ZTYTOKUYAKUKOUMOKUV180X50)
    public String getZtytokuyakukoumokuv180x50() {
        return ztytokuyakukoumokuv180x50;
    }

    public void setZtytokuyakukoumokuv180x50(String pZtytokuyakukoumokuv180x50) {
        ztytokuyakukoumokuv180x50 = pZtytokuyakukoumokuv180x50;
    }
}