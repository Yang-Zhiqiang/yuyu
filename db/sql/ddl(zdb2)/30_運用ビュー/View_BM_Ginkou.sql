CREATE VIEW BM_Ginkou AS SELECT
     bankcd ,         /* 銀行コード */
     sitencd ,         /* 支店コード */
     kousinymd ,         /* 更新年月日 */
     sinsetuymd ,         /* 新設年月日 */
     haisiymd ,         /* 廃止年月日 */
     banknmkn ,         /* 銀行名（カナ） */
     sitennmkn ,         /* 支店名（カナ） */
     banknmkj ,         /* 銀行名（漢字） */
     sitennmkj ,         /* 支店名（漢字） */
     banknmej ,         /* 銀行名（英字） */
     sitennmej ,         /* 支店名（英字） */
     csskyouteikaisiymd ,         /* ＣＳＳ協定開始年月日 */
     csskyouteikaijyoymd ,         /* ＣＳＳ協定解除年月日 */
     kokunaikwskameihyj ,         /* 内国為替制度加盟表示 */
     hrkmKanouihyj ,         /* 振込可能支店表示 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_Ginkou_Z;