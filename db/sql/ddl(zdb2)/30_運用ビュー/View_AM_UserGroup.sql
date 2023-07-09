CREATE VIEW AM_UserGroup AS SELECT
     userGroupCd ,         /* ユーザーグループコード */
     userGroupNm ,         /* ユーザーグループ名 */
     userGroupSetumei ,         /* ユーザーグループ説明 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM AM_UserGroup_Z;