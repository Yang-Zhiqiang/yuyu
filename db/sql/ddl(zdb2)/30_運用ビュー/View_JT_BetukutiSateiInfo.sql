CREATE VIEW JT_BetukutiSateiInfo AS SELECT
     skno ,         /* 請求番号 */
     syono ,         /* 証券番号 */
     seikyuurirekino ,         /* 請求履歴番号 */
     betusibouumukbn ,         /* 別口死亡有無区分 */
     betusiboucomment ,         /* 別口死亡コメント */
     betukdsgumukbn ,         /* 別口高度障害有無区分 */
     betukdsgcomment ,         /* 別口高度障害コメント */
     betusoukiumukbn ,         /* 別口早期有無区分 */
     betusoukicomment ,         /* 別口早期コメント */
     betusymtkykumukbn ,         /* 別口消滅契約有無区分 */
     betusymtkykcomment ,         /* 別口消滅契約コメント */
     kossyoricd ,         /* 更新処理コード */
     kossyorisscd ,         /* 更新処理詳細コード */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM JT_BetukutiSateiInfo_Z;