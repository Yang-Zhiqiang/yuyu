CREATE TABLE JM_TokusyuKyuHantei_Z (
     byoumeitourokuno                                   VARCHAR     (6)                                                       NOT NULL  ,  /* 病名登録番号 */
     syouhncd                                           VARCHAR     (4)                                                       NOT NULL  ,  /* 商品コード */
     syouhnsdno                                         DECIMAL     (2)                                                       NOT NULL  ,  /* 商品世代番号 */
     tekiyoukknfrom                                     VARCHAR     (8)                                                       NOT NULL  ,  /* 適用期間（自） */
     tekiyoukknkto                                      VARCHAR     (8)                                                       NOT NULL  ,  /* 適用期間（至） */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE JM_TokusyuKyuHantei_Z ADD CONSTRAINT PK_TokusyuKyuHantei PRIMARY KEY (
     byoumeitourokuno                                         , /* 病名登録番号 */
     syouhncd                                                 , /* 商品コード */
     syouhnsdno                                               , /* 商品世代番号 */
     tekiyoukknfrom                                           , /* 適用期間（自） */
     tekiyoukknkto                                              /* 適用期間（至） */
) ;
