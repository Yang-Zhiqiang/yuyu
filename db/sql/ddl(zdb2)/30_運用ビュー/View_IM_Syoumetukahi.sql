CREATE VIEW IM_Syoumetukahi AS SELECT
     kinouId ,         /* 機能ＩＤ */
     syoumetujiyuu ,         /* 消滅事由 */
     yuukoujyotaikahikbn ,         /* 有効状態処理可否区分 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IM_Syoumetukahi_Z;