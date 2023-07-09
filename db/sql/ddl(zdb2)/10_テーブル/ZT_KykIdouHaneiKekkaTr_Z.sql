CREATE TABLE ZT_KykIdouHaneiKekkaTr_Z (
     ztrhuho2kyknokbn                                   VARCHAR     (1)                                                       NOT NULL  ,  /* （取込用）普保Ⅱ契約番号区分 */
     ztrhuho2kykno                                      VARCHAR     (11)                                                      NOT NULL  ,  /* （取込用）普保Ⅱ契約番号 */
     ztrkyknaiyouhaneierrkbn                            VARCHAR     (1)                                                                 ,  /* （取込用）契約内容反映エラー区分 */
     ztrtsnkijyuntyoukahyj                              VARCHAR     (1)                                                                 ,  /* （取込用）通算基準超過表示 */
     ztrhhknnayosehumeihyj                              VARCHAR     (1)                                                                 ,  /* （取込用）被保険者名寄せ不明表示 */
     ztrkyknayosehumeihyj                               VARCHAR     (1)                                                                 ,  /* （取込用）契約者名寄せ不明表示 */
     ztrnkuktnayosehumeihyj                             VARCHAR     (1)                                                                 ,  /* （取込用）年金受取人名寄せ不明表示 */
     ztrtjtidouhaneikekkayobi01                         VARCHAR     (33)                                                                ,  /* （取込用）当日異動内容反映結果予備０１ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE ZT_KykIdouHaneiKekkaTr_Z ADD CONSTRAINT PK_KykIdouHaneiKekkaTr PRIMARY KEY (
     ztrhuho2kyknokbn                                         , /* （取込用）普保Ⅱ契約番号区分 */
     ztrhuho2kykno                                              /* （取込用）普保Ⅱ契約番号 */
) ;
