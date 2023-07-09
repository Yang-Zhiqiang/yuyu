CREATE TABLE HM_SkChannel_Z (
     channelcd                                          VARCHAR     (2)                                                       NOT NULL  ,  /* チャネルコード */
     oyadrtencd                                         VARCHAR     (7)                                                       NOT NULL  ,  /* 親代理店コード */
     aisyoumeichannelkbn                                VARCHAR     (2)                                                                 ,  /* 愛称名チャネル区分 */
     skeijimukbn                                        VARCHAR     (2)                                                                 ,  /* 新契約事務区分 */
     tyhyrenrakusikibetukbn                             VARCHAR     (2)                                                                 ,  /* 帳票連絡先識別区分 */
     sortNo                                             DECIMAL     (3)                                                                 ,  /* ソート番号 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                             ,  /* バージョン */
     kiteichkchannelcd                                  VARCHAR     (2)                                                                    /* 規定チェック用チャネルコード */
)
;

ALTER TABLE HM_SkChannel_Z ADD CONSTRAINT PK_SkChannel PRIMARY KEY (
     channelcd                                                , /* チャネルコード */
     oyadrtencd                                                 /* 親代理店コード */
) ;
