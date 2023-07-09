CREATE VIEW BM_TokujyouSakugenRate AS SELECT
     syouhncd ,         /* 商品コード */
     syouhnsdno ,         /* 商品世代番号 */
     tkjyskgnkkn ,         /* 特条削減期間 */
     dai1hknnndskgnsrate ,         /* 第１保険年度削減支払割合 */
     dai2hknnndskgnsrate ,         /* 第２保険年度削減支払割合 */
     dai3hknnndskgnsrate ,         /* 第３保険年度削減支払割合 */
     dai4hknnndskgnsrate ,         /* 第４保険年度削減支払割合 */
     dai5hknnndskgnsrate ,         /* 第５保険年度削減支払割合 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_TokujyouSakugenRate_Z;