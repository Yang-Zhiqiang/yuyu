CREATE TABLE BM_BunsyonoSettei (
     bunsyosyubetukbn                                   VARCHAR     (2)                                                       NOT NULL  ,  /* 文書種別区分 */
     aisyoumeikbn                                       VARCHAR     (3)                                                       NOT NULL  ,  /* 愛称名区分 */
     channelcd                                          VARCHAR     (2)                                                       NOT NULL  ,  /* チャネルコード */
     oyadrtencd                                         VARCHAR     (7)                                                       NOT NULL  ,  /* 親代理店コード */
     renno                                              NUMBER      (2)                                                       NOT NULL  ,  /* 連番 */
     tekiyouYmdFrom                                     VARCHAR     (8)                                                                 ,  /* 適用年月日（自） */
     tekiyouYmdTo                                       VARCHAR     (8)                                                                 ,  /* 適用年月日（至） */
     bunsyono                                           VARCHAR     (16)                                                                ,  /* 文書番号 */
     siorino                                            VARCHAR     (3)                                                                 ,  /* しおり番号 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE BM_BunsyonoSettei ADD CONSTRAINT PK_BunsyonoSettei PRIMARY KEY (
     bunsyosyubetukbn                                         , /* 文書種別区分 */
     aisyoumeikbn                                             , /* 愛称名区分 */
     channelcd                                                , /* チャネルコード */
     oyadrtencd                                               , /* 親代理店コード */
     renno                                                      /* 連番 */
) ;
