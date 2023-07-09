CREATE VIEW AM_Role AS SELECT
     roleCd ,         /* ロールコード */
     roleNm ,         /* ロール名 */
     roleSetumei ,         /* ロール説明 */
     sysSiyouKbn ,         /* システム使用区分 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM AM_Role_Z;