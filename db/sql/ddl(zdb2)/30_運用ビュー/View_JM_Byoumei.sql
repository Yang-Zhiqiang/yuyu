CREATE VIEW JM_Byoumei AS SELECT
     byoumeitourokuno ,         /* 病名登録番号 */
     byoumeikj ,         /* 病名（漢字） */
     byoumeizenkaku ,         /* 病名全角 */
     byoumeikn ,         /* 病名（カナ） */
     byoumeiknkensaku ,         /* 病名（カナ）検索用 */
     byoumeicd ,         /* 病名コード */
     gaitoukbn1 ,         /* 該当区分１ */
     gaitoukbn2 ,         /* 該当区分２ */
     gaitoukbn3 ,         /* 該当区分３ */
     gaitoukbn4 ,         /* 該当区分４ */
     gaitoukbn5 ,         /* 該当区分５ */
     tyuuimongon ,         /* 注意文言 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM JM_Byoumei_Z;