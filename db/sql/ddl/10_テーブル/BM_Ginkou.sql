CREATE TABLE BM_Ginkou (
     bankcd                                             VARCHAR     (4)                                                       NOT NULL  ,  /* 銀行コード */
     sitencd                                            VARCHAR     (3)                                                       NOT NULL  ,  /* 支店コード */
     kousinymd                                          VARCHAR     (8)                                                                 ,  /* 更新年月日 */
     sinsetuymd                                         VARCHAR     (8)                                                                 ,  /* 新設年月日 */
     haisiymd                                           VARCHAR     (8)                                                                 ,  /* 廃止年月日 */
     banknmkn                                           VARCHAR     (25)                                                                ,  /* 銀行名（カナ） */
     sitennmkn                                          VARCHAR     (25)                                                                ,  /* 支店名（カナ） */
     banknmkj                                           VARCHAR     (20)                                                                ,  /* 銀行名（漢字） */
     sitennmkj                                          VARCHAR     (20)                                                                ,  /* 支店名（漢字） */
     banknmej                                           VARCHAR     (60)                                                                ,  /* 銀行名（英字） */
     sitennmej                                          VARCHAR     (60)                                                                ,  /* 支店名（英字） */
     csskyouteikaisiymd                                 VARCHAR     (8)                                                                 ,  /* ＣＳＳ協定開始年月日 */
     csskyouteikaijyoymd                                VARCHAR     (8)                                                                 ,  /* ＣＳＳ協定解除年月日 */
     kokunaikwskameihyj                                 VARCHAR     (1)                                                                 ,  /* 内国為替制度加盟表示 */
     hrkmKanouihyj                                      VARCHAR     (1)                                                                 ,  /* 振込可能支店表示 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE BM_Ginkou ADD CONSTRAINT PK_Ginkou PRIMARY KEY (
     bankcd                                                   , /* 銀行コード */
     sitencd                                                    /* 支店コード */
) ;

CREATE INDEX IX1_Ginkou ON BM_Ginkou (
     sitencd                                                    /* 支店コード */
) ;

CREATE INDEX IX2_Ginkou ON BM_Ginkou (
     banknmkn                                                   /* 銀行名（カナ） */
) ;

CREATE INDEX IX3_Ginkou ON BM_Ginkou (
     sitennmkn                                                  /* 支店名（カナ） */
) ;

CREATE INDEX IX4_Ginkou ON BM_Ginkou (
     banknmkj                                                   /* 銀行名（漢字） */
) ;

CREATE INDEX IX5_Ginkou ON BM_Ginkou (
     sitennmkj                                                  /* 支店名（漢字） */
) ;
