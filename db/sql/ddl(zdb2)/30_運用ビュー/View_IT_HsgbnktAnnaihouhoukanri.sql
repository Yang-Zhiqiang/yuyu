CREATE VIEW IT_HsgbnktAnnaihouhoukanri AS SELECT
     kbnkey ,         /* 区分キー */
     syono ,         /* 証券番号 */
     hsgymd ,         /* 被災害年月日 */
     bnktannaihouhoukbn ,         /* 分割案内方法区分 */
     bnktannaikaisiymd ,         /* 分割案内開始日 */
     bnktannaiendymd ,         /* 分割案内終了日 */
     hsgtkbtymd1 ,         /* 被災害特別年月日１ */
     hsgtkbtymd2 ,         /* 被災害特別年月日２ */
     hsgtkbtkbn1 ,         /* 被災害特別区分１ */
     hsgtkbtkbn2 ,         /* 被災害特別区分２ */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IT_HsgbnktAnnaihouhoukanri_Z;