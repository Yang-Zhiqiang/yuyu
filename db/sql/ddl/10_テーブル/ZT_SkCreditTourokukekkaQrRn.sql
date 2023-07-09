CREATE TABLE ZT_SkCreditTourokukekkaQrRn (
     zrnrecordkbn                                       CHAR        (1)                                                       NOT NULL  ,  /* （連携用）レコード区分 */
     zrnsystemjyusinymd                                 CHAR        (8)                                                       NOT NULL  ,  /* （連携用）システム受信日 */
     zrnsystemjyusintime                                CHAR        (6)                                                       NOT NULL  ,  /* （連携用）システム受信時刻 */
     zrncreditqrtrkkbn                                  CHAR        (1)                                                       NOT NULL  ,  /* （連携用）クレジットカードＱＲ登録区分 */
     zrncreditqrsousinkbn                               CHAR        (1)                                                       NOT NULL  ,  /* （連携用）クレジットカードＱＲ送信区分 */
     zrncreditkessaiyouno                               CHAR        (26)                                                      NOT NULL  ,  /* （連携用）クレジットカード決済用番号 */
     zrnyobiv34                                         CHAR        (34)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ３４ */
     zrncreditkaiinno                                   CHAR        (16)                                                      NOT NULL  ,  /* （連携用）クレジット会員番号 */
     zrncardyuukoukigen                                 CHAR        (4)                                                       NOT NULL  ,  /* （連携用）カード有効期限 */
     zrnauthorigkjyusin                                 CHAR        (7)                                                       NOT NULL  ,  /* （連携用）オーソリ金額（受信） */
     zrnyobiv153                                        CHAR        (153)                                                     NOT NULL  ,  /* （連携用）予備項目Ｖ１５３ */
     zrntyuumonno                                       CHAR        (50)                                                      NOT NULL  ,  /* （連携用）注文番号 */
     zrnyobiv50                                         CHAR        (50)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ５０ */
     zrnbluegateshopid                                  CHAR        (16)                                                      NOT NULL  ,  /* （連携用）ＢｌｕｅＧａｔｅショップＩＤ */
     zrnyobiv81                                         CHAR        (81)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ８１ */
     zrnkessaisyoriymd                                  CHAR        (8)                                                       NOT NULL  ,  /* （連携用）決済処理日 */
     zrnyobiv24                                         CHAR        (24)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ２４ */
     zrncreditqrerrorcd                                 CHAR        (14)                                                      NOT NULL  ,  /* （連携用）クレジットカードＱＲエラーコード */
     zrnsyouninno7keta                                  CHAR        (7)                                                       NOT NULL  ,  /* （連携用）承認番号（７桁） */
     zrnbluegateerrorcd                                 CHAR        (8)                                                       NOT NULL  ,  /* （連携用）ＢｌｕｅＧａｔｅエラーコード */
     zrnhisimukekaisyacd                                CHAR        (11)                                                      NOT NULL  ,  /* （連携用）被仕向会社コード */
     zrnbluegatejyusinymdtime                           CHAR        (14)                                                      NOT NULL  ,  /* （連携用）ＢｌｕｅＧａｔｅ受付日時 */
     zrnyobiv160                                        CHAR        (160)                                                     NOT NULL     /* （連携用）予備項目Ｖ１６０ */
)
;

ALTER TABLE ZT_SkCreditTourokukekkaQrRn ADD CONSTRAINT PK_SkCreditTourokukekkaQrRn PRIMARY KEY (
     zrnsystemjyusinymd                                       , /* （連携用）システム受信日 */
     zrnsystemjyusintime                                      , /* （連携用）システム受信時刻 */
     zrncreditkessaiyouno                                       /* （連携用）クレジットカード決済用番号 */
) ;
