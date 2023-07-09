CREATE VIEW HT_KokutisyoVrf AS SELECT
     mosno ,         /* 申込番号 */
     kktymd ,         /* 告知日 */
     sintyou ,         /* 身長 */
     taijyuu ,         /* 体重 */
     kituenkbn ,         /* 喫煙区分 */
     kituenhon ,         /* 喫煙本数 */
     kijikbn ,         /* 記事区分 */
     kzkkijikbn ,         /* 家族記事区分 */
     hbcmnt ,         /* 不備コメント */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM HT_KokutisyoVrf_Z;