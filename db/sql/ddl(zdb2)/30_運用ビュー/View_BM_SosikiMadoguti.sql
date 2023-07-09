CREATE VIEW BM_SosikiMadoguti AS SELECT
     sskmdsosikicd ,         /* 組織窓口用組織コード */
     sskmdhassoukbn ,         /* 組織窓口用発送区分 */
     sskmdkanjisosikinm ,         /* 組織窓口用漢字組織名 */
     sskmdkanjisosikiadr1 ,         /* 組織窓口用漢字組織住所１ */
     sskmdkanjisosikiadr2 ,         /* 組織窓口用漢字組織住所２ */
     sskmdkanjisosikiadr3 ,         /* 組織窓口用漢字組織住所３ */
     sskmdpostalcd ,         /* 組織窓口用郵便番号 */
     sskmdtelno ,         /* 組織窓口用電話番号 */
     sskmdfaxno ,         /* 組織窓口用ＦＡＸ番号 */
     sskmdsisyaharaidasikznm ,         /* 組織窓口用支社払出口座名 */
     sskmdkouzanocd ,         /* 組織窓口用口座番号ＣＤ */
     sskmdsisyaharaidasikouzano ,         /* 組織窓口用支社払出口座番号 */
     sskmdsosikikbnnm ,         /* 組織窓口用組織区分名 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_SosikiMadoguti_Z;