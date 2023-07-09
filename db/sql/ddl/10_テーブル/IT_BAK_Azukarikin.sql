CREATE TABLE IT_BAK_Azukarikin (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     trkssikibetukey                                    VARCHAR     (18)                                                      NOT NULL  ,  /* 取消識別キー */
     henkousikibetukey                                  VARCHAR     (18)                                                      NOT NULL  ,  /* 変更識別キー */
     tuukasyu                                           VARCHAR     (3)                                                       NOT NULL  ,  /* 通貨種類 */
     azukarikinsyuruikbn                                VARCHAR     (1)                                                                 ,  /* 預り金種類区分 */
     shrymd                                             VARCHAR     (8)                                                                 ,  /* 支払日 */
     shrsyoriymd                                        VARCHAR     (8)                                                                 ,  /* 支払処理日 */
     azukarikinhsiymd                                   VARCHAR     (8)                                                                 ,  /* 預り金発生日 */
     azukarikingk                                       NUMBER      (13)                                                                ,  /* 預り金額 */
     azukarikingk$                                      VARCHAR     (10)                                                                ,  /* 預り金額(通貨型) */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE IT_BAK_Azukarikin ADD CONSTRAINT PK_BAK_Azukarikin PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                    , /* 証券番号 */
     trkssikibetukey                                          , /* 取消識別キー */
     henkousikibetukey                                        , /* 変更識別キー */
     tuukasyu                                                   /* 通貨種類 */
) ;
