CREATE VIEW HT_Tokujyou AS SELECT
     mosno ,         /* 申込番号 */
     tkjyhyouten ,         /* 特条標点 */
     tkjyskgnkkn ,         /* 特条削減期間 */
     htnpbuicd1 ,         /* 不担保部位コード１ */
     htnpkkn1 ,         /* 不担保期間１ */
     htnpbuicd2 ,         /* 不担保部位コード２ */
     htnpkkn2 ,         /* 不担保期間２ */
     htnpbuicd3 ,         /* 不担保部位コード３ */
     htnpkkn3 ,         /* 不担保期間３ */
     htnpbuicd4 ,         /* 不担保部位コード４ */
     htnpkkn4 ,         /* 不担保期間４ */
     tokkoudosghtnpkbn ,         /* 特定高度障害不担保区分 */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM HT_Tokujyou_Z;