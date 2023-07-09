CREATE VIEW BT_GkFBSoukinHukaInfo AS SELECT
     fbsoukindatasikibetukey ,         /* ＦＢ送金データ識別キー */
     fbtrhksyoukaino ,         /* ＦＢ取引先照会番号 */
     dengk ,         /* 伝票金額 */
     dengk$ ,         /* 伝票金額(通貨型) */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BT_GkFBSoukinHukaInfo_Z;