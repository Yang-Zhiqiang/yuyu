CREATE TABLE HT_MosDairitenVrf_Z (
     mosno                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 申込番号 */
     renno                                              DECIMAL     (2)                                                       NOT NULL  ,  /* 連番 */
     bsyujoyadrtencd                                    VARCHAR     (7)                                                                 ,  /* 募集時親代理店コード */
     drtensykbn                                         VARCHAR     (2)                                                                 ,  /* 代理店種別区分 */
     kinyuucd                                           VARCHAR     (4)                                                                 ,  /* 金融機関コード */
     kinyuusitencd                                      VARCHAR     (4)                                                                 ,  /* 金融機関支店コード */
     tratkiagcd                                         VARCHAR     (7)                                                                 ,  /* 取扱代理店コード */
     oyadrtencd                                         VARCHAR     (7)                                                                 ,  /* 親代理店コード */
     jimusyocd                                          VARCHAR     (4)                                                                 ,  /* 事務所コード */
     bosyuutrkno                                        VARCHAR     (13)                                                                ,  /* 募集人登録番号 */
     cifcd                                              VARCHAR     (15)                                                                ,  /* ＣＩＦコード */
     drtencd                                            VARCHAR     (7)                                                                 ,  /* 代理店コード */
     bosyuucd                                           VARCHAR     (6)                                                                 ,  /* 募集人コード */
     inputbosyuucd                                      VARCHAR     (7)                                                                 ,  /* 入力募集人コード */
     daibosyuucd                                        VARCHAR     (6)                                                                 ,  /* 代表募集人コード */
     tratkikouinncd                                     VARCHAR     (20)                                                                ,  /* 取扱行員コード */
     drtenkanrisosikicd                                 VARCHAR     (7)                                                                 ,  /* 代理店管理組織コード */
     gyousekikeijyousakisosikicd                        VARCHAR     (7)                                                                 ,  /* 業績計上先組織コード */
     bunwari                                            DECIMAL     (3)                                                                 ,  /* 分担割合 */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                             ,  /* バージョン */
     yuuseikbn                                          VARCHAR     (1)                                                                 ,  /* 郵政区分 */
     kyokusyocd                                         VARCHAR     (6)                                                                 ,  /* 局所コード */
     yuuseisyainno                                      VARCHAR     (8)                                                                    /* 郵政社員番号 */
)
;

ALTER TABLE HT_MosDairitenVrf_Z ADD CONSTRAINT PK_MosDairitenVrf PRIMARY KEY (
     mosno                                                    , /* 申込番号 */
     renno                                                      /* 連番 */
) ;
