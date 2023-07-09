CREATE TABLE WT_ImageArriveNotice (
     arriveKey                                          VARCHAR     (50)                                                      NOT NULL  ,  /* 到着キー                                          */
     torikomiSyoruiCd                                   VARCHAR     (30)                                                                ,  /* 取込書類コード                                       */
     gyoumuKey                                          VARCHAR     (20)                                                                ,  /* 業務キー                                          */
     flowId                                             VARCHAR     (19)                                                                ,  /* フローＩＤ                                         */
     subSystemId                                        VARCHAR     (50)                                                                ,  /* サブシステムＩＤ                                      */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE WT_ImageArriveNotice ADD CONSTRAINT PK_ArriveKey PRIMARY KEY (
     arriveKey                                                  /* 到着キー                                           */
) ;
