CREATE TABLE BM_FundIndexSyokitousi (
     unitfundkbn                                        VARCHAR     (3)                                                       NOT NULL  ,  /* ユニットファンド区分                                    */
     fundhyoukaymd                                      VARCHAR     (8)                                                       NOT NULL  ,  /* ファンド評価年月日　　　　                                 */
     segkey                                             VARCHAR     (1)                                                       NOT NULL  ,  /* ＳＥＧＫＥＹ　　　　　　　　                                */
     syokisegsakuseijiyuu                               VARCHAR     (1)                                                                 ,  /* 初期投資ＳＥＧ作成事由                                   */
     syokitousisetteigaku                               NUMBER      (13)                                                                ,  /* 初期投資設定額                                       */
     syokitousisetteigaku$                              VARCHAR     (10)                                                                ,  /* 初期投資設定額(通貨型)                                  */
     syokigoukeihensaigaku                              NUMBER      (13)                                                                ,  /* 初期投資合計返済額                                     */
     syokigoukeihensaigaku$                             VARCHAR     (10)                                                                ,  /* 初期投資合計返済額(通貨型)                                */
     syokirisokuhensaigaku                              NUMBER      (11)                                                                ,  /* 初期投資利息返済額                                     */
     syokirisokuhensaigaku$                             VARCHAR     (10)                                                                ,  /* 初期投資利息返済額(通貨型)                                */
     syokigankinhensaigaku                              NUMBER      (13)                                                                ,  /* 初期投資元金返済額                                     */
     syokigankinhensaigaku$                             VARCHAR     (10)                                                                ,  /* 初期投資元金返済額(通貨型)                                */
     syokitousirisoku                                   NUMBER      (11)                                                                ,  /* 初期投資利息                                        */
     syokitousirisoku$                                  VARCHAR     (10)                                                                ,  /* 初期投資利息(通貨型)                                   */
     syokigankinkuriiregaku                             NUMBER      (13)                                                                ,  /* 初期投資元金繰入金額                                    */
     syokigankinkuriiregaku$                            VARCHAR     (10)                                                                ,  /* 初期投資元金繰入金額(通貨型)                               */
     gksyokitousisetteigaku                             NUMBER      (15)                                                                ,  /* （外貨）初期投資設定額                                   */
     gksyokitousisetteigaku$                            VARCHAR     (10)                                                                ,  /* （外貨）初期投資設定額(通貨型)                              */
     gksyokigoukeihensaigaku                            NUMBER      (15)                                                                ,  /* （外貨）初期投資合計返済額                                 */
     gksyokigoukeihensaigaku$                           VARCHAR     (10)                                                                ,  /* （外貨）初期投資合計返済額(通貨型)                            */
     gksyokirisokuhensaigaku                            NUMBER      (15)                                                                ,  /* （外貨）初期投資利息返済額                                 */
     gksyokirisokuhensaigaku$                           VARCHAR     (10)                                                                ,  /* （外貨）初期投資利息返済額(通貨型)                            */
     gksyokigankinhensaigaku                            NUMBER      (15)                                                                ,  /* （外貨）初期投資元金返済額                                 */
     gksyokigankinhensaigaku$                           VARCHAR     (10)                                                                ,  /* （外貨）初期投資元金返済額(通貨型)                            */
     gksyokitousirisoku                                 NUMBER      (15)                                                                ,  /* （外貨）初期投資利息                                    */
     gksyokitousirisoku$                                VARCHAR     (10)                                                                ,  /* （外貨）初期投資利息(通貨型)                               */
     gksyokigankinkuriiregaku                           NUMBER      (15)                                                                ,  /* （外貨）初期投資元金繰入金額                                */
     gksyokigankinkuriiregaku$                          VARCHAR     (10)                                                                ,  /* （外貨）初期投資元金繰入金額(通貨型)                           */
     syokitousigankinkrirkbn                            VARCHAR     (1)                                                                 ,  /* 初期投資元金繰入区分                                    */
     zenkaistsegsakuseiymd                              VARCHAR     (8)                                                                 ,  /* 前回初期投資ＳＥＧ作成年月日                                */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE BM_FundIndexSyokitousi ADD CONSTRAINT PK_FundIndexSyokitousi PRIMARY KEY (
     unitfundkbn                                              , /* ユニットファンド区分                                     */
     fundhyoukaymd                                            , /* ファンド評価年月日　　　　                                  */
     segkey                                                     /* ＳＥＧＫＥＹ　　　　　　　　                                 */
) ;
