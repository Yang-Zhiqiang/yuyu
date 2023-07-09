CREATE TABLE BM_FundIndexSyokitousi_Z (
     unitfundkbn                                        VARCHAR     (3)                                                       NOT NULL  ,  /* ユニットファンド区分 */
     fundhyoukaymd                                      VARCHAR     (8)                                                       NOT NULL  ,  /* ファンド評価年月日　　　　 */
     segkey                                             VARCHAR     (1)                                                       NOT NULL  ,  /* ＳＥＧＫＥＹ　　　　　　　　 */
     syokisegsakuseijiyuu                               VARCHAR     (1)                                                                 ,  /* 初期投資ＳＥＧ作成事由 */
     syokitousisetteigaku                               DECIMAL     (13)                                                                ,  /* 初期投資設定額 */
     syokitousisetteigaku$                              VARCHAR     (10)                                                                ,  /* 初期投資設定額(通貨型) */
     syokigoukeihensaigaku                              DECIMAL     (13)                                                                ,  /* 初期投資合計返済額 */
     syokigoukeihensaigaku$                             VARCHAR     (10)                                                                ,  /* 初期投資合計返済額(通貨型) */
     syokirisokuhensaigaku                              DECIMAL     (11)                                                                ,  /* 初期投資利息返済額 */
     syokirisokuhensaigaku$                             VARCHAR     (10)                                                                ,  /* 初期投資利息返済額(通貨型) */
     syokigankinhensaigaku                              DECIMAL     (13)                                                                ,  /* 初期投資元金返済額 */
     syokigankinhensaigaku$                             VARCHAR     (10)                                                                ,  /* 初期投資元金返済額(通貨型) */
     syokitousirisoku                                   DECIMAL     (11)                                                                ,  /* 初期投資利息 */
     syokitousirisoku$                                  VARCHAR     (10)                                                                ,  /* 初期投資利息(通貨型) */
     syokigankinkuriiregaku                             DECIMAL     (13)                                                                ,  /* 初期投資元金繰入金額 */
     syokigankinkuriiregaku$                            VARCHAR     (10)                                                                ,  /* 初期投資元金繰入金額(通貨型) */
     gksyokitousisetteigaku                             DECIMAL     (15)                                                                ,  /* （外貨）初期投資設定額 */
     gksyokitousisetteigaku$                            VARCHAR     (10)                                                                ,  /* （外貨）初期投資設定額(通貨型) */
     gksyokigoukeihensaigaku                            DECIMAL     (15)                                                                ,  /* （外貨）初期投資合計返済額 */
     gksyokigoukeihensaigaku$                           VARCHAR     (10)                                                                ,  /* （外貨）初期投資合計返済額(通貨型) */
     gksyokirisokuhensaigaku                            DECIMAL     (15)                                                                ,  /* （外貨）初期投資利息返済額 */
     gksyokirisokuhensaigaku$                           VARCHAR     (10)                                                                ,  /* （外貨）初期投資利息返済額(通貨型) */
     gksyokigankinhensaigaku                            DECIMAL     (15)                                                                ,  /* （外貨）初期投資元金返済額 */
     gksyokigankinhensaigaku$                           VARCHAR     (10)                                                                ,  /* （外貨）初期投資元金返済額(通貨型) */
     gksyokitousirisoku                                 DECIMAL     (15)                                                                ,  /* （外貨）初期投資利息 */
     gksyokitousirisoku$                                VARCHAR     (10)                                                                ,  /* （外貨）初期投資利息(通貨型) */
     gksyokigankinkuriiregaku                           DECIMAL     (15)                                                                ,  /* （外貨）初期投資元金繰入金額 */
     gksyokigankinkuriiregaku$                          VARCHAR     (10)                                                                ,  /* （外貨）初期投資元金繰入金額(通貨型) */
     syokitousigankinkrirkbn                            VARCHAR     (1)                                                                 ,  /* 初期投資元金繰入区分 */
     zenkaistsegsakuseiymd                              VARCHAR     (8)                                                                 ,  /* 前回初期投資ＳＥＧ作成年月日 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE BM_FundIndexSyokitousi_Z ADD CONSTRAINT PK_FundIndexSyokitousi PRIMARY KEY (
     unitfundkbn                                              , /* ユニットファンド区分 */
     fundhyoukaymd                                            , /* ファンド評価年月日　　　　 */
     segkey                                                     /* ＳＥＧＫＥＹ　　　　　　　　 */
) ;
