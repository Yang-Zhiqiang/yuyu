CREATE VIEW BT_SkipKey AS SELECT
     recoverysikibetukey ,         /* リカバリ識別キー */
     kakutyoujobcd ,         /* 拡張ジョブコード */
     tableid ,         /* テーブルＩＤ */
     recoveryfilterid ,         /* リカバリフィルタＩＤ */
     recoveryfilterkey1 ,         /* リカバリフィルタキー１ */
     recoveryfilterkey2 ,         /* リカバリフィルタキー２ */
     recoveryfilterkey3 ,         /* リカバリフィルタキー３ */
     recoveryfilterkey4 ,         /* リカバリフィルタキー４ */
     recoveryfilterkey5 ,         /* リカバリフィルタキー５ */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BT_SkipKey_Z;