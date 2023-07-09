CREATE TABLE BM_FundIndexKihon_Z (
     unitfundkbn                                        VARCHAR     (3)                                                       NOT NULL  ,  /* ユニットファンド区分 */
     fundhyoukaymd                                      VARCHAR     (8)                                                       NOT NULL  ,  /* ファンド評価年月日　　　　 */
     fundkaisetuymd                                     VARCHAR     (8)                                                                 ,  /* ファンド開設年月日 */
     fundindex                                          DECIMAL     (13,10)                                                             ,  /* ファンドインデックス */
     fundindexkeisankbn                                 VARCHAR     (1)                                                                 ,  /* ファンドインデックス計算区分 */
     unyoustartjisisankagaku                            DECIMAL     (15)                                                                ,  /* 運用開始時資産価額 */
     unyoustartjisisankagaku$                           VARCHAR     (10)                                                                ,  /* 運用開始時資産価額(通貨型) */
     unyouendjisisankagaku                              DECIMAL     (15)                                                                ,  /* 運用終了時資産価額 */
     unyouendjisisankagaku$                             VARCHAR     (10)                                                                ,  /* 運用終了時資産価額(通貨型) */
     cfkasangosisankagaku                               DECIMAL     (15)                                                                ,  /* ＣＦ加算後資産価額 */
     cfkasangosisankagaku$                              VARCHAR     (10)                                                                ,  /* ＣＦ加算後資産価額(通貨型) */
     unyoustartjicfgaku                                 DECIMAL     (13)                                                                ,  /* 運用開始時ＣＦ額 */
     unyoustartjicfgaku$                                VARCHAR     (10)                                                                ,  /* 運用開始時ＣＦ額(通貨型) */
     unyoujisonekigaku                                  DECIMAL     (13)                                                                ,  /* 運用時損益額 */
     unyoujisonekigaku$                                 VARCHAR     (10)                                                                ,  /* 運用時損益額(通貨型) */
     unyougocfgaku                                      DECIMAL     (13)                                                                ,  /* 運用後ＣＦ額 */
     unyougocfgaku$                                     VARCHAR     (10)                                                                ,  /* 運用後ＣＦ額(通貨型) */
     saiteihosyounichigaku                              DECIMAL     (11)                                                                ,  /* 最低保障コスト日額 */
     saiteihosyounichigaku$                             VARCHAR     (10)                                                                ,  /* 最低保障コスト日額(通貨型) */
     saiteihosyougekkangaku                             DECIMAL     (11)                                                                ,  /* 最低保障コスト月間累積額 */
     saiteihosyougekkangaku$                            VARCHAR     (10)                                                                ,  /* 最低保障コスト月間累積額(通貨型) */
     gkunyoustartjisisankagaku                          DECIMAL     (15)                                                                ,  /* （外貨）運用開始時ＣＦ額 */
     gkunyoustartjisisankagaku$                         VARCHAR     (10)                                                                ,  /* （外貨）運用開始時ＣＦ額(通貨型) */
     gkunyouendjisisankagaku                            DECIMAL     (15)                                                                ,  /* （外貨）運用終了時資産価額 */
     gkunyouendjisisankagaku$                           VARCHAR     (10)                                                                ,  /* （外貨）運用終了時資産価額(通貨型) */
     gkcfkasangosisankagaku                             DECIMAL     (15)                                                                ,  /* （外貨）ＣＦ加算後資産価額 */
     gkcfkasangosisankagaku$                            VARCHAR     (10)                                                                ,  /* （外貨）ＣＦ加算後資産価額(通貨型) */
     gkunyoustartjicfgaku                               DECIMAL     (15)                                                                ,  /* （外貨）運用開始時ＣＦ額 */
     gkunyoustartjicfgaku$                              VARCHAR     (10)                                                                ,  /* （外貨）運用開始時ＣＦ額(通貨型) */
     gkunyoujisonekigaku                                DECIMAL     (15)                                                                ,  /* （外貨）運用時損益額 */
     gkunyoujisonekigaku$                               VARCHAR     (10)                                                                ,  /* （外貨）運用時損益額(通貨型) */
     gkunyougocfgaku                                    DECIMAL     (15)                                                                ,  /* （外貨）運用後ＣＦ額 */
     gkunyougocfgaku$                                   VARCHAR     (10)                                                                ,  /* （外貨）運用後ＣＦ額(通貨型) */
     starttousiganrigoukei                              DECIMAL     (13)                                                                ,  /* 開始初期投資元利合計残高 */
     starttousiganrigoukei$                             VARCHAR     (10)                                                                ,  /* 開始初期投資元利合計残高(通貨型) */
     gkstarttousiganrigoukei                            DECIMAL     (15)                                                                ,  /* （外貨）開始初期投資元利合計残高 */
     gkstarttousiganrigoukei$                           VARCHAR     (10)                                                                ,  /* （外貨）開始初期投資元利合計残高(通貨型) */
     saisinsyokitousisegymd                             VARCHAR     (8)                                                                 ,  /* 最新初期投資ＳＥＧ評価年月日 */
     unyougocfmikakuteihyouji                           VARCHAR     (1)                                                                 ,  /* 運用後ＣＦ未確定表示 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE BM_FundIndexKihon_Z ADD CONSTRAINT PK_FundIndexKihon PRIMARY KEY (
     unitfundkbn                                              , /* ユニットファンド区分 */
     fundhyoukaymd                                              /* ファンド評価年月日　　　　 */
) ;
