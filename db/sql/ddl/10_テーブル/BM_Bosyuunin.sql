CREATE TABLE BM_Bosyuunin (
     bosyuucd                                           VARCHAR     (6)                                                       NOT NULL  ,  /* 募集人コード */
     bosyuunm                                           VARCHAR     (20)                                                                ,  /* 募集人名 */
     kanjibosyuuninnm                                   VARCHAR     (15)                                                                ,  /* 漢字募集人名 */
     itakuymd                                           VARCHAR     (8)                                                                 ,  /* 委託年月日 */
     dairiten1cd                                        VARCHAR     (7)                                                                 ,  /* 代理店コード（１） */
     dairiten2cd                                        VARCHAR     (7)                                                                 ,  /* 代理店コード（２） */
     dairiten3cd                                        VARCHAR     (7)                                                                 ,  /* 代理店コード（３） */
     dairitenkanrisosikicd1                             VARCHAR     (7)                                                                 ,  /* 代理店管理組織コード（１） */
     dairitenkanrisosikicd2                             VARCHAR     (7)                                                                 ,  /* 代理店管理組織コード（２） */
     dairitenkanrisosikicd3                             VARCHAR     (7)                                                                 ,  /* 代理店管理組織コード（３） */
     bosyuukbn                                          VARCHAR     (1)                                                                 ,  /* 募集人区分 */
     bosyuunintourokuymd                                VARCHAR     (8)                                                                 ,  /* 募集人登録年月日 */
     bosyuukahikbn                                      VARCHAR     (1)                                                                 ,  /* 募集可否区分 */
     bosyuuningyouhaiymd                                VARCHAR     (8)                                                                 ,  /* 募集人業廃年月日 */
     hngkhknskktrkymd                                   VARCHAR     (8)                                                                 ,  /* 変額保険資格登録年月日 */
     hngkhknskktrkmsuymd                                VARCHAR     (8)                                                                 ,  /* 変額保険資格登録抹消年月日 */
     bosyuuseiymd                                       VARCHAR     (8)                                                                 ,  /* 募集人生年月日 */
     itakukaiyakuymd                                    VARCHAR     (8)                                                                 ,  /* 委託解約年月日 */
     daibosyuucd                                        VARCHAR     (6)                                                                 ,  /* 代表募集人コード */
     bosyuutrkno                                        VARCHAR     (13)                                                                ,  /* 募集人登録番号 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE BM_Bosyuunin ADD CONSTRAINT PK_Bosyuunin PRIMARY KEY (
     bosyuucd                                                   /* 募集人コード */
) ;

CREATE INDEX IX1_Bosyuunin ON BM_Bosyuunin (
     bosyuutrkno                                                /* 募集人登録番号 */
) ;
