CREATE TABLE IT_KhHenkouUktkMkhgkHnk_Z (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     hozenhenkouuktkrenno                               DECIMAL     (5)                                                       NOT NULL  ,  /* 保全変更受付連番 */
     targettkmokuhyouti                                 DECIMAL     (3)                                                                 ,  /* ターゲット特約目標値 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE IT_KhHenkouUktkMkhgkHnk_Z ADD CONSTRAINT PK_KhHenkouUktkMkhgkHnk PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                    , /* 証券番号 */
     hozenhenkouuktkrenno                                       /* 保全変更受付連番 */
) ;
