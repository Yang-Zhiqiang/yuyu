CREATE VIEW BM_Bosyuunin AS SELECT
     bosyuucd ,         /* 募集人コード */
     bosyuunm ,         /* 募集人名 */
     kanjibosyuuninnm ,         /* 漢字募集人名 */
     itakuymd ,         /* 委託年月日 */
     dairiten1cd ,         /* 代理店コード（１） */
     dairiten2cd ,         /* 代理店コード（２） */
     dairiten3cd ,         /* 代理店コード（３） */
     dairitenkanrisosikicd1 ,         /* 代理店管理組織コード（１） */
     dairitenkanrisosikicd2 ,         /* 代理店管理組織コード（２） */
     dairitenkanrisosikicd3 ,         /* 代理店管理組織コード（３） */
     bosyuukbn ,         /* 募集人区分 */
     bosyuunintourokuymd ,         /* 募集人登録年月日 */
     bosyuukahikbn ,         /* 募集可否区分 */
     bosyuuningyouhaiymd ,         /* 募集人業廃年月日 */
     hngkhknskktrkymd ,         /* 変額保険資格登録年月日 */
     hngkhknskktrkmsuymd ,         /* 変額保険資格登録抹消年月日 */
     bosyuuseiymd ,         /* 募集人生年月日 */
     itakukaiyakuymd ,         /* 委託解約年月日 */
     daibosyuucd ,         /* 代表募集人コード */
     bosyuutrkno ,         /* 募集人登録番号 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_Bosyuunin_Z;