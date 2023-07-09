CREATE TABLE ZT_TuutirirekiMeisaiFTy_Z (
     ztytuutirirekino                                   VARCHAR     (13)                                                      NOT NULL  ,  /* （中継用）通知履歴番号 */
     ztytuutisakuseiymd                                 VARCHAR     (8)                                                       NOT NULL  ,  /* （中継用）通知作成年月日 */
     ztytuutisakuseino                                  VARCHAR     (2)                                                       NOT NULL  ,  /* （中継用）通知作成番号 */
     ztytuutisyuruicd                                   VARCHAR     (8)                                                                 ,  /* （中継用）通知種類コード */
     ztyhyoujiyoutuutisksymd                            VARCHAR     (8)                                                                 ,  /* （中継用）表示用通知作成年月日 */
     ztyyobiv11                                         VARCHAR     (11)                                                                ,  /* （中継用）予備項目Ｖ１１ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE ZT_TuutirirekiMeisaiFTy_Z ADD CONSTRAINT PK_TuutirirekiMeisaiFTy PRIMARY KEY (
     ztytuutirirekino                                         , /* （中継用）通知履歴番号 */
     ztytuutisakuseiymd                                       , /* （中継用）通知作成年月日 */
     ztytuutisakuseino                                          /* （中継用）通知作成番号 */
) ;
