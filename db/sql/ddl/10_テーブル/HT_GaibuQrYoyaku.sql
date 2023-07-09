CREATE TABLE HT_GaibuQrYoyaku (
     syoriYmd                                           VARCHAR     (8)                                                       NOT NULL  ,  /* 処理年月日 */
     skeijimukbn                                        VARCHAR     (2)                                                       NOT NULL  ,  /* 新契約事務区分 */
     hknsyuruino                                        VARCHAR     (3)                                                       NOT NULL  ,  /* 保険種類番号 */
     sakuseikensuu                                      NUMBER      (5)                                                                 ,  /* 作成件数 */
     qrsakuseiymd                                       VARCHAR     (8)                                                                 ,  /* ＱＲ作成日 */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE HT_GaibuQrYoyaku ADD CONSTRAINT PK_GaibuQrYoyaku PRIMARY KEY (
     syoriYmd                                                 , /* 処理年月日 */
     skeijimukbn                                              , /* 新契約事務区分 */
     hknsyuruino                                                /* 保険種類番号 */
) ;
