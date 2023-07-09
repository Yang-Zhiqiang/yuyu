CREATE TABLE HT_JigyouIkkatu_Z (
     daimosno                                           VARCHAR     (20)                                                      NOT NULL  ,  /* 代表申込番号 */
     mosnrkumu                                          VARCHAR     (1)                                                                 ,  /* 申込書入力有無 */
     kktnrkumu                                          VARCHAR     (1)                                                                 ,  /* 告知書入力有無 */
     hjynrkumu                                          VARCHAR     (1)                                                                 ,  /* 報状入力有無 */
     nyknnrkumu                                         VARCHAR     (1)                                                                 ,  /* 入金入力有無 */
     nyknwarinrkumu                                     VARCHAR     (1)                                                                 ,  /* 入金割当入力有無 */
     itijiketnrkumu                                     VARCHAR     (1)                                                                 ,  /* １次決定入力有無 */
     jiketteikbn                                        VARCHAR     (2)                                                                 ,  /* 事業一括決定状態区分 */
     jgyiktsrkbn                                        VARCHAR     (2)                                                                 ,  /* 事業一括成立区分 */
     jgyiktsrymd                                        VARCHAR     (8)                                                                 ,  /* 事業一括成立日 */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE HT_JigyouIkkatu_Z ADD CONSTRAINT PK_JigyouIkkatu PRIMARY KEY (
     daimosno                                                   /* 代表申込番号 */
) ;
