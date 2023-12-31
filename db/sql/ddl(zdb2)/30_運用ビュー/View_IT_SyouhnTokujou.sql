CREATE VIEW IT_SyouhnTokujou AS SELECT
     kbnkey ,         /* 区分キー */
     syono ,         /* 証券番号 */
     syutkkbn ,         /* 主契約特約区分 */
     syouhncd ,         /* 商品コード */
     syouhnsdno ,         /* 商品世代番号 */
     kyksyouhnrenno ,         /* 契約商品連番 */
     henkousikibetukey ,         /* 変更識別キー */
     tkjyhyouten ,         /* 特条標点 */
     tkjyp ,         /* 特条保険料 */
     tkjyp$ ,         /* 特条保険料(通貨型) */
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
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IT_SyouhnTokujou_Z;