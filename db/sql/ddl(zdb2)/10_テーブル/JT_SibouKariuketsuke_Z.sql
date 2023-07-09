CREATE TABLE JT_SibouKariuketsuke_Z (
     skno                                               VARCHAR     (18)                                                      NOT NULL  ,  /* 請求番号 */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     sibouymd                                           VARCHAR     (8)                                                                 ,  /* 死亡日 */
     geninkbn                                           VARCHAR     (2)                                                                 ,  /* 原因区分 */
     torikesiflg                                        VARCHAR     (1)                                                                 ,  /* 取消フラグ */
     kossyoricd                                         VARCHAR     (50)                                                                ,  /* 更新処理コード */
     kossyorisscd                                       VARCHAR     (50)                                                                ,  /* 更新処理詳細コード */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE JT_SibouKariuketsuke_Z ADD CONSTRAINT PK_SibouKariuketsuke PRIMARY KEY (
     skno                                                     , /* 請求番号 */
     syono                                                      /* 証券番号 */
) ;
