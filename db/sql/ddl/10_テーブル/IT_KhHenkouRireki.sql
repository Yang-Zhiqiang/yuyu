CREATE TABLE IT_KhHenkouRireki (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     henkousikibetukey                                  VARCHAR     (18)                                                      NOT NULL  ,  /* 変更識別キー */
     renno3keta                                         NUMBER      (3)                                                       NOT NULL  ,  /* 連番（３桁） */
     tablenm                                            VARCHAR     (50)                                                                ,  /* テーブル名称 */
     tableid                                            VARCHAR     (100)                                                               ,  /* テーブルＩＤ */
     hnksyuruikbn                                       VARCHAR     (1)                                                                 ,  /* 変更種類区分 */
     hanbetukoumokunm                                   VARCHAR     (100)                                                               ,  /* 判別項目名 */
     henkoukoumokuid                                    VARCHAR     (50)                                                                ,  /* 変更項目ID */
     henkoukoumokunm                                    VARCHAR     (100)                                                               ,  /* 変更項目名 */
     bfrnaiyouoriginal                                  VARCHAR     (100)                                                               ,  /* 変更前内容原本 */
     bfrnaiyou                                          VARCHAR     (600)                                                               ,  /* 変更前内容 */
     newnaiyouoriginal                                  VARCHAR     (100)                                                               ,  /* 変更後内容原本 */
     newnaiyou                                          VARCHAR     (100)                                                               ,  /* 変更後内容 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE IT_KhHenkouRireki ADD CONSTRAINT PK_KhHenkouRireki PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                    , /* 証券番号 */
     henkousikibetukey                                        , /* 変更識別キー */
     renno3keta                                                 /* 連番（３桁） */
) ;

CREATE INDEX IX1_KhHenkouRireki ON IT_KhHenkouRireki (
     syono                                                    , /* 証券番号 */
     henkousikibetukey                                        , /* 変更識別キー */
     renno3keta                                                 /* 連番（３桁） */
) ;
