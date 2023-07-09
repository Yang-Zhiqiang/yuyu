CREATE VIEW HT_Houjyou AS SELECT
     mosno ,         /* 申込番号 */
     syosaikbn ,         /* 初診再診区分 */
     sinsakbn ,         /* 診査区分 */
     kktymd ,         /* 告知日 */
     sintyou ,         /* 身長 */
     taijyuu ,         /* 体重 */
     kituenkbn ,         /* 喫煙区分 */
     kituenhon ,         /* 喫煙本数 */
     sinsaicd ,         /* 診査医コード */
     sinsaymd ,         /* 診査日 */
     sinsatime ,         /* 診査時刻 */
     takuoukbn ,         /* 宅診往診区分 */
     sinsabakbn ,         /* 診査場所区分 */
     hbcmnt ,         /* 不備コメント */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM HT_Houjyou_Z;