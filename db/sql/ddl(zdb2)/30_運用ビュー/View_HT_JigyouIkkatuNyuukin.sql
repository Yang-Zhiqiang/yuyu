CREATE VIEW HT_JigyouIkkatuNyuukin AS SELECT
     daimosno ,         /* 代表申込番号 */
     renno ,         /* 連番 */
     soukinymd ,         /* 送金日 */
     soukincd ,         /* 送金コード */
     rsgaku ,         /* 領収金額 */
     rsgaku$ ,         /* 領収金額(通貨型) */
     ryosyuymd ,         /* 領収日 */
     rssyouno ,         /* 領収証番号 */
     zenhnknkbn ,         /* 全額返金区分 */
     srgonyknumu ,         /* 成立後入金有無 */
     jyuutouym ,         /* 充当年月 */
     krkno ,         /* 仮受番号 */
     dntcd ,         /* 団体コード */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM HT_JigyouIkkatuNyuukin_Z;