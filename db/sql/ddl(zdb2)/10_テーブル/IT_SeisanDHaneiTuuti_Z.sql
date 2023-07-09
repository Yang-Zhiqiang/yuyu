CREATE TABLE IT_SeisanDHaneiTuuti_Z (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     haitounendo                                        VARCHAR     (4)                                                       NOT NULL  ,  /* 配当年度 */
     kakuteitounendod                                   DECIMAL     (13)                                                                ,  /* 確定当年度Ｄ */
     kakuteitounendod$                                  VARCHAR     (10)                                                                ,  /* 確定当年度Ｄ(通貨型) */
     naiteitounendod                                    DECIMAL     (13)                                                                ,  /* 内定当年度Ｄ */
     naiteitounendod$                                   VARCHAR     (10)                                                                ,  /* 内定当年度Ｄ(通貨型) */
     seisandkgk                                         DECIMAL     (13)                                                                ,  /* 精算Ｄ金額 */
     seisandkgk$                                        VARCHAR     (10)                                                                ,  /* 精算Ｄ金額(通貨型) */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE IT_SeisanDHaneiTuuti_Z ADD CONSTRAINT PK_SeisanDHaneiTuuti PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                    , /* 証券番号 */
     haitounendo                                                /* 配当年度 */
) ;

CREATE INDEX IX1_SeisanDHaneiTuuti ON IT_SeisanDHaneiTuuti_Z (
     syono                                                      /* 証券番号 */
) ;

CREATE INDEX IX2_SeisanDHaneiTuuti ON IT_SeisanDHaneiTuuti_Z (
     haitounendo                                                /* 配当年度 */
) ;
