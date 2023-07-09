CREATE VIEW WT_TorikomiRelation AS SELECT
     iwfImageId ,         /* IWFイメージＩＤ */
     gyoumuKey ,         /* 業務キー */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM WT_TorikomiRelation_Z;