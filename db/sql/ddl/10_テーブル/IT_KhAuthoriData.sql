CREATE TABLE IT_KhAuthoriData (
     ansyuusyskbn                                       VARCHAR     (1)                                                       NOT NULL  ,  /* 案内収納用システム区分 */
     syoriYmd                                           VARCHAR     (8)                                                       NOT NULL  ,  /* 処理年月日 */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     authorikaisuu                                      NUMBER      (2)                                                       NOT NULL  ,  /* オーソリ回数 */
     creditcardno1                                      VARCHAR     (32)                                                                ,  /* クレジットカード番号１ */
     creditcardno2                                      VARCHAR     (32)                                                                ,  /* クレジットカード番号２ */
     creditcardno3                                      VARCHAR     (32)                                                                ,  /* クレジットカード番号３ */
     creditcardno4                                      VARCHAR     (32)                                                                ,  /* クレジットカード番号４ */
     creditcardykkigen                                  VARCHAR     (32)                                                                ,  /* クレジットカード有効期限 */
     authorigk                                          NUMBER      (13)                                                                ,  /* オーソリ金額 */
     authorigk$                                         VARCHAR     (10)                                                                ,  /* オーソリ金額(通貨型) */
     jkipjytym                                          VARCHAR     (6)                                                                 ,  /* 次回Ｐ充当年月 */
     hrkkaisuu                                          VARCHAR     (2)                                                                 ,  /* 払込回数 */
     gaiburenkeikakujkkbn                               VARCHAR     (1)                                                                 ,  /* 外部連携確認状況区分 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE IT_KhAuthoriData ADD CONSTRAINT PK_KhAuthoriData PRIMARY KEY (
     ansyuusyskbn                                             , /* 案内収納用システム区分 */
     syoriYmd                                                 , /* 処理年月日 */
     syono                                                    , /* 証券番号 */
     authorikaisuu                                              /* オーソリ回数 */
) ;
