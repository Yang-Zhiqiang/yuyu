CREATE TABLE IT_KhGinkouMdhnMisyuuInfo (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     datarenymd                                         VARCHAR     (8)                                                       NOT NULL  ,  /* データ連動日 */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     henkousikibetukey                                  VARCHAR     (18)                                                      NOT NULL  ,  /* 変更識別キー */
     gwbsydrtencd                                       VARCHAR     (7)                                                                 ,  /* ＧＷ＿募集代理店コード */
     gwdatakbn                                          VARCHAR     (1)                                                                 ,  /* ＧＷ＿データ区分 */
     gwdatasakuseiymd                                   VARCHAR     (8)                                                                 ,  /* ＧＷ＿データ作成日 */
     gwhknkaisyacd                                      VARCHAR     (2)                                                                 ,  /* ＧＷ＿保険会社コード */
     gwhknsyuruicd                                      VARCHAR     (2)                                                                 ,  /* ＧＷ＿保険種類コード */
     gwsyonosyuban                                      VARCHAR     (12)                                                                ,  /* ＧＷ＿証券番号主番 */
     gwmisyuutatekaekbn                                 VARCHAR     (1)                                                                 ,  /* ＧＷ＿未収・立替区分 */
     gwmisyuutatekaeym                                  VARCHAR     (6)                                                                 ,  /* ＧＷ＿未収・立替発生年月 */
     gwmisyuukg                                         VARCHAR     (10)                                                                ,  /* ＧＷ＿未収金額 */
     gwbnkaisuu                                         VARCHAR     (2)                                                                 ,  /* ＧＷ＿分割回数 */
     gwmisyuujiyuu                                      VARCHAR     (2)                                                                 ,  /* ＧＷ＿未収事由 */
     gwjikaidatakousinymd                               VARCHAR     (8)                                                                 ,  /* ＧＷ＿次回データ更新日 */
     ikkatubaraikbn                                     VARCHAR     (1)                                                                 ,  /* 一括払区分 */
     ikkatubaraikaisuu                                  VARCHAR     (2)                                                                 ,  /* 一括払回数 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE IT_KhGinkouMdhnMisyuuInfo ADD CONSTRAINT PK_KhGinkouMdhnMisyuuInfo PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     datarenymd                                               , /* データ連動日 */
     syono                                                    , /* 証券番号 */
     henkousikibetukey                                          /* 変更識別キー */
) ;
