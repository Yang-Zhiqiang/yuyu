CREATE TABLE HM_TokuteiKankeiHoujin_Z (
     tkhjnkinyuucd                                      VARCHAR     (4)                                                       NOT NULL  ,  /* 特定関係法人金融機関コード */
     meisaino                                           DECIMAL     (5)                                                       NOT NULL  ,  /* 明細番号 */
     marukinhyouji                                      VARCHAR     (1)                                                                 ,  /* マル金表示 */
     tkhjnkjdrtennm                                     VARCHAR     (82)                                                                ,  /* 特定関係法人漢字代理店名 */
     dairitenbtno                                       DECIMAL     (4)                                                                 ,  /* 代理店別通番 */
     tkhjnnmkj                                          VARCHAR     (202)                                                               ,  /* 特定関係法人名（漢字） */
     tkhjnnmkn                                          VARCHAR     (202)                                                               ,  /* 特定関係法人名（カナ） */
     kosymd                                             VARCHAR     (8)                                                                 ,  /* 更新日 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE HM_TokuteiKankeiHoujin_Z ADD CONSTRAINT PK_TokuteiKankeiHoujin PRIMARY KEY (
     tkhjnkinyuucd                                            , /* 特定関係法人金融機関コード */
     meisaino                                                   /* 明細番号 */
) ;
