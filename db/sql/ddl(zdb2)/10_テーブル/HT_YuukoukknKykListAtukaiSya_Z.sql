CREATE TABLE HT_YuukoukknKykListAtukaiSya_Z (
     mosno                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 申込番号 */
     tyouhyouymd                                        VARCHAR     (8)                                                       NOT NULL  ,  /* 帳票作成日 */
     keikakbn                                           VARCHAR     (1)                                                       NOT NULL  ,  /* 経過区分 */
     renno                                              DECIMAL     (2)                                                       NOT NULL  ,  /* 連番 */
     kinyuucd                                           VARCHAR     (4)                                                                 ,  /* 金融機関コード */
     kinyuusitencd                                      VARCHAR     (4)                                                                 ,  /* 金融機関支店コード */
     drtencd                                            VARCHAR     (7)                                                                 ,  /* 代理店コード */
     drtennm                                            VARCHAR     (62)                                                                ,  /* 代理店名 */
     tratkiagcd                                         VARCHAR     (7)                                                                 ,  /* 取扱代理店コード */
     tratkiagnm                                         VARCHAR     (62)                                                                ,  /* 取扱代理店名 */
     oyadrtencd                                         VARCHAR     (7)                                                                 ,  /* 親代理店コード */
     oyadrtennm                                         VARCHAR     (62)                                                                ,  /* 親代理店名 */
     jimusyocd                                          VARCHAR     (4)                                                                 ,  /* 事務所コード */
     bosyuucd                                           VARCHAR     (6)                                                                 ,  /* 募集人コード */
     bosyuutrkno                                        VARCHAR     (13)                                                                ,  /* 募集人登録番号 */
     bosyuunm                                           VARCHAR     (42)                                                                ,  /* 募集人名 */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE HT_YuukoukknKykListAtukaiSya_Z ADD CONSTRAINT PK_YuukoukknKykListAtukaiSya PRIMARY KEY (
     mosno                                                    , /* 申込番号 */
     tyouhyouymd                                              , /* 帳票作成日 */
     keikakbn                                                 , /* 経過区分 */
     renno                                                      /* 連番 */
) ;
