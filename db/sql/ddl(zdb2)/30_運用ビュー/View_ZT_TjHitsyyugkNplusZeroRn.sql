CREATE VIEW ZT_TjHitsyyugkNplusZeroRn AS SELECT
     zrnsequenceno ,         /* （連携用）シーケンス番号 */
     zrnyuukourecordlength ,         /* （連携用）有効レコード長 */
     zrnrdwarea ,         /* （連携用）ＲＤＷ領域 */
     zrnerrkbnv2 ,         /* （連携用）エラー区分Ｖ２ */
     zrnratekbn ,         /* （連携用）レート区分 */
     zrnkeisandnendo ,         /* （連携用）計算Ｄ年度 */
     zrnkeijyouym ,         /* （連携用）計上年月 */
     zrnsyouinkbn ,         /* （連携用）消因区分 */
     zrnkbnkeiriyousegmentkbn ,         /* （連携用）区分経理用セグメント区分 */
     zrnkbnkeiriyourgnbnskkbn ,         /* （連携用）区分経理用利源分析区分 */
     zrnsyukeiyakusyuruicdv2 ,         /* （連携用）主契約種類コードＶ２ */
     zrndaihyouyoteiriritu ,         /* （連携用）代表予定利率 */
     zrnharaikatakbn ,         /* （連携用）払方区分 */
     zrnnenkinkaisigohyouji ,         /* （連携用）年金開始後表示 */
     zrnkykjyoutai ,         /* （連携用）契約状態 */
     zrnnaizouteikiyoteiriritu ,         /* （連携用）内蔵定期予定利率 */
     zrngoukeigyousekihyoujis ,         /* （連携用）合計業績表示Ｓ */
     zrnsykykgyusekihyjs ,         /* （連携用）主契約業績表示Ｓ */
     zrntnknitjbrsykykgyuskhyjs ,         /* （連携用）転換一時払主契約業績表示Ｓ */
     zrndatakanrino ,         /* （連携用）データ管理番号 */
     zrnhknsyukigou ,         /* （連携用）保険種類記号 */
     zrnannaifuyouriyuukbn ,         /* （連携用）案内不要理由区分 */
     zrntkbthsyumnryuhyouji ,         /* （連携用）特別保障満了表示 */
     zrnkykymd ,         /* （連携用）契約年月日 */
     zrnhhknseikbn ,         /* （連携用）被保険者性別区分 */
     zrnhihokensyaagev2 ,         /* （連携用）被保険者年令Ｖ２ */
     zrnhknkkn ,         /* （連携用）保険期間 */
     zrnphrkkikn ,         /* （連携用）Ｐ払込期間 */
     zrnsaimnkkykhyj ,         /* （連携用）才満期契約表示 */
     zrnhrkkaisuukbn ,         /* （連携用）払込回数区分 */
     zrnannaikigetu ,         /* （連携用）案内期月 */
     zrnao3tyou3sibousdatehyouji ,         /* （連携用）青３長３死亡Ｓ建表示 */
     zrnkihons ,         /* （連携用）基本Ｓ */
     zrnharaizumiymd ,         /* （連携用）払済年月日 */
     zrnharaizumis ,         /* （連携用）払済Ｓ */
     zrnentyous ,         /* （連携用）延長Ｓ */
     zrnseizons ,         /* （連携用）生存Ｓ */
     zrnpmens ,         /* （連携用）Ｐ免Ｓ */
     zrnhendous ,         /* （連携用）変動Ｓ */
     zrnitibuitijibarais ,         /* （連携用）一部一時払Ｓ */
     zrntenkanteikisyuruikigou ,         /* （連携用）転換定期種類記号 */
     zrntenkanteikikikan ,         /* （連携用）転換定期期間 */
     zrntnknteikinkshrkkn ,         /* （連携用）転換定期年金支払期間 */
     zrngoukeitenkans ,         /* （連携用）合計転換Ｓ */
     zrngoukeitenkanteikis ,         /* （連携用）合計転換定期Ｓ */
     zrngoukeipbubuntenkans ,         /* （連携用）合計Ｐ部分転換Ｓ */
     zrntenkankaisuu ,         /* （連携用）転換回数 */
     zrndgoukei ,         /* （連携用）Ｄ合計 */
     zrnsrankbetuhisad ,         /* （連携用）Ｓランク別費差Ｄ */
     zrnsyumtjsrankbetuhisad ,         /* （連携用）消滅時Ｓランク別費差Ｄ */
     zrnbairitubetuhisad ,         /* （連携用）倍率別費差Ｄ */
     zrnsyumtjtikbairtbetuhisad ,         /* （連携用）消滅時定期倍率別費差Ｄ */
     zrnsyukeiyakukihongoukeid ,         /* （連携用）主契約基本合計Ｄ */
     zrnsyukeiyakukihonsisad ,         /* （連携用）主契約基本死差Ｄ */
     zrnsyukeiyakukihonrisad ,         /* （連携用）主契約基本利差Ｄ */
     zrnsyukeiyakukihonramudad ,         /* （連携用）主契約基本ラムダＤ */
     zrnsyukeiyakukihonhisad ,         /* （連携用）主契約基本費差Ｄ */
     zrnsyukeiyakukihondtaisyous ,         /* （連携用）主契約基本Ｄ対象Ｓ */
     zrnsyukeiyakukihondyouv ,         /* （連携用）主契約基本Ｄ用Ｖ */
     zrnsyukeiyakukihondkikens ,         /* （連携用）主契約基本Ｄ危険Ｓ */
     zrnsykykkhnhisadtisyus ,         /* （連携用）主契約基本費差Ｄ対象Ｓ */
     zrnsyukeiyakuteikigoukeid ,         /* （連携用）主契約定期合計Ｄ */
     zrnsyukeiyakuteikisisad ,         /* （連携用）主契約定期死差Ｄ */
     zrnsyukeiyakuteikirisad ,         /* （連携用）主契約定期利差Ｄ */
     zrnsyukeiyakuteikiramudad ,         /* （連携用）主契約定期ラムダＤ */
     zrnsyukeiyakuteikihisad ,         /* （連携用）主契約定期費差Ｄ */
     zrnsyukeiyakuteikidtaisyous ,         /* （連携用）主契約定期Ｄ対象Ｓ */
     zrnsyukeiyakuteikidyouv ,         /* （連携用）主契約定期Ｄ用Ｖ */
     zrnsyukeiyakuteikidkikens ,         /* （連携用）主契約定期Ｄ危険Ｓ */
     zrnsykyktikhisadtisyus ,         /* （連携用）主契約定期費差Ｄ対象Ｓ */
     zrntenkankihongoukeid ,         /* （連携用）転換基本合計Ｄ */
     zrntenkankihonsisad ,         /* （連携用）転換基本死差Ｄ */
     zrntenkankihonrisad ,         /* （連携用）転換基本利差Ｄ */
     zrntenkankihonramudad ,         /* （連携用）転換基本ラムダＤ */
     zrntenkankihonhisad ,         /* （連携用）転換基本費差Ｄ */
     zrntenkankihondtaisyous ,         /* （連携用）転換基本Ｄ対象Ｓ */
     zrntenkankihondyouv ,         /* （連携用）転換基本Ｄ用Ｖ */
     zrntenkankihondkikens ,         /* （連携用）転換基本Ｄ危険Ｓ */
     zrntenkankihonhisadtaisyous ,         /* （連携用）転換基本費差Ｄ対象Ｓ */
     zrntenkanteikigoukeid ,         /* （連携用）転換定期合計Ｄ */
     zrntenkanteikisisad ,         /* （連携用）転換定期死差Ｄ */
     zrntenkanteikirisad ,         /* （連携用）転換定期利差Ｄ */
     zrntenkanteikiramudad ,         /* （連携用）転換定期ラムダＤ */
     zrntenkanteikihisad ,         /* （連携用）転換定期費差Ｄ */
     zrntenkanteikidtaisyous ,         /* （連携用）転換定期Ｄ対象Ｓ */
     zrntenkanteikidyouv ,         /* （連携用）転換定期Ｄ用Ｖ */
     zrntenkanteikidkikens ,         /* （連携用）転換定期Ｄ危険Ｓ */
     zrntenkanteikihisadtaisyous ,         /* （連携用）転換定期費差Ｄ対象Ｓ */
     zrnsyumtjtyusiyutnkntikgukd ,         /* （連携用）消滅時調整用転換定期合計Ｄ */
     zrnsyumtjtyusiyutnkntiksisd ,         /* （連携用）消滅時調整用転換定期死差Ｄ */
     zrnsyumtjtyusiyutnkntikrisd ,         /* （連携用）消滅時調整用転換定期利差Ｄ */
     zrnsyumtjtyusiyutnkntikhisd ,         /* （連携用）消滅時調整用転換定期費差Ｄ */
     zrnsyumtjtnkntikdtaisyous ,         /* （連携用）消滅時転換定期Ｄ対象Ｓ */
     zrnsyumtjtnkntikdyouv ,         /* （連携用）消滅時転換定期Ｄ用Ｖ */
     zrnsyumtjtnkntikdkikens ,         /* （連携用）消滅時転換定期Ｄ危険Ｓ */
     zrnhendougoukeid ,         /* （連携用）変動合計Ｄ */
     zrnhendousisad ,         /* （連携用）変動死差Ｄ */
     zrnhendouhisad ,         /* （連携用）変動費差Ｄ */
     zrnhendoudtaisyous ,         /* （連携用）変動Ｄ対象Ｓ */
     zrnhendoudyouv ,         /* （連携用）変動Ｄ用Ｖ */
     zrnhendoudkikens ,         /* （連携用）変動Ｄ危険Ｓ */
     zrnitibuitijibaraigoukeid ,         /* （連携用）一部一時払合計Ｄ */
     zrnitibuitijibaraisisad ,         /* （連携用）一部一時払死差Ｄ */
     zrnitibuitijibaraihisad ,         /* （連携用）一部一時払費差Ｄ */
     zrnitibuitijibaraidtaisyous ,         /* （連携用）一部一時払Ｄ対象Ｓ */
     zrnitibuitijibaraidyouv ,         /* （連携用）一部一時払Ｄ用Ｖ */
     zrnitibuitijibaraidkikens ,         /* （連携用）一部一時払Ｄ危険Ｓ */
     zrnitibitjbrhisadtisyus ,         /* （連携用）一部一時払費差Ｄ対象Ｓ */
     zrnszoukouryokukaisiymd ,         /* （連携用）Ｓ増効力開始年月日 */
     zrnszouhokensyuruikigou ,         /* （連携用）Ｓ増保険種類記号 */
     zrnszoukikan ,         /* （連携用）Ｓ増期間 */
     zrnszouhihokensyaage ,         /* （連携用）Ｓ増被保険者年令 */
     zrnzoukagoukeid ,         /* （連携用）増加合計Ｄ */
     zrnzoukasisad ,         /* （連携用）増加死差Ｄ */
     zrnzoukarisad ,         /* （連携用）増加利差Ｄ */
     zrnzoukaramudad ,         /* （連携用）増加ラムダＤ */
     zrnzoukahisad ,         /* （連携用）増加費差Ｄ */
     zrnzoukadtaisyous ,         /* （連携用）増加Ｄ対象Ｓ */
     zrnzoukadyouv ,         /* （連携用）増加Ｄ用Ｖ */
     zrnzoukadkikens ,         /* （連携用）増加Ｄ危険Ｓ */
     zrnkakuteikakusasyuruikgu ,         /* （連携用）カク定カクサ種類記号 */
     zrnkakuteikakusad ,         /* （連携用）カク定カクサＤ */
     zrnkakuteikakusas ,         /* （連携用）カク定カクサＳ */
     zrnkakuteikakusamanryoujid ,         /* （連携用）カク定カクサ満了時Ｄ */
     zrnnaizoumarusasyuruikigou ,         /* （連携用）内蔵マルサ種類記号 */
     zrnnaizoumarusad ,         /* （連携用）内蔵マルサＤ */
     zrnnaizoumarusas ,         /* （連携用）内蔵マルサＳ */
     zrnnaizoukakusasyuruikigou ,         /* （連携用）内蔵カクサ種類記号 */
     zrnnaizoukakusad ,         /* （連携用）内蔵カクサＤ */
     zrnnaizoukakusas ,         /* （連携用）内蔵カクサＳ */
     zrntenkanpbubund ,         /* （連携用）転換Ｐ部分Ｄ */
     zrntenkanpbubunsisad ,         /* （連携用）転換Ｐ部分死差Ｄ */
     zrntenkanpbubunrisad ,         /* （連携用）転換Ｐ部分利差Ｄ */
     zrntenkanpbubunhisad ,         /* （連携用）転換Ｐ部分費差Ｄ */
     zrntenkanpbubundtaisyous ,         /* （連携用）転換Ｐ部分Ｄ対象Ｓ */
     zrntenkanpbubundyouv ,         /* （連携用）転換Ｐ部分Ｄ用Ｖ */
     zrntenkanpbubundkikens ,         /* （連携用）転換Ｐ部分Ｄ危険Ｓ */
     zrnnaizougatateikimud ,         /* （連携用）内蔵型定期ミューＤ */
     zrnnaizougatanenkansanp ,         /* （連携用）内蔵型年換算Ｐ */
     zrnvhktgbbntnkntikmud ,         /* （連携用）Ｖ引継部分転換定期ミューＤ */
     zrnhikitugitenkanphireimud ,         /* （連携用）引継転換Ｐ比例ミューＤ */
     zrnitibitjbrgyuskhyjs ,         /* （連携用）一部一時払業績表示Ｓ */
     zrnkariwariate4nenmae ,         /* （連携用）仮割当（４年前） */
     zrnkariwariate3nenmae ,         /* （連携用）仮割当（３年前） */
     zrnkariwariate2nenmae ,         /* （連携用）仮割当（２年前） */
     zrnkariwariate1nenmae ,         /* （連携用）仮割当（１年前） */
     zrngukisisntnkntikmud ,         /* （連携用）合計精算転換定期ミューＤ */
     zrngoukeiseisanteikis ,         /* （連携用）合計精算定期Ｓ */
     zrngukisisntnknnenknsnp ,         /* （連携用）合計精算転換年換算Ｐ */
     zrntnkntikhtnknkykymd ,         /* （連携用）転換定期被転換契約年月日 */
     zrntenkangophireimuritu ,         /* （連携用）転換後Ｐ比例ミュー率 */
     zrngoukeitenkannenkansanp ,         /* （連携用）合計転換年換算Ｐ */
     zrngoukeitenkanteikimud ,         /* （連携用）合計転換定期ミューＤ */
     zrntyoukikeizokutokubetud ,         /* （連携用）長期継続特別Ｄ */
     zrntyouseimaed ,         /* （連携用）調整前Ｄ */
     zrntuutokuhituusand ,         /* （連携用）通特非通算Ｄ */
     zrnhknsyuruikigousedaikbn ,         /* （連携用）保険種類記号世代区分 */
     zrntenkanteikikigousedaikbn ,         /* （連携用）転換定期記号世代区分 */
     zrnszoukigousedaikbn ,         /* （連携用）Ｓ増記号世代区分 */
     zrnmankihyouji ,         /* （連携用）満期表示 */
     zrnkeiyakuoutoubikbn ,         /* （連携用）契約応当日区分 */
     zrnsuuriyouyobin2 ,         /* （連携用）数理用予備項目Ｎ２ */
     zrntokuyakuhukasuu ,         /* （連携用）特約付加数 */
     zrnhokensyuruikigouyobi1x1 ,         /* （連携用）保険種類記号予備１＿１ */
     zrnhokensyuruikigouyobi1x2 ,         /* （連携用）保険種類記号予備１＿２ */
     zrnhokensyuruikigouyobi1x3 ,         /* （連携用）保険種類記号予備１＿３ */
     zrnhokensyuruikigouyobi1x4 ,         /* （連携用）保険種類記号予備１＿４ */
     zrnhokensyuruikigouyobi1x5 ,         /* （連携用）保険種類記号予備１＿５ */
     zrnhokensyuruikigouyobi1x6 ,         /* （連携用）保険種類記号予備１＿６ */
     zrnhokensyuruikigouyobi1x7 ,         /* （連携用）保険種類記号予備１＿７ */
     zrnhokensyuruikigouyobi1x8 ,         /* （連携用）保険種類記号予備１＿８ */
     zrnhokensyuruikigouyobi1x9 ,         /* （連携用）保険種類記号予備１＿９ */
     zrnhokensyuruikigouyobi1x10 ,         /* （連携用）保険種類記号予備１＿１０ */
     zrnhokensyuruikigouyobi1x11 ,         /* （連携用）保険種類記号予備１＿１１ */
     zrnhokensyuruikigouyobi1x12 ,         /* （連携用）保険種類記号予備１＿１２ */
     zrnhokensyuruikigouyobi1x13 ,         /* （連携用）保険種類記号予備１＿１３ */
     zrnhokensyuruikigouyobi1x14 ,         /* （連携用）保険種類記号予備１＿１４ */
     zrnhokensyuruikigouyobi1x15 ,         /* （連携用）保険種類記号予備１＿１５ */
     zrnhokensyuruikigouyobi2x1 ,         /* （連携用）保険種類記号予備２＿１ */
     zrnhokensyuruikigouyobi2x2 ,         /* （連携用）保険種類記号予備２＿２ */
     zrnhokensyuruikigouyobi2x3 ,         /* （連携用）保険種類記号予備２＿３ */
     zrnhokensyuruikigouyobi2x4 ,         /* （連携用）保険種類記号予備２＿４ */
     zrnhokensyuruikigouyobi2x5 ,         /* （連携用）保険種類記号予備２＿５ */
     zrnhokensyuruikigouyobi2x6 ,         /* （連携用）保険種類記号予備２＿６ */
     zrnhokensyuruikigouyobi2x7 ,         /* （連携用）保険種類記号予備２＿７ */
     zrnhokensyuruikigouyobi2x8 ,         /* （連携用）保険種類記号予備２＿８ */
     zrnhokensyuruikigouyobi2x9 ,         /* （連携用）保険種類記号予備２＿９ */
     zrnhokensyuruikigouyobi2x10 ,         /* （連携用）保険種類記号予備２＿１０ */
     zrnhokensyuruikigouyobi3x1 ,         /* （連携用）保険種類記号予備３＿１ */
     zrnhokensyuruikigouyobi3x2 ,         /* （連携用）保険種類記号予備３＿２ */
     zrnhokensyuruikigouyobi3x3 ,         /* （連携用）保険種類記号予備３＿３ */
     zrnhokensyuruikigouyobi3x4 ,         /* （連携用）保険種類記号予備３＿４ */
     zrnhokensyuruikigouyobi3x5 ,         /* （連携用）保険種類記号予備３＿５ */
     zrnhokensyuruikigouyobi3x6 ,         /* （連携用）保険種類記号予備３＿６ */
     zrnhokensyuruikigouyobi3x7 ,         /* （連携用）保険種類記号予備３＿７ */
     zrnhokensyuruikigouyobi3x8 ,         /* （連携用）保険種類記号予備３＿８ */
     zrnhokensyuruikigouyobi3x9 ,         /* （連携用）保険種類記号予備３＿９ */
     zrnhokensyuruikigouyobi3x10 ,         /* （連携用）保険種類記号予備３＿１０ */
     zrntenkanteikikigouyobix1 ,         /* （連携用）転換定期記号予備＿１ */
     zrntenkanteikikigouyobix2 ,         /* （連携用）転換定期記号予備＿２ */
     zrntenkanteikikigouyobix3 ,         /* （連携用）転換定期記号予備＿３ */
     zrntenkanteikikigouyobix4 ,         /* （連携用）転換定期記号予備＿４ */
     zrntenkanteikikigouyobix5 ,         /* （連携用）転換定期記号予備＿５ */
     zrnkakuteikakusakgusdkbn ,         /* （連携用）カク定カクサ記号世代区分 */
     zrnkakuteikakusakguybx1 ,         /* （連携用）カク定カクサ記号予備＿１ */
     zrnkakuteikakusakguybx2 ,         /* （連携用）カク定カクサ記号予備＿２ */
     zrnkakuteikakusakguybx3 ,         /* （連携用）カク定カクサ記号予備＿３ */
     zrnkakuteikakusakguybx4 ,         /* （連携用）カク定カクサ記号予備＿４ */
     zrnkakuteikakusakguybx5 ,         /* （連携用）カク定カクサ記号予備＿５ */
     zrnnaizoumarusakgusdkbn ,         /* （連携用）内蔵マルサ記号世代区分 */
     zrnnaizoumarusakigouyobix1 ,         /* （連携用）内蔵マルサ記号予備＿１ */
     zrnnaizoumarusakigouyobix2 ,         /* （連携用）内蔵マルサ記号予備＿２ */
     zrnnaizoumarusakigouyobix3 ,         /* （連携用）内蔵マルサ記号予備＿３ */
     zrnnaizoumarusakigouyobix4 ,         /* （連携用）内蔵マルサ記号予備＿４ */
     zrnnaizoumarusakigouyobix5 ,         /* （連携用）内蔵マルサ記号予備＿５ */
     zrnnaizoukakusakgusdkbn ,         /* （連携用）内蔵カクサ記号世代区分 */
     zrnnaizoukakusakigouyobix1 ,         /* （連携用）内蔵カクサ記号予備＿１ */
     zrnnaizoukakusakigouyobix2 ,         /* （連携用）内蔵カクサ記号予備＿２ */
     zrnnaizoukakusakigouyobix3 ,         /* （連携用）内蔵カクサ記号予備＿３ */
     zrnnaizoukakusakigouyobix4 ,         /* （連携用）内蔵カクサ記号予備＿４ */
     zrnnaizoukakusakigouyobix5 ,         /* （連携用）内蔵カクサ記号予備＿５ */
     zrnyobiv92 ,         /* （連携用）予備項目Ｖ９２ */
     zrnraysystemhyj ,         /* （連携用）ＲＡＹシステム表示 */
     zrngaikakbn ,         /* （連携用）外貨区分 */
     zrnkawaserate ,         /* （連携用）為替レート */
     zrnkawaseratetekiyouymd ,         /* （連携用）為替レート適用年月日 */
     zrnenkdtsbujsitihsyukngk ,         /* （連携用）円貨建死亡時最低保証金額 */
     zrnsuuriyouyobin10 ,         /* （連携用）数理用予備項目Ｎ１０ */
     zrnyobiv10x2 ,         /* （連携用）予備項目Ｖ１０＿２ */
     zrnyobin11 ,         /* （連携用）予備項目Ｎ１１ */
     zrnyobin11x2 ,         /* （連携用）予備項目Ｎ１１＿２ */
     zrnyobiv17 ,         /* （連携用）予備項目Ｖ１７ */
     zrnsisadrate ,         /* （連携用）死差Ｄレート */
     zrnrisadrate ,         /* （連携用）利差Ｄレート */
     zrnhisadrate ,         /* （連携用）費差Ｄレート */
     zrndyouvrate ,         /* （連携用）Ｄ用Ｖレート */
     zrnkikensrate ,         /* （連携用）危険Ｓレート */
     zrngoukeidrate ,         /* （連携用）合計Ｄレート */
     zrntokuyakukoumokuv180 ,         /* （連携用）特約項目Ｖ１８０ */
     zrntokuyakukoumokuv180x2 ,         /* （連携用）特約項目Ｖ１８０＿２ */
     zrntokuyakukoumokuv180x3 ,         /* （連携用）特約項目Ｖ１８０＿３ */
     zrntokuyakukoumokuv180x4 ,         /* （連携用）特約項目Ｖ１８０＿４ */
     zrntokuyakukoumokuv180x5 ,         /* （連携用）特約項目Ｖ１８０＿５ */
     zrntokuyakukoumokuv180x6 ,         /* （連携用）特約項目Ｖ１８０＿６ */
     zrntokuyakukoumokuv180x7 ,         /* （連携用）特約項目Ｖ１８０＿７ */
     zrntokuyakukoumokuv180x8 ,         /* （連携用）特約項目Ｖ１８０＿８ */
     zrntokuyakukoumokuv180x9 ,         /* （連携用）特約項目Ｖ１８０＿９ */
     zrntokuyakukoumokuv180x10 ,         /* （連携用）特約項目Ｖ１８０＿１０ */
     zrntokuyakukoumokuv180x11 ,         /* （連携用）特約項目Ｖ１８０＿１１ */
     zrntokuyakukoumokuv180x12 ,         /* （連携用）特約項目Ｖ１８０＿１２ */
     zrntokuyakukoumokuv180x13 ,         /* （連携用）特約項目Ｖ１８０＿１３ */
     zrntokuyakukoumokuv180x14 ,         /* （連携用）特約項目Ｖ１８０＿１４ */
     zrntokuyakukoumokuv180x15 ,         /* （連携用）特約項目Ｖ１８０＿１５ */
     zrntokuyakukoumokuv180x16 ,         /* （連携用）特約項目Ｖ１８０＿１６ */
     zrntokuyakukoumokuv180x17 ,         /* （連携用）特約項目Ｖ１８０＿１７ */
     zrntokuyakukoumokuv180x18 ,         /* （連携用）特約項目Ｖ１８０＿１８ */
     zrntokuyakukoumokuv180x19 ,         /* （連携用）特約項目Ｖ１８０＿１９ */
     zrntokuyakukoumokuv180x20 ,         /* （連携用）特約項目Ｖ１８０＿２０ */
     zrntokuyakukoumokuv180x21 ,         /* （連携用）特約項目Ｖ１８０＿２１ */
     zrntokuyakukoumokuv180x22 ,         /* （連携用）特約項目Ｖ１８０＿２２ */
     zrntokuyakukoumokuv180x23 ,         /* （連携用）特約項目Ｖ１８０＿２３ */
     zrntokuyakukoumokuv180x24 ,         /* （連携用）特約項目Ｖ１８０＿２４ */
     zrntokuyakukoumokuv180x25 ,         /* （連携用）特約項目Ｖ１８０＿２５ */
     zrntokuyakukoumokuv180x26 ,         /* （連携用）特約項目Ｖ１８０＿２６ */
     zrntokuyakukoumokuv180x27 ,         /* （連携用）特約項目Ｖ１８０＿２７ */
     zrntokuyakukoumokuv180x28 ,         /* （連携用）特約項目Ｖ１８０＿２８ */
     zrntokuyakukoumokuv180x29 ,         /* （連携用）特約項目Ｖ１８０＿２９ */
     zrntokuyakukoumokuv180x30 ,         /* （連携用）特約項目Ｖ１８０＿３０ */
     zrntokuyakukoumokuv180x31 ,         /* （連携用）特約項目Ｖ１８０＿３１ */
     zrntokuyakukoumokuv180x32 ,         /* （連携用）特約項目Ｖ１８０＿３２ */
     zrntokuyakukoumokuv180x33 ,         /* （連携用）特約項目Ｖ１８０＿３３ */
     zrntokuyakukoumokuv180x34 ,         /* （連携用）特約項目Ｖ１８０＿３４ */
     zrntokuyakukoumokuv180x35 ,         /* （連携用）特約項目Ｖ１８０＿３５ */
     zrntokuyakukoumokuv180x36 ,         /* （連携用）特約項目Ｖ１８０＿３６ */
     zrntokuyakukoumokuv180x37 ,         /* （連携用）特約項目Ｖ１８０＿３７ */
     zrntokuyakukoumokuv180x38 ,         /* （連携用）特約項目Ｖ１８０＿３８ */
     zrntokuyakukoumokuv180x39 ,         /* （連携用）特約項目Ｖ１８０＿３９ */
     zrntokuyakukoumokuv180x40 ,         /* （連携用）特約項目Ｖ１８０＿４０ */
     zrntokuyakukoumokuv180x41 ,         /* （連携用）特約項目Ｖ１８０＿４１ */
     zrntokuyakukoumokuv180x42 ,         /* （連携用）特約項目Ｖ１８０＿４２ */
     zrntokuyakukoumokuv180x43 ,         /* （連携用）特約項目Ｖ１８０＿４３ */
     zrntokuyakukoumokuv180x44 ,         /* （連携用）特約項目Ｖ１８０＿４４ */
     zrntokuyakukoumokuv180x45 ,         /* （連携用）特約項目Ｖ１８０＿４５ */
     zrntokuyakukoumokuv180x46 ,         /* （連携用）特約項目Ｖ１８０＿４６ */
     zrntokuyakukoumokuv180x47 ,         /* （連携用）特約項目Ｖ１８０＿４７ */
     zrntokuyakukoumokuv180x48 ,         /* （連携用）特約項目Ｖ１８０＿４８ */
     zrntokuyakukoumokuv180x49 ,         /* （連携用）特約項目Ｖ１８０＿４９ */
     zrntokuyakukoumokuv180x50           /* （連携用）特約項目Ｖ１８０＿５０ */
FROM ZT_TjHitsyyugkNplusZeroRn_Z;