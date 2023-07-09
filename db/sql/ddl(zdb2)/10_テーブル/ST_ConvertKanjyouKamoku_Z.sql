CREATE TABLE ST_ConvertKanjyouKamoku_Z (
     kanjyoukmkcd                                       VARCHAR     (5)                                                       NOT NULL  ,  /* 勘定科目コード */
     taisyakukbn                                        VARCHAR     (1)                                                       NOT NULL  ,  /* 貸借区分 */
     convertedkanjyoukmkcd                              VARCHAR     (5)                                                                 ,  /* 変換後勘定科目コード */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE ST_ConvertKanjyouKamoku_Z ADD CONSTRAINT PK_ConvertKanjyouKamoku PRIMARY KEY (
     kanjyoukmkcd                                             , /* 勘定科目コード */
     taisyakukbn                                                /* 貸借区分 */
) ;
