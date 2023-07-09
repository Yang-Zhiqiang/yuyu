CREATE VIEW AS_SubSystem AS SELECT
     subSystemId ,         /* サブシステムＩＤ */
     subSystemNm ,         /* サブシステム名 */
     sortNo ,         /* ソート番号 */
     linkImage ,         /* リンクイメージ */
     hyoudaiImage ,         /* 表題イメージ */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM AS_SubSystem_Z;