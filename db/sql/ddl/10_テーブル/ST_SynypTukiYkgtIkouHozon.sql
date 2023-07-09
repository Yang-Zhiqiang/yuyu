CREATE TABLE ST_SynypTukiYkgtIkouHozon (
     srkijyunym                                         VARCHAR     (6)                                                       NOT NULL  ,  /* 数理用基準年月 */
     sequenceno                                         NUMBER      (8)                                                       NOT NULL  ,  /* シーケンス番号 */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     jyutoustartym                                      VARCHAR     (6)                                                       NOT NULL  ,  /* 充当開始年月 */
     jyutouendym                                        VARCHAR     (6)                                                       NOT NULL  ,  /* 充当終了年月 */
     taisyakukbn                                        VARCHAR     (1)                                                       NOT NULL  ,  /* 貸借区分 */
     denymd                                             VARCHAR     (8)                                                                 ,  /* 伝票日付 */
     syoricd                                            VARCHAR     (4)                                                                 ,  /* 処理コード */
     syoriYmd                                           VARCHAR     (8)                                                                 ,  /* 処理年月日 */
     seg1cd                                             VARCHAR     (20)                                                                ,  /* セグメント１コード */
     zennoujiikkatubaraijytgk                           NUMBER      (11)                                                                ,  /* 前納時一括払充当額 */
     denrenno                                           VARCHAR     (20)                                                                ,  /* 伝票データ連番 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE ST_SynypTukiYkgtIkouHozon ADD CONSTRAINT PK_SynypTukiYkgtIkouHozon PRIMARY KEY (
     srkijyunym                                               , /* 数理用基準年月 */
     sequenceno                                               , /* シーケンス番号 */
     syono                                                    , /* 証券番号 */
     jyutoustartym                                            , /* 充当開始年月 */
     jyutouendym                                              , /* 充当終了年月 */
     taisyakukbn                                                /* 貸借区分 */
) ;
