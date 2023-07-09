CREATE VIEW IM_YykIdouUktksyorikahi AS SELECT
     kinouId ,         /* 機能ＩＤ */
     yykuktkkinouid ,         /* 予約受付中機能ＩＤ */
     yuukoujyotaikahikbn ,         /* 有効状態処理可否区分 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IM_YykIdouUktksyorikahi_Z;