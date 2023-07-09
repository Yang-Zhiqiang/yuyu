CREATE TABLE HM_KetteiSya_Z (
     ketsyacd                                           VARCHAR     (15)                                                      NOT NULL  ,  /* 決定者コード */
     palketsyacd                                        VARCHAR     (2)                                                                 ,  /* ＰＡＬ決定者コード */
     ketsyanm                                           VARCHAR     (32)                                                                ,  /* 決定者名 */
     mostenkenrankkbn                                   VARCHAR     (2)                                                                 ,  /* 申込点検ランク区分 */
     knksateirankkbn                                    VARCHAR     (2)                                                                 ,  /* 環境査定ランク区分 */
     knksateijygns                                      DECIMAL     (13)                                                                ,  /* 環境査定上限Ｓ */
     knksateijygns$                                     VARCHAR     (10)                                                                ,  /* 環境査定上限Ｓ(通貨型) */
     imusateirankkbn                                    VARCHAR     (2)                                                                 ,  /* 医務査定ランク区分 */
     imusateijygns                                      DECIMAL     (13)                                                                ,  /* 医務査定上限Ｓ */
     imusateijygns$                                     VARCHAR     (10)                                                                ,  /* 医務査定上限Ｓ(通貨型) */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE HM_KetteiSya_Z ADD CONSTRAINT PK_KetteiSya PRIMARY KEY (
     ketsyacd                                                   /* 決定者コード */
) ;
