CREATE VIEW HM_TokuteiKankeiHjnNmTotugou AS SELECT
     tkhjnkinyuucd ,         /* 特定関係法人金融機関コード */
     meisaino ,         /* 明細番号 */
     renno ,         /* 連番 */
     totugoutkhjnnmkj ,         /* 突合用特定関係法人名（漢字） */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM HM_TokuteiKankeiHjnNmTotugou_Z;