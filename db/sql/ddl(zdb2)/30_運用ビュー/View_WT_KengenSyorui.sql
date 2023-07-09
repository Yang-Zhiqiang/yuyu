CREATE VIEW WT_KengenSyorui AS SELECT
     roleCd ,         /* ロールコード */
     torikomiSyoruiCd ,         /* 取込書類コード */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM WT_KengenSyorui_Z;