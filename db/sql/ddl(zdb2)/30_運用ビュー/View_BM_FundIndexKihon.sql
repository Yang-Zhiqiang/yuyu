CREATE VIEW BM_FundIndexKihon AS SELECT
     unitfundkbn ,         /* ユニットファンド区分 */
     fundhyoukaymd ,         /* ファンド評価年月日　　　　 */
     fundkaisetuymd ,         /* ファンド開設年月日 */
     fundindex ,         /* ファンドインデックス */
     fundindexkeisankbn ,         /* ファンドインデックス計算区分 */
     unyoustartjisisankagaku ,         /* 運用開始時資産価額 */
     unyoustartjisisankagaku$ ,         /* 運用開始時資産価額(通貨型) */
     unyouendjisisankagaku ,         /* 運用終了時資産価額 */
     unyouendjisisankagaku$ ,         /* 運用終了時資産価額(通貨型) */
     cfkasangosisankagaku ,         /* ＣＦ加算後資産価額 */
     cfkasangosisankagaku$ ,         /* ＣＦ加算後資産価額(通貨型) */
     unyoustartjicfgaku ,         /* 運用開始時ＣＦ額 */
     unyoustartjicfgaku$ ,         /* 運用開始時ＣＦ額(通貨型) */
     unyoujisonekigaku ,         /* 運用時損益額 */
     unyoujisonekigaku$ ,         /* 運用時損益額(通貨型) */
     unyougocfgaku ,         /* 運用後ＣＦ額 */
     unyougocfgaku$ ,         /* 運用後ＣＦ額(通貨型) */
     saiteihosyounichigaku ,         /* 最低保障コスト日額 */
     saiteihosyounichigaku$ ,         /* 最低保障コスト日額(通貨型) */
     saiteihosyougekkangaku ,         /* 最低保障コスト月間累積額 */
     saiteihosyougekkangaku$ ,         /* 最低保障コスト月間累積額(通貨型) */
     gkunyoustartjisisankagaku ,         /* （外貨）運用開始時ＣＦ額 */
     gkunyoustartjisisankagaku$ ,         /* （外貨）運用開始時ＣＦ額(通貨型) */
     gkunyouendjisisankagaku ,         /* （外貨）運用終了時資産価額 */
     gkunyouendjisisankagaku$ ,         /* （外貨）運用終了時資産価額(通貨型) */
     gkcfkasangosisankagaku ,         /* （外貨）ＣＦ加算後資産価額 */
     gkcfkasangosisankagaku$ ,         /* （外貨）ＣＦ加算後資産価額(通貨型) */
     gkunyoustartjicfgaku ,         /* （外貨）運用開始時ＣＦ額 */
     gkunyoustartjicfgaku$ ,         /* （外貨）運用開始時ＣＦ額(通貨型) */
     gkunyoujisonekigaku ,         /* （外貨）運用時損益額 */
     gkunyoujisonekigaku$ ,         /* （外貨）運用時損益額(通貨型) */
     gkunyougocfgaku ,         /* （外貨）運用後ＣＦ額 */
     gkunyougocfgaku$ ,         /* （外貨）運用後ＣＦ額(通貨型) */
     starttousiganrigoukei ,         /* 開始初期投資元利合計残高 */
     starttousiganrigoukei$ ,         /* 開始初期投資元利合計残高(通貨型) */
     gkstarttousiganrigoukei ,         /* （外貨）開始初期投資元利合計残高 */
     gkstarttousiganrigoukei$ ,         /* （外貨）開始初期投資元利合計残高(通貨型) */
     saisinsyokitousisegymd ,         /* 最新初期投資ＳＥＧ評価年月日 */
     unyougocfmikakuteihyouji ,         /* 運用後ＣＦ未確定表示 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_FundIndexKihon_Z;