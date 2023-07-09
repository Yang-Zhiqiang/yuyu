CREATE VIEW BT_FBSoukinHukaInfo AS SELECT
     fbsoukindatasikibetukey ,         /* ＦＢ送金データ識別キー */
     kokcd1 ,         /* 顧客コード１ */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BT_FBSoukinHukaInfo_Z;