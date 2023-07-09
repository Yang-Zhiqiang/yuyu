CREATE TABLE BT_HengakuEpsilonDenpyo_Z (
     hengakudenpyourecdkbn                              VARCHAR     (2)                                                                 ,  /* 変額伝票レコード区分 */
     hengakusyuruikbn                                   VARCHAR     (1)                                                       NOT NULL  ,  /* 変額種類区分 */
     unitfundkbn                                        VARCHAR     (3)                                                       NOT NULL  ,  /* ユニットファンド区分 */
     tkbtkanjyouunitfundkbn                             VARCHAR     (3)                                                       NOT NULL  ,  /* 特別勘定ユニットファンド区分 */
     kacd                                               VARCHAR     (3)                                                       NOT NULL  ,  /* 課コード */
     denymd                                             VARCHAR     (8)                                                       NOT NULL  ,  /* 伝票日付 */
     denpyoukbn                                         VARCHAR     (1)                                                       NOT NULL  ,  /* 伝票区分 */
     taisyakukbn                                        VARCHAR     (1)                                                       NOT NULL  ,  /* 貸借区分 */
     kamokucd                                           VARCHAR     (5)                                                       NOT NULL  ,  /* 科目コード */
     syoriYmd                                           VARCHAR     (8)                                                       NOT NULL  ,  /* 処理年月日 */
     fundsyoricd                                        VARCHAR     (4)                                                                 ,  /* ファンド処理コード */
     cfkbn                                              VARCHAR     (1)                                                                 ,  /* ＣＦ区分 */
     hasseiriyuukbn                                     VARCHAR     (2)                                                                 ,  /* 発生理由区分 */
     hasseikbn                                          VARCHAR     (1)                                                                 ,  /* 発生区分 */
     fundkingaku                                        DECIMAL     (15)                                                                ,  /* ファンド金額 */
     fundkingaku$                                       VARCHAR     (10)                                                                ,  /* ファンド金額(通貨型) */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE BT_HengakuEpsilonDenpyo_Z ADD CONSTRAINT PK_HengakuEpsilonDenpyo PRIMARY KEY (
     hengakusyuruikbn                                         , /* 変額種類区分 */
     unitfundkbn                                              , /* ユニットファンド区分 */
     tkbtkanjyouunitfundkbn                                   , /* 特別勘定ユニットファンド区分 */
     kacd                                                     , /* 課コード */
     denymd                                                   , /* 伝票日付 */
     denpyoukbn                                               , /* 伝票区分 */
     taisyakukbn                                              , /* 貸借区分 */
     kamokucd                                                 , /* 科目コード */
     syoriYmd                                                   /* 処理年月日 */
) ;
