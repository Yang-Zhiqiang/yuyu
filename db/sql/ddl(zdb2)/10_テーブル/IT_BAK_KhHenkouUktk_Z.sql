CREATE TABLE IT_BAK_KhHenkouUktk_Z (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     trkssikibetukey                                    VARCHAR     (18)                                                      NOT NULL  ,  /* 取消識別キー */
     hozenhenkouuktkrenno                               DECIMAL     (5)                                                       NOT NULL  ,  /* 保全変更受付連番 */
     uktkymd                                            VARCHAR     (8)                                                                 ,  /* 受付日 */
     tourokuroute                                       VARCHAR     (2)                                                                 ,  /* 登録ルート */
     uktksyorikbn                                       VARCHAR     (2)                                                                 ,  /* 受付処理区分 */
     kouryokuhasseiymd                                  VARCHAR     (8)                                                                 ,  /* 効力発生日 */
     syoriyoteiymd                                      VARCHAR     (8)                                                                 ,  /* 処理予定日 */
     uktkjyoutaikbn                                     VARCHAR     (1)                                                                 ,  /* 受付状態区分 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE IT_BAK_KhHenkouUktk_Z ADD CONSTRAINT PK_BAK_KhHenkouUktk PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                    , /* 証券番号 */
     trkssikibetukey                                          , /* 取消識別キー */
     hozenhenkouuktkrenno                                       /* 保全変更受付連番 */
) ;
