CREATE TABLE ZT_KykIdouHaneiKekkaRn_Z (
     zrnhuho2kyknokbn                                   CHAR        (1)                                                       NOT NULL  ,  /* （連携用）普保Ⅱ契約番号区分 */
     zrnhuho2kykno                                      CHAR        (11)                                                      NOT NULL  ,  /* （連携用）普保Ⅱ契約番号 */
     zrnkyknaiyouhaneierrkbn                            CHAR        (1)                                                       NOT NULL  ,  /* （連携用）契約内容反映エラー区分 */
     zrntsnkijyuntyoukahyj                              CHAR        (1)                                                       NOT NULL  ,  /* （連携用）通算基準超過表示 */
     zrnhhknnayosehumeihyj                              CHAR        (1)                                                       NOT NULL  ,  /* （連携用）被保険者名寄せ不明表示 */
     zrnkyknayosehumeihyj                               CHAR        (1)                                                       NOT NULL  ,  /* （連携用）契約者名寄せ不明表示 */
     zrnnkuktnayosehumeihyj                             CHAR        (1)                                                       NOT NULL  ,  /* （連携用）年金受取人名寄せ不明表示 */
     zrntjtidouhaneikekkayobi01                         CHAR        (33)                                                      NOT NULL     /* （連携用）当日異動内容反映結果予備０１ */
)
;

ALTER TABLE ZT_KykIdouHaneiKekkaRn_Z ADD CONSTRAINT PK_KykIdouHaneiKekkaRn PRIMARY KEY (
     zrnhuho2kyknokbn                                         , /* （連携用）普保Ⅱ契約番号区分 */
     zrnhuho2kykno                                              /* （連携用）普保Ⅱ契約番号 */
) ;
