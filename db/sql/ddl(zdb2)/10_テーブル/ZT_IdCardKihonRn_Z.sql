CREATE TABLE ZT_IdCardKihonRn_Z (
     zrnidkbn                                           CHAR        (2)                                                       NOT NULL  ,  /* （連携用）ＩＤ区分 */
     zrnidcd                                            CHAR        (6)                                                       NOT NULL  ,  /* （連携用）ＩＤコード */
     zrnyobiv8                                          CHAR        (8)                                                       NOT NULL  ,  /* （連携用）予備項目Ｖ８ */
     zrnyobiv10                                         CHAR        (10)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ１０ */
     zrntanmatusiyoukbn                                 CHAR        (1)                                                       NOT NULL  ,  /* （連携用）端末使用区分 */
     zrnaccesskbn                                       CHAR        (1)                                                       NOT NULL  ,  /* （連携用）アクセス区分 */
     zrnidnyuuryokusyanm                                CHAR        (18)                                                      NOT NULL  ,  /* （連携用）ＩＤ入力者名 */
     zrnkanjiidnyuuryokusyanm                           GRAPHIC     (10)                                                      NOT NULL  ,  /* （連携用）漢字ＩＤ入力者名 */
     zrnidnyuuryokusyaseiymd                            CHAR        (8)                                                       NOT NULL  ,  /* （連携用）ＩＤ入力者生年月日 */
     zrnidnyuuryokusyanyuusyaymd                        CHAR        (8)                                                       NOT NULL  ,  /* （連携用）ＩＤ入力者入社年月日 */
     zrnsyozokusosikicd                                 CHAR        (7)                                                       NOT NULL  ,  /* （連携用）所属組織コード */
     zrnsyozokusisyacd                                  CHAR        (3)                                                       NOT NULL  ,  /* （連携用）所属支社コード */
     zrnsyozokusibucd                                   CHAR        (3)                                                       NOT NULL  ,  /* （連携用）所属支部コード */
     zrnidnyuuryokusyasikakucd                          CHAR        (5)                                                       NOT NULL  ,  /* （連携用）ＩＤ入力者資格コード */
     zrnyobiv2                                          CHAR        (2)                                                       NOT NULL  ,  /* （連携用）予備項目Ｖ２ */
     zrnidsdpsouhuhyouji                                CHAR        (1)                                                       NOT NULL  ,  /* （連携用）ＩＤＳＤＰ送付表示 */
     zrnyobiv1                                          CHAR        (1)                                                       NOT NULL  ,  /* （連携用）予備項目Ｖ１ */
     zrnyobiv1x2                                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）予備項目Ｖ１＿２ */
     zrnyobiv1x3                                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）予備項目Ｖ１＿３ */
     zrnyobiv2x2                                        CHAR        (2)                                                       NOT NULL  ,  /* （連携用）予備項目Ｖ２＿２ */
     zrnyobiv2x3                                        CHAR        (2)                                                       NOT NULL  ,  /* （連携用）予備項目Ｖ２＿３ */
     zrnyobiv26                                         CHAR        (26)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ２６ */
     zrnyobiv8x2                                        CHAR        (8)                                                       NOT NULL  ,  /* （連携用）予備項目Ｖ８＿２ */
     zrnidcardsaisyuukousinymd                          CHAR        (8)                                                       NOT NULL  ,  /* （連携用）ＩＤカード最終更新年月日 */
     zrnidcardmukouymd                                  CHAR        (8)                                                       NOT NULL  ,  /* （連携用）ＩＤカード無効年月日 */
     zrnkaikeitantousyakbn                              CHAR        (2)                                                       NOT NULL  ,  /* （連携用）会計担当者区分 */
     zrnsyanaiyokintantousyakbn                         CHAR        (2)                                                       NOT NULL  ,  /* （連携用）社内預金担当者区分 */
     zrnjinjimynosyoukaihyj                             CHAR        (1)                                                       NOT NULL  ,  /* （連携用）人事・マイナンバー照会可能表示 */
     zrneisyokumynosyoukaihyj                           CHAR        (1)                                                       NOT NULL  ,  /* （連携用）営職・マイナンバー照会可能表示 */
     zrnhudousanmynosyoukaihyj                          CHAR        (1)                                                       NOT NULL  ,  /* （連携用）不動産・マイナンバー照会可能表示 */
     zrnkohomynosyoukaihyj                              CHAR        (1)                                                       NOT NULL  ,  /* （連携用）個保・マイナンバー照会可能表示 */
     zrnkihomynosyoukaihyj                              CHAR        (1)                                                       NOT NULL  ,  /* （連携用）企保・マイナンバー照会可能表示 */
     zrnkikantantoukbn                                  CHAR        (1)                                                       NOT NULL  ,  /* （連携用）機関担当区分 */
     zrnyobiv32                                         CHAR        (32)                                                      NOT NULL     /* （連携用）予備項目Ｖ３２ */
)
;

ALTER TABLE ZT_IdCardKihonRn_Z ADD CONSTRAINT PK_IdCardKihonRn PRIMARY KEY (
     zrnidkbn                                                 , /* （連携用）ＩＤ区分 */
     zrnidcd                                                    /* （連携用）ＩＤコード */
) ;
