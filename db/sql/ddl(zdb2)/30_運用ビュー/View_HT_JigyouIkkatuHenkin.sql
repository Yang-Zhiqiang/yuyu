CREATE VIEW HT_JigyouIkkatuHenkin AS SELECT
     daimosno ,         /* 代表申込番号 */
     renno ,         /* 連番 */
     hnkngk ,         /* 返金額 */
     hnkngk$ ,         /* 返金額(通貨型) */
     hnknhoukbn ,         /* 返金方法区分 */
     hnknymd ,         /* 返金日 */
     bankcd ,         /* 銀行コード */
     sitencd ,         /* 支店コード */
     yokinkbn ,         /* 預金種目区分 */
     kouzano ,         /* 口座番号 */
     kzmeiginmkn ,         /* 口座名義人氏名（カナ） */
     srgohnknumu ,         /* 成立後返金有無 */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM HT_JigyouIkkatuHenkin_Z;