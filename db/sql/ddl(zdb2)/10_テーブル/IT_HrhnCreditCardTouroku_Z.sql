CREATE TABLE IT_HrhnCreditCardTouroku_Z (
     creditkessaiyouno                                  VARCHAR     (26)                                                      NOT NULL  ,  /* クレジットカード決済用番号 */
     syono                                              VARCHAR     (20)                                                                ,  /* 証券番号 */
     authorijkkbn                                       VARCHAR     (1)                                                                 ,  /* オーソリ状況区分 */
     cardbrandkbn                                       VARCHAR     (2)                                                                 ,  /* カードブランド区分 */
     creditkaiinnosimo4keta                             VARCHAR     (4)                                                                 ,  /* クレジット会員番号（下４桁） */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE IT_HrhnCreditCardTouroku_Z ADD CONSTRAINT PK_HrhnCreditCardTouroku PRIMARY KEY (
     creditkessaiyouno                                          /* クレジットカード決済用番号 */
) ;
