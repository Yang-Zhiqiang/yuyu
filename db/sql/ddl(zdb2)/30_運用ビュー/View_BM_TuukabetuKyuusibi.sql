CREATE VIEW BM_TuukabetuKyuusibi AS SELECT
     tuukatoriatukaiymd ,         /* 通貨取扱年月日 */
     kyuusijpykbn ,         /* 円休止区分 */
     kyuusiusdkbn ,         /* 米ドル休止区分 */
     kyuusieurkbn ,         /* ユーロ休止区分 */
     kyuusiaudkbn ,         /* 豪ドル休止区分 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_TuukabetuKyuusibi_Z;