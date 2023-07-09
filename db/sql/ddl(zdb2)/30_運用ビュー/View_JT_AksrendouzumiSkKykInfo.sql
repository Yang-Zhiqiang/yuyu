CREATE VIEW JT_AksrendouzumiSkKykInfo AS SELECT
     skno ,         /* 請求番号 */
     syono ,         /* 証券番号 */
     seikyuusyubetu ,         /* 請求種別 */
     shrkekkakbn ,         /* 支払結果区分 */
     syoriYmd ,         /* 処理年月日 */
     sibouymd ,         /* 死亡日 */
     geninkbn ,         /* 原因区分 */
     syoruiimagerendousuu ,         /* 書類イメージ連動数 */
     ankenimgjygntyoukahyj ,         /* 案件イメージ上限数超過表示 */
     tiffhenkankekkakbn ,         /* ＴＩＦＦ変換結果区分 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM JT_AksrendouzumiSkKykInfo_Z;