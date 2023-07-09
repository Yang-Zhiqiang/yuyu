CREATE TABLE IT_BAK_HengakuCf_Z (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     trkssikibetukey                                    VARCHAR     (18)                                                      NOT NULL  ,  /* 取消識別キー */
     henkousikibetukey                                  VARCHAR     (18)                                                      NOT NULL  ,  /* 変更識別キー */
     unitfundkbn                                        VARCHAR     (3)                                                       NOT NULL  ,  /* ユニットファンド区分 */
     syoriYmd                                           VARCHAR     (8)                                                       NOT NULL  ,  /* 処理年月日 */
     renno                                              DECIMAL     (2)                                                       NOT NULL  ,  /* 連番 */
     cfkbn                                              VARCHAR     (1)                                                                 ,  /* ＣＦ区分 */
     hasseiriyuukbn                                     VARCHAR     (2)                                                                 ,  /* 発生理由区分 */
     tuukasyu                                           VARCHAR     (3)                                                                 ,  /* 通貨種類 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE IT_BAK_HengakuCf_Z ADD CONSTRAINT PK_BAK_HengakuCf PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                    , /* 証券番号 */
     trkssikibetukey                                          , /* 取消識別キー */
     henkousikibetukey                                        , /* 変更識別キー */
     unitfundkbn                                              , /* ユニットファンド区分 */
     syoriYmd                                                 , /* 処理年月日 */
     renno                                                      /* 連番 */
) ;
