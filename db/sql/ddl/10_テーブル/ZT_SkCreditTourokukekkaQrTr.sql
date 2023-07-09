CREATE TABLE ZT_SkCreditTourokukekkaQrTr (
     ztrrecordkbn                                       VARCHAR     (1)                                                                 ,  /* （取込用）レコード区分 */
     ztrsystemjyusinymd                                 VARCHAR     (8)                                                       NOT NULL  ,  /* （取込用）システム受信日 */
     ztrsystemjyusintime                                VARCHAR     (6)                                                       NOT NULL  ,  /* （取込用）システム受信時刻 */
     ztrcreditqrtrkkbn                                  VARCHAR     (1)                                                                 ,  /* （取込用）クレジットカードＱＲ登録区分 */
     ztrcreditqrsousinkbn                               VARCHAR     (1)                                                                 ,  /* （取込用）クレジットカードＱＲ送信区分 */
     ztrcreditkessaiyouno                               VARCHAR     (26)                                                      NOT NULL  ,  /* （取込用）クレジットカード決済用番号 */
     ztryobiv34                                         VARCHAR     (34)                                                                ,  /* （取込用）予備項目Ｖ３４ */
     ztrcreditkaiinno                                   VARCHAR     (16)                                                                ,  /* （取込用）クレジット会員番号 */
     ztrcardyuukoukigen                                 VARCHAR     (4)                                                                 ,  /* （取込用）カード有効期限 */
     ztrauthorigkjyusin                                 VARCHAR     (7)                                                                 ,  /* （取込用）オーソリ金額（受信） */
     ztryobiv153                                        VARCHAR     (153)                                                               ,  /* （取込用）予備項目Ｖ１５３ */
     ztrtyuumonno                                       VARCHAR     (50)                                                                ,  /* （取込用）注文番号 */
     ztryobiv50                                         VARCHAR     (50)                                                                ,  /* （取込用）予備項目Ｖ５０ */
     ztrbluegateshopid                                  VARCHAR     (16)                                                                ,  /* （取込用）ＢｌｕｅＧａｔｅショップＩＤ */
     ztryobiv81                                         VARCHAR     (81)                                                                ,  /* （取込用）予備項目Ｖ８１ */
     ztrkessaisyoriymd                                  VARCHAR     (8)                                                                 ,  /* （取込用）決済処理日 */
     ztryobiv24                                         VARCHAR     (24)                                                                ,  /* （取込用）予備項目Ｖ２４ */
     ztrcreditqrerrorcd                                 VARCHAR     (14)                                                                ,  /* （取込用）クレジットカードＱＲエラーコード */
     ztrsyouninno7keta                                  VARCHAR     (7)                                                                 ,  /* （取込用）承認番号（７桁） */
     ztrbluegateerrorcd                                 VARCHAR     (8)                                                                 ,  /* （取込用）ＢｌｕｅＧａｔｅエラーコード */
     ztrhisimukekaisyacd                                VARCHAR     (11)                                                                ,  /* （取込用）被仕向会社コード */
     ztrbluegatejyusinymdtime                           VARCHAR     (14)                                                                ,  /* （取込用）ＢｌｕｅＧａｔｅ受付日時 */
     ztryobiv160                                        VARCHAR     (160)                                                               ,  /* （取込用）予備項目Ｖ１６０ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE ZT_SkCreditTourokukekkaQrTr ADD CONSTRAINT PK_SkCreditTourokukekkaQrTr PRIMARY KEY (
     ztrsystemjyusinymd                                       , /* （取込用）システム受信日 */
     ztrsystemjyusintime                                      , /* （取込用）システム受信時刻 */
     ztrcreditkessaiyouno                                       /* （取込用）クレジットカード決済用番号 */
) ;
