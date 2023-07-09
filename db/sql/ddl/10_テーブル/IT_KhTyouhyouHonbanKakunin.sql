CREATE TABLE IT_KhTyouhyouHonbanKakunin (
     tyouhyoubunrui                                     VARCHAR     (1)                                                       NOT NULL  ,  /* 帳票分類 */
     syoruiCd                                           VARCHAR     (5)                                                       NOT NULL  ,  /* 書類コード */
     jyoukenbunrui1                                     VARCHAR     (3)                                                       NOT NULL  ,  /* 条件分類１ */
     jyoukenbunrui2                                     VARCHAR     (3)                                                       NOT NULL  ,  /* 条件分類２ */
     jyoukenbunrui3                                     VARCHAR     (3)                                                       NOT NULL  ,  /* 条件分類３ */
     kakuninjyoutaikbn                                  VARCHAR     (1)                                                                 ,  /* 確認状態区分 */
     honbankakuninstartymd                              VARCHAR     (8)                                                                 ,  /* 本番確認開始日 */
     firstkaisouymd                                     VARCHAR     (8)                                                                 ,  /* 初回回送日 */
     honbankakuninymd                                   VARCHAR     (8)                                                                 ,  /* 本番確認日 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE IT_KhTyouhyouHonbanKakunin ADD CONSTRAINT PK_KhTyouhyouHonbanKakunin PRIMARY KEY (
     tyouhyoubunrui                                           , /* 帳票分類 */
     syoruiCd                                                 , /* 書類コード */
     jyoukenbunrui1                                           , /* 条件分類１ */
     jyoukenbunrui2                                           , /* 条件分類２ */
     jyoukenbunrui3                                             /* 条件分類３ */
) ;
