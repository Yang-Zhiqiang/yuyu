CREATE TABLE ZT_AuthoriKekkaTr (
     ztrrecordkbn                                       VARCHAR     (1)                                                                 ,  /* （取込用）レコード区分 */
     ztrkaiintourokukbn                                 VARCHAR     (1)                                                                 ,  /* （取込用）会員登録区分 */
     ztrcreditkessaiyouno                               VARCHAR     (26)                                                      NOT NULL  ,  /* （取込用）クレジットカード決済用番号 */
     ztryobiv34                                         VARCHAR     (34)                                                                ,  /* （取込用）予備項目Ｖ３４ */
     ztrcardno                                          VARCHAR     (16)                                                                ,  /* （取込用）カード番号 */
     ztrcardyuukoukigen                                 VARCHAR     (4)                                                                 ,  /* （取込用）カード有効期限 */
     ztrauthorigkjyusin                                 VARCHAR     (7)                                                                 ,  /* （取込用）オーソリ金額（受信） */
     ztrauthorikekkaerrorcd                             VARCHAR     (14)                                                                ,  /* （取込用）オーソリ結果エラーコード */
     ztrbluegateerrorcd                                 VARCHAR     (8)                                                                 ,  /* （取込用）ＢｌｕｅＧａｔｅエラーコード */
     ztryobiv25                                         VARCHAR     (25)                                                                ,  /* （取込用）予備項目Ｖ２５ */
     ztrhisimukekaisyacd                                VARCHAR     (11)                                                                ,  /* （取込用）被仕向会社コード */
     ztryobiv5                                          VARCHAR     (5)                                                                 ,  /* （取込用）予備項目Ｖ５ */
     ztrwentryuserid                                    VARCHAR     (8)                                                                 ,  /* （取込用）ＷエントリユーザＩＤ */
     ztrerrorcomment                                    VARCHAR     (40)                                                                ,  /* （取込用）エラーコメント */
     ztrniniinfo                                        VARCHAR     (40)                                                                ,  /* （取込用）任意情報 */
     ztrskjkssityuumonno                                VARCHAR     (9)                                                                 ,  /* （取込用）即時決済注文番号 */
     ztrskjkssiauthorigk                                VARCHAR     (7)                                                                 ,  /* （取込用）即時決済オーソリ金額 */
     ztrskjkssiyosinkekka                               VARCHAR     (3)                                                                 ,  /* （取込用）即時決済与信結果 */
     ztrskjkssibunruikbn                                VARCHAR     (1)                                                                 ,  /* （取込用）即時決済分類区分 */
     ztrdatasyorijyoukyou                               VARCHAR     (1)                                                                 ,  /* （取込用）データ処理状況 */
     ztrdatajyusinymd                                   VARCHAR     (14)                                                      NOT NULL  ,  /* （取込用）データ受信日 */
     ztryobiv25x2                                       VARCHAR     (25)                                                                ,  /* （取込用）予備項目Ｖ２５＿２ */
     ztrrenno7                                          VARCHAR     (7)                                                       NOT NULL  ,  /* （取込用）連番７桁 */
     ztryobiv33                                         VARCHAR     (33)                                                                ,  /* （取込用）予備項目Ｖ３３ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE ZT_AuthoriKekkaTr ADD CONSTRAINT PK_AuthoriKekkaTr PRIMARY KEY (
     ztrrenno7                                                , /* （取込用）連番７桁 */
     ztrcreditkessaiyouno                                     , /* （取込用）クレジットカード決済用番号 */
     ztrdatajyusinymd                                           /* （取込用）データ受信日 */
) ;
