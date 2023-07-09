CREATE TABLE MT_DsHenkouRireki (
     dskokno                                            VARCHAR     (10)                                                      NOT NULL  ,  /* ＤＳ顧客番号                                        */
     henkousikibetukey                                  VARCHAR     (18)                                                      NOT NULL  ,  /* 変更識別キー                                        */
     renno                                              NUMBER      (2)                                                       NOT NULL  ,  /* 連番                                            */
     tablenm                                            VARCHAR     (50)                                                                ,  /* テーブル名称                                        */
     tableid                                            VARCHAR     (100)                                                               ,  /* テーブルＩＤ                                        */
     hnksyuruikbn                                       VARCHAR     (1)                                                                 ,  /* 変更種類区分                                        */
     hanbetukoumokunm                                   VARCHAR     (100)                                                               ,  /* 判別項目名                                         */
     henkoukoumokuid                                    VARCHAR     (50)                                                                ,  /* 変更項目ID                                        */
     henkoukoumokunm                                    VARCHAR     (100)                                                               ,  /* 変更項目名                                         */
     bfrnaiyouoriginal                                  VARCHAR     (100)                                                               ,  /* 変更前内容原本                                       */
     bfrnaiyou                                          VARCHAR     (600)                                                               ,  /* 変更前内容                                         */
     newnaiyouoriginal                                  VARCHAR     (100)                                                               ,  /* 変更後内容原本                                       */
     newnaiyou                                          VARCHAR     (100)                                                               ,  /* 変更後内容                                         */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ                                     */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間                                       */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ                                      */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE MT_DsHenkouRireki ADD CONSTRAINT PK_DsHenkouRireki PRIMARY KEY (
     dskokno                                                  , /* ＤＳ顧客番号                                         */
     henkousikibetukey                                        , /* 変更識別キー                                         */
     renno                                                      /* 連番                                             */
) ;
