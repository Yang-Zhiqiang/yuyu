CREATE TABLE JT_AksrendouzumiSyoruiImg_Z (
     skno                                               VARCHAR     (18)                                                      NOT NULL  ,  /* 請求番号 */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     imageid                                            VARCHAR     (20)                                                      NOT NULL  ,  /* イメージID */
     syoruiimagepagecnt                                 DECIMAL     (5)                                                                 ,  /* 書類イメージページ数 */
     syoruiCd                                           VARCHAR     (5)                                                                 ,  /* 書類コード */
     aksrendoupdffilenm                                 VARCHAR     (100)                                                               ,  /* ＡＫＳ連動用ＰＤＦファイル名 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE JT_AksrendouzumiSyoruiImg_Z ADD CONSTRAINT PK_AksrendouzumiSyoruiImg PRIMARY KEY (
     skno                                                     , /* 請求番号 */
     syono                                                    , /* 証券番号 */
     imageid                                                    /* イメージID */
) ;
