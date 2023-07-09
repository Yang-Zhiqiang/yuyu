CREATE VIEW JT_SateiIppanHanteiInfo AS SELECT
     skno ,         /* 請求番号 */
     syono ,         /* 証券番号 */
     seikyuurirekino ,         /* 請求履歴番号 */
     ippanhanteitensuu1 ,         /* 一般判定点数１ */
     ippanhanteicomment1 ,         /* 一般判定コメント１ */
     ippanhanteitensuu2 ,         /* 一般判定点数２ */
     ippanhanteicomment2 ,         /* 一般判定コメント２ */
     ippanhanteitensuu3 ,         /* 一般判定点数３ */
     ippanhanteicomment3 ,         /* 一般判定コメント３ */
     ippanhanteitensuu4 ,         /* 一般判定点数４ */
     ippanhanteicomment4 ,         /* 一般判定コメント４ */
     ippanhanteitensuu5 ,         /* 一般判定点数５ */
     ippanhanteicomment5 ,         /* 一般判定コメント５ */
     ippanhanteitensuu6 ,         /* 一般判定点数６ */
     ippanhanteicomment6 ,         /* 一般判定コメント６ */
     ippanhanteitensuugoukei ,         /* 一般判定点数合計 */
     ippanhanteigoukeicomment ,         /* 一般判定合計コメント */
     kossyoricd ,         /* 更新処理コード */
     kossyorisscd ,         /* 更新処理詳細コード */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM JT_SateiIppanHanteiInfo_Z;