CREATE TABLE IT_Kouza_Z (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     kokno                                              VARCHAR     (10)                                                                ,  /* 顧客番号 */
     bankcd                                             VARCHAR     (4)                                                                 ,  /* 銀行コード */
     sitencd                                            VARCHAR     (3)                                                                 ,  /* 支店コード */
     yokinkbn                                           VARCHAR     (1)                                                                 ,  /* 預金種目区分 */
     kouzano                                            VARCHAR     (12)                                                                ,  /* 口座番号 */
     kzmeiginmkn                                        VARCHAR     (62)                                                                ,  /* 口座名義人氏名（カナ） */
     sinkeizkkbn                                        VARCHAR     (1)                                                                 ,  /* 新規継続区分 */
     syuudaikocd                                        VARCHAR     (2)                                                                 ,  /* 収納代行社コード */
     kzkykdoukbn                                        VARCHAR     (1)                                                                 ,  /* 口座名義契約者同一人区分 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE IT_Kouza_Z ADD CONSTRAINT PK_Kouza PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                      /* 証券番号 */
) ;

CREATE INDEX IX1_Kouza ON IT_Kouza_Z (
     syono                                                      /* 証券番号 */
) ;

CREATE INDEX IX2_Kouza ON IT_Kouza_Z (
     kzkykdoukbn                                                /* 口座名義契約者同一人区分 */
) ;
