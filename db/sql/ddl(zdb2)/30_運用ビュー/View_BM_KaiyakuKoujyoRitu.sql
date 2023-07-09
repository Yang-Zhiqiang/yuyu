CREATE VIEW BM_KaiyakuKoujyoRitu AS SELECT
     syouhncd ,         /* 商品コード */
     ryouritusdno ,         /* 料率世代番号 */
     kaiyakukjtkybr1 ,         /* 解約控除適用分類１ */
     kaiyakukjtkybr2 ,         /* 解約控除適用分類２ */
     keikanensuu ,         /* 経過年数 */
     kaiyakukoujyoritu ,         /* 解約控除率 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_KaiyakuKoujyoRitu_Z;