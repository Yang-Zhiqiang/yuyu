CREATE TABLE BT_TuutirirekiMeisaiHokan (
     tuutirirekirenno                                   VARCHAR     (18)                                                      NOT NULL  ,  /* 通知履歴連番 */
     tuutirirekino                                      VARCHAR     (13)                                                                ,  /* 通知履歴番号 */
     tuutisakuseiymd                                    VARCHAR     (8)                                                                 ,  /* 通知作成年月日 */
     tuutisakuseino                                     NUMBER      (2)                                                                 ,  /* 通知作成番号 */
     tuutisyuruicd                                      VARCHAR     (8)                                                                 ,  /* 通知種類コード */
     hyoujiyoutuutisakuseiymd                           VARCHAR     (8)                                                                 ,  /* 表示用通知作成年月日 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE BT_TuutirirekiMeisaiHokan ADD CONSTRAINT PK_TuutirirekiMeisaiHokan PRIMARY KEY (
     tuutirirekirenno                                           /* 通知履歴連番 */
) ;
