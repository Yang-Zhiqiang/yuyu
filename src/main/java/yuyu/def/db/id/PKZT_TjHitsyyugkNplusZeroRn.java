package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_TjHitsyyugkNplusZeroRn;
import yuyu.def.db.mapping.GenZT_TjHitsyyugkNplusZeroRn;
import yuyu.def.db.meta.GenQZT_TjHitsyyugkNplusZeroRn;
import yuyu.def.db.meta.QZT_TjHitsyyugkNplusZeroRn;

/**
 * 通常配当所要額Ｆ（Ｎ＋０）テーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_TjHitsyyugkNplusZeroRn}</td><td colspan="3">通常配当所要額Ｆ（Ｎ＋０）テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsequenceno zrnsequenceno}</td><td>（連携用）シーケンス番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnyuukourecordlength</td><td>（連携用）有効レコード長</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnrdwarea</td><td>（連携用）ＲＤＷ領域</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnerrkbnv2</td><td>（連携用）エラー区分Ｖ２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnratekbn</td><td>（連携用）レート区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkeisandnendo</td><td>（連携用）計算Ｄ年度</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkeijyouym</td><td>（連携用）計上年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyouinkbn</td><td>（連携用）消因区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkbnkeiriyousegmentkbn</td><td>（連携用）区分経理用セグメント区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkbnkeiriyourgnbnskkbn</td><td>（連携用）区分経理用利源分析区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyukeiyakusyuruicdv2</td><td>（連携用）主契約種類コードＶ２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndaihyouyoteiriritu</td><td>（連携用）代表予定利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnharaikatakbn</td><td>（連携用）払方区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigohyouji</td><td>（連携用）年金開始後表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykjyoutai</td><td>（連携用）契約状態</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnaizouteikiyoteiriritu</td><td>（連携用）内蔵定期予定利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrngoukeigyousekihyoujis</td><td>（連携用）合計業績表示Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsykykgyusekihyjs</td><td>（連携用）主契約業績表示Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntnknitjbrsykykgyuskhyjs</td><td>（連携用）転換一時払主契約業績表示Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrndatakanrino</td><td>（連携用）データ管理番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhknsyukigou</td><td>（連携用）保険種類記号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnannaifuyouriyuukbn</td><td>（連携用）案内不要理由区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntkbthsyumnryuhyouji</td><td>（連携用）特別保障満了表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykymd</td><td>（連携用）契約年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknseikbn</td><td>（連携用）被保険者性別区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhihokensyaagev2</td><td>（連携用）被保険者年令Ｖ２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhknkkn</td><td>（連携用）保険期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnphrkkikn</td><td>（連携用）Ｐ払込期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsaimnkkykhyj</td><td>（連携用）才満期契約表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrkkaisuukbn</td><td>（連携用）払込回数区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnannaikigetu</td><td>（連携用）案内期月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnao3tyou3sibousdatehyouji</td><td>（連携用）青３長３死亡Ｓ建表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkihons</td><td>（連携用）基本Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnharaizumiymd</td><td>（連携用）払済年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnharaizumis</td><td>（連携用）払済Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnentyous</td><td>（連携用）延長Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnseizons</td><td>（連携用）生存Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnpmens</td><td>（連携用）Ｐ免Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnhendous</td><td>（連携用）変動Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnitibuitijibarais</td><td>（連携用）一部一時払Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntenkanteikisyuruikigou</td><td>（連携用）転換定期種類記号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntenkanteikikikan</td><td>（連携用）転換定期期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntnknteikinkshrkkn</td><td>（連携用）転換定期年金支払期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrngoukeitenkans</td><td>（連携用）合計転換Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrngoukeitenkanteikis</td><td>（連携用）合計転換定期Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrngoukeipbubuntenkans</td><td>（連携用）合計Ｐ部分転換Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntenkankaisuu</td><td>（連携用）転換回数</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndgoukei</td><td>（連携用）Ｄ合計</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsrankbetuhisad</td><td>（連携用）Ｓランク別費差Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsyumtjsrankbetuhisad</td><td>（連携用）消滅時Ｓランク別費差Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnbairitubetuhisad</td><td>（連携用）倍率別費差Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsyumtjtikbairtbetuhisad</td><td>（連携用）消滅時定期倍率別費差Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsyukeiyakukihongoukeid</td><td>（連携用）主契約基本合計Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsyukeiyakukihonsisad</td><td>（連携用）主契約基本死差Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsyukeiyakukihonrisad</td><td>（連携用）主契約基本利差Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsyukeiyakukihonramudad</td><td>（連携用）主契約基本ラムダＤ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsyukeiyakukihonhisad</td><td>（連携用）主契約基本費差Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsyukeiyakukihondtaisyous</td><td>（連携用）主契約基本Ｄ対象Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsyukeiyakukihondyouv</td><td>（連携用）主契約基本Ｄ用Ｖ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsyukeiyakukihondkikens</td><td>（連携用）主契約基本Ｄ危険Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsykykkhnhisadtisyus</td><td>（連携用）主契約基本費差Ｄ対象Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsyukeiyakuteikigoukeid</td><td>（連携用）主契約定期合計Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsyukeiyakuteikisisad</td><td>（連携用）主契約定期死差Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsyukeiyakuteikirisad</td><td>（連携用）主契約定期利差Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsyukeiyakuteikiramudad</td><td>（連携用）主契約定期ラムダＤ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsyukeiyakuteikihisad</td><td>（連携用）主契約定期費差Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsyukeiyakuteikidtaisyous</td><td>（連携用）主契約定期Ｄ対象Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsyukeiyakuteikidyouv</td><td>（連携用）主契約定期Ｄ用Ｖ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsyukeiyakuteikidkikens</td><td>（連携用）主契約定期Ｄ危険Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsykyktikhisadtisyus</td><td>（連携用）主契約定期費差Ｄ対象Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntenkankihongoukeid</td><td>（連携用）転換基本合計Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntenkankihonsisad</td><td>（連携用）転換基本死差Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntenkankihonrisad</td><td>（連携用）転換基本利差Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntenkankihonramudad</td><td>（連携用）転換基本ラムダＤ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntenkankihonhisad</td><td>（連携用）転換基本費差Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntenkankihondtaisyous</td><td>（連携用）転換基本Ｄ対象Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntenkankihondyouv</td><td>（連携用）転換基本Ｄ用Ｖ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntenkankihondkikens</td><td>（連携用）転換基本Ｄ危険Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntenkankihonhisadtaisyous</td><td>（連携用）転換基本費差Ｄ対象Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntenkanteikigoukeid</td><td>（連携用）転換定期合計Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntenkanteikisisad</td><td>（連携用）転換定期死差Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntenkanteikirisad</td><td>（連携用）転換定期利差Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntenkanteikiramudad</td><td>（連携用）転換定期ラムダＤ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntenkanteikihisad</td><td>（連携用）転換定期費差Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntenkanteikidtaisyous</td><td>（連携用）転換定期Ｄ対象Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntenkanteikidyouv</td><td>（連携用）転換定期Ｄ用Ｖ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntenkanteikidkikens</td><td>（連携用）転換定期Ｄ危険Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntenkanteikihisadtaisyous</td><td>（連携用）転換定期費差Ｄ対象Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsyumtjtyusiyutnkntikgukd</td><td>（連携用）消滅時調整用転換定期合計Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsyumtjtyusiyutnkntiksisd</td><td>（連携用）消滅時調整用転換定期死差Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsyumtjtyusiyutnkntikrisd</td><td>（連携用）消滅時調整用転換定期利差Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsyumtjtyusiyutnkntikhisd</td><td>（連携用）消滅時調整用転換定期費差Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsyumtjtnkntikdtaisyous</td><td>（連携用）消滅時転換定期Ｄ対象Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsyumtjtnkntikdyouv</td><td>（連携用）消滅時転換定期Ｄ用Ｖ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsyumtjtnkntikdkikens</td><td>（連携用）消滅時転換定期Ｄ危険Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnhendougoukeid</td><td>（連携用）変動合計Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnhendousisad</td><td>（連携用）変動死差Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnhendouhisad</td><td>（連携用）変動費差Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnhendoudtaisyous</td><td>（連携用）変動Ｄ対象Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnhendoudyouv</td><td>（連携用）変動Ｄ用Ｖ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnhendoudkikens</td><td>（連携用）変動Ｄ危険Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnitibuitijibaraigoukeid</td><td>（連携用）一部一時払合計Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnitibuitijibaraisisad</td><td>（連携用）一部一時払死差Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnitibuitijibaraihisad</td><td>（連携用）一部一時払費差Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnitibuitijibaraidtaisyous</td><td>（連携用）一部一時払Ｄ対象Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnitibuitijibaraidyouv</td><td>（連携用）一部一時払Ｄ用Ｖ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnitibuitijibaraidkikens</td><td>（連携用）一部一時払Ｄ危険Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnitibitjbrhisadtisyus</td><td>（連携用）一部一時払費差Ｄ対象Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnszoukouryokukaisiymd</td><td>（連携用）Ｓ増効力開始年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnszouhokensyuruikigou</td><td>（連携用）Ｓ増保険種類記号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnszoukikan</td><td>（連携用）Ｓ増期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnszouhihokensyaage</td><td>（連携用）Ｓ増被保険者年令</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzoukagoukeid</td><td>（連携用）増加合計Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnzoukasisad</td><td>（連携用）増加死差Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnzoukarisad</td><td>（連携用）増加利差Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnzoukaramudad</td><td>（連携用）増加ラムダＤ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnzoukahisad</td><td>（連携用）増加費差Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnzoukadtaisyous</td><td>（連携用）増加Ｄ対象Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnzoukadyouv</td><td>（連携用）増加Ｄ用Ｖ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnzoukadkikens</td><td>（連携用）増加Ｄ危険Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnkakuteikakusasyuruikgu</td><td>（連携用）カク定カクサ種類記号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkakuteikakusad</td><td>（連携用）カク定カクサＤ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnkakuteikakusas</td><td>（連携用）カク定カクサＳ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnkakuteikakusamanryoujid</td><td>（連携用）カク定カクサ満了時Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnnaizoumarusasyuruikigou</td><td>（連携用）内蔵マルサ種類記号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnaizoumarusad</td><td>（連携用）内蔵マルサＤ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnnaizoumarusas</td><td>（連携用）内蔵マルサＳ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnnaizoukakusasyuruikigou</td><td>（連携用）内蔵カクサ種類記号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnaizoukakusad</td><td>（連携用）内蔵カクサＤ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnnaizoukakusas</td><td>（連携用）内蔵カクサＳ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntenkanpbubund</td><td>（連携用）転換Ｐ部分Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntenkanpbubunsisad</td><td>（連携用）転換Ｐ部分死差Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntenkanpbubunrisad</td><td>（連携用）転換Ｐ部分利差Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntenkanpbubunhisad</td><td>（連携用）転換Ｐ部分費差Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntenkanpbubundtaisyous</td><td>（連携用）転換Ｐ部分Ｄ対象Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntenkanpbubundyouv</td><td>（連携用）転換Ｐ部分Ｄ用Ｖ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntenkanpbubundkikens</td><td>（連携用）転換Ｐ部分Ｄ危険Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnnaizougatateikimud</td><td>（連携用）内蔵型定期ミューＤ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnnaizougatanenkansanp</td><td>（連携用）内蔵型年換算Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnvhktgbbntnkntikmud</td><td>（連携用）Ｖ引継部分転換定期ミューＤ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnhikitugitenkanphireimud</td><td>（連携用）引継転換Ｐ比例ミューＤ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnitibitjbrgyuskhyjs</td><td>（連携用）一部一時払業績表示Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnkariwariate4nenmae</td><td>（連携用）仮割当（４年前）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnkariwariate3nenmae</td><td>（連携用）仮割当（３年前）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnkariwariate2nenmae</td><td>（連携用）仮割当（２年前）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnkariwariate1nenmae</td><td>（連携用）仮割当（１年前）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrngukisisntnkntikmud</td><td>（連携用）合計精算転換定期ミューＤ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrngoukeiseisanteikis</td><td>（連携用）合計精算定期Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrngukisisntnknnenknsnp</td><td>（連携用）合計精算転換年換算Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntnkntikhtnknkykymd</td><td>（連携用）転換定期被転換契約年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntenkangophireimuritu</td><td>（連携用）転換後Ｐ比例ミュー率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrngoukeitenkannenkansanp</td><td>（連携用）合計転換年換算Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrngoukeitenkanteikimud</td><td>（連携用）合計転換定期ミューＤ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntyoukikeizokutokubetud</td><td>（連携用）長期継続特別Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntyouseimaed</td><td>（連携用）調整前Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntuutokuhituusand</td><td>（連携用）通特非通算Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnhknsyuruikigousedaikbn</td><td>（連携用）保険種類記号世代区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntenkanteikikigousedaikbn</td><td>（連携用）転換定期記号世代区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnszoukigousedaikbn</td><td>（連携用）Ｓ増記号世代区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmankihyouji</td><td>（連携用）満期表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkeiyakuoutoubikbn</td><td>（連携用）契約応当日区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsuuriyouyobin2</td><td>（連携用）数理用予備項目Ｎ２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakuhukasuu</td><td>（連携用）特約付加数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi1x1</td><td>（連携用）保険種類記号予備１＿１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi1x2</td><td>（連携用）保険種類記号予備１＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi1x3</td><td>（連携用）保険種類記号予備１＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi1x4</td><td>（連携用）保険種類記号予備１＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi1x5</td><td>（連携用）保険種類記号予備１＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi1x6</td><td>（連携用）保険種類記号予備１＿６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi1x7</td><td>（連携用）保険種類記号予備１＿７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi1x8</td><td>（連携用）保険種類記号予備１＿８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi1x9</td><td>（連携用）保険種類記号予備１＿９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi1x10</td><td>（連携用）保険種類記号予備１＿１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi1x11</td><td>（連携用）保険種類記号予備１＿１１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi1x12</td><td>（連携用）保険種類記号予備１＿１２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi1x13</td><td>（連携用）保険種類記号予備１＿１３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi1x14</td><td>（連携用）保険種類記号予備１＿１４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi1x15</td><td>（連携用）保険種類記号予備１＿１５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi2x1</td><td>（連携用）保険種類記号予備２＿１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi2x2</td><td>（連携用）保険種類記号予備２＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi2x3</td><td>（連携用）保険種類記号予備２＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi2x4</td><td>（連携用）保険種類記号予備２＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi2x5</td><td>（連携用）保険種類記号予備２＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi2x6</td><td>（連携用）保険種類記号予備２＿６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi2x7</td><td>（連携用）保険種類記号予備２＿７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi2x8</td><td>（連携用）保険種類記号予備２＿８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi2x9</td><td>（連携用）保険種類記号予備２＿９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi2x10</td><td>（連携用）保険種類記号予備２＿１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi3x1</td><td>（連携用）保険種類記号予備３＿１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi3x2</td><td>（連携用）保険種類記号予備３＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi3x3</td><td>（連携用）保険種類記号予備３＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi3x4</td><td>（連携用）保険種類記号予備３＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi3x5</td><td>（連携用）保険種類記号予備３＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi3x6</td><td>（連携用）保険種類記号予備３＿６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi3x7</td><td>（連携用）保険種類記号予備３＿７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi3x8</td><td>（連携用）保険種類記号予備３＿８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi3x9</td><td>（連携用）保険種類記号予備３＿９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi3x10</td><td>（連携用）保険種類記号予備３＿１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntenkanteikikigouyobix1</td><td>（連携用）転換定期記号予備＿１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntenkanteikikigouyobix2</td><td>（連携用）転換定期記号予備＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntenkanteikikigouyobix3</td><td>（連携用）転換定期記号予備＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntenkanteikikigouyobix4</td><td>（連携用）転換定期記号予備＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntenkanteikikigouyobix5</td><td>（連携用）転換定期記号予備＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkakuteikakusakgusdkbn</td><td>（連携用）カク定カクサ記号世代区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkakuteikakusakguybx1</td><td>（連携用）カク定カクサ記号予備＿１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkakuteikakusakguybx2</td><td>（連携用）カク定カクサ記号予備＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkakuteikakusakguybx3</td><td>（連携用）カク定カクサ記号予備＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkakuteikakusakguybx4</td><td>（連携用）カク定カクサ記号予備＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkakuteikakusakguybx5</td><td>（連携用）カク定カクサ記号予備＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnaizoumarusakgusdkbn</td><td>（連携用）内蔵マルサ記号世代区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnaizoumarusakigouyobix1</td><td>（連携用）内蔵マルサ記号予備＿１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnaizoumarusakigouyobix2</td><td>（連携用）内蔵マルサ記号予備＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnaizoumarusakigouyobix3</td><td>（連携用）内蔵マルサ記号予備＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnaizoumarusakigouyobix4</td><td>（連携用）内蔵マルサ記号予備＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnaizoumarusakigouyobix5</td><td>（連携用）内蔵マルサ記号予備＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnaizoukakusakgusdkbn</td><td>（連携用）内蔵カクサ記号世代区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnaizoukakusakigouyobix1</td><td>（連携用）内蔵カクサ記号予備＿１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnaizoukakusakigouyobix2</td><td>（連携用）内蔵カクサ記号予備＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnaizoukakusakigouyobix3</td><td>（連携用）内蔵カクサ記号予備＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnaizoukakusakigouyobix4</td><td>（連携用）内蔵カクサ記号予備＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnaizoukakusakigouyobix5</td><td>（連携用）内蔵カクサ記号予備＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv92</td><td>（連携用）予備項目Ｖ９２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnraysystemhyj</td><td>（連携用）ＲＡＹシステム表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrngaikakbn</td><td>（連携用）外貨区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkawaserate</td><td>（連携用）為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnkawaseratetekiyouymd</td><td>（連携用）為替レート適用年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnenkdtsbujsitihsyukngk</td><td>（連携用）円貨建死亡時最低保証金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsuuriyouyobin10</td><td>（連携用）数理用予備項目Ｎ１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv10x2</td><td>（連携用）予備項目Ｖ１０＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobin11</td><td>（連携用）予備項目Ｎ１１</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11x2</td><td>（連携用）予備項目Ｎ１１＿２</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobiv17</td><td>（連携用）予備項目Ｖ１７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisadrate</td><td>（連携用）死差Ｄレート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnrisadrate</td><td>（連携用）利差Ｄレート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnhisadrate</td><td>（連携用）費差Ｄレート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrndyouvrate</td><td>（連携用）Ｄ用Ｖレート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnkikensrate</td><td>（連携用）危険Ｓレート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrngoukeidrate</td><td>（連携用）合計Ｄレート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrntokuyakukoumokuv180</td><td>（連携用）特約項目Ｖ１８０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv180x2</td><td>（連携用）特約項目Ｖ１８０＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv180x3</td><td>（連携用）特約項目Ｖ１８０＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv180x4</td><td>（連携用）特約項目Ｖ１８０＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv180x5</td><td>（連携用）特約項目Ｖ１８０＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv180x6</td><td>（連携用）特約項目Ｖ１８０＿６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv180x7</td><td>（連携用）特約項目Ｖ１８０＿７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv180x8</td><td>（連携用）特約項目Ｖ１８０＿８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv180x9</td><td>（連携用）特約項目Ｖ１８０＿９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv180x10</td><td>（連携用）特約項目Ｖ１８０＿１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv180x11</td><td>（連携用）特約項目Ｖ１８０＿１１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv180x12</td><td>（連携用）特約項目Ｖ１８０＿１２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv180x13</td><td>（連携用）特約項目Ｖ１８０＿１３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv180x14</td><td>（連携用）特約項目Ｖ１８０＿１４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv180x15</td><td>（連携用）特約項目Ｖ１８０＿１５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv180x16</td><td>（連携用）特約項目Ｖ１８０＿１６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv180x17</td><td>（連携用）特約項目Ｖ１８０＿１７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv180x18</td><td>（連携用）特約項目Ｖ１８０＿１８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv180x19</td><td>（連携用）特約項目Ｖ１８０＿１９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv180x20</td><td>（連携用）特約項目Ｖ１８０＿２０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv180x21</td><td>（連携用）特約項目Ｖ１８０＿２１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv180x22</td><td>（連携用）特約項目Ｖ１８０＿２２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv180x23</td><td>（連携用）特約項目Ｖ１８０＿２３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv180x24</td><td>（連携用）特約項目Ｖ１８０＿２４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv180x25</td><td>（連携用）特約項目Ｖ１８０＿２５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv180x26</td><td>（連携用）特約項目Ｖ１８０＿２６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv180x27</td><td>（連携用）特約項目Ｖ１８０＿２７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv180x28</td><td>（連携用）特約項目Ｖ１８０＿２８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv180x29</td><td>（連携用）特約項目Ｖ１８０＿２９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv180x30</td><td>（連携用）特約項目Ｖ１８０＿３０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv180x31</td><td>（連携用）特約項目Ｖ１８０＿３１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv180x32</td><td>（連携用）特約項目Ｖ１８０＿３２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv180x33</td><td>（連携用）特約項目Ｖ１８０＿３３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv180x34</td><td>（連携用）特約項目Ｖ１８０＿３４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv180x35</td><td>（連携用）特約項目Ｖ１８０＿３５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv180x36</td><td>（連携用）特約項目Ｖ１８０＿３６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv180x37</td><td>（連携用）特約項目Ｖ１８０＿３７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv180x38</td><td>（連携用）特約項目Ｖ１８０＿３８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv180x39</td><td>（連携用）特約項目Ｖ１８０＿３９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv180x40</td><td>（連携用）特約項目Ｖ１８０＿４０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv180x41</td><td>（連携用）特約項目Ｖ１８０＿４１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv180x42</td><td>（連携用）特約項目Ｖ１８０＿４２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv180x43</td><td>（連携用）特約項目Ｖ１８０＿４３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv180x44</td><td>（連携用）特約項目Ｖ１８０＿４４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv180x45</td><td>（連携用）特約項目Ｖ１８０＿４５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv180x46</td><td>（連携用）特約項目Ｖ１８０＿４６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv180x47</td><td>（連携用）特約項目Ｖ１８０＿４７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv180x48</td><td>（連携用）特約項目Ｖ１８０＿４８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv180x49</td><td>（連携用）特約項目Ｖ１８０＿４９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv180x50</td><td>（連携用）特約項目Ｖ１８０＿５０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_TjHitsyyugkNplusZeroRn
 * @see     GenZT_TjHitsyyugkNplusZeroRn
 * @see     QZT_TjHitsyyugkNplusZeroRn
 * @see     GenQZT_TjHitsyyugkNplusZeroRn
 */
public class PKZT_TjHitsyyugkNplusZeroRn extends AbstractExDBPrimaryKey<ZT_TjHitsyyugkNplusZeroRn, PKZT_TjHitsyyugkNplusZeroRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_TjHitsyyugkNplusZeroRn() {
    }

    public PKZT_TjHitsyyugkNplusZeroRn(Integer pZrnsequenceno) {
        zrnsequenceno = pZrnsequenceno;
    }

    @Transient
    @Override
    public Class<ZT_TjHitsyyugkNplusZeroRn> getEntityClass() {
        return ZT_TjHitsyyugkNplusZeroRn.class;
    }

    private Integer zrnsequenceno;

    public Integer getZrnsequenceno() {
        return zrnsequenceno;
    }

    public void setZrnsequenceno(Integer pZrnsequenceno) {
        zrnsequenceno = pZrnsequenceno;
    }

}