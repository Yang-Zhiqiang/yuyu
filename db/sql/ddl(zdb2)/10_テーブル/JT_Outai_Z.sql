CREATE TABLE JT_Outai_Z (
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     renno                                              DECIMAL     (2)                                                       NOT NULL  ,  /* 連番 */
     nayoseyouhi                                        VARCHAR     (1)                                                                 ,  /* 名寄せ要否 */
     mousideninkbn                                      VARCHAR     (2)                                                                 ,  /* 申出人区分 */
     syuhiyouhi                                         VARCHAR     (1)                                                                 ,  /* 守秘要否 */
     mousideninnmkj                                     VARCHAR     (32)                                                                ,  /* 申出人名（漢字） */
     souhusakikbn                                       VARCHAR     (1)                                                                 ,  /* 送付先区分 */
     tsinyno                                            VARCHAR     (7)                                                                 ,  /* 通信先郵便番号 */
     tsinadr1kj                                         VARCHAR     (62)                                                                ,  /* 通信先住所１（漢字） */
     tsinadr2kj                                         VARCHAR     (62)                                                                ,  /* 通信先住所２（漢字） */
     tsinadr3kj                                         VARCHAR     (62)                                                                ,  /* 通信先住所３（漢字） */
     tsintelno                                          VARCHAR     (14)                                                                ,  /* 通信先電話番号 */
     betukyksuu                                         DECIMAL     (2)                                                                 ,  /* 別契約数 */
     kossyoricd                                         VARCHAR     (50)                                                                ,  /* 更新処理コード */
     kossyorisscd                                       VARCHAR     (50)                                                                ,  /* 更新処理詳細コード */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE JT_Outai_Z ADD CONSTRAINT PK_Outai PRIMARY KEY (
     syono                                                    , /* 証券番号 */
     renno                                                      /* 連番 */
) ;
