CREATE VIEW BM_KawaseRate AS SELECT
     kwsratekjymd ,         /* 為替レート基準日 */
     kwsrendoukbn ,         /* 為替レート連動区分 */
     mototuuka ,         /* 元通貨 */
     kanzantuuka ,         /* 換算通貨 */
     kawasetekiyokbn ,         /* 為替適用区分 */
     kawasetsrykbn ,         /* 為替手数料区分 */
     kawaserate ,         /* 為替レート */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_KawaseRate_Z;