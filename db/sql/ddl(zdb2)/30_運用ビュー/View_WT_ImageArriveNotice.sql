CREATE VIEW WT_ImageArriveNotice AS SELECT
     arriveKey ,         /* 到着キー */
     torikomiSyoruiCd ,         /* 取込書類コード */
     gyoumuKey ,         /* 業務キー */
     flowId ,         /* フローＩＤ */
     subSystemId ,         /* サブシステムＩＤ */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM WT_ImageArriveNotice_Z;