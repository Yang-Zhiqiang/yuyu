CREATE TABLE AM_SyoruiZokusei_Z (
     syoruiCd                                           VARCHAR     (5)                                                       NOT NULL  ,  /* 書類コード */
     syoruinm                                           VARCHAR     (62)                                                                ,  /* 書類名 */
     syoruinmryaku                                      VARCHAR     (22)                                                                ,  /* 書類名（略称） */
     tyouhyouid                                         VARCHAR     (30)                                                                ,  /* 帳票フォームＩＤ */
     hozonKikan                                         DECIMAL     (2)                                                                 ,  /* 保存期間 */
     nengetukbn                                         VARCHAR     (1)                                                                 ,  /* 年月区分 */
     angoukaKbn                                         VARCHAR     (1)                                                                 ,  /* 暗号化区分 */
     pdfHozonKbn                                        VARCHAR     (1)                                                                 ,  /* ＰＤＦ保存区分 */
     zipHozonKbn                                        VARCHAR     (1)                                                                 ,  /* ＺＩＰ保存区分 */
     pageCount                                          DECIMAL     (5)                                                                 ,  /* ページ数 */
     sortNo                                             DECIMAL     (3)                                                                 ,  /* ソート番号 */
     kensakuKey1                                        VARCHAR     (30)                                                                ,  /* 検索キー１ */
     kensakuKey2                                        VARCHAR     (30)                                                                ,  /* 検索キー２ */
     kensakuKey3                                        VARCHAR     (30)                                                                ,  /* 検索キー３ */
     kensakuKey4                                        VARCHAR     (30)                                                                ,  /* 検索キー４ */
     kensakuKey5                                        VARCHAR     (30)                                                                ,  /* 検索キー５ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE AM_SyoruiZokusei_Z ADD CONSTRAINT AM_SyoruiZokuseiPk PRIMARY KEY (
     syoruiCd                                                   /* 書類コード */
) ;
