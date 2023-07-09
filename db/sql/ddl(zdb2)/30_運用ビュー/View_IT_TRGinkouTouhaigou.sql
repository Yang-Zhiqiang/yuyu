CREATE VIEW IT_TRGinkouTouhaigou AS SELECT
     bfrikkatuseibibankcd ,         /* （変更前）一括整備用銀行コード */
     bfrikkatuseibisitencd ,         /* （変更前）一括整備用支店コード */
     newikkatuseibibankcd ,         /* （変更後）一括整備用銀行コード */
     newikkatuseibisitencd ,         /* （変更後）一括整備用支店コード */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IT_TRGinkouTouhaigou_Z;