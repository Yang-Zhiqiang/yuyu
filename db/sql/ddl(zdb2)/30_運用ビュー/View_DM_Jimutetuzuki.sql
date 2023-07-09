CREATE VIEW DM_Jimutetuzuki AS SELECT
     jimutetuzukicd ,         /* 事務手続コード */
     subSystemId ,         /* サブシステムＩＤ */
     jimutetuzukinm ,         /* 事務手続名 */
     imagerenkeikbn ,         /* イメージ連携区分 */
     hyoujijyun ,         /* 表示順 */
     syukouteijimutetuzukicd ,         /* 主工程事務手続コード */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM DM_Jimutetuzuki_Z;