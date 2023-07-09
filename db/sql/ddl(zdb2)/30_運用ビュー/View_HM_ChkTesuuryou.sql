CREATE VIEW HM_ChkTesuuryou AS SELECT
     renno3keta ,         /* 連番（３桁） */
     hrkmtsry ,         /* 振込手数料 */
     hrkmtsry$ ,         /* 振込手数料(通貨型) */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM HM_ChkTesuuryou_Z;