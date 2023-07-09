CREATE TABLE IT_BAK_KoujyoSymNaiyouD_Z (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     trkssikibetukey                                    VARCHAR     (18)                                                      NOT NULL  ,  /* 取消識別キー */
     syouhncd                                           VARCHAR     (4)                                                       NOT NULL  ,  /* 商品コード */
     renno3keta                                         DECIMAL     (3)                                                       NOT NULL  ,  /* 連番（３桁） */
     koujyosyoumeinnd                                   VARCHAR     (4)                                                                 ,  /* 控除証明年度 */
     koujyosyoumeid                                     DECIMAL     (13)                                                                ,  /* 控除証明Ｄ */
     koujyosyoumeid$                                    VARCHAR     (10)                                                                ,  /* 控除証明Ｄ(通貨型) */
     haitounendo                                        VARCHAR     (4)                                                                 ,  /* 配当年度 */
     haitoukanrirenno                                   DECIMAL     (2)                                                                 ,  /* 配当管理連番 */
     haitoukinskskbn                                    VARCHAR     (2)                                                                 ,  /* 配当金作成区分 */
     haitoumeisaikbn                                    VARCHAR     (2)                                                                 ,  /* 配当明細区分 */
     kjsmhakkouzumiflg                                  VARCHAR     (1)                                                                 ,  /* 控除証明書発行済フラグ */
     sakujyoflg                                         VARCHAR     (1)                                                                 ,  /* 削除フラグ */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE IT_BAK_KoujyoSymNaiyouD_Z ADD CONSTRAINT PK_BAK_KoujyoSymNaiyouD PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                    , /* 証券番号 */
     trkssikibetukey                                          , /* 取消識別キー */
     syouhncd                                                 , /* 商品コード */
     renno3keta                                                 /* 連番（３桁） */
) ;
