CREATE TABLE ZT_AuthoriKekkaRn (
     zrnrecordkbn                                       CHAR        (1)                                                       NOT NULL  ,  /* （連携用）レコード区分 */
     zrnkaiintourokukbn                                 CHAR        (1)                                                       NOT NULL  ,  /* （連携用）会員登録区分 */
     zrncreditkessaiyouno                               CHAR        (26)                                                      NOT NULL  ,  /* （連携用）クレジットカード決済用番号 */
     zrnyobiv34                                         CHAR        (34)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ３４ */
     zrncardno                                          CHAR        (16)                                                      NOT NULL  ,  /* （連携用）カード番号 */
     zrncardyuukoukigen                                 CHAR        (4)                                                       NOT NULL  ,  /* （連携用）カード有効期限 */
     zrnauthorigkjyusin                                 CHAR        (7)                                                       NOT NULL  ,  /* （連携用）オーソリ金額（受信） */
     zrnauthorikekkaerrorcd                             CHAR        (14)                                                      NOT NULL  ,  /* （連携用）オーソリ結果エラーコード */
     zrnbluegateerrorcd                                 CHAR        (8)                                                       NOT NULL  ,  /* （連携用）ＢｌｕｅＧａｔｅエラーコード */
     zrnyobiv25                                         CHAR        (25)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ２５ */
     zrnhisimukekaisyacd                                CHAR        (11)                                                      NOT NULL  ,  /* （連携用）被仕向会社コード */
     zrnyobiv5                                          CHAR        (5)                                                       NOT NULL  ,  /* （連携用）予備項目Ｖ５ */
     zrnwentryuserid                                    CHAR        (8)                                                       NOT NULL  ,  /* （連携用）ＷエントリユーザＩＤ */
     zrnerrorcomment                                    CHAR        (40)                                                      NOT NULL  ,  /* （連携用）エラーコメント */
     zrnniniinfo                                        CHAR        (40)                                                      NOT NULL  ,  /* （連携用）任意情報 */
     zrnskjkssityuumonno                                CHAR        (9)                                                       NOT NULL  ,  /* （連携用）即時決済注文番号 */
     zrnskjkssiauthorigk                                CHAR        (7)                                                       NOT NULL  ,  /* （連携用）即時決済オーソリ金額 */
     zrnskjkssiyosinkekka                               CHAR        (3)                                                       NOT NULL  ,  /* （連携用）即時決済与信結果 */
     zrnskjkssibunruikbn                                CHAR        (1)                                                       NOT NULL  ,  /* （連携用）即時決済分類区分 */
     zrndatasyorijyoukyou                               CHAR        (1)                                                       NOT NULL  ,  /* （連携用）データ処理状況 */
     zrndatajyusinymd                                   CHAR        (14)                                                      NOT NULL  ,  /* （連携用）データ受信日 */
     zrnyobiv25x2                                       CHAR        (25)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ２５＿２ */
     zrnrenno7                                          CHAR        (7)                                                       NOT NULL  ,  /* （連携用）連番７桁 */
     zrnyobiv33                                         CHAR        (33)                                                      NOT NULL     /* （連携用）予備項目Ｖ３３ */
)
;

ALTER TABLE ZT_AuthoriKekkaRn ADD CONSTRAINT PK_AuthoriKekkaRn PRIMARY KEY (
     zrnrenno7                                                , /* （連携用）連番７桁 */
     zrncreditkessaiyouno                                     , /* （連携用）クレジットカード決済用番号 */
     zrndatajyusinymd                                           /* （連携用）データ受信日 */
) ;
