CREATE TABLE IT_YuukouKakErrorList_Z (
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     creditkessaiyouno                                  VARCHAR     (26)                                                      NOT NULL  ,  /* クレジットカード決済用番号 */
     syoriym                                            VARCHAR     (6)                                                       NOT NULL  ,  /* 処理年月 */
     credityuukoukakym                                  VARCHAR     (6)                                                                 ,  /* クレジットカード有効確認年月 */
     credityuukoukakkekka                               VARCHAR     (1)                                                                 ,  /* クレジットカード有効確認結果 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE IT_YuukouKakErrorList_Z ADD CONSTRAINT PK_YuukouKakErrorList PRIMARY KEY (
     syono                                                    , /* 証券番号 */
     creditkessaiyouno                                        , /* クレジットカード決済用番号 */
     syoriym                                                    /* 処理年月 */
) ;
