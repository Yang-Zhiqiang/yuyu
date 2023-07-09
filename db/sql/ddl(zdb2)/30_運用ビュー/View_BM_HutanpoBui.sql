CREATE VIEW BM_HutanpoBui AS SELECT
     htnpbuicd ,         /* 不担保部位コード */
     htnpbuinm ,         /* 不担保部位名 */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_HutanpoBui_Z;