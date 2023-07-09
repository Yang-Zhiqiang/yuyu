CREATE VIEW BM_PalSyoumetujiyuu AS SELECT
     palsyoumetucd ,         /* ＰＡＬ消滅コード */
     betukutikeiyakukbn ,         /* 別口契約区分 */
     syoumetujiyuuname ,         /* 消滅事由名称 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_PalSyoumetujiyuu_Z;