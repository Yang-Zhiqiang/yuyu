CREATE VIEW BM_SyoruiZokuseiHukaInfo AS SELECT
     syoruiCd ,         /* 書類コード */
     subSystemId ,         /* サブシステムＩＤ */
     tyouhyououtkinousiyouumu ,         /* 帳票出力機能使用有無 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_SyoruiZokuseiHukaInfo_Z;