CREATE VIEW BM_TorikomiSyoruiHukaInfo AS SELECT
     syoruiCd ,         /* 書類コード */
     subSystemId ,         /* サブシステムＩＤ */
     syoruitorikomihoukbn ,         /* 書類取込方法区分 */
     kouteisakuseikeiki ,         /* 工程作成契機 */
     qrcodetaikeikbn ,         /* QRコード体系区分 */
     ttykknryouhi ,         /* 到着予定管理要否 */
     hozonKikan ,         /* 保存期間 */
     sortNo ,         /* ソート番号 */
     skeijimukbn ,         /* 新契約事務区分 */
     qrsealumukbn ,         /* QRシール用紙有無区分 */
     imagegazoukakbn ,         /* イメージ画像化区分 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_TorikomiSyoruiHukaInfo_Z;