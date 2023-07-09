CREATE VIEW AS_KinouMode AS SELECT
     kinouId ,         /* 機能ＩＤ */
     kinouModeId ,         /* 機能モードＩＤ */
     kinouModeNm ,         /* 機能モード名 */
     sortNo ,         /* ソート番号 */
     yuukouKbn ,         /* 有効区分 */
     yuukouKaisiYmd ,         /* 有効開始年月日 */
     kadouTimeGroupCd ,         /* 稼働時間グループコード */
     batchHeisouKahiKbn ,         /* バッチ並走可否区分 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM AS_KinouMode_Z;