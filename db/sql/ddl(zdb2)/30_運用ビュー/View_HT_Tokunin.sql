CREATE VIEW HT_Tokunin AS SELECT
     mosno ,         /* 申込番号 */
     spgndtknkbn ,         /* ＳＰ限度特認区分 */
     nenkkntknkbn ,         /* 年齢期間特認区分 */
     tsngndtknkbn ,         /* 通算限度特認区分 */
     sentakuinfotknkbn ,         /* 選択情報特認区分 */
     syorisimetknkbn ,         /* 処理締切日特認区分 */
     kzmeigitknkbn ,         /* 口座名義人特認区分 */
     massitknkbn ,         /* 末子特認区分 */
     kakoymdkyytknkbn ,         /* 過去日付許容特認区分 */
     saiteiptknkbn ,         /* 最低P特認区分 */
     yoteiriritutknkbn ,         /* 予定利率特認区分 */
     nenreiuptknkbn ,         /* 年齢アップ特認区分 */
     signalkaihikbn ,         /* シグナル回避区分 */
     ikkatuyouptknkbn ,         /* 一括要Ｐ特認区分 */
     sonotatknkbn ,         /* その他特認区分 */
     ketsyacd ,         /* 決定者コード */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM HT_Tokunin_Z;