CREATE TABLE MT_DsSoukinyouKouza (
     dskokno                                            VARCHAR     (10)                                                      NOT NULL  ,  /* ＤＳ顧客番号 */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     kzsyuruikbn                                        VARCHAR     (1)                                                       NOT NULL  ,  /* 口座種類区分 */
     bankcd                                             VARCHAR     (4)                                                                 ,  /* 銀行コード */
     sitencd                                            VARCHAR     (3)                                                                 ,  /* 支店コード */
     yokinkbn                                           VARCHAR     (1)                                                                 ,  /* 預金種目区分 */
     kouzano                                            VARCHAR     (12)                                                                ,  /* 口座番号 */
     kzdoukbn                                           VARCHAR     (1)                                                                 ,  /* 口座名義人同一区分 */
     kzmeiginmkn                                        VARCHAR     (30)                                                                ,  /* 口座名義人氏名（カナ） */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE MT_DsSoukinyouKouza ADD CONSTRAINT PK_DsSoukinyouKouza PRIMARY KEY (
     dskokno                                                  , /* ＤＳ顧客番号 */
     syono                                                    , /* 証券番号 */
     kzsyuruikbn                                                /* 口座種類区分 */
) ;

CREATE INDEX IX1_DsSoukinyouKouza ON MT_DsSoukinyouKouza (
     bankcd                                                   , /* 銀行コード */
     sitencd                                                    /* 支店コード */
) ;
