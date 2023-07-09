CREATE TABLE MT_DsKouzokuJimuKakunin_Z (
     hasseiymd                                          VARCHAR     (8)                                                       NOT NULL  ,  /* 発生日 */
     dskzkjmkknhsjykbn                                  VARCHAR     (2)                                                       NOT NULL  ,  /* ＤＳ後続事務確認発生事由区分 */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE MT_DsKouzokuJimuKakunin_Z ADD CONSTRAINT PK_DsKouzokuJimuKakunin PRIMARY KEY (
     hasseiymd                                                , /* 発生日 */
     dskzkjmkknhsjykbn                                        , /* ＤＳ後続事務確認発生事由区分 */
     syono                                                      /* 証券番号 */
) ;
