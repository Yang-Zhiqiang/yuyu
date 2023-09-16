package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_TjHitsyyugkNminusZeroTy;
import yuyu.def.db.mapping.GenZT_TjHitsyyugkNminusZeroTy;
import yuyu.def.db.meta.GenQZT_TjHitsyyugkNminusZeroTy;
import yuyu.def.db.meta.QZT_TjHitsyyugkNminusZeroTy;

/**
 * 通常配当所要額Ｆ（Ｎ－０）テーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_TjHitsyyugkNminusZeroTy}</td><td colspan="3">通常配当所要額Ｆ（Ｎ－０）テーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysequenceno ztysequenceno}</td><td>（中継用）シーケンス番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztyyuukourecordlength</td><td>（中継用）有効レコード長</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztyrdwarea</td><td>（中継用）ＲＤＷ領域</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyerrkbnv2</td><td>（中継用）エラー区分Ｖ２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyratekbn</td><td>（中継用）レート区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeisandnendo</td><td>（中継用）計算Ｄ年度</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeijyouym</td><td>（中継用）計上年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyouinkbn</td><td>（中継用）消因区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykbnkeiriyousegmentkbn</td><td>（中継用）区分経理用セグメント区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykbnkeiriyourgnbnskkbn</td><td>（中継用）区分経理用利源分析区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyukeiyakusyuruicdv2</td><td>（中継用）主契約種類コードＶ２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydaihyouyoteiriritu</td><td>（中継用）代表予定利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyharaikatakbn</td><td>（中継用）払方区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynenkinkaisigohyouji</td><td>（中継用）年金開始後表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykjyoutai</td><td>（中継用）契約状態</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynaizouteikiyoteiriritu</td><td>（中継用）内蔵定期予定利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztygoukeigyousekihyoujis</td><td>（中継用）合計業績表示Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysykykgyusekihyjs</td><td>（中継用）主契約業績表示Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytnknitjbrsykykgyuskhyjs</td><td>（中継用）転換一時払主契約業績表示Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztydatakanrino</td><td>（中継用）データ管理番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhknsyukigou</td><td>（中継用）保険種類記号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyannaifuyouriyuukbn</td><td>（中継用）案内不要理由区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytkbthsyumnryuhyouji</td><td>（中継用）特別保障満了表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykymd</td><td>（中継用）契約年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknseikbn</td><td>（中継用）被保険者性別区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhihokensyaagev2</td><td>（中継用）被保険者年令Ｖ２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhknkkn</td><td>（中継用）保険期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyphrkkikn</td><td>（中継用）Ｐ払込期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysaimnkkykhyj</td><td>（中継用）才満期契約表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkaisuukbn</td><td>（中継用）払込回数区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyannaikigetu</td><td>（中継用）案内期月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyao3tyou3sibousdatehyouji</td><td>（中継用）青３長３死亡Ｓ建表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykihons</td><td>（中継用）基本Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyharaizumiymd</td><td>（中継用）払済年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyharaizumis</td><td>（中継用）払済Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyentyous</td><td>（中継用）延長Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyseizons</td><td>（中継用）生存Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztypmens</td><td>（中継用）Ｐ免Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyhendous</td><td>（中継用）変動Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyitibuitijibarais</td><td>（中継用）一部一時払Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytenkanteikisyuruikigou</td><td>（中継用）転換定期種類記号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytenkanteikikikan</td><td>（中継用）転換定期期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytnknteikinkshrkkn</td><td>（中継用）転換定期年金支払期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztygoukeitenkans</td><td>（中継用）合計転換Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztygoukeitenkanteikis</td><td>（中継用）合計転換定期Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztygoukeipbubuntenkans</td><td>（中継用）合計Ｐ部分転換Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytenkankaisuu</td><td>（中継用）転換回数</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydgoukei</td><td>（中継用）Ｄ合計</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysrankbetuhisad</td><td>（中継用）Ｓランク別費差Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysyumtjsrankbetuhisad</td><td>（中継用）消滅時Ｓランク別費差Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztybairitubetuhisad</td><td>（中継用）倍率別費差Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysyumtjtikbairtbetuhisad</td><td>（中継用）消滅時定期倍率別費差Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysyukeiyakukihongoukeid</td><td>（中継用）主契約基本合計Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysyukeiyakukihonsisad</td><td>（中継用）主契約基本死差Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysyukeiyakukihonrisad</td><td>（中継用）主契約基本利差Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysyukeiyakukihonramudad</td><td>（中継用）主契約基本ラムダＤ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysyukeiyakukihonhisad</td><td>（中継用）主契約基本費差Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysyukeiyakukihondtaisyous</td><td>（中継用）主契約基本Ｄ対象Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysyukeiyakukihondyouv</td><td>（中継用）主契約基本Ｄ用Ｖ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysyukeiyakukihondkikens</td><td>（中継用）主契約基本Ｄ危険Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysykykkhnhisadtisyus</td><td>（中継用）主契約基本費差Ｄ対象Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysyukeiyakuteikigoukeid</td><td>（中継用）主契約定期合計Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysyukeiyakuteikisisad</td><td>（中継用）主契約定期死差Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysyukeiyakuteikirisad</td><td>（中継用）主契約定期利差Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysyukeiyakuteikiramudad</td><td>（中継用）主契約定期ラムダＤ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysyukeiyakuteikihisad</td><td>（中継用）主契約定期費差Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysyukeiyakuteikidtaisyous</td><td>（中継用）主契約定期Ｄ対象Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysyukeiyakuteikidyouv</td><td>（中継用）主契約定期Ｄ用Ｖ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysyukeiyakuteikidkikens</td><td>（中継用）主契約定期Ｄ危険Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysykyktikhisadtisyus</td><td>（中継用）主契約定期費差Ｄ対象Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytenkankihongoukeid</td><td>（中継用）転換基本合計Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytenkankihonsisad</td><td>（中継用）転換基本死差Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytenkankihonrisad</td><td>（中継用）転換基本利差Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytenkankihonramudad</td><td>（中継用）転換基本ラムダＤ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytenkankihonhisad</td><td>（中継用）転換基本費差Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytenkankihondtaisyous</td><td>（中継用）転換基本Ｄ対象Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytenkankihondyouv</td><td>（中継用）転換基本Ｄ用Ｖ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytenkankihondkikens</td><td>（中継用）転換基本Ｄ危険Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytenkankihonhisadtaisyous</td><td>（中継用）転換基本費差Ｄ対象Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytenkanteikigoukeid</td><td>（中継用）転換定期合計Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytenkanteikisisad</td><td>（中継用）転換定期死差Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytenkanteikirisad</td><td>（中継用）転換定期利差Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytenkanteikiramudad</td><td>（中継用）転換定期ラムダＤ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytenkanteikihisad</td><td>（中継用）転換定期費差Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytenkanteikidtaisyous</td><td>（中継用）転換定期Ｄ対象Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytenkanteikidyouv</td><td>（中継用）転換定期Ｄ用Ｖ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytenkanteikidkikens</td><td>（中継用）転換定期Ｄ危険Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytenkanteikihisadtaisyous</td><td>（中継用）転換定期費差Ｄ対象Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysyumtjtyusiyutnkntikgukd</td><td>（中継用）消滅時調整用転換定期合計Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysyumtjtyusiyutnkntiksisd</td><td>（中継用）消滅時調整用転換定期死差Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysyumtjtyusiyutnkntikrisd</td><td>（中継用）消滅時調整用転換定期利差Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysyumtjtyusiyutnkntikhisd</td><td>（中継用）消滅時調整用転換定期費差Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysyumtjtnkntikdtaisyous</td><td>（中継用）消滅時転換定期Ｄ対象Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysyumtjtnkntikdyouv</td><td>（中継用）消滅時転換定期Ｄ用Ｖ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysyumtjtnkntikdkikens</td><td>（中継用）消滅時転換定期Ｄ危険Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyhendougoukeid</td><td>（中継用）変動合計Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyhendousisad</td><td>（中継用）変動死差Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyhendouhisad</td><td>（中継用）変動費差Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyhendoudtaisyous</td><td>（中継用）変動Ｄ対象Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyhendoudyouv</td><td>（中継用）変動Ｄ用Ｖ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyhendoudkikens</td><td>（中継用）変動Ｄ危険Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyitibuitijibaraigoukeid</td><td>（中継用）一部一時払合計Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyitibuitijibaraisisad</td><td>（中継用）一部一時払死差Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyitibuitijibaraihisad</td><td>（中継用）一部一時払費差Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyitibuitijibaraidtaisyous</td><td>（中継用）一部一時払Ｄ対象Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyitibuitijibaraidyouv</td><td>（中継用）一部一時払Ｄ用Ｖ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyitibuitijibaraidkikens</td><td>（中継用）一部一時払Ｄ危険Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyitibitjbrhisadtisyus</td><td>（中継用）一部一時払費差Ｄ対象Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyszoukouryokukaisiymd</td><td>（中継用）Ｓ増効力開始年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyszouhokensyuruikigou</td><td>（中継用）Ｓ増保険種類記号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyszoukikan</td><td>（中継用）Ｓ増期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyszouhihokensyaage</td><td>（中継用）Ｓ増被保険者年令</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzoukagoukeid</td><td>（中継用）増加合計Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyzoukasisad</td><td>（中継用）増加死差Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyzoukarisad</td><td>（中継用）増加利差Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyzoukaramudad</td><td>（中継用）増加ラムダＤ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyzoukahisad</td><td>（中継用）増加費差Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyzoukadtaisyous</td><td>（中継用）増加Ｄ対象Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyzoukadyouv</td><td>（中継用）増加Ｄ用Ｖ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyzoukadkikens</td><td>（中継用）増加Ｄ危険Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztykakuteikakusasyuruikgu</td><td>（中継用）カク定カクサ種類記号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykakuteikakusad</td><td>（中継用）カク定カクサＤ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztykakuteikakusas</td><td>（中継用）カク定カクサＳ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztykakuteikakusamanryoujid</td><td>（中継用）カク定カクサ満了時Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztynaizoumarusasyuruikigou</td><td>（中継用）内蔵マルサ種類記号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynaizoumarusad</td><td>（中継用）内蔵マルサＤ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztynaizoumarusas</td><td>（中継用）内蔵マルサＳ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztynaizoukakusasyuruikigou</td><td>（中継用）内蔵カクサ種類記号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynaizoukakusad</td><td>（中継用）内蔵カクサＤ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztynaizoukakusas</td><td>（中継用）内蔵カクサＳ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytenkanpbubund</td><td>（中継用）転換Ｐ部分Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytenkanpbubunsisad</td><td>（中継用）転換Ｐ部分死差Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytenkanpbubunrisad</td><td>（中継用）転換Ｐ部分利差Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytenkanpbubunhisad</td><td>（中継用）転換Ｐ部分費差Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytenkanpbubundtaisyous</td><td>（中継用）転換Ｐ部分Ｄ対象Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytenkanpbubundyouv</td><td>（中継用）転換Ｐ部分Ｄ用Ｖ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytenkanpbubundkikens</td><td>（中継用）転換Ｐ部分Ｄ危険Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztynaizougatateikimud</td><td>（中継用）内蔵型定期ミューＤ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztynaizougatanenkansanp</td><td>（中継用）内蔵型年換算Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyvhktgbbntnkntikmud</td><td>（中継用）Ｖ引継部分転換定期ミューＤ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyhikitugitenkanphireimud</td><td>（中継用）引継転換Ｐ比例ミューＤ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyitibitjbrgyuskhyjs</td><td>（中継用）一部一時払業績表示Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztykariwariate4nenmae</td><td>（中継用）仮割当（４年前）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztykariwariate3nenmae</td><td>（中継用）仮割当（３年前）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztykariwariate2nenmae</td><td>（中継用）仮割当（２年前）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztykariwariate1nenmae</td><td>（中継用）仮割当（１年前）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztygukisisntnkntikmud</td><td>（中継用）合計精算転換定期ミューＤ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztygoukeiseisanteikis</td><td>（中継用）合計精算定期Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztygukisisntnknnenknsnp</td><td>（中継用）合計精算転換年換算Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytnkntikhtnknkykymd</td><td>（中継用）転換定期被転換契約年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytenkangophireimuritu</td><td>（中継用）転換後Ｐ比例ミュー率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztygoukeitenkannenkansanp</td><td>（中継用）合計転換年換算Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztygoukeitenkanteikimud</td><td>（中継用）合計転換定期ミューＤ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytyoukikeizokutokubetud</td><td>（中継用）長期継続特別Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytyouseimaed</td><td>（中継用）調整前Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytuutokuhituusand</td><td>（中継用）通特非通算Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyhknsyuruikigousedaikbn</td><td>（中継用）保険種類記号世代区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytenkanteikikigousedaikbn</td><td>（中継用）転換定期記号世代区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyszoukigousedaikbn</td><td>（中継用）Ｓ増記号世代区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymankihyouji</td><td>（中継用）満期表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeiyakuoutoubikbn</td><td>（中継用）契約応当日区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysuuriyouyobin2</td><td>（中継用）数理用予備項目Ｎ２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakuhukasuu</td><td>（中継用）特約付加数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi1x1</td><td>（中継用）保険種類記号予備１＿１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi1x2</td><td>（中継用）保険種類記号予備１＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi1x3</td><td>（中継用）保険種類記号予備１＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi1x4</td><td>（中継用）保険種類記号予備１＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi1x5</td><td>（中継用）保険種類記号予備１＿５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi1x6</td><td>（中継用）保険種類記号予備１＿６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi1x7</td><td>（中継用）保険種類記号予備１＿７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi1x8</td><td>（中継用）保険種類記号予備１＿８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi1x9</td><td>（中継用）保険種類記号予備１＿９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi1x10</td><td>（中継用）保険種類記号予備１＿１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi1x11</td><td>（中継用）保険種類記号予備１＿１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi1x12</td><td>（中継用）保険種類記号予備１＿１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi1x13</td><td>（中継用）保険種類記号予備１＿１３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi1x14</td><td>（中継用）保険種類記号予備１＿１４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi1x15</td><td>（中継用）保険種類記号予備１＿１５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi2x1</td><td>（中継用）保険種類記号予備２＿１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi2x2</td><td>（中継用）保険種類記号予備２＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi2x3</td><td>（中継用）保険種類記号予備２＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi2x4</td><td>（中継用）保険種類記号予備２＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi2x5</td><td>（中継用）保険種類記号予備２＿５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi2x6</td><td>（中継用）保険種類記号予備２＿６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi2x7</td><td>（中継用）保険種類記号予備２＿７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi2x8</td><td>（中継用）保険種類記号予備２＿８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi2x9</td><td>（中継用）保険種類記号予備２＿９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi2x10</td><td>（中継用）保険種類記号予備２＿１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi3x1</td><td>（中継用）保険種類記号予備３＿１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi3x2</td><td>（中継用）保険種類記号予備３＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi3x3</td><td>（中継用）保険種類記号予備３＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi3x4</td><td>（中継用）保険種類記号予備３＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi3x5</td><td>（中継用）保険種類記号予備３＿５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi3x6</td><td>（中継用）保険種類記号予備３＿６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi3x7</td><td>（中継用）保険種類記号予備３＿７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi3x8</td><td>（中継用）保険種類記号予備３＿８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi3x9</td><td>（中継用）保険種類記号予備３＿９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi3x10</td><td>（中継用）保険種類記号予備３＿１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytenkanteikikigouyobix1</td><td>（中継用）転換定期記号予備＿１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytenkanteikikigouyobix2</td><td>（中継用）転換定期記号予備＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytenkanteikikigouyobix3</td><td>（中継用）転換定期記号予備＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytenkanteikikigouyobix4</td><td>（中継用）転換定期記号予備＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytenkanteikikigouyobix5</td><td>（中継用）転換定期記号予備＿５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykakuteikakusakgusdkbn</td><td>（中継用）カク定カクサ記号世代区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykakuteikakusakguybx1</td><td>（中継用）カク定カクサ記号予備＿１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykakuteikakusakguybx2</td><td>（中継用）カク定カクサ記号予備＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykakuteikakusakguybx3</td><td>（中継用）カク定カクサ記号予備＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykakuteikakusakguybx4</td><td>（中継用）カク定カクサ記号予備＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykakuteikakusakguybx5</td><td>（中継用）カク定カクサ記号予備＿５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynaizoumarusakgusdkbn</td><td>（中継用）内蔵マルサ記号世代区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynaizoumarusakigouyobix1</td><td>（中継用）内蔵マルサ記号予備＿１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynaizoumarusakigouyobix2</td><td>（中継用）内蔵マルサ記号予備＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynaizoumarusakigouyobix3</td><td>（中継用）内蔵マルサ記号予備＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynaizoumarusakigouyobix4</td><td>（中継用）内蔵マルサ記号予備＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynaizoumarusakigouyobix5</td><td>（中継用）内蔵マルサ記号予備＿５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynaizoukakusakgusdkbn</td><td>（中継用）内蔵カクサ記号世代区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynaizoukakusakigouyobix1</td><td>（中継用）内蔵カクサ記号予備＿１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynaizoukakusakigouyobix2</td><td>（中継用）内蔵カクサ記号予備＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynaizoukakusakigouyobix3</td><td>（中継用）内蔵カクサ記号予備＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynaizoukakusakigouyobix4</td><td>（中継用）内蔵カクサ記号予備＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynaizoukakusakigouyobix5</td><td>（中継用）内蔵カクサ記号予備＿５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv92</td><td>（中継用）予備項目Ｖ９２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyraysystemhyj</td><td>（中継用）ＲＡＹシステム表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztygaikakbn</td><td>（中継用）外貨区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykawaserate</td><td>（中継用）為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztykawaseratetekiyouymd</td><td>（中継用）為替レート適用年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyenkdtsbujsitihsyukngk</td><td>（中継用）円貨建死亡時最低保証金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysuuriyouyobin10</td><td>（中継用）数理用予備項目Ｎ１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv10x2</td><td>（中継用）予備項目Ｖ１０＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobin11</td><td>（中継用）予備項目Ｎ１１</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobin11x2</td><td>（中継用）予備項目Ｎ１１＿２</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobiv17</td><td>（中継用）予備項目Ｖ１７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisadrate</td><td>（中継用）死差Ｄレート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyrisadrate</td><td>（中継用）利差Ｄレート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyhisadrate</td><td>（中継用）費差Ｄレート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztydyouvrate</td><td>（中継用）Ｄ用Ｖレート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztykikensrate</td><td>（中継用）危険Ｓレート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztygoukeidrate</td><td>（中継用）合計Ｄレート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztytokuyakukoumokuv180</td><td>（中継用）特約項目Ｖ１８０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv180x2</td><td>（中継用）特約項目Ｖ１８０＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv180x3</td><td>（中継用）特約項目Ｖ１８０＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv180x4</td><td>（中継用）特約項目Ｖ１８０＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv180x5</td><td>（中継用）特約項目Ｖ１８０＿５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv180x6</td><td>（中継用）特約項目Ｖ１８０＿６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv180x7</td><td>（中継用）特約項目Ｖ１８０＿７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv180x8</td><td>（中継用）特約項目Ｖ１８０＿８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv180x9</td><td>（中継用）特約項目Ｖ１８０＿９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv180x10</td><td>（中継用）特約項目Ｖ１８０＿１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv180x11</td><td>（中継用）特約項目Ｖ１８０＿１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv180x12</td><td>（中継用）特約項目Ｖ１８０＿１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv180x13</td><td>（中継用）特約項目Ｖ１８０＿１３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv180x14</td><td>（中継用）特約項目Ｖ１８０＿１４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv180x15</td><td>（中継用）特約項目Ｖ１８０＿１５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv180x16</td><td>（中継用）特約項目Ｖ１８０＿１６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv180x17</td><td>（中継用）特約項目Ｖ１８０＿１７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv180x18</td><td>（中継用）特約項目Ｖ１８０＿１８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv180x19</td><td>（中継用）特約項目Ｖ１８０＿１９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv180x20</td><td>（中継用）特約項目Ｖ１８０＿２０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv180x21</td><td>（中継用）特約項目Ｖ１８０＿２１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv180x22</td><td>（中継用）特約項目Ｖ１８０＿２２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv180x23</td><td>（中継用）特約項目Ｖ１８０＿２３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv180x24</td><td>（中継用）特約項目Ｖ１８０＿２４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv180x25</td><td>（中継用）特約項目Ｖ１８０＿２５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv180x26</td><td>（中継用）特約項目Ｖ１８０＿２６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv180x27</td><td>（中継用）特約項目Ｖ１８０＿２７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv180x28</td><td>（中継用）特約項目Ｖ１８０＿２８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv180x29</td><td>（中継用）特約項目Ｖ１８０＿２９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv180x30</td><td>（中継用）特約項目Ｖ１８０＿３０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv180x31</td><td>（中継用）特約項目Ｖ１８０＿３１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv180x32</td><td>（中継用）特約項目Ｖ１８０＿３２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv180x33</td><td>（中継用）特約項目Ｖ１８０＿３３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv180x34</td><td>（中継用）特約項目Ｖ１８０＿３４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv180x35</td><td>（中継用）特約項目Ｖ１８０＿３５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv180x36</td><td>（中継用）特約項目Ｖ１８０＿３６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv180x37</td><td>（中継用）特約項目Ｖ１８０＿３７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv180x38</td><td>（中継用）特約項目Ｖ１８０＿３８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv180x39</td><td>（中継用）特約項目Ｖ１８０＿３９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv180x40</td><td>（中継用）特約項目Ｖ１８０＿４０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv180x41</td><td>（中継用）特約項目Ｖ１８０＿４１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv180x42</td><td>（中継用）特約項目Ｖ１８０＿４２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv180x43</td><td>（中継用）特約項目Ｖ１８０＿４３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv180x44</td><td>（中継用）特約項目Ｖ１８０＿４４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv180x45</td><td>（中継用）特約項目Ｖ１８０＿４５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv180x46</td><td>（中継用）特約項目Ｖ１８０＿４６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv180x47</td><td>（中継用）特約項目Ｖ１８０＿４７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv180x48</td><td>（中継用）特約項目Ｖ１８０＿４８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv180x49</td><td>（中継用）特約項目Ｖ１８０＿４９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv180x50</td><td>（中継用）特約項目Ｖ１８０＿５０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_TjHitsyyugkNminusZeroTy
 * @see     GenZT_TjHitsyyugkNminusZeroTy
 * @see     QZT_TjHitsyyugkNminusZeroTy
 * @see     GenQZT_TjHitsyyugkNminusZeroTy
 */
public class PKZT_TjHitsyyugkNminusZeroTy extends AbstractExDBPrimaryKey<ZT_TjHitsyyugkNminusZeroTy, PKZT_TjHitsyyugkNminusZeroTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_TjHitsyyugkNminusZeroTy() {
    }

    public PKZT_TjHitsyyugkNminusZeroTy(Integer pZtysequenceno) {
        ztysequenceno = pZtysequenceno;
    }

    @Transient
    @Override
    public Class<ZT_TjHitsyyugkNminusZeroTy> getEntityClass() {
        return ZT_TjHitsyyugkNminusZeroTy.class;
    }

    private Integer ztysequenceno;

    public Integer getZtysequenceno() {
        return ztysequenceno;
    }

    public void setZtysequenceno(Integer pZtysequenceno) {
        ztysequenceno = pZtysequenceno;
    }

}