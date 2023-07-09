CREATE VIEW HT_JigyouIkkatu AS SELECT
     daimosno ,         /* 代表申込番号 */
     mosnrkumu ,         /* 申込書入力有無 */
     kktnrkumu ,         /* 告知書入力有無 */
     hjynrkumu ,         /* 報状入力有無 */
     nyknnrkumu ,         /* 入金入力有無 */
     nyknwarinrkumu ,         /* 入金割当入力有無 */
     itijiketnrkumu ,         /* １次決定入力有無 */
     jiketteikbn ,         /* 事業一括決定状態区分 */
     jgyiktsrkbn ,         /* 事業一括成立区分 */
     jgyiktsrymd ,         /* 事業一括成立日 */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM HT_JigyouIkkatu_Z;