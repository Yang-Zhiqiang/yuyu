CREATE TABLE ZT_NyknmeisaiRn_Z (
     zrndatakbn1                                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）データ区分１ */
     zrnsyubetucd                                       CHAR        (2)                                                       NOT NULL  ,  /* （連携用）種別コード */
     zrncdkbn                                           CHAR        (1)                                                       NOT NULL  ,  /* （連携用）コード区分 */
     zrnsakuseiymd6keta                                 CHAR        (6)                                                       NOT NULL  ,  /* （連携用）作成日６桁 */
     zrnknjyymdfrom6keta                                CHAR        (6)                                                       NOT NULL  ,  /* （連携用）勘定日（自）６桁 */
     zrnknjyymdto6keta                                  CHAR        (6)                                                       NOT NULL  ,  /* （連携用）勘定日（至）６桁 */
     zrnbankcd                                          CHAR        (4)                                                       NOT NULL  ,  /* （連携用）銀行番号 */
     zrnbanknmkn                                        CHAR        (15)                                                      NOT NULL  ,  /* （連携用）銀行名（カナ） */
     zrnshitencd                                        CHAR        (3)                                                       NOT NULL  ,  /* （連携用）支店番号 */
     zrnsitennmkn                                       CHAR        (15)                                                      NOT NULL  ,  /* （連携用）支店名（カナ） */
     zrnyobiv3                                          CHAR        (3)                                                       NOT NULL  ,  /* （連携用）予備項目Ｖ３ */
     zrnyokinkbn                                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）預金種目区分 */
     zrnkouzano                                         CHAR        (10)                                                      NOT NULL  ,  /* （連携用）口座番号 */
     zrnkznmkn                                          CHAR        (40)                                                      NOT NULL  ,  /* （連携用）口座名（カナ） */
     zrnkasikosikbn                                     CHAR        (1)                                                       NOT NULL  ,  /* （連携用）貸越区分 */
     zrntuutyousysykbn                                  CHAR        (1)                                                       NOT NULL  ,  /* （連携用）通帳・証書区分 */
     zrntrhkmaezndk                                     CHAR        (14)                                                      NOT NULL  ,  /* （連携用）取引前残高 */
     zrnyobiv63                                         CHAR        (63)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ６３ */
     zrnrenno8                                          CHAR        (8)                                                       NOT NULL  ,  /* （連携用）連番８桁 */
     zrndatakbn2                                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）データ区分２ */
     zrnsyoukaino                                       CHAR        (8)                                                       NOT NULL  ,  /* （連携用）照会番号 */
     zrnknjyymd6keta                                    CHAR        (6)                                                       NOT NULL  ,  /* （連携用）勘定日６桁 */
     zrnazkrhrdsymd6keta                                CHAR        (6)                                                       NOT NULL  ,  /* （連携用）預入・払出日６桁 */
     zrniribaraikbn                                     CHAR        (1)                                                       NOT NULL  ,  /* （連携用）入払区分 */
     zrntrhkkbn                                         CHAR        (2)                                                       NOT NULL  ,  /* （連携用）取引区分 */
     zrntrhkgk                                          CHAR        (12)                                                      NOT NULL  ,  /* （連携用）取引金額 */
     zrntatenkengk                                      CHAR        (12)                                                      NOT NULL  ,  /* （連携用）うち他店券金額 */
     zrnkknteijiymd6keta                                CHAR        (6)                                                       NOT NULL  ,  /* （連携用）交換呈示日６桁 */
     zrnhwtrhnknymd6keta                                CHAR        (6)                                                       NOT NULL  ,  /* （連携用）不渡返還日６桁 */
     zrntgtkgtkbn                                       CHAR        (1)                                                       NOT NULL  ,  /* （連携用）手形・小切手区分 */
     zrntgtkgtno                                        CHAR        (7)                                                       NOT NULL  ,  /* （連携用）手形・小切手番号 */
     zrnryoutenno                                       CHAR        (3)                                                       NOT NULL  ,  /* （連携用）僚店番号 */
     zrnhrkmirnincd                                     CHAR        (10)                                                      NOT NULL  ,  /* （連携用）振込依頼人コード */
     zrnhrkmirninnm                                     CHAR        (48)                                                      NOT NULL  ,  /* （連携用）振込依頼人名 */
     zrnsimukebanknmkn                                  CHAR        (15)                                                      NOT NULL  ,  /* （連携用）仕向銀行名 */
     zrnsimuketennmkn                                   CHAR        (15)                                                      NOT NULL  ,  /* （連携用）仕向店名 */
     zrntekiyounaiyou                                   CHAR        (20)                                                      NOT NULL  ,  /* （連携用）摘要内容 */
     zrnediinfo                                         CHAR        (20)                                                      NOT NULL  ,  /* （連携用）EDI情報 */
     zrnyobiv1                                          CHAR        (1)                                                       NOT NULL     /* （連携用）予備項目Ｖ１ */
)
;

ALTER TABLE ZT_NyknmeisaiRn_Z ADD CONSTRAINT PK_NyknmeisaiRn PRIMARY KEY (
     zrnsakuseiymd6keta                                       , /* （連携用）作成日６桁 */
     zrnbankcd                                                , /* （連携用）銀行番号 */
     zrnshitencd                                              , /* （連携用）支店番号 */
     zrnyokinkbn                                              , /* （連携用）預金種目区分 */
     zrnkouzano                                               , /* （連携用）口座番号 */
     zrnsyoukaino                                             , /* （連携用）照会番号 */
     zrnrenno8                                                  /* （連携用）連番８桁 */
) ;
