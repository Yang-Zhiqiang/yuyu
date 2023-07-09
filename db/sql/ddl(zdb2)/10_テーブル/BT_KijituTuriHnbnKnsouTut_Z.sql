CREATE TABLE BT_KijituTuriHnbnKnsouTut_Z (
     syoriYmd                                           VARCHAR     (8)                                                       NOT NULL  ,  /* 処理年月日 */
     subSystemId                                        VARCHAR     (50)                                                      NOT NULL  ,  /* サブシステムＩＤ */
     tysytno                                            DECIMAL     (3)                                                       NOT NULL  ,  /* 抽出番号 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE BT_KijituTuriHnbnKnsouTut_Z ADD CONSTRAINT PK_KijituTuriHnbnKnsouTut PRIMARY KEY (
     syoriYmd                                                 , /* 処理年月日 */
     subSystemId                                              , /* サブシステムＩＤ */
     tysytno                                                    /* 抽出番号 */
) ;
