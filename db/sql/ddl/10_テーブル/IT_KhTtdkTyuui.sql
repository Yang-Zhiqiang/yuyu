CREATE TABLE IT_KhTtdkTyuui (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     ttdktyuuisetymd                                    VARCHAR     (8)                                                                 ,  /* 手続注意設定日 */
     ttdktyuuisetnm                                     VARCHAR     (20)                                                                ,  /* 手続注意設定者名 */
     kktyuitakbn                                        VARCHAR     (2)                                                                 ,  /* 契約管理注意取扱区分 */
     ttdktyuuinaiyou1                                   VARCHAR     (40)                                                                ,  /* 手続注意内容１ */
     ttdktyuuinaiyou2                                   VARCHAR     (40)                                                                ,  /* 手続注意内容２ */
     ttdktyuuinaiyou3                                   VARCHAR     (40)                                                                ,  /* 手続注意内容３ */
     ttdktyuuikbn1                                      VARCHAR     (2)                                                                 ,  /* 手続注意区分１ */
     ttdktyuuikbn2                                      VARCHAR     (2)                                                                 ,  /* 手続注意区分２ */
     ttdktyuuikbn3                                      VARCHAR     (2)                                                                 ,  /* 手続注意区分３ */
     ttdktyuuikbn4                                      VARCHAR     (2)                                                                 ,  /* 手続注意区分４ */
     ttdktyuuikbn5                                      VARCHAR     (2)                                                                 ,  /* 手続注意区分５ */
     ttdktyuuikbnhsknaiyou1                             VARCHAR     (94)                                                                ,  /* 手続注意区分補足内容１ */
     ttdktyuuikbnhsknaiyou2                             VARCHAR     (94)                                                                ,  /* 手続注意区分補足内容２ */
     ttdktyuuikbnhsknaiyou3                             VARCHAR     (94)                                                                ,  /* 手続注意区分補足内容３ */
     ttdktyuuikbnhsknaiyou4                             VARCHAR     (94)                                                                ,  /* 手続注意区分補足内容４ */
     ttdktyuuikbnhsknaiyou5                             VARCHAR     (94)                                                                ,  /* 手続注意区分補足内容５ */
     ttdktyuuikbnsetymd1                                VARCHAR     (8)                                                                 ,  /* 手続注意区分設定日１ */
     ttdktyuuikbnsetymd2                                VARCHAR     (8)                                                                 ,  /* 手続注意区分設定日２ */
     ttdktyuuikbnsetymd3                                VARCHAR     (8)                                                                 ,  /* 手続注意区分設定日３ */
     ttdktyuuikbnsetymd4                                VARCHAR     (8)                                                                 ,  /* 手続注意区分設定日４ */
     ttdktyuuikbnsetymd5                                VARCHAR     (8)                                                                 ,  /* 手続注意区分設定日５ */
     setsosikicd1                                       VARCHAR     (7)                                                                 ,  /* 設定組織コード１ */
     setsosikicd2                                       VARCHAR     (7)                                                                 ,  /* 設定組織コード２ */
     setsosikicd3                                       VARCHAR     (7)                                                                 ,  /* 設定組織コード３ */
     setsosikicd4                                       VARCHAR     (7)                                                                 ,  /* 設定組織コード４ */
     setsosikicd5                                       VARCHAR     (7)                                                                 ,  /* 設定組織コード５ */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                 ,  /* バージョン */
     kykdrknhatudoujyoutai                              VARCHAR     (1)                                                                 ,  /* 契約者代理権発動状態 */
     kykdrdouiyouhi                                     VARCHAR     (1)                                                                    /* 契約者代理人同意要否 */
)
;

ALTER TABLE IT_KhTtdkTyuui ADD CONSTRAINT PK_KhTtdkTyuui PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                      /* 証券番号 */
) ;

CREATE INDEX IX1_KhTtdkTyuui ON IT_KhTtdkTyuui (
     syono                                                      /* 証券番号 */
) ;
