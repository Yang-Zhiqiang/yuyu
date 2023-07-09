CREATE TABLE WM_TorikomiSyorui_Z (
     torikomiSyoruiCd                                   VARCHAR     (30)                                                      NOT NULL  ,  /* 取込書類コード */
     torikomiSyoruiNm                                   VARCHAR     (125)                                                               ,  /* 取込書類名 */
     torikomiSyoruiRyaku                                VARCHAR     (50)                                                                ,  /* 取込書類略称 */
     syzkDaiBunruiId                                    VARCHAR     (30)                                                                ,  /* 所属大分類ＩＤ */
     syzkSyouBunruiId                                   VARCHAR     (30)                                                                ,  /* 所属小分類ＩＤ */
     angoukaKbn                                         VARCHAR     (1)                                                                 ,  /* 暗号化区分 */
     zipHozonKbn                                        VARCHAR     (1)                                                                 ,  /* ＺＩＰ保存区分 */
     kouteiSeigyoUmuKbn                                 VARCHAR     (1)                                                                 ,  /* 工程制御有無区分 */
     flowId                                             VARCHAR     (19)                                                                ,  /* フローＩＤ */
     nodeId                                             VARCHAR     (200)                                                               ,  /* ノードＩＤ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                             ,  /* バージョン */
     angoukaHousikiKbn                                  VARCHAR     (1)                                                                    /* 暗号化方式区分 */
)
;

ALTER TABLE WM_TorikomiSyorui_Z ADD CONSTRAINT PK_TorikomiSyorui PRIMARY KEY (
     torikomiSyoruiCd                                           /* 取込書類コード */
) ;

CREATE INDEX WM_TorikomiSyoruiIdx1 ON WM_TorikomiSyorui_Z (
     flowId                                                   , /* フローＩＤ */
     nodeId                                                     /* ノードＩＤ */
) ;
