CREATE TABLE BT_KijituTuriHnbnKnsouTutJk (
     subSystemId                                        VARCHAR     (50)                                                      NOT NULL  ,  /* サブシステムＩＤ */
     tysytno                                            NUMBER      (3)                                                       NOT NULL  ,  /* 抽出番号 */
     nikaimeikoutuutiyouhi                              VARCHAR     (1)                                                                 ,  /* ２回目以降通知要否 */
     tuutijkkbn                                         VARCHAR     (1)                                                                 ,  /* 通知状況区分 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE BT_KijituTuriHnbnKnsouTutJk ADD CONSTRAINT PK_KijituTuriHnbnKnsouTutJk PRIMARY KEY (
     subSystemId                                              , /* サブシステムＩＤ */
     tysytno                                                    /* 抽出番号 */
) ;
