CREATE VIEW IM_KhTtdkTyuuikahi AS SELECT
     kinouId ,         /* 機能ＩＤ */
     ttdktyuuikbn ,         /* 手続注意区分 */
     syorikahikbn ,         /* 処理可否区分 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IM_KhTtdkTyuuikahi_Z;