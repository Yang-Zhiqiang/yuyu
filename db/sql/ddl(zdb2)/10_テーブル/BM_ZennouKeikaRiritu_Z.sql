CREATE TABLE BM_ZennouKeikaRiritu_Z (
     keikatukisuu                                       DECIMAL     (2)                                                       NOT NULL  ,  /* 経過月数（２桁） */
     tekiyoukknfrom                                     VARCHAR     (8)                                                       NOT NULL  ,  /* 適用期間（自） */
     tekiyoukknkto                                      VARCHAR     (8)                                                       NOT NULL  ,  /* 適用期間（至） */
     zennoukeikariritu                                  DECIMAL     (7,6)                                                               ,  /* 前納経過利率 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE BM_ZennouKeikaRiritu_Z ADD CONSTRAINT PK_ZennouKeikaRiritu PRIMARY KEY (
     keikatukisuu                                             , /* 経過月数（２桁） */
     tekiyoukknfrom                                           , /* 適用期間（自） */
     tekiyoukknkto                                              /* 適用期間（至） */
) ;
