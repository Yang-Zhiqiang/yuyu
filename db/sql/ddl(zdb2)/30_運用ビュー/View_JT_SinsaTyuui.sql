CREATE VIEW JT_SinsaTyuui AS SELECT
     syono ,         /* 証券番号 */
     sinsatyuui ,         /* 審査注意 */
     sosikinm ,         /* 組織名 */
     kossyoricd ,         /* 更新処理コード */
     kossyorisscd ,         /* 更新処理詳細コード */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM JT_SinsaTyuui_Z;