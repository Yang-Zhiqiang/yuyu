CREATE VIEW JM_SiTyouhyoumsg AS SELECT
     bunrui1 ,         /* 分類１ */
     bunrui2 ,         /* 分類２ */
     tyouhyoulineno ,         /* 帳票行番号 */
     setteikasyo ,         /* 設定箇所 */
     tyouhyoumsg ,         /* 帳票メッセージ */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM JM_SiTyouhyoumsg_Z;