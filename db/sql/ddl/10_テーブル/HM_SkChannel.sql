CREATE TABLE HM_SkChannel (
     channelcd                                          VARCHAR     (2)                                                       NOT NULL  ,  /* チャネルコード */
     oyadrtencd                                         VARCHAR     (7)                                                       NOT NULL  ,  /* 親代理店コード */
     aisyoumeichannelkbn                                VARCHAR     (2)                                                                 ,  /* 愛称名チャネル区分 */
     kiteichkchannelcd                                  VARCHAR     (2)                                                                 ,  /* 規定チェック用チャネルコード */
     skeijimukbn                                        VARCHAR     (2)                                                                 ,  /* 新契約事務区分 */
     tyhyrenrakusikibetukbn                             VARCHAR     (2)                                                                 ,  /* 帳票連絡先識別区分 */
     sortNo                                             NUMBER      (3)                                                                 ,  /* ソート番号 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE HM_SkChannel ADD CONSTRAINT PK_SkChannel PRIMARY KEY (
     channelcd                                                , /* チャネルコード */
     oyadrtencd                                                 /* 親代理店コード */
) ;
