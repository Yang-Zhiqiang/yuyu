CREATE TABLE BM_Channel (
     channelcd                                          VARCHAR     (2)                                                       NOT NULL  ,  /* チャネルコード                                       */
     channelnm                                          VARCHAR     (15)                                                                ,  /* チャネル名                                         */
     jimuschemekbn                                      VARCHAR     (2)                                                                 ,  /* 事務スキーム区分                                      */
     drtensikibetukbn                                   VARCHAR     (2)                                                                 ,  /* 代理店識別区分                                       */
     gwdrtensikibetukbn                                 VARCHAR     (2)                                                                 ,  /* ＧＷ代理店識別区分                                     */
     gwsousinsakisikibetusi                             VARCHAR     (21)                                                                ,  /* ＧＷ送信先識別子                                      */
     tyhyrenrakusikibetukbn                             VARCHAR     (2)                                                                 ,  /* 帳票連絡先識別区分                                     */
     sortNo                                             NUMBER      (3)                                                                 ,  /* ソート番号                                         */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE BM_Channel ADD CONSTRAINT PK_Channel PRIMARY KEY (
     channelcd                                                  /* チャネルコード                                        */
) ;
