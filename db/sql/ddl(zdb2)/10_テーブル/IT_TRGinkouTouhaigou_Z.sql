CREATE TABLE IT_TRGinkouTouhaigou_Z (
     bfrikkatuseibibankcd                               VARCHAR     (4)                                                       NOT NULL  ,  /* （変更前）一括整備用銀行コード */
     bfrikkatuseibisitencd                              VARCHAR     (3)                                                       NOT NULL  ,  /* （変更前）一括整備用支店コード */
     newikkatuseibibankcd                               VARCHAR     (4)                                                       NOT NULL  ,  /* （変更後）一括整備用銀行コード */
     newikkatuseibisitencd                              VARCHAR     (3)                                                       NOT NULL  ,  /* （変更後）一括整備用支店コード */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE IT_TRGinkouTouhaigou_Z ADD CONSTRAINT PK_TRGinkouTouhaigou PRIMARY KEY (
     bfrikkatuseibibankcd                                     , /* （変更前）一括整備用銀行コード */
     bfrikkatuseibisitencd                                      /* （変更前）一括整備用支店コード */
) ;
