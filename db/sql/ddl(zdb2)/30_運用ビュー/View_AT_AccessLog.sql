CREATE VIEW AT_AccessLog AS SELECT
     logId ,         /* ログＩＤ */
     timeStamp ,         /* アクセスログ出力時刻 */
     syoriUserId ,         /* 処理ユーザーＩＤ */
     ipAddress ,         /* ＩＰアドレス */
     sessionId ,         /* セッションＩＤ */
     transactionId ,         /* トランザクションＩＤ */
     logKindCd ,         /* ログ種別コード */
     subSystemId ,         /* サブシステムＩＤ */
     categoryId ,         /* カテゴリＩＤ */
     kinouId ,         /* 機能ＩＤ */
     tanmatuType ,         /* 端末タイプ */
     butsuriSosikiCd ,         /* 物理組織コード */
     ronriSosikiCd ,         /* 論理組織コード */
     tanmatuJyoutaiHyouji ,         /* 端末状態表示 */
     logData ,         /* ログデータ */
     syousaiKensuu ,         /* 詳細ログ件数 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM AT_AccessLog_Z;