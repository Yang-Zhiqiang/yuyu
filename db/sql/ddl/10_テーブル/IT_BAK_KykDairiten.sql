CREATE TABLE IT_BAK_KykDairiten (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー                                          */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号                                          */
     trkssikibetukey                                    VARCHAR     (18)                                                      NOT NULL  ,  /* 取消識別キー                                        */
     drtenrenno                                         NUMBER      (2)                                                       NOT NULL  ,  /* 代理店連番                                         */
     drtencd                                            VARCHAR     (7)                                                                 ,  /* 代理店コード                                        */
     drtenkanrisosikicd                                 VARCHAR     (7)                                                                 ,  /* 代理店管理組織コード                                    */
     gyousekikeijyousakisosikicd                        VARCHAR     (7)                                                                 ,  /* 業績計上先組織コード                                    */
     oyadrtencd                                         VARCHAR     (7)                                                                 ,  /* 親代理店コード                                       */
     bosyuucd                                           VARCHAR     (6)                                                                 ,  /* 募集人コード                                        */
     daibosyuucd                                        VARCHAR     (6)                                                                 ,  /* 代表募集人コード                                      */
     drtenbunumu                                        VARCHAR     (1)                                                                 ,  /* 代理店分担有無                                       */
     kanjidrtflg                                        VARCHAR     (1)                                                                 ,  /* 幹事代理店フラグ                                      */
     bunwari                                            NUMBER      (3)                                                                 ,  /* 分担割合                                          */
     ikanymd                                            VARCHAR     (8)                                                                 ,  /* 移管日                                           */
     bsyujoyadrtencd                                    VARCHAR     (7)                                                                 ,  /* 募集時親代理店コード                                    */
     bsyujdrtencd                                       VARCHAR     (10)                                                                ,  /* 募集時代理店コード                                     */
     bsyujbosyuutrkno                                   VARCHAR     (13)                                                                ,  /* 募集時募集人登録番号                                    */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ                                     */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ                                      */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間                                       */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE IT_BAK_KykDairiten ADD CONSTRAINT PK_BAK_KykDairiten PRIMARY KEY (
     kbnkey                                                   , /* 区分キー                                           */
     syono                                                    , /* 証券番号                                           */
     trkssikibetukey                                          , /* 取消識別キー                                         */
     drtenrenno                                                 /* 代理店連番                                          */
) ;
