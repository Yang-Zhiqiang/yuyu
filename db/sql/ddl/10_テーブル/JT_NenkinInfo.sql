CREATE TABLE JT_NenkinInfo (
     skno                                               VARCHAR     (18)                                                      NOT NULL  ,  /* 請求番号                                          */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号                                          */
     seikyuurirekino                                    NUMBER      (3)                                                       NOT NULL  ,  /* 請求履歴番号                                        */
     nkkknsetymd                                        VARCHAR     (8)                                                                 ,  /* 年金基金設定日                                       */
     nkshrstartymd                                      VARCHAR     (8)                                                                 ,  /* 年金支払開始日                                       */
     nkshrtkyknksyukbn                                  VARCHAR     (1)                                                                 ,  /* 年金支払特約年金種類区分                                  */
     nkshrtkyknksyukkn                                  NUMBER      (2)                                                                 ,  /* 年金支払特約年金期間                                    */
     bnshrkaisuu                                        VARCHAR     (2)                                                                 ,  /* 分割支払回数                                        */
     nkhaitoukinuketorihoukbn                           VARCHAR     (1)                                                                 ,  /* 年金配当金受取方法区分                                   */
     teinkkikingkgaika                                  NUMBER      (13)                                                                ,  /* 定額年金年金基金額（外貨）                                 */
     teinkkikingkgaika$                                 VARCHAR     (10)                                                                ,  /* 定額年金年金基金額（外貨）(通貨型)                            */
     teinkkikingken                                     NUMBER      (13)                                                                ,  /* 定額年金年金基金額（円貨）                                 */
     teinkkikingken$                                    VARCHAR     (10)                                                                ,  /* 定額年金年金基金額（円貨）(通貨型)                            */
     htykeihi                                           NUMBER      (13)                                                                ,  /* 必要経費                                          */
     htykeihi$                                          VARCHAR     (10)                                                                ,  /* 必要経費(通貨型)                                     */
     yenhtykeihi                                        NUMBER      (13)                                                                ,  /* 円換算必要経費                                       */
     yenhtykeihi$                                       VARCHAR     (10)                                                                ,  /* 円換算必要経費(通貨型)                                  */
     nknengk                                            NUMBER      (13)                                                                ,  /* 年金年額                                          */
     nknengk$                                           VARCHAR     (10)                                                                ,  /* 年金年額(通貨型)                                     */
     bnktnkgk                                           NUMBER      (13)                                                                ,  /* 分割年金額                                         */
     bnktnkgk$                                          VARCHAR     (10)                                                                ,  /* 分割年金額(通貨型)                                    */
     kossyoricd                                         VARCHAR     (50)                                                                ,  /* 更新処理コード                                       */
     kossyorisscd                                       VARCHAR     (50)                                                                ,  /* 更新処理詳細コード                                     */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ                                      */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間                                       */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE JT_NenkinInfo ADD CONSTRAINT PK_NenkinInfo PRIMARY KEY (
     skno                                                     , /* 請求番号                                           */
     syono                                                    , /* 証券番号                                           */
     seikyuurirekino                                            /* 請求履歴番号                                         */
) ;
