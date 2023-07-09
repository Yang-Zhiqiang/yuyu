CREATE VIEW IM_KhHituyouSyorui AS SELECT
     kinouId ,         /* 機能ＩＤ */
     hanteikbn1 ,         /* 判定区分１ */
     hanteikbn2 ,         /* 判定区分２ */
     hanteikbn3 ,         /* 判定区分３ */
     htysrirenno ,         /* 必要書類連番 */
     htysyorui ,         /* 必要書類メッセージ */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IM_KhHituyouSyorui_Z;