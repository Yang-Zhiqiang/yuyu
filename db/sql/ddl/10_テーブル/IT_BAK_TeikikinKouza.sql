CREATE TABLE IT_BAK_TeikikinKouza (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー                                          */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号                                          */
     trkssikibetukey                                    VARCHAR     (18)                                                      NOT NULL  ,  /* 取消識別キー                                        */
     kzsyuruikbn                                        VARCHAR     (1)                                                                 ,  /* 口座種類区分                                        */
     bankcd                                             VARCHAR     (4)                                                                 ,  /* 銀行コード                                         */
     sitencd                                            VARCHAR     (3)                                                                 ,  /* 支店コード                                         */
     yokinkbn                                           VARCHAR     (1)                                                                 ,  /* 預金種目区分                                        */
     kouzano                                            VARCHAR     (12)                                                                ,  /* 口座番号                                          */
     kzmeiginmkn                                        VARCHAR     (30)                                                                ,  /* 口座名義人氏名（カナ）                                   */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ                                     */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ                                      */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間                                       */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE IT_BAK_TeikikinKouza ADD CONSTRAINT PK_BAK_TeikikinKouza PRIMARY KEY (
     kbnkey                                                   , /* 区分キー                                           */
     syono                                                    , /* 証券番号                                           */
     trkssikibetukey                                            /* 取消識別キー                                         */
) ;
