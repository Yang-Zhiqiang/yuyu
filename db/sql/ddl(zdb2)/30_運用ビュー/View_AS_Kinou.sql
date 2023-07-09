CREATE VIEW AS_Kinou AS SELECT
     kinouId ,         /* 機能ＩＤ */
     subSystemId ,         /* サブシステムＩＤ */
     categoryId ,         /* カテゴリＩＤ */
     kinouNm ,         /* 機能名 */
     sortNo ,         /* ソート番号 */
     kinouKbn ,         /* 機能区分 */
     jikkouPath ,         /* 実行パス */
     kinouSetumei ,         /* 機能説明 */
     batchKyouseiSyuuryouFlag ,         /* バッチ強制終了フラグ */
     menuHyoujiKahi ,         /* メニュー表示可否 */
     batchLogHyoujiKbn ,         /* バッチログ表示区分 */
     kidouKengenHanteiYouhiKbn ,         /* 起動権限判定要否区分 */
     kinouTeigiTaisyouKbn ,         /* 機能定義対象区分 */
     syoricd ,         /* 処理コード */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM AS_Kinou_Z;