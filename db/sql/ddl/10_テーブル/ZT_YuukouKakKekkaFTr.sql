CREATE TABLE ZT_YuukouKakKekkaFTr (
     ztrrecordkbn                                       VARCHAR     (1)                                                                 ,  /* （取込用）レコード区分 */
     ztryobiv1                                          VARCHAR     (1)                                                                 ,  /* （取込用）予備項目Ｖ１ */
     ztrcreditkessaiyouno                               VARCHAR     (26)                                                      NOT NULL  ,  /* （取込用）クレジットカード決済用番号 */
     ztrdbkeykugirimoji1                                VARCHAR     (1)                                                                 ,  /* （取込用）ＤＢキー区切り文字１ */
     ztrdbkeykugirimoji2                                VARCHAR     (1)                                                                 ,  /* （取込用）ＤＢキー区切り文字２ */
     ztryobiv32                                         VARCHAR     (32)                                                                ,  /* （取込用）予備項目Ｖ３２ */
     ztrcardno                                          VARCHAR     (16)                                                                ,  /* （取込用）カード番号 */
     ztrcardyuukoukigen                                 VARCHAR     (4)                                                                 ,  /* （取込用）カード有効期限 */
     ztryuukouhanteikekka                               VARCHAR     (1)                                                                 ,  /* （取込用）有効性判定結果 */
     ztryobiv59                                         VARCHAR     (59)                                                                ,  /* （取込用）予備項目Ｖ５９ */
     ztrcreditkigyoucd                                  VARCHAR     (5)                                                                 ,  /* （取込用）クレジット企業コード */
     ztryobiv53                                         VARCHAR     (53)                                                                ,  /* （取込用）予備項目Ｖ５３ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE ZT_YuukouKakKekkaFTr ADD CONSTRAINT PK_YuukouKakKekkaFTr PRIMARY KEY (
     ztrcreditkessaiyouno                                       /* （取込用）クレジットカード決済用番号 */
) ;
