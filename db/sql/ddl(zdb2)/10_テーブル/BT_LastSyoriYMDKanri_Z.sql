CREATE TABLE BT_LastSyoriYMDKanri_Z (
     lastsyoriymdkanrikbn                               VARCHAR     (2)                                                       NOT NULL  ,  /* 最終処理日管理区分 */
     lastsyoriymd                                       VARCHAR     (8)                                                                 ,  /* 最終処理日 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE BT_LastSyoriYMDKanri_Z ADD CONSTRAINT PK_LastSyoriYMDKanri PRIMARY KEY (
     lastsyoriymdkanrikbn                                       /* 最終処理日管理区分 */
) ;
