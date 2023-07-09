CREATE TABLE ST_SynypTukiTugtTykiyuHozon_Z (
     ztysrkijyunym                                      VARCHAR     (6)                                                       NOT NULL  ,  /* （中継用）数理用基準年月 */
     ztysrkakutyoujobcd                                 VARCHAR     (8)                                                       NOT NULL  ,  /* （中継用）数理用拡張ジョブコード */
     ztysequenceno                                      DECIMAL     (8)                                                       NOT NULL  ,  /* （中継用）シーケンス番号 */
     ztydatakanrino                                     VARCHAR     (11)                                                                ,  /* （中継用）データ管理番号 */
     ztyjyuutouym                                       VARCHAR     (6)                                                                 ,  /* （中継用）充当年月 */
     ztyjyuutoukaisuu                                   VARCHAR     (4)                                                                 ,  /* （中継用）充当回数 */
     ztyrecordkbn                                       VARCHAR     (1)                                                                 ,  /* （中継用）レコード区分 */
     ztydenymd                                          VARCHAR     (8)                                                                 ,  /* （中継用）伝票日付 */
     ztysyoricd                                         VARCHAR     (4)                                                                 ,  /* （中継用）処理コード */
     ztyhenkousyoriymd                                  VARCHAR     (8)                                                                 ,  /* （中継用）変更処理年月日 */
     ztykbnkeiriyousegmentcd                            VARCHAR     (4)                                                                 ,  /* （中継用）区分経理用セグメントコード */
     ztyzennoujiikkatubaraijytgk                        DECIMAL     (11)                                                                ,  /* （中継用）前納時一括払充当額 */
     ztysrdenrenno                                      VARCHAR     (20)                                                                ,  /* （中継用）数理用伝票データ連番 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE ST_SynypTukiTugtTykiyuHozon_Z ADD CONSTRAINT PK_SynypTukiTugtTykiyuHozon PRIMARY KEY (
     ztysrkijyunym                                            , /* （中継用）数理用基準年月 */
     ztysrkakutyoujobcd                                       , /* （中継用）数理用拡張ジョブコード */
     ztysequenceno                                              /* （中継用）シーケンス番号 */
) ;
