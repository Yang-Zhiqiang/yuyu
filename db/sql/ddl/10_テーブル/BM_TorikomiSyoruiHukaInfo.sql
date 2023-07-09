CREATE TABLE BM_TorikomiSyoruiHukaInfo (
     syoruiCd                                           VARCHAR     (5)                                                       NOT NULL  ,  /* 書類コード */
     subSystemId                                        VARCHAR     (50)                                                                ,  /* サブシステムＩＤ */
     syoruitorikomihoukbn                               VARCHAR     (1)                                                                 ,  /* 書類取込方法区分 */
     kouteisakuseikeiki                                 VARCHAR     (1)                                                                 ,  /* 工程作成契機 */
     qrcodetaikeikbn                                    VARCHAR     (4)                                                                 ,  /* QRコード体系区分 */
     ttykknryouhi                                       VARCHAR     (1)                                                                 ,  /* 到着予定管理要否 */
     hozonKikan                                         NUMBER      (2)                                                                 ,  /* 保存期間 */
     sortNo                                             NUMBER      (3)                                                                 ,  /* ソート番号 */
     skeijimukbn                                        VARCHAR     (2)                                                                 ,  /* 新契約事務区分 */
     qrsealumukbn                                       VARCHAR     (1)                                                                 ,  /* QRシール用紙有無区分 */
     imagegazoukakbn                                    VARCHAR     (1)                                                                 ,  /* イメージ画像化区分 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE BM_TorikomiSyoruiHukaInfo ADD CONSTRAINT PK_TorikomiSyoruiHukaInfo PRIMARY KEY (
     syoruiCd                                                   /* 書類コード */
) ;
