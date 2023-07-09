CREATE VIEW JT_SibouKariuketsuke AS SELECT
     skno ,         /* 請求番号 */
     syono ,         /* 証券番号 */
     sibouymd ,         /* 死亡日 */
     geninkbn ,         /* 原因区分 */
     torikesiflg ,         /* 取消フラグ */
     kossyoricd ,         /* 更新処理コード */
     kossyorisscd ,         /* 更新処理詳細コード */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM JT_SibouKariuketsuke_Z;