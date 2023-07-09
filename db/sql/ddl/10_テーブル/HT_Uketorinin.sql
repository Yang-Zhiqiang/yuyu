CREATE TABLE HT_Uketorinin (
     mosno                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 申込番号 */
     uktsyukbn                                          VARCHAR     (2)                                                       NOT NULL  ,  /* 受取人種類区分 */
     uktsyurenno                                        NUMBER      (2)                                                       NOT NULL  ,  /* 受取人種類別連番 */
     uktkbn                                             VARCHAR     (2)                                                                 ,  /* 受取人区分 */
     uktnmkn                                            VARCHAR     (18)                                                                ,  /* 受取人名（カナ） */
     uktnmkj                                            VARCHAR     (15)                                                                ,  /* 受取人名（漢字） */
     uktnmkjkhukakbn                                    VARCHAR     (1)                                                                 ,  /* 受取人名漢字化不可区分 */
     ukttdk                                             VARCHAR     (2)                                                                 ,  /* 受取人続柄 */
     uktbnwari                                          NUMBER      (3)                                                                 ,  /* 受取人分割割合 */
     uktseiymd                                          VARCHAR     (8)                                                                 ,  /* 受取人生年月日 */
     ukttsindousiteikbn                                 VARCHAR     (1)                                                                 ,  /* 受取人通信先同一指定区分 */
     uktyno                                             VARCHAR     (7)                                                                 ,  /* 受取人郵便番号 */
     uktadr1kj                                          VARCHAR     (30)                                                                ,  /* 受取人住所１（漢字） */
     uktadr2kj                                          VARCHAR     (30)                                                                ,  /* 受取人住所２（漢字） */
     uktadr3kj                                          VARCHAR     (30)                                                                ,  /* 受取人住所３（漢字） */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE HT_Uketorinin ADD CONSTRAINT PK_Uketorinin PRIMARY KEY (
     mosno                                                    , /* 申込番号 */
     uktsyukbn                                                , /* 受取人種類区分 */
     uktsyurenno                                                /* 受取人種類別連番 */
) ;
